/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.KhachHangDAO;
import DAO.LichtrinhDAO;
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
                        tourDaDat.setMatour(rs.getString("tour.matour"));
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
    
    public long getGiatour(String matour){
        ResultSet rs = TourDaDatDAO.getInstance().GetGiaTour(matour);
        long giatour = 0;
        try {
            while (rs.next()) {
                giatour = rs.getInt("giatour");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return giatour;
    }
    public void timkiemTourDaDaDat(ArrayList<TourDaDat> list,String matourdadat){
        list.clear();
        ResultSet rs = TourDaDatDAO.getInstance().timkiemTour(matourdadat);
              
        try {
            while (rs.next()) {
                TourDaDat tourDaDat = new TourDaDat(rs.getString("madanhsach"), rs.getString("tentour"), rs.getString("tenkhachhang"),
                         rs.getString("ngaydattour"), rs.getString("ngaykhoihanh"), rs.getString("sodienthoai"),
                        rs.getString("gmail"), rs.getInt("songuoilon"), rs.getInt("sotreem"), rs.getInt("tongtien"));
                        tourDaDat.setMakhachhang(rs.getString("khachhang.makhachhang"));
                        tourDaDat.setMatour(rs.getString("tour.matour"));
                list.add(tourDaDat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int checkma(String makhachhang){
        int songuoi=0;
        ResultSet data = TourDaDatDAO.getInstance().checkma(makhachhang);
        try {
            data.next();
             songuoi = data.getInt("songuoi");
        } catch (SQLException ex) {
            Logger.getLogger(TourBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return songuoi;
    }
}
