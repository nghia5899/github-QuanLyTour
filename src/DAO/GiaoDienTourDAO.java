/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class GiaoDienTourDAO {
    private static GiaoDienTourDAO instance ;
    
    public static GiaoDienTourDAO getInstance(){
        if(instance==null)
            instance = new GiaoDienTourDAO();
        return instance;
    }

    public GiaoDienTourDAO() {
    }
    
    public ResultSet getListTourKhuyenMai(){
        return DataProvider.getInstance().GetData("select  matour,tentour,giatour,phantram " +
                                                    "from  tour INNER JOIN khuyenmai  "
                                                    + "ON tour.makhuyenmai = khuyenmai.makhuyenmai ");
    }
    
    public ResultSet getDienXuatPhat(){
        return DataProvider.getInstance().GetData("SELECT diemxuatphat from tour GROUP BY diemxuatphat");
    }
    
    public ResultSet getDiaDiem(){
        return DataProvider.getInstance().GetData("SELECT diadiem from tour GROUP BY diadiem");
    }
    
    public ResultSet getListSearch(String diemdi,String diemden,int giatourmax, int giatoumin){
        String sql = "SELECT matour,tentour,giatour,phantram FROM tour INNER JOIN khuyenmai  "
                    + "ON tour.makhuyenmai = khuyenmai.makhuyenmai where ";
        StringBuilder dieukien = new StringBuilder();
        int dem=0;
        if(diemden!=null||diemdi!=null||giatourmax!=0){
            dieukien.append(sql);
            if(diemden!=null){
                if(dem>0)
                    dieukien.append(" and ");
                dieukien.append("diadiem = '"+diemden+"'");
                dem++;
            }
            if(diemdi!=null){
                if(dem>0)
                    dieukien.append(" and ");
                dieukien.append(" diemxuatphat = '"+diemdi+"'");
                dem++;
            }
            if (giatourmax!=0) {
                if(dem>0)
                    dieukien.append(" and ");
                dieukien.append(" giatour >= "+giatoumin+" AND giatour <= "+giatourmax+"");
                dem++;
            }
        }else{
             return getListTourKhuyenMai();
        }
        
        return DataProvider.getInstance().GetData(dieukien.toString()) ;
    }
}
