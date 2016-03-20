package vista;

import controlador.ControladorUsuario;
import controlador.controladorConsulta;
import controlador.controladorExcel;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmUsuario extends javax.swing.JInternalFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    private ImageIcon icon;
    private String accion;
    private String idPersona;
    private String claveDefecto;
    private String correo;
    private String bandera;
    ArrayList<String> codigoRol = new ArrayList<>();
    String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;
// </editor-fold > 

    public frmUsuario() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[2];
        idPersona = "-1";
        claveDefecto = "-1";
        bandera = "";
        llenarGrid();
        llenarFiltro();
        llenarComboRoles();
        cargarTotalRegistros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbUsuarios = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jpRegistroUsuario = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtRepetirClave = new javax.swing.JPasswordField();
        cmbRol = new javax.swing.JComboBox<>();
        lblPersona = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblClave1 = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        lblClave2 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        txtPersona = new javax.swing.JTextField();
        btnPersona = new javax.swing.JButton();
        lblRegistros1 = new javax.swing.JLabel();
        lblEstadoProceso = new javax.swing.JLabel();
        jpBusquedaUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuario = new javax.swing.JTable();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistros = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        rbHabilitados = new javax.swing.JRadioButton();
        rbBloqueados = new javax.swing.JRadioButton();
        rbRecuperarClave = new javax.swing.JRadioButton();
        btnNuevo1 = new javax.swing.JButton();
        lblBusqueda = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setTitle("USUARIO");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_usuarios_32.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(945, 535));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(945, 575));
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

        txtNombreUsuario.setPreferredSize(new java.awt.Dimension(225, 25));
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        txtRepetirClave.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroUsuario.add(txtRepetirClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        cmbRol.setBackground(new java.awt.Color(204, 204, 255));
        cmbRol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbRol.setPreferredSize(new java.awt.Dimension(150, 25));
        jpRegistroUsuario.add(cmbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 220, -1));

        lblPersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona.setText("Persona:");
        lblPersona.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblRol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol.setText("Rol:");
        lblRol.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lblClave1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave1.setText("Repetir Contraseña:");
        lblClave1.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lblClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave.setText("Usuario:");
        lblClave.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblClave2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave2.setText("Contraseña:");
        lblClave2.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtClave.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroUsuario.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        txtPersona.setEditable(false);
        txtPersona.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroUsuario.add(txtPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        btnPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnPersona.setToolTipText("Buscar");
        btnPersona.setBorder(null);
        btnPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPersona.setPreferredSize(new java.awt.Dimension(40, 40));
        btnPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonaActionPerformed(evt);
            }
        });
        jpRegistroUsuario.add(btnPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        lblRegistros1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros1.setText("Estado:");
        lblRegistros1.setPreferredSize(new java.awt.Dimension(60, 20));
        jpRegistroUsuario.add(lblRegistros1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 50, -1));

        lblEstadoProceso.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblEstadoProceso.setForeground(new java.awt.Color(255, 0, 0));
        lblEstadoProceso.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblEstadoProceso.setPreferredSize(new java.awt.Dimension(200, 20));
        jpRegistroUsuario.add(lblEstadoProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 370, -1));

        jPanel1.add(jpRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        jpBusquedaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaUsuario.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtUsuario.setGridColor(new java.awt.Color(0, 102, 153));
        jtUsuario.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtUsuario.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUsuario);

        jpBusquedaUsuario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 430, 380));

        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        jpBusquedaUsuario.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 100, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaUsuario.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 200, -1));

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

        rbUsuarios.add(rbHabilitados);
        rbHabilitados.setSelected(true);
        rbHabilitados.setText("Habilitados");
        rbHabilitados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbHabilitados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHabilitadosActionPerformed(evt);
            }
        });
        jpBusquedaUsuario.add(rbHabilitados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        rbUsuarios.add(rbBloqueados);
        rbBloqueados.setText("Bloqueados");
        rbBloqueados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbBloqueados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBloqueadosActionPerformed(evt);
            }
        });
        jpBusquedaUsuario.add(rbBloqueados, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        rbUsuarios.add(rbRecuperarClave);
        rbRecuperarClave.setText("Recuperar Contraseña");
        rbRecuperarClave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbRecuperarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRecuperarClaveActionPerformed(evt);
            }
        });
        jpBusquedaUsuario.add(rbRecuperarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

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
        jpBusquedaUsuario.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 40, 40));

        jPanel1.add(jpBusquedaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BUSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(185, 50));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos"> 
    private void jtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuarioMouseClicked
        int fila = jtUsuario.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        bandera = "";
        if (fila != -1) {
            btnCrearActualizar.setEnabled(true);
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarUsuario(consultarRegistroIndividual(jtUsuario.getValueAt(fila, 0).toString(), "usuario"));
        }
    }//GEN-LAST:event_jtUsuarioMouseClicked

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
            enviarNotificacion();
            limpiarCajasTexto(jpRegistroUsuario);
            llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
        lblEstadoProceso.setText("");

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
        buscar("persona");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarPersona(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona"));
    }//GEN-LAST:event_btnPersonaActionPerformed

    private void txtNombreUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyReleased
        convertirAminusculas(txtNombreUsuario);
    }//GEN-LAST:event_txtNombreUsuarioKeyReleased

    private void rbBloqueadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBloqueadosActionPerformed
        bandera = "BU";
        llenarGridUsuariosBloqueados();
        desahbilitar();
    }//GEN-LAST:event_rbBloqueadosActionPerformed

    private void rbHabilitadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHabilitadosActionPerformed
        bandera = "";
        habilitar();
        llenarGrid();

    }//GEN-LAST:event_rbHabilitadosActionPerformed

    private void rbRecuperarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRecuperarClaveActionPerformed
        bandera = "RC";
        llenarGridUsuariosRecuperarClave();
        desahbilitar();
    }//GEN-LAST:event_rbRecuperarClaveActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel(rutaArchivo, jtUsuario.getModel());
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void habilitar() {
        icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_crear_actualizar_40.png"));
        btnCrearActualizar.setIcon(icon);
        btnCrearActualizar.setToolTipText("Guardar");
        btnPersona.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnCrearActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtNombreUsuario.setEditable(true);
        txtClave.setEnabled(true);
        txtRepetirClave.setEnabled(true);
        cmbRol.setEnabled(true);
    }

    private void desahbilitar() {
        icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_desbloquear_40.png"));
        btnCrearActualizar.setIcon(icon);
        btnCrearActualizar.setToolTipText("Desbloquear Usuario");
        btnNuevo.setEnabled(false);
        btnCrearActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnPersona.setEnabled(false);
        txtNombreUsuario.setEditable(false);
        txtClave.setEnabled(false);
        txtRepetirClave.setEnabled(false);
        cmbRol.setEnabled(false);
    }

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtUsuario.getRowCount();
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

        if (txtClave.getText().length() == 0) {
            txtClave.setText(claveDefecto);
            txtRepetirClave.setText(claveDefecto);
            JOptionPane.showMessageDialog(rootPane, "Clave por defecto número de identificación", "Clave", 1);
        }

        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("accion", accion);
        map.put("id", lblId.getText());
        map.put("idPersona", idPersona);
        map.put("idRol", codigoRol.get(cmbRol.getSelectedIndex()));
        map.put("nombreUsuario", txtNombreUsuario.getText());
        map.put("clave", txtClave.getText());
        map.put("repetirClave", txtRepetirClave.getText());

        //instacia el controlador
        ControladorUsuario usuario = new ControladorUsuario();
        lblEstadoProceso.setText("Enviando correo electrónico...");
        //llama al metodo para crear o actualizar segun sea la accion
        return usuario.crearActualizar(map);

    }

    private void enviarNotificacion() {
        switch (bandera) {
            case "BU":
                enviarDatosUsuario("SIGED - Desbloqueo de Usuario");
                break;
            case "RC":
                enviarDatosUsuario("SIGED - Restauración de Contraseña");
                break;
            default:
                if (accion.equals("crear")) {
                    enviarDatosUsuario("SIGED - Creación de Usuario SIGED");
                } else {
                    enviarDatosUsuario("SIGED - Modificación de Usuario SIGED");
                }

        }

    }

    private void enviarDatosUsuario(String asunto) {
        String mensaje = "INFORMACIÓN DE USUARIO\n"
                + "\nUsuario: " + txtNombreUsuario.getText()
                + "\nContraseña: " + txtClave.getText()
                + "\nRol: " + cmbRol.getSelectedItem()
                + "\n\nGuarde la información en un lugar seguro!!!";
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        controladorUsuario.enviarDatosUsuario(asunto, mensaje, correo);
    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", lblId.getText());
        ControladorUsuario usuario = new ControladorUsuario();

        usuario.eliminar(map);

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
        jtUsuario.getColumnModel().getColumn(0).setMaxWidth(0);
        jtUsuario.getColumnModel().getColumn(0).setMinWidth(0);
        jtUsuario.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        cmbRol.setSelectedIndex(0);
        rbHabilitados.setSelected(true);
        habilitar();
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

    private void llenarComboRoles() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "rol";//nombre de la tabla
        criterioBusqueda[1] = "tabla";//tipo de consulta
        cmbRol.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoRol = consulta.getCodigoCombo();
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid() {
        jtUsuario.setModel(controladorGrid.getInstance().llenarGrid("usuario", "grid", null, true));
        sorter = new TableRowSorter<>(jtUsuario.getModel());
        jtUsuario.setRowSorter(sorter);
        jtUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarGridUsuariosBloqueados() {
        jtUsuario.setModel(controladorGrid.getInstance().llenarGrid("usuario_bloqueado", "grid", null, true));
        sorter = new TableRowSorter<>(jtUsuario.getModel());
        jtUsuario.setRowSorter(sorter);
        jtUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarGridUsuariosRecuperarClave() {
        jtUsuario.setModel(controladorGrid.getInstance().llenarGrid("usuario_recuperar_clave", "grid", null, true));
        sorter = new TableRowSorter<>(jtUsuario.getModel());
        jtUsuario.setRowSorter(sorter);
        jtUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarPersona(ArrayList<Object> datos) {
        idPersona = (String.valueOf(datos.get(0)));
        txtPersona.setText((String) datos.get(2) + " " + (String) datos.get(1));
        claveDefecto = (String) datos.get(4);
        correo = (String) datos.get(7);

    }

    private void llenarUsuario(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        idPersona = (String.valueOf(datos.get(1)));
        txtPersona.setText((String) datos.get(2));
        cmbRol.setSelectedItem((String) datos.get(3));
        txtNombreUsuario.setText((String) datos.get(4));
        claveDefecto = (String) datos.get(6);
        correo = (String) datos.get(7);
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
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpBusquedaUsuario;
    private javax.swing.JPanel jpRegistroUsuario;
    private javax.swing.JTable jtUsuario;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblClave1;
    private javax.swing.JLabel lblClave2;
    private javax.swing.JLabel lblEstadoProceso;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblRegistros1;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JRadioButton rbBloqueados;
    private javax.swing.JRadioButton rbHabilitados;
    private javax.swing.JRadioButton rbRecuperarClave;
    private javax.swing.ButtonGroup rbUsuarios;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPersona;
    private javax.swing.JPasswordField txtRepetirClave;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
