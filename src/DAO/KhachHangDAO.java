/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class KhachHangDAO {
   static KhachHangDAO instance;
   
   public static KhachHangDAO getInstance(){
       if(instance!=null)
           instance = new KhachHangDAO();
       return instance;
   }
   
   private KhachHangDAO(){
       
   }
   
   public ResultSet GetListKhachHang(){
       return DataProvider.getInstance().GetData("");
   }
   public ResultSet GetKhachHangTheoMa(String maKhachHang){
        return DataProvider.getInstance().GetDataSearch("", maKhachHang);
   }
   
   
   //kiểm tra nếu tồn tại ở bảng đặt tour thì không xóa được
   public boolean KiemTraKhoaNgoai(String maKhachHang)
    {
        ResultSet data = DataProvider.getInstance().GetDataSearch("", maKhachHang);
        try {
            if(data.next())
                return data.getInt(1) > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
   public boolean Insert(KhachHang x)
    {
        int result = 0;
        String query = "Insert into dbo.KhachHang values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.getMakhachhang());
            
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    
    public boolean Update(KhachHang x)
    {
        int result = 0;
        String query = "Update dbo.KhachHang Set HoTen = ?, DiaChi = ?, SoDienThoai = ?, TrangThai = ? Where MaKhachHang = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.getTenkhachhang());
            
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    
    public boolean Delete(String maKhachHang)
    {
        int result = 0;
        String query = "Delete dbo.KhachHang Where MaKhachHang = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, maKhachHang);
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
}
