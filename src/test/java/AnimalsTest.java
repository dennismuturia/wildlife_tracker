//Setting up the animals test.

import org.junit.*;
import org.junit.Assert.*;

public class AnimalTest{
    @Test
    public  void animals_instantiatesCorrectly(){
        Animals myanimal = new Animals();
        assertEquals(true, myanimal instanceof Animals);
    }
}