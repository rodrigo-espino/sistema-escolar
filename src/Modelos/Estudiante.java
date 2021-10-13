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
public class Estudiante {
    private int ID, Grado;
    private String Nombre, CURP, Grupo, Turno, Busqueda,T_Busqueda;

    public Estudiante() {
    }

    public Estudiante(int ID, int Grado, String Nombre, String CURP, String Grupo, String Turno, String Busqueda, String T_Busqueda) {
        this.ID = ID;
        this.Grado = Grado;
        this.Nombre = Nombre;
        this.CURP = CURP;
        this.Grupo = Grupo;
        this.Turno = Turno;
        this.Busqueda = Busqueda;
        this.T_Busqueda = T_Busqueda;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGrado() {
        return Grado;
    }

    public void setGrado(int Grado) {
        this.Grado = Grado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }

    public String getBusqueda() {
        return Busqueda;
    }

    public void setBusqueda(String Busqueda) {
        this.Busqueda = Busqueda;
    }

    public String getT_Busqueda() {
        return T_Busqueda;
    }

    public void setT_Busqueda(String T_Busqueda) {
        this.T_Busqueda = T_Busqueda;
    }

    
}
