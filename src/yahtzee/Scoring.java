/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yahtzee;

/**
 *
 * @author Elijah
 */
public class Scoring {
    
    static int[] diceValues = new int[5];
    private static int valueToKeep = 0;

    public static int getValueToKeep() {
        return valueToKeep;
    }
    
    public Scoring(int[] diceValues)
    {
        for(int x = 0; x < this.diceValues.length; x++)
        {
            this.diceValues[x] = diceValues[x];
        }
    }
    
    public static boolean ones()
    {
        int onesFound = 0;
        
        for(int x = 0; x < diceValues.length; x++)
        {
            if(diceValues[x] == 1)
                onesFound++;
        
        }
        
        if(onesFound > 0 && onesFound < 5)
            return true;
        
        return false;
    }
    
    public static boolean twos()
    {
        int twosFound = 0;
        
        for(int x = 0; x < diceValues.length; x++)
        {
            if(diceValues[x] == 2)
                twosFound++;
        }
        
        if(twosFound > 0 && twosFound < 5)
            return true;
            
        return false;
    }
    
    public static boolean Yahtzee()
    {
        if(diceValues[0] == diceValues[1] && diceValues[1] == diceValues[2] && diceValues[2] == diceValues[3] && diceValues[3] == diceValues[4])
        {
           return true; 
        }
        
        return false;
    }
    
    public static boolean threeOfAKind()
    {
        if(diceValues[0] == diceValues[1] && diceValues[1] == diceValues[2] && diceValues[2] != diceValues[3] ||
                diceValues[1] == diceValues[2] && diceValues[2] == diceValues[3] && diceValues[3] != diceValues[4] ||
                diceValues[2] == diceValues[3] && diceValues[3] == diceValues[4])
        {
            valueToKeep = diceValues[3];
            return true;
        }
        
        return false;
    }
    
    public static boolean fourOfAKind()
    {
        if(diceValues[0] == diceValues[1] && diceValues[1] == diceValues[2] && diceValues[2] == diceValues[3] ||
                diceValues[1] == diceValues[2] && diceValues[2] == diceValues[3] && diceValues[3] == diceValues[4])
        {
            valueToKeep = diceValues[3];
            return true;
        }
        
        return false;
    }
    
    public static boolean smallStraight()
    {
        if(diceValues[0] == 1 && diceValues[1] == 2 && diceValues[2] == 3 && diceValues[3] == 4)
        {
            return true;
        }
        return false;
    }
    
    
    public static boolean largeStraight()
    {
        if(diceValues[0] == 2 && diceValues[1] == 3 && diceValues[2] == 4 && diceValues[3] == 5 && diceValues[4] == 6)
        {
            return true;
        }
        
        return false;
    }
    
            
}
