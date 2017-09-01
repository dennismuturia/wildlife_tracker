/*
This is a child class of the animal that has a relationship of one to many
*/

//Now this is where you import all what you require
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
//main class
public class Danger{
    public String name;
    public int animalId;

    public Danger(String name, int animalId){
        this.name = name;
    
    }
    //this returns the name
    public String getName(){
        return name;
    }
    //returns the animal id
    public int getAnimalId(){
        return animalId;
    }

}