/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Testing.Package;

import CablesAndRacks.*;
import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author Elijah
 */
public class TestPlayer {
    
   private player playerOne;
   
   @Before
   public void runBeforeEachTest() throws IOException
   {
       playerOne = new player(1, "Cedric", "Car");
   
   }
   
   @Test
   public void testPlayerNumber()
   {
       
   }
   
   

}
