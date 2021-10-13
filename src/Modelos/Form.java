/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigosantacruzespino
 */
public class Form {
    Conexion cn = new Conexion();
   Connection con;
   PreparedStatement ps;
   ResultSet rs;
    public boolean Alumnos(){
        String sql = "TRUNCATE TABLE Alumnos ";
        try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.execute();
           return true;
        }
        catch(SQLException e){
            System.out.println(e);
            return false;
        }
        finally{
           try{
           con.close();
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, e, "Error", HEIGHT);
           }
           
       }
        
    }
}
