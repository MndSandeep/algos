package com.turvo.assesment.shipmenttracking.notification.listener;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.turvo.assesment.shipmenttracking.enums.PreferenceType;
import com.turvo.assesment.shipmenttracking.enums.ShipmentStatus;
import com.turvo.assesment.shipmenttracking.exception.ShipmentTrackingApplicationException;
import com.turvo.assesment.shipmenttracking.model.Customer;
import com.turvo.assesment.shipmenttracking.notification.Message;
import com.turvo.assesment.shipmenttracking.notification.NotificationSender;
import com.turvo.assesment.shipmenttracking.notification.ShipmentStatusMessage;
import com.turvo.assesment.shipmenttracking.notification.factory.NotificationFactory;
import com.turvo.assesment.shipmenttracking.service.CustomerService;

@Component
public class ShipmentTrackingStatusListener {
	
	@Autowired 
	CustomerService customerService;
	
	NotificationSender notificationSender;

	@Autowired
	NotificationFactory notificationFactory;

	@JmsListener(destination = "shipmentStatusQueue", containerFactory = "myFactory")
    public void receiveMessage(ShipmentStatusMessage shipment) {
		try {
			Customer customer = customerService.getCustomer(shipment.getCustomerId());
			for(PreferenceType preference : customer.getChanelPreferenceList()) {
			notificationSender = notificationFactory.getNotificationSender(preference);
			Collection<ShipmentStatus> interestedEvents = customer.getSubscribeList();
			Optional<ShipmentStatus> intrestFound = interestedEvents.stream().filter(e -> e.equals(shipment.getShipmentStatus())).findAny();
			if(intrestFound.isPresent()) {
				Message message = new Message();
				message.setCustomerId(customer.getId());
				message.setEmail(customer.getEmail());
				message.setFrom("helpdesk@turvo.com");
				message.setMessageText("Status of your shipment changed to :"+ shipment.getShipmentStatus());
				notificationSender.sendNotification(message);
			}
			}
		} catch (ShipmentTrackingApplicationException e) {
			e.printStackTrace();
		}
    }
}
