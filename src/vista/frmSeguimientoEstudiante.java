package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import controlador.ControladorSeguimientoEstudiante;
import controlador.controladorConsulta;
import controlador.controladorExcel;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Container;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import static vista.frmCronograma.cmbPeriodo;

public class frmSeguimientoEstudiante extends javax.swing.JInternalFrame {
// <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 
    //id de las claves foraneas
    Date fechaActual;
    private String idEstudiante = "-1";//Foreign Key
    private String idTutorEmpresarial = "-1";//Foreign Key
    private String idTutorAcademico = "-1";//Foreign Key
    private String idEmpresaSucursal = "-1";//Foreign Key
    private String tipo_consulta;

    private String accion = "crear";//para saber si estoy creando o actualizando (crear, actualizar)
    private String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;//guarda todos los registros del grid

    ArrayList<String> codigoPeriodo = new ArrayList<>();
    ArrayList<String> codigoNivel = new ArrayList<>();

    DefaultListModel modelo = new DefaultListModel();
    FileInputStream[] archivos;
    int[] tamanioArchivos;
// </editor-fold > 

    public frmSeguimientoEstudiante() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[3];
        fechaActual = new Date();
        dtFechaInicio.setDate(fechaActual);
        dtFechaFin.setDate(fechaActual);
        tipo_consulta = "seguimiento_estudiante";
        llenarComboPeriodos();
        llenarComboNiveles();
        cargarTotalRegistros();
        if (controladorVariablesSesion.getInstance().getPerfilUsuario().equals("1")) {
            cmbPeriodo.setEnabled(true);
            tipo_consulta = "seguimiento_estudiante_admin";
            llenarGrid(tipo_consulta);
        } else {
            tipo_consulta = "seguimiento_estudiante";
            llenarGrid(tipo_consulta);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jpRegistroSeguimientoEstudiante = new javax.swing.JPanel();
        lblPeriodo = new javax.swing.JLabel();
        lblTutorEmpresarial = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        lblNotaInstituto = new javax.swing.JLabel();
        cmbNivel = new javax.swing.JComboBox();
        txtTutorAcademico = new javax.swing.JTextField();
        lblTutorAcademico = new javax.swing.JLabel();
        txtEmpresaSucursal = new javax.swing.JTextField();
        cmbPeriodo = new javax.swing.JComboBox();
        lblPromedio = new javax.swing.JLabel();
        txtPromedio = new javax.swing.JTextField();
        lblEstudiante = new javax.swing.JLabel();
        txtNombresApellidos = new javax.swing.JTextField();
        lblNotaEmpresarial = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo2 = new javax.swing.JButton();
        btnCrearActualizar2 = new javax.swing.JButton();
        btnEliminar2 = new javax.swing.JButton();
        btnCerrar2 = new javax.swing.JButton();
        txtTutorEmpresarial = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtNotaInstituto = new javax.swing.JTextField();
        txtNotaEmpresarial = new javax.swing.JTextField();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnEstudiante = new javax.swing.JButton();
        btnTutorEmpresarial = new javax.swing.JButton();
        btnTutorAcademico = new javax.swing.JButton();
        btnEmpresaSucursal = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblFechaReunion = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dtFechaInicio = new com.toedter.calendar.JDateChooser();
        lblFechaReunion1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        dtFechaFin = new com.toedter.calendar.JDateChooser();
        lblBusqueda = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        jpBusquedaSeguimientoEstudiante = new javax.swing.JPanel();
        lblFiltro = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox();
        txtCriterioBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSeguimientoEstudiante = new javax.swing.JTable();
        lblRegistros = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAdjuntarAnexos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnNuevo1 = new javax.swing.JButton();

        setTitle("SEGUIMIENTO ESTUDIANTE");
        setPreferredSize(new java.awt.Dimension(945, 535));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(945, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 845, -1, -1));

        jpRegistroSeguimientoEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroSeguimientoEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroSeguimientoEstudiante.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroSeguimientoEstudiante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPeriodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPeriodo.setText("Período:");
        jpRegistroSeguimientoEstudiante.add(lblPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblTutorEmpresarial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTutorEmpresarial.setText("Tutor Empresarial:");
        jpRegistroSeguimientoEstudiante.add(lblTutorEmpresarial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmpresa.setText("Empresa:");
        jpRegistroSeguimientoEstudiante.add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        lblNivel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNivel.setText("Nivel:");
        jpRegistroSeguimientoEstudiante.add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        lblNotaInstituto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNotaInstituto.setText("Nota Instituto:");
        jpRegistroSeguimientoEstudiante.add(lblNotaInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        cmbNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmbNivel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegistroSeguimientoEstudiante.add(cmbNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 110, 25));

        txtTutorAcademico.setEditable(false);
        txtTutorAcademico.setPreferredSize(new java.awt.Dimension(250, 25));
        txtTutorAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTutorAcademicoActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoEstudiante.add(txtTutorAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 270, -1));

        lblTutorAcademico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTutorAcademico.setText("Tutor Académico:");
        jpRegistroSeguimientoEstudiante.add(lblTutorAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        txtEmpresaSucursal.setEditable(false);
        txtEmpresaSucursal.setPreferredSize(new java.awt.Dimension(250, 25));
        txtEmpresaSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaSucursalActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoEstudiante.add(txtEmpresaSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 270, -1));

        cmbPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbPeriodo.setEnabled(false);
        cmbPeriodo.setPreferredSize(new java.awt.Dimension(28, 25));
        jpRegistroSeguimientoEstudiante.add(cmbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 270, -1));

        lblPromedio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPromedio.setText("Promedio:");
        jpRegistroSeguimientoEstudiante.add(lblPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        txtPromedio.setEditable(false);
        txtPromedio.setPreferredSize(new java.awt.Dimension(50, 25));
        txtPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPromedioActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoEstudiante.add(txtPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 70, -1));

        lblEstudiante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEstudiante.setText("Estudiante:");
        jpRegistroSeguimientoEstudiante.add(lblEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtNombresApellidos.setEditable(false);
        txtNombresApellidos.setPreferredSize(new java.awt.Dimension(120, 25));
        txtNombresApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresApellidosActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoEstudiante.add(txtNombresApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 270, -1));

        lblNotaEmpresarial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNotaEmpresarial.setText("Nota Empresarial:");
        jpRegistroSeguimientoEstudiante.add(lblNotaEmpresarial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        btnNuevo2.setToolTipText("Nuevo");
        btnNuevo2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo2.setPreferredSize(new java.awt.Dimension(50, 40));
        btnNuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo2ActionPerformed(evt);
            }
        });
        jPanel6.add(btnNuevo2);

        btnCrearActualizar2.setToolTipText("Guardar");
        btnCrearActualizar2.setPreferredSize(new java.awt.Dimension(50, 40));
        btnCrearActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActualizar2ActionPerformed(evt);
            }
        });
        jPanel6.add(btnCrearActualizar2);

        btnEliminar2.setToolTipText("Eliminar");
        btnEliminar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar2.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel6.add(btnEliminar2);

        btnCerrar2.setToolTipText("Cancelar");
        btnCerrar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar2.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel6.add(btnCerrar2);

        jpRegistroSeguimientoEstudiante.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 230, -1));

        txtTutorEmpresarial.setEditable(false);
        txtTutorEmpresarial.setPreferredSize(new java.awt.Dimension(250, 25));
        txtTutorEmpresarial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTutorEmpresarialActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoEstudiante.add(txtTutorEmpresarial, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 270, -1));

        txtCedula.setEditable(false);
        txtCedula.setPreferredSize(new java.awt.Dimension(95, 25));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoEstudiante.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 150, -1));

        txtNotaInstituto.setPreferredSize(new java.awt.Dimension(50, 25));
        txtNotaInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaInstitutoActionPerformed(evt);
            }
        });
        txtNotaInstituto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNotaInstitutoKeyReleased(evt);
            }
        });
        jpRegistroSeguimientoEstudiante.add(txtNotaInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 70, -1));

        txtNotaEmpresarial.setPreferredSize(new java.awt.Dimension(50, 25));
        txtNotaEmpresarial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaEmpresarialActionPerformed(evt);
            }
        });
        txtNotaEmpresarial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNotaEmpresarialKeyReleased(evt);
            }
        });
        jpRegistroSeguimientoEstudiante.add(txtNotaEmpresarial, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 70, -1));

        lblTitulo_Id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id.setText("Id:");
        lblTitulo_Id.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroSeguimientoEstudiante.add(lblTitulo_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroSeguimientoEstudiante.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

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
        jpRegistroSeguimientoEstudiante.add(btnEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        btnTutorEmpresarial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnTutorEmpresarial.setToolTipText("Buscar");
        btnTutorEmpresarial.setBorder(null);
        btnTutorEmpresarial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTutorEmpresarial.setPreferredSize(new java.awt.Dimension(40, 40));
        btnTutorEmpresarial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutorEmpresarialActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoEstudiante.add(btnTutorEmpresarial, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        btnTutorAcademico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnTutorAcademico.setToolTipText("Buscar");
        btnTutorAcademico.setBorder(null);
        btnTutorAcademico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTutorAcademico.setPreferredSize(new java.awt.Dimension(40, 40));
        btnTutorAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutorAcademicoActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoEstudiante.add(btnTutorAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, -1));

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
        jpRegistroSeguimientoEstudiante.add(btnEmpresaSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jpRegistroSeguimientoEstudiante.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 10, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");
        jpRegistroSeguimientoEstudiante.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 10, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");
        jpRegistroSeguimientoEstudiante.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 10, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");
        jpRegistroSeguimientoEstudiante.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 10, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");
        jpRegistroSeguimientoEstudiante.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 10, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*");
        jpRegistroSeguimientoEstudiante.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 10, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*");
        jpRegistroSeguimientoEstudiante.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 10, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("*");
        jpRegistroSeguimientoEstudiante.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 10, -1));

        lblFechaReunion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaReunion.setText("Fecha Inicio:");
        jpRegistroSeguimientoEstudiante.add(lblFechaReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("*");
        jpRegistroSeguimientoEstudiante.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 10, -1));

        dtFechaInicio.setDateFormatString("yyyy-MM-dd");
        dtFechaInicio.setPreferredSize(new java.awt.Dimension(100, 25));
        jpRegistroSeguimientoEstudiante.add(dtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        lblFechaReunion1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaReunion1.setText("Fecha Fin:");
        jpRegistroSeguimientoEstudiante.add(lblFechaReunion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("*");
        jpRegistroSeguimientoEstudiante.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 10, -1));

        dtFechaFin.setDateFormatString("yyyy-MM-dd");
        dtFechaFin.setPreferredSize(new java.awt.Dimension(100, 25));
        jpRegistroSeguimientoEstudiante.add(dtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        jPanel1.add(jpRegistroSeguimientoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jpBusquedaSeguimientoEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaSeguimientoEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaSeguimientoEstudiante.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaSeguimientoEstudiante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaSeguimientoEstudiante.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(62, 25));
        jpBusquedaSeguimientoEstudiante.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioBusquedaActionPerformed(evt);
            }
        });
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaSeguimientoEstudiante.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 270, -1));

        jtSeguimientoEstudiante.setModel(new javax.swing.table.DefaultTableModel(
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
        jtSeguimientoEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtSeguimientoEstudiante.setGridColor(new java.awt.Color(0, 102, 153));
        jtSeguimientoEstudiante.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtSeguimientoEstudiante.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtSeguimientoEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtSeguimientoEstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtSeguimientoEstudiante);

        jpBusquedaSeguimientoEstudiante.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 440, 460));

        lblRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros.setText("Registros:");
        lblRegistros.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaSeguimientoEstudiante.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 60, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaSeguimientoEstudiante.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 200, -1));

        jPanel1.add(jpBusquedaSeguimientoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(230, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 50));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

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
        jPanel1.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 975, 615);
    }// </editor-fold>//GEN-END:initComponents
// <editor-fold defaultstate="collapsed" desc="Eventos">    
    private void txtTutorAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTutorAcademicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTutorAcademicoActionPerformed

    private void txtEmpresaSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaSucursalActionPerformed

    private void txtPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPromedioActionPerformed

    private void txtNombresApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresApellidosActionPerformed

    private void btnNuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevo2ActionPerformed

    private void btnCrearActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearActualizar2ActionPerformed

    private void txtTutorEmpresarialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTutorEmpresarialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTutorEmpresarialActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtNotaInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaInstitutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotaInstitutoActionPerformed

    private void txtNotaEmpresarialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaEmpresarialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotaEmpresarialActionPerformed

    private void txtCriterioBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaActionPerformed

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void jtSeguimientoEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtSeguimientoEstudianteMouseClicked
        int fila = jtSeguimientoEstudiante.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarSeguimientoEstudiante(consultarRegistroIndividual(jtSeguimientoEstudiante.getValueAt(fila, 0).toString(), "seguimiento_estudiante", controladorVariablesSesion.getInstance().getFiltrar()));
        }
    }//GEN-LAST:event_jtSeguimientoEstudianteMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroSeguimientoEstudiante);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroSeguimientoEstudiante);
            llenarGrid(tipo_consulta);//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (controladorVariablesSesion.getInstance().eliminar(lblId.getText()) == 0) {
            accion = "crear";
            eliminar();//elimina el registro seleccionado
            llenarGrid(tipo_consulta);//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpRegistroSeguimientoEstudiante);//limpia las cajas de texto
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

    private void btnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudianteActionPerformed
        buscar("estudiante", "grid");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarEstudiante(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona", controladorVariablesSesion.getInstance().getFiltrar()));
    }//GEN-LAST:event_btnEstudianteActionPerformed

    private void btnTutorEmpresarialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutorEmpresarialActionPerformed
        criterioBusqueda[0] = idEmpresaSucursal;
        buscar("tutor_empresarial", "grid");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarTutorEmpresarial(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona", controladorVariablesSesion.getInstance().getFiltrar()));
    }//GEN-LAST:event_btnTutorEmpresarialActionPerformed

    private void btnTutorAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutorAcademicoActionPerformed
        buscar("tutor_academico", "grid");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarTutorAcademico(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona", controladorVariablesSesion.getInstance().getFiltrar()));
    }//GEN-LAST:event_btnTutorAcademicoActionPerformed

    private void btnEmpresaSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaSucursalActionPerformed
        buscar("empresa_sucursal", "grid");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarEmpresaSucursal(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "empresa_sucursal", controladorVariablesSesion.getInstance().getFiltrar()));
    }//GEN-LAST:event_btnEmpresaSucursalActionPerformed

    private void btnAdjuntarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarAnexosActionPerformed
        int fila = jtSeguimientoEstudiante.getSelectedRow();
        if (fila != -1) {
            criterioBusqueda[0] = jtSeguimientoEstudiante.getValueAt(fila, 0).toString();
            criterioBusqueda[1] = "S";//tipo de documento anexo
            criterioBusqueda[2] = "Seguimiento Estudiante";//descripcion de los anexos
            frmDocumentoAnexos frm = new frmDocumentoAnexos(null, true, criterioBusqueda);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Documento", "Seleccionar", 2);
        }
    }//GEN-LAST:event_btnAdjuntarAnexosActionPerformed

    private void txtNotaInstitutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaInstitutoKeyReleased
        if (calcularPromedio()) {
            txtNotaInstituto.setText(controladorVariablesSesion.validarNumerosSinEspacios(txtNotaInstituto.getText()));
        } else {
            JOptionPane.showMessageDialog(rootPane, "Valor excede el rango de la nota (0-20)");
            txtNotaInstituto.setText(txtNotaInstituto.getText().substring(0, 1));
        }

    }//GEN-LAST:event_txtNotaInstitutoKeyReleased

    private void txtNotaEmpresarialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaEmpresarialKeyReleased

        if (calcularPromedio()) {
            txtNotaEmpresarial.setText(controladorVariablesSesion.validarNumerosSinEspacios(txtNotaEmpresarial.getText()));
        } else {
            JOptionPane.showMessageDialog(rootPane, "Valor excede el rango de la nota (0-20)");
            txtNotaEmpresarial.setText(txtNotaEmpresarial.getText().substring(0, 1));
        }
    }//GEN-LAST:event_txtNotaEmpresarialKeyReleased

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel(rutaArchivo, controladorGrid.getInstance().filtrarGrid(jtSeguimientoEstudiante));
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Metodos"> 
    private boolean calcularPromedio() {
        double notaEmpresa = 0.0;
        double notaInstituto = 0.0;
        double promedio = 0.0;
        if (!txtNotaEmpresarial.getText().equals("")) {
            notaEmpresa = Integer.parseInt(txtNotaEmpresarial.getText());
            if (notaEmpresa < 0 || notaEmpresa > 20) {
                return false;
            }
        }
        if (!txtNotaInstituto.getText().equals("")) {
            notaInstituto = Integer.parseInt(txtNotaInstituto.getText());
            if (notaInstituto < 0 || notaInstituto > 20) {
                return false;
            }
        }
        promedio = (notaInstituto + notaEmpresa) / 2;
        txtPromedio.setText(String.valueOf(promedio));
        return true;
    }

    private void buscar(String tabla, String tipo) {

        frmConsultas consulta = new frmConsultas(null, true);//instancia la el formulario con la ventana de busqueda
        consulta.consultar(tabla, tipo, criterioBusqueda);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtSeguimientoEstudiante.getRowCount();
        lblTotalRegistros.setText(String.valueOf(total));
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

    private ArrayList<Object> consultarRegistroIndividual(String id, String tabla, String tipo) {
        criterioBusqueda[0] = id;
        controladorConsulta consulta = new controladorConsulta();
        return consulta.obtenerConsulta(tabla, tipo, criterioBusqueda);
    }

    private boolean crearActualizar() {
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("accion", accion);
        map.put("id", lblId.getText());
        map.put("idPeriodo", codigoPeriodo.get(cmbPeriodo.getSelectedIndex()));
        map.put("fechaInicio", dateToString(dtFechaInicio));
        map.put("fechaFin", dateToString(dtFechaFin));
        map.put("idEstudiante", idEstudiante);
        map.put("idTutorEmpresarial", idTutorEmpresarial);
        map.put("idTutorAcademico", idTutorAcademico);
        map.put("idEmpresaSucursal", idEmpresaSucursal);
        map.put("idNivel", codigoNivel.get(cmbNivel.getSelectedIndex()));
        map.put("notaInstituto", txtNotaInstituto.getText());
        map.put("notaEmpresa", txtNotaEmpresarial.getText());
        map.put("descripcionDocumentos", txtNotaEmpresarial.getText());

        //instacia el controlador
        ControladorSeguimientoEstudiante controladorSeguimientoEstudiante = new ControladorSeguimientoEstudiante();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorSeguimientoEstudiante.crearActualizar(map, archivos, tamanioArchivos);

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

    private void consultarDocumentoAnexos() {
        int fila = jtSeguimientoEstudiante.getSelectedRow();
        if (fila != -1) {
            criterioBusqueda[0] = jtSeguimientoEstudiante.getValueAt(fila, 0).toString();
            criterioBusqueda[1] = "S";
            consultarDocumentoAnexos(criterioBusqueda);
        } else {
            JOptionPane.showMessageDialog(rootPane, "seleccione un registro");
        }
    }

    private void consultarDocumentoAnexos(String[] criterioBusqueda) {
        try {
            frmDocumentoAnexos documentoAnexos = new frmDocumentoAnexos(null, true, criterioBusqueda);

            documentoAnexos.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error Buscar Subgrupos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", lblId.getText());
        ControladorSeguimientoEstudiante controladorSeguimientoEstudiante = new ControladorSeguimientoEstudiante();
        controladorSeguimientoEstudiante.eliminar(map);

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
        jtSeguimientoEstudiante.getColumnModel().getColumn(0).setMaxWidth(0);
        jtSeguimientoEstudiante.getColumnModel().getColumn(0).setMinWidth(0);
        jtSeguimientoEstudiante.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void llenarGrid(String tipo) {
        jtSeguimientoEstudiante.setModel(controladorGrid.getInstance().llenarGrid(tipo, "grid", null, true));
        sorter = new TableRowSorter<>(jtSeguimientoEstudiante.getModel());
        jtSeguimientoEstudiante.setRowSorter(sorter);
        jtSeguimientoEstudiante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        idEmpresaSucursal = "-1";
        idEstudiante = "-1";
        idTutorAcademico = "-1";
        idTutorEmpresarial = "-1";
        //cmbPeriodo.setSelectedIndex(0);
        cmbNivel.setSelectedIndex(0);
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

    private void llenarComboNiveles() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "NIVEL";
        criterioBusqueda[1] = "enumeracion";
        cmbNivel.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoNivel = consulta.getCodigoCombo();
    }

    private void llenarSeguimientoEstudiante(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        idEstudiante = (String.valueOf(datos.get(1)));
        idTutorEmpresarial = (String.valueOf(datos.get(2)));
        idTutorAcademico = (String.valueOf(datos.get(3)));
        idEmpresaSucursal = (String.valueOf(datos.get(4)));
        txtEmpresaSucursal.setText((String) datos.get(5));
        cmbPeriodo.setSelectedItem(datos.get(6));
        txtCedula.setText((String) datos.get(9));
        txtNombresApellidos.setText((String) datos.get(10));
        txtTutorEmpresarial.setText((String) datos.get(11));
        txtTutorAcademico.setText((String) datos.get(12));
        cmbNivel.setSelectedItem(datos.get(13));
        txtNotaInstituto.setText(String.valueOf(datos.get(14)));
        txtNotaEmpresarial.setText(String.valueOf(datos.get(15)));
        txtPromedio.setText(String.valueOf(datos.get(16)));
        dtFechaInicio.setDate(stringToJDateChooser((String) datos.get(7)));
        dtFechaFin.setDate(stringToJDateChooser((String) datos.get(8)));
    }

    private void llenarEstudiante(ArrayList<Object> datos) {
        idEstudiante = (String.valueOf(datos.get(0)));
        txtCedula.setText(String.valueOf(datos.get(4)));
        txtNombresApellidos.setText(String.valueOf(datos.get(2)) + " " + String.valueOf(datos.get(1)));
    }

    private void llenarTutorEmpresarial(ArrayList<Object> datos) {
        idTutorEmpresarial = (String.valueOf(datos.get(0)));
        txtTutorEmpresarial.setText(String.valueOf(datos.get(2)) + " " + String.valueOf(datos.get(1)));
    }

    private void llenarTutorAcademico(ArrayList<Object> datos) {
        idTutorAcademico = (String.valueOf(datos.get(0)));
        txtTutorAcademico.setText(String.valueOf(datos.get(2)) + " " + String.valueOf(datos.get(1)));
    }

    private void llenarEmpresaSucursal(ArrayList<Object> datos) {
        idEmpresaSucursal = (String.valueOf(datos.get(0)));
        txtEmpresaSucursal.setText(String.valueOf(datos.get(3)));
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
    private javax.swing.JButton btnCerrar2;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnCrearActualizar2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnEmpresaSucursal;
    private javax.swing.JButton btnEstudiante;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnNuevo2;
    private javax.swing.JButton btnTutorAcademico;
    private javax.swing.JButton btnTutorEmpresarial;
    private javax.swing.JComboBox cmbFiltro;
    private javax.swing.JComboBox cmbNivel;
    public static javax.swing.JComboBox cmbPeriodo;
    private com.toedter.calendar.JDateChooser dtFechaFin;
    private com.toedter.calendar.JDateChooser dtFechaInicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpBusquedaSeguimientoEstudiante;
    private javax.swing.JPanel jpRegistroSeguimientoEstudiante;
    private javax.swing.JTable jtSeguimientoEstudiante;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblFechaReunion;
    private javax.swing.JLabel lblFechaReunion1;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNotaEmpresarial;
    private javax.swing.JLabel lblNotaInstituto;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblPromedio;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JLabel lblTutorAcademico;
    private javax.swing.JLabel lblTutorEmpresarial;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtEmpresaSucursal;
    private javax.swing.JTextField txtNombresApellidos;
    private javax.swing.JTextField txtNotaEmpresarial;
    private javax.swing.JTextField txtNotaInstituto;
    private javax.swing.JTextField txtPromedio;
    private javax.swing.JTextField txtTutorAcademico;
    private javax.swing.JTextField txtTutorEmpresarial;
    // End of variables declaration//GEN-END:variables
// </editor-fold>   
}
