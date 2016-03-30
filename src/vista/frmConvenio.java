package vista;

import com.toedter.calendar.JDateChooser;
import controlador.ControladorConvenio;
import controlador.controladorConsulta;
import controlador.controladorExcel;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Color;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmConvenio extends javax.swing.JInternalFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables">
    private Date fechaActual;
    private String accion;
    private String idViabilidad;
    ArrayList<String> codigoRol = new ArrayList<>();
    String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;

// </editor-fold >
    
    public frmConvenio() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[2];
        idViabilidad = "-1";
        llenarGrid();
        llenarFiltro();
        cargarTotalRegistros();
        fechaActual = new Date() ;
        dtFechaFin.setDate(fechaActual);
        dtFechaSuscripcion.setDate(fechaActual);

    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpRegistroUsuario = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblPersona = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblClave1 = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        lblClave2 = new javax.swing.JLabel();
        txtViabilidad = new javax.swing.JTextField();
        btnPersona = new javax.swing.JButton();
        lblRol1 = new javax.swing.JLabel();
        lblRol2 = new javax.swing.JLabel();
        lblRol3 = new javax.swing.JLabel();
        txtNumeroConvenio = new javax.swing.JTextField();
        txtAdmEmpSup = new javax.swing.JTextField();
        txtAdmEmpPrin = new javax.swing.JTextField();
        txtAdmInsSup = new javax.swing.JTextField();
        txtAdmInsPrin = new javax.swing.JTextField();
        dtFechaFin = new com.toedter.calendar.JDateChooser();
        dtFechaSuscripcion = new com.toedter.calendar.JDateChooser();
        lblRol4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        lblPersona5 = new javax.swing.JLabel();
        lblPersona6 = new javax.swing.JLabel();
        lblPersona7 = new javax.swing.JLabel();
        lblPersona8 = new javax.swing.JLabel();
        lblPersona9 = new javax.swing.JLabel();
        lblPersona10 = new javax.swing.JLabel();
        lblPersona11 = new javax.swing.JLabel();
        lblPersona12 = new javax.swing.JLabel();
        jpBusquedaUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConvenio = new javax.swing.JTable();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistros = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        lblBusqueda = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnNuevo1 = new javax.swing.JButton();

        setTitle("CONVENIO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_convenio_32.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(945, 535));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lblPersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona.setLabelFor(txtViabilidad);
        lblPersona.setText("Viabilidad:");
        lblPersona.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblRol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol.setText("<html>Suplente Empresa:</html>");
        lblRol.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        lblClave1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave1.setText("Fecha Fin:");
        lblClave1.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lblClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave.setText("Número Convenio:");
        lblClave.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblClave2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave2.setText("Fecha Suscripcion:");
        lblClave2.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtViabilidad.setEditable(false);
        txtViabilidad.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroUsuario.add(txtViabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, 25));

        btnPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnPersona.setToolTipText("BUSCAR");
        btnPersona.setBorder(null);
        btnPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonaActionPerformed(evt);
            }
        });
        jpRegistroUsuario.add(btnPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        lblRol1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol1.setText("<html>Principal Empresa :</html>");
        lblRol1.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, -1));

        lblRol2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol2.setText("<html>Principal Instituto:</html>");
        lblRol2.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        lblRol3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol3.setText("Observaciones:");
        lblRol3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        txtNumeroConvenio.setPreferredSize(new java.awt.Dimension(225, 25));
        txtNumeroConvenio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroConvenioKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtNumeroConvenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, 25));

        txtAdmEmpSup.setPreferredSize(new java.awt.Dimension(225, 25));
        txtAdmEmpSup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdmEmpSupKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtAdmEmpSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, 25));

        txtAdmEmpPrin.setPreferredSize(new java.awt.Dimension(225, 25));
        txtAdmEmpPrin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdmEmpPrinKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtAdmEmpPrin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, 25));

        txtAdmInsSup.setPreferredSize(new java.awt.Dimension(225, 25));
        txtAdmInsSup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdmInsSupKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtAdmInsSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, 25));

        txtAdmInsPrin.setPreferredSize(new java.awt.Dimension(225, 25));
        txtAdmInsPrin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdmInsPrinKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtAdmInsPrin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, 25));

        dtFechaFin.setToolTipText("aaaa-mm-dd");
        dtFechaFin.setDateFormatString("yyyy-MM-dd");
        dtFechaFin.setPreferredSize(new java.awt.Dimension(100, 25));
        jpRegistroUsuario.add(dtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, 25));
        dtFechaFin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Date date2 = new Date();
        dtFechaFin.setDate(date2);

        dtFechaSuscripcion.setToolTipText("aaaa-mm-dd");
        dtFechaSuscripcion.setDateFormatString("yyyy-MM-dd");
        dtFechaSuscripcion.setPreferredSize(new java.awt.Dimension(100, 25));
        jpRegistroUsuario.add(dtFechaSuscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, 25));
        dtFechaSuscripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Date date1 = new Date();
        dtFechaSuscripcion.setDate(date1);

        lblRol4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol4.setText("<html>Suplente Instituto:</html>");
        lblRol4.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txaObservaciones.setColumns(2);
        txaObservaciones.setRows(3);
        jScrollPane2.setViewportView(txaObservaciones);

        jpRegistroUsuario.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 220, -1));

        lblPersona5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona5.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona5.setText("*");
        lblPersona5.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 10, -1));

        lblPersona6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona6.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona6.setText("*");
        lblPersona6.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 10, -1));

        lblPersona7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona7.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona7.setText("*");
        lblPersona7.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 10, -1));

        lblPersona8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona8.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona8.setText("*");
        lblPersona8.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 10, -1));

        lblPersona9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona9.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona9.setText("*");
        lblPersona9.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 10, -1));

        lblPersona10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona10.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona10.setText("*");
        lblPersona10.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 10, -1));

        lblPersona11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona11.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona11.setText("*");
        lblPersona11.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 10, -1));

        lblPersona12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona12.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona12.setText("*");
        lblPersona12.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 10, -1));

        jPanel1.add(jpRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        jpBusquedaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaUsuario.setMinimumSize(new java.awt.Dimension(455, 520));
        jpBusquedaUsuario.setPreferredSize(new java.awt.Dimension(453, 520));
        jpBusquedaUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(430, 420));

        jtConvenio.setModel(new javax.swing.table.DefaultTableModel(
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
        jtConvenio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtConvenio.setGridColor(new java.awt.Color(0, 102, 153));
        jtConvenio.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtConvenio.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtConvenio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtConvenioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtConvenio);

        jpBusquedaUsuario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 430, 460));

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        jpBusquedaUsuario.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaUsuario.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 250, -1));

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
        lblFiltro.setPreferredSize(new java.awt.Dimension(32, 25));
        jpBusquedaUsuario.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jpBusquedaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_nuevo_40.png"))); // NOI18N
        btnNuevo.setToolTipText("NUEVO");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo);

        btnCrearActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_crear_actualizar_40.png"))); // NOI18N
        btnCrearActualizar.setToolTipText("GUARDAR");
        btnCrearActualizar.setBorder(null);
        btnCrearActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrearActualizar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_eliminar_40.png"))); // NOI18N
        btnEliminar.setToolTipText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cerrar_40.png"))); // NOI18N
        btnCerrar.setToolTipText("CERRAR");
        btnCerrar.setBorder(null);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 5, 190, 50));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos">
    private void jtConvenioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtConvenioMouseClicked
        
        int fila = jtConvenio.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        cambiarColorPanel(accion);
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarConvenio(consultarRegistroIndividual(jtConvenio.getValueAt(fila, 0).toString(), "convenio"));
        }
    }//GEN-LAST:event_jtConvenioMouseClicked

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();        
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroUsuario);//limpia las cajas de texto
        cambiarColorPanel(accion);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroUsuario);
            llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (controladorVariablesSesion.getInstance().eliminar(lblId.getText()) == 0) {
            accion = "crear";
            eliminar();//elimina el registro seleccionado
            llenarGrid();//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpRegistroUsuario);//limpia las cajas de texto
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
        
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonaActionPerformed
        buscar("viabilidad");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarViabilidad(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "viabilidad"));
    }//GEN-LAST:event_btnPersonaActionPerformed

    private void txtNumeroConvenioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroConvenioKeyReleased
        txtNumeroConvenio.setText(controladorVariablesSesion.validarNumerosConEspacios(txtNumeroConvenio.getText()));
    }//GEN-LAST:event_txtNumeroConvenioKeyReleased

    private void txtAdmEmpSupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdmEmpSupKeyReleased
        convertirAmayusculas(txtAdmEmpSup);
        txtAdmEmpSup.setText(controladorVariablesSesion.validarLetrasConEspacios(txtAdmEmpSup.getText()));
    }//GEN-LAST:event_txtAdmEmpSupKeyReleased

    private void txtAdmEmpPrinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdmEmpPrinKeyReleased
        convertirAmayusculas(txtAdmEmpPrin);
        txtAdmEmpPrin.setText(controladorVariablesSesion.validarLetrasConEspacios(txtAdmEmpPrin.getText()));
    }//GEN-LAST:event_txtAdmEmpPrinKeyReleased

    private void txtAdmInsSupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdmInsSupKeyReleased
        convertirAmayusculas(txtAdmInsSup);
        txtAdmInsSup.setText(controladorVariablesSesion.validarLetrasConEspacios(txtAdmInsSup.getText()));
    }//GEN-LAST:event_txtAdmInsSupKeyReleased

    private void txtAdmInsPrinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdmInsPrinKeyReleased
        convertirAmayusculas(txtAdmInsPrin);
        txtAdmInsPrin.setText(controladorVariablesSesion.validarLetrasConEspacios(txtAdmInsPrin.getText()));

    }//GEN-LAST:event_txtAdmInsPrinKeyReleased

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel(rutaArchivo,controladorGrid.getInstance().filtrarGrid(jtConvenio));
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Metodos">

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }
    
    private void cambiarColorPanel(String accion){
        
        if(accion.equals("crear")){
            jpRegistroUsuario.setBackground(Color.WHITE);
            lblRegistro.setText("CREANDO...");
        }else if(accion.equals("actualizar")){
            jpRegistroUsuario.setBackground(Color.lightGray);
            lblRegistro.setText("MODIFICANDO...");
        }  
        
    }
         
    
    private void cargarTotalRegistros() {
        int total = jtConvenio.getRowCount();
        lblTotalRegistros.setText(String.valueOf(total));
    }

    private ArrayList<Object> consultarRegistroIndividual(String id, String tabla) {
        criterioBusqueda[0] = id;
        controladorConsulta consulta = new controladorConsulta();
        return consulta.obtenerConsulta(tabla, controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);
    }

    private void convertirAmayusculas(javax.swing.JTextField jTextfieldS) {
        String cadena = (jTextfieldS.getText()).toUpperCase();
        jTextfieldS.setText(cadena);
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
        map.put("idViabilidad", idViabilidad);
        map.put("numeroConvenio", txtNumeroConvenio.getText());
        map.put("fechaFin", dateToString(dtFechaFin));
        map.put("fechaSuscripcion", dateToString(dtFechaSuscripcion));
        map.put("observaciones", txaObservaciones.getText());
        map.put("admEmpresaPrincipal", txtAdmEmpPrin.getText());
        map.put("admEmpresaSuplente", txtAdmEmpSup.getText());
        map.put("admInstitutoPrincipal", txtAdmInsPrin.getText());
        map.put("admInstitutoSuplente", txtAdmInsSup.getText());

        //instacia el controlador
        ControladorConvenio convenio = new ControladorConvenio();
        //llama al metodo para crear o actualizar segun sea la accion
        return convenio.crearActualizar(map);

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
        ControladorConvenio convenio = new ControladorConvenio();
        convenio.eliminar(map);
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
        jtConvenio.getColumnModel().getColumn(0).setMaxWidth(0);
        jtConvenio.getColumnModel().getColumn(0).setMinWidth(0);
        jtConvenio.getColumnModel().getColumn(0).setPreferredWidth(0);

        jtConvenio.getColumnModel().getColumn(5).setMaxWidth(0);
        jtConvenio.getColumnModel().getColumn(5).setMinWidth(0);
        jtConvenio.getColumnModel().getColumn(5).setPreferredWidth(0);

    }

    private void limpiarCajasTexto(Component component) {
        lblId.setText("0");
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
    
    private void llenarConvenio(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        idViabilidad = (String.valueOf(datos.get(1)));
        txtViabilidad.setText((String) datos.get(2));
        txtNumeroConvenio.setText((String) datos.get(3));
        dtFechaSuscripcion.setDate(stringToJDateChooser((String) datos.get(4)));
        dtFechaFin.setDate(stringToJDateChooser((String) datos.get(5)));
        txtAdmEmpPrin.setText((String) datos.get(6));
        txtAdmEmpSup.setText((String) datos.get(7));
        txtAdmInsPrin.setText((String) datos.get(8));
        txtAdmInsSup.setText((String) datos.get(9));
        txaObservaciones.setText((String) datos.get(10));

    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas() - 1; i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid() {
        jtConvenio.setModel(controladorGrid.getInstance().llenarGrid("convenio", "grid", null, true));
        sorter = new TableRowSorter<>(jtConvenio.getModel());
        jtConvenio.setRowSorter(sorter);
        jtConvenio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarViabilidad(ArrayList<Object> datos) {
        idViabilidad = (String.valueOf(datos.get(0)));
        txtViabilidad.setText((String) datos.get(2));

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
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify                     ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnPersona;
    private javax.swing.JComboBox<String> cmbFiltro;
    private com.toedter.calendar.JDateChooser dtFechaFin;
    private com.toedter.calendar.JDateChooser dtFechaSuscripcion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpBusquedaUsuario;
    private javax.swing.JPanel jpRegistroUsuario;
    private javax.swing.JTable jtConvenio;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblClave1;
    private javax.swing.JLabel lblClave2;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblPersona10;
    private javax.swing.JLabel lblPersona11;
    private javax.swing.JLabel lblPersona12;
    private javax.swing.JLabel lblPersona5;
    private javax.swing.JLabel lblPersona6;
    private javax.swing.JLabel lblPersona7;
    private javax.swing.JLabel lblPersona8;
    private javax.swing.JLabel lblPersona9;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblRol1;
    private javax.swing.JLabel lblRol2;
    private javax.swing.JLabel lblRol3;
    private javax.swing.JLabel lblRol4;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaObservaciones;
    private javax.swing.JTextField txtAdmEmpPrin;
    private javax.swing.JTextField txtAdmEmpSup;
    private javax.swing.JTextField txtAdmInsPrin;
    private javax.swing.JTextField txtAdmInsSup;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtNumeroConvenio;
    private javax.swing.JTextField txtViabilidad;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
}
