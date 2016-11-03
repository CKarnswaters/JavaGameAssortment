/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rockpaperscissors;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Elijah
 */
public class Game{
    
    private static String[] choices = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
    private static Random randomChoice;
    
    private static int playerChoice = -1;
    private static int computerChoice = -1;
    
    private static WinLoseTie score = new WinLoseTie();
    
    private static boolean Playing = false;
    
    public static void main(String[] args)
    {
        wouldYouLikeToPlay();        
        //Checks if the player would like to continue playing or not each time.            
        while(Playing)
        {
            getChoices();
            findWinner();
            System.out.println("\n" + score.ToString() + "\n");
            wouldYouLikeToPlay();
            
        }
        
        System.out.println("Thank you for joining us today!");
    }
    
    public static void wouldYouLikeToPlay()
    {
        Scanner keyboardInput = new Scanner(System.in);
        
        if(!Playing)
            System.out.println("Would you like to play a game of Rock, Paper, Scissors, Lizard, Spock? (Y/N)");
        
        else
        {
            System.out.println("Would you like to continue playing? (Y/N)");
            
        }
        
        String usersChoice = keyboardInput.nextLine().substring(0, 1).toLowerCase();

        if(usersChoice.equals("y"))
        {
            Playing = true;
            playerChoice = -1;
        }
        else
            Playing = false;
        
        
    }
    
    public static void getChoices()
    {
        Scanner keyboardInput = new Scanner(System.in);
        
        while(playerChoice > 4 || playerChoice < 0)
        {
            
            System.out.println("Please pick a cooresponding number for your choice.");
            System.out.println("(0) Rock");
            System.out.println("(1) Paper");
            System.out.println("(2) Scissors");
            System.out.println("(3) Lizard");
            System.out.println("(4) Spock");
            playerChoice = keyboardInput.nextInt();
            
        }    
        
        randomChoice = new Random();
        
        computerChoice = randomChoice.nextInt(4);
        
        System.out.println("You picked " + choices[playerChoice] + ", the computer picked " + choices[computerChoice]);   
    }
    
    public static void findWinner()
    {
        switch(playerChoice)
        {
            case 0:
                switch(computerChoice)
                {
                    case 0:
                        System.out.println("Both rocks just kind of... Sit there.");
                        score.tied();
                        break;
                    
                    case 1:
                        System.out.println("Paper covers rock, you lose!");
                        score.lost();
                        break;
                    
                    case 2:
                        System.out.println("Rock crushes scissors, you win!");
                        score.won();
                        break;
                        
                    case 3:
                        System.out.println("Rock crushes lizard, you win!");
                        score.won();
                        break;
                        
                    case 4:
                        System.out.println("Spock vaporizes rock, you lose!");
                        score.lost();
                        break;                     
                }
                break;
                
            case 1:
                switch(computerChoice)
                {
                    case 0:
                        System.out.println("Paper covers rock, you win!");
                        score.won();
                        break;
                        
                    case 1:
                        System.out.println("Both pieces of paper float to the ground...");
                        score.tied();
                        break;
                        
                    case 2:
                        System.out.println("Scissors cuts paper, you lose!");
                        score.lost();
                        break;
                        
                    case 3:
                        System.out.println("Lizard eats paper, you lose!");
                        score.lost();
                        break;
                        
                    case 4:
                        System.out.println("Paper proves Spock wrong, you win!");
                        score.won();
                        break;
                }
                break;
            
            case 2:
                switch(computerChoice)
                {
                    case 0:
                        System.out.println("Rock crushes scissors, you lose!");
                        score.lost();
                        break;
                        
                    case 1:
                        System.out.println("Scissors cuts paper, you win!");
                        score.won();
                        break;
                        
                    case 2:
                        System.out.println("A grand battle has taken place! But it was a tie..");
                        score.tied();
                        break;
                        
                    case 3:
                        System.out.println("Scissors decapitate lizard, you win!");
                        score.won();
                        break;
                        
                    case 4:
                        System.out.println("Spock smashes scissors, you lose!");
                        score.lost();
                        break;
                }
                break;
            
            case 3:
                switch(computerChoice)
                {
                    case 0:
                        System.out.println("Rock crushes lizard, you lose!");
                        score.lost();
                        break;
                        
                    case 1:
                        System.out.println("Lizard eats paper, you win!");
                        score.won();
                        break;
                        
                    case 2:
                        System.out.println("Scissors decapitates lizard, you lose!");
                        score.lost();
                        break;
                        
                    case 3:
                        System.out.println("They stare visciously in to each others eyes, ending... In a tie..");
                        score.tied();
                        break;
                        
                    case 4:
                        System.out.println("Lizard poisons Spock, you win!");
                        score.won();
                        break;
                }
                break;
                
            case 4:
                switch(computerChoice)
                {
                    case 0:
                        System.out.println("Spock vaporizes Rock, you win!");
                        score.won();
                        break;
                        
                    case 1:
                        System.out.println("Paper disproves Spock, you lose!");
                        score.lost();
                        break;
                        
                    case 2:
                        System.out.println("Spock smashes scissors, you win!");
                        score.won();
                        break;
                        
                    case 3:
                        System.out.println("Lizard poisons Spock, you lose!");
                        score.lost();
                        break;
                        
                    case 4:
                        System.out.println("Through a mistake in the temporal warp drive, you have crossed in to a parallel dimension.");
                        System.out.println("But the meeting would be cut short as the destabilization of the dimensional fluxuation wave");
                        System.out.println("Sends your pararellel ships straight in to a black hole, ending this in... A tie...");
                        //Never watched Star Trek, but I've heard that they have a habit of making things up, so I did my best.
                        score.tied();
                        break;
                }
                
        }
    }
}
