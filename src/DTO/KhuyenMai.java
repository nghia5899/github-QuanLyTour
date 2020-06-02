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
public class KhuyenMai {
    String makhuyenmai;
    float phantram ;
    String ngaybatdau ;
    String ngayketthuc ;

    public KhuyenMai(String makhuyenmai, float phantram, String ngaybatdau, String ngayketthuc) {
        this.makhuyenmai = makhuyenmai;
        this.phantram = phantram;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
    }

    public String getMakhuyenmai() {
        return makhuyenmai;
    }

    public void setMakhuyenmai(String makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }

    public float getPhantram() {
        return phantram;
    }

    public void setPhantram(float phantram) {
        this.phantram = phantram;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }
    
    
}
