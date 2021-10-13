/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author rodrigosantacruzespino
 */
public class Conexion {
    Connection con;
    public Connection getConnection(){
        try{
            String myDB = "jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5444020";
            con = DriverManager.getConnection(myDB,"sql5444020","qJlnttesR8");
            
            return con;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
