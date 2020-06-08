/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.GiaoDienTourDAO;
import DTO.Tour;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ADMIN
 */
public class GiaoDienTourBLL {
    private static GiaoDienTourBLL instance ;
    
    public static GiaoDienTourBLL getInstance() {
        if(instance == null)
            instance = new GiaoDienTourBLL();
        return instance;
    }

    public GiaoDienTourBLL() {
    }
    
    public void getListTourSearch(ArrayList<Tour> listtour,String diemdi,String diemden,int max,int min){
        ResultSet data = GiaoDienTourDAO.getInstance().getListSearch(diemdi, diemden, max, min);
        try {
            while (data.next()) {
                Tour tour = new Tour(data.getString("matour"),data.getString("tentour"),data.getInt("giatour"),data.getInt("phantram"));
                listtour.add(tour);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienTourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getListTourKhuyenMai(ArrayList<Tour> listtour){
        ResultSet data = GiaoDienTourDAO.getInstance().getListTourKhuyenMai();
        try {
            while (data.next()) {
                Tour tour = new Tour(data.getString("matour"),data.getString("tentour"),data.getInt("giatour"),data.getInt("phantram"));
                listtour.add(tour);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienTourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadComboboxDiemXuatPhat(DefaultComboBoxModel model){
         ResultSet data = GiaoDienTourDAO.getInstance().getDienXuatPhat();
         model.addElement("---Chọn điểm đi---");
        try {
            while(data.next())
            {
                model.addElement(data.getString("diemxuatphat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienTourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void LoadComboboxDiadiem(DefaultComboBoxModel model){
         ResultSet data = GiaoDienTourDAO.getInstance().getDiaDiem();
         model.addElement("---Chọn điểm đến---");
        try {
            while(data.next())
            {
                model.addElement(data.getString("diadiem"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienTourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
