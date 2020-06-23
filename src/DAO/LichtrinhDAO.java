/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LichTrinh;
import DTO.TourDaDat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class LichtrinhDAO {
     private static LichtrinhDAO instance ;
    
    public static LichtrinhDAO getInstance(){
        if(instance==null)
            instance = new LichtrinhDAO();
        return instance;
    }

    public LichtrinhDAO() {
    }
    
    public ResultSet GetListLichTrinh(String matour)
    {
        return DataProvider.getInstance().GetData("select * from lichtrinh where matour = '"+matour+"'");
    }
    public ResultSet demsolichtrinh(String matour){
        
        return DataProvider.getInstance().GetData("select count(*) as 'songay' from lichtrinh where matour = '"+matour+"'");
    }
   
    public boolean CapNhatLichTrinh(LichTrinh lichtrinh){
        int result = 0;
        String query = "UPDATE `lichtrinh` SET `noidung` = '"+lichtrinh.getNoidung()+"' where malichtrinh = '"+lichtrinh.getMalichtrinh()+"' ";
        try { 
            Statement pre = DataProvider.getInstance().getConnection().createStatement();
            result = pre.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(LichtrinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    public boolean themlichtrinh(String matour){
        int result =0;
        String query = "Insert into lichtrinh values(null,'"+matour+"','Ngay 1',null),"
                + "                                 (null,'"+matour+"','Ngay 2',null),"
                + "                                 (null,'"+matour+"','Ngay 3',null),"
                + "                                 (null,'"+matour+"','Ngay 4',null),"
                + "                                 (null,'"+matour+"','Ngay 5',null)";
        try { 
            Statement pre = DataProvider.getInstance().getConnection().createStatement();
            result = pre.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(LichtrinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
}
