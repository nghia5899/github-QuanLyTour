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
    
    public ArrayList<taikhoan> getlisttaikhoan(){
        ArrayList<taikhoan> list = new ArrayList<>();        
        try {
            ResultSet rs = DataProvider.getInstance().GetData("Select * From taikhoan");
            while(rs.next()){
                taikhoan tk = new taikhoan();
                tk.setTendangnhap(rs.getString("tendangnhap"));
                tk.setMatkhau(rs.getString("matkhau"));
                list.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
