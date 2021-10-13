/*
 * To change this license header, choose License Headers in Project Propertius.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author rodrigosantacruzespino
 */
public class UsuariosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarUsuario(Usuarios us){
       String sql = "INSERT INTO Usuarios (Nombre, Usuario, Cont, TA) VALUES (?,?,?,?)";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, us.getNombre());
           ps.setString(2, us.getUsuario());
           ps.setString(3, us.getCant());
           ps.setString(4, us.getTA());
           
           ps.execute();
           return true;
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, e, "Error", HEIGHT);
           System.out.println(e);
           return false;
       }
       finally{
           try{
           con.close();
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null, e, "Error", HEIGHT);
           }
           
       } 
   }
    
    public List ListarUsuarios(){
       List<Usuarios> ListaUsu = new ArrayList();
       String sql = "SELECT * FROM Usuarios";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               Usuarios us = new Usuarios();
               us.setID(rs.getInt("ID"));
               us.setNombre(rs.getString("Nombre"));
               us.setUsuario(rs.getNString("Usuario"));
               us.setCant(rs.getString("Cont"));
               us.setTA(rs.getString("TA"));
               
               ListaUsu.add(us);
           }
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, e, "Error", HEIGHT);
       }
       return ListaUsu;
   }
    
    public boolean EliminarUsuario(int id){
    String sql = "DELETE FROM Usuarios WHERE ID = ?";
    try{
        con = cn.getConnection();
        rs = ps.executeQuery();
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        return true;
    }   
    
    catch(SQLException e){
        System.out.println(e);
        JOptionPane.showMessageDialog(null, e, "Error", HEIGHT);
        return false;
    }
    finally{
        try{
            con.close();
        }
        catch(SQLException ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
        }
    }
}
    
    public boolean Modificar(Usuarios us){
       String sql = "UPDATE Usuarios SET Nombre = ?, Usuario = ?, Cont = ?, TA = ? WHERE ID = ?";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, us.getNombre());
           ps.setString(2, us.getUsuario());
           ps.setString(3, us.getCant());
           ps.setString(4, us.getTA());
           ps.setInt(5, us.getID());
           ps.execute();
           return true;
       }
       catch(SQLException e){
           System.out.println(e);
           JOptionPane.showMessageDialog(null, e, "Error Base de Datos", HEIGHT);
           return false;
       }
       finally{
           try{
               con.close(); 
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, e, "Error", HEIGHT);
               System.out.println(e);
           }
       }
   }
    
}
