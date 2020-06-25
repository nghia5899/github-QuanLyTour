/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.AnhBLL;
import BLL.TourBLL;
import DTO.Anh;
import DTO.LichTrinh;
import DTO.Tour;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class FormChiTietTour extends javax.swing.JFrame {
    Tour tour;
    int dau=0,cuoi=3;
    ArrayList<Anh> listanh = new ArrayList<>();
    ArrayList<LichTrinh> lichtrinh;
    /**
     * Creates new form FormChiTietTour
     */
    public FormChiTietTour() {
        initComponents();
        setLocationRelativeTo(this);
    }
    
    
    public String ngayhientai() {
        Calendar lich = new GregorianCalendar();
        String ngay = lich.get(Calendar.DAY_OF_MONTH) + "";
        String thang = lich.get(Calendar.MONTH) + "";
        String nam = lich.get(Calendar.YEAR) + "";
        if (ngay.length() == 1) {
            ngay = "0" + ngay;
        }
        if (thang.length() == 1) {
            thang = "0" + thang;
        }
        String string = nam + "-" + thang + "-" + ngay;

        return string;
    }
    public void setNgayKhoihanh(java.util.Date date){
        txtngaykhoihanh.setDateFormatString("yyyy-MM-dd");
        txtngaykhoihanh.setDate(date);
    }
    
    public void getThongTinTour(String matour){
        tour = TourBLL.getInstance().getTourTheoMa(matour);
        txtMatour.setText(tour.getMatour());
        txtTenTour.setText(tour.getTentour());
        txtDiemXuatPhat.setText(tour.getDiemxuatphat());
        txtThoiGianTour.setText(tour.getThoigiantour());
        txtDiemDuLich.setText(tour.getDiemdulich());
        txtDichVu.setText(tour.getDichvu());
    }
    
    public void loadcombobox(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        int songay = TourBLL.getInstance().demsolichtrinh(tour.getMatour());
        for (int i = 0; i < songay; i++) {
            model.addElement("Ngày "+(i+1));
        }
        txtngay.setModel(model);
    }
     public void getLichTrinh(){
        lichtrinh = TourBLL.getInstance().GetLichTrinh(tour.getMatour());
        if(lichtrinh.size()>0)
            txtlichtrinh.setText(lichtrinh.get(0).getNoidung());
    }
     public boolean kt(){
        txtngaykhoihanh.setDateFormatString("yyyy-MM-dd");
        String string =null;
        try {
            java.util.Date date = txtngaykhoihanh.getDate();
            string  = new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập ngày");
            return false;
        }
        if(ngayhientai().compareTo(string)>0){
            JOptionPane.showMessageDialog(rootPane,"Ngày không hợp lệ");
            return false;
        }
        return true;
        
    }
    public int taosize(int cuoi){
        if(listanh.size()<=cuoi){
            return listanh.size();
        }else
            return cuoi;
    }
    public void hienthilistanh(){
            khunganh.removeAll();
            khunganh.revalidate();
            khunganh.repaint();
            khunganh.setLayout(new FlowLayout());
        
        try {
            AnhBLL.getInstance().getListanh(listanh, tour.getMatour());
        } catch (NullPointerException e) {
        }
        
        
        for (int i = dau; i < taosize(cuoi); i++) {
            int vitri = i;
            final JPanel p = new JPanel();
            p.setBorder(BorderFactory.createLineBorder(Color.yellow));
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            
            JLabel labelImage = new JLabel();
            labelImage.setHorizontalAlignment(JLabel.LEFT);
            p.add(labelImage);
            try {
                BufferedImage image = ImageIO.read(new File(listanh.get(vitri).getLinkanh()));
                ImageIcon icon = new ImageIcon(image.getScaledInstance(250, 150, image.SCALE_SMOOTH));
                labelImage.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
            }
            p.add(labelImage);
            khunganh.add(p);
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        txtTenTour = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMatour = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtThoiGianTour = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiemXuatPhat = new javax.swing.JLabel();
        txtDiemDuLich = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        khunganh = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtDichVu = new javax.swing.JLabel();
        txtngaykhoihanh = new com.toedter.calendar.JDateChooser();
        btnback = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        txtngay = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtlichtrinh = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTenTour.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        txtTenTour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenTour.setText("Hà nội - Hạ Long - Bãi Cháy - Cô tô");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Mã tour :");

        txtMatour.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtMatour.setText("HNQN01");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Ngày khởi hành :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Xuất phát: ");

        txtThoiGianTour.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtThoiGianTour.setText("4 ngày");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Thời gian :");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Điểm du lịch :");

        txtDiemXuatPhat.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtDiemXuatPhat.setText("Hà nội");

        txtDiemDuLich.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtDiemDuLich.setText("Vịnh Hạ Long - Bãi Cháy - Đảo Cô Tô");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Lịch Trình:");

        khunganh.setPreferredSize(new java.awt.Dimension(991, 150));

        javax.swing.GroupLayout khunganhLayout = new javax.swing.GroupLayout(khunganh);
        khunganh.setLayout(khunganhLayout);
        khunganhLayout.setHorizontalGroup(
            khunganhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 991, Short.MAX_VALUE)
        );
        khunganhLayout.setVerticalGroup(
            khunganhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(khunganh);

        jButton1.setBackground(new java.awt.Color(150, 238, 238));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Đặt tour");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Quay lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Dịch vụ: ");

        txtDichVu.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtDichVu.setText("Khách san 4*");

        btnback.setText("<");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnnext.setText(">");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        txtngay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtngay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtngayItemStateChanged(evt);
            }
        });
        txtngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtngayActionPerformed(evt);
            }
        });
        txtngay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtngayPropertyChange(evt);
            }
        });

        txtlichtrinh.setColumns(20);
        txtlichtrinh.setRows(5);
        jScrollPane1.setViewportView(txtlichtrinh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTenTour)
                .addGap(215, 215, 215))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMatour)
                            .addComponent(txtDiemXuatPhat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiemDuLich)
                            .addComponent(txtngaykhoihanh, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDichVu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThoiGianTour))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnback)
                                .addGap(18, 18, 18)
                                .addComponent(btnnext))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtngay, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtTenTour))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtngaykhoihanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtMatour)
                        .addComponent(jLabel4)
                        .addComponent(txtThoiGianTour)
                        .addComponent(jLabel7)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiemXuatPhat)
                    .addComponent(jLabel8)
                    .addComponent(txtDiemDuLich))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtDichVu)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(kt()){
            FormDangKyTour dangKyTour = new FormDangKyTour();
            dangKyTour.setTour(tour);
            dangKyTour.hienthithongtin(tour);
            dangKyTour.setNgayKhoihanh(txtngaykhoihanh.getDate());
            dangKyTour.tinhtongtien();
            dangKyTour.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FormGiaoDienTour formGiaoDienTour = new FormGiaoDienTour();
        formGiaoDienTour.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        if (dau >=3) {
            dau-=3;
            cuoi-=3;
        }

        hienthilistanh();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:
        if (cuoi<listanh.size()) {
            dau+=3;
            cuoi+=3;
        }
        khunganh.removeAll();
        hienthilistanh();
    }//GEN-LAST:event_btnnextActionPerformed
    
    private void txtngayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtngayItemStateChanged
        txtlichtrinh.setText(lichtrinh.get(txtngay.getSelectedIndex()).getNoidung());
    }//GEN-LAST:event_txtngayItemStateChanged

    private void txtngayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtngayPropertyChange

    }//GEN-LAST:event_txtngayPropertyChange

    private void txtngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtngayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtngayActionPerformed

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
            java.util.logging.Logger.getLogger(FormChiTietTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormChiTietTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormChiTietTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormChiTietTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormChiTietTour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel khunganh;
    private javax.swing.JLabel txtDichVu;
    private javax.swing.JLabel txtDiemDuLich;
    private javax.swing.JLabel txtDiemXuatPhat;
    private javax.swing.JLabel txtMatour;
    private javax.swing.JLabel txtTenTour;
    private javax.swing.JLabel txtThoiGianTour;
    private javax.swing.JTextArea txtlichtrinh;
    private javax.swing.JComboBox<String> txtngay;
    private com.toedter.calendar.JDateChooser txtngaykhoihanh;
    // End of variables declaration//GEN-END:variables
}
