import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Test {

	public static void main(String[] args) {
		int[] data = { 1, 3, 3, 2,5 };
		List temp = new ArrayList<>();
		int totalPrice = data[data.length - 1];
		int min = data[data.length - 1];
		temp.add(data.length - 1);
		for (int i = data.length - 2; i >= 0; i--) {
			min = min(data,i);
			 if(min == -1){
				totalPrice += data[i];
				temp.add(i);
			}else if (data[i] > data[min])
				totalPrice += (data[i] - data[min]);
			
		}
		System.out.println(totalPrice);
		Collections.reverse(temp);
		temp.stream().forEach(i -> System.out.print(i + " "));
		System.out.println();
	}
	static int min(int[] data, int index) {
		int p = index;
		for (int i= index+1; i<data.length ; i++) {
			if(data[p] >= data[i]){
				return i;
			}
		}
		return -1;
	}

}
