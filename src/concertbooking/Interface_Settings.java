/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertbooking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Stuart
 */
public class Interface_Settings extends javax.swing.JFrame {

    /**
     * Creates new form Interface_Settings
     * @param intface_
     */
    public Interface_Settings(Interface intface_) {
        initComponents();
        this.intface=intface_;
    }

    Interface intface;
    String setting_title;
    float setting_bronzeprice;
    float setting_silverprice;
    float setting_goldprice;
    String setting_date;
    
    public void setInterface(Interface intface_){
        this.intface = intface_;
    }
    
    public Interface getInterface(){
        return this.intface;
    }
    
    public void clearSettings() {
        FileWriter writer = null;
        try {
            File settingsfile = new File("settings.txt");
            writer = new FileWriter(settingsfile);
            String defaultsettings = ("Press Event Setup to Begin"
                    + "\n10"
                    + "\n20"
                    + "\n30"
                    + "\n01/01/17");
            writer.write(defaultsettings);
            writer.flush();
            writer.close();
            this.setting_title = "Press Event Setup to Begin";
            this.setting_bronzeprice = 10;
            this.setting_silverprice = 20;
            this.setting_goldprice = 30;
            this.setting_date = "01/01/17";
            intface.applySettings(setting_title, setting_bronzeprice, setting_silverprice, setting_goldprice, setting_date);
        } catch (IOException ex) {
            Logger.getLogger(Interface_Settings.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Interface_Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        Input_Name = new javax.swing.JFormattedTextField();
        Input_Date = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Input_Bronze = new javax.swing.JFormattedTextField();
        Input_Silver = new javax.swing.JFormattedTextField();
        Input_Gold = new javax.swing.JFormattedTextField();
        Button_Apply = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Event Setup");
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel1.setText("EVENT SETUP");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Event Name:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Event Date:");

        try {
            Input_Name.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("******************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Input_Name.setText("Event Name Max 30 Chars       ");

        Input_Date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        Input_Date.setText("01/01/17");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Silver Price:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Bronze Price:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Gold Price:");

        Input_Bronze.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        Input_Bronze.setText("0.00");

        Input_Silver.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        Input_Silver.setText("0.00");

        Input_Gold.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        Input_Gold.setText("0.00");

        Button_Apply.setText("Save Settings");
        Button_Apply.setEnabled(false);
        Button_Apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Input_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Input_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button_Apply)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Input_Gold, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Input_Bronze)
                            .addComponent(Input_Silver, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(181, 181, 181))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Button_Apply, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Input_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Input_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Input_Bronze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Input_Silver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Input_Gold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ApplyActionPerformed
        this.updateSettings();
        this.setVisible(false);
    }//GEN-LAST:event_Button_ApplyActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if (this.Input_Name.isEditValid() && this.Input_Date.isEditValid() && this.Input_Bronze.isEditValid() && this.Input_Silver.isEditValid() && this.Input_Gold.isEditValid()) {
            this.Button_Apply.setEnabled(true);
        } else {
            this.Button_Apply.setEnabled(false);
        }
    }//GEN-LAST:event_formMouseMoved

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }
    
    private void updateSettings(){
        this.setting_title=this.Input_Name.getText();
        this.setting_bronzeprice=Float.parseFloat(this.Input_Bronze.getText());
        this.setting_silverprice=Float.parseFloat(this.Input_Silver.getText());
        this.setting_goldprice=Float.parseFloat(this.Input_Gold.getText());
        this.setting_date=this.Input_Date.getText();
        
        intface.applySettings(setting_title, setting_bronzeprice, setting_silverprice, setting_goldprice, setting_date);
        saveSettings();
        intface.setup();
    }
    
    public void loadSettings(){
        File settingsfile = new File("settings.txt");
        try{
            if(settingsfile.createNewFile()){
                System.out.println("Settings file doesnt exist, creating...");
                
                FileWriter writer = new FileWriter(settingsfile);
                String defaultsettings = (
                        "Press Event Setup to Begin"+
                        "\n10"+
                        "\n20"+
                        "\n30"+
                        "\n01/01/17"
                        );
                writer.write(defaultsettings);
                writer.flush();
                writer.close();
                
                this.setting_title="Press Event Setup to Begin";
                this.setting_bronzeprice=10;
                this.setting_silverprice=20;
                this.setting_goldprice=30;
                this.setting_date="01/01/17";
                
                intface.applySettings(setting_title, setting_bronzeprice, setting_silverprice, setting_goldprice, setting_date);
                
            }else{
                System.out.println("Settings file exists. Will load...");
                
                File file = new File("settings.txt");
                FileReader filereader = new FileReader(file);
                BufferedReader bufferedreader = new BufferedReader(filereader);
                
                String buffer;int index=0;
                while((buffer = bufferedreader.readLine()) != null){
                    if(index==0){
                        this.setting_title=buffer;index++;
                    }else if(index == 1){
                        this.setting_bronzeprice=Float.parseFloat(buffer);index++;
                    }else if(index == 2){
                        this.setting_silverprice=Float.parseFloat(buffer);index++;
                    }else if(index == 3){
                        this.setting_goldprice=Float.parseFloat(buffer);index++;
                    }else if(index == 4){
                        this.setting_date=buffer;index++;
                    }
                          
                }
                System.out.println("Settings Loaded... ");
                this.Input_Name.setText(this.setting_title);
                this.Input_Bronze.setText(Float.toString(this.setting_bronzeprice));
                this.Input_Silver.setText(Float.toString(this.setting_silverprice));
                this.Input_Gold.setText(Float.toString(this.setting_goldprice));
                this.Input_Date.setText(this.setting_date);
                intface.applySettings(setting_title, setting_bronzeprice, setting_silverprice, setting_goldprice, setting_date);
            }
               
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public void saveSettings(){
        File settingsfile = new File("settings.txt");
        
        try {
            try (FileWriter writer = new FileWriter(settingsfile)) {
                String stringbuild = (this.setting_title+"\n"+this.setting_bronzeprice+"\n"+this.setting_silverprice+"\n"+this.setting_goldprice+"\n"+this.setting_date);
                writer.write(stringbuild);
                
                writer.flush();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Interface_Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Apply;
    private javax.swing.JFormattedTextField Input_Bronze;
    private javax.swing.JFormattedTextField Input_Date;
    private javax.swing.JFormattedTextField Input_Gold;
    private javax.swing.JFormattedTextField Input_Name;
    private javax.swing.JFormattedTextField Input_Silver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}