/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.DataProvider;
import java.sql.ResultSet;
import DAO.ThongKeDAO;
import java.util.ArrayList;

/**
 *
 * @author chubo
 */
public class ThongKeBLL {
    static ThongKeBLL instance;
    public static ThongKeBLL getInstance() {
        if (instance == null) {
            instance = new ThongKeBLL();
        }
        return instance;
    }
    public ArrayList<String> list(String tenCot, String tenBang){
        return ThongKeDAO.getInstance().list(tenCot,tenBang);
    }
    public ResultSet thongke(String sql){
        return ThongKeDAO.getInstance().thongke(sql);
    }
}
