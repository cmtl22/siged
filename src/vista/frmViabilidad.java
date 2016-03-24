
package vista;

import controlador.ControladorViabilidad;
import controlador.controladorConsulta;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Container;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;

public class frmViabilidad extends javax.swing.JInternalFrame {

// <editor-fold defaultstate="collapsed" desc="Declaracion de Variables">     
//fks
    private String accion;   
    private String idEmpresaSucursal;
    private String[] idsCarrera;
    private String idPersona;
    private String idInstituto;
    private String idEmpresa;
    
    private DefaultTableModel modeloSucursales;
    private DefaultTableModel modeloCarreras  = new DefaultTableModel(); 
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
        accion = "crear";
        criterioBusqueda = new String[2];
        idEmpresaSucursal = "-1";
        //idCarrera = "-1";
        nombreEmpresa = " ";
        nombreInstituto = " ";
        idEmpresa = "-1";  
        direccionEmpresa = new String[10];
        direccionSucursal = new String[10];
        
        modeloSucursales = null;
        modeloDireccionMatriz = new DefaultTableModel();
        modeloDireccionSucursal = null;
        //llenarGridDocumentosHabilitantes();
        
        //llenarGrid();
        llenarGridEntidadesDeControl();
        //llenarFiltro();
        //cargarTotalRegistros();
        

    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupConductaInstitucional = new javax.swing.ButtonGroup();
        buttonGroupRenovacionConvenio = new javax.swing.ButtonGroup();
        buttonGroupUniformesEstudiantes = new javax.swing.ButtonGroup();
        buttonGroupEquipoDeProteccion = new javax.swing.ButtonGroup();
        buttonGroupNormasDeSeguridad = new javax.swing.ButtonGroup();
        buttonGroupCompensacion = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jp_Viabilidad = new javax.swing.JTabbedPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        jp_DatosGenerales = new javax.swing.JPanel();
        lblAsunto = new javax.swing.JLabel();
        lblSolicitante = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblPara = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        txtRUC = new javax.swing.JTextField();
        lblRUC = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        dtFechaInforme = new com.toedter.calendar.JDateChooser();
        lblFechaInforme = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        txaPara = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        txaAsunto = new javax.swing.JTextArea();
        jScrollPane20 = new javax.swing.JScrollPane();
        txaSolicitante = new javax.swing.JTextArea();
        btnBuscarEmpresa = new javax.swing.JButton();
        btnBuscarEncargadoSenescyt = new javax.swing.JButton();
        lblEmpresa1 = new javax.swing.JLabel();
        txtInstituto = new javax.swing.JTextField();
        btnBuscarInstittuto = new javax.swing.JButton();
        txtViabNumeroInforme = new javax.swing.JFormattedTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        jp_Antecedentes = new javax.swing.JPanel();
        jrbConductaInstitucionalSi = new javax.swing.JRadioButton();
        jrbConductaInstitucionalNo = new javax.swing.JRadioButton();
        lblObservaciones = new javax.swing.JLabel();
        lblConsideracionesRecomendaciones = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaObservacionesDeudas = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObservacionesConsideracionesRecomendaciones = new javax.swing.JTextArea();
        lblFechaDeAcercamientoInicial = new javax.swing.JLabel();
        txtFechaDeAcercamientoInicial = new javax.swing.JTextField();
        lblListadoDocumentacionRespaldo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaListadoDocumentacionRespaldo = new javax.swing.JTextArea();
        lblNombreRepresentanteLegal = new javax.swing.JLabel();
        txtNombreRepresentanteLegal = new javax.swing.JTextField();
        lblTipoDeEmpresa = new javax.swing.JLabel();
        txtTipoDeEmpresa = new javax.swing.JTextField();
        lblActividadEconomica = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtActividadEconomica = new javax.swing.JTextArea();
        lblDireccionMatriz = new javax.swing.JLabel();
        lblDireccionSucursal = new javax.swing.JLabel();
        lblInfoRepresentanteLegal = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jtDireccionMatriz = new javax.swing.JTable();
        jScrollPane25 = new javax.swing.JScrollPane();
        jtSucursales = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtDeudas = new javax.swing.JTable();
        lblTipoDeEmpresa1 = new javax.swing.JLabel();
        txtNombreER = new javax.swing.JTextField();
        btnBuscarRepresentanteLegal = new javax.swing.JButton();
        btnAgregarEmsu = new javax.swing.JButton();
        btnQuitarCarrera1 = new javax.swing.JButton();
        lblDireccionSucursal2 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jpContenidoDelInforme = new javax.swing.JPanel();
        lblNombreInstituto = new javax.swing.JLabel();
        txtNombreInstituto = new javax.swing.JTextField();
        lblDocCreacionInstituto = new javax.swing.JLabel();
        txtDocCreacionInstituto = new javax.swing.JTextField();
        lblNombreRector = new javax.swing.JLabel();
        txtNombreRector = new javax.swing.JTextField();
        lblNumYTipoDeContrato = new javax.swing.JLabel();
        txtNumYTipoDeContrato = new javax.swing.JTextField();
        lblNombreCarreras = new javax.swing.JLabel();
        lblNumResolucion = new javax.swing.JLabel();
        lblNumTutores = new javax.swing.JLabel();
        lblPlazoVigenciaConvenio = new javax.swing.JLabel();
        lblDisposicionRenovarConvenio = new javax.swing.JLabel();
        jrbRespuestaRenovarConvenioSi = new javax.swing.JRadioButton();
        jrbRespuestaRenovarConvenioNo = new javax.swing.JRadioButton();
        lblObservacionesPlazoConvenio = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        txaObservacionesPlazoConvenio = new javax.swing.JTextArea();
        lblAsignaturas = new javax.swing.JLabel();
        lblEstudiantesEscenarioPedagogico = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtEstudiantesEscenarioPedagogico = new javax.swing.JTable();
        lbAdministradorConvInstituto = new javax.swing.JLabel();
        txtAdministradorConvInstituto = new javax.swing.JTextField();
        lbAdministradorConvER = new javax.swing.JLabel();
        txtAdministradorConvER = new javax.swing.JTextField();
        lblCompensacionEstudiantes = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaProcesoDesignacionEstudiantes = new javax.swing.JTextArea();
        lblProcesoDesignacionEstudiantes1 = new javax.swing.JLabel();
        lblDotacionUniformes = new javax.swing.JLabel();
        jrbUniformesSi = new javax.swing.JRadioButton();
        jrbUniformeNo = new javax.swing.JRadioButton();
        lblEquipoDeProteccion = new javax.swing.JLabel();
        jrbEquipoDeProteccionSi = new javax.swing.JRadioButton();
        jrbEquipoDeProteccionNo = new javax.swing.JRadioButton();
        lbObservacionesCondicionesEstudiantes = new javax.swing.JLabel();
        jrbNormasDeSeguridadSi = new javax.swing.JRadioButton();
        jrbNormasDeSeguridadNo = new javax.swing.JRadioButton();
        lblNormasDeSeguridad1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txaObservacionesCondicionesEstudiantes = new javax.swing.JTextArea();
        lblCompensacionEstudiante2 = new javax.swing.JLabel();
        jrbCompensacionSi = new javax.swing.JRadioButton();
        jrbCompensacionNo = new javax.swing.JRadioButton();
        lblTipoCompensacion = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txaCondiciones = new javax.swing.JTextArea();
        lblCondiciones = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txaTipoCompensacion = new javax.swing.JTextArea();
        btnAgregarCarrera = new javax.swing.JButton();
        btnQuitarCarrera = new javax.swing.JButton();
        jScrollPane23 = new javax.swing.JScrollPane();
        jtNombreCarreras = new javax.swing.JTable();
        jspNumEstudiantes = new javax.swing.JSpinner();
        jspNumTutores = new javax.swing.JSpinner();
        jspPlazoVigenciaConvenio = new javax.swing.JSpinner();
        jScrollPane26 = new javax.swing.JScrollPane();
        jtAsignaturas = new javax.swing.JTable();
        btnAgregarAsignatura = new javax.swing.JButton();
        btnQuitarAsignatura = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        jpConclusiones = new javax.swing.JPanel();
        lblElaborado = new javax.swing.JLabel();
        txtElaborado = new javax.swing.JTextField();
        lblRevisado = new javax.swing.JLabel();
        txtRevisado = new javax.swing.JTextField();
        lblAprobado = new javax.swing.JLabel();
        txtAprobado = new javax.swing.JTextField();
        lblRegistro = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnAdjuntarAnexos = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("VIABILIDAD");
        setMaximumSize(new java.awt.Dimension(945, 535));
        setPreferredSize(new java.awt.Dimension(945, 535));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(935, 535));
        jPanel1.setPreferredSize(new java.awt.Dimension(935, 535));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_Viabilidad.setBackground(new java.awt.Color(255, 255, 255));
        jp_Viabilidad.setForeground(new java.awt.Color(0, 0, 102));
        jp_Viabilidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jp_Viabilidad.setMaximumSize(new java.awt.Dimension(946, 520));
        jp_Viabilidad.setPreferredSize(new java.awt.Dimension(946, 520));

        jp_DatosGenerales.setBackground(new java.awt.Color(255, 255, 255));
        jp_DatosGenerales.setAutoscrolls(true);
        jp_DatosGenerales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAsunto.setText("Asunto:");
        jp_DatosGenerales.add(lblAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 190, 210, 25));

        lblSolicitante.setText("Solicitante:");
        jp_DatosGenerales.add(lblSolicitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 210, 25));

        jLabel5.setText("N° Informe:");
        jp_DatosGenerales.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 210, 25));

        lblPara.setText("Para:");
        jp_DatosGenerales.add(lblPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 210, 25));

        lblEmpresa.setText("Empresa:");
        jp_DatosGenerales.add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 30, 210, 25));

        txtEmpresa.setEditable(false);
        jp_DatosGenerales.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 70, 240, 25));

        txtRUC.setEditable(false);
        jp_DatosGenerales.add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 150, 160, 25));

        lblRUC.setText("RUC:");
        jp_DatosGenerales.add(lblRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 110, 210, 25));

        lblId.setText("0");
        lblId.setEnabled(false);
        jp_DatosGenerales.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 12, 110, 20));

        dtFechaInforme.setDateFormatString("yyyy-MM-dd");
        jp_DatosGenerales.add(dtFechaInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 210, 25));
        dtFechaInforme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Date date = new Date();
        dtFechaInforme.setDate(date);

        lblFechaInforme.setText("Fecha Informe:");
        jp_DatosGenerales.add(lblFechaInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 210, 25));

        jScrollPane15.setEnabled(false);

        txaPara.setEditable(false);
        txaPara.setBackground(new java.awt.Color(238, 238, 238));
        txaPara.setColumns(20);
        txaPara.setLineWrap(true);
        txaPara.setRows(3);
        txaPara.setWrapStyleWord(true);
        txaPara.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        txaPara.setFocusCycleRoot(true);
        txaPara.setFocusTraversalPolicyProvider(true);
        txaPara.setFocusable(false);
        txaPara.setRequestFocusEnabled(false);
        txaPara.setVerifyInputWhenFocusTarget(false);
        jScrollPane15.setViewportView(txaPara);

        jp_DatosGenerales.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 320, -1));

        jScrollPane19.setEnabled(false);

        txaAsunto.setBackground(new java.awt.Color(238, 238, 238));
        txaAsunto.setColumns(20);
        txaAsunto.setLineWrap(true);
        txaAsunto.setRows(3);
        txaAsunto.setWrapStyleWord(true);
        txaAsunto.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jScrollPane19.setViewportView(txaAsunto);

        jp_DatosGenerales.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 221, 320, 70));

        jScrollPane20.setEnabled(false);

        txaSolicitante.setEditable(false);
        txaSolicitante.setBackground(new java.awt.Color(238, 238, 238));
        txaSolicitante.setColumns(20);
        txaSolicitante.setLineWrap(true);
        txaSolicitante.setRows(3);
        txaSolicitante.setWrapStyleWord(true);
        txaSolicitante.setCaretColor(new java.awt.Color(0, 153, 255));
        txaSolicitante.setRequestFocusEnabled(false);
        txaSolicitante.setVerifyInputWhenFocusTarget(false);
        jScrollPane20.setViewportView(txaSolicitante);

        jp_DatosGenerales.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 250, -1));

        btnBuscarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnBuscarEmpresa.setToolTipText("BUSCAR EMPRESA");
        btnBuscarEmpresa.setBorder(null);
        btnBuscarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpresaActionPerformed(evt);
            }
        });
        jp_DatosGenerales.add(btnBuscarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));

        btnBuscarEncargadoSenescyt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnBuscarEncargadoSenescyt.setToolTipText("BUSCAR SUBSECRETARIO");
        btnBuscarEncargadoSenescyt.setBorder(null);
        btnBuscarEncargadoSenescyt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarEncargadoSenescyt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEncargadoSenescytActionPerformed(evt);
            }
        });
        jp_DatosGenerales.add(btnBuscarEncargadoSenescyt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        lblEmpresa1.setText("Instittuto:");
        jp_DatosGenerales.add(lblEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, 25));

        txtInstituto.setEditable(false);
        jp_DatosGenerales.add(txtInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 240, 25));

        btnBuscarInstittuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnBuscarInstittuto.setToolTipText("BUSCAR INSTITUTO");
        btnBuscarInstittuto.setBorder(null);
        btnBuscarInstittuto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarInstittuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarInstittutoActionPerformed(evt);
            }
        });
        jp_DatosGenerales.add(btnBuscarInstittuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        txtViabNumeroInforme.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000"))));
        jp_DatosGenerales.add(txtViabNumeroInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 213, 25));

        jScrollPane10.setViewportView(jp_DatosGenerales);

        jp_Viabilidad.addTab("Datos Generales", null, jScrollPane10, "");
        jScrollPane10.getAccessibleContext().setAccessibleName("");
        jScrollPane10.getAccessibleContext().setAccessibleDescription("");
        jScrollPane10.getVerticalScrollBar().setUnitIncrement(16);

        jp_Antecedentes.setBackground(new java.awt.Color(255, 255, 255));
        jp_Antecedentes.setToolTipText("");
        jp_Antecedentes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jp_Antecedentes.setRequestFocusEnabled(false);
        jp_Antecedentes.setVerifyInputWhenFocusTarget(false);
        jp_Antecedentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGroupConductaInstitucional.add(jrbConductaInstitucionalSi);
        jrbConductaInstitucionalSi.setSelected(true);
        jrbConductaInstitucionalSi.setText("SI");
        jp_Antecedentes.add(jrbConductaInstitucionalSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 42, -1));

        btnGroupConductaInstitucional.add(jrbConductaInstitucionalNo);
        jrbConductaInstitucionalNo.setText("NO");
        jp_Antecedentes.add(jrbConductaInstitucionalNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        lblObservaciones.setText("Observaciones sobre deudas:");
        lblObservaciones.setToolTipText("Observaciones respecto al análisis de deudas");
        jp_Antecedentes.add(lblObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, 25));

        lblConsideracionesRecomendaciones.setText("<html>                           <p  > \tConsideraciones Preliminares/Recomendaciones                   </p>                   <small> \t<span style =\"font-weight:normal\"> (Principales consideraciones a tomar en cuenta previo análisis de los apectos técnicos y académicos descritos en el informe y a las conclusiones arribadas)                  </small>             </div> </html>");
        lblConsideracionesRecomendaciones.setToolTipText("");
        jp_Antecedentes.add(lblConsideracionesRecomendaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, -1));

        jLabel14.setText("<html>           <div align=\"justify\">¿Se realizó el análisis preliminar mediante consultas online a las entidades de regulación y control? </div> </html>");
        jp_Antecedentes.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 10, 390, 30));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("<html>           <div align = \"justify\"> \t¿Se constató una conducta institucional/empresarial apropiada, por parte de la empresa?           </div> </html>");
        jLabel7.setMinimumSize(new java.awt.Dimension(140, 15));
        jp_Antecedentes.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 390, 25));

        txaObservacionesDeudas.setColumns(20);
        txaObservacionesDeudas.setRows(2);
        txaObservacionesDeudas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObservacionesDeudasKeyReleased(evt);
            }
        });
        txaObservacionesDeudas.setLineWrap(true);
        jScrollPane1.setViewportView(txaObservacionesDeudas);

        jp_Antecedentes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 390, -1));

        txaObservacionesConsideracionesRecomendaciones.setColumns(20);
        txaObservacionesConsideracionesRecomendaciones.setRows(2);
        txaObservacionesConsideracionesRecomendaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObservacionesConsideracionesRecomendacionesKeyReleased(evt);
            }
        });
        txaObservacionesConsideracionesRecomendaciones.setLineWrap(true);
        jScrollPane2.setViewportView(txaObservacionesConsideracionesRecomendaciones);

        jp_Antecedentes.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 390, -1));

        lblFechaDeAcercamientoInicial.setText("Fecha de Acercamiento Inicial");
        jp_Antecedentes.add(lblFechaDeAcercamientoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 25));

        txtFechaDeAcercamientoInicial.setEditable(false);
        jp_Antecedentes.add(txtFechaDeAcercamientoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 89, -1));

        lblListadoDocumentacionRespaldo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblListadoDocumentacionRespaldo.setText("<html>     <div align=\"justify\">        <p> Documentación de Respaldo:</p>         <small>           <span style =\"font-weight:normal\">  Oficios, Memos, Ayuda Memoria,  etc:</span>        </small>     </div> </html>");
        jp_Antecedentes.add(lblListadoDocumentacionRespaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 390, -1));

        txaListadoDocumentacionRespaldo.setColumns(20);
        txaListadoDocumentacionRespaldo.setRows(3);
        txaListadoDocumentacionRespaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaListadoDocumentacionRespaldoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txaListadoDocumentacionRespaldo);

        jp_Antecedentes.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 390, -1));

        lblNombreRepresentanteLegal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreRepresentanteLegal.setText("<html>\n     <div align=\"justify\">\n        <p>Nombre del Representante Legal o Delegado:</p>\n         <small>\n           <span style =\"font-weight:normal\"> (persona legalmente autorizada para la suscripción de convenios o documentos de similar característica)</span>\n        </small>\n     </div>\n </html>");
        jp_Antecedentes.add(lblNombreRepresentanteLegal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 390, -1));

        txtNombreRepresentanteLegal.setEditable(false);
        txtNombreRepresentanteLegal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreRepresentanteLegalActionPerformed(evt);
            }
        });
        jp_Antecedentes.add(txtNombreRepresentanteLegal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 174, -1));

        lblTipoDeEmpresa.setText("Tipo de Empresa");
        jp_Antecedentes.add(lblTipoDeEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 140, 25));

        txtTipoDeEmpresa.setEditable(false);
        txtTipoDeEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoDeEmpresaActionPerformed(evt);
            }
        });
        jp_Antecedentes.add(txtTipoDeEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 55, -1));

        lblActividadEconomica.setText("Actividad Económica");
        jp_Antecedentes.add(lblActividadEconomica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 390, 25));

        txtActividadEconomica.setEditable(false);
        txtActividadEconomica.setBackground(new java.awt.Color(238, 238, 238));
        txtActividadEconomica.setColumns(20);
        txtActividadEconomica.setRows(2);
        txtActividadEconomica.setLineWrap(true);
        jScrollPane9.setViewportView(txtActividadEconomica);

        jp_Antecedentes.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 390, -1));

        lblDireccionMatriz.setText("Dirección Matriz");
        jp_Antecedentes.add(lblDireccionMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 260, 390, 25));

        lblDireccionSucursal.setText("Sucursales: ");
        jp_Antecedentes.add(lblDireccionSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 380, 344, 25));

        lblInfoRepresentanteLegal.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jp_Antecedentes.add(lblInfoRepresentanteLegal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 570, 400, 70));

        jtDireccionMatriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtDireccionMatriz.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtDireccionMatriz.setPreferredSize(new java.awt.Dimension(1100, 20));
        jScrollPane24.setViewportView(jtDireccionMatriz);

        jp_Antecedentes.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 290, 390, 91));

        jScrollPane25.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jtSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtSucursales.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtSucursales.setComponentPopupMenu(jPopupMenu1);
        jtSucursales.setPreferredSize(new java.awt.Dimension(1100, 1000));
        jScrollPane25.setViewportView(jtSucursales);

        jp_Antecedentes.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 390, 83));

        jtDeudas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Consultado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jtDeudas);

        jp_Antecedentes.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 380, 92));

        lblTipoDeEmpresa1.setText("Nombre de la Entidad Receptora:");
        jp_Antecedentes.add(lblTipoDeEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 200, 25));

        txtNombreER.setEditable(false);
        txtNombreER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreERActionPerformed(evt);
            }
        });
        jp_Antecedentes.add(txtNombreER, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 180, -1));

        btnBuscarRepresentanteLegal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnBuscarRepresentanteLegal.setToolTipText("BUSCAR SUBSECRETARIO");
        btnBuscarRepresentanteLegal.setBorder(null);
        btnBuscarRepresentanteLegal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarRepresentanteLegal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRepresentanteLegalActionPerformed(evt);
            }
        });
        jp_Antecedentes.add(btnBuscarRepresentanteLegal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, -1, -1));

        btnAgregarEmsu.setText("Agregar");
        btnAgregarEmsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmsuActionPerformed(evt);
            }
        });
        jp_Antecedentes.add(btnAgregarEmsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, -1, -1));

        btnQuitarCarrera1.setText("Quitar");
        btnQuitarCarrera1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarCarrera1ActionPerformed(evt);
            }
        });
        jp_Antecedentes.add(btnQuitarCarrera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 80, -1));

        lblDireccionSucursal2.setText("Datos de contacto");
        jp_Antecedentes.add(lblDireccionSucursal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 140, 25));

        jScrollPane16.setViewportView(jp_Antecedentes);

        jp_Viabilidad.addTab("Antecedentes", jScrollPane16);
        jScrollPane16.getVerticalScrollBar().setUnitIncrement(16);

        jpContenidoDelInforme.setBackground(new java.awt.Color(255, 255, 255));
        jpContenidoDelInforme.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreInstituto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreInstituto.setText("Nombre del Instituto:");
        jpContenidoDelInforme.add(lblNombreInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 309, 25));

        txtNombreInstituto.setEditable(false);
        txtNombreInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreInstitutoActionPerformed(evt);
            }
        });
        jpContenidoDelInforme.add(txtNombreInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 49, 309, 25));

        lblDocCreacionInstituto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDocCreacionInstituto.setText("Documento de Creación del Instituto");
        jpContenidoDelInforme.add(lblDocCreacionInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 12, 309, 25));

        txtDocCreacionInstituto.setEditable(false);
        txtDocCreacionInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocCreacionInstitutoActionPerformed(evt);
            }
        });
        jpContenidoDelInforme.add(txtDocCreacionInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 49, 309, 25));

        lblNombreRector.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreRector.setText("Nombre del Rector/a del Instituto");
        jpContenidoDelInforme.add(lblNombreRector, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 92, 309, 25));

        txtNombreRector.setEditable(false);
        txtNombreRector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreRectorActionPerformed(evt);
            }
        });
        jpContenidoDelInforme.add(txtNombreRector, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 129, 309, 25));

        lblNumYTipoDeContrato.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumYTipoDeContrato.setText("N° y Tipo de Contrato del Rector/a del Instituto con el Senescyt:");
        jpContenidoDelInforme.add(lblNumYTipoDeContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 92, 372, 25));

        txtNumYTipoDeContrato.setEditable(false);
        txtNumYTipoDeContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumYTipoDeContratoActionPerformed(evt);
            }
        });
        jpContenidoDelInforme.add(txtNumYTipoDeContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 129, 308, 25));

        lblNombreCarreras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreCarreras.setText("Carreras que entran en el Convenio:");
        jpContenidoDelInforme.add(lblNombreCarreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 172, 214, 25));

        lblNumResolucion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumResolucion.setText(" No. de Estudiantes que recibirá la empresa receptora por ciclo académico: ");
        jpContenidoDelInforme.add(lblNumResolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 170, 310, 25));

        lblNumTutores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumTutores.setText("N° de tutores empresariales");
        jpContenidoDelInforme.add(lblNumTutores, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 320, 210, 25));

        lblPlazoVigenciaConvenio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPlazoVigenciaConvenio.setText("Plazo de vigencia del Convenio (en años):");
        jpContenidoDelInforme.add(lblPlazoVigenciaConvenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 250, 245, 25));

        lblDisposicionRenovarConvenio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDisposicionRenovarConvenio.setText(" ¿La ER está dispuesta a renovar el convenio?");
        jpContenidoDelInforme.add(lblDisposicionRenovarConvenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 400, 280, 25));

        buttonGroupRenovacionConvenio.add(jrbRespuestaRenovarConvenioSi);
        jrbRespuestaRenovarConvenioSi.setSelected(true);
        jrbRespuestaRenovarConvenioSi.setText("SI");
        jpContenidoDelInforme.add(jrbRespuestaRenovarConvenioSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));

        buttonGroupRenovacionConvenio.add(jrbRespuestaRenovarConvenioNo);
        jrbRespuestaRenovarConvenioNo.setText("NO");
        jpContenidoDelInforme.add(jrbRespuestaRenovarConvenioNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, -1, -1));

        lblObservacionesPlazoConvenio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblObservacionesPlazoConvenio.setText("Observaciones respecto al plazo del convenio");
        jpContenidoDelInforme.add(lblObservacionesPlazoConvenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 310, 25));

        txaObservacionesPlazoConvenio.setColumns(1);
        txaObservacionesPlazoConvenio.setRows(2);
        txaObservacionesPlazoConvenio.setPreferredSize(new java.awt.Dimension(150, 32));
        txaObservacionesPlazoConvenio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObservacionesPlazoConvenioKeyReleased(evt);
            }
        });
        jScrollPane18.setViewportView(txaObservacionesPlazoConvenio);

        jpContenidoDelInforme.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 310, -1));

        lblAsignaturas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAsignaturas.setText("<html>Carrera, ciclos académicos y asignaturas que solventan el convenio de formación dual:</html>");
        lblAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAsignaturasMouseClicked(evt);
            }
        });
        jpContenidoDelInforme.add(lblAsignaturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 310, 25));

        lblEstudiantesEscenarioPedagogico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEstudiantesEscenarioPedagogico.setText("Estudiantes por escenario pedagógico");
        jpContenidoDelInforme.add(lblEstudiantesEscenarioPedagogico, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 324, 25));

        jtEstudiantesEscenarioPedagogico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Escenario pedagógico", "No. Estudiantes"
            }
        ));
        TableColumn columnaEscenarioPedagogico = jtEstudiantesEscenarioPedagogico.getColumnModel().getColumn(0);

        JComboBox cmbEscenarios = new JComboBox();
        cmbEscenarios.addItem("Análisis");
        cmbEscenarios.addItem("Limpieza");
        columnaEscenarioPedagogico.setCellEditor(new DefaultCellEditor(cmbEscenarios));
        jScrollPane5.setViewportView(jtEstudiantesEscenarioPedagogico);

        jpContenidoDelInforme.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 324, 92));

        lbAdministradorConvInstituto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAdministradorConvInstituto.setText("Administrador del convenio por parte del instituto:");
        jpContenidoDelInforme.add(lbAdministradorConvInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 610, 320, 25));
        jpContenidoDelInforme.add(txtAdministradorConvInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 650, 320, 25));

        lbAdministradorConvER.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAdministradorConvER.setText("Administrador del convenio por parte de la Empresa Receptora:");
        jpContenidoDelInforme.add(lbAdministradorConvER, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 690, 369, 25));
        jpContenidoDelInforme.add(txtAdministradorConvER, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 730, 319, 25));

        lblCompensacionEstudiantes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCompensacionEstudiantes.setText("Compensación del estudiante:");
        jpContenidoDelInforme.add(lblCompensacionEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 740, 319, 25));

        txaProcesoDesignacionEstudiantes.setColumns(20);
        txaProcesoDesignacionEstudiantes.setRows(3);
        txaProcesoDesignacionEstudiantes.setLineWrap(true);
        txaProcesoDesignacionEstudiantes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaProcesoDesignacionEstudiantesKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(txaProcesoDesignacionEstudiantes);

        jpContenidoDelInforme.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 319, -1));

        lblProcesoDesignacionEstudiantes1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblProcesoDesignacionEstudiantes1.setText("Proceso de designación de estudiantes:");
        jpContenidoDelInforme.add(lblProcesoDesignacionEstudiantes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 319, 25));

        lblDotacionUniformes.setText(" ¿Se dotará de uniforme al estudiante?");
        jpContenidoDelInforme.add(lblDotacionUniformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 760, 319, -1));

        buttonGroupUniformesEstudiantes.add(jrbUniformesSi);
        jrbUniformesSi.setSelected(true);
        jrbUniformesSi.setText("SI");
        jpContenidoDelInforme.add(jrbUniformesSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 780, -1, -1));

        buttonGroupUniformesEstudiantes.add(jrbUniformeNo);
        jrbUniformeNo.setText("NO");
        jpContenidoDelInforme.add(jrbUniformeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 780, -1, -1));

        lblEquipoDeProteccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquipoDeProteccion.setText("<html>       <div align=\"justify\">             ¿Se dotará de equipo mínimo de protección personal al setudiante?       </div>   </html>");
        jpContenidoDelInforme.add(lblEquipoDeProteccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 820, -1, -1));

        buttonGroupEquipoDeProteccion.add(jrbEquipoDeProteccionSi);
        jrbEquipoDeProteccionSi.setSelected(true);
        jrbEquipoDeProteccionSi.setText("SI");
        jpContenidoDelInforme.add(jrbEquipoDeProteccionSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 840, -1, -1));

        buttonGroupEquipoDeProteccion.add(jrbEquipoDeProteccionNo);
        jrbEquipoDeProteccionNo.setText("NO");
        jpContenidoDelInforme.add(jrbEquipoDeProteccionNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 840, -1, -1));

        lbObservacionesCondicionesEstudiantes.setText("<html>\n       <div align=\"justify\">\n             Observaciones\n       </div>\n</html>");
        jpContenidoDelInforme.add(lbObservacionesCondicionesEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 930, 382, 14));

        buttonGroupNormasDeSeguridad.add(jrbNormasDeSeguridadSi);
        jrbNormasDeSeguridadSi.setSelected(true);
        jrbNormasDeSeguridadSi.setText("SI");
        jrbNormasDeSeguridadSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNormasDeSeguridadSiActionPerformed(evt);
            }
        });
        jpContenidoDelInforme.add(jrbNormasDeSeguridadSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 900, -1, -1));

        buttonGroupNormasDeSeguridad.add(jrbNormasDeSeguridadNo);
        jrbNormasDeSeguridadNo.setText("NO");
        jpContenidoDelInforme.add(jrbNormasDeSeguridadNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 900, -1, -1));

        lblNormasDeSeguridad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNormasDeSeguridad1.setText("<html>\n       <div align=\"justify\">\n             ¿Se verificó que las normas de seguridad de la ER garanticen la protección de los estudiantes durante sus prácticas?\n       </div>\n</html>");
        jpContenidoDelInforme.add(lblNormasDeSeguridad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 870, 382, -1));

        txaObservacionesCondicionesEstudiantes.setColumns(20);
        txaObservacionesCondicionesEstudiantes.setRows(2);
        txaObservacionesCondicionesEstudiantes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObservacionesCondicionesEstudiantesKeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(txaObservacionesCondicionesEstudiantes);

        jpContenidoDelInforme.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 960, 382, 57));

        lblCompensacionEstudiante2.setText("<html>\n      <div align=\"justify\">\n            ¿La ER compensará al estudiante en formación dual?\n      </div> \n </html>");
        jpContenidoDelInforme.add(lblCompensacionEstudiante2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 770, 319, 14));

        buttonGroupCompensacion.add(jrbCompensacionSi);
        jrbCompensacionSi.setSelected(true);
        jrbCompensacionSi.setText("SI");
        jpContenidoDelInforme.add(jrbCompensacionSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 790, -1, -1));

        buttonGroupCompensacion.add(jrbCompensacionNo);
        jrbCompensacionNo.setText("NO");
        jpContenidoDelInforme.add(jrbCompensacionNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 790, -1, -1));

        lblTipoCompensacion.setText("<html>\n      <div align=\"justify\">\n            Tipo de compensación:\n      </div> \n </html>");
        jpContenidoDelInforme.add(lblTipoCompensacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 820, 321, -1));

        txaCondiciones.setColumns(20);
        txaCondiciones.setRows(2);
        txaCondiciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaCondicionesKeyReleased(evt);
            }
        });
        jScrollPane11.setViewportView(txaCondiciones);

        jpContenidoDelInforme.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 920, 321, -1));

        lblCondiciones.setText("<html>\n      <div align=\"justify\">\n            Condiciones:\n      </div> \n </html>");
        jpContenidoDelInforme.add(lblCondiciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 890, -1, 14));

        txaTipoCompensacion.setColumns(20);
        txaTipoCompensacion.setRows(1);
        txaTipoCompensacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaTipoCompensacionKeyReleased(evt);
            }
        });
        jScrollPane13.setViewportView(txaTipoCompensacion);

        jpContenidoDelInforme.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 850, 321, 25));

        btnAgregarCarrera.setText("Agregar");
        btnAgregarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarreraActionPerformed(evt);
            }
        });
        jpContenidoDelInforme.add(btnAgregarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 304, -1, -1));

        btnQuitarCarrera.setText("Quitar");
        btnQuitarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarCarreraActionPerformed(evt);
            }
        });
        jpContenidoDelInforme.add(btnQuitarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 304, 80, -1));

        jtNombreCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CARRERA", "N° DE RESOLUCIÓN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane23.setViewportView(jtNombreCarreras);

        jpContenidoDelInforme.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 209, 310, 83));

        jspNumEstudiantes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        jpContenidoDelInforme.add(jspNumEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 210, 49, 25));

        jspNumTutores.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        jpContenidoDelInforme.add(jspNumTutores, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 360, 49, 25));

        jspPlazoVigenciaConvenio.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        jpContenidoDelInforme.add(jspPlazoVigenciaConvenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 280, 49, 25));

        jtAsignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id asignatura", "id carrera", "CARRERA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane26.setViewportView(jtAsignaturas);

        jpContenidoDelInforme.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 310, 83));

        btnAgregarAsignatura.setText("Agregar");
        btnAgregarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAsignaturaActionPerformed(evt);
            }
        });
        jpContenidoDelInforme.add(btnAgregarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, -1, -1));

        btnQuitarAsignatura.setText("Quitar");
        btnQuitarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarAsignaturaActionPerformed(evt);
            }
        });
        jpContenidoDelInforme.add(btnQuitarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 80, -1));

        jScrollPane12.setViewportView(jpContenidoDelInforme);

        jp_Viabilidad.addTab("Contenido", jScrollPane12);
        jScrollPane12.getVerticalScrollBar().setUnitIncrement(16);

        jpConclusiones.setBackground(new java.awt.Color(254, 254, 254));

        lblElaborado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblElaborado.setText("Elaborado:");

        txtElaborado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtElaboradoKeyReleased(evt);
            }
        });

        lblRevisado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRevisado.setText("Revisado:");

        txtRevisado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRevisadoKeyReleased(evt);
            }
        });

        lblAprobado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAprobado.setText("Aprobado:");

        txtAprobado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAprobadoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jpConclusionesLayout = new javax.swing.GroupLayout(jpConclusiones);
        jpConclusiones.setLayout(jpConclusionesLayout);
        jpConclusionesLayout.setHorizontalGroup(
            jpConclusionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConclusionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpConclusionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblElaborado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtElaborado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRevisado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRevisado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(179, 676, Short.MAX_VALUE))
        );
        jpConclusionesLayout.setVerticalGroup(
            jpConclusionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConclusionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblElaborado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtElaborado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRevisado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRevisado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );

        jScrollPane14.setViewportView(jpConclusiones);

        jp_Viabilidad.addTab("Conclusiones", jScrollPane14);
        jScrollPane14.getVerticalScrollBar().setUnitIncrement(16);

        jPanel1.add(jp_Viabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 58, 923, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_nuevo_40.png"))); // NOI18N
        btnNuevo.setToolTipText("NUEVO");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        btnCrearActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_crear_actualizar_40.png"))); // NOI18N
        btnCrearActualizar.setToolTipText("GUARDAR");
        btnCrearActualizar.setBorder(null);
        btnCrearActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_eliminar_40.png"))); // NOI18N
        btnEliminar.setToolTipText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cerrar_40.png"))); // NOI18N
        btnCerrar.setToolTipText("CERRAR");
        btnCerrar.setBorder(null);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, -1, -1));

        btnAdjuntarAnexos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_adjuntar_40.jpg"))); // NOI18N
        btnAdjuntarAnexos.setToolTipText("ADJUNTAR");
        btnAdjuntarAnexos.setBorder(null);
        btnAdjuntarAnexos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdjuntarAnexos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjuntarAnexosActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdjuntarAnexos, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos"> 
    private void txtNombreRepresentanteLegalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreRepresentanteLegalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreRepresentanteLegalActionPerformed

    private void txtTipoDeEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoDeEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoDeEmpresaActionPerformed

    private void txtNombreInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreInstitutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreInstitutoActionPerformed

    private void txtDocCreacionInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocCreacionInstitutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocCreacionInstitutoActionPerformed

    private void txtNombreRectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreRectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreRectorActionPerformed

    private void txtNumYTipoDeContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumYTipoDeContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumYTipoDeContratoActionPerformed

    private void jrbNormasDeSeguridadSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNormasDeSeguridadSiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbNormasDeSeguridadSiActionPerformed

    private void btnAgregarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarreraActionPerformed
        criterioBusqueda[0] = idInstituto;
        
        buscar("carrera_viabilidad","grid_filtro");//abre una ventana de busqueda
        String str = controladorVariablesSesion.getInstance().getDatosTemporalesConsulta();
        llenarNombresCarreras(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "carrera_viabilidad"));//consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos el tipo persona sirve para estudiante, tutor academicoy empresarial

    }//GEN-LAST:event_btnAgregarCarreraActionPerformed

    private void btnQuitarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCarreraActionPerformed
        
        int fila = jtNombreCarreras.getSelectedRow();
        modeloCarreras.removeRow(fila);

    }//GEN-LAST:event_btnQuitarCarreraActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jp_Viabilidad);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jp_Viabilidad);
            //llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        accion = "crear";
        eliminar();//elimina el registro seleccionado
        //llenarGrid();//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
        limpiarCajasTexto(jp_Viabilidad);//limpia las cajas de texto
        cargarTotalRegistros();//carga el total de registros
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpresaActionPerformed
        buscar("empresa_sucursal_acercamiento", "grid");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarEmpresa(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "empresas_viabilidad"));
    }//GEN-LAST:event_btnBuscarEmpresaActionPerformed

    private void btnBuscarEncargadoSenescytActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEncargadoSenescytActionPerformed
        buscar("encargado_senescyt","grid");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarEncargadoSenescyt(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona"));
    }//GEN-LAST:event_btnBuscarEncargadoSenescytActionPerformed

    private void btnBuscarInstittutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarInstittutoActionPerformed
        buscar("instituto","grid");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarInstituto(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "instituto"));
    }//GEN-LAST:event_btnBuscarInstittutoActionPerformed

    private void btnAdjuntarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarAnexosActionPerformed
        
    }//GEN-LAST:event_btnAdjuntarAnexosActionPerformed

    private void txaObservacionesDeudasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionesDeudasKeyReleased
        convertirAmayusculas(txaObservacionesDeudas);
        txaObservacionesDeudas.setText(controladorVariablesSesion.validarLetrasConEspacios(txaObservacionesDeudas.getText()));
    }//GEN-LAST:event_txaObservacionesDeudasKeyReleased

    private void txaListadoDocumentacionRespaldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaListadoDocumentacionRespaldoKeyReleased
        convertirAmayusculas(txaListadoDocumentacionRespaldo);
    }//GEN-LAST:event_txaListadoDocumentacionRespaldoKeyReleased

    private void txaObservacionesConsideracionesRecomendacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionesConsideracionesRecomendacionesKeyReleased
        convertirAmayusculas(txaObservacionesConsideracionesRecomendaciones);
    }//GEN-LAST:event_txaObservacionesConsideracionesRecomendacionesKeyReleased

    private void txaObservacionesPlazoConvenioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionesPlazoConvenioKeyReleased
        convertirAmayusculas(txaObservacionesPlazoConvenio);
    }//GEN-LAST:event_txaObservacionesPlazoConvenioKeyReleased

    private void txaProcesoDesignacionEstudiantesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaProcesoDesignacionEstudiantesKeyReleased
        convertirAmayusculas(txaProcesoDesignacionEstudiantes);
    }//GEN-LAST:event_txaProcesoDesignacionEstudiantesKeyReleased

    private void txaTipoCompensacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaTipoCompensacionKeyReleased
        convertirAmayusculas(txaObservacionesDeudas);
    }//GEN-LAST:event_txaTipoCompensacionKeyReleased

    private void txaCondicionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaCondicionesKeyReleased
        convertirAmayusculas(txaObservacionesDeudas);
    }//GEN-LAST:event_txaCondicionesKeyReleased

    private void txaObservacionesCondicionesEstudiantesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionesCondicionesEstudiantesKeyReleased
        convertirAmayusculas(txaObservacionesCondicionesEstudiantes);
    }//GEN-LAST:event_txaObservacionesCondicionesEstudiantesKeyReleased

    private void txtElaboradoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtElaboradoKeyReleased
        convertirAmayusculas(txtElaborado);
    }//GEN-LAST:event_txtElaboradoKeyReleased

    private void txtRevisadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRevisadoKeyReleased
        convertirAmayusculas(txtRevisado);
    }//GEN-LAST:event_txtRevisadoKeyReleased

    private void txtAprobadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAprobadoKeyReleased
        convertirAmayusculas(txtAprobado);
    }//GEN-LAST:event_txtAprobadoKeyReleased

    private void txtNombreERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreERActionPerformed

    private void btnBuscarRepresentanteLegalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRepresentanteLegalActionPerformed
        buscar("representante_legal","grid");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarRepresentanteLegal(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona"));
    }//GEN-LAST:event_btnBuscarRepresentanteLegalActionPerformed

    private void btnAgregarEmsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmsuActionPerformed
         criterioBusqueda[0] = idEmpresaSucursal;
        buscar("empresa_sucursal_sucursales", "grid_filtro");//abre una ventana de busqueda
        
        llenarSucursales(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "empresa_sucursales"));//consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos el tipo persona sirve para estudiante, tutor academicoy empresarial

    }//GEN-LAST:event_btnAgregarEmsuActionPerformed

    private void btnQuitarCarrera1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCarrera1ActionPerformed
        
        int fila = jtSucursales.getSelectedRow();
        modeloSucursales = (DefaultTableModel)jtSucursales.getModel();
        modeloSucursales.removeRow(fila);
    }//GEN-LAST:event_btnQuitarCarrera1ActionPerformed

    private void lblAsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAsignaturasMouseClicked
         
    }//GEN-LAST:event_lblAsignaturasMouseClicked

    private void btnAgregarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAsignaturaActionPerformed
        
        frmConsultas1 frm = new frmConsultas1(null, true);
        //JTable jt = frm.ge();
        DefaultTableModel modelo = new DefaultTableModel();
        
        
        try {
            
            for(int i = 0; i < idsCarrera.length; i++){
                PreparedStatement ps = Conexion.getConexion().prepareStatement("select * from siged_asignatura where carr_id =" + idsCarrera[i]);
                ResultSet rs = ps.executeQuery();
                
                Object[] datosTabla = new Object[rs.getMetaData().getColumnCount()];
                while (rs.next()) {

                    for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {
                        if (rs.getObject(j) != null) {
                            datosTabla[j - 1] = rs.getObject(j);

                        } else {
                            datosTabla[j - 1] = "";
                        }
                    }
                modelo.addRow(datosTabla);
            }
            }
            
            
            llenarNombresCarreras(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "carrera_viabilidad"));//consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos el tipo persona sirve para estudiante, tutor academicoy empresarial
        } catch (SQLException ex) {
            Logger.getLogger(frmViabilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        frm.setVisible(true); //hace visible la ventan de busqueda
        
    }//GEN-LAST:event_btnAgregarAsignaturaActionPerformed

    private void btnQuitarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuitarAsignaturaActionPerformed

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 
    
    private void buscar(String tabla, String tipo) {
        
        switch (tabla) {
            case "carrera_viabilidad":
                criterioBusqueda[0] = idInstituto;
                break;
            case "empresa_sucursal_sucursales":
                criterioBusqueda[0] = idEmpresa;
                break;
            default:
                criterioBusqueda[0] = "-1";
        }
        
        frmConsultas consulta = new frmConsultas(null, true);//instancia la el formulario con la ventana de busqueda
        consulta.consultar(tabla, tipo, criterioBusqueda);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true); //hace visible la ventan de busqueda

    }
    
    private void cargarTotalRegistros() {
//        int total = jtUsuario.getRowCount();
//        lblTotalRegistros.setText(String.valueOf(total));
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

        map.put("accion", accion);
        map.put("id", lblId.getText());
        map.put("idEmpresaSucursal", idEmpresaSucursal);
        map.put("numeroDeInforme", txtViabNumeroInforme.getText());
        map.put("fechaInforme", "djjjdksjk");
        map.put("asunto", txaAsunto.getText());
        map.put("constatacion", respuestaRadioButton = (jrbConductaInstitucionalSi.isSelected()) ? "1" : "0");
        map.put("deudaSRI", respuestaCheckBox = (boolean) jtDeudas.getValueAt(0, 1) == true ? "1" : "0");
        map.put("deudaIESS", respuestaRadioButton = (boolean) jtDeudas.getValueAt(2, 1) == true ? "1" : "0");
        map.put("deudaSERCOP", respuestaRadioButton = (boolean) jtDeudas.getValueAt(1, 1) == true ? "1" : "0");
        map.put("deudaSupIntendencia", respuestaRadioButton = (boolean) jtDeudas.getValueAt(3, 1) == true ? "1" : "0");
        map.put("observacionesDeudas", txaObservacionesDeudas.getText());
        map.put("recomendaciones", txaObservacionesConsideracionesRecomendaciones.getText());
        map.put("fechaPrimerAcercamiento", txtFechaDeAcercamientoInicial.getText());
        map.put("documentAcercamiento", txaListadoDocumentacionRespaldo.getText());
        map.put("observacionesInforme", "0");
        map.put("numeroEstudiantes", String.valueOf(jspNumEstudiantes.getValue()));
        map.put("numeroTutores", String.valueOf(jspNumTutores.getValue()));
        map.put("plazo", String.valueOf(jspPlazoVigenciaConvenio.getValue()));
        map.put("renuevaConvenio", respuestaRadioButton = (jrbRespuestaRenovarConvenioSi.isSelected()) ? "1" : "0");
        map.put("observacionesRenovacion", txaObservacionesPlazoConvenio.getText());
        map.put("administradorInstiituto", txtAdministradorConvInstituto.getText());
        map.put("administradorEmpresa", txtAdministradorConvER.getText());
        map.put("procesoDesignacion", txaProcesoDesignacionEstudiantes.getText());
        map.put("uniformes", respuestaRadioButton = (jrbUniformesSi.isSelected()) ? "1" : "0");
        map.put("equipoProteccion", respuestaRadioButton = (jrbEquipoDeProteccionSi.isSelected()) ? "1" : "0");
        map.put("normasSeguridad", respuestaRadioButton = (jrbNormasDeSeguridadSi.isSelected()) ? "1" : "0");
        map.put("observacionesCondiciones", txaObservacionesCondicionesEstudiantes.getText());
        map.put("compensacion", respuestaRadioButton = (jrbCompensacionSi.isSelected()) ? "1" : "0");
        map.put("compensacionTipo", txaCondiciones.getText());
        map.put("compensacionCondiciones", txaCondiciones.getText());
        map.put("elaborado", txtElaborado.getText());
        map.put("revisado", txtRevisado.getText());
        map.put("aprobado", txtAprobado.getText());
        map.put("estadoTramite", "0");
        map.put("idCarrera", idsCarrera[0]);

        ControladorViabilidad controladorViabilidad = new ControladorViabilidad();
        return controladorViabilidad.crearActualizar(map);

    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", txtAprobado.getText());

        ControladorViabilidad controladorViabilidad = new ControladorViabilidad();
        controladorViabilidad.eliminar(map);

    }
    
    private void formatearColumnas() {
        //Oculta la primera columna que corresponde al ID de la tabla
        jtNombreCarreras.getColumnModel().getColumn(0).setMaxWidth(0);
        jtNombreCarreras.getColumnModel().getColumn(0).setMinWidth(0);
        jtNombreCarreras.getColumnModel().getColumn(0).setPreferredWidth(0);
       
        
        //formatea la tabla que muestra la ubicación de la sucursal asociada a el actual informe de viabilidad
        for(int i = 1; i < jtSucursales.getColumnCount(); i++){
            
            jtSucursales.getColumnModel().getColumn(i).setMaxWidth(110);
            jtSucursales.getColumnModel().getColumn(i).setMinWidth(110);
            jtSucursales.getColumnModel().getColumn(i).setPreferredWidth(110);
            jtSucursales.getTableHeader().getColumnModel().getColumn(i).setMaxWidth(110);
            jtSucursales.getTableHeader().getColumnModel().getColumn(i).setMinWidth(110);
            jtSucursales.getTableHeader().getColumnModel().getColumn(i).setPreferredWidth(110);           
            
        }
        
        if(modeloSucursales != null){
            jtSucursales.getColumnModel().getColumn(0).setMaxWidth(140);
            jtSucursales.getColumnModel().getColumn(0).setMinWidth(140);
            jtSucursales.getColumnModel().getColumn(0).setPreferredWidth(140);
            jtSucursales.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(140);
            jtSucursales.getTableHeader().getColumnModel().getColumn(0).setMinWidth(140);
            jtSucursales.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(140); 
        }
        
        
        //formatea la tabla que muestra la ubicación de la empresa matriz asociada a el actual informe de viabilidad
        for(int i = 0; i < jtDireccionMatriz.getColumnCount(); i++){
            
            jtDireccionMatriz.getColumnModel().getColumn(i).setMaxWidth(110);
            jtDireccionMatriz.getColumnModel().getColumn(i).setMinWidth(110);
            jtDireccionMatriz.getColumnModel().getColumn(i).setPreferredWidth(110);
            jtDireccionMatriz.getTableHeader().getColumnModel().getColumn(i).setMaxWidth(110);
            jtDireccionMatriz.getTableHeader().getColumnModel().getColumn(i).setMinWidth(110);
            jtDireccionMatriz.getTableHeader().getColumnModel().getColumn(i).setPreferredWidth(110);           
            
        }
        
        jtDeudas.getColumnModel().getColumn(0).setMaxWidth(0);
        jtDeudas.getColumnModel().getColumn(0).setMinWidth(0);
        jtDeudas.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        jtDeudas.getColumnModel().getColumn(3).setMaxWidth(0);
        jtDeudas.getColumnModel().getColumn(3).setMinWidth(0);
        jtDeudas.getColumnModel().getColumn(3).setPreferredWidth(0);
        
        
    }
    
    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        //txaPara.setText("Mgs. Galo Nina Rada, Subsecretario de Formación Tecnica,\nTecnología, Artes, Música y Pedagogía");
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
    
    private void llenarDireccionMatriz(String[] direccion){
        
        String[] cabecera = {"NOMBRE","PAÍS", "PROVINCIA", "CIUDAD", "CANTÓN","SECTOR", "REFERENCIA", "CALLE PRINCIPAL", "INTERSECCIÓN", "NÚMERO" };
        
        modeloDireccionMatriz = new DefaultTableModel(cabecera, 0);
        
        modeloDireccionMatriz.addRow(direccion);
        
        jtDireccionMatriz.setModel(modeloDireccionMatriz);
        
        formatearColumnas();
    }
    
    private void llenarDireccionSucursal(String[] direccion){
        
        String[] cabecera = {"NOMBRE","PAÍS", "PROVINCIA", "CIUDAD", "CANTÓN","SECTOR", "REFERENCIA", "CALLE PRINCIPAL", "INTERSECCIÓN", "NÚMERO" };
        
        
        if(modeloDireccionSucursal == null)modeloDireccionSucursal = new DefaultTableModel(cabecera, 0);
        
        modeloDireccionSucursal.addRow(direccion);
       
        jtSucursales.setModel(modeloDireccionSucursal);
        
    }    
    
    private void llenarEmpresa(ArrayList<Object> datos) {
        
        int indicePais = 5;
        for(int i = 0 ; i < direccionEmpresa.length  - 1; i++) direccionEmpresa[i+1] =  (String) datos.get(i + indicePais);
        
        direccionEmpresa[0] = (String) datos.get(3);
        
        llenarDireccionMatriz(direccionEmpresa);
        
        idEmpresaSucursal = (String.valueOf(datos.get(0)));
        idEmpresa = (String.valueOf(datos.get(1)));
        nombreEmpresa = (String) datos.get(3);
        txtEmpresa.setText((String) datos.get(3));
        txtRUC.setText((String) datos.get(14));
        txtTipoDeEmpresa.setText((String) datos.get(16));
        txtActividadEconomica.setText((String) datos.get(17));
        txtFechaDeAcercamientoInicial.setText((String) datos.get(18));
        txtNombreER.setText((String) datos.get(3));

        txaAsunto.setText("Informe técnico-académico de viabilidad para la firma del\nConvenio de formación dual entre \"" + nombreEmpresa + "\" y el \"" + nombreInstituto + " \"");
        
        
    }
    
    private void llenarEncargadoSenescyt(ArrayList<Object> datos) {
        idPersona = (String.valueOf(datos.get(0)));
        txaPara.setText((String) datos.get(10) + " " + (String) datos.get(2) + " " + (String) datos.get(1) + ", " + (String) datos.get(14));
        txtNumYTipoDeContrato.setText((String) datos.get(14));
        

    }
    
    private void llenarGridEntidadesDeControl() {
        criterioBusqueda[0] = "'TIPO ENTIDAD'";
        jtDeudas.setModel(controladorGrid.getInstance().llenarGridPermisos("consulta_regulacion", "grid_filtro", criterioBusqueda));
        sorterEntidades = new TableRowSorter<>(jtDeudas.getModel());
        jtDeudas.setRowSorter(sorterEntidades);
        jtDeudas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarInstituto(ArrayList<Object> datos) {
        
        idInstituto = (String.valueOf(datos.get(0)));
        
        txtNombreInstituto.setText((String) datos.get(4));
        nombreInstituto = (String) datos.get(4);
        txtDocCreacionInstituto.setText((String) datos.get(11));
        txtInstituto.setText((String) datos.get(8));
        txaAsunto.setText("Informe técnico-académico de viabilidad para la firma del\nConvenio de formación dual entre \"" + nombreEmpresa + "\" y el \"" + nombreInstituto + " \"");

        DecimalFormat fmt = new DecimalFormat("000");
        Year año = Year.now();

        int numeroInforme = (Integer) datos.get(12)+1;
        txtViabNumeroInforme.setText("SENESCYT-SFTT-" + fmt.format(numeroInforme) + "-" + año);
        
        
        txaSolicitante.setText(((String) datos.get(15)).toUpperCase() + ", " + (String) datos.get(3) + " " + (String) datos.get(2) + ", RECTOR/A DE " + (String) datos.get(4));
        txtNumYTipoDeContrato.setText((String) datos.get(14));
        txtNombreRector.setText((String) datos.get(3) + " " + (String) datos.get(2));

    }

    private void llenarNombresCarreras(ArrayList<Object> datos) {
        
        modeloCarreras = (DefaultTableModel) jtNombreCarreras.getModel();
        
        String[] prueba = new String[datos.size()];
        
        for(int i = 0; i < datos.size(); i++) prueba[i] = String.valueOf(datos.get(i));
                
        modeloCarreras.addRow(prueba);
        jtNombreCarreras.setModel(modeloCarreras);
        
        idsCarrera = new String[jtNombreCarreras.getRowCount()];
        
        for(int i = 0; i < jtNombreCarreras.getRowCount(); i++) idsCarrera[i] = String.valueOf(modeloCarreras.getValueAt(i, 0)); 
        
       formatearColumnas();
        
        
    
    }

    private void llenarRepresentanteLegal(ArrayList<Object> datos) {
        //idPersona = (String.valueOf(datos.get(0)));
        
        txtNombreRepresentanteLegal.setText((String) datos.get(2) + " " + (String) datos.get(1));
        
        lblInfoRepresentanteLegal.setText("<html> <b>Nombre:</b> "+ (String) datos.get(2) + " " + (String) datos.get(1)+ " <br>"
                + "                         <b>Correo:</b> "+ (String) datos.get(7) + " <br>"
                + "                         <b>Teléfono:</b> "+ (String) datos.get(5) + " <br>"
                + "                         <b>Celular:</b> "+ (String) datos.get(6) + " <br>"
                + "                         </html>");

    }
    
    private void llenarSucursales(ArrayList<Object> datos) {
        
        for(int i = 0 ; i < direccionSucursal.length  - 1; i++) direccionSucursal[i+1] =  (String) datos.get(i + 6);
        
        direccionSucursal[0] = (String) datos.get(4);
        
        llenarDireccionSucursal(direccionSucursal);
        
        idEmpresaSucursal = String.valueOf(datos.get(0));        
        
        formatearColumnas();
    
    }
// </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjuntarAnexos;
    private javax.swing.JButton btnAgregarAsignatura;
    private javax.swing.JButton btnAgregarCarrera;
    private javax.swing.JButton btnAgregarEmsu;
    private javax.swing.JButton btnBuscarEmpresa;
    private javax.swing.JButton btnBuscarEncargadoSenescyt;
    private javax.swing.JButton btnBuscarInstittuto;
    private javax.swing.JButton btnBuscarRepresentanteLegal;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGroupConductaInstitucional;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarAsignatura;
    private javax.swing.JButton btnQuitarCarrera;
    private javax.swing.JButton btnQuitarCarrera1;
    private javax.swing.ButtonGroup buttonGroupCompensacion;
    private javax.swing.ButtonGroup buttonGroupEquipoDeProteccion;
    private javax.swing.ButtonGroup buttonGroupNormasDeSeguridad;
    private javax.swing.ButtonGroup buttonGroupRenovacionConvenio;
    private javax.swing.ButtonGroup buttonGroupUniformesEstudiantes;
    public static com.toedter.calendar.JDateChooser dtFechaInforme;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpConclusiones;
    private javax.swing.JPanel jpContenidoDelInforme;
    public static javax.swing.JPanel jp_Antecedentes;
    private javax.swing.JPanel jp_DatosGenerales;
    public static javax.swing.JTabbedPane jp_Viabilidad;
    private javax.swing.JRadioButton jrbCompensacionNo;
    private javax.swing.JRadioButton jrbCompensacionSi;
    private javax.swing.JRadioButton jrbConductaInstitucionalNo;
    private javax.swing.JRadioButton jrbConductaInstitucionalSi;
    private javax.swing.JRadioButton jrbEquipoDeProteccionNo;
    private javax.swing.JRadioButton jrbEquipoDeProteccionSi;
    private javax.swing.JRadioButton jrbNormasDeSeguridadNo;
    private javax.swing.JRadioButton jrbNormasDeSeguridadSi;
    private javax.swing.JRadioButton jrbRespuestaRenovarConvenioNo;
    private javax.swing.JRadioButton jrbRespuestaRenovarConvenioSi;
    private javax.swing.JRadioButton jrbUniformeNo;
    private javax.swing.JRadioButton jrbUniformesSi;
    private javax.swing.JSpinner jspNumEstudiantes;
    private javax.swing.JSpinner jspNumTutores;
    private javax.swing.JSpinner jspPlazoVigenciaConvenio;
    private javax.swing.JTable jtAsignaturas;
    private javax.swing.JTable jtDeudas;
    private javax.swing.JTable jtDireccionMatriz;
    private javax.swing.JTable jtEstudiantesEscenarioPedagogico;
    private javax.swing.JTable jtNombreCarreras;
    private javax.swing.JTable jtSucursales;
    private javax.swing.JLabel lbAdministradorConvER;
    private javax.swing.JLabel lbAdministradorConvInstituto;
    private javax.swing.JLabel lbObservacionesCondicionesEstudiantes;
    private javax.swing.JLabel lblActividadEconomica;
    private javax.swing.JLabel lblAprobado;
    private javax.swing.JLabel lblAsignaturas;
    private javax.swing.JLabel lblAsunto;
    private javax.swing.JLabel lblCompensacionEstudiante2;
    private javax.swing.JLabel lblCompensacionEstudiantes;
    private javax.swing.JLabel lblCondiciones;
    private javax.swing.JLabel lblConsideracionesRecomendaciones;
    private javax.swing.JLabel lblDireccionMatriz;
    private javax.swing.JLabel lblDireccionSucursal;
    private javax.swing.JLabel lblDireccionSucursal2;
    private javax.swing.JLabel lblDisposicionRenovarConvenio;
    private javax.swing.JLabel lblDocCreacionInstituto;
    private javax.swing.JLabel lblDotacionUniformes;
    private javax.swing.JLabel lblElaborado;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEmpresa1;
    private javax.swing.JLabel lblEquipoDeProteccion;
    private javax.swing.JLabel lblEstudiantesEscenarioPedagogico;
    private javax.swing.JLabel lblFechaDeAcercamientoInicial;
    private javax.swing.JLabel lblFechaInforme;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblInfoRepresentanteLegal;
    private javax.swing.JLabel lblListadoDocumentacionRespaldo;
    private javax.swing.JLabel lblNombreCarreras;
    private javax.swing.JLabel lblNombreInstituto;
    private javax.swing.JLabel lblNombreRector;
    private javax.swing.JLabel lblNombreRepresentanteLegal;
    private javax.swing.JLabel lblNormasDeSeguridad1;
    private javax.swing.JLabel lblNumResolucion;
    private javax.swing.JLabel lblNumTutores;
    private javax.swing.JLabel lblNumYTipoDeContrato;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblObservacionesPlazoConvenio;
    private javax.swing.JLabel lblPara;
    private javax.swing.JLabel lblPlazoVigenciaConvenio;
    private javax.swing.JLabel lblProcesoDesignacionEstudiantes1;
    private javax.swing.JLabel lblRUC;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRevisado;
    private javax.swing.JLabel lblSolicitante;
    private javax.swing.JLabel lblTipoCompensacion;
    private javax.swing.JLabel lblTipoDeEmpresa;
    private javax.swing.JLabel lblTipoDeEmpresa1;
    private javax.swing.JTextArea txaAsunto;
    private javax.swing.JTextArea txaCondiciones;
    private javax.swing.JTextArea txaListadoDocumentacionRespaldo;
    private javax.swing.JTextArea txaObservacionesCondicionesEstudiantes;
    private javax.swing.JTextArea txaObservacionesConsideracionesRecomendaciones;
    private javax.swing.JTextArea txaObservacionesDeudas;
    private javax.swing.JTextArea txaObservacionesPlazoConvenio;
    private javax.swing.JTextArea txaPara;
    private javax.swing.JTextArea txaProcesoDesignacionEstudiantes;
    private javax.swing.JTextArea txaSolicitante;
    private javax.swing.JTextArea txaTipoCompensacion;
    private javax.swing.JTextArea txtActividadEconomica;
    private javax.swing.JTextField txtAdministradorConvER;
    private javax.swing.JTextField txtAdministradorConvInstituto;
    private javax.swing.JTextField txtAprobado;
    public static javax.swing.JTextField txtDocCreacionInstituto;
    private javax.swing.JTextField txtElaborado;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtFechaDeAcercamientoInicial;
    private javax.swing.JTextField txtInstituto;
    private javax.swing.JTextField txtNombreER;
    public static javax.swing.JTextField txtNombreInstituto;
    public static javax.swing.JTextField txtNombreRector;
    private javax.swing.JTextField txtNombreRepresentanteLegal;
    public static javax.swing.JTextField txtNumYTipoDeContrato;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtRevisado;
    private javax.swing.JTextField txtTipoDeEmpresa;
    private javax.swing.JFormattedTextField txtViabNumeroInforme;
    // End of variables declaration//GEN-END:variables
// </editor-fold>  
}
