/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertbooking;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Stuart
 */
public class Reporting {

    ArrayList seats_all;
    Interface_Settings settings;
    int total_booked=0;
    float totalvalue=0;

    public Reporting() {
        seats_all = new ArrayList();
    }

    public void setup(ArrayList seats, Interface_Settings settings) {
        
        this.settings=settings;
        
        for(int i=0;i<seats.size();i++){
            ArrayList tempseats_= (ArrayList) seats.get(i);
            
            for(int x=0;x<tempseats_.size();x++){
                seats_all.add(tempseats_.get(x));
            }
        }
        
        System.out.println("Total Seats Reporting: "+this.seats_all.size());
        getReportingTotals();
        
    }
    
    public Seat getSeatDetails(int id){
        for(int i=0;i<seats_all.size();i++){
            Seat s = (Seat) seats_all.get(i);
            if(s.getID() == id-1){
                //System.out.println("Seat Details: "+s.getBookingName()+s.getBooked());
                return s;
            }
        }
        System.out.println("Seat Error");
        return null;
    }

    public void getReportingTotals() {
        
        float prices[] = settings.getPrices();
        
            for(int i=0;i<seats_all.size();i++){
                Seat tempseat = (Seat) seats_all.get(i);
                if(tempseat.getBooked()){
                    if(tempseat.getID()<30){this.totalvalue+=prices[0];}
                    else if((tempseat.getID() >= 30) && (tempseat.getID()<60)){this.totalvalue+=prices[1];}
                    else {this.totalvalue+=prices[2];}

                    this.total_booked++;
                }
            }
            //System.out.println("Reporting Totals: "+this.total_booked+","+this.totalvalue);
    }
    
    public int getTotalBookings(){
        return this.total_booked;
    }
    
    public int getTotalSeatsAv(){
        return(90-this.total_booked);
    }
    
    public float getTotalTakings(){
        return this.totalvalue;
    }
    
    public int getSeatID(String isle, int seat){
        int multi = 0;
        switch(isle){
            case("A"):
                multi=0;
                break;
            case("B"):
                multi=10;
                break;
            case("C"):
                multi=20;
                break;
            case("D"):
                multi=30;
                break;
            case("E"):
                multi=40;
                break;
            case("F"):
                multi=50;
                break;
            case("G"):
                multi=60;
                break;
            case("H"):
                multi=70;
                break;
            case("I"):
                multi=80;
                break;
        }
        return multi+seat;
    }
    
    
}
