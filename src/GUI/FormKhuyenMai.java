/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DataProvider;
import DTO.*;
import DAO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author E7450
 */
public class FormKhuyenMai extends javax.swing.JFrame {

    /**
     * Creates new form FormKhuyenMai
     */
    DataProvider dataConn = new DataProvider();

    String makhuyenmai, ngaybatdau, ngayketthuc, phantram;

    public static FormInsertFromExcel fife = new FormInsertFromExcel();

    public FormKhuyenMai() {
        initComponents();
        setLocationRelativeTo(this);
        hienthiBang();
    }

    void getTxt() {
        makhuyenmai = txtmakm.getText();
        phantram = txtphantram.getText();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            ngaybatdau = format.format(jdcStart.getDate());
//        } catch (Exception e) {
//            System.out.println("chưa nhập");
//        }
//        try {
//            ngayketthuc = format.format(jdcEnd.getDate());
//        } catch (Exception e) {
//            System.out.println("chưa nhập");
//        }

//        System.out.println(format.format(jdcEnd.getDate()));
    }

    Calendar strToCal(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(FormKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnCapnhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        txtmakm = new javax.swing.JTextField();
        txtphantram = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        jdcStart = new com.toedter.calendar.JDateChooser();
        jdcEnd = new com.toedter.calendar.JDateChooser();
        btnQuaylai = new javax.swing.JButton();
        btnExcel1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label1.setName(""); // NOI18N
        label1.setText("Quản lý Khuyến Mại");

        jLabel1.setText("Mã Khuyến Mại");

        jLabel2.setText("Phần trăm ");

        jLabel3.setText("Ngày Bắt Đầu");

        jLabel4.setText("Ngày Kết Thúc");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapnhat.setText("Sửa");
        btnCapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapnhatActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm ");
        btnTim.setToolTipText("");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Khuyến Mại", "Phần trăm", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbData);

        jdcStart.setDateFormatString("yyyy-MM-dd");

        jdcEnd.setDateFormatString("yyyy-MM-dd");

        btnQuaylai.setText("Quay lại");

        btnExcel1.setText("Thêm từ Excel");
        btnExcel1.setToolTipText("");
        btnExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnQuaylai)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtmakm, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtphantram, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jdcStart, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnCapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(233, 233, 233)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(134, 134, 134)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExcel1)
                                    .addComponent(jdcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnQuaylai))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jdcStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jdcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtmakm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtphantram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        getTxt();
        try {
            if (checkTrung()) {
                System.out.println("adđ");
                if (checkNull()) {
                    KhuyenMai km = new KhuyenMai(makhuyenmai, Integer.valueOf(phantram), ngaybatdau.toString(), ngayketthuc.toString());
                    KhuyenMaiDAO kmdao = new KhuyenMaiDAO();
                    kmdao.Insert(km);
                    hienthiBang();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormQuanLyTour.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnThemActionPerformed

    public boolean checkTrung() throws SQLException {
//        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSet rs = dataConn.GetData("select * from khuyenmai where makhuyenmai ='" + txtmakm.getText().trim() + "'");
        Integer countCheck = 0;
        while (rs.next()) {
            countCheck++;
        }
        if (countCheck == 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Mã khuyến mại đã tồn tại nên không thể nhập trùng!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
    }
    private void btnCapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhatActionPerformed
        getTxt();
        try {
            if (checkCapnhat()) {
                KhuyenMai km = new KhuyenMai(makhuyenmai, Integer.valueOf(phantram), ngaybatdau, ngayketthuc);
                KhuyenMaiDAO kmdao = new KhuyenMaiDAO();
                kmdao.Update(km, makhuyenmai);
                hienthiBang();
            }
        } catch (Exception e) {
            Logger.getLogger(FormKhuyenMai.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_btnCapnhatActionPerformed

    public boolean checkCapnhat() throws SQLException {
        ResultSet rs = dataConn.GetData("select * from khuyenmai where makhuyenmai ='" + txtmakm.getText().trim() + "'");
        Integer countCheck = 0;
        while (rs.next()) {
            countCheck++;
        }
        if (countCheck != 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Mã khuyến mại không tồn tại nên không thể cập nhật!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        getTxt();
        KhuyenMaiDAO kmdao = new KhuyenMaiDAO();
        kmdao.Delete(makhuyenmai);
        hienthiBang();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataMouseClicked
        int r = tbData.getSelectedRow();
        txtmakm.setText(tbData.getModel().getValueAt(r, 0).toString());
        txtphantram.setText(tbData.getModel().getValueAt(r, 1).toString());
        jdcStart.setCalendar(strToCal(tbData.getModel().getValueAt(r, 2).toString()));
        jdcEnd.setCalendar(strToCal(tbData.getModel().getValueAt(r, 3).toString()));
    }//GEN-LAST:event_tbDataMouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        if (txtmakm.getText().trim().length() == 0) {
            hienthiBang();
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSet rs = dataConn.GetData("select * from khuyenmai where makhuyenmai ='" + txtmakm.getText() + "'");
            String colName[] = {"Mã khuyến mại", "Phần trăm", "Ngày bắt đầu", "Ngày kết thúc"};
            tableModel.setColumnIdentifiers(colName);
            tbData.setModel(tableModel);
            try {
                while (rs.next()) {
                    Object rows[] = new Object[10];
                    rows[0] = rs.getString("makhuyenmai");
                    rows[1] = rs.getString("phantram");
                    rows[2] = rs.getString("ngaybatdau");
                    rows[3] = rs.getString("ngayketthuc");
                    tableModel.addRow(rows);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormQuanLyTour.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnExcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel1ActionPerformed
        // TODO add your handling code here:

        fife.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnExcel1ActionPerformed

    void hienthiBang() {

        DefaultTableModel tb = new DefaultTableModel();
        ResultSet rs = dataConn.GetData("select * from khuyenmai");
        String colName[] = {"Mã khuyến mại", "Phần trăm", "Ngày bắt đầu", "Ngày kết thúc"};
        tb.setColumnIdentifiers(colName);
        tbData.setModel(tb);
        try {
            while (rs.next()) {
                Object rows[] = new Object[5];
                rows[0] = rs.getString("makhuyenmai");
                rows[1] = Integer.valueOf(rs.getString("phantram"));
                rows[2] = rs.getString("ngaybatdau");
                rows[3] = rs.getString("ngayketthuc");
                tb.addRow(rows);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkNull() {
        System.out.println("check null");
        getTxt();
        if (makhuyenmai.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập mã khuyến mại!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ngaybatdau = format.format(jdcStart.getDate());
            System.out.println(ngaybatdau);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập ngày bắt đầu!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        try {
            ngayketthuc = format.format(jdcEnd.getDate());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập ngày kết thúc!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        try {
            int pt = Integer.parseInt(phantram);
            if (pt <= 0) {
                JOptionPane.showMessageDialog(null, "Yêu cầu phần trăm khuyến mại!", "Thông báo", JOptionPane.OK_OPTION);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Giá tour phải là số!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        return true;

    }

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
            java.util.logging.Logger.getLogger(FormKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapnhat;
    private javax.swing.JButton btnExcel1;
    private javax.swing.JButton btnQuaylai;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private com.toedter.calendar.JDateChooser jdcEnd;
    private com.toedter.calendar.JDateChooser jdcStart;
    private java.awt.Label label1;
    private javax.swing.JTable tbData;
    private javax.swing.JTextField txtmakm;
    private javax.swing.JTextField txtphantram;
    // End of variables declaration//GEN-END:variables
}
