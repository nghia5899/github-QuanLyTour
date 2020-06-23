/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Tour {
    String matour;
    String tentour;
    String diemxuatphat;
    String thoigiantour;
    int giatour =0;
    String diadiem;
    String diemdulich;
    ArrayList<LichTrinh> lichtrinh;
    String dichvu;
    int khuyenmai;
    String anhchinh;
    String makhuyenmai;

    public Tour() {
    }

    public Tour(String matour, String tentour,int giatour, int khuyenmai) {
        this.matour = matour;
        this.tentour = tentour;
        this.khuyenmai = khuyenmai;
        this.giatour =giatour;
    }

    
    public Tour(String matour, String tentour, String diemxuatphat, String diadiem,String diemdulich, String dichvu, String thoigiantour, int giatour, ArrayList<LichTrinh> lichtrinh, int khuyenmai, String anhchinh) {
        this.matour = matour;
        this.tentour = tentour;
        this.diemxuatphat = diemxuatphat;
        this.thoigiantour = thoigiantour;
        this.giatour = giatour;
        this.diemdulich = diemdulich;
        this.diadiem = diadiem;
        this.lichtrinh = lichtrinh;
        this.dichvu = dichvu;
        this.khuyenmai = khuyenmai;
        this.anhchinh = anhchinh;
    }
    public Tour(String matour, String tentour, String diemxuatphat, String diadiem,String diemdulich, String dichvu, String thoigiantour, int giatour, int khuyenmai) {
        this.matour = matour;
        this.tentour = tentour;
        this.diemxuatphat = diemxuatphat;
        this.thoigiantour = thoigiantour;
        this.giatour = giatour;
        this.diemdulich = diemdulich;
        this.diadiem = diadiem;
        this.dichvu = dichvu;
        this.khuyenmai = khuyenmai;
    }
    public Tour(String matour, String tentour, String diemxuatphat, String diadiem, String dichvu,String diemdulich, String thoigiantour, int giatour, String khuyenmai) {
        this.matour = matour;
        this.tentour = tentour;
        this.diemxuatphat = diemxuatphat;
        this.thoigiantour = thoigiantour;
        this.giatour = giatour;
        this.diemdulich = diemdulich;
        this.diadiem = diadiem;
        this.dichvu = dichvu;
        this.makhuyenmai = khuyenmai;
    }
    public String getMatour() {
        return matour;
    }

    public void setMatour(String matour) {
        this.matour = matour;
    }

    public String getTentour() {
        return tentour;
    }

    public void setTentour(String tentour) {
        this.tentour = tentour;
    }

    public String getDiemxuatphat() {
        return diemxuatphat;
    }

    public void setDiemxuatphat(String diemxuatphat) {
        this.diemxuatphat = diemxuatphat;
    }

    public String getThoigiantour() {
        return thoigiantour;
    }

    public void setThoigiantour(String thoigiantour) {
        this.thoigiantour = thoigiantour;
    }

    public int getGiatour() {
        return giatour;
    }

    public void setGiatour(int giatour) {
        this.giatour = giatour;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public ArrayList<LichTrinh> getLichtrinh() {
        return lichtrinh;
    }

    public void setLichtrinh(ArrayList<LichTrinh> lichtrinh) {
        this.lichtrinh = lichtrinh;
    }

    public String getDichvu() {
        return dichvu;
    }

    public void setDichvu(String dichvu) {
        this.dichvu = dichvu;
    }

    public int getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(int khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public String getAnhchinh() {
        return anhchinh;
    }

    public void setAnhchinh(String anhchinh) {
        this.anhchinh = anhchinh;
    }
    public String getDiemdulich() {
        return diemdulich;
    }

    public void setDiemdulichString(String diemdulich) {
        this.diemdulich = diemdulich;
    }

    

    public String getMakhuyenmai() {
        return makhuyenmai;
    }

    public void setMakhuyenmai(String makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }
    
    
    
}
