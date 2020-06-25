/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TourDaDat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class TourDaDatDAO {
    private static TourDaDatDAO instance ;
    
    public static TourDaDatDAO getInstance(){
        if(instance==null)
            instance = new TourDaDatDAO();
        return instance;
    }

    public TourDaDatDAO() {
    }
    
    public ResultSet GetListTour()
    {
        return DataProvider.getInstance().GetData("SELECT `madanhsach`, `tentour`, `ngaykhoihanh`, `ngaydattour`, `tenkhachhang`, `sodienthoai`, `gmail`,`songuoilon`,`sotreem`,`tongtien`, khachhang.makhachhang , tour.matour \n" +
"FROM `tourdabook` INNER JOIN khachhang on tourdabook.makhachhang = khachhang.makhachhang INNER JOIN tour on tour.matour = tourdabook.matour ");
    }
    
    public boolean CapNhatTourDaDat(TourDaDat tour){
        int result = 0,result1 = 0;
        String query = "Update tourdabook Set ngaydattour = '"+tour.getNgaydattour()+"', ngaykhoihanh = '"+tour.getNgaykhoihanh()+"', songuoilon = "+tour.getSonguoilon()+", sotreem = "+tour.getSotreem()+", tongtien = "+tour.getTongtien()+" where  madanhsach = '"+tour.getMadanhsach()+"'";
        String query1 = "Update khachhang Set tenkhachhang = '"+tour.getTenkhachhang()+"', sodienthoai = '"+tour.getSodienthoai()+"', gmail = '"+tour.getGmail()+"' where makhachhang = '"+tour.getMakhachhang()+"'";
        try { 
            Statement pre = DataProvider.getInstance().getConnection().createStatement();
            Statement pre1 = DataProvider.getInstance().getConnection().createStatement();
            result1 = pre1.executeUpdate(query1);
            result = pre.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0&& result1>0;
    }
    
    public boolean XoatourDaDat(TourDaDat tour){
        int result = 0;
        String query = "delete from tourdabook  where  madanhsach = '"+tour.getMadanhsach()+"'";
        try { 
            Statement pre = DataProvider.getInstance().getConnection().createStatement();
            result = pre.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Xoakhachhang(tour);
        return result > 0 ;
    }
    public boolean Xoakhachhang(TourDaDat tour){
        int result = 0;
        String query1 = "delete from khachhang  where makhachhang = '"+tour.getMakhachhang()+"'";
        Statement pre1;
        try {
            pre1 = DataProvider.getInstance().getConnection().createStatement();
            result = pre1.executeUpdate(query1);
        } catch (SQLException ex) {
            Logger.getLogger(TourDaDatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }
    public ResultSet GetGiaTour(String matour){
        
        return DataProvider.getInstance().GetData("select giatour from tour where matour = '"+matour+"'");
    }
    
    public ResultSet timkiemTour(String matourdadat){
        return DataProvider.getInstance().GetData("SELECT `madanhsach`, `tentour`, `ngaykhoihanh`, `ngaydattour`, `tenkhachhang`, `sodienthoai`, `gmail`,`songuoilon`,`sotreem`,`tongtien`, khachhang.makhachhang , tour.matour \n" +
"FROM `tourdabook` INNER JOIN khachhang on tourdabook.makhachhang = khachhang.makhachhang INNER JOIN tour on tour.matour = tourdabook.matour where madanhsach like '%"+matourdadat+"%'");
    }
    
    public ResultSet checkma(String makhachhang){
        
        return DataProvider.getInstance().GetData("select count(*) as 'songuoi' from khachhang where makhachhang = '"+makhachhang+"'");
    }
}
