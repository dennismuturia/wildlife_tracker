/*
This is a endagered animal tests
*/
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class DangerTest{
    //Lets see if it instantiates with a name correctly
    @Test

    public void Danger_instantiatescorrectlyWithName(){
        Danger myDanger = new Danger("Dinosaur",1);
        assertEquals("Dinosaur", myDanger.getName()); 
    }

    //Lets see if it can instantiate with animal id
    @Test
    public void Danger_instantiatescorrectlywithAnimalsId(){
        Danger myDanger = new Danger("Dinosaur",1);
        assertEquals(1, myDanger.getAnimalId());  
    }
}