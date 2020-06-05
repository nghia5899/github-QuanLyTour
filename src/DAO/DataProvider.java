package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataProvider {
    private static DataProvider instance;
    Connection connection;
    public static DataProvider getInstance() {
        if(instance == null)
            instance = new DataProvider();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    private DataProvider() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytour", "root", "");
            System.out.println("ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet GetData(String query)
    {
        ResultSet data = null;
        try {
            Statement state = connection.createStatement();
            data = state.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
}
