/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package war;

/**
 *
 * @author Elijah
 */
public class WinLoseTie {
    
    private int win;
    private int lose;
    private int tie;
    
    public WinLoseTie()
    {
        win = 0;
        lose = 0;
        tie = 0;
    }

    public void won()
    {
        win++;
    }
    
    public void lost()
    {
        lose++;
    }
    
    public void tied()
    {
        tie++;
    }
    
    public String ToString()
    {
        String output = "";
        
        output += "Won: " + win;
        output += "\nLost: " + lose;
        //output += "\nTied: " + tie;
        
        return output;
    }
    
    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }
    
    
    
}
