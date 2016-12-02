/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertbooking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stuart
 */
public class ParseBookings {

    public ParseBookings() {

    }

    public ArrayList load() {

        //Creating Save file if doesnt exist.
        File savefile = new File("bookings.txt");
        try {
            if (savefile.createNewFile()) {
                System.out.println("Save file doesnt exist, creating...");

                try {
                    FileWriter writer = new FileWriter(savefile);

                    for (int x = 0; x <= 89; x = x + 1) {
                        String stringbuild = (x + ",false,none");
                        writer.write(stringbuild + "\n");
                    }
                    writer.flush();
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(ParseBookings.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                System.out.println("Save file exists. Will load...");
            }
        } catch (IOException ex) {
            Logger.getLogger(ParseBookings.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Loading Started...");

        ArrayList Seats = new ArrayList();
        ArrayList Seats_Bronze = new ArrayList();
        ArrayList Seats_Silver = new ArrayList();
        ArrayList Seats_Gold = new ArrayList();

        try {
            File file = new File("bookings.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufferedreader = new BufferedReader(filereader);

            String buffer;
            while ((buffer = bufferedreader.readLine()) != null) {
                String[] buffersplit = buffer.split(",", -1);
                int index = Integer.parseInt(buffersplit[0]);
                if (index < 30) {
                    //System.out.println("Bronze @ "+index);

                    Seat_Bronze bseat_ = new Seat_Bronze();
                    bseat_.setID(index);
                    bseat_.setBooked(Boolean.parseBoolean(buffersplit[1]), buffersplit[2]);
                    Seats_Bronze.add(bseat_);

                } else if (59 >= index && index > 29) {
                    //System.out.println("Silver @ "+index);

                    Seat_Silver sseat_ = new Seat_Silver();
                    sseat_.setID(index);
                    sseat_.setBooked(Boolean.parseBoolean(buffersplit[1]), buffersplit[2]);
                    Seats_Silver.add(sseat_);

                } else {
                    //System.out.println("Gold @"+index);

                    Seat_Gold gseat_ = new Seat_Gold();
                    gseat_.setID(index);
                    gseat_.setBooked(Boolean.parseBoolean(buffersplit[1]), buffersplit[2]);
                    Seats_Gold.add(gseat_);

                }

            }

            Seats.add(Seats_Bronze);
            Seats.add(Seats_Silver);
            Seats.add(Seats_Gold);
            System.out.println("Loading Complete.");
            System.out.println("Loaded B/S/G: " + Seats_Bronze.size() + "/" + Seats_Silver.size() + "/" + Seats_Gold.size());

            return Seats;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParseBookings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParseBookings.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean save(ArrayList seats_) {

        ArrayList Seats = seats_;
        File bookings_file = new File("bookings.txt");
        ArrayList Seats_Bronze = (ArrayList) Seats.get(0);
        ArrayList Seats_Silver = (ArrayList) Seats.get(1);
        ArrayList Seats_Gold = (ArrayList) Seats.get(2);

        try {
            FileWriter writer = new FileWriter(bookings_file);

            for (int x = 0; x < Seats_Bronze.size(); x = x + 1) {
                Seat_Bronze b = (Seat_Bronze) Seats_Bronze.get(x);
                String stringbuild = (b.getID() + "," + Boolean.toString(b.getBooked())+","+b.getBookingName());

                writer.write(stringbuild + "\n");
            }

            for (int x = 0; x < Seats_Silver.size(); x = x + 1) {
                Seat_Silver s = (Seat_Silver) Seats_Silver.get(x);
                String stringbuild = (s.getID() + "," + Boolean.toString(s.getBooked())+","+s.getBookingName());

                writer.write(stringbuild + "\n");
            }

            for (int x = 0; x < Seats_Gold.size(); x = x + 1) {
                Seat_Gold g = (Seat_Gold) Seats_Gold.get(x);
                String strinbuild = (g.getID() + "," + Boolean.toString(g.getBooked())+","+g.getBookingName());

                writer.write(strinbuild + "\n");
            }

            writer.flush();
            writer.close();

            return true;

        } catch (IOException ex) {
            Logger.getLogger(ParseBookings.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
