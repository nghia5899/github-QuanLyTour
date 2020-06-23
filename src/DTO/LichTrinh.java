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
public class LichTrinh {
    String malichtrinh;
    String ngay ;
    String noidung ;

    public LichTrinh(String ngay, String noidung) {
        this.ngay = ngay;
        this.noidung = noidung;
    }

    public LichTrinh(String malichtrinh, String ngay, String noidung) {
        this.malichtrinh = malichtrinh;
        this.ngay = ngay;
        this.noidung = noidung;
    }

    public String getMalichtrinh() {
        return malichtrinh;
    }

    public void setMalichtrinh(String malichtrinh) {
        this.malichtrinh = malichtrinh;
    }
    
    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
    
    
    
}
