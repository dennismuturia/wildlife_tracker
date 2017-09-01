import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class SightingsTest{


    @Rule
    public DatabaseRule database = new DatabaseRule();
    
    //This test checks whether the instance instantiates correctly
    
    @Test
    public  void sightings_instantiatesCorrectly(){
        Sightings mysighting = new Sightings("Park");
        assertEquals(true, mysighting instanceof Sightings);
    }

    //This test checks whether the instance instantiates with name
    @Test
    public void sightings_instantiatescorrectlyWithName(){
        Sightings mysighting = new Sightings("park");
        assertEquals("park", mysighting.getName()); 
    }

    //Now lets check if it can return the same 
    @Test
    public void returns_trueifNameandIdareSame(){
        Sightings mysighting1 = new Sightings("park");
        Sightings mysighting2 = new Sightings("Nairobi");
        assertTrue(mysighting1.equals(mysighting2));
    }
    //Checking the saving into databse
    public void save_insertObjectIntoDtaBase_Sightings(){
        Sightings mysighting = new Sightings("park");
        mysighting.save();
        assertTrue(Sightings.all().get(0).equals(mysighting));
    }

    //Lets return all database entries
    @Test
    public void all_returnsAllInstancesOfSighting_true() {
      Sightings mysighting1 = new Sightings("park");
      mysighting1.save();
      Sightings mysighting2 = new Sightings("park");
      mysighting2.save();
      assertEquals(true, Sightings.all().get(0).equals(mysighting1));
      assertEquals(true, Sightings.all().get(1).equals(mysighting2));
    }
    //Now lets assign ids
    public void save_assignsIdtoObjects(){
        Sightings mysighting = new Sightings("park");
        mysighting.save();
        Sightings savedanimal = Sightings.all().get(0);
        assertEquals(mysighting.getId(), savedanimal.getId());
    }
    //Lets find an animal basing on its id
    public void find_returnsfirdtSightingwithid_secondSigting(){
        Sightings mysighting1 = new Sightings("park");
        mysighting1.save();
        Sightings mysighting2 = new Sightings("park");
        mysighting2.save();
        assertEquals(Sightings.find(mysighting2.getId()),mysighting2);
    }
}