//Setting up the animals test.

import org.junit.*;
import org.junit.Assert.*;

public class AnimalsTest{
    //This test checks whether the instance instantiates correctly
    @Test
    public  void animals_instantiatesCorrectly(){
        Animals myanimal = new Animals("Carnivores");
        assertEquals(true, myanimal instanceof Animals);
    }
}