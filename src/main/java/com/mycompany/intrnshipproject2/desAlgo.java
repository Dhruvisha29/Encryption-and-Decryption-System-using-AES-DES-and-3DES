
package com.mycompany.intrnshipproject2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.crypto.spec.IvParameterSpec;


public class desAlgo extends javax.swing.JFrame {

   
    public desAlgo() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        f_loc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        E_DSE = new javax.swing.JButton();
        D_DSE = new javax.swing.JButton();
        file_name = new javax.swing.JTextField();
        get_key = new javax.swing.JTextField();
        returnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        f_loc.setText("file location");

        jButton1.setText("choose image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("encrypt");

        jLabel2.setText("dicrypt");

        E_DSE.setText("DSE");
        E_DSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E_DSEActionPerformed(evt);
            }
        });

        D_DSE.setText("DSE");
        D_DSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D_DSEActionPerformed(evt);
            }
        });

        file_name.setText("choose name of file");

        get_key.setText("enter 8 char long key");

        returnHome.setText("return to homepage");
        returnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(f_loc)
                    .addComponent(get_key)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(E_DSE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(D_DSE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(207, 207, 207)
                        .addComponent(jLabel2))
                    .addComponent(file_name))
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(318, 318, 318))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(returnHome)
                        .addGap(302, 302, 302))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(f_loc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(get_key, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(file_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(E_DSE)
                    .addComponent(D_DSE))
                .addGap(18, 18, 18)
                .addComponent(returnHome)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        f_loc.setText(f.getAbsolutePath());

    }//GEN-LAST:event_jButton1ActionPerformed

    private void E_DSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E_DSEActionPerformed
        // TODO add your handling code here:
        try{
            FileInputStream file = new FileInputStream(f_loc.getText());

            FileOutputStream os= new FileOutputStream(file_name.getText());
            
            String s= new String();
           
            s=get_key.getText();
            byte k[]= s.getBytes();
            SecretKeySpec key = new SecretKeySpec(k,"DES");
            Cipher enc = Cipher.getInstance("DES");
            enc.init(Cipher.ENCRYPT_MODE,key);
            CipherOutputStream cos= new CipherOutputStream(os,enc);
            byte[] buf=new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf,0,read);
            }
            file.close();
            os.flush();
            cos.close();
            JOptionPane.showMessageDialog(null,"successfully");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_E_DSEActionPerformed

    private void D_DSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_DSEActionPerformed
        // TODO add your handling code here:
        try{
            FileInputStream file = new FileInputStream(f_loc.getText());
            FileOutputStream os= new FileOutputStream(file_name.getText());
            String s= new String();
           
               
            s=get_key.getText();
            byte k[]= s.getBytes();
            SecretKeySpec key = new SecretKeySpec(k,"DES");
            Cipher enc = Cipher.getInstance("DES");
            enc.init(Cipher.DECRYPT_MODE,key);
            CipherOutputStream cos= new CipherOutputStream(os,enc);
            byte[] buf=new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf,0,read);
            }
            file.close();
            os.flush();
            cos.close();
            JOptionPane.showMessageDialog(null,"successfully");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

    }//GEN-LAST:event_D_DSEActionPerformed

    private void returnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnHomeActionPerformed
        // TODO add your handling code here:
        new home().setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_returnHomeActionPerformed

   
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new desAlgo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton D_DSE;
    private javax.swing.JButton E_DSE;
    private javax.swing.JTextField f_loc;
    private javax.swing.JTextField file_name;
    private javax.swing.JTextField get_key;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton returnHome;
    // End of variables declaration//GEN-END:variables
}
