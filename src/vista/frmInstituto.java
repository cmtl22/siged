package vista;

import com.toedter.calendar.JDateChooser;
import controlador.ControladorInstituto;
import controlador.controladorConsulta;
import controlador.controladorExcel;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Container;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmInstituto extends javax.swing.JInternalFrame {

    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 
    //id de las claves foreanas
    Date fechaActual;
    private String idRector = "-1";//Foreign Key

    private String accion = "crear"; //sirve para tomar los valores  crear o actualizar 
    private String[] criterioBusqueda; //parametro de consulta por medio del id y por busqueda que es por id  es un array por tener [] 
    private TableRowSorter<TableModel> sorter; //guarda todos los registros del grid .........////////// el grid es el jtable

    // auqi van los arrayai list de los combo box pero no existe aqui
    // aqui pongo mis mis variables que nesesito
    // </editor-fold > 
    public frmInstituto() {
        initComponents();
        accion = "crear"; //COMO LOGICA DEL PROGRAMA DICE._ POR DEFECTO CREAR UN REGISTRO 
        criterioBusqueda = new String[3];
        fechaActual = new Date();
        dtFechaCreacion.setDate(fechaActual);
        llenarGrid();
        cargarTotalRegistros();
        //
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpInstituto = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSiglas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCoordinacionZonal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCreacionResolucion = new javax.swing.JTextField();
        dtFechaCreacion = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDireccion = new javax.swing.JTextArea();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtRector = new javax.swing.JTextField();
        btnRector = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaNombre = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAdjuntarAnexos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jpBusquedaUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInstituto = new javax.swing.JTable();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistros = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        btnNuevo1 = new javax.swing.JButton();

        setTitle("INSTITUTO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_institutos_32.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(945, 535));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(945, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpInstituto.setBackground(new java.awt.Color(255, 255, 255));
        jpInstituto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpInstituto.setPreferredSize(new java.awt.Dimension(470, 520));
        jpInstituto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre:");
        jLabel4.setPreferredSize(new java.awt.Dimension(70, 25));
        jpInstituto.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Direccción:");
        jLabel5.setPreferredSize(new java.awt.Dimension(70, 25));
        jpInstituto.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Teléfono:");
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 25));
        jpInstituto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        txtTelefono.setPreferredSize(new java.awt.Dimension(87, 25));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });
        jpInstituto.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 270, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Correo:");
        jLabel7.setPreferredSize(new java.awt.Dimension(70, 25));
        jpInstituto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        txtCorreo.setPreferredSize(new java.awt.Dimension(87, 25));
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });
        jpInstituto.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 270, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Siglas:");
        jLabel8.setPreferredSize(new java.awt.Dimension(70, 25));
        jpInstituto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        txtSiglas.setPreferredSize(new java.awt.Dimension(87, 25));
        txtSiglas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSiglasActionPerformed(evt);
            }
        });
        txtSiglas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSiglasKeyReleased(evt);
            }
        });
        jpInstituto.add(txtSiglas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 270, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Coordinación Zonal:");
        jLabel9.setPreferredSize(new java.awt.Dimension(70, 25));
        jpInstituto.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, -1));

        txtCoordinacionZonal.setPreferredSize(new java.awt.Dimension(87, 25));
        txtCoordinacionZonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoordinacionZonalActionPerformed(evt);
            }
        });
        txtCoordinacionZonal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCoordinacionZonalKeyReleased(evt);
            }
        });
        jpInstituto.add(txtCoordinacionZonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 270, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Fecha Creación:");
        jLabel10.setPreferredSize(new java.awt.Dimension(70, 25));
        jpInstituto.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 90, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Creación Solución:");
        jLabel11.setPreferredSize(new java.awt.Dimension(70, 25));
        jpInstituto.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 110, -1));

        txtCreacionResolucion.setPreferredSize(new java.awt.Dimension(87, 25));
        txtCreacionResolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreacionResolucionActionPerformed(evt);
            }
        });
        txtCreacionResolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCreacionResolucionKeyReleased(evt);
            }
        });
        jpInstituto.add(txtCreacionResolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 270, -1));

        dtFechaCreacion.setDateFormatString("yyyy-MM-dd");
        dtFechaCreacion.setPreferredSize(new java.awt.Dimension(100, 25));
        jpInstituto.add(dtFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        txaDireccion.setColumns(2);
        txaDireccion.setLineWrap(true);
        txaDireccion.setRows(3);
        txaDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDireccionKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaDireccion);

        jpInstituto.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 270, 60));

        lblTitulo_Id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id.setText("Id:");
        lblTitulo_Id.setPreferredSize(new java.awt.Dimension(15, 20));
        jpInstituto.add(lblTitulo_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpInstituto.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");
        jpInstituto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 10, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");
        jpInstituto.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 10, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");
        jpInstituto.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 10, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*");
        jpInstituto.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 10, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*");
        jpInstituto.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 10, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("*");
        jpInstituto.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 10, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("*");
        jpInstituto.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 10, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("*");
        jpInstituto.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 10, -1));

        txtRector.setEditable(false);
        txtRector.setPreferredSize(new java.awt.Dimension(250, 25));
        txtRector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRectorActionPerformed(evt);
            }
        });
        jpInstituto.add(txtRector, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 270, -1));

        btnRector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnRector.setToolTipText("Buscar");
        btnRector.setBorder(null);
        btnRector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRector.setPreferredSize(new java.awt.Dimension(40, 40));
        btnRector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectorActionPerformed(evt);
            }
        });
        jpInstituto.add(btnRector, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Rector:");
        jLabel19.setPreferredSize(new java.awt.Dimension(70, 25));
        jpInstituto.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txaNombre.setColumns(2);
        txaNombre.setLineWrap(true);
        txaNombre.setRows(3);
        txaNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaNombreKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txaNombre);

        jpInstituto.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 270, 60));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*");
        jpInstituto.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 10, -1));

        jPanel1.add(jpInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        jLabel1.setText("BÚSQUEDA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        jLabel2.setText("REGISTRO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(230, 50));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_nuevo_40.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setPreferredSize(new java.awt.Dimension(40, 40));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevo);

        btnCrearActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_crear_actualizar_40.png"))); // NOI18N
        btnCrearActualizar.setToolTipText("Guardar");
        btnCrearActualizar.setBorder(null);
        btnCrearActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearActualizar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCrearActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCrearActualizar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_eliminar_40.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar);

        btnAdjuntarAnexos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_adjuntar_40.jpg"))); // NOI18N
        btnAdjuntarAnexos.setToolTipText("Nuevo");
        btnAdjuntarAnexos.setBorder(null);
        btnAdjuntarAnexos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdjuntarAnexos.setPreferredSize(new java.awt.Dimension(40, 40));
        btnAdjuntarAnexos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjuntarAnexosActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdjuntarAnexos);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cerrar_40.png"))); // NOI18N
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setBorder(null);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCerrar);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

        jpBusquedaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaUsuario.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtInstituto.setModel(new javax.swing.table.DefaultTableModel(
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
        jtInstituto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtInstituto.setGridColor(new java.awt.Color(0, 102, 153));
        jtInstituto.setPreferredSize(new java.awt.Dimension(300, 100));
        jtInstituto.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtInstituto.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtInstituto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtInstitutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtInstituto);

        jpBusquedaUsuario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 47, 440, 450));

        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        jpBusquedaUsuario.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 90, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaUsuario.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 300, -1));

        lblRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros.setText("Registros:");
        lblRegistros.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaUsuario.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaUsuario.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaUsuario.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jpBusquedaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        btnNuevo1.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_exportar_excel_32.png"))); // NOI18N
        btnNuevo1.setToolTipText("Exportar");
        btnNuevo1.setBorder(null);
        btnNuevo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo1.setPreferredSize(new java.awt.Dimension(40, 40));
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtSiglasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSiglasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSiglasActionPerformed

    private void txtCoordinacionZonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoordinacionZonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoordinacionZonalActionPerformed

    private void txtCreacionResolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreacionResolucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreacionResolucionActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpInstituto);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpInstituto);
            llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (controladorVariablesSesion.getInstance().eliminar(lblId.getText()) == 0) {
            accion = "crear";
            eliminar();//elimina el registro seleccionado
            llenarGrid();//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpInstituto);//limpia las cajas de texto
            cargarTotalRegistros();//carga el total de registros
    }//GEN-LAST:event_btnEliminarActionPerformed
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jtInstitutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtInstitutoMouseClicked
        int fila = jtInstituto.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarInstituto(consultarRegistroIndividual(jtInstituto.getValueAt(fila, 0).toString(), "instituto"));
        }
    }//GEN-LAST:event_jtInstitutoMouseClicked

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void btnAdjuntarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarAnexosActionPerformed
        int fila = jtInstituto.getSelectedRow();
        if (fila != -1) {
            criterioBusqueda[0] = jtInstituto.getValueAt(fila, 0).toString();
            criterioBusqueda[1] = "I";//tipo de documento anexo
            criterioBusqueda[2] = "Instituto";//descripcion de los anexos
            frmDocumentoAnexos frm = new frmDocumentoAnexos(null, true, criterioBusqueda);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Documento", "Seleccionar", 2);
        }
    }//GEN-LAST:event_btnAdjuntarAnexosActionPerformed

    private void txtCoordinacionZonalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoordinacionZonalKeyReleased
        convertirAmayusculas(txtCoordinacionZonal);    }//GEN-LAST:event_txtCoordinacionZonalKeyReleased

    private void txaDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDireccionKeyReleased
        convertirAmayusculas(txaDireccion);    }//GEN-LAST:event_txaDireccionKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        txtTelefono.setText(controladorVariablesSesion.validarNumerosConEspacios(txtTelefono.getText()));
        convertirAmayusculas(txtTelefono);    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtCreacionResolucionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreacionResolucionKeyReleased
        convertirAmayusculas(txtCreacionResolucion);    }//GEN-LAST:event_txtCreacionResolucionKeyReleased

    private void txtSiglasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSiglasKeyReleased
        convertirAmayusculas(txtSiglas);    }//GEN-LAST:event_txtSiglasKeyReleased

    private void txtRectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRectorActionPerformed

    private void btnRectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectorActionPerformed
        buscar();//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarRector(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona"));
    }//GEN-LAST:event_btnRectorActionPerformed

    private void txaNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaNombreKeyReleased
        convertirAmayusculas(txaNombre);
    }//GEN-LAST:event_txaNombreKeyReleased

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        convertirAminusculas(txtCorreo);
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel(rutaArchivo,controladorGrid.getInstance().filtrarGrid(jtInstituto));
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed
    
    // </editor-fold>  
// <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar() {
        frmConsultas consulta = new frmConsultas(null, true);//instancia la el formulario con la ventana de busqueda
        consulta.consultar("rector", "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtInstituto.getRowCount();
        lblTotalRegistros.setText(String.valueOf(total));
    }

    private ArrayList<Object> consultarRegistroIndividual(String id, String tabla) {
        criterioBusqueda[0] = id;
        controladorConsulta consulta = new controladorConsulta();
        return consulta.obtenerConsulta(tabla, controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);
    }

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

    private void convertirAminusculas(javax.swing.JTextField jTextfieldS) {
        String cadena = (jTextfieldS.getText()).toLowerCase();
        jTextfieldS.setText(cadena);
    }

    private boolean crearActualizar() {
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("accion", accion);
        map.put("id", lblId.getText());
        map.put("idPersona", idRector);
        map.put("nombre", txaNombre.getText());
        map.put("direccion", txaDireccion.getText());
        map.put("telefono", txtTelefono.getText());
        map.put("correo", txtCorreo.getText());
        map.put("siglas", txtSiglas.getText());
        map.put("coordinacionZonal", txtCoordinacionZonal.getText());
        map.put("fechaCreacion", dateToString(dtFechaCreacion));
        map.put("creacionResolucion", txtCreacionResolucion.getText());

        //instacia el controlador
        ControladorInstituto ControladorInstituto = new ControladorInstituto();
        //llama al metodo para crear o actualizar segun sea la accion
        return ControladorInstituto.crearActualizar(map);

    }

    private String dateToString(JDateChooser fecha) {
        Date fechaNacimiento;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        if (fecha.getDate() != null) {
            fechaNacimiento = fecha.getDate();
        } else {
            Date fechActual = new Date();
            fechaNacimiento = fechActual;
        }
        return formatoFecha.format(fechaNacimiento);
    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", lblId.getText());
        ControladorInstituto ControladorInstituto = new ControladorInstituto();
        ControladorInstituto.eliminar(map);

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

    private void formatearColumnas() {
        //Oculta la primera columna que corresponde al ID de la tabla
        jtInstituto.getColumnModel().getColumn(0).setMaxWidth(0); //ANCHO
        jtInstituto.getColumnModel().getColumn(0).setMinWidth(0); //LARGO
        jtInstituto.getColumnModel().getColumn(0).setPreferredWidth(0); //DEFECTO AQUI DEPENDE DEL LARGO Y DEL ANCHO
    }

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        idRector="-1";
        txaNombre.isFocusable();
        if (component instanceof JTextField) {

            JTextField text = (JTextField) component;
            text.setText("");

        } else if (component instanceof JTextArea) {
            JTextArea textArea = (JTextArea) component;
            textArea.setText("");
        } else if (component instanceof Container) {
            for (Component c : ((Container) component).getComponents()) {
                limpiarCajasTexto(c);
            }
        }
    }

    private void llenarGrid() {
        jtInstituto.setModel(controladorGrid.getInstance().llenarGrid("instituto", "grid", null, true));
        sorter = new TableRowSorter<>(jtInstituto.getModel());
        jtInstituto.setRowSorter(sorter);
        jtInstituto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
        llenarFiltro();
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarRector(ArrayList<Object> datos) {
        idRector = (String.valueOf(datos.get(0)));
        txtRector.setText(String.valueOf(datos.get(2)) + " " + String.valueOf(datos.get(1)));
    }

    private void llenarInstituto(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        txtRector.setText((String) datos.get(2) + " " + (String) datos.get(3));
        idRector=String.valueOf(datos.get(1));
        txaNombre.setText((String) datos.get(4));
        txaDireccion.setText((String) datos.get(5));
        txtTelefono.setText((String) datos.get(6));
        txtCorreo.setText((String) datos.get(7));
        txtSiglas.setText((String) datos.get(8));
        txtCoordinacionZonal.setText((String) datos.get(9));
        dtFechaCreacion.setDate(stringToJDateChooser((String) datos.get(10)));
        txtCreacionResolucion.setText((String) datos.get(11));

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

// </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="Variables declaration"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjuntarAnexos;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnRector;
    private javax.swing.JComboBox<String> cmbFiltro;
    private com.toedter.calendar.JDateChooser dtFechaCreacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpBusquedaUsuario;
    private javax.swing.JPanel jpInstituto;
    private javax.swing.JTable jtInstituto;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaDireccion;
    private javax.swing.JTextArea txaNombre;
    private javax.swing.JTextField txtCoordinacionZonal;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCreacionResolucion;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtRector;
    private javax.swing.JTextField txtSiglas;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
}
