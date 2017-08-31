//Setting up the animals test.

import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalsTest{

    //This is a database rule
    @Rule
    public DatabaseRule database = new DatabaseRule();
    
    //This test checks whether the instance instantiates correctly
    @Test
    public  void animals_instantiatesCorrectly(){
        Animals myanimal = new Animals("Carnivores");
        assertEquals(true, myanimal instanceof Animals);
    }

    //This test checks whether the instance instantiates with name
    @Test
    public void animals_instantiatescorrectlyWithName(){
        Animals myanimal = new Animals("Carnivores");
        assertEquals("Carnivores", myanimal.getName()); 
    }

    //Now lets check if it can return the same 
    @Test
    public void returns_trueifNameandIdareSame(){
        Animals myanimal1 = new Animals("Canivore");
        Animals myanimal2 = new Animals("Canivore");
        assertTrue(myanimal1.equals(myanimal2));
    }
    //Checking the saving into databse
    public void save_insertObjectIntoDtaBase_Animals(){
        Animals myanimal = new Animals("Canivore");
        myanimal.save();
        assertTrue(Animals.all().get(0).equals(myanimal));
    }

    //Lets return all database entries
    @Test
    public void all_returnsAllInstancesOfPerson_true() {
      Animals myanimal1 = new Animals("Birds");
      myanimal1.save();
      Animals myanimal2 = new Animals("crocks");
      myanimal2.save();
      assertEquals(true, Animals.all().get(0).equals(myanimal1));
      assertEquals(true, Animals.all().get(1).equals(myanimal2));
    }
    
}