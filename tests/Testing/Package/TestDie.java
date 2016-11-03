
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Testing.Package;

import org.junit.*;
import static org.junit.Assert.*;


import yahtzee.*;
/**
 *
 * @author Elijah
 */
public class TestDie {
    
    Die dice;
    
    @Before
    public void generateDice()
    {
        dice = new Die();
        dice.rollDie();
        
    }
    
    @Test
    public void testRollBetweenSix()
    {
        
        assertTrue("This failed!", dice.getValue() > 6 || dice.getValue() < 1);
        
    }
    
}
