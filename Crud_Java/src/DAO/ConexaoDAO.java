package DAO;


import java.sql.Connection;

import java.sql.SQLException;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoDAO {
   
    public Connection conectaBD(){
        Connection conn = null;

        try {
            
            String url = "jdbc:mysql://localhost:3307/bancoteste?user=root&password=";
            conn = DriverManager.getConnection(url);
            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"ConexaoDAO"+erro);
            
        }
        return conn;
    
    
    
    }
    
    
}
