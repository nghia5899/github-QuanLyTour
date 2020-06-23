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
public class TourDaDat {
    String madanhsach ;
    String tentour ;
    String tenkhachhang ;
    String ngaydattour;
    String ngaykhoihanh ;
    String sodienthoai;
    String gmail ;
    int songuoilon ;
    int sotreem ;
    long tongtien;
    String makhachhang;
    String matour;

  
    public TourDaDat() {
    }

    public TourDaDat(String madanhsach, String tentour, String tenkhachhang, String ngaydattour, String ngaykhoihanh, String sodienthoai, String gmail, int songuoilon, int sotreem, long tongtien) {
        this.madanhsach = madanhsach;
        this.tentour = tentour;
        this.tenkhachhang = tenkhachhang;
        this.ngaydattour = ngaydattour;
        this.ngaykhoihanh = ngaykhoihanh;
        this.sodienthoai = sodienthoai;
        this.gmail = gmail;
        this.songuoilon = songuoilon;
        this.sotreem = sotreem;
        this.tongtien = tongtien;
    }

    public String getMadanhsach() {
        return madanhsach;
    }

    public void setMadanhsach(String madanhsach) {
        this.madanhsach = madanhsach;
    }

    public String getTentour() {
        return tentour;
    }

    public void setTentour(String tentour) {
        this.tentour = tentour;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getNgaydattour() {
        return ngaydattour;
    }

    public void setNgaydattour(String ngaydattour) {
        this.ngaydattour = ngaydattour;
    }

    public String getNgaykhoihanh() {
        return ngaykhoihanh;
    }

    public void setNgaykhoihanh(String ngaykhoihanh) {
        this.ngaykhoihanh = ngaykhoihanh;
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

    public int getSonguoilon() {
        return songuoilon;
    }

    public void setSonguoilon(int songuoilon) {
        this.songuoilon = songuoilon;
    }

    public int getSotreem() {
        return sotreem;
    }

    public void setSotreem(int sotreem) {
        this.sotreem = sotreem;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }
    
     public String getMatour() {
        return matour;
    }

    public void setMatour(String matour) {
        this.matour = matour;
    }
    
    
}
