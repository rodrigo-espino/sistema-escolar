/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author rodrigosantacruzespino
 */
public class login {
    private int ID;
    private String Nombre, Usuario, Cont, Ta;

    public login() {
    }

    public login(int ID, String Nombre, String Usuario, String Cont, String Ta) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Usuario = Usuario;
        this.Cont = Cont;
        this.Ta = Ta;
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

    public String getCont() {
        return Cont;
    }

    public void setCont(String Cont) {
        this.Cont = Cont;
    }

    public String getTa() {
        return Ta;
    }

    public void setTa(String Ta) {
        this.Ta = Ta;
    }
    
}
