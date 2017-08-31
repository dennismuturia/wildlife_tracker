/*
This will be my absreact class that i will work
on for my project. It will contain all the variables 
that are necessary for all my other classes.abstract
*/

import java.util.ArrayList;
import java.util.List;

public class Animals{
    private String name;
    private int id;
    public Animals(String name, int id){
        this.name = name;
        this.id = id;
    }
    //This is a getter for the name variable
    public String getName(){
        return name;
    }
    //A getter for id variable
    public int getId(){
        return id;
    }

}