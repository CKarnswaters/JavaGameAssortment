/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yahtzee;

import javax.swing.ImageIcon;

/**
 *
 * @author Elijah
 */
public class DieImage extends Die{
    
    protected ImageIcon dieImage = new ImageIcon();
    public DieImage()
    {
        this.setSides(6);
    }
    
    @Override
    public void setValue(int value)
    {
        super.setValue(value);
        pickImage();
    }
    
    @Override
    public int rollDie()
    {
        int value = super.rollDie();
        
        return value;
    }

    public ImageIcon getDieImage() {
        return dieImage;
    }
    
    
    
    private void pickImage()
    {
        switch(this.getValue())
        {
            case 1:
                dieImage = new ImageIcon(ClassLoader.getSystemResource("one.png"));
                break;
                
            case 2:
                dieImage = new ImageIcon(ClassLoader.getSystemResource("two.png"));
                break;
                
            case 3:
                dieImage = new ImageIcon(ClassLoader.getSystemResource("three.png"));
                break;
                
            case 4:
                dieImage = new ImageIcon(ClassLoader.getSystemResource("four.png"));
                break;
                
                
            case 5:
                dieImage = new ImageIcon(ClassLoader.getSystemResource("five.png"));
                break;
                
                
            case 6:
                dieImage = new ImageIcon(ClassLoader.getSystemResource("six.png"));
                break;
              
            default:
                dieImage = new ImageIcon(ClassLoader.getSystemResource("one.png"));
                break;
        }
    }
    
}
