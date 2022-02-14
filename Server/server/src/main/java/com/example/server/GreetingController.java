package com.example.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


//==============================================================================
//                          Server's Db
//==============================================================================


@Controller
public class GreetingController {
    
    Square [] Squares = {
        new Square("#45858C", 0, 0),
        new Square("#A0D9D9", 0, 1),
        new Square("#D9C589", 0, 2),
        new Square("#BF9765", 0, 3),
        new Square("#D9B70D", 0, 4),
        new Square("#253C59", 0, 5),
        new Square("#8DC3F2", 0, 6),
        new Square("#BF1131", 0, 7),
        new Square("##F25E7A", 0, 8),
        new Square("#F28066", 0, 9),
        new Square("white", 0, 10)
    };



//==============================================================================
//                          WebSocket Server
//==============================================================================



    @MessageMapping("/hello")
    @SendTo("/topic/greetings")

    
    public Square [] Square(int message) throws Exception {
        System.out.println("=================== >Received: " + message);
        // Thread.sleep(1000); // simulated delay
        for(int i =0;i<Squares.length;i++){
            if(Squares[i].getId()==message)
            Squares[i].setVote(Squares[i].getVote()+1);
        }
        return this.Squares;
    }
}