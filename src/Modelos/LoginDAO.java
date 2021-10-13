/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Modelos.login;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author rodrigosantacruzespino
 */
public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public login log(String Usuario, String Pass){
        login l = new login();
        String sql = "Select * from Usuarios where Usuario = ? and Cont = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Usuario);
            ps.setString(2,Pass);
            rs = ps.executeQuery();
            if(rs.next()){
                l.setID(rs.getInt("ID"));
                l.setNombre(rs.getString("Nombre"));
                l.setUsuario(rs.getString("Usuario"));
                l.setCont(rs.getString("Cont"));
                l.setTa(rs.getString("TA"));
                
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return l ;
    }
}
