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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class TourDAO {
    private static TourDAO instance ;
    
    public static TourDAO getInstance(){
        if(instance!=null)
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
        return DataProvider.getInstance().GetDataSearch("g",matour);
    }
    
    public boolean Insert(Tour x)
    {
        int result = 0;
        String query = "Insert into dbo.Hang values(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.getMatour());
            
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    
    public boolean Update(Tour x)
    {
        int result = 0;
        String query = "Update dbo.Hang Set TenHang = ?, DonViTinh = ?, SoLuongCo = ?, MaNhaCungCap = ?, MaLoai = ?, TrangThai = ? Where MaHang = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.getTentour());
            
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    
    public boolean Delete(String matour)
    {
        int result = 0;
        String query = "Delete dbo.Hang Where MaHang = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, matour);
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    
    
}
