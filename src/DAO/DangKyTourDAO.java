/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHang;
import DTO.Tour;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DangKyTourDAO {
    private static DangKyTourDAO instance ;
    
    public static DangKyTourDAO getInstance(){
        if(instance==null)
            instance = new DangKyTourDAO();
        return instance;
    }
    
    public boolean insertdangky(Tour tour,String madatour,KhachHang khachHang,String ngayhientai ,String ngaykhoihanh,int songuoilon,int sotreem,int tongtien){
        int result = 0;
        
        
        String query = "insert into tourdabook values ('"+madatour+"','"+tour.getMatour()+"','"+khachHang.getMakhachhang()+"','"+ngayhientai+"','"+ngaykhoihanh+"',"+songuoilon+","+sotreem+","+tongtien+")";
        
        try {
            Statement pre = DataProvider.getInstance().getConnection().createStatement(); 
            result = pre.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
}
