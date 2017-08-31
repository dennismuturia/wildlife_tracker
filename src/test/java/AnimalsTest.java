//Setting up the animals test.

import org.junit.*;
import static org.junit.Assert.*;

public class AnimalsTest{
    //This test checks whether the instance instantiates correctly
    @Test
    public  void animals_instantiatesCorrectly(){
        Animals myanimal = new Animals("Carnivores",1);
        assertEquals(true, myanimal instanceof Animals);
    }

    //This test checks whether the instance instantiates with name
    @Test
    public void animals_instantiatescorrectlyWithName(){
        Animals myanimal = new Animals("Carnivores", 1);
        assertEquals("Carnivores", myanimal.getName()); 
    }

    

}