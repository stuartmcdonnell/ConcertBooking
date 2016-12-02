/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertbooking;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author Stuart
 */
public class Seat extends JButton {

    int ID;
    boolean booked;
    String type;
    String bookingname;
    
    public Seat() {

        //Setting the size for each seat.
        Dimension d;
        d = new Dimension(50, 50);
        this.setPreferredSize(d);

        //Sets the buttons border.
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        this.setBorder(raisedbevel);

        //Sets the seats defaults.
        this.setText(" ");
        this.bookingname="none";

    }
    
    public boolean getBooked(){
        return booked;
    }
    
    public void setBooked(boolean booked, String bookingname){
        this.booked = booked;this.bookingname=bookingname;
    }
    
    public String getBookingName(){
        return this.bookingname;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public void setID(int id_){
        this.ID = id_;
    }

    public int getID(){
        return this.ID;
    }

}
