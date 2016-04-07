/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controladorConsulta;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author itsbj
 */
public class frmAgenda extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    private String[] criterioBusqueda;
    private TableRowSorter<TableModel> sorter;
// </editor-fold> 

    /**
     * Creates new form frmAgenda
     */
    public frmAgenda() {
        initComponents();
        init();
    }

    private void init() {
        criterioBusqueda = new String[2];
        llenarGrid();
        llenarFiltro();
        cargarTotalRegistros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpBusquedaAsignatura = new javax.swing.JPanel();
        lblFiltro = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox();
        txtCriterioBusqueda = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtAsignatura = new javax.swing.JTable();
        lblTotalRegistros = new javax.swing.JLabel();
        lblRegistros3 = new javax.swing.JLabel();
        jpRegistroUsuario = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtNombrePersona = new javax.swing.JTextField();
        lblPersona = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        lblClave3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtFormacionAcademica = new javax.swing.JTextField();
        lblClave5 = new javax.swing.JLabel();
        txtTelefonoFijo = new javax.swing.JTextField();
        lblClave6 = new javax.swing.JLabel();
        txtTelefonoMovil = new javax.swing.JTextField();
        lblClave7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblClave8 = new javax.swing.JLabel();
        lblRol1 = new javax.swing.JLabel();
        lblRol2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaInformacionAdicional = new javax.swing.JTextArea();
        lblRol3 = new javax.swing.JLabel();
        txtNumeroIdentificacion = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaDireccion = new javax.swing.JTextArea();
        dtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        lblEmpresa = new javax.swing.JLabel();
        lblPersona2 = new javax.swing.JLabel();
        lblPersona3 = new javax.swing.JLabel();
        lblPersona4 = new javax.swing.JLabel();
        lblPersona5 = new javax.swing.JLabel();
        lblPersona6 = new javax.swing.JLabel();
        lblPersona9 = new javax.swing.JLabel();
        lblPersona10 = new javax.swing.JLabel();
        lblPersona11 = new javax.swing.JLabel();
        lblPersona13 = new javax.swing.JLabel();
        lblRol4 = new javax.swing.JLabel();
        lblPersona15 = new javax.swing.JLabel();
        txtTipoIdentificacion = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGENDA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpBusquedaAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaAsignatura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaAsignatura.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaAsignatura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaAsignatura.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));

        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpBusquedaAsignatura.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 23));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioBusquedaActionPerformed(evt);
            }
        });
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaAsignatura.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 280, -1));

        jtAsignatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtAsignatura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtAsignatura.setGridColor(new java.awt.Color(0, 102, 153));
        jtAsignatura.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtAsignatura.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAsignaturaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtAsignatura);

        jpBusquedaAsignatura.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 440, 450));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaAsignatura.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        lblRegistros3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros3.setText("Registros:");
        lblRegistros3.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaAsignatura.add(lblRegistros3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        jPanel1.add(jpBusquedaAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        jpRegistroUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroUsuario.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo_Id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id.setText("Id:");
        lblTitulo_Id.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroUsuario.add(lblTitulo_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroUsuario.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        txtNombrePersona.setPreferredSize(new java.awt.Dimension(225, 25));
        txtNombrePersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePersonaActionPerformed(evt);
            }
        });
        txtNombrePersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombrePersonaKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtNombrePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 230, -1));

        lblPersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona.setText("*");
        lblPersona.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 10, -1));

        lblRol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol.setText("Tipo de Identificación:");
        lblRol.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, -1));

        lblClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave.setText("Nombres:");
        lblClave.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, 20));

        txtEmpresa.setEditable(false);
        txtEmpresa.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroUsuario.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 230, -1));

        lblClave3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave3.setText("Apellidos:");
        lblClave3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 20));

        txtApellido.setPreferredSize(new java.awt.Dimension(225, 25));
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 230, -1));

        txtFormacionAcademica.setPreferredSize(new java.awt.Dimension(225, 25));
        txtFormacionAcademica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFormacionAcademicaKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtFormacionAcademica, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 230, -1));

        lblClave5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave5.setText("Teléfono Fijo:");
        lblClave5.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 80, 20));

        txtTelefonoFijo.setPreferredSize(new java.awt.Dimension(225, 25));
        txtTelefonoFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoFijoKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtTelefonoFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 230, -1));

        lblClave6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave6.setText("Teléfono Móvil:");
        lblClave6.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 90, 20));

        txtTelefonoMovil.setPreferredSize(new java.awt.Dimension(225, 25));
        txtTelefonoMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoMovilActionPerformed(evt);
            }
        });
        txtTelefonoMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoMovilKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtTelefonoMovil, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 230, -1));

        lblClave7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave7.setText("Correo Electrónico:");
        lblClave7.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 130, 20));

        txtEmail.setPreferredSize(new java.awt.Dimension(225, 25));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 230, -1));

        lblClave8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave8.setText("Fecha Nacimiento:");
        lblClave8.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, 20));

        lblRol1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol1.setText("Dirección:");
        lblRol1.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 130, -1));

        lblRol2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol2.setText("Formación Académica:");
        lblRol2.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 130, -1));

        jScrollPane2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jScrollPane2KeyReleased(evt);
            }
        });

        txaInformacionAdicional.setColumns(20);
        txaInformacionAdicional.setLineWrap(true);
        txaInformacionAdicional.setRows(2);
        txaInformacionAdicional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaInformacionAdicionalKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaInformacionAdicional);

        jpRegistroUsuario.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 230, -1));

        lblRol3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol3.setText("Información Adicional:");
        lblRol3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 130, -1));

        txtNumeroIdentificacion.setPreferredSize(new java.awt.Dimension(100, 25));
        txtNumeroIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroIdentificacionActionPerformed(evt);
            }
        });
        txtNumeroIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroIdentificacionKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtNumeroIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        txaDireccion.setColumns(1);
        txaDireccion.setLineWrap(true);
        txaDireccion.setRows(2);
        txaDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDireccionKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txaDireccion);

        jpRegistroUsuario.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 230, -1));

        dtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        dtFechaNacimiento.setPreferredSize(new java.awt.Dimension(110, 25));
        jpRegistroUsuario.add(dtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));
        dtFechaNacimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Date date3 = new Date();
        dtFechaNacimiento.setDate(date3);

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmpresa.setText("Empresa:");
        lblEmpresa.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        lblPersona2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona2.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona2.setText("*");
        lblPersona2.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 10, -1));

        lblPersona3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona3.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona3.setText("*");
        lblPersona3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 10, -1));

        lblPersona4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona4.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona4.setText("*");
        lblPersona4.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 10, -1));

        lblPersona5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona5.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona5.setText("*");
        lblPersona5.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 10, -1));

        lblPersona6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona6.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona6.setText("*");
        lblPersona6.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 10, -1));

        lblPersona9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona9.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona9.setText("*");
        lblPersona9.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 10, -1));

        lblPersona10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona10.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona10.setText("*");
        lblPersona10.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 10, -1));

        lblPersona11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona11.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona11.setText("*");
        lblPersona11.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 10, -1));

        lblPersona13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona13.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona13.setText("*");
        lblPersona13.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 10, -1));

        lblRol4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol4.setText("Género:");
        lblRol4.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, -1));

        lblPersona15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona15.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona15.setText("*");
        lblPersona15.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 10, -1));

        txtTipoIdentificacion.setPreferredSize(new java.awt.Dimension(100, 25));
        txtTipoIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoIdentificacionActionPerformed(evt);
            }
        });
        txtTipoIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTipoIdentificacionKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtTipoIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 120, -1));

        txtGenero.setPreferredSize(new java.awt.Dimension(100, 25));
        txtGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneroActionPerformed(evt);
            }
        });
        txtGenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGeneroKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 120, -1));

        jPanel1.add(jpRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCriterioBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaActionPerformed

    private void txtCriterioBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaKeyPressed

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased
    private void convertirAmayusculas(Component componente) {

        if (componente instanceof JTextField) {
            JTextField text = (JTextField) componente;
            String cadena = (text.getText()).toUpperCase();
            text.setText(cadena);

        } else if (componente instanceof JTextArea) {
            JTextArea textArea = (JTextArea) componente;
            String cadena = (textArea.getText()).toUpperCase();
            textArea.setText(cadena);
        }

    }

    private void filtrar() {
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(txtCriterioBusqueda.getText(), cmbFiltro.getSelectedIndex() + 1);
            sorter.setRowFilter(rf);

        } catch (java.util.regex.PatternSyntaxException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Error Filtrar", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void jtAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAsignaturaMouseClicked
        int fila = jtAsignatura.getSelectedRow();//guarda la fila seleccionada
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarTutorEmpresarial(consultarRegistroIndividual(jtAsignatura.getValueAt(fila, 0).toString(), "persona_agenda"));
        }
    }//GEN-LAST:event_jtAsignaturaMouseClicked

    private void txtNombrePersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePersonaActionPerformed

    private void txtNombrePersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePersonaKeyReleased

        convertirAmayusculas(txtNombrePersona);
        txtNombrePersona.setText(controladorVariablesSesion.validarLetrasConEspacios(txtNombrePersona.getText()));
    }//GEN-LAST:event_txtNombrePersonaKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        convertirAmayusculas(txtApellido);
        txtApellido.setText(controladorVariablesSesion.validarLetrasConEspacios(txtApellido.getText()));
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtFormacionAcademicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormacionAcademicaKeyReleased
        convertirAmayusculas(txtFormacionAcademica);
    }//GEN-LAST:event_txtFormacionAcademicaKeyReleased

    private void txtTelefonoFijoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoFijoKeyReleased
        txtTelefonoFijo.setText(controladorVariablesSesion.validarNumerosSinEspacios(txtTelefonoFijo.getText()));
    }//GEN-LAST:event_txtTelefonoFijoKeyReleased

    private void txtTelefonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoMovilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoMovilActionPerformed

    private void txtTelefonoMovilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoMovilKeyReleased
        txtTelefonoMovil.setText(controladorVariablesSesion.validarNumerosSinEspacios(txtTelefonoMovil.getText()));
    }//GEN-LAST:event_txtTelefonoMovilKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased

    }//GEN-LAST:event_txtEmailKeyReleased

    private void txaInformacionAdicionalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaInformacionAdicionalKeyReleased
        convertirAmayusculas(txaInformacionAdicional);
    }//GEN-LAST:event_txaInformacionAdicionalKeyReleased

    private void jScrollPane2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane2KeyReleased

    }//GEN-LAST:event_jScrollPane2KeyReleased

    private void txtNumeroIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroIdentificacionActionPerformed

    }//GEN-LAST:event_txtNumeroIdentificacionActionPerformed

    private void txtNumeroIdentificacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroIdentificacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroIdentificacionKeyReleased

    private void txaDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDireccionKeyReleased
        convertirAmayusculas(txaDireccion);
    }//GEN-LAST:event_txaDireccionKeyReleased

    private void txtTipoIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoIdentificacionActionPerformed

    private void txtTipoIdentificacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoIdentificacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoIdentificacionKeyReleased

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed

    private void txtGeneroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeneroKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroKeyReleased
    private ArrayList<Object> consultarRegistroIndividual(String id, String tabla) {
        criterioBusqueda[0] = id;
        controladorConsulta consulta = new controladorConsulta();
        return consulta.obtenerConsulta(tabla, controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);
    }

    private void llenarTutorEmpresarial(ArrayList<Object> datos) {

        lblId.setText(String.valueOf(datos.get(0)));
        txtTipoIdentificacion.setText((String) datos.get(1));
        txtNumeroIdentificacion.setText((String) datos.get(2));
        txtNombrePersona.setText((String) datos.get(3));
        txtApellido.setText((String) datos.get(4));
        dtFechaNacimiento.setDate(stringToJDateChooser((String) datos.get(5)));
        txaDireccion.setText((String) datos.get(6));
        txtTelefonoFijo.setText((String) datos.get(7));
        txtTelefonoMovil.setText((String) datos.get(8));
        txtEmail.setText((String) datos.get(9));
        txtGenero.setText((String) datos.get(10));
        txtFormacionAcademica.setText((String) datos.get(11));
        txaInformacionAdicional.setText((String) datos.get(12));
        //txtEmpresa.setText((String) datos.get(13));

        

    }

    public Date stringToJDateChooser(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);
            System.out.println(fechaDate.toString());
            return fechaDate;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return fechaDate;
        }
    }

    private void llenarGrid() {
        jtAsignatura.setModel(controladorGrid.getInstance().llenarGrid("persona", "grid", null, true));
        sorter = new TableRowSorter<>(jtAsignatura.getModel());
        jtAsignatura.setRowSorter(sorter);
        jtAsignatura.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void formatearColumnas() {
        //Oculta la primera columna que corresponde al ID de la tabla
        jtAsignatura.getColumnModel().getColumn(0).setMaxWidth(0);
        jtAsignatura.getColumnModel().getColumn(0).setMinWidth(0);
        jtAsignatura.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    private void cargarTotalRegistros() {
        int total = jtAsignatura.getRowCount();
        lblTotalRegistros.setText(String.valueOf(total));
    }

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
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbFiltro;
    private com.toedter.calendar.JDateChooser dtFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpBusquedaAsignatura;
    private javax.swing.JPanel jpRegistroUsuario;
    private javax.swing.JTable jtAsignatura;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblClave3;
    private javax.swing.JLabel lblClave5;
    private javax.swing.JLabel lblClave6;
    private javax.swing.JLabel lblClave7;
    private javax.swing.JLabel lblClave8;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblPersona10;
    private javax.swing.JLabel lblPersona11;
    private javax.swing.JLabel lblPersona13;
    private javax.swing.JLabel lblPersona15;
    private javax.swing.JLabel lblPersona2;
    private javax.swing.JLabel lblPersona3;
    private javax.swing.JLabel lblPersona4;
    private javax.swing.JLabel lblPersona5;
    private javax.swing.JLabel lblPersona6;
    private javax.swing.JLabel lblPersona9;
    private javax.swing.JLabel lblRegistros3;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblRol1;
    private javax.swing.JLabel lblRol2;
    private javax.swing.JLabel lblRol3;
    private javax.swing.JLabel lblRol4;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaDireccion;
    private javax.swing.JTextArea txaInformacionAdicional;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtFormacionAcademica;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNombrePersona;
    private javax.swing.JTextField txtNumeroIdentificacion;
    private javax.swing.JTextField txtTelefonoFijo;
    private javax.swing.JTextField txtTelefonoMovil;
    private javax.swing.JTextField txtTipoIdentificacion;
    // End of variables declaration//GEN-END:variables
}
