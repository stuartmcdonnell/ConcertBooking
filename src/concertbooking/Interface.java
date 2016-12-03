/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertbooking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Stuart
 */
public class Interface extends javax.swing.JFrame {

    ArrayList Seats;
    ArrayList Seats_Bronze;
    ArrayList Seats_Silver;
    ArrayList Seats_Gold;
    ParseBookings pb = new ParseBookings();
    Interface_Settings settings_interface = new Interface_Settings(this);
    Reporting reporting = new Reporting();
    
    private float price_bronze;float price_silver;float price_gold;
    
    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
        this.setup();
        this.addSeatListeners();
    }
    
    public void setup(){
        settings_interface.loadSettings();
        Seats = pb.load();
        Seats_Bronze = (ArrayList) Seats.get(0);
        Seats_Silver = (ArrayList) Seats.get(1);
        Seats_Gold = (ArrayList) Seats.get(2);
        
        
        populateSeats();
        resetReporting();
        
    }
    
    private void resetReporting(){
        Reporting r_ = new Reporting();
        r_.setup(Seats, settings_interface);
        this.reporting = r_;
        this.Reporting_TotalBookings.setText(Integer.toString(this.reporting.getTotalBookings()));
        this.Reporting_TotalSeatsAv.setText(Integer.toString(this.reporting.getTotalSeatsAv()));
        this.Reporting_TotalTakings.setText("£"+Float.toString(this.reporting.getTotalTakings()));
    }
    
    Seat[] bronzelist_;
    Seat[] silverlist_;
    Seat[] goldlist_;
    
    private void populateSeats() {
        
        bronzelist_ = new Seat[]{
            this.seat_Bronze1,
            this.seat_Bronze2,
            this.seat_Bronze3,
            this.seat_Bronze4,
            this.seat_Bronze5,
            this.seat_Bronze6,
            this.seat_Bronze7,
            this.seat_Bronze8,
            this.seat_Bronze9,
            this.seat_Bronze10,
            this.seat_Bronze11,
            this.seat_Bronze12,
            this.seat_Bronze13,
            this.seat_Bronze14,
            this.seat_Bronze15,
            this.seat_Bronze16,
            this.seat_Bronze17,
            this.seat_Bronze18,
            this.seat_Bronze19,
            this.seat_Bronze20,
            this.seat_Bronze21,
            this.seat_Bronze22,
            this.seat_Bronze23,
            this.seat_Bronze24,
            this.seat_Bronze25,
            this.seat_Bronze26,
            this.seat_Bronze27,
            this.seat_Bronze28,
            this.seat_Bronze29,
            this.seat_Bronze30,};

		//Creates a List of silver seats.
        silverlist_ = new Seat[]{
            this.seat_Silver1,
            this.seat_Silver2,
            this.seat_Silver3,
            this.seat_Silver4,
            this.seat_Silver5,
            this.seat_Silver6,
            this.seat_Silver7,
            this.seat_Silver8,
            this.seat_Silver9,
            this.seat_Silver10,
            this.seat_Silver11,
            this.seat_Silver12,
            this.seat_Silver13,
            this.seat_Silver14,
            this.seat_Silver15,
            this.seat_Silver16,
            this.seat_Silver17,
            this.seat_Silver18,
            this.seat_Silver19,
            this.seat_Silver20,
            this.seat_Silver21,
            this.seat_Silver22,
            this.seat_Silver23,
            this.seat_Silver24,
            this.seat_Silver25,
            this.seat_Silver26,
            this.seat_Silver27,
            this.seat_Silver28,
            this.seat_Silver29,
            this.seat_Silver30,};

		        //Create a list of gold seats
        goldlist_ = new Seat[]{
            this.seat_Gold1,
            this.seat_Gold2,
            this.seat_Gold3,
            this.seat_Gold4,
            this.seat_Gold5,
            this.seat_Gold6,
            this.seat_Gold7,
            this.seat_Gold8,
            this.seat_Gold9,
            this.seat_Gold10,
            this.seat_Gold11,
            this.seat_Gold12,
            this.seat_Gold13,
            this.seat_Gold14,
            this.seat_Gold15,
            this.seat_Gold16,
            this.seat_Gold17,
            this.seat_Gold18,
            this.seat_Gold19,
            this.seat_Gold20,
            this.seat_Gold21,
            this.seat_Gold22,
            this.seat_Gold23,
            this.seat_Gold24,
            this.seat_Gold25,
            this.seat_Gold26,
            this.seat_Gold27,
            this.seat_Gold28,
            this.seat_Gold29,
            this.seat_Gold30,
        };
        

        System.out.println("Populating Seats...");

        //Assigning each bronze seat its event.
        try {
            for (int x = 0; x < this.Seats_Bronze.size(); x = x + 1) {
                Seat_Bronze seatbronze_ = (Seat_Bronze) Seats_Bronze.get(x);
                
                if(seatbronze_.getBooked()){
                    //bronzelist_[x].setEnabled(false);
                    bronzelist_[x].setBookedOverride(true, seatbronze_.getBookingName());
                }else{
                    //bronzelist_[x].setEnabled(true);
                    bronzelist_[x].setBookedOverride(false, null);
                }
                
                bronzelist_[x].setID(seatbronze_.getID());
                bronzelist_[x].setPrice(this.price_bronze);

                //bronzelist_[x].addActionListener(new SeatListener());
 
                
  
                //bronzelist_[x].setText(Integer.toString(seatbronze_.getID()));
                bronzelist_[x].setType("bronze");
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        //Bronze Finished
        
       
        
        //Assigning each silver seat its event.
        try {
            for (int x = 0; x < this.Seats_Silver.size(); x = x + 1) {
                Seat_Silver seatsilver_ = (Seat_Silver) Seats_Silver.get(x);

                if(seatsilver_.getBooked()){
                    //silverlist_[x].setEnabled(false);
                    silverlist_[x].setBookedOverride(true, seatsilver_.getBookingName());
                }else{
                    //silverlist_[x].setEnabled(true);
                    silverlist_[x].setBookedOverride(false, null);
                }   
                silverlist_[x].setID(seatsilver_.getID());
                silverlist_[x].setPrice(this.price_silver);
                //silverlist_[x].addActionListener(new SeatListener());                
                //silverlist_[x].setText(Integer.toString(seatsilver_.getID()));
                silverlist_[x].setType("silver");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        //Silver Complete
        
        
        //Assigning each gold seat its event.
        try {
            for (int x = 0; x < this.Seats_Gold.size(); x = x + 1) {
                Seat_Gold seatgold_ = (Seat_Gold) Seats_Gold.get(x);
               
                if(seatgold_.getBooked()){
                    //goldlist_[x].setEnabled(false);
                    goldlist_[x].setBookedOverride(true, seatgold_.getBookingName());
                }else{
                    //goldlist_[x].setEnabled(true);
                    goldlist_[x].setBookedOverride(false, null);
                }
                
                goldlist_[x].setID(seatgold_.getID());
                goldlist_[x].setPrice(this.price_gold);
                //goldlist_[x].addActionListener(new SeatListener());
                //goldlist_[x].setText(Integer.toString(seatgold_.getID()));
                goldlist_[x].setType("gold");
            }
                
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        //Gold Complete


        //Seat Population Complete.
        System.out.println("Seat Population Complete.");
    }
    
    public void applySettings(String title, float bronze, float silver, float gold, String date){
        this.Title_EventName.setText(title);
        this.Title_EventDate.setText(date);
        this.price_bronze=bronze;
        this.price_silver=silver;
        this.price_gold=gold;
    }
    
    public void bookSeat(int ID, String bookingname){
        System.out.println(bookingname);
        if(ID<30){
            Seat_Bronze sb = (Seat_Bronze) Seats_Bronze.get(ID);
            sb.setBooked(true, bookingname);
            Seats_Bronze.set(ID, sb);
        }else if(ID>=30 && ID<60){
            Seat_Silver ss = (Seat_Silver) Seats_Silver.get(ID-30);
            ss.setBooked(true, bookingname);
            Seats_Silver.set(ID-30, ss);
        }else{
            Seat_Gold sg = (Seat_Gold) Seats_Gold.get(ID-60);
            sg.setBooked(true, bookingname);
            Seats_Gold.set(ID-60, sg);
            
            Random rn = new Random();
            int rdn = rn.nextInt(10 - 1 + 1)+1;
            if(rdn == 1){
                JOptionPane.showMessageDialog(rootPane, "WIN: BACK-STAGE PASS");
                
            }
            
        }
        pb.save(Seats);
    }
    
    public void unbookSeat(int ID) {
        if (ID < 30) {
            JOptionPane.showMessageDialog(null, "Bronze Seats Cannot Be Unbooked");
        } else if (ID >= 30 && ID < 60) {
            Seat_Silver ss = (Seat_Silver) Seats_Silver.get(ID - 30);
            ss.setBooked(false, null);
            Seats_Silver.set(ID - 30, ss);
        } else {
            Seat_Gold sg = (Seat_Gold) Seats_Gold.get(ID-60);
            sg.setBooked(false, null);
            Seats_Gold.set(ID-60, sg);
        }
        pb.save(Seats);
    }
    
    private String getBookingName(Seat s){
        JFrame bookingframe = new JFrame("Booking Details");
        String bookingname = JOptionPane.showInputDialog(
                bookingframe,
                "Please Enter Surname: \nSeat Price: £"+s.getPrice(),
                "Booking Details",
                JOptionPane.INFORMATION_MESSAGE
        );
             return bookingname;   
    }
    
    
    private void addSeatListeners(){
        for (int x = 0; x < this.Seats_Bronze.size(); x = x + 1) {
            Seat_Bronze seatbronze_ = (Seat_Bronze) Seats_Bronze.get(x);

            bronzelist_[x].addActionListener(new SeatListener());

        }
        
        for (int x = 0; x < this.Seats_Silver.size(); x = x + 1) {
                Seat_Silver seatsilver_ = (Seat_Silver) Seats_Silver.get(x);

                silverlist_[x].addActionListener(new SeatListener());                

            }
        
        for (int x = 0; x < this.Seats_Gold.size(); x = x + 1) {
                Seat_Gold seatgold_ = (Seat_Gold) Seats_Gold.get(x);
               
                goldlist_[x].addActionListener(new SeatListener());

            }
    }
    


    //Fires when a seat is clicked.
    private class SeatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            Seat s = (Seat) e.getSource();
            System.out.println("Seat Fired. Booked: "+s.getBooked());
            
            if (s.getBooked() == true) {
                    //JOptionPane.showMessageDialog(null, "Seat Already Booked\n Booking Name: "+s.getBookingName());
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "SEAT ALREADY BOOKED \nBooking Name: "+s.getBookingName()+"\nWould You Like to Remove the Booking?","Booking Details",dialogButton);

                if (dialogResult == JOptionPane.YES_OPTION) {
                      Interface.this.unbookSeat(s.getID());
                }
                    
            } else {
                String bookingname_ = Interface.this.getBookingName(s);

                if ((bookingname_ == null) || (bookingname_.isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Booking Name Invalid!");
                } else {
                    Interface.this.bookSeat(s.getID(), bookingname_);
                }
            }
            
            Interface.this.populateSeats();
            resetReporting();
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_Settings = new javax.swing.JButton();
        Panel_Main = new javax.swing.JTabbedPane();
        Panel_Bookings = new javax.swing.JPanel();
        seat_Bronze1 = new concertbooking.Seat_Bronze();
        seat_Bronze2 = new concertbooking.Seat_Bronze();
        seat_Bronze3 = new concertbooking.Seat_Bronze();
        seat_Bronze4 = new concertbooking.Seat_Bronze();
        seat_Bronze5 = new concertbooking.Seat_Bronze();
        seat_Bronze6 = new concertbooking.Seat_Bronze();
        seat_Bronze7 = new concertbooking.Seat_Bronze();
        seat_Bronze8 = new concertbooking.Seat_Bronze();
        seat_Bronze9 = new concertbooking.Seat_Bronze();
        seat_Bronze10 = new concertbooking.Seat_Bronze();
        seat_Bronze11 = new concertbooking.Seat_Bronze();
        seat_Bronze12 = new concertbooking.Seat_Bronze();
        seat_Bronze13 = new concertbooking.Seat_Bronze();
        seat_Bronze14 = new concertbooking.Seat_Bronze();
        seat_Bronze15 = new concertbooking.Seat_Bronze();
        seat_Bronze16 = new concertbooking.Seat_Bronze();
        seat_Bronze17 = new concertbooking.Seat_Bronze();
        seat_Bronze18 = new concertbooking.Seat_Bronze();
        seat_Bronze19 = new concertbooking.Seat_Bronze();
        seat_Bronze20 = new concertbooking.Seat_Bronze();
        seat_Bronze21 = new concertbooking.Seat_Bronze();
        seat_Bronze22 = new concertbooking.Seat_Bronze();
        seat_Bronze23 = new concertbooking.Seat_Bronze();
        seat_Bronze24 = new concertbooking.Seat_Bronze();
        seat_Bronze25 = new concertbooking.Seat_Bronze();
        seat_Bronze26 = new concertbooking.Seat_Bronze();
        seat_Bronze27 = new concertbooking.Seat_Bronze();
        seat_Bronze28 = new concertbooking.Seat_Bronze();
        seat_Bronze29 = new concertbooking.Seat_Bronze();
        seat_Bronze30 = new concertbooking.Seat_Bronze();
        seat_Silver1 = new concertbooking.Seat_Silver();
        seat_Silver2 = new concertbooking.Seat_Silver();
        seat_Silver3 = new concertbooking.Seat_Silver();
        seat_Silver4 = new concertbooking.Seat_Silver();
        seat_Silver5 = new concertbooking.Seat_Silver();
        seat_Silver6 = new concertbooking.Seat_Silver();
        seat_Silver7 = new concertbooking.Seat_Silver();
        seat_Silver8 = new concertbooking.Seat_Silver();
        seat_Silver9 = new concertbooking.Seat_Silver();
        seat_Silver10 = new concertbooking.Seat_Silver();
        seat_Silver12 = new concertbooking.Seat_Silver();
        seat_Silver14 = new concertbooking.Seat_Silver();
        seat_Silver13 = new concertbooking.Seat_Silver();
        seat_Silver11 = new concertbooking.Seat_Silver();
        seat_Silver15 = new concertbooking.Seat_Silver();
        seat_Silver18 = new concertbooking.Seat_Silver();
        seat_Silver17 = new concertbooking.Seat_Silver();
        seat_Silver19 = new concertbooking.Seat_Silver();
        seat_Silver16 = new concertbooking.Seat_Silver();
        seat_Silver20 = new concertbooking.Seat_Silver();
        seat_Silver23 = new concertbooking.Seat_Silver();
        seat_Silver22 = new concertbooking.Seat_Silver();
        seat_Silver25 = new concertbooking.Seat_Silver();
        seat_Silver24 = new concertbooking.Seat_Silver();
        seat_Silver21 = new concertbooking.Seat_Silver();
        seat_Silver28 = new concertbooking.Seat_Silver();
        seat_Silver27 = new concertbooking.Seat_Silver();
        seat_Silver26 = new concertbooking.Seat_Silver();
        seat_Silver29 = new concertbooking.Seat_Silver();
        seat_Silver30 = new concertbooking.Seat_Silver();
        seat_Gold1 = new concertbooking.Seat_Gold();
        seat_Gold2 = new concertbooking.Seat_Gold();
        seat_Gold3 = new concertbooking.Seat_Gold();
        seat_Gold4 = new concertbooking.Seat_Gold();
        seat_Gold5 = new concertbooking.Seat_Gold();
        seat_Gold6 = new concertbooking.Seat_Gold();
        seat_Gold7 = new concertbooking.Seat_Gold();
        seat_Gold8 = new concertbooking.Seat_Gold();
        seat_Gold9 = new concertbooking.Seat_Gold();
        seat_Gold10 = new concertbooking.Seat_Gold();
        seat_Gold11 = new concertbooking.Seat_Gold();
        seat_Gold15 = new concertbooking.Seat_Gold();
        seat_Gold14 = new concertbooking.Seat_Gold();
        seat_Gold12 = new concertbooking.Seat_Gold();
        seat_Gold13 = new concertbooking.Seat_Gold();
        seat_Gold18 = new concertbooking.Seat_Gold();
        seat_Gold19 = new concertbooking.Seat_Gold();
        seat_Gold16 = new concertbooking.Seat_Gold();
        seat_Gold17 = new concertbooking.Seat_Gold();
        seat_Gold20 = new concertbooking.Seat_Gold();
        seat_Gold25 = new concertbooking.Seat_Gold();
        seat_Gold23 = new concertbooking.Seat_Gold();
        seat_Gold24 = new concertbooking.Seat_Gold();
        seat_Gold22 = new concertbooking.Seat_Gold();
        seat_Gold21 = new concertbooking.Seat_Gold();
        seat_Gold29 = new concertbooking.Seat_Gold();
        seat_Gold27 = new concertbooking.Seat_Gold();
        seat_Gold30 = new concertbooking.Seat_Gold();
        seat_Gold28 = new concertbooking.Seat_Gold();
        seat_Gold26 = new concertbooking.Seat_Gold();
        Panel_Reports = new javax.swing.JPanel();
        reporting_lab = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Reporting_TotalBookings = new javax.swing.JLabel();
        Reporting_TotalSeatsAv = new javax.swing.JLabel();
        Reporting_TotalTakings = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Button_ReportingGetSeat = new javax.swing.JButton();
        Input_Reporting_Isle = new javax.swing.JComboBox();
        Input_Reporting_SeatNo = new javax.swing.JComboBox();
        reporting_lab1 = new javax.swing.JLabel();
        reporting_lab2 = new javax.swing.JLabel();
        reporting_lab3 = new javax.swing.JLabel();
        reporting_lab4 = new javax.swing.JLabel();
        Reporting_SeatBooked = new javax.swing.JCheckBox();
        Reporting_BookingName = new javax.swing.JLabel();
        Reporting_Programme = new javax.swing.JCheckBox();
        Reporting_Backstage = new javax.swing.JCheckBox();
        Title_EventDate = new javax.swing.JLabel();
        Title_EventName = new javax.swing.JLabel();
        Button_Clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booking System");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Button_Settings.setText("Event Setup");
        Button_Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SettingsActionPerformed(evt);
            }
        });

        Panel_Main.setPreferredSize(new java.awt.Dimension(657, 654));
        Panel_Main.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Panel_MainStateChanged(evt);
            }
        });

        seat_Bronze4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout Panel_BookingsLayout = new javax.swing.GroupLayout(Panel_Bookings);
        Panel_Bookings.setLayout(Panel_BookingsLayout);
        Panel_BookingsLayout.setHorizontalGroup(
            Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BookingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BookingsLayout.createSequentialGroup()
                        .addComponent(seat_Bronze10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(seat_Bronze5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BookingsLayout.createSequentialGroup()
                        .addComponent(seat_Bronze17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seat_Bronze15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BookingsLayout.createSequentialGroup()
                        .addComponent(seat_Bronze30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seat_Bronze21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Bronze23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BookingsLayout.createSequentialGroup()
                        .addComponent(seat_Silver10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seat_Silver5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BookingsLayout.createSequentialGroup()
                        .addComponent(seat_Silver20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seat_Silver15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BookingsLayout.createSequentialGroup()
                        .addComponent(seat_Silver30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seat_Silver25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Silver21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BookingsLayout.createSequentialGroup()
                        .addComponent(seat_Gold10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seat_Gold5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BookingsLayout.createSequentialGroup()
                        .addComponent(seat_Gold20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seat_Gold15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BookingsLayout.createSequentialGroup()
                        .addComponent(seat_Gold30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seat_Gold25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat_Gold21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Panel_BookingsLayout.setVerticalGroup(
            Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BookingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_Bronze1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_Bronze11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_Bronze23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Bronze30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_Silver1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_Silver11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_Silver21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Silver30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_Gold1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_Gold11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_Gold20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(seat_Gold26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seat_Gold27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seat_Gold28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seat_Gold29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seat_Gold30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_BookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(seat_Gold21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seat_Gold22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seat_Gold23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seat_Gold24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seat_Gold25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_Main.addTab("Bookings", Panel_Bookings);

        reporting_lab.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        reporting_lab.setText("Total Takings:");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Total Seats Available:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Total Bookings:");

        Reporting_TotalBookings.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Reporting_TotalBookings.setText("0");

        Reporting_TotalSeatsAv.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Reporting_TotalSeatsAv.setText("0");

        Reporting_TotalTakings.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Reporting_TotalTakings.setText("0");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Button_ReportingGetSeat.setText("Get Seat Details");
        Button_ReportingGetSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ReportingGetSeatActionPerformed(evt);
            }
        });

        Input_Reporting_Isle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" }));

        Input_Reporting_SeatNo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        reporting_lab1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        reporting_lab1.setText("Seat Booked:");

        reporting_lab2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        reporting_lab2.setText("Booking Name:");

        reporting_lab3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        reporting_lab3.setText("Free Programme:");

        reporting_lab4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        reporting_lab4.setText("Backstage Pass:");

        Reporting_SeatBooked.setEnabled(false);

        Reporting_BookingName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Reporting_BookingName.setText(".....");

        Reporting_Programme.setEnabled(false);

        Reporting_Backstage.setEnabled(false);

        javax.swing.GroupLayout Panel_ReportsLayout = new javax.swing.GroupLayout(Panel_Reports);
        Panel_Reports.setLayout(Panel_ReportsLayout);
        Panel_ReportsLayout.setHorizontalGroup(
            Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(reporting_lab)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Reporting_TotalBookings)
                    .addComponent(Reporting_TotalSeatsAv)
                    .addComponent(Reporting_TotalTakings))
                .addGap(138, 138, 138)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ReportsLayout.createSequentialGroup()
                        .addComponent(reporting_lab3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Reporting_Programme))
                    .addGroup(Panel_ReportsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_ReportsLayout.createSequentialGroup()
                                .addComponent(reporting_lab4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Reporting_Backstage))
                            .addGroup(Panel_ReportsLayout.createSequentialGroup()
                                .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(reporting_lab1)
                                    .addComponent(reporting_lab2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Reporting_SeatBooked)
                                    .addComponent(Reporting_BookingName)))
                            .addGroup(Panel_ReportsLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(Button_ReportingGetSeat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Input_Reporting_Isle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Input_Reporting_SeatNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        Panel_ReportsLayout.setVerticalGroup(
            Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ReportsLayout.createSequentialGroup()
                .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ReportsLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Reporting_TotalBookings))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Reporting_TotalSeatsAv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reporting_lab)
                            .addComponent(Reporting_TotalTakings)))
                    .addGroup(Panel_ReportsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button_ReportingGetSeat)
                            .addComponent(Input_Reporting_Isle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Input_Reporting_SeatNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reporting_lab1)
                            .addComponent(Reporting_SeatBooked))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reporting_lab2)
                            .addComponent(Reporting_BookingName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reporting_lab3)
                            .addComponent(Reporting_Programme))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reporting_lab4)
                            .addComponent(Reporting_Backstage)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(395, Short.MAX_VALUE))
        );

        Panel_Main.addTab("Reports", Panel_Reports);

        Title_EventDate.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Title_EventDate.setText("01/01/2017");

        Title_EventName.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Title_EventName.setText("Event Title");

        Button_Clear.setText("New Event");
        Button_Clear.setFocusPainted(false);
        Button_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Title_EventName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Title_EventDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_Clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Settings)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title_EventName)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Button_Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Button_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Title_EventDate, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SettingsActionPerformed
      settings_interface.setVisible(true);
    }//GEN-LAST:event_Button_SettingsActionPerformed

    private void Button_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ClearActionPerformed
            pb.clearBookings();
            settings_interface.clearSettings();
            Seats_Bronze.clear();Seats_Silver.clear();Seats_Gold.clear();Seats.clear();
            this.setup();
    }//GEN-LAST:event_Button_ClearActionPerformed

    private void Panel_MainStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Panel_MainStateChanged
        
    }//GEN-LAST:event_Panel_MainStateChanged

    private void Button_ReportingGetSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ReportingGetSeatActionPerformed
        int id = reporting.getSeatID(this.Input_Reporting_Isle.getSelectedItem().toString(), Integer.parseInt(this.Input_Reporting_SeatNo.getSelectedItem().toString()));
        Seat s_ =reporting.getSeatDetails(id);
        this.Reporting_SeatBooked.setSelected(s_.getBooked());
        this.Reporting_BookingName.setText(s_.getBookingName());
        //Programme and Backstage pass to be finished.
    }//GEN-LAST:event_Button_ReportingGetSeatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Clear;
    private javax.swing.JButton Button_ReportingGetSeat;
    private javax.swing.JButton Button_Settings;
    private javax.swing.JComboBox Input_Reporting_Isle;
    private javax.swing.JComboBox Input_Reporting_SeatNo;
    private javax.swing.JPanel Panel_Bookings;
    private javax.swing.JTabbedPane Panel_Main;
    private javax.swing.JPanel Panel_Reports;
    private javax.swing.JCheckBox Reporting_Backstage;
    private javax.swing.JLabel Reporting_BookingName;
    private javax.swing.JCheckBox Reporting_Programme;
    private javax.swing.JCheckBox Reporting_SeatBooked;
    private javax.swing.JLabel Reporting_TotalBookings;
    private javax.swing.JLabel Reporting_TotalSeatsAv;
    private javax.swing.JLabel Reporting_TotalTakings;
    private javax.swing.JLabel Title_EventDate;
    private javax.swing.JLabel Title_EventName;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel reporting_lab;
    private javax.swing.JLabel reporting_lab1;
    private javax.swing.JLabel reporting_lab2;
    private javax.swing.JLabel reporting_lab3;
    private javax.swing.JLabel reporting_lab4;
    private concertbooking.Seat_Bronze seat_Bronze1;
    private concertbooking.Seat_Bronze seat_Bronze10;
    private concertbooking.Seat_Bronze seat_Bronze11;
    private concertbooking.Seat_Bronze seat_Bronze12;
    private concertbooking.Seat_Bronze seat_Bronze13;
    private concertbooking.Seat_Bronze seat_Bronze14;
    private concertbooking.Seat_Bronze seat_Bronze15;
    private concertbooking.Seat_Bronze seat_Bronze16;
    private concertbooking.Seat_Bronze seat_Bronze17;
    private concertbooking.Seat_Bronze seat_Bronze18;
    private concertbooking.Seat_Bronze seat_Bronze19;
    private concertbooking.Seat_Bronze seat_Bronze2;
    private concertbooking.Seat_Bronze seat_Bronze20;
    private concertbooking.Seat_Bronze seat_Bronze21;
    private concertbooking.Seat_Bronze seat_Bronze22;
    private concertbooking.Seat_Bronze seat_Bronze23;
    private concertbooking.Seat_Bronze seat_Bronze24;
    private concertbooking.Seat_Bronze seat_Bronze25;
    private concertbooking.Seat_Bronze seat_Bronze26;
    private concertbooking.Seat_Bronze seat_Bronze27;
    private concertbooking.Seat_Bronze seat_Bronze28;
    private concertbooking.Seat_Bronze seat_Bronze29;
    private concertbooking.Seat_Bronze seat_Bronze3;
    private concertbooking.Seat_Bronze seat_Bronze30;
    private concertbooking.Seat_Bronze seat_Bronze4;
    private concertbooking.Seat_Bronze seat_Bronze5;
    private concertbooking.Seat_Bronze seat_Bronze6;
    private concertbooking.Seat_Bronze seat_Bronze7;
    private concertbooking.Seat_Bronze seat_Bronze8;
    private concertbooking.Seat_Bronze seat_Bronze9;
    private concertbooking.Seat_Gold seat_Gold1;
    private concertbooking.Seat_Gold seat_Gold10;
    private concertbooking.Seat_Gold seat_Gold11;
    private concertbooking.Seat_Gold seat_Gold12;
    private concertbooking.Seat_Gold seat_Gold13;
    private concertbooking.Seat_Gold seat_Gold14;
    private concertbooking.Seat_Gold seat_Gold15;
    private concertbooking.Seat_Gold seat_Gold16;
    private concertbooking.Seat_Gold seat_Gold17;
    private concertbooking.Seat_Gold seat_Gold18;
    private concertbooking.Seat_Gold seat_Gold19;
    private concertbooking.Seat_Gold seat_Gold2;
    private concertbooking.Seat_Gold seat_Gold20;
    private concertbooking.Seat_Gold seat_Gold21;
    private concertbooking.Seat_Gold seat_Gold22;
    private concertbooking.Seat_Gold seat_Gold23;
    private concertbooking.Seat_Gold seat_Gold24;
    private concertbooking.Seat_Gold seat_Gold25;
    private concertbooking.Seat_Gold seat_Gold26;
    private concertbooking.Seat_Gold seat_Gold27;
    private concertbooking.Seat_Gold seat_Gold28;
    private concertbooking.Seat_Gold seat_Gold29;
    private concertbooking.Seat_Gold seat_Gold3;
    private concertbooking.Seat_Gold seat_Gold30;
    private concertbooking.Seat_Gold seat_Gold4;
    private concertbooking.Seat_Gold seat_Gold5;
    private concertbooking.Seat_Gold seat_Gold6;
    private concertbooking.Seat_Gold seat_Gold7;
    private concertbooking.Seat_Gold seat_Gold8;
    private concertbooking.Seat_Gold seat_Gold9;
    private concertbooking.Seat_Silver seat_Silver1;
    private concertbooking.Seat_Silver seat_Silver10;
    private concertbooking.Seat_Silver seat_Silver11;
    private concertbooking.Seat_Silver seat_Silver12;
    private concertbooking.Seat_Silver seat_Silver13;
    private concertbooking.Seat_Silver seat_Silver14;
    private concertbooking.Seat_Silver seat_Silver15;
    private concertbooking.Seat_Silver seat_Silver16;
    private concertbooking.Seat_Silver seat_Silver17;
    private concertbooking.Seat_Silver seat_Silver18;
    private concertbooking.Seat_Silver seat_Silver19;
    private concertbooking.Seat_Silver seat_Silver2;
    private concertbooking.Seat_Silver seat_Silver20;
    private concertbooking.Seat_Silver seat_Silver21;
    private concertbooking.Seat_Silver seat_Silver22;
    private concertbooking.Seat_Silver seat_Silver23;
    private concertbooking.Seat_Silver seat_Silver24;
    private concertbooking.Seat_Silver seat_Silver25;
    private concertbooking.Seat_Silver seat_Silver26;
    private concertbooking.Seat_Silver seat_Silver27;
    private concertbooking.Seat_Silver seat_Silver28;
    private concertbooking.Seat_Silver seat_Silver29;
    private concertbooking.Seat_Silver seat_Silver3;
    private concertbooking.Seat_Silver seat_Silver30;
    private concertbooking.Seat_Silver seat_Silver4;
    private concertbooking.Seat_Silver seat_Silver5;
    private concertbooking.Seat_Silver seat_Silver6;
    private concertbooking.Seat_Silver seat_Silver7;
    private concertbooking.Seat_Silver seat_Silver8;
    private concertbooking.Seat_Silver seat_Silver9;
    // End of variables declaration//GEN-END:variables

}
