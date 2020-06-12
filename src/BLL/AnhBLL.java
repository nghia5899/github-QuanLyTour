/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.AnhDAO;
import DAO.TourDAO;
import DTO.Anh;
import DTO.LichTrinh;
import DTO.Tour;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class AnhBLL {
    private static AnhBLL instance;
    public static AnhBLL getInstance(){
        if(instance==null)
            instance = new AnhBLL();
        return instance;
    }
    
    public void getListanh(ArrayList<Anh> listanh,String matour){
        ResultSet data = AnhDAO.getInstance().getListAnh(matour);
        listanh.clear();
        try {
            while (data.next()) {
                listanh.add(new Anh(data.getString("maanh"), data.getString("matour"), data.getString("linkanh")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean Xoaanh(String maanh){
        return AnhDAO.getInstance().XoaAnh(maanh);
    }
    public boolean ThemAnh(String matour,String linkanh){
        return AnhDAO.getInstance().Themanh(matour, linkanh);
    }
}
