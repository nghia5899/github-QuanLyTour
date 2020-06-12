/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.AnhDAO;
import DAO.DangKyTourDAO;
import DAO.KhachHangDAO;
import DTO.KhachHang;
import DTO.Tour;

/**
 *
 * @author ADMIN
 */
public class DangiKyTourBLL {
    private static DangiKyTourBLL instance ;
    
    public static DangiKyTourBLL getInstance(){
        if(instance==null)
            instance = new DangiKyTourBLL();
        return instance;
    }
    
    public boolean inserttourdabook(Tour tour,KhachHang khachHang ,String ngaykhoihanh,int songuoilon,int sotreem){
        boolean themkhachhang = KhachHangDAO.getInstance().Insert(khachHang);
        return DangKyTourDAO.getInstance().insertdangky(tour, khachHang, ngaykhoihanh, songuoilon, sotreem)&&themkhachhang;
    }
}
