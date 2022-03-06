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
    private int votes = 0;
    


    public Square(String color, int votes, int id) {
        this.color = color;
        this.votes = votes;
        this.id = id;
    }


    public void setVote(int vote) {
        this.votes = vote;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public int getVote() {
        return votes;
    }
    
    public String getColor(){
        return this.color;
    }



    
}