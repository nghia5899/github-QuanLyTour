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
    int giatour;
    String lichtrinh;
    String dichvu;
    ArrayList<Anh> listanh;

    public Tour(String matour, String tentour, String diemxuatphat, String thoigiantour, int giatour, String lichtrinh, String dichvu, ArrayList<Anh> listanh) {
        this.matour = matour;
        this.tentour = tentour;
        this.diemxuatphat = diemxuatphat;
        this.thoigiantour = thoigiantour;
        this.giatour = giatour;
        this.lichtrinh = lichtrinh;
        this.dichvu = dichvu;
        this.listanh = listanh;
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

    public String getLichtrinh() {
        return lichtrinh;
    }

    public void setLichtrinh(String lichtrinh) {
        this.lichtrinh = lichtrinh;
    }

    public String getDichvu() {
        return dichvu;
    }

    public void setDichvu(String dichvu) {
        this.dichvu = dichvu;
    }

    public ArrayList<Anh> getListanh() {
        return listanh;
    }

    public void setListanh(ArrayList<Anh> listanh) {
        this.listanh = listanh;
    }
    
    
}
