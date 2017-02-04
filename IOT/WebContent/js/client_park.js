        var slotv1;
		var slotv2;
		var slotv3;
		var slotv4;
		var slotv5;
		var slotv6;
		

function slot1(gtvalue1) {
if(gtvalue1==1)
{
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="red";
ctx.fillRect(40, 20, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Busy 1",80,80);
slotv1=1;
if(slotv1==1 && slotv2==1 && slotv3==1 && slotv4==1 && slotv5==1 && slotv4==1) 
		{
			alert("Parking Full");
		}
}
else if(gtvalue1==0)
{
slotv1=0;
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="green";
ctx.fillRect(40, 20, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Empty 1",75,80);

}
};

function slot2(gtvalue2) {
if(gtvalue2==1)
{
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="red";
ctx.fillRect(40, 140, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Busy 2",80,200);
slotv2=1;
}
else if(gtvalue2==0)
{
slotv2=0;
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="green";
ctx.fillRect(40, 140, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Empty 2",75,200);
}
	
};

function slot3(gtvalue3) {

if(gtvalue3==1)
{
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="red";
ctx.fillRect(40, 260, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Busy 3",80,320);
slotv3=1;
}
else if(gtvalue3==0)
{
slotv3=0;
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="green";
ctx.fillRect(40, 260, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Empty 3",75,320);
}	
};

function slot4(gtvalue4) {

if(gtvalue4==1)
{
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="red";
ctx.fillRect(240, 20, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Busy 4",280,80);
slotv4=1;
}
else if(gtvalue4==0)
{
slotv4=0;
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="green";
ctx.fillRect(240, 20, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Empty 4",275,80);
}	
};

function slot5(gtvalue5) {

if(gtvalue5==1)
{
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="red";
ctx.fillRect(240, 140, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Busy 5",280,200);
slotv5=1;
}
else if(gtvalue5==0)
{
slotv5=0;
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="green";
ctx.fillRect(240, 140, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Empty 5",275,200);
}	
};

function slot6(gtvalue6) {

if(gtvalue6==1)
{
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="red";
ctx.fillRect(240, 260, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Busy 6",280,320);
slotv6=1;
}
else if(gtvalue6==0)
{
slotv6=0;
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="green";
ctx.fillRect(240, 260, 150, 100);
ctx.fillStyle="yellow";
ctx.font = "30px Arial";
ctx.fillText("Empty 6",275,320);
}	
};

var ip = location.host;
var ip1 = ip.split(":"); 
var wsbroker = ip1[0];  //mqtt websocket enabled broker
//var wsbroker = "192.168.0.104";//"52.36.184.102";//"broker.hivemq.com";//"192.168.56.102";//"54.238.179.124";  //mqtt websocket enabled broker
var wsport = "8000";//"8083";//8000;//9001; // port for above

//var client = new Paho.MQTT.Client(wsbroker, wsport,"parksmart_station_Delta1");
var text = "";
var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

for( var i=0; i < 5; i++ )
    text += possible.charAt(Math.floor(Math.random() * possible.length));
 //alert(document.getElementById("clientname").value);
var client = new Paho.MQTT.Client(wsbroker, wsport,text);   
   client.onConnectionLost = function (responseObject) 
   {
     alert("connection lost: " + responseObject.errorMessage);
    };
   

   client.onMessageArrived = function (message)
   {

   //alert(message.destinationName+ +message.payloadString);
       var topic = message.destinationName;
	    
	   if(topic=="parkslot1")
	   {
		   slot1(message.payloadString);
	   }
	   if(topic=="parkslot2")
	   {
		   slot2(message.payloadString);
	   }
	   if(topic=="parkslot3")
	   {
		   slot3(message.payloadString);
	   }
	   if(topic=="parkslot4")
	   {
		   slot4(message.payloadString);
	   }	
	    if(topic=="parkslot5")
	   {
		   slot5(message.payloadString);
	   }
	   if(topic=="parkslot6")
	   {
		   slot6(message.payloadString);
	   }	  
   };
	 
   

   var options = 
   {
      timeout: 3,
      onSuccess: function () {
        //alert("mqtt connected");
        // Connection succeeded; subscribe to our topic, you can add multile lines of these
        client.subscribe('parkslot1', {qos: 1});
        client.subscribe('parkslot2', {qos: 1});
		client.subscribe('parkslot3', {qos: 1});
		client.subscribe('parkslot4', {qos: 1});
		client.subscribe('parkslot5', {qos: 1});
		client.subscribe('parkslot6', {qos: 1});
        //use the below if you want to publish to a topic on connect
        msgit();
      },
      onFailure: function (message) {
        alert("Connection failed: " + message.errorMessage);
      }
    };
	
  var init = function () {
      client.connect(options);
	
 }
  var msgit =function ()
  {
	  message = new Paho.MQTT.Message("Parking is Online");
        message.destinationName = "parking_control";
        client.send(message);

  };
