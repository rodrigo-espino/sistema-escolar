/*
 * To change this license header, choose License Headers in Project Properties.
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
public class EstudianteDAO {
   Conexion cn = new Conexion();
   Connection con;
   PreparedStatement ps;
   ResultSet rs;
   
   public boolean RegistrarCliente(Estudiante es){
       String sql = "INSERT INTO Alumnos (Nombre, CURP, Grado, Grupo, Turno) VALUES (?,?,?,?,?)";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, es.getNombre());
           ps.setString(2, es.getCURP());
           ps.setInt(3, es.getGrado());
           ps.setString(4, es.getGrupo());
           ps.setString(5, es.getTurno());
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
   
   public List ListarEstudiante(){
       List<Estudiante> ListaEst = new ArrayList();
       String sql = "SELECT * FROM Alumnos";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               Estudiante est = new Estudiante();
               est.setID(rs.getInt("ID"));
               est.setNombre(rs.getString("Nombre"));
               est.setCURP(rs.getNString("CURP"));
               est.setGrado(rs.getInt("Grado"));
               est.setGrupo(rs.getString("Grupo"));
               est.setTurno(rs.getString("Turno"));
               ListaEst.add(est);
           }
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, e, "Error", HEIGHT);
       }
       return ListaEst;
   }
   
   public boolean EliminarAlumno(int id){
    String sql = "DELETE FROM Alumnos WHERE ID = ?";
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
   
   public boolean Modificar(Estudiante est){
       String sql = "UPDATE Alumnos SET Nombre = ?, CURP = ?, Grado = ?, Grupo = ?, Turno = ? WHERE ID = ?";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, est.getNombre());
           ps.setString(2, est.getCURP());
           ps.setInt(3, est.getGrado());
           ps.setString(4, est.getGrupo());
           ps.setString(5, est.getTurno());
           ps.setInt(6, est.getID());
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
   
   public List BuscarEstudiante(Estudiante est){
       
       List<Estudiante> BuscarEst = new ArrayList();
       String sql = "SELECT * FROM Alumnos WHERE ? LIKE ?";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, est.getT_Busqueda());
           ps.setString(2, est.getBusqueda());
           rs = ps.executeQuery();
           System.out.println(rs.next());
           while(rs.next()){
               
               est.setID(rs.getInt("ID"));
               est.setNombre(rs.getString("Nombre"));
               est.setCURP(rs.getNString("CURP"));
               est.setGrado(rs.getInt("Grado"));
               est.setGrupo(rs.getString("Grupo"));
               est.setTurno(rs.getString("Turno"));
               BuscarEst.add(est);
           }
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, e, "Error", HEIGHT);
       }
       return BuscarEst;
   }
   
}
