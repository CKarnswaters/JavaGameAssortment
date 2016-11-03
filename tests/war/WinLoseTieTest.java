/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package war;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elijah
 */
public class WinLoseTieTest {
    
    WinLoseTie counter = new WinLoseTie();
    
    @Test
    public void testWinCount()
    {
        int currentWins = counter.getWin();
        int newWins = 0;
        int expectedWins = 0;
        
        counter.won();
        newWins = counter.getWin();
        expectedWins = currentWins + 1;
        
        assertEquals("Wins weren't added properly...", expectedWins, newWins);
        
    }
    
}
