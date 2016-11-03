/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CablesAndRacks;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Elijah
 */
public class player{
    
    Random roll = new Random();
    
    String playerName;
    
    int playerNumber;
    int turnOrder;
    int turnOrderRoll;
    
    int position;
    int spacesToMove;
    
    String pieceImagePath;
    
    public player(int playerNumber, String playerName, String gamePiece) throws IOException
    {
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        pieceImagePath = gamePiece + ".png";
        
        spacesToMove = 0;
        position = 0;
        turnOrder = 0;
        
    }
    
    public void helpDetermine()
    {
        turnOrderRoll = roll.nextInt(19) + 1;
    }
    
    public void rollDice()
    {
        spacesToMove = roll.nextInt(5) + 1;
    }
    
    public void move()
    {
        position += spacesToMove;
        if(position > 99)
            position = 99;
           
    }

    public Random getRoll() {
        return roll;
    }

    public void setRoll(Random roll) {
        this.roll = roll;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getTurnOrder() {
        return turnOrder;
    }

    public void setTurnOrder(int turnOrder) {
        this.turnOrder = turnOrder;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getSpacesToMove() {
        return spacesToMove;
    }

    public void setSpacesToMove(int spacesToMove) {
        this.spacesToMove = spacesToMove;
    }

    public String getPieceImagePath() {
        return pieceImagePath;
    }

    public void setPieceImagePath(String pieceImagePath) {
        this.pieceImagePath = pieceImagePath;
    }
    
    public int getTurnOrderRoll() {
        return turnOrderRoll;
    }
    
    public static Comparator<player> playerRollComparison
            = new Comparator<player>() {
                
                @Override
                public int compare(player turnRoll1, player turnRoll2) {
                    int turnValue1 = turnRoll1.getTurnOrderRoll();
                    int turnValue2 = turnRoll2.getTurnOrderRoll();
                    
                    boolean turnRollIsSame = true;
                    
                    while(turnRollIsSame)
                    {
                        if(turnValue1 > turnValue2)
                            return 1;
                    
                        else if(turnValue1 < turnValue2)
                            return -1;
                    
                        else
                        {
                            turnRollIsSame = true;
                            turnValue1 = turnRoll1.roll.nextInt(19) + 1;
                            turnValue2 = turnRoll2.roll.nextInt(19) + 1;
                        } 
                    }
                    return 0;
                }
            };
                    
}

