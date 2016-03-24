package vista;

import com.toedter.calendar.JDateChooser;
import controlador.ControladorEntrevista;
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
import static vista.frmCronograma.cmbPeriodo;

public class frmEntrevista extends javax.swing.JInternalFrame {

    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 
    Date fechaActual;
    private String accion;
    private String idEmpresaSucursal;
    private String idEstudiante;
    private String tipo_consulta;

    ArrayList<String> codigoPeriodo = new ArrayList<>();
    ArrayList<String> codigoEstadoEntrevista = new ArrayList<>();
    ArrayList<String> codigoNivel = new ArrayList<>();
    String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;
// </editor-fold > 

    public frmEntrevista() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[3];
        idEmpresaSucursal = "-1";
        idEstudiante = "-1";
        fechaActual = new Date();
        dtFecha.setDate(fechaActual);
        tipo_consulta = "entrevista_estudiante";
        llenarFiltro();
        llenarComboPeriodos();
        llenarComboNiveles();
        llenarComboEstadoEntrevista();
        cargarTotalRegistros();
        if (controladorVariablesSesion.getInstance().getPerfilUsuario().equals("1")) {
            cmbPeriodo.setEnabled(true);
            tipo_consulta = "entrevista_estudiante_admin";
            llenarGrid(tipo_consulta);
        } else {
            tipo_consulta = "entrevista_estudiante";
            llenarGrid(tipo_consulta);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpRegistroEntrevista = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        cmbEstadoEntrevista = new javax.swing.JComboBox<>();
        lblEmpresaSucursal = new javax.swing.JLabel();
        lblEstadoEntrevista = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        lblEstudiante = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        txtNombresApellidos = new javax.swing.JTextField();
        btnEmpresaSucursal = new javax.swing.JButton();
        txtEmpresaSucursal = new javax.swing.JTextField();
        btnEstudiante = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        lblFecha = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        cmbNivel = new javax.swing.JComboBox<>();
        dtFecha = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbPeriodo = new javax.swing.JComboBox();
        jpBusquedaEntrevista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEntrevista = new javax.swing.JTable();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistros = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        btnNuevo1 = new javax.swing.JButton();
        lblBusqueda = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAdjuntarAnexos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("ENTREVISTA");
        setPreferredSize(new java.awt.Dimension(945, 535));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(945, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRegistroEntrevista.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroEntrevista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroEntrevista.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroEntrevista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo_Id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id.setText("Id:");
        lblTitulo_Id.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroEntrevista.add(lblTitulo_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroEntrevista.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        cmbEstadoEntrevista.setBackground(new java.awt.Color(204, 204, 255));
        cmbEstadoEntrevista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbEstadoEntrevista.setPreferredSize(new java.awt.Dimension(150, 25));
        cmbEstadoEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoEntrevistaActionPerformed(evt);
            }
        });
        jpRegistroEntrevista.add(cmbEstadoEntrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 230, -1));

        lblEmpresaSucursal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmpresaSucursal.setText("Empresa Sucursal:");
        lblEmpresaSucursal.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroEntrevista.add(lblEmpresaSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblEstadoEntrevista.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEstadoEntrevista.setText("Estado:");
        lblEstadoEntrevista.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroEntrevista.add(lblEstadoEntrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        lblObservaciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblObservaciones.setText("Observaciones:");
        lblObservaciones.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroEntrevista.add(lblObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lblEstudiante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEstudiante.setText("Estudiante:");
        lblEstudiante.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroEntrevista.add(lblEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblPeriodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPeriodo.setText("Periodo:");
        lblPeriodo.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroEntrevista.add(lblPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtNombresApellidos.setEditable(false);
        txtNombresApellidos.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroEntrevista.add(txtNombresApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        btnEmpresaSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnEmpresaSucursal.setToolTipText("Buscar");
        btnEmpresaSucursal.setBorder(null);
        btnEmpresaSucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpresaSucursal.setPreferredSize(new java.awt.Dimension(40, 40));
        btnEmpresaSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaSucursalActionPerformed(evt);
            }
        });
        jpRegistroEntrevista.add(btnEmpresaSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        txtEmpresaSucursal.setEditable(false);
        txtEmpresaSucursal.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroEntrevista.add(txtEmpresaSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        btnEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnEstudiante.setToolTipText("Buscar");
        btnEstudiante.setBorder(null);
        btnEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstudiante.setPreferredSize(new java.awt.Dimension(40, 40));
        btnEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudianteActionPerformed(evt);
            }
        });
        jpRegistroEntrevista.add(btnEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        txtCedula.setEditable(false);
        txtCedula.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroEntrevista.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        txaObservaciones.setColumns(2);
        txaObservaciones.setLineWrap(true);
        txaObservaciones.setRows(3);
        txaObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObservacionesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaObservaciones);

        jpRegistroEntrevista.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 230, 60));

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFecha.setText("Fecha:");
        lblFecha.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroEntrevista.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        lblNivel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNivel.setText("Nivel:");
        lblNivel.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroEntrevista.add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        cmbNivel.setBackground(new java.awt.Color(204, 204, 255));
        cmbNivel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbNivel.setPreferredSize(new java.awt.Dimension(150, 25));
        jpRegistroEntrevista.add(cmbNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 230, -1));

        dtFecha.setDateFormatString("yyyy-MM-dd");
        dtFecha.setPreferredSize(new java.awt.Dimension(100, 25));
        jpRegistroEntrevista.add(dtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jpRegistroEntrevista.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 10, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");
        jpRegistroEntrevista.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 10, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");
        jpRegistroEntrevista.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 10, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");
        jpRegistroEntrevista.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 10, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");
        jpRegistroEntrevista.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 10, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*");
        jpRegistroEntrevista.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 10, -1));

        cmbPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbPeriodo.setEnabled(false);
        cmbPeriodo.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroEntrevista.add(cmbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jPanel1.add(jpRegistroEntrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        jpBusquedaEntrevista.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaEntrevista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaEntrevista.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaEntrevista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtEntrevista.setModel(new javax.swing.table.DefaultTableModel(
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
        jtEntrevista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtEntrevista.setGridColor(new java.awt.Color(0, 102, 153));
        jtEntrevista.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtEntrevista.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtEntrevista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEntrevistaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEntrevista);

        jpBusquedaEntrevista.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 420));

        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        jpBusquedaEntrevista.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaEntrevista.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 190, -1));

        lblRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros.setText("Registros:");
        lblRegistros.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaEntrevista.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaEntrevista.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaEntrevista.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        btnNuevo1.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_exportar_excel_32.png"))); // NOI18N
        btnNuevo1.setToolTipText("Exportar");
        btnNuevo1.setBorder(null);
        btnNuevo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo1.setPreferredSize(new java.awt.Dimension(48, 48));
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });
        jpBusquedaEntrevista.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 40, 40));

        jPanel1.add(jpBusquedaEntrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));

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
        jPanel2.add(btnNuevo);

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
        jPanel2.add(btnCrearActualizar);

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
        jPanel2.add(btnEliminar);

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
        jPanel2.add(btnAdjuntarAnexos);

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
        jPanel2.add(btnCerrar);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 240, 50));

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
    private void jtEntrevistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEntrevistaMouseClicked
        int fila = jtEntrevista.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarEntrevista(consultarRegistroIndividual(jtEntrevista.getValueAt(fila, 0).toString(), "entrevista_estudiante"));
        }
    }//GEN-LAST:event_jtEntrevistaMouseClicked

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void btnEmpresaSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaSucursalActionPerformed
        buscar("empresa_sucursal");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarEmpresaSucursal(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "empresa_sucursal"));
    }//GEN-LAST:event_btnEmpresaSucursalActionPerformed

    private void btnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudianteActionPerformed
        buscar("estudiante");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarEstudiante(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona"));
    }//GEN-LAST:event_btnEstudianteActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (controladorVariablesSesion.getInstance().eliminar(lblId.getText()) == 0) {
            accion = "crear";
            eliminar();//elimina el registro seleccionado
            llenarGrid(tipo_consulta);//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpRegistroEntrevista);//limpia las cajas de texto
            cargarTotalRegistros();//carga el total de registros
    }//GEN-LAST:event_btnEliminarActionPerformed
    }
    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroEntrevista);
            llenarGrid(tipo_consulta);//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroEntrevista);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cmbEstadoEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoEntrevistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoEntrevistaActionPerformed

    private void btnAdjuntarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarAnexosActionPerformed
        int fila = jtEntrevista.getSelectedRow();
        if (fila != -1) {
            criterioBusqueda[0] = jtEntrevista.getValueAt(fila, 0).toString();
            criterioBusqueda[1] = "T";//tipo de documento anexo
            criterioBusqueda[2] = "Entrevista";//descripcion de los anexos
            frmDocumentoAnexos frm = new frmDocumentoAnexos(null, true, criterioBusqueda);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Documento", "Seleccionar", 2);
        }
    }//GEN-LAST:event_btnAdjuntarAnexosActionPerformed

    private void txaObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionesKeyReleased
        convertirAmayusculas(txaObservaciones);    }//GEN-LAST:event_txaObservacionesKeyReleased

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel(rutaArchivo,controladorGrid.getInstance().filtrarGrid(jtEntrevista));
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed
    private DefaultTableModel filtrarGrid() {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] datos = new String[jtEntrevista.getColumnCount()];
        for (int i = 0; i < jtEntrevista.getRowCount(); i++) {
            for (int j = 0; j < jtEntrevista.getColumnCount(); j++) {
                datos[j] = jtEntrevista.getValueAt(i, j).toString();
            }
            modelo.addRow(datos);
        }
        return modelo;
    }
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtEntrevista.getRowCount();
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
        map.put("idEmpresaSucursal", idEmpresaSucursal);
        map.put("idEstudiante", idEstudiante);
        map.put("idPeriodo", codigoPeriodo.get(cmbPeriodo.getSelectedIndex()));
        map.put("observaciones", txaObservaciones.getText());
        map.put("idEstadoEntrevista", codigoEstadoEntrevista.get(cmbEstadoEntrevista.getSelectedIndex()));
        map.put("fecha", dateToString(dtFecha));
        map.put("idNivel", codigoNivel.get(cmbNivel.getSelectedIndex()));

        //instacia el controlador
        ControladorEntrevista controladorEntrevista = new ControladorEntrevista();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorEntrevista.crearActualizar(map);

    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", lblId.getText());
        ControladorEntrevista controladorEntrevista = new ControladorEntrevista();
        controladorEntrevista.eliminar(map);
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
        jtEntrevista.getColumnModel().getColumn(0).setMaxWidth(0);
        jtEntrevista.getColumnModel().getColumn(0).setMinWidth(0);
        jtEntrevista.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        cmbNivel.setSelectedIndex(0);
        cmbEstadoEntrevista.setSelectedIndex(0);
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

    private void llenarComboPeriodos() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "periodo";
        criterioBusqueda[1] = "tabla";
        cmbPeriodo.setModel(consulta.consultarCombo(criterioBusqueda));
        cmbPeriodo.setSelectedIndex(1);
        codigoPeriodo = consulta.getCodigoCombo();
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid(String tipo) {
        jtEntrevista.setModel(controladorGrid.getInstance().llenarGrid(tipo, "grid", null, true));
        sorter = new TableRowSorter<>(jtEntrevista.getModel());
        jtEntrevista.setRowSorter(sorter);
        jtEntrevista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarEmpresaSucursal(ArrayList<Object> datos) {
        idEmpresaSucursal = (String.valueOf(datos.get(0)));
        txtEmpresaSucursal.setText((String) datos.get(4));
    }

    private void llenarEstudiante(ArrayList<Object> datos) {
        idEstudiante = (String.valueOf(datos.get(0)));
        txtCedula.setText(String.valueOf(datos.get(4)));
        txtNombresApellidos.setText((String) datos.get(2) + " " + (String) datos.get(1));

    }

    private void llenarComboNiveles() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "NIVEL";
        criterioBusqueda[1] = "enumeracion";
        cmbNivel.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoNivel = consulta.getCodigoCombo();
    }

    private void llenarComboEstadoEntrevista() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "ESTADO ENTREVISTA";
        criterioBusqueda[1] = "enumeracion";
        cmbEstadoEntrevista.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoEstadoEntrevista = consulta.getCodigoCombo();
    }

    private void llenarEntrevista(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        idEmpresaSucursal = (String.valueOf(datos.get(1)));
        idEstudiante = (String.valueOf(datos.get(2)));
        cmbNivel.setSelectedItem(datos.get(3));
        cmbEstadoEntrevista.setSelectedItem(datos.get(4));
        txtEmpresaSucursal.setText((String) datos.get(5));
        txtCedula.setText((String) datos.get(6));
        txtNombresApellidos.setText((String) datos.get(7));
        txaObservaciones.setText((String) datos.get(8));
        dtFecha.setDate(stringToJDateChooser((String) datos.get(9)));
        cmbPeriodo.setSelectedItem(datos.get(10));
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
    private javax.swing.JButton btnAdjuntarAnexos;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEmpresaSucursal;
    private javax.swing.JButton btnEstudiante;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JComboBox<String> cmbEstadoEntrevista;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JComboBox<String> cmbNivel;
    public static javax.swing.JComboBox cmbPeriodo;
    private com.toedter.calendar.JDateChooser dtFecha;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpBusquedaEntrevista;
    private javax.swing.JPanel jpRegistroEntrevista;
    private javax.swing.JTable jtEntrevista;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblEmpresaSucursal;
    private javax.swing.JLabel lblEstadoEntrevista;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaObservaciones;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtEmpresaSucursal;
    private javax.swing.JTextField txtNombresApellidos;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
