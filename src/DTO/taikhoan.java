/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author chubo
 */
public class taikhoan {
    String tendangnhap;
    String matkhau;
    String loaitaikhoan;

    public taikhoan() {
    }

    public taikhoan(String tendangnhap, String matkhau,String loaitaikhoan) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.loaitaikhoan = loaitaikhoan;
    }
    

    public String getLoaitaikhoan() {
        return loaitaikhoan;
    }

    public void setLoaitaikhoan(String loaitaikhoan) {
        this.loaitaikhoan = loaitaikhoan;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }
    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }
    
    public String getMatkhau() {
        return matkhau;
    }
    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    
    
}
