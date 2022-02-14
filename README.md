# intango-backend server
the backend websocket server of the intango web application

## in order to start running the server : clone the repository 
from there , start running the server . if you are using vsCode , you can simply press f5 on the ServerApplication.java
file , that is inside src-->main-->java-->com-->example-->server.


##once youre running , you will see this message pop up : 
![image](https://user-images.githubusercontent.com/80175752/153445247-9fbfb950-8bf2-4927-81a5-9dd145dc9b5f.png)

## and you will be able to start recieving requests
![image](https://user-images.githubusercontent.com/80175752/153445721-23532159-510b-4519-a35b-fb6b55962c54.png)

## in any case that you wish to open more instances of the same client , you need to add the following lines to <WebSocket.java>: 
'.setAllwedOrigins(http://localhost:<portNum>)'

![image](https://user-images.githubusercontent.com/80175752/153443170-8c5375e1-9b7a-4673-8c89-3a91b1b2b958.png)

## which is located at: 
![image](https://user-images.githubusercontent.com/80175752/153443184-21fcf18e-78bb-4a4d-b896-748fb90728db.png)


 ## disclaimer : currently the socket allowes only localhost origins from ports 4200 , 4201
