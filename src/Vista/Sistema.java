/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelos.Conexion;
import Modelos.Estudiante;
import Modelos.EstudianteDAO;
import Modelos.Form;
import Modelos.LoginDAO;
import Modelos.Usuarios;
import Modelos.UsuariosDAO;
import Modelos.login;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodrigosantacruzespino
 */
public class Sistema extends javax.swing.JFrame {
    login lg = new login();
    LoginDAO login = new LoginDAO();
    
    Estudiante est = new Estudiante();
    EstudianteDAO estDAO = new EstudianteDAO();
    
    Usuarios us = new Usuarios();
    UsuariosDAO usDAO = new UsuariosDAO();
    
    Form del= new Form();
    
    PreparedStatement ps;
    Connection con;
    Conexion cn = new Conexion();
    
    
    /**
     * Creates new form Sistema
     */
    DefaultTableModel modelo = new DefaultTableModel();
    public Sistema() {
        initComponents();
        TMenu.setSelectedIndex(2);
        this.setLocationRelativeTo(null);
        txtID.setVisible(false);
    }
    
    public Sistema(login priv){
        initComponents();
        this.setLocationRelativeTo(null);
        TMenu.setSelectedIndex(2);
        txtID.setVisible(false);
        
        
        if (priv.getTa().equals("C")) {
            btnEditarA.setEnabled(false);
            btnUsuarios.setEnabled(false);
            btnEliminarA.setEnabled(false);
            btnFormatear.setEnabled(false);
            LabelNombre.setText(priv.getNombre());
        }
        else  if(priv.getTa().equals("B")){
           btnFormatear.setEnabled(false);
           btnUsuarios.setEnabled(false);
           LabelNombre.setText(priv.getNombre());
        }
        else{
            LabelNombre.setText(priv.getNombre());
        }
    }
    
    public void ListarEstudiante(){
    List<Estudiante> ListarEst = estDAO.ListarEstudiante();
    modelo = (DefaultTableModel) TEstudiantes.getModel();
    Object[] ob = new Object[6];
    for (int i = 0; i < ListarEst.size(); i++) {
        ob[0] = ListarEst.get(i).getID();
        ob[1] = ListarEst.get(i).getNombre();
        ob[2] = ListarEst.get(i).getCURP();
        ob[3] = ListarEst.get(i).getGrado();
        ob[4] = ListarEst.get(i).getGrupo();
        ob[5] = ListarEst.get(i).getTurno();
        modelo.addRow(ob);
        
    }
    TEstudiantes.setModel(modelo);
}
    
   public void ListarUsuarios(){
    List<Usuarios> ListarUs = usDAO.ListarUsuarios();
    modelo = (DefaultTableModel) TableUsuarios.getModel();
    Object[] ob = new Object[5];
    for (int i = 0; i < ListarUs.size(); i++) {
        ob[0] = ListarUs.get(i).getID();
        ob[1] = ListarUs.get(i).getNombre();
        ob[2] = ListarUs.get(i).getUsuario();
        ob[3] = ListarUs.get(i).getCant();
        ob[4] = ListarUs.get(i).getTA();
        
        modelo.addRow(ob);
        
    }
    TableUsuarios.setModel(modelo);
}
    
    private void Limpiar(){
        txtIDA.setText("");
        txtNombreA.setText("");
        txtCURPA.setText("");
        cbxGradoA.setSelectedIndex(0);
        cbxGrupoA.setSelectedIndex(0);
        cbxTurnoA.setSelectedIndex(0);
        
        
        txtNombre.setText("");
        txtUsuario.setText("");
        txtPass.setText("");
        txtID.setText("");
        cbxTA.setSelectedIndex(0);
    }
    
    public void LimpiarTabla(){
    for (int i = 0; i < modelo.getRowCount(); i++) {
        modelo.removeRow(i);
        i--;
    }
       
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAlumnos = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnFormatear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        TMenu = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIDA = new javax.swing.JTextField();
        txtNombreA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCURPA = new javax.swing.JTextField();
        cbxGradoA = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxGrupoA = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxTurnoA = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TEstudiantes = new javax.swing.JTable();
        btnAgregarA = new javax.swing.JButton();
        btnEliminarA = new javax.swing.JButton();
        btnEditarA = new javax.swing.JButton();
        btnCancelarA = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbxTA = new javax.swing.JComboBox<>();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableUsuarios = new javax.swing.JTable();
        btnAgregarU = new javax.swing.JButton();
        btnEliminarU = new javax.swing.JButton();
        btnModificarU = new javax.swing.JButton();
        btnCancelarU = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Escolar - Main");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAlumnos.setText("Alumnos");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, 40));

        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, 40));

        btnFormatear.setText("B. Alumnos");
        btnFormatear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormatearActionPerformed(evt);
            }
        });
        jPanel1.add(btnFormatear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 100, 40));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Bienvenid@");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        LabelNombre.setText("Nombre");
        jPanel1.add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 500));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("ID:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtIDA.setEditable(false);
        jPanel2.add(txtIDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 40, -1));
        jPanel2.add(txtNombreA, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 180, -1));

        jLabel4.setText("Nombre:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel5.setText("CURP:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));
        jPanel2.add(txtCURPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 180, -1));

        cbxGradoA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Grado-", "1", "2", "3" }));
        jPanel2.add(cbxGradoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        jLabel6.setText("Grado:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jLabel7.setText("Grupo");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        cbxGrupoA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Grupo-", "A", "B", "C", "D", "E" }));
        jPanel2.add(cbxGrupoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        jLabel8.setText("Turno");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        cbxTurnoA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Turno-", "Matutino", "Vespertino" }));
        jPanel2.add(cbxTurnoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, -1));

        TEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "CURP", "Grado", "Grupo", "Turno"
            }
        ));
        TEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TEstudiantes);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 780, 340));

        btnAgregarA.setText("Agregar");
        btnAgregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        btnEliminarA.setText("Eliminar");
        btnEliminarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, -1, -1));

        btnEditarA.setText("Editar");
        btnEditarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 90, -1));

        btnCancelarA.setText("Cancelar");
        btnCancelarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, -1, -1));

        jButton11.setText("PDF");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        TMenu.addTab("tab1", jPanel2);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 160, 30));

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel12.setText("Nombre:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel13.setText("Usuario:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel14.setText("Contrase??a:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel15.setText("Tipo de Administrador:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        cbxTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Tipo  Administrador--", "A", "B", "C" }));
        jPanel4.add(cbxTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 160, 30));
        jPanel4.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 120, 30));
        jPanel4.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 130, 30));

        TableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Usuario", "Contrase??a", "TA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableUsuarios);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 780, 360));

        btnAgregarU.setText("Agregar");
        btnAgregarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregarU, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        btnEliminarU.setText("Eliminar");
        btnEliminarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminarU, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        btnModificarU.setText("Modificar");
        btnModificarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificarU, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        btnCancelarU.setText("Cancelar");
        btnCancelarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarUActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelarU, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));
        jPanel4.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, -1, -1));

        TMenu.addTab("tab3", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("Sistema de Control Escolar");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jLabel11.setText("Sistema creado Por Rodrigo Santacruz Espino");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, -1, -1));

        TMenu.addTab("tab4", jPanel5);

        getContentPane().add(TMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -30, 820, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        LimpiarTabla();
        TMenu.setSelectedIndex(0);
        ListarEstudiante();
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        LimpiarTabla();
        ListarUsuarios();
        TMenu.setSelectedIndex(1);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnFormatearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormatearActionPerformed
int pregunta = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar a todos los alumnos?", "Eliminar", WIDTH);
           if(pregunta == 0){
        ListarEstudiante();
     pdfE(); 
     del.Alumnos();
           }
    }//GEN-LAST:event_btnFormatearActionPerformed

    private void btnAgregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAActionPerformed
        if(!"".equals(txtNombreA.getText()) || !"".equals(txtCURPA.getText()) ){
          est.setNombre(txtNombreA.getText());
          est.setCURP(txtCURPA.getText());
          est.setGrado(Integer.parseInt(cbxGradoA.getSelectedItem().toString()));
          est.setGrupo(cbxGrupoA.getSelectedItem().toString());
          est.setTurno(cbxTurnoA.getSelectedItem().toString());
          LimpiarTabla();
          estDAO.RegistrarCliente(est);
          ListarEstudiante();
          Limpiar();            
        }
        else{
            JOptionPane.showMessageDialog(null, "Completar datos", "Error", HEIGHT);
        }
    }//GEN-LAST:event_btnAgregarAActionPerformed

    private void TEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TEstudiantesMouseClicked
        int fila = TEstudiantes.rowAtPoint(evt.getPoint());
        txtIDA.setText(TEstudiantes.getValueAt(fila, 0).toString());
        txtNombreA.setText(TEstudiantes.getValueAt(fila, 1).toString());
        txtCURPA.setText(TEstudiantes.getValueAt(fila, 2).toString());
        cbxGradoA.setSelectedItem(TEstudiantes.getValueAt(fila, 3).toString());
        cbxGrupoA.setSelectedItem(TEstudiantes.getValueAt(fila, 4).toString());
        cbxTurnoA.setSelectedItem(TEstudiantes.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TEstudiantesMouseClicked

    private void btnEliminarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAActionPerformed
        if(!"".equals(txtIDA.getText())){
           int pregunta = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar?", "Eliminar", WIDTH);
           if(pregunta == 0){
               int id = Integer.parseInt(txtIDA.getText());
               estDAO.EliminarAlumno(id);
               LimpiarTabla();
               ListarEstudiante();
               Limpiar();
           }
           
        }
    }//GEN-LAST:event_btnEliminarAActionPerformed

    private void btnEditarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAActionPerformed
        if("".equals(txtIDA.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione Una Fila", "Error", HEIGHT);
            
        }
        else{
            if(!"".equals(txtNombreA.getText()) || !"".equals(txtCURPA.getText()) ){
          est.setNombre(txtNombreA.getText());
          est.setCURP(txtCURPA.getText());
          est.setGrado(Integer.parseInt(cbxGradoA.getSelectedItem().toString()));
          est.setGrupo(cbxGrupoA.getSelectedItem().toString());
          est.setTurno(cbxTurnoA.getSelectedItem().toString());
          est.setID(Integer.parseInt(txtIDA.getText()));
          LimpiarTabla();
          estDAO.Modificar(est);
          ListarEstudiante();
          Limpiar();            
        }
        else{
            JOptionPane.showMessageDialog(null, "Completar datos", "Error", HEIGHT);
        }
          
        }
    }//GEN-LAST:event_btnEditarAActionPerformed

    private void btnCancelarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarAActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        pdf();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnAgregarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUActionPerformed
        if(!"".equals(txtUsuario.getText()) || !"".equals(txtPass.getText()) ){
          us.setNombre(txtNombre.getText());
          us.setUsuario(txtUsuario.getText());
          us.setCant(txtPass.getText());
          us.setTA(cbxTA.getSelectedItem().toString());
          
          LimpiarTabla();
          usDAO.RegistrarUsuario(us);
          ListarUsuarios();
          Limpiar();            
        }
        else{
            JOptionPane.showMessageDialog(null, "Completar datos", "Error", HEIGHT);
        }
    }//GEN-LAST:event_btnAgregarUActionPerformed

    private void TableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUsuariosMouseClicked
        int fila = TableUsuarios.rowAtPoint(evt.getPoint());
        txtID.setText(TableUsuarios.getValueAt(fila, 0).toString());
        txtNombre.setText(TableUsuarios.getValueAt(fila, 1).toString());
        txtUsuario.setText(TableUsuarios.getValueAt(fila, 2).toString());
        txtPass.setText(TableUsuarios.getValueAt(fila, 3).toString());
        cbxTA.setSelectedItem(TableUsuarios.getValueAt(fila, 4).toString());
        
    }//GEN-LAST:event_TableUsuariosMouseClicked

    private void btnEliminarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUActionPerformed
        if(!"".equals(txtID.getText())){
           int pregunta = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar?", "Eliminar", WIDTH);
           if(pregunta == 0){
               int id = Integer.parseInt(txtID.getText());
               usDAO.EliminarUsuario(id);
               LimpiarTabla();
               ListarEstudiante();
               Limpiar();
           }
           
        }
    }//GEN-LAST:event_btnEliminarUActionPerformed

    private void btnModificarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUActionPerformed
        if("".equals(txtID.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione Una Fila", "Error", HEIGHT);
            
        }
        else{
            if(!"".equals(txtUsuario.getText()) || !"".equals(txtPass.getText()) ){
          us.setNombre(txtNombre.getText());
          us.setUsuario(txtUsuario.getText());
          us.setCant(txtPass.getText());
          us.setTA(cbxTA.getSelectedItem().toString());
          us.setID(Integer.parseInt(txtID.getText()));
          LimpiarTabla();
          usDAO.Modificar(us);
          ListarUsuarios();
          Limpiar();            
        }
        else{
            JOptionPane.showMessageDialog(null, "Completar datos", "Error", HEIGHT);
        }
          
        }
    }//GEN-LAST:event_btnModificarUActionPerformed

    private void btnCancelarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarUActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarUActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Login l = new Login();
        l.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JTable TEstudiantes;
    private javax.swing.JTabbedPane TMenu;
    private javax.swing.JTable TableUsuarios;
    private javax.swing.JButton btnAgregarA;
    private javax.swing.JButton btnAgregarU;
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnCancelarA;
    private javax.swing.JButton btnCancelarU;
    private javax.swing.JButton btnEditarA;
    private javax.swing.JButton btnEliminarA;
    private javax.swing.JButton btnEliminarU;
    private javax.swing.JButton btnFormatear;
    private javax.swing.JButton btnModificarU;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JComboBox<String> cbxGradoA;
    private javax.swing.JComboBox<String> cbxGrupoA;
    private javax.swing.JComboBox<String> cbxTA;
    private javax.swing.JComboBox<String> cbxTurnoA;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCURPA;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDA;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreA;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

private void pdf(){
        try{
            
            FileOutputStream archivo;
            File file = new File("src/PDF/reporte.pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document ();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN,12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha: "+new SimpleDateFormat("dd-MM-yyyy").format(date)+" Hora: "+new SimpleDateFormat("kk:mm:ss").format(date)+"\n\n");
            
            PdfPTable Encabezado = new PdfPTable(2);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] columnaencabezado = new float[]{70f,40f};
            Encabezado.setWidths(columnaencabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            
            Encabezado.addCell("Sistema de Control Escolar \n Lista de Alumnos");
            Encabezado.addCell(fecha);
            
            doc.add(Encabezado);
            
            
            PdfPTable tablapro = new PdfPTable(5);
            tablapro.setWidthPercentage(100);
           tablapro.getDefaultCell().setBorder(0);
            float[] columnapro = new float[]{35f,35f,3f,3f,15f};
            
            tablapro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell pro2 = new PdfPCell(new Phrase("CURP: ", negrita));
            PdfPCell pro3 = new PdfPCell(new Phrase("Grado: ", negrita ));
            PdfPCell pro4 = new PdfPCell(new Phrase("Grupo: ", negrita ));
            PdfPCell pro5 = new PdfPCell(new Phrase("Turno: ", negrita ));
            
            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);
            pro5.setBorder(0);
            
            
            tablapro.addCell(pro1);
            tablapro.addCell(pro2);
            tablapro.addCell(pro3);
            tablapro.addCell(pro4);
            tablapro.addCell(pro5);
            
            
            for (int i = 0; i < TEstudiantes.getRowCount(); i++) {
                String nom = TEstudiantes.getValueAt(i,1).toString();
                String curp = TEstudiantes.getValueAt(i,2).toString();
                String grado = TEstudiantes.getValueAt(i,3).toString();
                String grupo = TEstudiantes.getValueAt(i,4).toString();
                String turno = TEstudiantes.getValueAt(i,5).toString();
                
                tablapro.addCell(nom);
                tablapro.addCell(curp);
                tablapro.addCell(grado);
                tablapro.addCell(grupo);
                tablapro.addCell(turno);
            }
            
            doc.add(tablapro);
            
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        }
        catch(DocumentException | IOException e){
            System.out.println(e);
                 
        }
    }

private void pdfE(){
        try{
            
            FileOutputStream archivo;
            File file = new File("src/PDF/alumnosEliminados.pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document ();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN,12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha: "+new SimpleDateFormat("dd-MM-yyyy").format(date)+" Hora: "+new SimpleDateFormat("kk:mm:ss").format(date)+"\n\n");
            
            PdfPTable Encabezado = new PdfPTable(2);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] columnaencabezado = new float[]{70f,40f};
            Encabezado.setWidths(columnaencabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            
            Encabezado.addCell("Sistema de Control Escolar \n Lista de Alumnos");
            Encabezado.addCell(fecha);
            
            doc.add(Encabezado);
            
            
            PdfPTable tablapro = new PdfPTable(5);
            tablapro.setWidthPercentage(100);
           tablapro.getDefaultCell().setBorder(0);
            float[] columnapro = new float[]{35f,35f,3f,3f,15f};
            
            tablapro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell pro2 = new PdfPCell(new Phrase("CURP: ", negrita));
            PdfPCell pro3 = new PdfPCell(new Phrase("Grado: ", negrita ));
            PdfPCell pro4 = new PdfPCell(new Phrase("Grupo: ", negrita ));
            PdfPCell pro5 = new PdfPCell(new Phrase("Turno: ", negrita ));
            
            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);
            pro5.setBorder(0);
            
            
            tablapro.addCell(pro1);
            tablapro.addCell(pro2);
            tablapro.addCell(pro3);
            tablapro.addCell(pro4);
            tablapro.addCell(pro5);
            
            
            for (int i = 0; i < TEstudiantes.getRowCount(); i++) {
                String nom = TEstudiantes.getValueAt(i,1).toString();
                String curp = TEstudiantes.getValueAt(i,2).toString();
                String grado = TEstudiantes.getValueAt(i,3).toString();
                String grupo = TEstudiantes.getValueAt(i,4).toString();
                String turno = TEstudiantes.getValueAt(i,5).toString();
                
                tablapro.addCell(nom);
                tablapro.addCell(curp);
                tablapro.addCell(grado);
                tablapro.addCell(grupo);
                tablapro.addCell(turno);
            }
            
            doc.add(tablapro);
            
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        }
        catch(DocumentException | IOException e){
            System.out.println(e);
                 
        }
    }

}