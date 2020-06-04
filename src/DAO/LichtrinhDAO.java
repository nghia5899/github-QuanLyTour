/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;

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
}
