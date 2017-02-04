package com.iot.mqtt;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.iot.service.ServiceProcess;
import com.iot.util.GetterSetter;
import com.iot.util.PropertiesFile;

public class MQTTPaho implements MqttCallback {
public static final PropertiesFile propsFileLoader = new PropertiesFile("IOT");
MqttClient client;

public MQTTPaho() {
}

/*public static void main(String[] args) {
    new PahoDemo().doDemo();
}*/
GetterSetter gs = new GetterSetter();
ServiceProcess sp = new ServiceProcess();
public boolean doPublish(String topic,String ClientId) {
    boolean result = false;
    MqttClient client;
	try {
       client = new MqttClient("tcp://"+propsFileLoader.getValue("PublicIP"),ClientId, new MemoryPersistence());
		//client = new MqttClient("tcp://broker.hivemq.com:1883", MqttClient.generateClientId(), new MemoryPersistence());
		client.connect();
        client.setCallback(this);
        System.out.println("TEST :"+topic);
        
        MqttMessage message = new MqttMessage();
        message.setPayload("1".getBytes());
        message.setRetained(true);
       
        // client.publish("parkslot"+topic,message);//("", message,1,false);
        client.publish(topic,message);
        result = true;
    } catch (MqttException e) {
        e.printStackTrace();
    }
	return result;
}

public boolean doUnPublish(String topic,String ClientId) {
    boolean result = false;
    MqttClient client;
	try {
       client = new MqttClient("tcp://"+propsFileLoader.getValue("PublicIP"),ClientId, new MemoryPersistence());
		//client = new MqttClient("tcp://broker.hivemq.com:1883", MqttClient.generateClientId(), new MemoryPersistence());
		client.connect();
        client.setCallback(this);
        //System.out.println("TEST :"+topic);
        
        MqttMessage message = new MqttMessage();
        message.setPayload("0".getBytes());
        message.setRetained(true);
       
         //client.publish("parkslot"+topic,message);//("", message,1,false);
        client.publish(topic,message);
        
        //result = sp.deleteEntry(topic);
        result = true;
    } catch (MqttException e) {
        e.printStackTrace();
    }
	return result;
}

/*public void doSubscribe() {
	MqttClient client;
	try {
    	while (true){
        client = new MqttClient("tcp://"+gs.getPublicIP(), MqttClient.generateClientId());
        client.connect();
        MqttMessage message = new MqttMessage();
        message.setPayload("2"
                .getBytes());
       String[] topicFilters ={"parkslot1","parkslot2","parkslot3","parkslot4","parkslot5","parkslot6"};
    		   int[] qos ={1,1,1,1,1,1};
    		   System.out.println(message.getQos());
       client.subscribe(topicFilters[0],1);
       client.subscribe(topicFilters[1],1);
       client.subscribe(topicFilters[2],1);
       client.subscribe(topicFilters[3],1);
       client.subscribe(topicFilters[4],1);
       client.subscribe(topicFilters[5],1);
       //client.close();
    	client.subscribe("#", 1);	   
       	
        client.setCallback(new MqttCallback() {
        	 
            public void connectionLost(Throwable cause) { //Called when the client lost the connection to the broker 
            }
 
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                String s = new String(message.getPayload());
            	System.out.println(topic + ": " + s);//Arrays.toString(message.getPayload()));
            	
             
            }
             public void deliveryComplete(IMqttDeliveryToken token) {//Called when a outgoing publish is complete 
            	 System.out.println("Outgoing Publish Complete "+token);
            }
        });
    	}
//client.connect();
//client.subscribe("#", 1);
       	} catch (MqttException e) {
        e.printStackTrace();
    }
   
}
*/

public void connectionLost(Throwable cause) {
    // TODO Auto-generated method stub

}

public void messageArrived(String topic, MqttMessage message)
        throws Exception {
 System.out.println(topic+" "+message);   
}

public void deliveryComplete(IMqttDeliveryToken token) {
    // TODO Auto-generated method stub

}

}