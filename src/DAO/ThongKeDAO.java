/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chubo
 */
public class ThongKeDAO {
    static ThongKeDAO instance;
    
    public static ThongKeDAO getInstance() {
        if (instance == null) {
            instance = new ThongKeDAO();
        }
        return instance;
    }
    
    private ThongKeDAO() {

    }
    public ResultSet thongke(String sql){
        return DataProvider.getInstance().GetData(sql);
    }
    public ArrayList<String> list(String tenCot, String sql){
        ArrayList<String> list = new ArrayList<>();
        ResultSet rs = DataProvider.getInstance().GetData(sql);
        try {
            while(rs.next()){
                String x=null;
                x=rs.getString(tenCot);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   
}
