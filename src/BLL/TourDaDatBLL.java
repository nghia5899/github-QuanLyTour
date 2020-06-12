/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.KhachHangDAO;
import DAO.TourDaDatDAO;
import DTO.KhachHang;
import DTO.TourDaDat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class TourDaDatBLL {
    private static TourDaDatBLL instance ;
    
    public static TourDaDatBLL getInstance(){
        if(instance==null)
            instance = new TourDaDatBLL();
        return instance;
    }
    
    public void getTourDaDaDat(ArrayList<TourDaDat> list){
        list.clear();
        ResultSet rs = TourDaDatDAO.getInstance().GetListTour();
              
        try {
            while (rs.next()) {
                TourDaDat tourDaDat = new TourDaDat(rs.getString("madanhsach"), rs.getString("tentour"), rs.getString("tenkhachhang"),
                         rs.getString("ngaydattour"), rs.getString("ngaykhoihanh"), rs.getString("sodienthoai"),
                        rs.getString("gmail"), rs.getInt("songuoilon"), rs.getInt("sotreem"), rs.getInt("tongtien"));
                        tourDaDat.setMakhachhang(rs.getString("khachhang.makhachhang"));
                list.add(tourDaDat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean CapNhatTourDaDat(TourDaDat tour){
        return TourDaDatDAO.getInstance().CapNhatTourDaDat(tour);
    }
    public boolean XoatourDaDat(TourDaDat tour){
        return TourDaDatDAO.getInstance().XoatourDaDat(tour);
    }
}
