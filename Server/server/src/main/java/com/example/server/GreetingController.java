package com.example.server;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


//==============================================================================
//                          Server's Db
//==============================================================================


@Controller
public class GreetingController {
    
    public ArrayList<Square> Squares;
    public String [] colors;
   

    public GreetingController()
    {
        colors = new String[]{"#45858C", "#A0D9D9", "#D9C589", "#BF9765", "#D9B70D", "#253C59", "#BF1131", "#F25E7A", "#F28066", "white"};
        Squares = new ArrayList<Square>();
        for (int i = 0; i < colors.length; i++)
            Squares.add(new Square(colors[i], 0, i));
        
    }



//==============================================================================
//                          WebSocket Server
//==============================================================================



    @MessageMapping("/hello")
    @SendTo("/topic/greetings")

    
    public Square [] Square(int message) throws Exception {
        System.out.println("=================== >Received: " + message);
        for(int i =0;i<Squares.size();i++){
            Square sq = Squares.get(i);
            if(sq.getId()==message)
                sq.setVote(sq.getVote()+1);
        }
        return toArray();
    }


    @MessageMapping("/newSquare")
    @SendTo("/topic/greetings")

    public Square [] newSquare(String newSquares) throws Exception {

        if(newSquares==null)
            return toArray();

        try{
            System.out.println(newSquares);
            JSONObject obj = new JSONObject(newSquares);
            JSONArray jsonArray = obj.getJSONArray("squares");
            // System.out.println("=================== >Received");
            // JSONArray jsonArray2 = new JSONArray(newSquares);
            System.out.println("=================== >Received2");
            for(int i =0;i<jsonArray.length();i++)
            {
                JSONObject curr = jsonArray.getJSONObject(i);
                Square sq = new Square(curr.getString("color"), curr.getInt("votes"), curr.getInt("id"));

                System.out.println(sq.toString());
                if(!Contains(sq.getId()))
                {
                    this.Squares.add(sq);
                }
                else
                {
                    System.out.println("Square already exists");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return toArray();
        }
        return toArray();

    }


    @MessageMapping("/EditSquare")
    @SendTo("/topic/greetings")

    public Square [] EditSquare(String EditSquare) throws Exception {
        
        if(EditSquare==null)
            return toArray();
        try
        {
            System.out.println(EditSquare);
            JSONObject obj = new JSONObject(EditSquare);
            for (int i = 0; i < Squares.size(); i++)
            {
                Square sq = Squares.get(i);
                if(sq.getId()==obj.getInt("id"))
                {
                    sq.setVote(obj.getInt("votes"));
                    sq.setColor(obj.getString("color"));
                    return toArray();
                }
            }
        }
        catch(Exception e){
            return toArray();
        }
        
        return 
            toArray();
    }

    private boolean Contains(int id)
    {
        for (int i=0;i<this.Squares.size();i++)
        {
            if(this.Squares.get(i).getId()==id)
                return true;
        }
        return false;
    }

    private Square [] toArray()
    {
        Square[] ret = new Square[Squares.size()];
        for(int i =0;i<Squares.size();i++)
            ret[i]= Squares.get(i);
        return ret;
    }
}