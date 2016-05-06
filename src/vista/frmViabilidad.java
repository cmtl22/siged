package vista;

import controlador.ControladorViabilidad;
import controlador.controladorConsulta;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmViabilidad extends javax.swing.JInternalFrame {

// <editor-fold defaultstate="collapsed" desc="Declaracion de Variables">     
    private String accion;
    private String idEmpresaSucursal;
    private String idCarrera;
    private String idPersona;
    private String idInstituto;
    private String idEmpresa;

    private DefaultTableModel modeloSucursales;
    private DefaultTableModel modeloCarreras = new DefaultTableModel();
    private DefaultTableModel modeloAsignaturasTabla = new DefaultTableModel();
    private DefaultTableModel modeloDireccionMatriz;
    private DefaultTableModel modeloDireccionSucursal;

    private String nombreInstituto;
    private String nombreEmpresa;

    private ArrayList<String> codigoRol = new ArrayList<>();
    private String[] criterioBusqueda;
    private ArrayList<String> codigoTipo;
    ArrayList<String> codigoEntidadDeRegulacion = new ArrayList<>();
    private TableRowSorter<TableModel> sorter;
    private TableRowSorter<TableModel> sorterEntidades;
    private String[] direccionEmpresa;
    private String[] direccionSucursal;

    private String respuestaRadioButton;
    private String respuestaCheckBox;
    private TableModel modeloTablaDeudas;

// </editor-fold > 
    public frmViabilidad() {
        initComponents();
        init();

    }

    private void init() {
        criterioBusqueda = new String[3];
        cargarPrimeraSeccion();
        llenarGridEntidadesRegulacion();
        llenarGridDocumentosHabilitantesEntidadReceptora();
        llenarGridDocumentosHabilitantesInstituto();
        formatearGridEscenariosPedagogicos();
        btnAdelante.setEnabled(true);
        jtpInformeViabilidad.setEnabledAt(0, true);
        jtpInformeViabilidad.setEnabledAt(1, false);
        jtpInformeViabilidad.setEnabledAt(2, false);
        jtpInformeViabilidad.setEnabledAt(3, false);
        jtpInformeViabilidad.setEnabledAt(4, false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        btgConstatacion = new javax.swing.ButtonGroup();
        btgRecompensa = new javax.swing.ButtonGroup();
        btgNormasSeguridad = new javax.swing.ButtonGroup();
        btgEquipo = new javax.swing.ButtonGroup();
        btgUniforme = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtpInformeViabilidad = new javax.swing.JTabbedPane();
        jpPrimeraSeccion = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroInforme = new javax.swing.JFormattedTextField();
        lblFechaInforme = new javax.swing.JLabel();
        dtFechaInforme = new com.toedter.calendar.JDateChooser();
        lblEmpresa1 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        lblRUC = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        lblEmpresa = new javax.swing.JLabel();
        btnBuscarCarrera = new javax.swing.JButton();
        lblSolicitante = new javax.swing.JLabel();
        lblPara = new javax.swing.JLabel();
        lblAsunto = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtCarrera = new javax.swing.JFormattedTextField();
        btnBuscarEmpresa = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaNombreInstituto = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaSolicitante = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        txaPara = new javax.swing.JTextArea();
        jScrollPane20 = new javax.swing.JScrollPane();
        txaAsunto = new javax.swing.JTextArea();
        lblParaInforme = new javax.swing.JLabel();
        lblParaInforme1 = new javax.swing.JLabel();
        lblParaInforme2 = new javax.swing.JLabel();
        jpSegundaSeccion = new javax.swing.JPanel();
        btnBuscarRepresentanteLegal = new javax.swing.JButton();
        txtNombreRepresentanteLegal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rbSiConstatacion = new javax.swing.JRadioButton();
        rbNoConstatacion = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEntidadesRegulacion = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObservacionesDeudas = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaConsideracionesRecomendaciones = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFechaAcercamiento = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaDireccion2 = new javax.swing.JTextArea();
        txtCreacionResolucion1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtSucursales = new javax.swing.JTable();
        btnAgregarSucursal = new javax.swing.JButton();
        btnQuitarSucursal = new javax.swing.JButton();
        lblParaInforme3 = new javax.swing.JLabel();
        lblParaInforme5 = new javax.swing.JLabel();
        lblParaInforme6 = new javax.swing.JLabel();
        lblParaInforme7 = new javax.swing.JLabel();
        lblParaInforme8 = new javax.swing.JLabel();
        lblParaInforme9 = new javax.swing.JLabel();
        lblParaInforme10 = new javax.swing.JLabel();
        lblParaInforme11 = new javax.swing.JLabel();
        jpTereceraSeccion1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txaProcesoDesignacionEstudiantes = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtAsignaturas = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        btnAgregarAsignatura = new javax.swing.JButton();
        btnQuitarAsignatura = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtEscenariosPedagogicos = new javax.swing.JTable();
        btnAgregarEscenarioPedagogico = new javax.swing.JButton();
        btnQuitarEscenarioPedagogico = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtAdministradorInstituto = new javax.swing.JTextField();
        txtAdministradorEntidadReceptora = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        txaObjetivo = new javax.swing.JTextArea();
        jsCantidadEstudiantes = new javax.swing.JSpinner();
        jsCantidadTutores = new javax.swing.JSpinner();
        jsPlazo = new javax.swing.JSpinner();
        jLabel55 = new javax.swing.JLabel();
        lblParaInforme4 = new javax.swing.JLabel();
        lblParaInforme12 = new javax.swing.JLabel();
        lblParaInforme13 = new javax.swing.JLabel();
        lblParaInforme14 = new javax.swing.JLabel();
        lblParaInforme15 = new javax.swing.JLabel();
        lblParaInforme16 = new javax.swing.JLabel();
        lblParaInforme17 = new javax.swing.JLabel();
        lblParaInforme18 = new javax.swing.JLabel();
        lblParaInforme19 = new javax.swing.JLabel();
        jpTerceraSeccion2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        rbSiUniforme = new javax.swing.JRadioButton();
        rbNoUniforme = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        rbNoEquipoProteccion = new javax.swing.JRadioButton();
        rbSiEquipoProteccion = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        rbNoNormasSeguridad = new javax.swing.JRadioButton();
        rbSiNormasSeguridad = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txaObjetivo1 = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        rbSiRecompensa = new javax.swing.JRadioButton();
        rbNoRecompensa = new javax.swing.JRadioButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtCreacionResolucion7 = new javax.swing.JTextField();
        txtCreacionResolucion8 = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        txaObjetivo2 = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jtAsignaturas2 = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        lblParaInforme20 = new javax.swing.JLabel();
        lblParaInforme21 = new javax.swing.JLabel();
        lblParaInforme22 = new javax.swing.JLabel();
        lblParaInforme23 = new javax.swing.JLabel();
        lblParaInforme24 = new javax.swing.JLabel();
        lblParaInforme25 = new javax.swing.JLabel();
        lblParaInforme26 = new javax.swing.JLabel();
        lblParaInforme27 = new javax.swing.JLabel();
        lblParaInforme28 = new javax.swing.JLabel();
        jpCuartaQuintaSeccion = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        txaOtrosDocumentosHabilitantes = new javax.swing.JTextArea();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtRemitenteInstituto = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtRemitenteEntidadReceptora = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jtDocumentosHabilitantesInstituto = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        jtDocumentosHabilitantesEntidadReceptora = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        txaObjetivo4 = new javax.swing.JTextArea();
        lblParaInforme29 = new javax.swing.JLabel();
        lblParaInforme30 = new javax.swing.JLabel();
        lblParaInforme31 = new javax.swing.JLabel();
        lblParaInforme32 = new javax.swing.JLabel();
        lblParaInforme33 = new javax.swing.JLabel();
        lblParaInforme34 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnAdelante = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnBuscarInformeViabilidad = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAdjuntarAnexos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("INFORME DE VIABILIDAD");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_informe_32.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(945, 535));
        setPreferredSize(new java.awt.Dimension(945, 535));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(935, 535));
        jPanel1.setPreferredSize(new java.awt.Dimension(935, 535));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtpInformeViabilidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtpInformeViabilidadMouseClicked(evt);
            }
        });

        jpPrimeraSeccion.setBackground(new java.awt.Color(255, 255, 255));
        jpPrimeraSeccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("N° Informe:");
        jpPrimeraSeccion.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 25));

        txtNumeroInforme.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000"))));
        jpPrimeraSeccion.add(txtNumeroInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 240, 25));

        lblFechaInforme.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaInforme.setText("Fecha Informe:");
        jpPrimeraSeccion.add(lblFechaInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 25));

        dtFechaInforme.setDateFormatString("yyyy-MM-dd");
        dtFechaInforme.setPreferredSize(new java.awt.Dimension(100, 25));
        jpPrimeraSeccion.add(dtFechaInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));
        dtFechaInforme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Date date = new Date();
        dtFechaInforme.setDate(date);

        lblEmpresa1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmpresa1.setText("Instittuto:");
        jpPrimeraSeccion.add(lblEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, 25));

        txtRUC.setEditable(false);
        jpPrimeraSeccion.add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 160, 25));

        lblRUC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRUC.setText("RUC:");
        jpPrimeraSeccion.add(lblRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, 25));

        txtEmpresa.setEditable(false);
        jpPrimeraSeccion.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 240, 25));

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmpresa.setText("Empresa:");
        jpPrimeraSeccion.add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 100, 25));

        btnBuscarCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnBuscarCarrera.setToolTipText("BUSCAR EMPRESA");
        btnBuscarCarrera.setBorder(null);
        btnBuscarCarrera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCarreraActionPerformed(evt);
            }
        });
        jpPrimeraSeccion.add(btnBuscarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        lblSolicitante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSolicitante.setText("Solicitante:");
        jpPrimeraSeccion.add(lblSolicitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 75, 25));

        lblPara.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPara.setText("Para:");
        jpPrimeraSeccion.add(lblPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 75, 25));

        lblAsunto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAsunto.setText("Asunto:");
        jpPrimeraSeccion.add(lblAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 75, 25));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Carrera:");
        jpPrimeraSeccion.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 25));

        txtCarrera.setEditable(false);
        txtCarrera.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000"))));
        jpPrimeraSeccion.add(txtCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 240, 25));

        btnBuscarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnBuscarEmpresa.setToolTipText("BUSCAR EMPRESA");
        btnBuscarEmpresa.setBorder(null);
        btnBuscarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpresaActionPerformed(evt);
            }
        });
        jpPrimeraSeccion.add(btnBuscarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        txaNombreInstituto.setColumns(20);
        txaNombreInstituto.setLineWrap(true);
        txaNombreInstituto.setRows(2);
        txaNombreInstituto.setTabSize(5);
        jScrollPane4.setViewportView(txaNombreInstituto);

        jpPrimeraSeccion.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 240, 50));

        txaSolicitante.setColumns(20);
        txaSolicitante.setLineWrap(true);
        txaSolicitante.setRows(2);
        txaSolicitante.setTabSize(5);
        jScrollPane5.setViewportView(txaSolicitante);

        jpPrimeraSeccion.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 300, 60));

        txaPara.setColumns(20);
        txaPara.setLineWrap(true);
        txaPara.setRows(2);
        txaPara.setTabSize(5);
        jScrollPane19.setViewportView(txaPara);

        jpPrimeraSeccion.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 300, 70));

        txaAsunto.setColumns(20);
        txaAsunto.setLineWrap(true);
        txaAsunto.setRows(4);
        txaAsunto.setTabSize(5);
        jScrollPane20.setViewportView(txaAsunto);

        jpPrimeraSeccion.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 300, 80));

        lblParaInforme.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInformeMouseMoved(evt);
            }
        });
        jpPrimeraSeccion.add(lblParaInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, -1, -1));

        lblParaInforme1.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme1.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme1MouseMoved(evt);
            }
        });
        jpPrimeraSeccion.add(lblParaInforme1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, -1, -1));

        lblParaInforme2.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme2.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme2MouseMoved(evt);
            }
        });
        jpPrimeraSeccion.add(lblParaInforme2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, -1, -1));

        jtpInformeViabilidad.addTab("Primera sección.- Datos Generales:", jpPrimeraSeccion);

        jpSegundaSeccion.setBackground(new java.awt.Color(255, 255, 255));
        jpSegundaSeccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscarRepresentanteLegal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnBuscarRepresentanteLegal.setToolTipText("BUSCAR SUBSECRETARIO");
        btnBuscarRepresentanteLegal.setBorder(null);
        btnBuscarRepresentanteLegal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarRepresentanteLegal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRepresentanteLegalActionPerformed(evt);
            }
        });
        jpSegundaSeccion.add(btnBuscarRepresentanteLegal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, -1, -1));

        txtNombreRepresentanteLegal.setEditable(false);
        txtNombreRepresentanteLegal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreRepresentanteLegalActionPerformed(evt);
            }
        });
        jpSegundaSeccion.add(txtNombreRepresentanteLegal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 360, 30));

        jLabel6.setText("<html>¿Se realizó el análisis preliminar mediante consultas online a las entidades de regulación y control?</html>");
        jpSegundaSeccion.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 410, 40));

        rbSiConstatacion.setBackground(new java.awt.Color(153, 255, 153));
        btgConstatacion.add(rbSiConstatacion);
        rbSiConstatacion.setText("SI");
        rbSiConstatacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbSiConstatacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSiConstatacionActionPerformed(evt);
            }
        });
        jpSegundaSeccion.add(rbSiConstatacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        rbNoConstatacion.setBackground(new java.awt.Color(255, 153, 153));
        btgConstatacion.add(rbNoConstatacion);
        rbNoConstatacion.setText("NO");
        rbNoConstatacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpSegundaSeccion.add(rbNoConstatacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel7.setText("<html>¿Se constató que la entidad receptora goce de una conducta institucional/empresarial apropiada, para desarrollar el proceso de formación dual, a través de un análisis preliminar?</html>");
        jpSegundaSeccion.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 420, 50));

        jtEntidadesRegulacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtEntidadesRegulacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtEntidadesRegulacion.setGridColor(new java.awt.Color(0, 102, 153));
        jtEntidadesRegulacion.setPreferredSize(new java.awt.Dimension(300, 60));
        jtEntidadesRegulacion.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtEntidadesRegulacion.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtEntidadesRegulacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEntidadesRegulacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEntidadesRegulacion);

        jpSegundaSeccion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 410, 100));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Observaciones:");
        jpSegundaSeccion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 140, 50));

        txaObservacionesDeudas.setColumns(2);
        txaObservacionesDeudas.setLineWrap(true);
        txaObservacionesDeudas.setRows(2);
        txaObservacionesDeudas.setTabSize(3);
        txaObservacionesDeudas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObservacionesDeudasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaObservacionesDeudas);

        jpSegundaSeccion.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 260, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("<html>Consideraciones preliminares/ recomendaciones</html>");
        jpSegundaSeccion.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 140, 50));

        txaConsideracionesRecomendaciones.setColumns(2);
        txaConsideracionesRecomendaciones.setLineWrap(true);
        txaConsideracionesRecomendaciones.setRows(2);
        txaConsideracionesRecomendaciones.setTabSize(3);
        txaConsideracionesRecomendaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaConsideracionesRecomendacionesKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txaConsideracionesRecomendaciones);

        jpSegundaSeccion.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 260, 90));

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 153));
        jLabel10.setText("<html>(Principales sugerencias a tomar en cuenta previo análisis de los aspectos técnicos y académicos descritos en el informe y a las conclusiones arribadas)</html>");
        jpSegundaSeccion.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 450, 30));

        jLabel11.setText("Fecha acercamiento inicial:");
        jpSegundaSeccion.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 160, 25));

        jLabel12.setText("<html>Documentación de respaldo Oficios, Memos, Ayuda Memoria, etc.  </html>");
        jpSegundaSeccion.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 160, 50));

        jLabel13.setText("<html>Nombre del Representante Legal o delegado/ a:</html>");
        jpSegundaSeccion.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 160, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 153));
        jLabel14.setText("<html>(persona legalmente autorizada para la suscripción de convenios o documentos de similar característica)</html>");
        jpSegundaSeccion.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 410, 30));

        txtFechaAcercamiento.setPreferredSize(new java.awt.Dimension(87, 25));
        txtFechaAcercamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaAcercamientoActionPerformed(evt);
            }
        });
        txtFechaAcercamiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaAcercamientoKeyReleased(evt);
            }
        });
        jpSegundaSeccion.add(txtFechaAcercamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 140, -1));

        txaDireccion2.setColumns(2);
        txaDireccion2.setLineWrap(true);
        txaDireccion2.setRows(2);
        txaDireccion2.setTabSize(3);
        txaDireccion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDireccion2KeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(txaDireccion2);

        jpSegundaSeccion.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 240, 50));

        txtCreacionResolucion1.setPreferredSize(new java.awt.Dimension(87, 25));
        txtCreacionResolucion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreacionResolucion1ActionPerformed(evt);
            }
        });
        txtCreacionResolucion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCreacionResolucion1KeyReleased(evt);
            }
        });
        jpSegundaSeccion.add(txtCreacionResolucion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 240, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("<html>Dirección sucursal/ planta/ filial: (Lugar en donde se realizará la formación dual, establecer referencias para ubicación, por ejm: diagonal a bco. Pacifico) </html>");
        jpSegundaSeccion.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 350, 50));

        jtSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtSucursales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtSucursales.setGridColor(new java.awt.Color(0, 102, 153));
        jtSucursales.setPreferredSize(new java.awt.Dimension(300, 100));
        jtSucursales.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtSucursales.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtSucursales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtSucursalesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtSucursales);

        jpSegundaSeccion.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 350, 140));

        btnAgregarSucursal.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_agregar_32.png"))); // NOI18N
        btnAgregarSucursal.setToolTipText("Agregar");
        btnAgregarSucursal.setBorder(null);
        btnAgregarSucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarSucursal.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAgregarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSucursalActionPerformed(evt);
            }
        });
        jpSegundaSeccion.add(btnAgregarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 270, -1, -1));

        btnQuitarSucursal.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitarSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cancelar_40.png"))); // NOI18N
        btnQuitarSucursal.setToolTipText("Eliminar");
        btnQuitarSucursal.setBorder(null);
        btnQuitarSucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarSucursal.setPreferredSize(new java.awt.Dimension(50, 50));
        btnQuitarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarSucursalActionPerformed(evt);
            }
        });
        jpSegundaSeccion.add(btnQuitarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, -1, -1));

        lblParaInforme3.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme3.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme3MouseMoved(evt);
            }
        });
        jpSegundaSeccion.add(lblParaInforme3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        lblParaInforme5.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme5.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme5MouseMoved(evt);
            }
        });
        jpSegundaSeccion.add(lblParaInforme5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, -1));

        lblParaInforme6.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme6.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme6MouseMoved(evt);
            }
        });
        jpSegundaSeccion.add(lblParaInforme6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        lblParaInforme7.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme7.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme7MouseMoved(evt);
            }
        });
        jpSegundaSeccion.add(lblParaInforme7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        lblParaInforme8.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme8.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme8MouseMoved(evt);
            }
        });
        jpSegundaSeccion.add(lblParaInforme8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, -1, -1));

        lblParaInforme9.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme9.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme9MouseMoved(evt);
            }
        });
        jpSegundaSeccion.add(lblParaInforme9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, -1, -1));

        lblParaInforme10.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme10.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme10MouseMoved(evt);
            }
        });
        jpSegundaSeccion.add(lblParaInforme10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, -1, -1));

        lblParaInforme11.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme11.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme11MouseMoved(evt);
            }
        });
        jpSegundaSeccion.add(lblParaInforme11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        jtpInformeViabilidad.addTab("Segunda sección.- Antecedentes:", jpSegundaSeccion);

        jpTereceraSeccion1.setBackground(new java.awt.Color(255, 255, 255));
        jpTereceraSeccion1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Objetivo:");
        jpTereceraSeccion1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 50));

        txaProcesoDesignacionEstudiantes.setColumns(2);
        txaProcesoDesignacionEstudiantes.setLineWrap(true);
        txaProcesoDesignacionEstudiantes.setRows(2);
        txaProcesoDesignacionEstudiantes.setTabSize(3);
        txaProcesoDesignacionEstudiantes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaProcesoDesignacionEstudiantesKeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(txaProcesoDesignacionEstudiantes);

        jpTereceraSeccion1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 420, 80));

        jLabel17.setText("<html>No. de estudiantes que recibiría la Entidad Receptora por ciclo académico</html>");
        jpTereceraSeccion1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 370, 40));

        jLabel18.setText("<html>Cantidad de tutores por parte de la Entidad Receptora (principales y suplentes) por estudiante. </html>");
        jpTereceraSeccion1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 370, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 153));
        jLabel19.setText("<html>(establecer la cantidad mínima que conforme a la capacidad de la ER, nos proporcionen)</html>");
        jpTereceraSeccion1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 370, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 153));
        jLabel21.setText("<html>(Se recomienda que el plazo sea mínimo de  3 años)</html>");
        jpTereceraSeccion1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 370, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("<html>Carrera, ciclos académicos y asignaturas que solventan el convenio de formación dual </html>");
        jpTereceraSeccion1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 360, 30));

        jtAsignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtAsignaturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtAsignaturas.setGridColor(new java.awt.Color(0, 102, 153));
        jtAsignaturas.setPreferredSize(new java.awt.Dimension(300, 70));
        jtAsignaturas.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtAsignaturas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAsignaturasMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jtAsignaturas);

        jpTereceraSeccion1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 360, 130));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Estudiantes por escenario pedagógico");
        jpTereceraSeccion1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 360, 30));

        btnAgregarAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_agregar_32.png"))); // NOI18N
        btnAgregarAsignatura.setToolTipText("Agregar");
        btnAgregarAsignatura.setBorder(null);
        btnAgregarAsignatura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarAsignatura.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAgregarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAsignaturaActionPerformed(evt);
            }
        });
        jpTereceraSeccion1.add(btnAgregarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

        btnQuitarAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitarAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cancelar_40.png"))); // NOI18N
        btnQuitarAsignatura.setToolTipText("Eliminar");
        btnQuitarAsignatura.setBorder(null);
        btnQuitarAsignatura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarAsignatura.setPreferredSize(new java.awt.Dimension(50, 50));
        btnQuitarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarAsignaturaActionPerformed(evt);
            }
        });
        jpTereceraSeccion1.add(btnQuitarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        jtEscenariosPedagogicos.setAutoCreateRowSorter(true);
        jtEscenariosPedagogicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null}
            },
            new String [] {
                "No. Estudiantes", "Escenario Pedagógico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtEscenariosPedagogicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtEscenariosPedagogicos.setGridColor(new java.awt.Color(0, 102, 153));
        jtEscenariosPedagogicos.setPreferredSize(new java.awt.Dimension(300, 100));
        jtEscenariosPedagogicos.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtEscenariosPedagogicos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtEscenariosPedagogicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEscenariosPedagogicosMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jtEscenariosPedagogicos);

        jpTereceraSeccion1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 360, 130));

        btnAgregarEscenarioPedagogico.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarEscenarioPedagogico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_agregar_32.png"))); // NOI18N
        btnAgregarEscenarioPedagogico.setToolTipText("Agregar");
        btnAgregarEscenarioPedagogico.setBorder(null);
        btnAgregarEscenarioPedagogico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarEscenarioPedagogico.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAgregarEscenarioPedagogico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEscenarioPedagogicoActionPerformed(evt);
            }
        });
        jpTereceraSeccion1.add(btnAgregarEscenarioPedagogico, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, -1, -1));

        btnQuitarEscenarioPedagogico.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitarEscenarioPedagogico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cancelar_40.png"))); // NOI18N
        btnQuitarEscenarioPedagogico.setToolTipText("Eliminar");
        btnQuitarEscenarioPedagogico.setBorder(null);
        btnQuitarEscenarioPedagogico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarEscenarioPedagogico.setPreferredSize(new java.awt.Dimension(50, 50));
        btnQuitarEscenarioPedagogico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarEscenarioPedagogicoActionPerformed(evt);
            }
        });
        jpTereceraSeccion1.add(btnQuitarEscenarioPedagogico, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("<html>Administradores del Convenio</html>");
        jpTereceraSeccion1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 420, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 153));
        jLabel25.setText("<html>Incluir únicamente el cargo de los administradores </html>");
        jpTereceraSeccion1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 360, 20));

        jLabel26.setText("<html>Por la Entidad Receptora</html>");
        jpTereceraSeccion1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 120, 30));

        jLabel27.setText("<html>Por el Instituto</html>");
        jpTereceraSeccion1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 120, 20));

        txtAdministradorInstituto.setPreferredSize(new java.awt.Dimension(87, 25));
        txtAdministradorInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdministradorInstitutoActionPerformed(evt);
            }
        });
        txtAdministradorInstituto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdministradorInstitutoKeyReleased(evt);
            }
        });
        jpTereceraSeccion1.add(txtAdministradorInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 230, -1));

        txtAdministradorEntidadReceptora.setPreferredSize(new java.awt.Dimension(87, 25));
        txtAdministradorEntidadReceptora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdministradorEntidadReceptoraActionPerformed(evt);
            }
        });
        txtAdministradorEntidadReceptora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdministradorEntidadReceptoraKeyReleased(evt);
            }
        });
        jpTereceraSeccion1.add(txtAdministradorEntidadReceptora, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 230, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("<html>Proceso de designación de estudiantes</html>");
        jpTereceraSeccion1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 420, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 51, 153));
        jLabel29.setText("<html>Acuerdos específicos consensuados con la Entidad Receptora en base al Instructivo para la Selección de Estudiantes, si así lo requiere. </html>");
        jpTereceraSeccion1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 360, 30));

        txaObjetivo.setColumns(2);
        txaObjetivo.setLineWrap(true);
        txaObjetivo.setRows(2);
        txaObjetivo.setTabSize(3);
        txaObjetivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObjetivoKeyReleased(evt);
            }
        });
        jScrollPane18.setViewportView(txaObjetivo);

        jpTereceraSeccion1.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 350, 50));

        jsCantidadEstudiantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTereceraSeccion1.add(jsCantidadEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 40, -1));

        jsCantidadTutores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTereceraSeccion1.add(jsCantidadTutores, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 40, -1));

        jsPlazo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTereceraSeccion1.add(jsPlazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 40, -1));

        jLabel55.setText("<html>Plazo de vigencia del convenio</html>");
        jpTereceraSeccion1.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 370, 30));

        lblParaInforme4.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme4.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme4MouseMoved(evt);
            }
        });
        jpTereceraSeccion1.add(lblParaInforme4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        lblParaInforme12.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme12.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme12MouseMoved(evt);
            }
        });
        jpTereceraSeccion1.add(lblParaInforme12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        lblParaInforme13.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme13.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme13MouseMoved(evt);
            }
        });
        jpTereceraSeccion1.add(lblParaInforme13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        lblParaInforme14.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme14.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme14MouseMoved(evt);
            }
        });
        jpTereceraSeccion1.add(lblParaInforme14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        lblParaInforme15.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme15.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme15MouseMoved(evt);
            }
        });
        jpTereceraSeccion1.add(lblParaInforme15, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        lblParaInforme16.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme16.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme16MouseMoved(evt);
            }
        });
        jpTereceraSeccion1.add(lblParaInforme16, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, -1, -1));

        lblParaInforme17.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme17.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme17MouseMoved(evt);
            }
        });
        jpTereceraSeccion1.add(lblParaInforme17, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, -1, -1));

        lblParaInforme18.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme18.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme18.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme18MouseMoved(evt);
            }
        });
        jpTereceraSeccion1.add(lblParaInforme18, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 320, -1, -1));

        lblParaInforme19.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme19.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme19.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme19MouseMoved(evt);
            }
        });
        jpTereceraSeccion1.add(lblParaInforme19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        jtpInformeViabilidad.addTab("Tercera Sección.- Contenido del Informe 1:", jpTereceraSeccion1);

        jpTerceraSeccion2.setBackground(new java.awt.Color(255, 255, 255));
        jpTerceraSeccion2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("<html>Condiciones en las que recibirá a los estudiantes</html>");
        jpTerceraSeccion2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 51, 153));
        jLabel31.setText("<html>(Para la descripción establecer qué tipo de estructura es donde se va a realizar la formación dual, ej: planta de procesamiento atunero, ubicada en alrededor de 400 metros cuadrados de construcción o fábrica textil, otros)</html>");
        jpTerceraSeccion2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 460, 30));

        jLabel32.setText("<html>Condiciones</html>");
        jpTerceraSeccion2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 140, 25));

        rbSiUniforme.setBackground(new java.awt.Color(153, 255, 153));
        btgUniforme.add(rbSiUniforme);
        rbSiUniforme.setText("SI");
        rbSiUniforme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbSiUniforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSiUniformeActionPerformed(evt);
            }
        });
        jpTerceraSeccion2.add(rbSiUniforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        rbNoUniforme.setBackground(new java.awt.Color(255, 153, 153));
        btgUniforme.add(rbNoUniforme);
        rbNoUniforme.setText("NO");
        rbNoUniforme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTerceraSeccion2.add(rbNoUniforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel33.setText("<html>¿Se dotará de equipo mínimo de protección personal  al estudiante?</html>");
        jpTerceraSeccion2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 290, 30));

        rbNoEquipoProteccion.setBackground(new java.awt.Color(255, 153, 153));
        btgEquipo.add(rbNoEquipoProteccion);
        rbNoEquipoProteccion.setText("NO");
        rbNoEquipoProteccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTerceraSeccion2.add(rbNoEquipoProteccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        rbSiEquipoProteccion.setBackground(new java.awt.Color(153, 255, 153));
        btgEquipo.add(rbSiEquipoProteccion);
        rbSiEquipoProteccion.setText("SI");
        rbSiEquipoProteccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTerceraSeccion2.add(rbSiEquipoProteccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel34.setText("<html>¿Se verificó que las normas de seguridad de la entidad receptora garantice la protección de los estudiantes durante su formación práctica?</html>");
        jpTerceraSeccion2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 390, 40));

        rbNoNormasSeguridad.setBackground(new java.awt.Color(255, 153, 153));
        btgNormasSeguridad.add(rbNoNormasSeguridad);
        rbNoNormasSeguridad.setText("NO");
        rbNoNormasSeguridad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTerceraSeccion2.add(rbNoNormasSeguridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        rbSiNormasSeguridad.setBackground(new java.awt.Color(153, 255, 153));
        btgNormasSeguridad.add(rbSiNormasSeguridad);
        rbSiNormasSeguridad.setText("SI");
        rbSiNormasSeguridad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTerceraSeccion2.add(rbSiNormasSeguridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("<html>Observaciones:</html>");
        jpTerceraSeccion2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 100, 30));

        txaObjetivo1.setColumns(2);
        txaObjetivo1.setLineWrap(true);
        txaObjetivo1.setRows(2);
        txaObjetivo1.setTabSize(3);
        txaObjetivo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObjetivo1KeyReleased(evt);
            }
        });
        jScrollPane11.setViewportView(txaObjetivo1);

        jpTerceraSeccion2.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 240, 60));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("<html>Criterios técnicos de infraestructura</html>");
        jpTerceraSeccion2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 420, 30));

        rbSiRecompensa.setBackground(new java.awt.Color(153, 255, 153));
        btgRecompensa.add(rbSiRecompensa);
        rbSiRecompensa.setText("SI");
        rbSiRecompensa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTerceraSeccion2.add(rbSiRecompensa, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        rbNoRecompensa.setBackground(new java.awt.Color(255, 153, 153));
        btgRecompensa.add(rbNoRecompensa);
        rbNoRecompensa.setText("NO");
        rbNoRecompensa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTerceraSeccion2.add(rbNoRecompensa, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 51, 153));
        jLabel37.setText("<html>La dotación de equipo mínimo de protección personal es indispensable según la naturaleza de la carrera.</html>");
        jpTerceraSeccion2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 370, 30));

        jLabel38.setText("<html>¿Se dotará de uniforme al estudiante?</html>");
        jpTerceraSeccion2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 370, 20));

        jLabel39.setText("<html>Tipo de compensación</html>");
        jpTerceraSeccion2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 140, 25));

        txtCreacionResolucion7.setPreferredSize(new java.awt.Dimension(87, 25));
        txtCreacionResolucion7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreacionResolucion7ActionPerformed(evt);
            }
        });
        txtCreacionResolucion7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCreacionResolucion7KeyReleased(evt);
            }
        });
        jpTerceraSeccion2.add(txtCreacionResolucion7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 280, -1));

        txtCreacionResolucion8.setPreferredSize(new java.awt.Dimension(87, 25));
        txtCreacionResolucion8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreacionResolucion8ActionPerformed(evt);
            }
        });
        txtCreacionResolucion8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCreacionResolucion8KeyReleased(evt);
            }
        });
        jpTerceraSeccion2.add(txtCreacionResolucion8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 280, -1));

        txaObjetivo2.setColumns(2);
        txaObjetivo2.setLineWrap(true);
        txaObjetivo2.setRows(2);
        txaObjetivo2.setTabSize(3);
        txaObjetivo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObjetivo2KeyReleased(evt);
            }
        });
        jScrollPane12.setViewportView(txaObjetivo2);

        jpTerceraSeccion2.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 460, 70));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("<html>Descripción General de la Infraestructura </html>");
        jpTerceraSeccion2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 450, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 51, 153));
        jLabel42.setText("<html>Incluir el detalle de la naturaleza de la compensación (económica, en especie o mixta). Determinar sus condiciones</html>");
        jpTerceraSeccion2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, 20));

        jtAsignaturas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Espacio Físico (detallar lugares para desarrollo de la FD)", "Descripción General de Actividades", "Equipamiento General Disponible"
            }
        ));
        jtAsignaturas2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtAsignaturas2.setGridColor(new java.awt.Color(0, 102, 153));
        jtAsignaturas2.setPreferredSize(new java.awt.Dimension(300, 100));
        jtAsignaturas2.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtAsignaturas2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtAsignaturas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAsignaturas2MouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(jtAsignaturas2);

        jpTerceraSeccion2.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 880, 130));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("<html>¿La Entidad Receptora compensará al estudiante en formación dual? </html>");
        jpTerceraSeccion2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 460, 20));

        lblParaInforme20.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme20.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme20.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme20MouseMoved(evt);
            }
        });
        jpTerceraSeccion2.add(lblParaInforme20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        lblParaInforme21.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme21.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme21MouseMoved(evt);
            }
        });
        jpTerceraSeccion2.add(lblParaInforme21, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        lblParaInforme22.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme22.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme22.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme22MouseMoved(evt);
            }
        });
        jpTerceraSeccion2.add(lblParaInforme22, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        lblParaInforme23.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme23.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme23.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme23MouseMoved(evt);
            }
        });
        jpTerceraSeccion2.add(lblParaInforme23, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        lblParaInforme24.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme24.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme24.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme24MouseMoved(evt);
            }
        });
        jpTerceraSeccion2.add(lblParaInforme24, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, -1, -1));

        lblParaInforme25.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme25.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme25.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme25MouseMoved(evt);
            }
        });
        jpTerceraSeccion2.add(lblParaInforme25, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, -1, -1));

        lblParaInforme26.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme26.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme26.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme26MouseMoved(evt);
            }
        });
        jpTerceraSeccion2.add(lblParaInforme26, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, -1, -1));

        lblParaInforme27.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme27.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme27.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme27MouseMoved(evt);
            }
        });
        jpTerceraSeccion2.add(lblParaInforme27, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, -1, -1));

        lblParaInforme28.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme28.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme28.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme28MouseMoved(evt);
            }
        });
        jpTerceraSeccion2.add(lblParaInforme28, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        jtpInformeViabilidad.addTab("Tercera Sección.- Contenido del Informe 2:", jpTerceraSeccion2);

        jpCuartaQuintaSeccion.setBackground(new java.awt.Color(255, 255, 255));
        jpCuartaQuintaSeccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Conclusiones:");
        jpCuartaQuintaSeccion.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 50));

        txaOtrosDocumentosHabilitantes.setColumns(2);
        txaOtrosDocumentosHabilitantes.setLineWrap(true);
        txaOtrosDocumentosHabilitantes.setRows(2);
        txaOtrosDocumentosHabilitantes.setTabSize(3);
        txaOtrosDocumentosHabilitantes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaOtrosDocumentosHabilitantesKeyReleased(evt);
            }
        });
        jScrollPane14.setViewportView(txaOtrosDocumentosHabilitantes);

        jpCuartaQuintaSeccion.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 510, 80));

        jLabel45.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 51, 153));
        jLabel45.setText("<html>Rector/a del Instituto en el caso de que el informe haya sido realizado por un docente o el Coordinador de la carrera El/la rector/a de cada institución debe revisar todo el contenido del informe y cotejarlo con el instructivo previo al envío. </html>");
        jpCuartaQuintaSeccion.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 370, 40));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("<html>Documentos habilitantes</html>");
        jpCuartaQuintaSeccion.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 180, 20));

        txtRemitenteInstituto.setPreferredSize(new java.awt.Dimension(87, 25));
        txtRemitenteInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRemitenteInstitutoActionPerformed(evt);
            }
        });
        txtRemitenteInstituto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRemitenteInstitutoKeyReleased(evt);
            }
        });
        jpCuartaQuintaSeccion.add(txtRemitenteInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 240, -1));

        jLabel47.setText("<html>Revisado y Aprobado por:</html>");
        jpCuartaQuintaSeccion.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 100, 30));

        txtRemitenteEntidadReceptora.setPreferredSize(new java.awt.Dimension(87, 25));
        txtRemitenteEntidadReceptora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRemitenteEntidadReceptoraActionPerformed(evt);
            }
        });
        txtRemitenteEntidadReceptora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRemitenteEntidadReceptoraKeyReleased(evt);
            }
        });
        jpCuartaQuintaSeccion.add(txtRemitenteEntidadReceptora, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 240, -1));

        jLabel48.setText("<html>Elaborado por:</html>");
        jpCuartaQuintaSeccion.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 100, 20));

        jLabel49.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 51, 153));
        jLabel49.setText("<html>Consideraciones finales sobre ventajas y desventajas de firmar el convenio con la posible entidad receptora</html>");
        jpCuartaQuintaSeccion.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 370, 30));

        jLabel50.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 51, 153));
        jLabel50.setText("<html>Nombre del Rector/a, Docente o Coordinador/a de Carrera responsable por la sistematización de la información</html>");
        jpCuartaQuintaSeccion.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 370, 30));

        jLabel51.setText("<html>Del Instituto</html>");
        jpCuartaQuintaSeccion.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 460, 20));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("<html>Remitentes </html>");
        jpCuartaQuintaSeccion.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 80, 20));

        jLabel53.setText("<html>De la Entidad Receptora</html>");
        jpCuartaQuintaSeccion.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 460, 20));

        jScrollPane15.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jtDocumentosHabilitantesInstituto.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jtDocumentosHabilitantesInstituto.setModel(new javax.swing.table.DefaultTableModel(
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
        jtDocumentosHabilitantesInstituto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtDocumentosHabilitantesInstituto.setGridColor(new java.awt.Color(0, 102, 153));
        jtDocumentosHabilitantesInstituto.setPreferredSize(new java.awt.Dimension(300, 80));
        jtDocumentosHabilitantesInstituto.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtDocumentosHabilitantesInstituto.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtDocumentosHabilitantesInstituto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDocumentosHabilitantesInstitutoMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(jtDocumentosHabilitantesInstituto);

        jpCuartaQuintaSeccion.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 510, 120));

        jScrollPane16.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jtDocumentosHabilitantesEntidadReceptora.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jtDocumentosHabilitantesEntidadReceptora.setModel(new javax.swing.table.DefaultTableModel(
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
        jtDocumentosHabilitantesEntidadReceptora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtDocumentosHabilitantesEntidadReceptora.setGridColor(new java.awt.Color(0, 102, 153));
        jtDocumentosHabilitantesEntidadReceptora.setPreferredSize(new java.awt.Dimension(300, 80));
        jtDocumentosHabilitantesEntidadReceptora.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtDocumentosHabilitantesEntidadReceptora.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtDocumentosHabilitantesEntidadReceptora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDocumentosHabilitantesEntidadReceptoraMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(jtDocumentosHabilitantesEntidadReceptora);

        jpCuartaQuintaSeccion.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 510, 110));

        jLabel54.setText("Otros:");
        jpCuartaQuintaSeccion.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 40, 20));

        txaObjetivo4.setColumns(2);
        txaObjetivo4.setLineWrap(true);
        txaObjetivo4.setRows(2);
        txaObjetivo4.setTabSize(3);
        txaObjetivo4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObjetivo4KeyReleased(evt);
            }
        });
        jScrollPane17.setViewportView(txaObjetivo4);

        jpCuartaQuintaSeccion.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 240, 150));

        lblParaInforme29.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme29.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme29.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme29MouseMoved(evt);
            }
        });
        jpCuartaQuintaSeccion.add(lblParaInforme29, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        lblParaInforme30.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme30.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme30.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme30MouseMoved(evt);
            }
        });
        jpCuartaQuintaSeccion.add(lblParaInforme30, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        lblParaInforme31.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme31.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme31.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme31MouseMoved(evt);
            }
        });
        jpCuartaQuintaSeccion.add(lblParaInforme31, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        lblParaInforme32.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme32.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme32.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme32MouseMoved(evt);
            }
        });
        jpCuartaQuintaSeccion.add(lblParaInforme32, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        lblParaInforme33.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme33.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme33.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme33MouseMoved(evt);
            }
        });
        jpCuartaQuintaSeccion.add(lblParaInforme33, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));

        lblParaInforme34.setBackground(new java.awt.Color(255, 255, 255));
        lblParaInforme34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_ayuda_32.png"))); // NOI18N
        lblParaInforme34.setToolTipText("Para quien va dirigido el informe de viabilidad");
        lblParaInforme34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParaInforme34.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblParaInforme34MouseMoved(evt);
            }
        });
        jpCuartaQuintaSeccion.add(lblParaInforme34, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        jtpInformeViabilidad.addTab("Cuarta y Quinta Sección: Conclusiones y Cierre", jpCuartaQuintaSeccion);

        jPanel1.add(jtpInformeViabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 930, 510));
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_atras_32.png"))); // NOI18N
        btnAtras.setToolTipText("Atrás");
        btnAtras.setBorder(null);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.setEnabled(false);
        btnAtras.setPreferredSize(new java.awt.Dimension(40, 40));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btnAdelante.setBackground(new java.awt.Color(255, 255, 255));
        btnAdelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_adelante_32.png"))); // NOI18N
        btnAdelante.setToolTipText("Siguiente");
        btnAdelante.setBorder(null);
        btnAdelante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdelante.setEnabled(false);
        btnAdelante.setPreferredSize(new java.awt.Dimension(40, 40));
        btnAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdelanteActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdelante, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        btnBuscarInformeViabilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnBuscarInformeViabilidad.setToolTipText("NUEVO");
        btnBuscarInformeViabilidad.setBorder(null);
        btnBuscarInformeViabilidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarInformeViabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarInformeViabilidadActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarInformeViabilidad);

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

        btnAdjuntarAnexos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_adjuntar_40.jpg"))); // NOI18N
        btnAdjuntarAnexos.setToolTipText("ADJUNTAR");
        btnAdjuntarAnexos.setBorder(null);
        btnAdjuntarAnexos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdjuntarAnexos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjuntarAnexosActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdjuntarAnexos);

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 250, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 943, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos"> 
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCarreraActionPerformed
        buscar("viabilidad_carrera", "grid", null);
           if (!controladorVariablesSesion.getInstance().getDatosTemporalesConsulta().equals("")) 
        llenarCarrera(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "viabilidad_carrera"));
    }//GEN-LAST:event_btnBuscarCarreraActionPerformed

    private void btnAdjuntarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarAnexosActionPerformed

    }//GEN-LAST:event_btnAdjuntarAnexosActionPerformed

    private void txtNombreRepresentanteLegalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreRepresentanteLegalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreRepresentanteLegalActionPerformed

    private void btnBuscarRepresentanteLegalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRepresentanteLegalActionPerformed

    }//GEN-LAST:event_btnBuscarRepresentanteLegalActionPerformed

    private void rbSiConstatacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSiConstatacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSiConstatacionActionPerformed

    private void jtEntidadesRegulacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEntidadesRegulacionMouseClicked

    }//GEN-LAST:event_jtEntidadesRegulacionMouseClicked

    private void txaObservacionesDeudasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionesDeudasKeyReleased

    }//GEN-LAST:event_txaObservacionesDeudasKeyReleased

    private void txaConsideracionesRecomendacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaConsideracionesRecomendacionesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txaConsideracionesRecomendacionesKeyReleased

    private void txtFechaAcercamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaAcercamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaAcercamientoActionPerformed

    private void txtFechaAcercamientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaAcercamientoKeyReleased

    }//GEN-LAST:event_txtFechaAcercamientoKeyReleased

    private void txaDireccion2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDireccion2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txaDireccion2KeyReleased

    private void txtCreacionResolucion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreacionResolucion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreacionResolucion1ActionPerformed

    private void txtCreacionResolucion1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreacionResolucion1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreacionResolucion1KeyReleased

    private void jtSucursalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtSucursalesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtSucursalesMouseClicked

    private void btnAgregarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSucursalActionPerformed
        criterioBusqueda[0] = idEmpresa;
        buscar("viabilidad_empresa_sucursal", "grid_filtro", criterioBusqueda);
        llenarEmpresaSucursal(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "viabilidad_empresa_sucursal"));
        formatearGridSucursales();
    }//GEN-LAST:event_btnAgregarSucursalActionPerformed

    private void btnQuitarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarSucursalActionPerformed
        if (jtSucursales.getSelectedRow() != -1) {
            DefaultTableModel modelo = (DefaultTableModel) jtSucursales.getModel();
            modelo.removeRow(jtSucursales.getSelectedRow());
            jtSucursales.setModel(modelo);
        }
    }//GEN-LAST:event_btnQuitarSucursalActionPerformed

    private void txaProcesoDesignacionEstudiantesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaProcesoDesignacionEstudiantesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txaProcesoDesignacionEstudiantesKeyReleased

    private void jtAsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAsignaturasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtAsignaturasMouseClicked

    private void btnAgregarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAsignaturaActionPerformed
        criterioBusqueda[0] = idCarrera;
        buscar("viabilidad_asignatura", "grid_filtro", criterioBusqueda);
        llenarAsignatura(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "viabilidad_asignatura"));
        formatearGridAsignaturas();
    }//GEN-LAST:event_btnAgregarAsignaturaActionPerformed

    private void btnQuitarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarAsignaturaActionPerformed
        if (jtAsignaturas.getSelectedRow() != -1) {
            DefaultTableModel modelo = (DefaultTableModel) jtAsignaturas.getModel();
            modelo.removeRow(jtAsignaturas.getSelectedRow());
            jtAsignaturas.setModel(modelo);
        }
    }//GEN-LAST:event_btnQuitarAsignaturaActionPerformed

    private void jtEscenariosPedagogicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEscenariosPedagogicosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEscenariosPedagogicosMouseClicked

    private void btnAgregarEscenarioPedagogicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEscenarioPedagogicoActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtEscenariosPedagogicos.getModel();
        Object[] datos = {"1", ""};
        modelo.addRow(datos);
        jtEscenariosPedagogicos.setModel(modelo);
    }//GEN-LAST:event_btnAgregarEscenarioPedagogicoActionPerformed

    private void btnQuitarEscenarioPedagogicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarEscenarioPedagogicoActionPerformed
        if (jtEscenariosPedagogicos.getSelectedRow() != -1) {
            DefaultTableModel modelo = (DefaultTableModel) jtEscenariosPedagogicos.getModel();
            modelo.removeRow(jtEscenariosPedagogicos.getSelectedRow());
            jtEscenariosPedagogicos.setModel(modelo);
        }
    }//GEN-LAST:event_btnQuitarEscenarioPedagogicoActionPerformed

    private void txtAdministradorInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdministradorInstitutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdministradorInstitutoActionPerformed

    private void txtAdministradorInstitutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdministradorInstitutoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdministradorInstitutoKeyReleased

    private void txtAdministradorEntidadReceptoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdministradorEntidadReceptoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdministradorEntidadReceptoraActionPerformed

    private void txtAdministradorEntidadReceptoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdministradorEntidadReceptoraKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdministradorEntidadReceptoraKeyReleased

    private void txaObjetivo1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObjetivo1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txaObjetivo1KeyReleased

    private void txtCreacionResolucion7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreacionResolucion7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreacionResolucion7ActionPerformed

    private void txtCreacionResolucion7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreacionResolucion7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreacionResolucion7KeyReleased

    private void txtCreacionResolucion8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreacionResolucion8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreacionResolucion8ActionPerformed

    private void txtCreacionResolucion8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreacionResolucion8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreacionResolucion8KeyReleased

    private void btnBuscarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpresaActionPerformed
        buscar("empresa", "grid", null);
           if (!controladorVariablesSesion.getInstance().getDatosTemporalesConsulta().equals("")) 
        llenarEmpresa(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "empresa"));
        llenarAsunto();
    }//GEN-LAST:event_btnBuscarEmpresaActionPerformed

    private void txaObjetivo2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObjetivo2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txaObjetivo2KeyReleased

    private void jtAsignaturas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAsignaturas2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtAsignaturas2MouseClicked

    private void txaOtrosDocumentosHabilitantesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaOtrosDocumentosHabilitantesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txaOtrosDocumentosHabilitantesKeyReleased

    private void txtRemitenteInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemitenteInstitutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemitenteInstitutoActionPerformed

    private void txtRemitenteInstitutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemitenteInstitutoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemitenteInstitutoKeyReleased

    private void txtRemitenteEntidadReceptoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemitenteEntidadReceptoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemitenteEntidadReceptoraActionPerformed

    private void txtRemitenteEntidadReceptoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemitenteEntidadReceptoraKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemitenteEntidadReceptoraKeyReleased

    private void jtDocumentosHabilitantesInstitutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDocumentosHabilitantesInstitutoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDocumentosHabilitantesInstitutoMouseClicked

    private void jtDocumentosHabilitantesEntidadReceptoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDocumentosHabilitantesEntidadReceptoraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDocumentosHabilitantesEntidadReceptoraMouseClicked

    private void txaObjetivo4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObjetivo4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txaObjetivo4KeyReleased

    private void txaObjetivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObjetivoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txaObjetivoKeyReleased

    private void rbSiUniformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSiUniformeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSiUniformeActionPerformed

    private void jtpInformeViabilidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtpInformeViabilidadMouseClicked
    }//GEN-LAST:event_jtpInformeViabilidadMouseClicked

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        validarProcesoInformeAtras();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteActionPerformed
        validarProcesoInformeAdelante();
    }//GEN-LAST:event_btnAdelanteActionPerformed

    private void btnBuscarInformeViabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarInformeViabilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarInformeViabilidadActionPerformed

    private void lblParaInformeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInformeMouseMoved
        
    }//GEN-LAST:event_lblParaInformeMouseMoved

    private void lblParaInforme1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme1MouseMoved

    private void lblParaInforme2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme2MouseMoved

    private void lblParaInforme3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme3MouseMoved

    private void lblParaInforme5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme5MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme5MouseMoved

    private void lblParaInforme6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme6MouseMoved

    private void lblParaInforme7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme7MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme7MouseMoved

    private void lblParaInforme8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme8MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme8MouseMoved

    private void lblParaInforme9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme9MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme9MouseMoved

    private void lblParaInforme10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme10MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme10MouseMoved

    private void lblParaInforme11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme11MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme11MouseMoved

    private void lblParaInforme4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme4MouseMoved

    private void lblParaInforme12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme12MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme12MouseMoved

    private void lblParaInforme13MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme13MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme13MouseMoved

    private void lblParaInforme14MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme14MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme14MouseMoved

    private void lblParaInforme15MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme15MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme15MouseMoved

    private void lblParaInforme16MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme16MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme16MouseMoved

    private void lblParaInforme17MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme17MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme17MouseMoved

    private void lblParaInforme18MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme18MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme18MouseMoved

    private void lblParaInforme19MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme19MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme19MouseMoved

    private void lblParaInforme20MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme20MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme20MouseMoved

    private void lblParaInforme21MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme21MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme21MouseMoved

    private void lblParaInforme22MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme22MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme22MouseMoved

    private void lblParaInforme23MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme23MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme23MouseMoved

    private void lblParaInforme24MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme24MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme24MouseMoved

    private void lblParaInforme25MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme25MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme25MouseMoved

    private void lblParaInforme26MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme26MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme26MouseMoved

    private void lblParaInforme27MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme27MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme27MouseMoved

    private void lblParaInforme28MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme28MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme28MouseMoved

    private void lblParaInforme29MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme29MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme29MouseMoved

    private void lblParaInforme30MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme30MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme30MouseMoved

    private void lblParaInforme31MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme31MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme31MouseMoved

    private void lblParaInforme32MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme32MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme32MouseMoved

    private void lblParaInforme33MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme33MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme33MouseMoved

    private void lblParaInforme34MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParaInforme34MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblParaInforme34MouseMoved

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Métodos">   
    private void validarProcesoInformeAtras() {
        switch (jtpInformeViabilidad.getSelectedIndex()) {
            case 4:
                if (validarPrimeraSeccion().equals("")) {
                    jtpInformeViabilidad.setEnabledAt(4, false);
                    jtpInformeViabilidad.setEnabledAt(3, true);
                    jtpInformeViabilidad.setSelectedIndex(3);
                    btnAtras.setEnabled(true);
                    btnAdelante.setEnabled(true);
                    ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_adelante_32.png"));
                    btnAdelante.setIcon(icon);
                    btnAdelante.setToolTipText("Siguiente");
                } else {
                    JOptionPane.showMessageDialog(rootPane, validarPrimeraSeccion(), "Completar", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 3:
                if (validarPrimeraSeccion().equals("")) {
                    jtpInformeViabilidad.setEnabledAt(3, false);
                    jtpInformeViabilidad.setEnabledAt(2, true);
                    jtpInformeViabilidad.setSelectedIndex(2);
                    btnAtras.setEnabled(true);
                    btnAdelante.setEnabled(true);
                    ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_adelante_32.png"));
                    btnAdelante.setIcon(icon);
                    btnAdelante.setToolTipText("Siguiente");
                }
                break;
            case 2:
                if (validarPrimeraSeccion().equals("")) {
                    jtpInformeViabilidad.setEnabledAt(2, false);
                    jtpInformeViabilidad.setEnabledAt(1, true);
                    jtpInformeViabilidad.setSelectedIndex(1);
                    btnAtras.setEnabled(true);
                    btnAdelante.setEnabled(true);
                    ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_adelante_32.png"));
                    btnAdelante.setIcon(icon);
                    btnAdelante.setToolTipText("Siguiente");
                }
                break;
            case 1:
                if (validarPrimeraSeccion().equals("")) {
                    jtpInformeViabilidad.setEnabledAt(1, false);
                    jtpInformeViabilidad.setEnabledAt(0, true);
                    jtpInformeViabilidad.setSelectedIndex(0);
                    btnAtras.setEnabled(false);
                    btnAdelante.setEnabled(true);
                    ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_adelante_32.png"));
                    btnAdelante.setIcon(icon);
                    btnAdelante.setToolTipText("Siguiente");
                }
                break;
            default:
                break;
        }
    }

    private void validarProcesoInformeAdelante() {
        switch (jtpInformeViabilidad.getSelectedIndex()) {
            case 0:
                if (validarPrimeraSeccion().equals("")) {
                    jtpInformeViabilidad.setEnabledAt(0, false);
                    jtpInformeViabilidad.setEnabledAt(1, true);
                    jtpInformeViabilidad.setSelectedIndex(1);
                    btnAtras.setEnabled(true);
                    btnAdelante.setEnabled(true);
                    ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_adelante_32.png"));
                    btnAdelante.setIcon(icon);
                    cargarSegundaSeccion();
                    btnAdelante.setToolTipText("Siguiente");
                } else {
                    JOptionPane.showMessageDialog(null, validarPrimeraSeccion(), "Completar", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 1:
                if (validarSegundaSeccion().equals("")) {
                    jtpInformeViabilidad.setEnabledAt(1, false);
                    jtpInformeViabilidad.setEnabledAt(2, true);
                    jtpInformeViabilidad.setSelectedIndex(2);
                    btnAtras.setEnabled(true);
                    btnAdelante.setEnabled(true);
                    ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_adelante_32.png"));
                    btnAdelante.setIcon(icon);
                    btnAdelante.setToolTipText("Siguiente");
                } else {
                    JOptionPane.showMessageDialog(null, validarPrimeraSeccion(), "Completar", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 2:
                if (validarPrimeraSeccion().equals("")) {
                    jtpInformeViabilidad.setEnabledAt(2, false);
                    jtpInformeViabilidad.setEnabledAt(3, true);
                    jtpInformeViabilidad.setSelectedIndex(3);
                    btnAtras.setEnabled(true);
                    btnAdelante.setEnabled(true);
                    ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_adelante_32.png"));
                    btnAdelante.setIcon(icon);
                    btnAdelante.setToolTipText("Siguiente");
                } else {
                    JOptionPane.showMessageDialog(null, validarPrimeraSeccion(), "Completar", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 3:
                if (validarPrimeraSeccion().equals("")) {
                    jtpInformeViabilidad.setEnabledAt(3, false);
                    jtpInformeViabilidad.setEnabledAt(4, true);
                    jtpInformeViabilidad.setSelectedIndex(4);
                    btnAtras.setEnabled(true);
                    btnAdelante.setEnabled(true);
                    ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_crear_actualizar_40.png"));
                    btnAdelante.setIcon(icon);
                    btnAdelante.setToolTipText("Guardar");
                } else {
                    JOptionPane.showMessageDialog(null, validarPrimeraSeccion(), "Completar", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 4:
                if (validarPrimeraSeccion().equals("")) {
                    btnAtras.setEnabled(true);
                    btnAdelante.setEnabled(true);
                }
                break;
            default:
                break;
        }
    }

    private String validarPrimeraSeccion() {
        String errores = "";
        if (txtNumeroInforme.getText().equals("")) {
            errores += "Número de Informe\n";
        }
        if (dtFechaInforme.getDate().equals("")) {
            errores += "Fecha\n";
        }
        if (txaNombreInstituto.getText().equals("")) {
            errores += "Nombre Instituto\n";
        }
        if (idCarrera.equals("")) {
            errores += "Carrera\n";
        }
        if (idEmpresa.equals("")) {
            errores += "Empresa\n";
        }
        if (txaPara.getText().equals("")) {
            errores += "Para\n";
        }
        if (txaAsunto.getText().equals("")) {
            errores += "Asunto\n";
        }
        if (txaSolicitante.getText().equals("")) {
            errores += "Solicitante\n";
        }
        return errores;
    }

    private String validarSegundaSeccion() {
        String errores = "";
        if (txtNumeroInforme.getText().equals("")) {
            errores += "Número de Informe\n";
        }
        if (dtFechaInforme.getDate().equals("")) {
            errores += "Fecha\n";
        }
        if (idInstituto.equals("")) {
            errores += "Nombre Instituto\n";
        }
        if (idCarrera.equals("")) {
            errores += "Carrera\n";
        }
        if (idEmpresa.equals("")) {
            errores += "Empresa\n";
        }
        if (txaPara.getText().equals("")) {
            errores += "Para\n";
        }
        if (txaAsunto.getText().equals("")) {
            errores += "Asunto\n";
        }
        if (txaSolicitante.getText().equals("")) {
            errores += "Solicitante\n";
        }
        return errores;
    }

    private void cargarPrimeraSeccion() {
        idCarrera = "";
        idEmpresa = "";
        idInstituto = "";
        ControladorViabilidad controladorViabilidad = new ControladorViabilidad();
        txtNumeroInforme.setText(controladorViabilidad.obtenerNumeroInforme());
        idInstituto = controladorViabilidad.obtenerInstituto()[0];
        txaNombreInstituto.setText(controladorViabilidad.obtenerInstituto()[1]);
        txaPara.setText(controladorViabilidad.obtenerParaAsuntoSolicitante()[0]);
        txaAsunto.setText(controladorViabilidad.obtenerParaAsuntoSolicitante()[1]);
        txaSolicitante.setText(controladorViabilidad.obtenerParaAsuntoSolicitante()[2]);
    }

    private void cargarSegundaSeccion() {
        ControladorViabilidad controladorViabilidad = new ControladorViabilidad();
        txtFechaAcercamiento.setText(controladorViabilidad.obtenerFechaAcercamiento(idEmpresa));

    }

    private void llenarGridEntidadesRegulacion() {
        criterioBusqueda[0] = "0";
        jtEntidadesRegulacion.setModel(controladorGrid.getInstance().llenarGridEntidadesRegulacion());
        formatearColumnas();
    }

    private void llenarGridDocumentosHabilitantesEntidadReceptora() {
        criterioBusqueda[0] = "0";
        jtDocumentosHabilitantesEntidadReceptora.setModel(controladorGrid.getInstance().llenarGridDocumentosHabilitantes("viabilidad_documentos_habilitantes_entidad_receptora"));
    }

    private void llenarGridDocumentosHabilitantesInstituto() {
        criterioBusqueda[0] = "0";
        jtDocumentosHabilitantesInstituto.setModel(controladorGrid.getInstance().llenarGridDocumentosHabilitantes("viabilidad_documentos_habilitantes_instituto"));
        formatearGridDocumentosHabilitantes();
    }

    private void formatearColumnas() {
        //Oculta la primera columna que corresponde al ID de la tabla
        jtEntidadesRegulacion.getColumnModel().getColumn(0).setMaxWidth(0);
        jtEntidadesRegulacion.getColumnModel().getColumn(0).setMinWidth(0);
        jtEntidadesRegulacion.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    private void formatearGridDocumentosHabilitantes() {
        jtDocumentosHabilitantesEntidadReceptora.getColumnModel().getColumn(0).setMaxWidth(0);
        jtDocumentosHabilitantesEntidadReceptora.getColumnModel().getColumn(0).setMinWidth(0);
        jtDocumentosHabilitantesEntidadReceptora.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        jtDocumentosHabilitantesEntidadReceptora.getColumnModel().getColumn(1).setMaxWidth(1000);
        jtDocumentosHabilitantesEntidadReceptora.getColumnModel().getColumn(1).setMinWidth(0);
        jtDocumentosHabilitantesEntidadReceptora.getColumnModel().getColumn(1).setPreferredWidth(725);
        
        
        jtDocumentosHabilitantesInstituto.getColumnModel().getColumn(0).setMaxWidth(0);
        jtDocumentosHabilitantesInstituto.getColumnModel().getColumn(0).setMinWidth(0);
        jtDocumentosHabilitantesInstituto.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        jtDocumentosHabilitantesInstituto.getColumnModel().getColumn(1).setMaxWidth(1000);
        jtDocumentosHabilitantesInstituto.getColumnModel().getColumn(1).setMinWidth(0);
        jtDocumentosHabilitantesInstituto.getColumnModel().getColumn(1).setPreferredWidth(700);
    }

    private void formatearGridSucursales() {
        jtSucursales.getColumnModel().getColumn(0).setMaxWidth(0);
        jtSucursales.getColumnModel().getColumn(0).setMinWidth(0);
        jtSucursales.getColumnModel().getColumn(0).setPreferredWidth(0);

        jtSucursales.getColumnModel().getColumn(1).setMaxWidth(0);
        jtSucursales.getColumnModel().getColumn(1).setMinWidth(0);
        jtSucursales.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    private void formatearGridEscenariosPedagogicos() {
        jtEscenariosPedagogicos.getColumnModel().getColumn(1).setMaxWidth(500);
        jtEscenariosPedagogicos.getColumnModel().getColumn(1).setMinWidth(0);
        jtEscenariosPedagogicos.getColumnModel().getColumn(1).setPreferredWidth(250);
    }

    private void formatearGridAsignaturas() {
        jtAsignaturas.getColumnModel().getColumn(0).setMaxWidth(0);
        jtAsignaturas.getColumnModel().getColumn(0).setMinWidth(0);
        jtAsignaturas.getColumnModel().getColumn(0).setPreferredWidth(0);

        jtAsignaturas.getColumnModel().getColumn(1).setMaxWidth(0);
        jtAsignaturas.getColumnModel().getColumn(1).setMinWidth(0);
        jtAsignaturas.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    private void buscar(String tabla, String tipo, String[] criterio) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia la el formulario con la ventana de busqueda
        consulta.consultar(tabla, tipo, criterio);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void llenarEmpresa(ArrayList<Object> datos) {
        idEmpresa = (String.valueOf(datos.get(0)));
        txtRUC.setText(String.valueOf(datos.get(1)));
        txtEmpresa.setText(String.valueOf(datos.get(3)));
    }

    private void llenarCarrera(ArrayList<Object> datos) {
        idCarrera = (String.valueOf(datos.get(0)));
        txtCarrera.setText(String.valueOf(datos.get(1)));
    }

    private void llenarEmpresaSucursal(ArrayList<Object> datos) {
        String[] nombresColumnas = {"id", "empresa", "SUCURSALES"};

        DefaultTableModel modelo = new DefaultTableModel(nombresColumnas, 0);
        if (jtSucursales.getRowCount() == 0) {
            modelo.addRow(arrayListToArrayString(datos));
        } else {

            for (int i = 0; i < jtSucursales.getRowCount(); i++) {
                modelo.addRow(nombresColumnas);
                modelo.setValueAt(jtSucursales.getValueAt(i, 0).toString(), i, 0);
                modelo.setValueAt(jtSucursales.getValueAt(i, 1).toString(), i, 1);
                modelo.setValueAt(jtSucursales.getValueAt(i, 2).toString(), i, 2);

            }
            modelo.addRow(arrayListToArrayString(datos));
        }
        jtSucursales.setModel(modelo);
    }

    private void llenarAsignatura(ArrayList<Object> datos) {
        String[] nombresColumnas = {"id", "carrera", "ASGINATURAS"};
        DefaultTableModel modelo = new DefaultTableModel(nombresColumnas, 0);
        if (jtAsignaturas.getRowCount() == 0) {
            modelo.addRow(arrayListToArrayString(datos));
        } else {

            for (int i = 0; i < jtAsignaturas.getRowCount(); i++) {
                modelo.addRow(nombresColumnas);
                modelo.setValueAt(jtAsignaturas.getValueAt(i, 0).toString(), i, 0);
                modelo.setValueAt(jtAsignaturas.getValueAt(i, 1).toString(), i, 1);
                modelo.setValueAt(jtAsignaturas.getValueAt(i, 2).toString(), i, 2);

            }
            modelo.addRow(arrayListToArrayString(datos));
        }
        jtAsignaturas.setModel(modelo);
    }

    private Object[] arrayListToArrayString(ArrayList datos) {
        Object[] datosTemporales = new Object[datos.size()];
        for (int i = 0; i < datos.size(); i++) {
            datosTemporales[i] = datos.get(i).toString();
        }
        return datosTemporales;
    }

    private ArrayList<Object> consultarRegistroIndividual(String id, String tabla) {
        criterioBusqueda[0] = id;
        controladorConsulta consulta = new controladorConsulta();
        return consulta.obtenerConsulta(tabla, controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);
    }

    private void llenarAsunto() {
        txaAsunto.setText(txaAsunto.getText() + " " + txtEmpresa.getText() + " y el " + txaNombreInstituto.getText());
    }
    // </editor-fold>     
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgConstatacion;
    private javax.swing.ButtonGroup btgEquipo;
    private javax.swing.ButtonGroup btgNormasSeguridad;
    private javax.swing.ButtonGroup btgRecompensa;
    private javax.swing.ButtonGroup btgUniforme;
    private javax.swing.JButton btnAdelante;
    private javax.swing.JButton btnAdjuntarAnexos;
    private javax.swing.JButton btnAgregarAsignatura;
    private javax.swing.JButton btnAgregarEscenarioPedagogico;
    private javax.swing.JButton btnAgregarSucursal;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscarCarrera;
    private javax.swing.JButton btnBuscarEmpresa;
    private javax.swing.JButton btnBuscarInformeViabilidad;
    private javax.swing.JButton btnBuscarRepresentanteLegal;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarAsignatura;
    private javax.swing.JButton btnQuitarEscenarioPedagogico;
    private javax.swing.JButton btnQuitarSucursal;
    public static com.toedter.calendar.JDateChooser dtFechaInforme;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpCuartaQuintaSeccion;
    private javax.swing.JPanel jpPrimeraSeccion;
    private javax.swing.JPanel jpSegundaSeccion;
    private javax.swing.JPanel jpTerceraSeccion2;
    private javax.swing.JPanel jpTereceraSeccion1;
    private javax.swing.JSpinner jsCantidadEstudiantes;
    private javax.swing.JSpinner jsCantidadTutores;
    private javax.swing.JSpinner jsPlazo;
    private javax.swing.JTable jtAsignaturas;
    private javax.swing.JTable jtAsignaturas2;
    private javax.swing.JTable jtDocumentosHabilitantesEntidadReceptora;
    private javax.swing.JTable jtDocumentosHabilitantesInstituto;
    private javax.swing.JTable jtEntidadesRegulacion;
    private javax.swing.JTable jtEscenariosPedagogicos;
    private javax.swing.JTable jtSucursales;
    private javax.swing.JTabbedPane jtpInformeViabilidad;
    private javax.swing.JLabel lblAsunto;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEmpresa1;
    private javax.swing.JLabel lblFechaInforme;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPara;
    private javax.swing.JLabel lblParaInforme;
    private javax.swing.JLabel lblParaInforme1;
    private javax.swing.JLabel lblParaInforme10;
    private javax.swing.JLabel lblParaInforme11;
    private javax.swing.JLabel lblParaInforme12;
    private javax.swing.JLabel lblParaInforme13;
    private javax.swing.JLabel lblParaInforme14;
    private javax.swing.JLabel lblParaInforme15;
    private javax.swing.JLabel lblParaInforme16;
    private javax.swing.JLabel lblParaInforme17;
    private javax.swing.JLabel lblParaInforme18;
    private javax.swing.JLabel lblParaInforme19;
    private javax.swing.JLabel lblParaInforme2;
    private javax.swing.JLabel lblParaInforme20;
    private javax.swing.JLabel lblParaInforme21;
    private javax.swing.JLabel lblParaInforme22;
    private javax.swing.JLabel lblParaInforme23;
    private javax.swing.JLabel lblParaInforme24;
    private javax.swing.JLabel lblParaInforme25;
    private javax.swing.JLabel lblParaInforme26;
    private javax.swing.JLabel lblParaInforme27;
    private javax.swing.JLabel lblParaInforme28;
    private javax.swing.JLabel lblParaInforme29;
    private javax.swing.JLabel lblParaInforme3;
    private javax.swing.JLabel lblParaInforme30;
    private javax.swing.JLabel lblParaInforme31;
    private javax.swing.JLabel lblParaInforme32;
    private javax.swing.JLabel lblParaInforme33;
    private javax.swing.JLabel lblParaInforme34;
    private javax.swing.JLabel lblParaInforme4;
    private javax.swing.JLabel lblParaInforme5;
    private javax.swing.JLabel lblParaInforme6;
    private javax.swing.JLabel lblParaInforme7;
    private javax.swing.JLabel lblParaInforme8;
    private javax.swing.JLabel lblParaInforme9;
    private javax.swing.JLabel lblRUC;
    private javax.swing.JLabel lblSolicitante;
    private javax.swing.JRadioButton rbNoConstatacion;
    private javax.swing.JRadioButton rbNoEquipoProteccion;
    private javax.swing.JRadioButton rbNoNormasSeguridad;
    private javax.swing.JRadioButton rbNoRecompensa;
    private javax.swing.JRadioButton rbNoUniforme;
    private javax.swing.JRadioButton rbSiConstatacion;
    private javax.swing.JRadioButton rbSiEquipoProteccion;
    private javax.swing.JRadioButton rbSiNormasSeguridad;
    private javax.swing.JRadioButton rbSiRecompensa;
    private javax.swing.JRadioButton rbSiUniforme;
    private javax.swing.JTextArea txaAsunto;
    private javax.swing.JTextArea txaConsideracionesRecomendaciones;
    private javax.swing.JTextArea txaDireccion2;
    private javax.swing.JTextArea txaNombreInstituto;
    private javax.swing.JTextArea txaObjetivo;
    private javax.swing.JTextArea txaObjetivo1;
    private javax.swing.JTextArea txaObjetivo2;
    private javax.swing.JTextArea txaObjetivo4;
    private javax.swing.JTextArea txaObservacionesDeudas;
    private javax.swing.JTextArea txaOtrosDocumentosHabilitantes;
    private javax.swing.JTextArea txaPara;
    private javax.swing.JTextArea txaProcesoDesignacionEstudiantes;
    private javax.swing.JTextArea txaSolicitante;
    private javax.swing.JTextField txtAdministradorEntidadReceptora;
    private javax.swing.JTextField txtAdministradorInstituto;
    private javax.swing.JFormattedTextField txtCarrera;
    private javax.swing.JTextField txtCreacionResolucion1;
    private javax.swing.JTextField txtCreacionResolucion7;
    private javax.swing.JTextField txtCreacionResolucion8;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtFechaAcercamiento;
    private javax.swing.JTextField txtNombreRepresentanteLegal;
    private javax.swing.JFormattedTextField txtNumeroInforme;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtRemitenteEntidadReceptora;
    private javax.swing.JTextField txtRemitenteInstituto;
    // End of variables declaration//GEN-END:variables
// </editor-fold>  
}
