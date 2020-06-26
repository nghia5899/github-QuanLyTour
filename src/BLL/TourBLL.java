/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.AnhDAO;
import DAO.LichtrinhDAO;
import DAO.TourDAO;
import DTO.LichTrinh;
import DTO.Tour;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class TourBLL {
    private static TourBLL instance ;
    
    public static TourBLL getInstance() {
        if(instance == null)
            instance = new TourBLL();
        return instance;
    }

    public TourBLL() {
    }
    
    public ArrayList<LichTrinh> GetLichTrinh(String matour){
         ArrayList<LichTrinh> listlichtrinh = new ArrayList<>();
        ResultSet datalichtrinh = LichtrinhDAO.getInstance().GetListLichTrinh(matour);
        try {
            while (datalichtrinh.next()) {
                listlichtrinh.add(new LichTrinh(datalichtrinh.getString("malichtrinh"),datalichtrinh.getString("ngay"),datalichtrinh.getString("noidung")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listlichtrinh;
    }
    
    public void GetListTour(ArrayList<Tour> listtour){
        listtour.clear();
       
        ResultSet data = TourDAO.getInstance().GetListTour();
        
        try {
            while (data.next()) {
                ArrayList<LichTrinh> listllichtrinh = new ArrayList<>();                
                Tour tour = new Tour(data.getString("matour"),data.getString("tentour"),data.getString("diemxuatphat"),data.getString("diadiem"),data.getString("diemdulich"),
                                        data.getString("dichvu"),data.getString("thoigiantour"),data.getInt("giatour"),
                                         null,data.getInt("phantram"),"");
                listtour.add(tour);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Tour getTourTheoMa(String matour){
        ResultSet data = TourDAO.getInstance().GetTourTheoMa(matour);
        try {
            if(data.next()){
                return new Tour(data.getString("matour"),data.getString("tentour"),data.getString("diemxuatphat"),data.getString("diadiem"),data.getString("diemdulich"),
                        data.getString("dichvu"),data.getString("thoigiantour"),data.getInt("giatour"),
                        null,0,"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int demsolichtrinh(String matour){
        int songay=0;
        ResultSet data = LichtrinhDAO.getInstance().demsolichtrinh(matour);
        try {
            data.next();
             songay = data.getInt("songay");
        } catch (SQLException ex) {
            Logger.getLogger(TourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return songay;
    }
    
}
