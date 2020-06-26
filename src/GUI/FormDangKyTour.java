/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.DangiKyTourBLL;
import BLL.TourBLL;
import BLL.TourDaDatBLL;
import DAO.DataProvider;
import DTO.KhachHang;
import DTO.Tour;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author chubo
 */
public class FormDangKyTour extends javax.swing.JFrame {
    int tien=1000000;
    int venguoilon=0;
    int vetreem=0;
    Tour tour;
    int phantram=0;

    public int getPhantram() {
        return phantram;
    }

    public void setPhantram(int phantram) {
        this.phantram = phantram;
    }
    
    
    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
    /**
     * Creates new form DangKyTour
     */
    public FormDangKyTour() {
        initComponents();
        setLocationRelativeTo(this);
        capnhatngay();
 //       getThongTinTour(tour.getMatour());
    }

   
    public void setNgayKhoihanh(java.util.Date date){
        String string =null;
        try {
            string  = new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập ngày");
        }

        txtkhoihanh.setText(string);
    }
    
     
   
    public boolean kiemsoatform(){
        boolean kiemtra = true;
        String ngaysinh = null;
        try {
            java.util.Date date = txtngaysinh.getDate();
            ngaysinh  = new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(rootPane,"Khong duoc de trong ngay");
            kiemtra = false;
        }
        
        //kiemtraten
        if (Pattern.matches("[a-zA-Z ]+", txtTenKhach.getText())&&!txtTenKhach.getText().equals("")) {
            tbten.setText("");
        } else {
            tbten.setText("Nhập sai tên !");
            kiemtra = false;
        }
        
        //kiemtrasdt
        if (Pattern.matches("[0]{1}[0-9]{9}", txtSodienthoai.getText())&&!txtSodienthoai.getText().equals("")) {
            tbsdt.setText("");
        } else {
            tbsdt.setText("Nhập sai sđt !");
            kiemtra = false;
        }
        
        //kiémtraemail
        if (Pattern.matches("[a-zA-Z0-9]+[@]{1}[a-zA-Z]{1,}[.]{1}[a-zA-Z]+",txtgmail.getText())&&!txtgmail.getText().equals("")) {
            tbgmail.setText("");
        } else {
            tbgmail.setText("Nhập sai gmail !");
            kiemtra = false;
        }
        //kiemtradiachi
        if (!txtdiachi.getText().equals("")) {
            tbdiachi.setText("");
        } else {
            tbdiachi.setText("Nhập sai dia chi !");
            kiemtra = false;
        }
            
        return kiemtra ;
    }
    public void capnhatngay() {
        txtngaysinh.setDateFormatString("yyyy-MM-dd");
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
            
            txtngaysinh.setDate(date);

        } catch (ParseException ex) {
            Logger.getLogger(FormGiaoDienTour.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public String taomakhachhang(){
            StringBuilder makh = new StringBuilder() ;
            String tenkhach = txtTenKhach.getText();
            String mang[] = tenkhach.trim().split("\\s+");
            for(String s: mang){
                makh.append(s.charAt(0));
            }
            String ngaysinh = null;
            try {
                java.util.Date date = txtngaysinh.getDate();
                ngaysinh  = new SimpleDateFormat("yyyy-MM-dd").format(date);
            } catch (NullPointerException e) {}
            
            String mang1[] = ngaysinh.trim().split("\\-");
            for(String s: mang1){
                makh.append(s);
            }
            String txtsdt = txtSodienthoai.getText();
            String sdt = txtsdt.substring(txtsdt.length()-3, txtsdt.length());
            makh.append(sdt);
            
            return makh.toString();
            
    }
    public String taomadattour(){
            StringBuilder madattour = new StringBuilder();
            madattour.append(tour.getMatour());
            madattour.append(taomakhachhang());
            String mang1[] = txtkhoihanh.getText().trim().split("\\-");
            for(String s: mang1){
                madattour.append(s);
            }
            return madattour.toString();
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
    public void getThongTinTour(String matour){
        tour = TourBLL.getInstance().getTourTheoMa(matour);
        txtMatour.setText(tour.getMatour());
        txtTenTour.setText(tour.getTentour());
        txtXuatPhat.setText(tour.getDiemxuatphat());
        txtThoigian.setText(tour.getThoigiantour());
        txtGiatien.setText(tour.getGiatour()+" VND");
    }
    
    public void hienthithongtin(Tour tour){
        txtMatour.setText(tour.getMatour());
        txtTenTour.setText(tour.getTentour());
        txtThoigian.setText(tour.getThoigiantour());
        txtGiatien.setText(tour.getGiatour()+" VND");
        txtXuatPhat.setText(tour.getDiemxuatphat());
        
    }
    public int tinh(int nguoilon,int trem){
        int tongtien=0;
        System.out.println(phantram);
        tongtien = nguoilon*tour.getGiatour()
                    +trem*tour.getGiatour()/2;
        
        return tongtien - tongtien*phantram/100;
    }
    public void tinhtongtien(){
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
        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jLabel18 = new javax.swing.JLabel();
        btngioitinh = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tongtien = new javax.swing.JLabel();
        txtDangKyTour = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txttreem = new javax.swing.JPanel();
        xdd = new javax.swing.JLabel();
        txtTenKhach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        xdd2 = new javax.swing.JLabel();
        txtSodienthoai = new javax.swing.JTextField();
        txtgmail = new javax.swing.JTextField();
        xdd3 = new javax.swing.JLabel();
        xdd4 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnnam = new javax.swing.JRadioButton();
        btnnu = new javax.swing.JRadioButton();
        xdd5 = new javax.swing.JLabel();
        txtngaysinh = new com.toedter.calendar.JDateChooser();
        txtNguoiLon = new javax.swing.JSpinner();
        txtTreEm = new javax.swing.JSpinner();
        tbten = new javax.swing.JLabel();
        tbsdt = new javax.swing.JLabel();
        tbgmail = new javax.swing.JLabel();
        tbdiachi = new javax.swing.JLabel();
        txtMatour = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenTour = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtXuatPhat = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtThoigian = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtkhoihanh = new javax.swing.JLabel();
        txtGiatien = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

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

        jLabel18.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel18.setText("1.500.000/người");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng ký Tour");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Đăng ký Tour");

        tongtien.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tongtien.setText("Tổng Tiền :");
        tongtien.setToolTipText("");

        txtDangKyTour.setText("Đăng Ký ");
        txtDangKyTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDangKyTourActionPerformed(evt);
            }
        });

        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txttreem.setBorder(new javax.swing.border.MatteBorder(null));

        xdd.setText("Tên Khách hàng :");

        jLabel4.setText("Số Người Lớn :");
        jLabel4.setToolTipText("");

        jLabel5.setText("Số Trẻ Em :");
        jLabel5.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Mời nhập thông tin :");

        xdd2.setText("Số điện thoại :");

        txtSodienthoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSodienthoaiActionPerformed(evt);
            }
        });

        xdd3.setText("Gmail :");

        xdd4.setText("Địa chỉ");

        jLabel6.setText("Giới Tính :");

        btngioitinh.add(btnnam);
        btnnam.setSelected(true);
        btnnam.setText("Nam");

        btngioitinh.add(btnnu);
        btnnu.setText("Nữ");

        xdd5.setText("Ngày sinh :");

        tbten.setForeground(new java.awt.Color(223, 0, 41));

        tbsdt.setForeground(new java.awt.Color(223, 0, 41));

        tbgmail.setForeground(new java.awt.Color(223, 0, 41));

        tbdiachi.setForeground(new java.awt.Color(223, 0, 41));

        javax.swing.GroupLayout txttreemLayout = new javax.swing.GroupLayout(txttreem);
        txttreem.setLayout(txttreemLayout);
        txttreemLayout.setHorizontalGroup(
            txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txttreemLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txttreemLayout.createSequentialGroup()
                        .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txttreemLayout.createSequentialGroup()
                                .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(txttreemLayout.createSequentialGroup()
                                        .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(xdd)
                                            .addComponent(xdd3, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(txttreemLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(txttreemLayout.createSequentialGroup()
                                        .addComponent(xdd4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(txttreemLayout.createSequentialGroup()
                                        .addComponent(xdd2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSodienthoai)
                                    .addComponent(txtTenKhach)
                                    .addComponent(txtgmail)
                                    .addComponent(txtdiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addGroup(txttreemLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(btnnam, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnnu))))
                            .addGroup(txttreemLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(xdd5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbsdt)
                            .addComponent(tbten)
                            .addComponent(tbgmail)
                            .addComponent(tbdiachi))
                        .addGap(127, 127, 127))
                    .addGroup(txttreemLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNguoiLon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTreEm, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        txttreemLayout.setVerticalGroup(
            txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txttreemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xdd)
                    .addComponent(tbten))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnnam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnnu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xdd5))
                .addGap(18, 18, 18)
                .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xdd2)
                    .addComponent(tbsdt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtgmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tbgmail))
                    .addComponent(xdd3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xdd4)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbdiachi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(txttreemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNguoiLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTreEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtMatour.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtMatour.setText("HNQN01");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Mã tour :");

        txtTenTour.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtTenTour.setText("Hà nội -Hạ long - Bãi Cháy");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Tên tour :");

        txtXuatPhat.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtXuatPhat.setText("Hà nội");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Điểm xuất phát :");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Thời gian :");

        txtThoigian.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtThoigian.setText("4 ngày");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Ngày khởi hành :");

        txtkhoihanh.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtkhoihanh.setText("1/6/2020");

        txtGiatien.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        txtGiatien.setText("1.500.000/người");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Giá tiền:");

        jLabel19.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel19.setText("(Trẻ em = 50% x Giá tiền)");

        txtTongtien.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTongtien.setText("0");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("VND");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(243, 243, 243)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txttreem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongtien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(txtDangKyTour, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtXuatPhat))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMatour))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGiatien)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtThoigian)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtkhoihanh))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenTour)))))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMatour)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTenTour))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtXuatPhat)
                    .addComponent(jLabel12)
                    .addComponent(txtThoigian)
                    .addComponent(jLabel14)
                    .addComponent(txtkhoihanh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtGiatien)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txttreem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongtien)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDangKyTour, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       java.util.Date date = null ;
        try { 
            date = new SimpleDateFormat("yyyy-MM-dd").parse(txtkhoihanh.getText());
        } catch (ParseException ex) {
            Logger.getLogger(FormDangKyTour.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           
        FormChiTietTour formChiTietTour = new FormChiTietTour();
                    formChiTietTour.getThongTinTour(tour.getMatour());
                    formChiTietTour.setNgayKhoihanh(date);
                    formChiTietTour.loadcombobox();
                    formChiTietTour.getLichTrinh();
                    formChiTietTour.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSodienthoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSodienthoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSodienthoaiActionPerformed

    private void txtDangKyTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDangKyTourActionPerformed
        String makh = null;
        String madattour = null;
        if(kiemsoatform()){
            if(tinh(Integer.parseInt(txtNguoiLon.getValue().toString()),Integer.parseInt(txtTreEm.getValue().toString()))>0){
                boolean dangky ;
                String ngaykhoihanh = txtkhoihanh.getText();

                String ngaysinh = null;
                int gioitinh = 0;
                if (btnnam.isSelected()) 
                    gioitinh = 0;
                else
                    gioitinh = 1;


                try {
                    java.util.Date date = txtngaysinh.getDate();
                    ngaysinh  = new SimpleDateFormat("yyyy-MM-dd").format(date);
                } catch (NullPointerException e) {}
                
                venguoilon = Integer.parseInt(txtNguoiLon.getValue().toString());
                vetreem = Integer.parseInt(txtTreEm.getValue().toString());
                String makhachhang = taomakhachhang();
                if(TourDaDatBLL.getInstance().checkma(taomakhachhang())>0){
                     makhachhang = taomakhachhang()+"1";
                }
                
                KhachHang khachHang = new KhachHang(makhachhang,txtTenKhach.getText(), gioitinh,txtSodienthoai.getText(), txtgmail.getText(), txtdiachi.getText(),ngaysinh);
                dangky = DangiKyTourBLL.getInstance().inserttourdabook(tour,taomadattour(), khachHang,ngayhientai(), ngaykhoihanh, venguoilon, vetreem,tinh(tinh(Integer.parseInt(txtNguoiLon.getValue().toString()),Integer.parseInt(txtTreEm.getValue().toString()))
                    ,tinh(Integer.parseInt(txtTreEm.getValue().toString()),Integer.parseInt(txtTreEm.getValue().toString()))));
                if(dangky){
                    JOptionPane.showMessageDialog(rootPane,"Đăng ký thành công");
                    FormGiaoDienTour formGiaoDienTour = new FormGiaoDienTour();
                    formGiaoDienTour.setVisible(true);
                    setVisible(false);
                }
            }else
                JOptionPane.showMessageDialog(rootPane,"Mời nhập số người");
        }
        
    }//GEN-LAST:event_txtDangKyTourActionPerformed

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
            java.util.logging.Logger.getLogger(FormDangKyTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDangKyTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDangKyTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDangKyTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDangKyTour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngioitinh;
    private javax.swing.JRadioButton btnnam;
    private javax.swing.JRadioButton btnnu;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel tbdiachi;
    private javax.swing.JLabel tbgmail;
    private javax.swing.JLabel tbsdt;
    private javax.swing.JLabel tbten;
    private javax.swing.JLabel tongtien;
    private javax.swing.JButton txtDangKyTour;
    private javax.swing.JLabel txtGiatien;
    private javax.swing.JLabel txtMatour;
    private javax.swing.JSpinner txtNguoiLon;
    private javax.swing.JTextField txtSodienthoai;
    private javax.swing.JTextField txtTenKhach;
    private javax.swing.JLabel txtTenTour;
    private javax.swing.JLabel txtThoigian;
    private javax.swing.JLabel txtTongtien;
    private javax.swing.JSpinner txtTreEm;
    private javax.swing.JLabel txtXuatPhat;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtgmail;
    private javax.swing.JLabel txtkhoihanh;
    private com.toedter.calendar.JDateChooser txtngaysinh;
    private javax.swing.JPanel txttreem;
    private javax.swing.JLabel xdd;
    private javax.swing.JLabel xdd2;
    private javax.swing.JLabel xdd3;
    private javax.swing.JLabel xdd4;
    private javax.swing.JLabel xdd5;
    // End of variables declaration//GEN-END:variables

    

    
}
