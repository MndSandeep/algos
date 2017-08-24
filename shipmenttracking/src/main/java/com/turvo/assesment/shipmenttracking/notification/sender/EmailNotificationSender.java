package com.turvo.assesment.shipmenttracking.notification.sender;

import org.springframework.stereotype.Component;

import com.turvo.assesment.shipmenttracking.notification.Message;
import com.turvo.assesment.shipmenttracking.notification.NotificationSender;

@Component
public class EmailNotificationSender implements NotificationSender {

	@Override
	public int sendNotification(Message message) {
		return 0;
	}

}
