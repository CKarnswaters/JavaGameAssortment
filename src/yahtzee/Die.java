/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yahtzee;

import java.util.Random;

/**
 *
 * @author Elijah
 * @version 0.01
 */

public class Die {
    
    private static Random roller = new Random();
    private int value;
    private int sides;

    public Die(int sides) {
        this.sides = sides;
        rollDie();
    }

    public Die() {
        sides = 6;
        rollDie();
    }
    
    public int rollDie()
    {
        value = roller.nextInt(sides) + 1;
        return value;
    }
    
    public int getValue() {
        return value;
    }

    public int getSides() {
        return sides;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
    
    
    
}
