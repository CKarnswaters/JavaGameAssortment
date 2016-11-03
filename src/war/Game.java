/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package war;


import java.util.Scanner;

/**
 *
 * @author Elijah
 */
public class Game {
    
    private static Card playerCard = new Card();
    private static Card computerCard = new Card();
    private static WinLoseTie score = new WinLoseTie();
    private static boolean playing = false;
    private static boolean inWar = false;
    
    
    
    public static void main(String[] args)
    {
        System.out.println("Welcome to war! Let's play!");
        System.out.println("(Y/N)");
        
        Scanner keyboardInput = new Scanner(System.in);
        if(keyboardInput.nextLine().substring(0, 1).toLowerCase().equals("y"))
            playing = true;
        
        else
            playing = false;
        
        while(playing)
        {
            playerCard.dealCard();
            computerCard.dealCard();
            whoDrewWhat();
            checkWinner();
            System.out.println(score.ToString());
            playAgain();
            inWar = false;
        }
        
        
    }
    
    public static void whoDrewWhat()
    {
        System.out.println("You drew: " + playerCard.getCard() + " of " +playerCard.getSuit());
        System.out.println("Computer drew: " + computerCard.getCard() + " of " + computerCard.getSuit());
    }
    
    public static void checkWinner()
    {
        if(playerCard.cardValue > computerCard.cardValue)
        {
            System.out.println("You win!");
            
            if(!inWar)
             score.won();
            
            else if(inWar)
            {
                score.won();
                score.won();
                score.won();
            }
            
        }
        
        else if(playerCard.cardValue < computerCard.cardValue)
        {
            System.out.println("You lost!");
            
            if(!inWar)
                score.lost();
            
            else if(inWar)
            {
                score.lost();
                score.lost();
                score.lost();
            }
        }
        
        else if(playerCard.cardValue == computerCard.cardValue)
        {
            declareWar();
        }
            
    }
    
    public static void declareWar()
    {
        inWar = true;
        
        playerCard.dealCard();
        computerCard.dealCard();
        System.out.print("I..");
        
        playerCard.dealCard();
        computerCard.dealCard();
        System.out.print("Declare...");
        
        playerCard.dealCard();
        computerCard.dealCard();
        System.out.print("War!");
        
        whoDrewWhat();
        
        checkWinner();
    }
    
    public static void playAgain()
    {
        
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Would you like to play again?");
        System.out.println("(Y/N)");
        
        if(keyboardInput.nextLine().substring(0, 1).toLowerCase().equals("y"))
            playing = true;
        
        else
            playing = false;
        
        
    }
}
