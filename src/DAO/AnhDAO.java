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
public class AnhDAO {
    private static AnhDAO instance ;
    
    public static AnhDAO getInstance(){
        if(instance!=null)
            instance = new AnhDAO();
        return instance;
    }
    public ResultSet GetListAnh(String matour)
    {
        return DataProvider.getInstance().GetDataSearch("",matour);
    }
    
}
