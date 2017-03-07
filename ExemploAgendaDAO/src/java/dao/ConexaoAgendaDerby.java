/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ManoelNeto
 */
public class ConexaoAgendaDerby {
    
    private static ConexaoAgendaDerby conexao;

    private ConexaoAgendaDerby() throws Exception {
        setConexao();
    }
    
    public static ConexaoAgendaDerby getInstance() throws Exception{
        if (conexao ==null){
            conexao = new ConexaoAgendaDerby();
        }
       return conexao;
    }
    
    private Connection connection;
    private void setConexao() throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/ExemploDB","manoel","");
        connection =conn;
    }
    
    public Connection getConexao(){
        return connection;
    }
    
}
