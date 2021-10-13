/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.logging.Logger;

/**
 *
 * @author rodrigosantacruzespino
 */
public class Usuarios {
    private int ID;
    private String Nombre, Usuario, Cant, TA;

    public Usuarios() {
    }

    public Usuarios(int ID, String Nombre, String Usuario, String Cant, String TA) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Usuario = Usuario;
        this.Cant = Cant;
        this.TA = TA;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getCant() {
        return Cant;
    }

    public void setCant(String Cant) {
        this.Cant = Cant;
    }

    public String getTA() {
        return TA;
    }

    public void setTA(String TA) {
        this.TA = TA;
    }
    
    
    
}
