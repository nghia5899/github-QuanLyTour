/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class FormQuanLyTour extends javax.swing.JFrame {

    /**
     * Creates new form FormQuanLyTour
     */
    public static FormInsertTour fit = new FormInsertTour();
    DataProvider dataConn = new DataProvider();

    String matour, tentour, diemxp, diadiem, dichvu, diemdl, tgtour, makm, giatour;
//    int ;

    public FormQuanLyTour() {
        
        initComponents();
        setLocationRelativeTo(this);
        hienThiBang();
        addCombobox();
    }

    void getTxt() {
        matour = txtMatour.getText();
        tentour = txtTentour.getText();
        diemxp = txtXuatPhat.getText();
        diadiem = txtDiadiem.getText();
        dichvu = txtDichvu.getText();
        diemdl = txtDiemdulich.getText();
        tgtour = txtThoiGian.getText();
        makm = cbkhuyenmai.getSelectedItem().toString();
        giatour = txtGia.getText();
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
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMatour = new javax.swing.JTextField();
        txtXuatPhat = new javax.swing.JTextField();
        txtDichvu = new javax.swing.JTextField();
        txtDiadiem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDiemdulich = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnCapnhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtTentour = new javax.swing.JTextField();
        cbkhuyenmai = new javax.swing.JComboBox<>();
        txtThoiGian = new javax.swing.JTextField();
        btnExcel1 = new javax.swing.JButton();
        btnanh = new javax.swing.JButton();
        btnlichtrinh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý tour");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Mã tour :");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Dịch vụ: ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Khuyến mại :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Xuất phát: ");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Thời gian :");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Điểm du lịch :");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("Giá tiền :");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Địa điểm :");

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
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

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jButton5.setText("Quay lại");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Tên tour :");

        btnExcel1.setText("Thêm từ Excel");
        btnExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel1ActionPerformed(evt);
            }
        });

        btnanh.setText("Ảnh");
        btnanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanhActionPerformed(evt);
            }
        });

        btnlichtrinh.setText("Lịch Trình");
        btnlichtrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlichtrinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 77, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(337, 337, 337)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnCapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnanh, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnlichtrinh))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtXuatPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtMatour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDiadiem, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1))))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTentour)
                                    .addComponent(txtDiemdulich)
                                    .addComponent(cbkhuyenmai, 0, 174, Short.MAX_VALUE)
                                    .addComponent(txtGia)
                                    .addComponent(txtThoiGian))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMatour, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtXuatPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtDichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtDiadiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(80, 80, 80))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(txtTentour, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtDiemdulich, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnlichtrinh)
                            .addComponent(btnanh))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        getTxt();
        try {
            if (checkTrung()) {
                if (checkNull()) {

                    Tour tour = new Tour(matour, tentour, diemxp, diadiem, diemdl, dichvu, tgtour, Integer.valueOf(giatour), Integer.parseInt(makm));
                    TourDAO tourda = new TourDAO();
                    tourda.Insert(tour);
                    hienThiBang();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormQuanLyTour.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnthemActionPerformed

    public boolean checkTrung() throws SQLException {
//        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSet rs = dataConn.GetData("select * from tour where matour ='" + txtMatour.getText().trim() + "'");
        Integer countCheck = 0;
        while (rs.next()) {
            countCheck++;
        }
        if (countCheck == 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Mã tour đã tồn tại nên không thể nhập trùng!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
    }

    private void btnCapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhatActionPerformed
        getTxt();
        try {
            if (checkCapnhat()) {
                Tour tour = new Tour(matour, tentour, diemxp, diadiem, diemdl, dichvu, tgtour, Integer.valueOf(giatour), Integer.parseInt(makm));
                TourDAO tourda = new TourDAO();
                tourda.Update(tour, matour);
                hienThiBang();
            }
        } catch (Exception e) {
            Logger.getLogger(FormQuanLyTour.class.getName()).log(Level.SEVERE, null, e);
        }
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapnhatActionPerformed

    public boolean checkCapnhat() throws SQLException {
        ResultSet rs = dataConn.GetData("select * from tour where matour ='" + txtMatour.getText().trim() + "'");
        Integer countCheck = 0;
        while (rs.next()) {
            countCheck++;
        }
        if (countCheck != 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Mã tour không tồn tại nên không thể cập nhật!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        getTxt();
        TourDAO tourda = new TourDAO();
        tourda.Delete(matour);
        hienThiBang();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
//        getTxt();
        if (txtMatour.getText().trim().length() == 0
                && txtDiadiem.getText().trim().length() == 0
                && cbkhuyenmai.getSelectedItem().toString().trim().length() == 0
                && txtXuatPhat.getText().trim().length() == 0
                && txtDichvu.getText().trim().length() == 0
                && txtThoiGian.getText().trim().length() == 0
                && txtDiemdulich.getText().trim().length() == 0
                && txtGia.getText().trim().length() == 0
                && txtTentour.getText().trim().length() == 0) {
            hienThiBang();
        } else {
            System.out.println("tim ");
            DefaultTableModel tableModel = new DefaultTableModel();
            String dataTextSearch[] = {txtMatour.getText().trim(), txtTentour.getText().trim(), txtXuatPhat.getText().trim(), txtDiadiem.getText().trim(), txtDichvu.getText().trim(), txtDiemdulich.getText().trim(), txtThoiGian.getText().trim(), txtGia.getText().trim(), cbkhuyenmai.getSelectedItem().toString().trim()};
            String datakeySearch[] = {"matour", "tentour", "diemxuatphat", "diadiem", "dichvu", "diemdulich", "thoigiantour", "giatour", "makhuyenmai"};
            String sqlSearchKey = "";
            for (int i = 0; i < dataTextSearch.length; i++) {
                if (dataTextSearch[i].length() != 0) {
                    sqlSearchKey += datakeySearch[i] + " LIKE '%" + dataTextSearch[i] + "%' OR ";
                }
            }
            String newSQL = sqlSearchKey.substring(0, sqlSearchKey.lastIndexOf("OR"));
            String SQLsearch = "SELECT * FROM `tour` WHERE " + newSQL;
            System.out.println(SQLsearch);
            ResultSet rs = dataConn.GetData("SELECT * FROM `tour` WHERE " + newSQL);
            String colName[] = {"Mã tour", "Tên tour", "Xuất phát", "Thời gian tour", "Địa điểm", "Điểm du lịch", "Dịch vụ", "Giá tiền", "Mã khuyến mãi"};
            tableModel.setColumnIdentifiers(colName);
            tblData.setModel(tableModel);
            try {
                while (rs.next()) {
                    Object rows[] = new Object[10];
                    rows[0] = rs.getString("matour");
                    rows[1] = rs.getString("tentour");
                    rows[2] = rs.getString("diemxuatphat");
                    rows[3] = rs.getString("thoigiantour");
                    rows[4] = rs.getString("diadiem");
                    rows[5] = rs.getString("diemdulich");
                    rows[6] = rs.getString("dichvu");
                    rows[7] = String.valueOf(rs.getInt("giatour"));
                    rows[8] = rs.getString("makhuyenmai");
                    tableModel.addRow(rows);
                }
                System.out.println("thanh cong");

            } catch (SQLException ex) {
                Logger.getLogger(FormQuanLyTour.class
                        .getName()).log(Level.SEVERE, null, ex);
                System.out.println("khong thanh cong");
            }

        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        int r = tblData.getSelectedRow();
        String[] rr = new String[9];
        for (int i = 0; i < 9; i++) {
            rr[i] = tblData.getModel().getValueAt(r, i).toString();
        }
        System.out.println(rr[7]);
        txtMatour.setText(rr[0]);
        txtTentour.setText(rr[1]);
        txtXuatPhat.setText(rr[2]);
        txtThoiGian.setText(rr[3]);
        txtDiadiem.setText(rr[4]);
        txtDiemdulich.setText(rr[5]);
        txtDichvu.setText(rr[6]);
        cbkhuyenmai.setSelectedItem(rr[8]);
        txtGia.setText(rr[7]);
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnExcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel1ActionPerformed
        // TODO add your handling code here:
        fit.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnExcel1ActionPerformed

    private void btnanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanhActionPerformed
        // TODO add your handling code here:
        if(!txtMatour.getText().equals("")){
            FormQuanLiAnh formQuanLiAnh = new FormQuanLiAnh();
            formQuanLiAnh.hienthianh(txtMatour.getText());
            formQuanLiAnh.setVisible(true);
        }
        
    }//GEN-LAST:event_btnanhActionPerformed

    private void btnlichtrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlichtrinhActionPerformed
        // TODO add your handling code here:
        if(!txtMatour.getText().equals("")){
            FormCapNhatLichTrinh formCapNhatLichTrinh = new FormCapNhatLichTrinh();
            formCapNhatLichTrinh.loadcombobox(txtMatour.getText());
            formCapNhatLichTrinh.getLichTrinh(txtMatour.getText());
            formCapNhatLichTrinh.setVisible(true);
        }
    }//GEN-LAST:event_btnlichtrinhActionPerformed

    void addCombobox() {
        ResultSet rs = dataConn.GetData("select makhuyenmai from khuyenmai");
        try {
            cbkhuyenmai.addItem("");
            while (rs.next()) {
                cbkhuyenmai.addItem(rs.getString("makhuyenmai"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(FormQuanLyTour.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    void hienThiBang() {
        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSet rs = dataConn.GetData("select * from tour");
        String colName[] = {"Mã tour", "Tên tour", "Xuất phát", "Thời gian tour", "Địa điểm", "Điểm du lịch", "Dịch vụ", "Giá tiền", "Mã khuyến mãi"};
        tableModel.setColumnIdentifiers(colName);
        tblData.setModel(tableModel);
        try {
            while (rs.next()) {
                Object rows[] = new Object[10];
                rows[0] = rs.getString("matour");
                rows[1] = rs.getString("tentour");
                rows[2] = rs.getString("diemxuatphat");
                rows[3] = rs.getString("thoigiantour");
                rows[4] = rs.getString("diadiem");
                rows[5] = rs.getString("diemdulich");
                rows[6] = rs.getString("dichvu");
                rows[7] = String.valueOf(rs.getInt("giatour"));
                rows[8] = rs.getString("makhuyenmai");
                tableModel.addRow(rows);
            }
            System.out.println("thanh cong");

        } catch (SQLException ex) {
            Logger.getLogger(FormQuanLyTour.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("khong thanh cong");
        }
    }

    public boolean checkNull() {
        getTxt();
        if (matour.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập mã tour!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        if (tentour.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập tên tour!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        if (diemxp.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập điểm xuất phát!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        if (tgtour.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập thời gian tour!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        if (diadiem.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập địa điểm!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        if (diemdl.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập điểm du lịch!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        if (makm.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Yêu cầu chọn mã khuyến mại!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        if (dichvu.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập dịch vụ tour!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        try {
            int gia = Integer.parseInt(giatour);
            if (gia <= 0) {
                JOptionPane.showMessageDialog(null, "Yêu cầu nhập giá tour!", "Thông báo", JOptionPane.OK_OPTION);
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
            java.util.logging.Logger.getLogger(FormQuanLyTour.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyTour.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyTour.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyTour.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQuanLyTour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapnhat;
    private javax.swing.JButton btnExcel1;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnanh;
    private javax.swing.JButton btnlichtrinh;
    private javax.swing.JButton btnthem;
    private javax.swing.JComboBox<String> cbkhuyenmai;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtDiadiem;
    private javax.swing.JTextField txtDichvu;
    private javax.swing.JTextField txtDiemdulich;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMatour;
    private javax.swing.JTextField txtTentour;
    private javax.swing.JTextField txtThoiGian;
    private javax.swing.JTextField txtXuatPhat;
    // End of variables declaration//GEN-END:variables
}
