/*
This is a sighting class 
where an animal is sighted
by Dennis MUTURIA
*/

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Sightings{
    private String name;
    private int id;
    public Sightings(String name){
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

    //This will be an override that returns if the passed values are the same
    @Override
    public boolean equals(Object otherSighting){
        if(!(otherSighting instanceof Sightings)){
            return false;
        }else{
            Sightings newSightings = (Sightings) otherSighting;
            return this.getName().equals(newSightings.getName());
        }
    }
    //Now we are going to save our animals
    public void save() {
        try(Connection con = DB.sql2o.open()) {
          String sql = "INSERT INTO sighting (name) VALUES (:name)";
          this.id = (int) con.createQuery(sql, true)
            .addParameter("name", this.name)
            .executeUpdate()
            .getKey();
        }
      }
      //Now lets addthe returning for all columns
      public static List<Sightings> all() {
        String sql = "SELECT * FROM sighting";
        try(Connection con = DB.sql2o.open()) {
         return con.createQuery(sql).executeAndFetch(Sightings.class);
        }
      }
      //Now this is a find function that finds the animals based on their id
      public static Sightings find(int id) {
        try(Connection con = DB.sql2o.open()) {
          String sql = "SELECT * FROM sighting where id=:id";
          Sightings sighting = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(Sightings.class);
          return sighting;
        }
      }    
}
