package com.example.server;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor



//==============================================================================
//                          Square Class
//==============================================================================



public class Square {

    private int id = 0;
    private String color="";
    private int vote = 0;
    


    public Square(String color, int vote, int id) {
        this.color = color;
        this.vote = vote;
        this.id = id;
    }


    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getId() {
        return id;
    }

    public int getVote() {
        return vote;
    }
    
    public String getColor(){
        return this.color;
    }



    
}