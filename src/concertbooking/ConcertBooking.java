/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertbooking;

import javax.swing.UIManager;

/**
 *
 * @author Stuart
 */
public class ConcertBooking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
        }
 
        Interface interface_ = new Interface();
        interface_.setVisible(true);

    }

}
