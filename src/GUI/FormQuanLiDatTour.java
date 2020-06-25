/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.TourDaDatBLL;
import DTO.TourDaDat;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class FormQuanLiDatTour extends javax.swing.JFrame {

    ArrayList<TourDaDat> listtour = new ArrayList<>();
    TourDaDat tour = new TourDaDat();
    int vitri;
    long giatour;
    int datim=0;

    public FormQuanLiDatTour(JButton btnSua, JButton btnTim, JButton btnXoa, JLabel jLabel1, JLabel jLabel2, JLabel jLabel4, JLabel jLabel5, JScrollPane jScrollPane1, JLabel lblID, JLabel lblID1, JLabel lblName, JLabel lblPhone, JTable tbquantidattour, JTextField txtGmail, JSpinner txtNguoiLon, JTextField txtTenKhach, JSpinner txtTreEm, JTextField txtmatourdat, JDateChooser txtngaykhoihanh, JTextField txtsdt) throws HeadlessException {
        this.btnSua = btnSua;
        this.btnTim = btnTim;
        this.btnXoa = btnXoa;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jLabel4 = jLabel4;
        this.jLabel5 = jLabel5;
        this.jScrollPane1 = jScrollPane1;
        this.lblID = lblID;
        this.lblID1 = lblID1;
        this.lblName = lblName;
        this.lblPhone = lblPhone;
        this.tbquantidattour = tbquantidattour;
        this.txtGmail = txtGmail;
        this.txtNguoiLon = txtNguoiLon;
        this.txtTenKhach = txtTenKhach;
        this.txtTreEm = txtTreEm;
        this.txtmatourdat = txtmatourdat;
        this.txtngaykhoihanh = txtngaykhoihanh;
        this.txtsdt = txtsdt;
    }

    /**
     * Creates new form FormQuanLiDatTour
     */
    public FormQuanLiDatTour() {
        initComponents();
        setLocationRelativeTo(this);
        TourDaDatBLL.getInstance().getTourDaDaDat(listtour);
        hienthidanhsach();
    }

   

    public void xoatour() {
        if (TourDaDatBLL.getInstance().XoatourDaDat(tour)) {
            JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
        }
    }

    public void capnhat() {
        String string = null;
        try {
            java.util.Date date = txtngaykhoihanh.getDate();
            string = new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (NullPointerException e) {
        }
        tour = new TourDaDat(listtour.get(vitri).getMadanhsach(), listtour.get(vitri).getTentour(), txtTenKhach.getText(),
                string, listtour.get(vitri).getNgaydattour(), txtsdt.getText(),
                txtGmail.getText(), Integer.parseInt(txtNguoiLon.getValue().toString()), Integer.parseInt(txtTreEm.getValue().toString()),
                tinh(Integer.parseInt(txtNguoiLon.getValue().toString()),Integer.parseInt(txtTreEm.getValue().toString())));
        tour.setMakhachhang(listtour.get(vitri).getMakhachhang());
        TourDaDatBLL.getInstance().CapNhatTourDaDat(tour);
    }

    public void hienthidanhsach() {
        DefaultTableModel model = (DefaultTableModel) tbquantidattour.getModel();
        model.setRowCount(0);       
        for (TourDaDat tourDaDat : listtour) {
            Object mang[] = {tourDaDat.getMadanhsach(), tourDaDat.getTentour(), tourDaDat.getNgaykhoihanh(), tourDaDat.getNgaydattour(),
                 tourDaDat.getTenkhachhang(), tourDaDat.getSodienthoai(), tourDaDat.getGmail(), tourDaDat.getSonguoilon(),
                 tourDaDat.getSotreem(), tourDaDat.getTongtien()};
            model.addRow(mang);
        }
    }

    public int tinh(int nguoilon,int treem) {
        int tongtien = 0;
        
        tongtien = (int) (nguoilon * giatour + treem * giatour/2);

        return tongtien;
    }

    public void tinhtongtien() {
        int tongtien = 0;
        txtNguoiLon.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (Integer.parseInt(txtNguoiLon.getValue().toString()) > 0) {
                    txtTongtien.setText(tinh(Integer.parseInt(txtNguoiLon.getValue().toString()),Integer.parseInt(txtTreEm.getValue().toString())) + "");
                } else if (Integer.parseInt(txtTreEm.getValue().toString()) > 0) {
                    txtTongtien.setText(tinh(0,Integer.parseInt(txtTreEm.getValue().toString()))+"");
                } else{
                    txtTongtien.setText(0+"");
                }
                
                
            }
        });
        txtTreEm.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (Integer.parseInt(txtTreEm.getValue().toString()) > 0) {
                    txtTongtien.setText(tinh(Integer.parseInt(txtNguoiLon.getValue().toString()),Integer.parseInt(txtTreEm.getValue().toString())) + "");
                } else if (Integer.parseInt(txtNguoiLon.getValue().toString()) > 0) {
                     txtTongtien.setText(tinh(Integer.parseInt(txtNguoiLon.getValue().toString()),0) + "");
                } else{
                    txtTongtien.setText(0 + "");
                }

            }
        });
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
    public boolean kiemsoatform(){
        //kiemtrasdt
        boolean kiemtra = true;
        if (Pattern.matches("[0]{1}[0-9]{9}",txtsdt.getText())&&!txtsdt.getText().equals("")) {
            tbsdt.setText("");
        } else {
            tbsdt.setText("Nhập sai!");
            kiemtra = false;
        }
        
        if (Pattern.matches("[a-zA-Z0-9]+[@]{1}[a-zA-Z]{1,}[.]{1}[a-zA-Z]+",txtGmail.getText())&&!txtGmail.getText().equals("")) {
            tbgmail.setText("");
            
        } else {
            tbgmail.setText("Nhập sai gmail !");
            kiemtra = false;
        }
        
        if(!txtTenKhach.getText().equals("")){
            tbten.setText("");
        }else {
            tbten.setText("Nhập sai ten !");
            kiemtra = false;
        }
        
        if(Integer.parseInt(txtNguoiLon.getValue().toString())>0||Integer.parseInt(txtTreEm.getValue().toString())>0){
            tbsonguoi.setText("");
        }else{
            tbsonguoi.setText("Nhập số người đi !");
            kiemtra = false;
        }
        
        if(!kt()){
            kiemtra =false;
        }
        
        
        
        return kiemtra;
    }
    public void clearform(){
        txtsdt.setText("");
        txtGmail.setText("");
        txtTenKhach.setText("");
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
        lblName = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbquantidattour = new javax.swing.JTable();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        lblPhone = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        txtGmail = new javax.swing.JTextField();
        txtTenKhach = new javax.swing.JTextField();
        txtmatourdat = new javax.swing.JTextField();
        lblID1 = new javax.swing.JLabel();
        txtngaykhoihanh = new com.toedter.calendar.JDateChooser();
        txtNguoiLon = new javax.swing.JSpinner();
        txtTreEm = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tongtien = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JLabel();
        tbten = new javax.swing.JLabel();
        tbgmail = new javax.swing.JLabel();
        tbsonguoi = new javax.swing.JLabel();
        tbsdt = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Quản lí đặt tour đã đặt");

        lblName.setText("Tên Khách");

        lblID.setText("Ngày khởi hành");

        tbquantidattour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tour đã đjăt", "Tên tour", "Ngày khởi hành", "Ngày đặt tour", "Tên khách đặt", "Số điện thoại", "Gmail", "Người lớn", "Trẻ em", "Tổng tiền"
            }
        ));
        tbquantidattour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbquantidattourMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbquantidattour);

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        lblPhone.setText("Di Động");

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel2.setText("Gmail");

        lblID1.setText("Mã tour đã đặt");

        jLabel4.setText("Số Người Lớn :");
        jLabel4.setToolTipText("");

        jLabel5.setText("Số Trẻ Em :");
        jLabel5.setToolTipText("");

        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tongtien.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tongtien.setText("Tổng Tiền :");
        tongtien.setToolTipText("");

        txtTongtien.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTongtien.setText("0");

        tbten.setForeground(new java.awt.Color(223, 0, 41));

        tbgmail.setForeground(new java.awt.Color(223, 0, 41));
        tbgmail.setName("dsadsa"); // NOI18N

        tbsonguoi.setForeground(new java.awt.Color(223, 0, 41));

        tbsdt.setForeground(new java.awt.Color(223, 0, 41));

        jLabel6.setText("VND");
        jLabel6.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPhone)
                            .addComponent(lblID))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtsdt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtngaykhoihanh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbgmail, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbten, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongtien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(109, 109, 109))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(371, 371, 371)
                                .addComponent(tbsonguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblID1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNguoiLon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTreEm, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(225, 225, 225)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtmatourdat, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTim))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(11, 11, 11)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(572, 572, 572))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID1)
                    .addComponent(txtmatourdat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbgmail)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbten))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtngaykhoihanh, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhone)
                            .addComponent(tbsdt))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(tbsonguoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNguoiLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTreEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongtien)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbquantidattourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbquantidattourMouseClicked
        vitri = tbquantidattour.getSelectedRow();

        txtTenKhach.setText((String) tbquantidattour.getModel().getValueAt(vitri, 4));
        txtsdt.setText((String) tbquantidattour.getModel().getValueAt(vitri, 5));
        txtGmail.setText((String) tbquantidattour.getModel().getValueAt(vitri, 6));
        txtNguoiLon.setValue(tbquantidattour.getModel().getValueAt(vitri, 7));
        txtTreEm.setValue(tbquantidattour.getModel().getValueAt(vitri, 8));
        txtngaykhoihanh.setDateFormatString("yyyy-MM-dd");

        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tbquantidattour.getModel().getValueAt(vitri, 2).toString());

            txtngaykhoihanh.setDate(date);

        } catch (ParseException ex) {
            Logger.getLogger(FormGiaoDienTour.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtTongtien.setText(tbquantidattour.getModel().getValueAt(vitri, 9) + "");
        tour.setMadanhsach(listtour.get(vitri).getMadanhsach());
        tour.setMakhachhang(listtour.get(vitri).getMakhachhang());

        giatour = TourDaDatBLL.getInstance().getGiatour(listtour.get(vitri).getMatour());
        tinhtongtien();
    }//GEN-LAST:event_tbquantidattourMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (kiemsoatform()) {
            capnhat();
            JOptionPane.showMessageDialog(rootPane,"Cập nhật thành công");
           if(datim==1)
               TourDaDatBLL.getInstance().timkiemTourDaDaDat(listtour, txtmatourdat.getText());
           else
               TourDaDatBLL.getInstance().getTourDaDaDat(listtour);
           hienthidanhsach();
           clearform();
        }
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        int xoa = JOptionPane.showConfirmDialog(rootPane, "Bán muốn xóa tour da dat co ma "+tour.getMadanhsach(), "Xóa", JOptionPane.YES_NO_OPTION);
        if(xoa==JOptionPane.YES_OPTION)
                xoatour();
        if(datim==1)
            TourDaDatBLL.getInstance().timkiemTourDaDaDat(listtour, txtmatourdat.getText());
        else
            TourDaDatBLL.getInstance().getTourDaDaDat(listtour);
        hienthidanhsach();
        clearform();

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        datim =1;
        TourDaDatBLL.getInstance().timkiemTourDaDaDat(listtour, txtmatourdat.getText());
        
        hienthidanhsach();
    }//GEN-LAST:event_btnTimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormGIaoDienAdmin formGIaoDienAdmin = new FormGIaoDienAdmin();
        formGIaoDienAdmin.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormQuanLiDatTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLiDatTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLiDatTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLiDatTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQuanLiDatTour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel tbgmail;
    private javax.swing.JTable tbquantidattour;
    private javax.swing.JLabel tbsdt;
    private javax.swing.JLabel tbsonguoi;
    private javax.swing.JLabel tbten;
    private javax.swing.JLabel tongtien;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JSpinner txtNguoiLon;
    private javax.swing.JTextField txtTenKhach;
    private javax.swing.JLabel txtTongtien;
    private javax.swing.JSpinner txtTreEm;
    private javax.swing.JTextField txtmatourdat;
    private com.toedter.calendar.JDateChooser txtngaykhoihanh;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
