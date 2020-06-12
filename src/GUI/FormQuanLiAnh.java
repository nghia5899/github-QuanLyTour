/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.AnhBLL;
import DTO.Anh;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class FormQuanLiAnh extends javax.swing.JFrame {
    ArrayList<Anh> listanh = new ArrayList<>();
    
    
    public FormQuanLiAnh() {
        initComponents();
        setLocationRelativeTo(this);
        hienthianh(listanh);
        
    }
    public void hienthianh(ArrayList<Anh> listanh){
        AnhBLL.getInstance().getListanh(listanh, "HNQN001");
            khunganh.removeAll();
            khunganh.revalidate();
            khunganh.setLayout(new FlowLayout());
        
        for (int i = 0; i < listanh.size(); i++) {
            int vitri = i;
            final JPanel p = new JPanel();
            p.setBorder(BorderFactory.createLineBorder(Color.yellow));
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            
            JLabel labelImage = new JLabel();
            labelImage.setHorizontalAlignment(JLabel.CENTER);
            p.add(labelImage);
            try {
                BufferedImage image = ImageIO.read(new File(listanh.get(vitri).getLinkanh()));
                ImageIcon icon = new ImageIcon(image.getScaledInstance(300, 200, image.SCALE_SMOOTH));
                labelImage.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
            }
            p.add(labelImage);
            JButton btnxoa = new JButton("Xóa");
            btnxoa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AnhBLL.getInstance().Xoaanh(listanh.get(vitri).getMaanh());
                }
            });
            p.add(btnxoa);
            khunganh.add(p);
            
        }
        
    }
    public void showFileJFilechooser(){
        JFileChooser fileChooser = new JFileChooser("C:\\\\Users\\\\ADMIN\\\\Documents\\\\NetBeansProjects\\\\QuanLyTour");
        Dialog dialog = new Dialog(this);
        dialog.setLocation(100,100);
        int kt =  fileChooser.showOpenDialog(this);
        if(kt == JFileChooser.APPROVE_OPTION){
            java.io.File file = fileChooser.getSelectedFile();
            AnhBLL.getInstance().ThemAnh("HNQN001", file.getAbsolutePath());
            JOptionPane.showMessageDialog(rootPane,file.getAbsoluteFile());
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

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        khunganh = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        title.setText("Quản lí ảnh và lịch trình");

        khunganh.setPreferredSize(new java.awt.Dimension(968, 230));

        javax.swing.GroupLayout khunganhLayout = new javax.swing.GroupLayout(khunganh);
        khunganh.setLayout(khunganhLayout);
        khunganhLayout.setHorizontalGroup(
            khunganhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 968, Short.MAX_VALUE)
        );
        khunganhLayout.setVerticalGroup(
            khunganhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(khunganh);

        btnthem.setText("Thêm ảnh");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        showFileJFilechooser();
        hienthianh(listanh);
        JOptionPane.showMessageDialog(rootPane,listanh.size());
    }//GEN-LAST:event_btnthemActionPerformed

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
            java.util.logging.Logger.getLogger(FormQuanLiAnh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLiAnh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLiAnh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLiAnh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQuanLiAnh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnthem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel khunganh;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
