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

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class game extends JFrame implements ActionListener{
    
    private static game yahtzeeFrame;
    
    
    private static JFrame scoringFrame = new JFrame("Scoring Frame");
    
    private static JPanel scoringPanel = new JPanel(new BorderLayout());
    private static JPanel innerScoringPanel = new JPanel(new FlowLayout());
    private static JPanel[] scoringPanels = new JPanel[13];
    private static JRadioButton[] scoringRadio = new JRadioButton[13];
    private static ButtonGroup scoringGroup = new ButtonGroup();
//12
    
    
    
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 400;
    
    
    //<editor-fold defaultstate="collapsed" desc="Roll Variables">
    private static int rollCount = 0;   
    private static Die[] rolls = new Die[5];
    //</editor-fold>
    
    //private static String[] diceImagePath = {"dice1.jpg", "dice2.jpg", "dice3.jpg", "dice4.jpg", "dice5.jpg"};
    //private static File[] diceFilePath = new File[5];
    //private static BufferedImage[] diceImage = new BufferedImage[5];
    
    // <editor-fold defaultstate="collapsed" desc="Main Dice Panels and Images">
    private static JPanel[] dicePanels = new JPanel[5];
    private static JPanel dicePanel = new JPanel(new BorderLayout());
    private static JPanel dicePanel2 = new JPanel(new FlowLayout());
    private static JPanel diceAndCheck = new JPanel();
    private static ImageIcon[] diceImage = new ImageIcon[6];
    private static JCheckBox[] diceCheckBox = new JCheckBox[5];
    //</editor-fold>
 
    
    //<editor-fold defaultstate="collapsed" desc="Kept Dice Panels, Images and Values">
    private static JPanel keptDicePanel = new JPanel(new BorderLayout());
    private static JPanel innerKeptDice = new JPanel(new FlowLayout());
    private static JPanel[] keptDicePanels = new JPanel[5];
    private static JLabel[] keptDiceImages = new JLabel[5];
    private static int[] valuesKept = new int[5];
    private static ArrayList<Integer> keptValues = new ArrayList<Integer>();
    private static JLabel[] keptDiceValueText = new JLabel[5];
    //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Lower Panel, Score, Buttons, Etc">
    private static JPanel lowerPanel = new JPanel(new BorderLayout());
    private static JPanel scorePanel = new JPanel(new BorderLayout());   
    private static JButton rollButton = new JButton("Roll");
    private static JButton nextSetButton = new JButton("Next Set");
    private static JLabel[] diceValueText = new JLabel[5];
    private static JLabel scoreText = new JLabel("Score: ");
    private static JLabel scoreCountText = new JLabel("0000");
    private static int score = 0;
    //</editor-fold>
    
    
    
    public game() throws IOException
    {
        super("Yahtzee!");
        setLayout(new BorderLayout());
        
        setupScoringFrame();       
        setupCentralDiceLayout();        
        setupKeptDiceLayout();       
        setupLowerPanelLayout();       
        
        rollButton.addActionListener(this);
        nextSetButton.addActionListener(this);
        
    }

    private void setupScoringFrame() {
        
        scoringFrame.setSize(300, 600);
        scoringFrame.setBounds(300, 300, 150, 600);
        scoringFrame.add(scoringPanel);
        scoringPanel.add(innerScoringPanel, BorderLayout.CENTER);
        
        
        scoringRadio[0] = new JRadioButton("Ones");
        scoringRadio[1] = new JRadioButton("Twos");
        scoringRadio[2] = new JRadioButton("Threes");
        scoringRadio[3] = new JRadioButton("Fours");
        scoringRadio[4] = new JRadioButton("Fives");
        scoringRadio[5] = new JRadioButton("Sixes");
        scoringRadio[6] = new JRadioButton("3 of a kind");
        scoringRadio[7] = new JRadioButton("4 of a kind");
        scoringRadio[8] = new JRadioButton("Full House");
        scoringRadio[9] = new JRadioButton("Small Straight");
        scoringRadio[10] = new JRadioButton("Large Straight");
        scoringRadio[11] = new JRadioButton("Yahtzee");
        scoringRadio[12] = new JRadioButton("Chance");
        
        
        //CAN'T SEEM TO GET THE RADIO BUTTONS TO SHOW UP!!!!
        for(int x = 0; x < scoringRadio.length; x++)
        {
            scoringPanels[x] = new JPanel(new BorderLayout());
            scoringPanel.add(scoringPanels[x]);
            scoringPanels[x].add(scoringRadio[x]);
            scoringGroup.add(scoringRadio[x]);
            innerScoringPanel.add(scoringPanels[x], BorderLayout.NORTH);
            
            //scoringRadio[x].setEnabled(false);
            //scoringRadio[x].setSelected(false);
            
        }
        
        
        
        scoringFrame.setVisible(true);
        
        
        
    }
    
    private void setupLowerPanelLayout() {
        lowerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(lowerPanel, BorderLayout.PAGE_END);
        rollButton.setPreferredSize(new Dimension(128, 32));
        nextSetButton.setPreferredSize(new Dimension(128, 32));
        nextSetButton.setBounds(300, 10, 128, 32);
        nextSetButton.setEnabled(false);
        lowerPanel.add(rollButton, BorderLayout.LINE_END);
        lowerPanel.add(nextSetButton, BorderLayout.WEST);
        
        scorePanel.setPreferredSize(new Dimension(100, 32));
        lowerPanel.add(scorePanel, BorderLayout.LINE_START);        
        scorePanel.add(scoreText, BorderLayout.LINE_START);
        scorePanel.add(scoreCountText, BorderLayout.LINE_END);
    }

    private void setupKeptDiceLayout() {
        keptDicePanel.setPreferredSize(new Dimension(48, 100));
        keptDicePanel.setBackground(Color.red);
        add(keptDicePanel, BorderLayout.LINE_END);
        keptDicePanel.add(innerKeptDice, BorderLayout.CENTER);
        
        for(int addKeptDice = 0; addKeptDice < keptDicePanels.length; addKeptDice++)
        {
            keptDicePanels[addKeptDice] = new JPanel();
            keptDicePanels[addKeptDice].setPreferredSize(new Dimension(40, 40));
            innerKeptDice.add(keptDicePanels[addKeptDice]);
            
            //Test image until it's set up properly.
            keptDiceImages[addKeptDice] = new JLabel();
            keptDiceImages[addKeptDice].setIcon(diceImage[addKeptDice]);
            keptDiceValueText[addKeptDice] = new JLabel();
            keptDiceValueText[addKeptDice].setPreferredSize(new Dimension(36, 36));
            keptDicePanels[addKeptDice].add(keptDiceValueText[addKeptDice]);
            keptDicePanels[addKeptDice].setVisible(false);
        }
    }

    private void setupCentralDiceLayout() {
        dicePanel.setPreferredSize(new Dimension(100, 300));
        dicePanel.setBackground(Color.red);
        dicePanel.setBounds(150, 125, 275, 100);
        add(dicePanel, BorderLayout.SOUTH);
        dicePanel2.setPreferredSize(new Dimension(0, 75));
        dicePanel.add(dicePanel2, BorderLayout.CENTER);
        
        for(int crazyLayout = 0; crazyLayout < 5; crazyLayout++)
        {
            dicePanels[crazyLayout] = new JPanel(new FlowLayout());
            dicePanels[crazyLayout].setPreferredSize(new Dimension(50, 100));
            dicePanel2.add(dicePanels[crazyLayout]);
            
            
            diceValueText[crazyLayout] = new JLabel(diceImage[0]);
            diceValueText[crazyLayout].setPreferredSize(new Dimension(32, 32));
            
            dicePanels[crazyLayout].add(diceValueText[crazyLayout], BorderLayout.NORTH);
            dicePanels[crazyLayout].add(diceCheckBox[crazyLayout], BorderLayout.SOUTH);
        }
        
        /*
        for(int setFiles = 0; setFiles < 6; setFiles++)
        {
        //diceFilePath[setFiles] = new File(diceImagePath[setFiles]);
        //diceImage[setFiles] = ImageIO.read(diceFilePath[setFiles]);
        }
        */
    }
    
    public static void main(String[] args) throws IOException
    {
        setupDice();
        yahtzeeFrame = new game();
        yahtzeeFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        yahtzeeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        yahtzeeFrame.setLocationRelativeTo(null);
        yahtzeeFrame.setVisible(true);
        
    }

    public static void setupDice()
    {
        for(int timesRolled = 0; timesRolled < rolls.length; timesRolled++)
        {
            rolls[timesRolled] = new Die(6);            
        }
        
        for(int currentCheckBox = 0; currentCheckBox < diceCheckBox.length; currentCheckBox++)
        {
            diceCheckBox[currentCheckBox] = new JCheckBox("", false);
            diceCheckBox[currentCheckBox].setEnabled(false);
        }
        
        int currentDice = 0;
        
        for(int currentImage = 0; currentImage < diceImage.length; currentImage++)
        {
            currentDice++;
            diceImage[currentImage] = createImageIcon("dice" + currentDice + ".png");
             
            
        }
    }
    
    public static void addDiceToBoard(JFrame frame)
    {
        for(int currentDice = 0; currentDice < diceCheckBox.length; currentDice++)
        {
            dicePanels[currentDice] = new JPanel(new BorderLayout());
            dicePanels[currentDice].setPreferredSize(new Dimension(150, 150));
            frame.add(dicePanels[currentDice], BorderLayout.LINE_START);
            
            dicePanels[currentDice].add(diceCheckBox[currentDice]);
            
        }
    }
    
    public static void rollDice()
    {
        String diceValue = "";
        for(int diceBeingRolled = 0; diceBeingRolled < rolls.length; diceBeingRolled++)
        {
            if(rollCount == 0)
                diceCheckBox[diceBeingRolled].setEnabled(true);
            
            rolls[diceBeingRolled].rollDie();
            diceValueText[diceBeingRolled].setIcon(diceImage[rolls[diceBeingRolled].getValue() - 1]);
            
            //diceCheckBox[diceBeingRolled].setText(Integer.toString(rolls[diceBeingRolled].getValue()));
            
        }
        rollCount++;
    }
    
    private void keepDice() {
                
        
        for(int checkingBox = 0; checkingBox < diceCheckBox.length; checkingBox++)
        {
            
            
            if(diceCheckBox[checkingBox].isSelected())
            {
                keptValues.add(rolls[checkingBox].getValue());
                diceCheckBox[checkingBox].setSelected(false);
                dicePanels[checkingBox].setVisible(false);
                dicePanels[checkingBox].setEnabled(false);
            }   
            
            
        } 
        
        setKeptDiceToRight();
                
        
    }

    private void setKeptDiceToRight() {
        
        Collections.sort(keptValues);
        
        switch(keptValues.size())
        {
            case 1:
                keptDiceValueText[0].setIcon(diceImage[keptValues.get(0) - 1]);
                keptDicePanels[0].setVisible(true);
                
                break;
                
            case 2:
                keptDiceValueText[0].setIcon(diceImage[keptValues.get(0) - 1]);
                keptDicePanels[0].setVisible(true);
                keptDiceValueText[1].setIcon(diceImage[keptValues.get(1) - 1]);
                keptDicePanels[1].setVisible(true);
                break;
                
            case 3:
                keptDiceValueText[0].setIcon(diceImage[keptValues.get(0) - 1]);
                keptDicePanels[0].setVisible(true);
                keptDiceValueText[1].setIcon(diceImage[keptValues.get(1) - 1]);
                keptDicePanels[1].setVisible(true);
                keptDiceValueText[2].setIcon(diceImage[keptValues.get(2) - 1]);
                keptDicePanels[2].setVisible(true);
                break;
                
            case 4:
                keptDiceValueText[0].setIcon(diceImage[keptValues.get(0) - 1]);
                keptDicePanels[0].setVisible(true);
                keptDiceValueText[1].setIcon(diceImage[keptValues.get(1) - 1]);
                keptDicePanels[1].setVisible(true);
                keptDiceValueText[2].setIcon(diceImage[keptValues.get(2) - 1]);
                keptDicePanels[2].setVisible(true);
                keptDiceValueText[3].setIcon(diceImage[keptValues.get(3) - 1]);
                keptDicePanels[3].setVisible(true);
                break;
                
            case 5:
                keptDiceValueText[0].setIcon(diceImage[keptValues.get(0) - 1]);
                keptDicePanels[0].setVisible(true);
                keptDiceValueText[1].setIcon(diceImage[keptValues.get(1) - 1]);
                keptDicePanels[1].setVisible(true);
                keptDiceValueText[2].setIcon(diceImage[keptValues.get(2) - 1]);
                keptDicePanels[2].setVisible(true);
                keptDiceValueText[3].setIcon(diceImage[keptValues.get(3) - 1]);
                keptDicePanels[3].setVisible(true);
                keptDiceValueText[4].setIcon(diceImage[keptValues.get(4) - 1]);
                keptDicePanels[4].setVisible(true);
                break;
                
                
            default:
                System.err.println("Something messed up in the switch statement to print the kept dice...");
                
        }        
    }
    
    private void addRemainingValues() {
        
        for(int x = 0; x < diceCheckBox.length; x++)
        {
            
            
            if(dicePanels[x].isEnabled())
            {
                
                keptValues.add(rolls[x].getValue());
                dicePanels[x].setVisible(false);
                dicePanels[x].setEnabled(false);
            }
        }
        
        
        
        setKeptDiceToRight();
        
    }
    
    private boolean selectedCheckBox() {
        for(int isChecked = 0; isChecked < diceCheckBox.length; isChecked++)
        {
            if(diceCheckBox[isChecked].isSelected())
                return true;
        }
        
        return false;
    }
    
    private void calculateScore() {
        
        int[] finalValues = new int[5];
        int count = 0;
        
        for(Integer values : keptValues)
        {
            finalValues[count] = values;
            count++;
        }
        
        Scoring setScoreDice = new Scoring(finalValues);
        
        if(Scoring.Yahtzee())
        {
            score += 50;
            
        }
        
        else if(Scoring.smallStraight())
        {
            score += 30;
        }
        
        else if(Scoring.largeStraight())
        {
            score += 40;
        }
        
        else if(Scoring.threeOfAKind())
        {
            score += Scoring.getValueToKeep() * 3;
        }
        
        else if(Scoring.ones())
        {
            for(Integer one : keptValues)
            {
               if(one == 1)
                   score += 1;
            }
            
        }
        
        else if(Scoring.twos())
        {
            for(Integer two : keptValues)
            {
                if(two == 2)
                    score += 2;
            }
            
            
        }
        
        
        
        else
        {
            System.err.print("You scored nothing!");
        }
        
        scoreCountText.setText(Integer.toString(score));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == rollButton)
        {
            if(rollCount > 0 && selectedCheckBox())
            {
                keepDice();                
            }
            
            rollDice();
            
            if(rollCount >= 3 || keptValues.size() >= 5)
            {
                rollButton.setEnabled(false);
                
                if(rollCount >= 3)
                    addRemainingValues();
                
                
                calculateScore();
                nextSetButton.setEnabled(true);
                
            }
            
        }
        
        if(source == nextSetButton)
        {
            nextSetButton.setEnabled(false);
            rollButton.setEnabled(true);
            
            for(JPanel panel : dicePanels)
            {
                panel.setEnabled(true);
                panel.setVisible(true);
            }
            
            for(JPanel panel : keptDicePanels)
            {
                panel.setEnabled(false);
                panel.setVisible(false);
            
            }
            
            keptValues.clear();
            
            rollCount = 0;
        }
        
        
    }

    static protected ImageIcon createImageIcon(String path) {
        
        URL imgURL = game.class.getResource(path);
        
        if(imgURL != null)
        {
            return new ImageIcon(imgURL);
        }
        
        else
        {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}