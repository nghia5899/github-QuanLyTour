/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class AnhDAO {
    private static AnhDAO instance ;
    
    public static AnhDAO getInstance(){
        if(instance==null)
            instance = new AnhDAO();
        return instance;
    }

    public AnhDAO() {
    }
    
    public ResultSet getListAnh(String matour){
        return DataProvider.getInstance().GetData("Select * from anh where matour = '"+matour+"'");
    }
    
    public boolean XoaAnh(String maanh){
        int result = 0;
         String query = "Delete from anh where maanh = '"+maanh+"'";
         try { 
            Statement pre = DataProvider.getInstance().getConnection().createStatement();
            result  = pre.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }
    public boolean Themanh(String matour,String linkanh){
        int result = 0;
        int so = 7;
         String query = "Insert into anh values ("+so+",'"+matour+"','"+linkanh+"')";
         try { 
            Statement pre = DataProvider.getInstance().getConnection().createStatement();
            result  = pre.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }
    
    
}
