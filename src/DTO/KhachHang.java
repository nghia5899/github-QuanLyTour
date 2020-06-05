/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class KhachHang {
    String makhachhang;
    String tenkhachhang;
    int gioitinh;
    String sodienthoai;
    String gmail;
    String diachi ;
    String ngaysinh ;

    public KhachHang(String makhachhang, String tenkhachhang, int gioitinh, String sodienthoai, String gmail, String diachi, String ngaysinh) {
        this.makhachhang = makhachhang;
        this.tenkhachhang = tenkhachhang;
        this.gioitinh = gioitinh;
        this.sodienthoai = sodienthoai;
        this.gmail = gmail;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
    }

    public KhachHang() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    
    
}
