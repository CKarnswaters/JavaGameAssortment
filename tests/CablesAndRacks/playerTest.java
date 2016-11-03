/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CablesAndRacks;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elijah
 */
public class playerTest {
    
    public playerTest() {
    }
    
    private player PlayerOne;
    
    @Before
    public void setUp() throws IOException {
        PlayerOne = new player(1, "Cedric", "Car");
    }

    @Test
    public void testHelpDetermine() {
        
    }
    
 
    
    @Test
    public void testDiceBetweenOneAndSix() {
        
        for(int x = 0; x < 100; x++)
        {
            PlayerOne.rollDice();
            assertTrue("Dice did not roll between 1 and 6...", PlayerOne.getSpacesToMove() >= 1 || PlayerOne.getSpacesToMove() <= 6);
           
        }
        
        
    }

    @Test
    public void testMove() {
        int currentPosition = PlayerOne.getPosition();
        PlayerOne.rollDice();
        PlayerOne.move();
        int newPosition = PlayerOne.getPosition();
        int predictedPosition = currentPosition + PlayerOne.getSpacesToMove();
        
        assertEquals("Position for player is not as expected... ", predictedPosition, newPosition);
        
        
        
        
    }
    
}
