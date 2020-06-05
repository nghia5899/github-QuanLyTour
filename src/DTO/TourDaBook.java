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
public class TourDaBook {
    String madanhsach ;
    String matour ;
    String makhachhang ;
    String ngaykhoihanh ;
    int songuoilon ;
    int sotreem ;
    long tongtien;

    public TourDaBook(String madanhsach, String matour, String makhachhang, String ngaykhoihanh, int songuoilon, int sotreem, long tongtien) {
        this.madanhsach = madanhsach;
        this.matour = matour;
        this.makhachhang = makhachhang;
        this.ngaykhoihanh = ngaykhoihanh;
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

    public String getMatour() {
        return matour;
    }

    public void setMatour(String matour) {
        this.matour = matour;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getNgaykhoihanh() {
        return ngaykhoihanh;
    }

    public void setNgaykhoihanh(String ngaykhoihanh) {
        this.ngaykhoihanh = ngaykhoihanh;
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
    
    
}
