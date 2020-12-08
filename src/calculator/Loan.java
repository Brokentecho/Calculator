package calculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Loan 
{
    private double p;
    private double r;
    private double y;
    
    private String sms="";
    
    
    public void Loan()
    {
        p = 0;
        r = 0;
        y = 0;
        sms = "";
    }
    
    public void Loan(double principle, double rate, int length)
    {
        Loan();
        
        p = principle;
        r = rate/100;
        y = length;
        
    }
    
    
    public double getPrinciple()
    {
        return p;
    }

    
    public void setPrinciple(double value)
    {
        p = value;
    }
    
    public double getRatio()
    {
        return r;
    }

    
    public void setRatio(double value)
    {
        r = value/100;
    }
    
    public double getTerm()
    {
        return y;
    }

    
    public void setTerm(double value)
    {
        y = value;
    }
    
    
    public double getLoan()
    {
        return combo(p,r,y, 0);
    }
    
    
    public double getIntrest()
    {
        return p * r * y;
    }
    
    /** Recursive calculation loan amount for each year in incentive mode
     * 
     * @param p principle of loan
     * @param r Yearly ratio of loan 
     * @param y Team of loan
     * @param i loop counter
     * @return 
     */
    private double combo(double p, double r, double y, int i)
    {
        double pp;
        
        if( i <= y)
        {
            //sms += ("\n\t" + i + "\t" + String.valueOf(p) );
            sms += String.format("\n\t%8d \t%.0f", i ,p);
            
            pp = (1+r)*p; 
            
            i++;
            
            combo(pp, r, y, i);
                                             
        }
        
            return p;
    }
    
    public String getReport()
    {
        String header = "";
        header += String.format("\n  Loan Amount($):\t%.0f", p);
        header += "\n  Intrest Rate(%):\t" + r*100;
        header += "\n  Term length (year): \t" + y;
        header += "\n  ______________________________________";
        
        String footer = "\n  ______________________________________\n";
        
        return header + sms + footer;
    }
    
}
