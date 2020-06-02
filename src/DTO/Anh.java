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
public class Anh{
    String maanh ;
    String matour;
    String linkanh;

    public Anh(String maanh, String matour, String linkanh) {
        this.maanh = maanh;
        this.matour = matour;
        this.linkanh = linkanh;
    }

    public String getMaanh() {
        return maanh;
    }

    public void setMaanh(String maanh) {
        this.maanh = maanh;
    }

    public String getMatour() {
        return matour;
    }

    public void setMatour(String matour) {
        this.matour = matour;
    }

    public String getLinkanh() {
        return linkanh;
    }

    public void setLinkanh(String linkanh) {
        this.linkanh = linkanh;
    }
    
    
}
