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

    //Lets see if it returns the same
    @Test
    public void returns_TrueifNamesandIdAreSame(){
        Danger myDanger1 = new Danger("Dinosaur",1);
        Danger myDanger2 = new Danger("Dinosaur",1);
        assertTrue(myDanger1.equals(myDanger2));
    }
    //Now lets save
    @Test
    public void returns_TrueifNamesAreTheSame(){
        Danger myDanger1 = new Danger("Dinosaur",1);
        myDanger1.save();
        assertTrue(Danger.all().get(0).equals(myDanger1));
    }
}