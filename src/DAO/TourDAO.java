/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Tour;
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
public class TourDAO {
    private static TourDAO instance ;
    
    public static TourDAO getInstance(){
        if(instance==null)
            instance = new TourDAO();
        return instance;
    }

    public TourDAO() {
        
    }
    
    public ResultSet GetListTour()
    {
        return DataProvider.getInstance().GetData("");
    }
    
    public ResultSet GetTourTheoMa(String matour)
    {
        return DataProvider.getInstance().GetData("Select * from tour where matour = '"+matour+"'");
    }
    
    
    
public int Insert(Tour x) {
        String query = "Insert into tour values('" + x.getMatour() + "','" + x.getTentour() + "','" + x.getDiemxuatphat() + "','" + x.getDiadiem() + "','" + x.getDiemdulich() + "','" + x.getDichvu() + "','" + x.getThoigiantour() + "'," + x.getGiatour() + ",'" + x.getMakhuyenmai()+ "')";
        try {
            Statement pre = DataProvider.getInstance().getConnection().createStatement();
            
            return pre.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public boolean Update(Tour x, String matour) {
        int result = 0;
//        UPDATE tour SET tentour="a", diemxuatphat="b" WHERE matour = "1"
        String query = "Update tour Set tentour = ?, diemxuatphat = ?, thoigiantour = ?, giatour = ?, diadiem = ?, diemdulich = ?, dichvu= ?, makhuyenmai = ? Where matour = ?";

        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.getTentour());
            pre.setString(2, x.getDiemxuatphat());
            pre.setString(3, x.getThoigiantour());
            pre.setString(4, Integer.toString(x.getGiatour()));
            pre.setString(5, x.getDiadiem());
            pre.setString(6, x.getDiemdulich());
            pre.setString(7, x.getDichvu());
            pre.setInt(8, x.getKhuyenmai());
            pre.setString(9, matour);
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    public ResultSet SearchTour(String matour) {
        return DataProvider.getInstance().GetData("Select * from tour where matour = '" + matour + "'");
    }

    public boolean Delete(String matour) {
        int result = 0;
        String query = "DELETE FROM tour WHERE matour = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, matour);
            result = pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    public ResultSet checkTrungDAO(String matour) {
        return DataProvider.getInstance().GetData("Select * from tour where matour = '" + matour + "'");
    }

    public ResultSet GetListTour(String select_from_tour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
