/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.GiaoDienTourBLL;
import DTO.Tour;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class FormGiaoDienTour extends javax.swing.JFrame {

    ArrayList<Tour> dstour = new ArrayList<>();

    /**
     * Creates new form FormQuanLyKhachHang
     */
    public FormGiaoDienTour() {
        initComponents();
        setLocationRelativeTo(this);
        getListour();
        hienthitour();
        loadcombobox();
        listGiaTien();
        test1();

    }

    public void test1() {
        calendar.setDateFormatString("yyyy-MM-dd");
        try {
            java.util.Date date = calendar.getDate();
            String string = new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (NullPointerException e) {
            test();
        }

    }

    public void test() {
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

        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(string);

            calendar.setDate(date);

        } catch (ParseException ex) {
            Logger.getLogger(FormGiaoDienTour.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listGiaTien() {
        listGiaTien.removeAllItems();
        listGiaTien.addItem("--Chọn giá tiền--");
        listGiaTien.addItem("500.000 VNĐ - 1.000.000 VNĐ");
        listGiaTien.addItem("1.000.000 VNĐ - 3.000.000 VNĐ");
        listGiaTien.addItem("3.000.000 VNĐ - 5.000.000 VNĐ");
        listGiaTien.addItem("5.000.000 VNĐ - 10.000.000 VNĐ");
        listGiaTien.addItem("10.000.000 trở lên ");
    }

    public void loadcombobox() {
        DefaultComboBoxModel diemdi = new DefaultComboBoxModel();
        DefaultComboBoxModel diemden = new DefaultComboBoxModel();
        GiaoDienTourBLL.getInstance().LoadComboboxDiemXuatPhat(diemdi);
        GiaoDienTourBLL.getInstance().LoadComboboxDiadiem(diemden);
        listDiemDi.setModel(diemdi);
        listDiemDen.setModel(diemden);
    }

    public void getListour() {
        dstour.clear();
        GiaoDienTourBLL.getInstance().getListTourKhuyenMai(dstour);
        
    }

    public void getListtourSearch() {
        String diemdi = null, diemden = null;
        int min = 0, max = 0;
        if (listDiemDi.getSelectedIndex() != 0) {
            diemdi = listDiemDi.getSelectedItem().toString();
        } else {
        }
        if (listDiemDen.getSelectedIndex() != 0) {
            diemden = listDiemDen.getSelectedItem().toString();
        } else {
        }
        switch (listGiaTien.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                min = 500000;
                max = 1000000;
                break;
            case 2:
                min = 1000000;
                max = 3000000;
                break;
            case 3:
                min = 3000000;
                max = 5000000;
                break;
            case 4:
                min = 5000000;
                max = 10000000;
                break;
            case 5:
                min = 10000000;
                max = 1000000000;
                break;

        }

        GiaoDienTourBLL.getInstance().getListTourSearch(dstour, diemdi, diemden, max, min);

    }

    public void hienthitour() {

        int col = 3;

        listTour.removeAll();
        listTour.revalidate();

        listTour.setLayout(new GridLayout(dstour.size() / 3 + 1, col, -1, -1));
        listTour.setBorder(BorderFactory.createLineBorder(Color.yellow));

        for (int i = 0; i < dstour.size(); i++) {
            int vitri = i;
            final JPanel p = new JPanel();
            p.setMaximumSize(new Dimension(10, 10));
            p.setBorder(BorderFactory.createLineBorder(Color.yellow));
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

            JLabel lbl = new JLabel(dstour.get(i).getTentour());
            lbl.setLayout(null);
            lbl.setFont(new Font("Serif", Font.BOLD, 18));
            lbl.setHorizontalAlignment(JLabel.CENTER);
            p.add(lbl);

            JLabel labelImage = new JLabel();
            labelImage.setHorizontalAlignment(JLabel.CENTER);
            p.add(labelImage);
            try {
                BufferedImage image = ImageIO.read(new File(dstour.get(i).getAnhchinh()));
                ImageIcon icon = new ImageIcon(image.getScaledInstance(200, 100, image.SCALE_SMOOTH));
                labelImage.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
            }
            p.add(labelImage);

            JPanel bottom1 = new JPanel();
            bottom1.setLayout(new BoxLayout(bottom1, BoxLayout.X_AXIS));
            bottom1.setAlignmentX(Component.LEFT_ALIGNMENT);
            bottom1.add(Box.createRigidArea(new Dimension(20, 0)));
            JLabel lbgia = new JLabel("Gia :" + dstour.get(i).getGiatour() + " VND");
            bottom1.add(lbgia);
            if (dstour.get(i).getKhuyenmai() != 0) {
                JLabel lbkm = new JLabel("  (-" + dstour.get(i).getKhuyenmai() + "%)");
                lbkm.setForeground(Color.RED);
                bottom1.add(lbkm);
            }

            p.add(bottom1);

            JPanel bottom = new JPanel();
            bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
            bottom.setAlignmentX(Component.LEFT_ALIGNMENT);
            bottom.add(Box.createRigidArea(new Dimension(20, 0)));
            JButton btn1 = new JButton("Chi tiết");
            JButton btn2 = new JButton("Đặt");

            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FormChiTietTour formChiTietTour = new FormChiTietTour();
                    formChiTietTour.getThongTinTour(dstour.get(vitri).getMatour());
                    formChiTietTour.setNgayKhoihanh(calendar.getDate());
                    formChiTietTour.setPhantram(dstour.get(vitri).getKhuyenmai());
                    formChiTietTour.loadcombobox();
                    formChiTietTour.getLichTrinh();
                    formChiTietTour.hienthilistanh();
                    formChiTietTour.setVisible(true);
                    setVisible(false);

                }
            });
            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FormDangKyTour formDangKyTour = new FormDangKyTour();
                    formDangKyTour.setVisible(true);
                    setVisible(false);
                }
            });
            bottom.add(btn1);
            bottom.add(btn2);

            p.add(bottom);
            listTour.add(p);

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

        jPanel1 = new javax.swing.JPanel();
        btntimkiem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        listDiemDen = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        listGiaTien = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        listDiemDi = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTour = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 1000));

        jPanel1.setBackground(new java.awt.Color(150, 238, 238));

        btntimkiem.setText("TÌm kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Điểm đến :");

        listDiemDen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listDiemDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listDiemDenActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Giá tiền :");

        listGiaTien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listGiaTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listGiaTienActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Ngày khởi hành :");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Điểm đi");

        listDiemDi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listDiemDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listDiemDiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(listDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(listDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(listDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(listGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hãy chọn tour du lịch phù hợp với bạn");

        listTour.setBackground(new java.awt.Color(238, 200, 238));
        listTour.setAutoscrolls(true);
        listTour.setRequestFocusEnabled(false);
        listTour.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout listTourLayout = new javax.swing.GroupLayout(listTour);
        listTour.setLayout(listTourLayout);
        listTourLayout.setHorizontalGroup(
            listTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        listTourLayout.setVerticalGroup(
            listTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(listTour);

        jButton2.setText("Đăng nhập admin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Điểm đến :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(308, 308, 308))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(587, 587, 587)
                    .addComponent(jLabel6)
                    .addContainerGap(588, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(381, 381, 381)
                    .addComponent(jLabel6)
                    .addContainerGap(382, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FormDangNhap formDangNhap = new FormDangNhap();
        formDangNhap.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listGiaTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listGiaTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listGiaTienActionPerformed

    private void listDiemDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listDiemDenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listDiemDenActionPerformed

    private void listDiemDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listDiemDiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listDiemDiActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        dstour.clear();
        getListtourSearch();
        hienthitour();

    }//GEN-LAST:event_btntimkiemActionPerformed

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
            java.util.logging.Logger.getLogger(FormGiaoDienTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormGiaoDienTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormGiaoDienTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormGiaoDienTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormGiaoDienTour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btntimkiem;
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listDiemDen;
    private javax.swing.JComboBox<String> listDiemDi;
    private javax.swing.JComboBox<String> listGiaTien;
    private javax.swing.JPanel listTour;
    // End of variables declaration//GEN-END:variables
}
