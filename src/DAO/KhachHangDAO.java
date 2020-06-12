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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class KhachHangDAO {

    static KhachHangDAO instance;

    public static KhachHangDAO getInstance() {
        if (instance == null) {
            instance = new KhachHangDAO();
        }
        return instance;
    }

    private KhachHangDAO() {

    }

    public ResultSet GetListKhachHang() {
        return DataProvider.getInstance().GetData("Select * from khachhang");
    }

    public ResultSet GetKhachHangTheoMa(String maKhachHang) {
        return DataProvider.getInstance().GetDataSearch("Select * From khachhang Where makhachhang =?", maKhachHang);
    }

    //kiểm tra nếu tồn tại ở bảng đặt tour thì không xóa được
    public boolean KiemTraKhoaNgoai(String maKhachHang) {
        ResultSet data = DataProvider.getInstance().GetDataSearch("Select Count(*) From tourdabook Where makhachhang =?", maKhachHang);
        try {
            if (data.next()) {
                return data.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean Insert(KhachHang x) {
        int result = 0;
        String query = "Insert into khachhang values('"+x.getMakhachhang()+"', '"+x.getTenkhachhang()+"', "+x.getGioitinh()+", '"+x.getSodienthoai()+"', '"+x.getGmail()+"','"+x.getNgaysinh()+"','"+x.getDiachi()+"')";
        
        try {
            Statement pre = DataProvider.getInstance().getConnection().createStatement();          
                result = pre.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    public boolean Update(KhachHang x) {
        int result = 0;
        String query = "Update khachhang Set tenkhachhang = ?, gioitinh = ?, SoDienThoai = ?, gmail = ?, ngaysinh = ?, diachi = ? Where makhachhang = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.getTenkhachhang());
            pre.setString(2, Integer.toString(x.getGioitinh()));
            pre.setString(3, x.getSodienthoai());
            pre.setString(4, x.getGmail());
            pre.setString(5, x.getNgaysinh());
            pre.setString(6, x.getDiachi());
            pre.setString(7, x.getMakhachhang());
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    public boolean Delete(String maKhachHang) {
        int result = 0;
        String query = "Delete From khachhang Where MaKhachHang = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, maKhachHang);
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    public boolean KiemTraKhoaChinh(String maKhachHang) {
        ResultSet data = DataProvider.getInstance().GetData("Select count(*) from khachhang where makhachhang='" +maKhachHang+"'");
        try {
            if (data.next()) {
                return data.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
