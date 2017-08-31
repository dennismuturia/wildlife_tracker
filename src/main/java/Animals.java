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
    public Animals(String name){
        this.name = name;
    }
    //This is a getter for the name variable
    public String getName(){
        return name;
    }

    //This will be an override that returns if the passed values are the same
    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animals)){
            return false;
        }else{
            Animals newAnimals = (Animals) otherAnimal;
            return this.getName().equals(newAnimals.getName());
        }
    }
}