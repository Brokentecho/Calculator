/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author user
 */

public class oneFrame extends JFrame
{
        
    private JTextField numA;
    private JTextField numB;
    private JTextField numC;
    
    private JTextArea sms;
    
    private static final int FRAME_WIDTH = 200;
    private static final int FRAME_HEIGHT = 300;
    
        
    public oneFrame()
    {        
       super("Calculator");
       
      // numA.setText("0"); 
       //numB.setText("0");
       //numC.setText("0");
       
       createTitle(); 
       createBody();
       createFooter();
             
       setSize(FRAME_WIDTH, FRAME_HEIGHT);
       pack();
       setVisible(true);
    }
    
   
        /** header */
    private void createTitle()
    {

        JLabel titile = new JLabel("Loan Calculator");
        titile.setForeground(Color.red);
        titile.setBackground(Color.DARK_GRAY);
        titile.setSize(10, 10);

        JPanel header = new JPanel(); 
        header.add(titile);

        add(BorderLayout.NORTH,header);
    }

        
        /** body */
    private void createBody()
    {
         

        JPanel panelA = new JPanel(); 
        panelA.setLayout(new GridLayout(3,2));
        
            JLabel labA = new JLabel("Loan Amount($): ", JLabel.RIGHT);
            panelA.add(labA);

            numA = new JTextField("0",12);
            panelA.add(numA);


            JLabel labB = new JLabel("Intrest Rate/Year(%): ", JLabel.RIGHT);
            panelA.add(labB);

            numB = new JTextField("0", 12);
            panelA.add(numB);


            JLabel labC = new JLabel("Length of Term(year): ", JLabel.RIGHT);
            panelA.add(labC);

            numC = new JTextField("0", 12);
            panelA.add(numC);

        
        
            sms = new JTextArea(30,30);
            sms.setEditable(false);
            JScrollPane logbook = new JScrollPane(sms);
            


        JPanel pane = new JPanel();
            pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
            pane.add(panelA);
            pane.add(logbook);

        add(BorderLayout.CENTER, pane);
        
    }


    /** footer */
    private void createFooter()
    {
        JPanel footer = new JPanel();
        footer.setBackground(Color.yellow);  

        JButton Reset = new JButton("Save");
        // Reset.addActionListener(new LoneActionListener()); 
        footer.add(Reset);


        JButton Press;
        Press = createButton();

        footer.add(Press);

        add(BorderLayout.SOUTH, footer);
    }
       
   
    
    private JButton createButton()
    {        
        JButton Press = new JButton("Show");
        
        class LoneActionListener implements ActionListener
        {

            public void actionPerformed(ActionEvent e) 
            {

               //System.out.println("pressed");
                double a,b,c;
                a = b = c = 0;
                
               // try
                {
                    a = Double.parseDouble(numA.getText());

                    b = Double.parseDouble(numB.getText());

                    c = Double.parseDouble(numC.getText());

                    Loan home = new Loan();
                    home.setPrinciple(a);
                    home.setRatio(b);
                    home.setTerm(c);

                    home.getLoan();
                    sms.append(  home.getReport() );
                }
        /* catch(Exception e)   
            {
                 System.out.println("Error." + e.notify());
            }
*/
            }
        }
        
        ActionListener listener = new LoneActionListener();
        Press.addActionListener(listener); 
        return Press;
    }
    
   
}
