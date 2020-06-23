/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import DTO.KhuyenMai;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author E7450
 */
public class KhuyenMaiDAO {

    private static KhuyenMaiDAO instance;

    public static KhuyenMaiDAO getInstance() {
        if (instance == null) {
            instance = new KhuyenMaiDAO();
        }
        return instance;
    }

    public KhuyenMaiDAO() {

    }

    public ResultSet GetListKM() {
        return DataProvider.getInstance().GetData("");
    }

    public ResultSet GetKMTheoMa(String makhuyenmai) {
        return DataProvider.getInstance().GetData("Select * from khuyenmai where makhuyenmai='" + makhuyenmai + "'");
    }

    public ResultSet GetListKM(String select_from_km) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public int Insert(KhuyenMai x) {
        String query = "Insert into khuyenmai values('" + x.getMakhuyenmai() + "'," + x.getPhantram() + ",'" + x.getNgaybatdau() + "','" + x.getNgayketthuc() + "')";
        try {
            Statement pre = DataProvider.getInstance().getConnection().createStatement();
            return pre.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int Update(KhuyenMai x, String makhuyenmai) {
        String sql = "Update khuyenmai Set phantram='" + x.getPhantram() + "',ngaybatdau='" + x.getNgaybatdau() + "',ngayketthuc='" + x.getNgayketthuc() + "' where makhuyenmai = '" + makhuyenmai + "'";
        try {
            Statement stm = DataProvider.getInstance().getConnection().createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int Delete(String makhuyenmai) {
        String sql = "DELETE FROM khuyenmai WHERE makhuyenmai='" + makhuyenmai + "'";
        try {
            System.out.println(sql);
            Statement stm = DataProvider.getInstance().getConnection().createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ResultSet Search(String makhuyenmai) {
        return DataProvider.getInstance().GetData("Select * from khuyenmai where makhuyenmai = '" + makhuyenmai + "'");
    }
}
