/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import javax.swing.JFrame;


/**
 *
 * @author user
 */
public class Calculator 
{

      
    
    /** Application start    point
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    
        JFrame frame = new oneFrame();
            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.pack();
       frame.setVisible(true);
      //  frame.setSize(300,300);
        frame.setLocation(150, 100);
        
    }   
     
    
}
