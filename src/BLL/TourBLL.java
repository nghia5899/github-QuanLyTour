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
    
    public void GetLichTrinh(ArrayList<LichTrinh> listlichtrinh,String matour){
        listlichtrinh.clear();
        ResultSet datalichtrinh = LichtrinhDAO.getInstance().GetListLichTrinh(matour);
        try {
            while (datalichtrinh.next()) {
                listlichtrinh.add(new LichTrinh(datalichtrinh.getString("ngay"),datalichtrinh.getString("noidung")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void GetListTour(ArrayList<Tour> listtour, Vector tableRecord){
        listtour.clear();
        tableRecord.clear();
        ResultSet data = TourDAO.getInstance().GetListTour();
        
        try {
            while (data.next()) {
                ArrayList<LichTrinh> listllichtrinh = new ArrayList<>();
                GetLichTrinh(listllichtrinh, data.getString("matour"));
                ResultSet dataanh = AnhDAO.getInstance().GetListAnh(data.getString("matour"));
                
                Tour tour = new Tour(data.getString("matour"),data.getString("tentour"),data.getString("diemxuatphat"),data.getString("diadiem"),data.getString("diemdulich"),
                                        data.getString("dichvu"),data.getString("thoigiantour"),data.getInt("giatour"),
                                         listllichtrinh,data.getInt("phantram"),dataanh.getString("linkanh"));
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
                ArrayList<LichTrinh> listllichtrinh = new ArrayList<>();
                GetLichTrinh(listllichtrinh, data.getString("matour"));
                ResultSet dataanh = AnhDAO.getInstance().GetListAnh(data.getString("matour"));
                return new Tour(data.getString("matour"),data.getString("tentour"),data.getString("diemxuatphat"),data.getString("diadiem"),data.getString("diemdulich"),
                        data.getString("dichvu"),data.getString("thoigiantour"),data.getInt("giatour"),
                        listllichtrinh,data.getInt("phantram"),dataanh.getString("linkanh"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
