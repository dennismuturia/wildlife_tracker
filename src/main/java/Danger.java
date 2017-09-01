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
        this.animalId = animalId;
    
    }
    //this returns the name
    public String getName(){
        return name;
    }
    //returns the animal id
    public int getAnimalId(){
        return animalId;
    }
    //Create an override to find aspecific with an id
    @Override
    public boolean equals(Object otherDanger){
        if(!(otherDanger instanceof Danger)){
            return false;
        }else{
            Danger newDanger = (Danger) otherDanger;
            return this.getName().equals(newDanger.getName())&&
                this.getAnimalId() == newDanger.getAnimalId();
        }
    }
    //Now lets create a function for the save
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql =  "INSERT INTO danger (name, animalId) VALUES (:name, :animalId)";
            this.id = (int) con.createQuery(sql, true)
            .addParameter("name", this.name)
            .addParameter("personId", this.animalId)
            .executeUpdate()
            .getKey();
        }
    }

}