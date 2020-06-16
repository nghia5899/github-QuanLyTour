/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import DTO.taikhoan;
import java.util.ArrayList;
import DAO.DataProvider;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author chubo
 */
public class TaiKhoanDAO {
    static TaiKhoanDAO instance;
    
    public static TaiKhoanDAO getInstance() {
        if (instance == null) {
            instance = new TaiKhoanDAO();
        }
        return instance;
    }
    
public ArrayList<taikhoan> laylist(){
    String sql="Select * From taikhoan";
    ArrayList<taikhoan> list =new ArrayList<>();
    ResultSet rs = DataProvider.getInstance().GetData(sql);
        try {
            while(rs.next()){
                taikhoan t = new taikhoan();
                t.setTendangnhap(rs.getString("tendangnhap"));
                t.setMatkhau(rs.getString("matkhau"));
                t.setLoaitaikhoan(rs.getString("loaitaikhoan"));
                list.add(t);
            }   } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
}
public boolean taikhoansql(String sql){
    int result = 0;
        
        try {
            Statement pre = DataProvider.getInstance().getConnection().createStatement();          
                result = pre.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
}
public ResultSet taikhoantim(String sql){
        return DataProvider.getInstance().GetData(sql);
}
}
