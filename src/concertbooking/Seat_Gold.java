/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertbooking;

/**
 *
 * @author Stuart
 */
public class Seat_Gold extends Seat{
    
    final double price = 30.00;
    
    public Seat_Gold(){
        
        //Sets the seats colour to gold.
        this.setBackground(new java.awt.Color(240, 160, 36));
    
    }
    
}
