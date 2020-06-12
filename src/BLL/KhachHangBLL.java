/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.*;
import DAO.KhachHangDAO;
import DTO.KhachHang;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chubo
 */
public class KhachHangBLL {

    private static KhachHangBLL instance;

    public static KhachHangBLL getInstance() {
        if (instance == null) {
            instance = new KhachHangBLL();
        }
        return instance;
    }

    public KhachHangBLL() {
    }

    public void getKhachHang(ArrayList<KhachHang> list) {
        ResultSet rs = KhachHangDAO.getInstance().GetListKhachHang();
       
        KhachHangDAO hd = KhachHangDAO.getInstance();
        
        try {
            while (rs.next()) {
                KhachHang khachhang = new KhachHang(rs.getString("makhachhang"), rs.getString("tenkhachhang"), rs.getInt("gioitinh"),
                        rs.getString("sodienthoai"), rs.getString("gmail"), rs.getString("diachi"), rs.getString("ngaysinh"));
                list.add(khachhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean Insert(KhachHang x)
    {
        return KhachHangDAO.getInstance().Insert(x);
    }
    public boolean Delete(String maKhachHang)
    {
        return KhachHangDAO.getInstance().Delete(maKhachHang);
    }
    public boolean Update(KhachHang x)
    {
        return KhachHangDAO.getInstance().Update(x);
    }
    public ResultSet GetKhachHangTheoMa(String maKhachHang)
    {
        return KhachHangDAO.getInstance().GetKhachHangTheoMa(maKhachHang);
    }
}
