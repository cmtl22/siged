package vista;

import com.toedter.calendar.JDateChooser;
import controlador.ControladorPersona;
import controlador.controladorConsulta;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmPersona extends javax.swing.JInternalFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    private String accion;
    private String idCarrera;
    private String tipoPersona;
    private String idPersonaCarrera;
    ArrayList<String> codigoTipoPersona = new ArrayList<>();
    ArrayList<String> codigoTipoDocumento = new ArrayList<>();
    String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;

    private String tipo;
// </editor-fold > 

    public frmPersona(String tipo) {

        initComponents();
        tipoPersona = tipo;
        init();

    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[2];
        idCarrera = "-1";
        idPersonaCarrera = "-1";
        llenarGrid();
        llenarFiltro();
        llenarComboTipoIdentificacion();
        llenarComboTipoPersona();
        cargarTotalRegistros();
        switch (tipoPersona) {
            case "estudiante":
                this.setTitle("ESTUDIANTE");
                tipo = "ES";
                break;
            case "tutor_academico":
                this.setTitle("TUTOR ACDÉMICO");
                tipo = "TA";
                break;
            case "tutor_empresarial":
                this.setTitle("TUTOR EMPRESARIAL");
                tipo = "TE";
                break;
            default:
                this.setTitle("PERSONA");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPersona12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpRegistroUsuario = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtNombrePersona = new javax.swing.JTextField();
        cmbTipoIdentificacion = new javax.swing.JComboBox<>();
        lblPersona = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        txtCarrera = new javax.swing.JTextField();
        btnBuscarCarrera = new javax.swing.JButton();
        lblClave3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblClave4 = new javax.swing.JLabel();
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
        lblPersona1 = new javax.swing.JLabel();
        lblPersona2 = new javax.swing.JLabel();
        lblPersona3 = new javax.swing.JLabel();
        lblPersona4 = new javax.swing.JLabel();
        lblPersona5 = new javax.swing.JLabel();
        lblPersona6 = new javax.swing.JLabel();
        lblPersona7 = new javax.swing.JLabel();
        lblPersona8 = new javax.swing.JLabel();
        lblPersona9 = new javax.swing.JLabel();
        lblPersona10 = new javax.swing.JLabel();
        lblPersona11 = new javax.swing.JLabel();
        lblPersona13 = new javax.swing.JLabel();
        jpBusquedaUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPersona = new javax.swing.JTable();
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

        lblPersona12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona12.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona12.setText("*");
        lblPersona12.setPreferredSize(new java.awt.Dimension(120, 25));

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("PERSONA");
        setPreferredSize(new java.awt.Dimension(945, 535));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRegistroUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroUsuario.setPreferredSize(new java.awt.Dimension(450, 510));
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
        jpRegistroUsuario.add(txtNombrePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 230, -1));

        cmbTipoIdentificacion.setBackground(new java.awt.Color(255, 255, 204));
        cmbTipoIdentificacion.setToolTipText("");
        cmbTipoIdentificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbTipoIdentificacion.setPreferredSize(new java.awt.Dimension(150, 25));
        jpRegistroUsuario.add(cmbTipoIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 230, -1));

        lblPersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona.setText("*");
        lblPersona.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 10, -1));

        lblRol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol.setText("Tipo de Identificación:");
        lblRol.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 130, -1));

        lblClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave.setText("Nombres:");
        lblClave.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 20));

        txtCarrera.setEditable(false);
        txtCarrera.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroUsuario.add(txtCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        btnBuscarCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnBuscarCarrera.setToolTipText("BUSCAR");
        btnBuscarCarrera.setBorder(null);
        btnBuscarCarrera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCarreraActionPerformed(evt);
            }
        });
        jpRegistroUsuario.add(btnBuscarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        lblClave3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave3.setText("Apellidos:");
        lblClave3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 130, 20));

        txtApellido.setPreferredSize(new java.awt.Dimension(225, 25));
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 230, -1));

        lblClave4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave4.setText("Número Identificación:");
        lblClave4.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 130, 20));

        txtFormacionAcademica.setPreferredSize(new java.awt.Dimension(225, 25));
        txtFormacionAcademica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFormacionAcademicaKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtFormacionAcademica, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 230, -1));

        lblClave5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave5.setText("Teléfono Fijo:");
        lblClave5.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 80, 20));

        txtTelefonoFijo.setPreferredSize(new java.awt.Dimension(225, 25));
        txtTelefonoFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoFijoKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtTelefonoFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 100, -1));

        lblClave6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave6.setText("Teléfono Móvil:");
        lblClave6.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 90, 20));

        txtTelefonoMovil.setPreferredSize(new java.awt.Dimension(225, 25));
        txtTelefonoMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoMovilKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtTelefonoMovil, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 100, -1));

        lblClave7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave7.setText("Correo Electrónico:");
        lblClave7.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, 20));

        txtEmail.setPreferredSize(new java.awt.Dimension(225, 25));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 230, -1));

        lblClave8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave8.setText("Fecha Nacimiento:");
        lblClave8.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 130, 20));

        lblRol1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol1.setText("Dirección:");
        lblRol1.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 130, -1));

        lblRol2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol2.setText("Formación Académica:");
        lblRol2.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 130, -1));

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

        jpRegistroUsuario.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 230, -1));

        lblRol3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol3.setText("Información Adicional:");
        lblRol3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 130, -1));

        txtNumeroIdentificacion.setPreferredSize(new java.awt.Dimension(225, 25));
        txtNumeroIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroIdentificacionKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtNumeroIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 230, -1));

        txaDireccion.setColumns(1);
        txaDireccion.setLineWrap(true);
        txaDireccion.setRows(2);
        txaDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDireccionKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txaDireccion);

        jpRegistroUsuario.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 230, -1));

        dtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        jpRegistroUsuario.add(dtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 230, 25));
        dtFechaNacimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Date date3 = new Date();
        dtFechaNacimiento.setDate(date3);

        lblPersona1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona1.setText("Carrera:");
        lblPersona1.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, -1));

        lblPersona2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona2.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona2.setText("*");
        lblPersona2.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 10, -1));

        lblPersona3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona3.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona3.setText("*");
        lblPersona3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 10, -1));

        lblPersona4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona4.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona4.setText("*");
        lblPersona4.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 10, -1));

        lblPersona5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona5.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona5.setText("*");
        lblPersona5.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 10, -1));

        lblPersona6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona6.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona6.setText("*");
        lblPersona6.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 10, -1));

        lblPersona7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona7.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona7.setText("*");
        lblPersona7.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 10, -1));

        lblPersona8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona8.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona8.setText("*");
        lblPersona8.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 10, -1));

        lblPersona9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona9.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona9.setText("*");
        lblPersona9.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 10, -1));

        lblPersona10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona10.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona10.setText("*");
        lblPersona10.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 10, -1));

        lblPersona11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona11.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona11.setText("*");
        lblPersona11.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 10, -1));

        lblPersona13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona13.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona13.setText("*");
        lblPersona13.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 10, -1));

        jPanel1.add(jpRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 55, -1, -1));

        jpBusquedaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaUsuario.setPreferredSize(new java.awt.Dimension(450, 510));
        jpBusquedaUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(430, 420));

        jtPersona.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtPersona.setGridColor(new java.awt.Color(0, 102, 153));
        jtPersona.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtPersona.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPersonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPersona);

        jpBusquedaUsuario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        cmbFiltro.setBackground(new java.awt.Color(255, 255, 204));
        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        jpBusquedaUsuario.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 120, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaUsuario.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 260, -1));

        lblRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros.setText("Registros:");
        lblRegistros.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaUsuario.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaUsuario.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, 20));

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(32, 25));
        jpBusquedaUsuario.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jpBusquedaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 190, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos"> 
    private void jtPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPersonaMouseClicked
        int fila = jtPersona.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarPersona(consultarRegistroIndividual(jtPersona.getValueAt(fila, 0).toString(), "persona"));
        }
    }//GEN-LAST:event_jtPersonaMouseClicked

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroUsuario);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroUsuario);
            llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        accion = "crear";
        eliminar();//elimina el registro seleccionado
        llenarGrid();//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
        limpiarCajasTexto(jpRegistroUsuario);//limpia las cajas de texto
        cargarTotalRegistros();//carga el total de registros


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCarreraActionPerformed
        buscar("carrera");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
           if (!controladorVariablesSesion.getInstance().getDatosTemporalesConsulta().equals("")) 
        llenarCarrera(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "carrera"));
    }//GEN-LAST:event_btnBuscarCarreraActionPerformed

    private void txtNombrePersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePersonaKeyReleased
        txtNombrePersona.setText(controladorVariablesSesion.validarLetrasConEspacios(txtNombrePersona.getText()));
        convertirAmayusculas(txtNombrePersona);
    }//GEN-LAST:event_txtNombrePersonaKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        convertirAmayusculas(txtApellido);
        txtApellido.setText(controladorVariablesSesion.validarLetrasSinEspacios(txtApellido.getText()));
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtFormacionAcademicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormacionAcademicaKeyReleased
        convertirAmayusculas(txtFormacionAcademica);
    }//GEN-LAST:event_txtFormacionAcademicaKeyReleased

    private void txtTelefonoFijoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoFijoKeyReleased
        txtTelefonoFijo.setText(controladorVariablesSesion.validarNumerosSinEspacios(txtTelefonoFijo.getText()));
    }//GEN-LAST:event_txtTelefonoFijoKeyReleased

    private void txtTelefonoMovilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoMovilKeyReleased
        txtTelefonoMovil.setText(controladorVariablesSesion.validarNumerosConEspacios(txtTelefonoMovil.getText()));
    }//GEN-LAST:event_txtTelefonoMovilKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        convertirAminusculas(txtEmail);
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtNumeroIdentificacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroIdentificacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroIdentificacionKeyReleased

    private void txaDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDireccionKeyReleased
        convertirAmayusculas(txaDireccion);
    }//GEN-LAST:event_txaDireccionKeyReleased

    private void jScrollPane2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane2KeyReleased

    }//GEN-LAST:event_jScrollPane2KeyReleased

    private void txaInformacionAdicionalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaInformacionAdicionalKeyReleased
        convertirAmayusculas(txaInformacionAdicional);
    }//GEN-LAST:event_txaInformacionAdicionalKeyReleased

    private void txtNombrePersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePersonaActionPerformed
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtPersona.getRowCount();
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
        map.put("tipoIdentificacion", codigoTipoDocumento.get(cmbTipoIdentificacion.getSelectedIndex()));
        map.put("idCarrera", idCarrera);
        map.put("numeroIdentificacion", txtNumeroIdentificacion.getText());
        map.put("nombres", txtNombrePersona.getText());
        map.put("apellidos", txtApellido.getText());
        map.put("fechaNacimiento", dateToString(dtFechaNacimiento));
        map.put("direccion", txaDireccion.getText());
        map.put("telefonoFijo", txtTelefonoFijo.getText());
        map.put("telefonoCelular", txtTelefonoMovil.getText());
        map.put("correo", txtEmail.getText());
        map.put("tipo", tipo);
        map.put("formacionAcademica", txtFormacionAcademica.getText());
        map.put("informacionAdicional", txaInformacionAdicional.getText());

        //instacia el controlador
        ControladorPersona persona = new ControladorPersona();
        //llama al metodo para crear o actualizar segun sea la accion
        return persona.crearActualizar(map);

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
        ControladorPersona persona = new ControladorPersona();
        persona.eliminar(map);
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
        jtPersona.getColumnModel().getColumn(0).setMaxWidth(0);
        jtPersona.getColumnModel().getColumn(0).setMinWidth(0);
        jtPersona.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        cmbTipoIdentificacion.setSelectedIndex(0);
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

    private void llenarCarrera(ArrayList<Object> datos) {
        idCarrera = (String.valueOf(datos.get(0)));
        txtCarrera.setText((String) datos.get(3));

    }

    private void llenarComboTipoIdentificacion() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "TID";//nombre de la tabla
        criterioBusqueda[1] = "enumeracion";//tipo de consulta
        cmbTipoIdentificacion.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoTipoDocumento = consulta.getCodigoCombo();
    }

    private void llenarComboTipoPersona() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "TP";//nombre de la tabla
        criterioBusqueda[1] = "enumeracion";//tipo de consulta
        //cmbTipoPersona.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoTipoPersona = consulta.getCodigoCombo();
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid() {
        jtPersona.setModel(controladorGrid.getInstance().llenarGrid(tipoPersona, "grid", null, true));
        sorter = new TableRowSorter<>(jtPersona.getModel());
        jtPersona.setRowSorter(sorter);
        jtPersona.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarPersona(ArrayList<Object> datos) {

        lblId.setText(String.valueOf(datos.get(0)));
        txtNombrePersona.setText((String) datos.get(1));
        txtApellido.setText((String) datos.get(2));
        cmbTipoIdentificacion.setSelectedItem((String) datos.get(3));
        txtNumeroIdentificacion.setText((String) datos.get(4));
        txtTelefonoFijo.setText((String) datos.get(5));
        txtTelefonoMovil.setText((String) datos.get(6));
        txtEmail.setText((String) datos.get(7));
        dtFechaNacimiento.setDate(stringToJDateChooser((String) datos.get(8)));
        txaDireccion.setText((String) datos.get(9));
        txtFormacionAcademica.setText((String) datos.get(10));
        txtCarrera.setText((String) datos.get(11));
        //cmbTipoPersona.setSelectedItem((String) datos.get(12));
        idCarrera = (String.valueOf(datos.get(13)));
        txaInformacionAdicional.setText((String) datos.get(14));

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
    private javax.swing.JButton btnBuscarCarrera;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JComboBox<String> cmbTipoIdentificacion;
    private com.toedter.calendar.JDateChooser dtFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpBusquedaUsuario;
    private javax.swing.JPanel jpRegistroUsuario;
    private javax.swing.JTable jtPersona;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblClave3;
    private javax.swing.JLabel lblClave4;
    private javax.swing.JLabel lblClave5;
    private javax.swing.JLabel lblClave6;
    private javax.swing.JLabel lblClave7;
    private javax.swing.JLabel lblClave8;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblPersona1;
    private javax.swing.JLabel lblPersona10;
    private javax.swing.JLabel lblPersona11;
    private javax.swing.JLabel lblPersona12;
    private javax.swing.JLabel lblPersona13;
    private javax.swing.JLabel lblPersona2;
    private javax.swing.JLabel lblPersona3;
    private javax.swing.JLabel lblPersona4;
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
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaDireccion;
    private javax.swing.JTextArea txaInformacionAdicional;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCarrera;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFormacionAcademica;
    private javax.swing.JTextField txtNombrePersona;
    private javax.swing.JTextField txtNumeroIdentificacion;
    private javax.swing.JTextField txtTelefonoFijo;
    private javax.swing.JTextField txtTelefonoMovil;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
