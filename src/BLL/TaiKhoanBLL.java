/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.taikhoan;
import java.util.ArrayList;
import DAO.TaiKhoanDAO;

/**
 *
 * @author chubo
 */
public class TaiKhoanBLL {
    static TaiKhoanBLL instance;
    public static TaiKhoanBLL getInstance() {
        if (instance == null) {
            instance = new TaiKhoanBLL();
        }
        return instance;
    }
    
    public ArrayList<taikhoan> getlisttaikhoan(){
        return TaiKhoanDAO.getInstance().getlisttaikhoan();
    }
}
