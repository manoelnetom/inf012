/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ManoelNeto
 */
public class DerbyDbConnection {
    
    private static DerbyDbConnection conn;
    
    private DerbyDbConnection(){
        
    }
    
    public static DerbyDbConnection getInstancia(){
    
            if(conn==null){
                conn=new DerbyDbConnection();
            }
         return conn;   
    }
    
    public Connection getConexao() throws Exception{
    
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/loginjsfdb";
        return DriverManager.getConnection(url,"sa","123456");   
    }
    
}
