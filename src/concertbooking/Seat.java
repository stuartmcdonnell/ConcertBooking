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

    private int ID;
    private boolean booked;
    private String type;
    private String bookingname;
    private float price;
    private boolean backstage;
    private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
    public Seat() {

        //Setting the size for each seat.
        Dimension d;
        d = new Dimension(50, 50);
        this.setPreferredSize(d);

        //Sets the buttons border.
        
        this.setBorder(raisedbevel);

    }
    
    public void setBackstage(boolean backstage){
        this.backstage=backstage;
    }
    
    public boolean getBackstage(){
        return this.backstage;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public boolean getBooked() {
        return booked;
    }

    public void setBooked(boolean booked, String bookingname) {
        this.booked = booked;
        this.bookingname = bookingname;
    }

    public void setBookedOverride(boolean booked, String bookingname) {
        if (booked) {
            this.bookingname=bookingname;
            this.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 20, 20, 20, new java.awt.Color(153, 0, 51)));
        }
        this.booked = booked;
    }

    public String getBookingName() {
        return this.bookingname;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setID(int id_) {
        if(!booked){this.setBorder(raisedbevel);}
        this.ID = id_;
    }

    public int getID() {
        return this.ID;
    }

}
