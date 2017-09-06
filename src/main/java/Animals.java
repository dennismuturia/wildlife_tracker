/*
This will be my absreact class that i will work
on for my project. It will contain all the variables 
that are necessary for all my other classes.abstract
*/

import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Animals{
    private String name;
    private int id;
    private int sightingId;
    public Animals(String name){
        this.name = name;
    }
    //This is a getter for the name variable
    public String getName(){
        return name;
    }

    //Getter to return id
    public int getId() {
        return id;
    }
    //Initialize the sighting id
    public int getSightingId(){
        return sightingId;
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
    //Now we are going to save our animals
    public void save() {
        try(Connection con = DB.sql2o.open()) {
          String sql = "INSERT INTO animals (name, sightingId) VALUES (:name, :sightingid)";
          this.id = (int) con.createQuery(sql, true)
            .addParameter("name", this.name)
            .addParameter("sightingid", this.sightingId)
            .executeUpdate()
            .getKey();
        }
      }
      //Now lets addthe returning for all columns
      public static List<Animals> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
         return con.createQuery(sql).executeAndFetch(Animals.class);
        }
      }
      //Now this is a find function that finds the animals based on their id
      public static Animals find(int id) {
        try(Connection con = DB.sql2o.open()) {
          String sql = "SELECT * FROM animals where id=:id";
          Animals animals = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(Animals.class);
          return animals;
        }
      }
}