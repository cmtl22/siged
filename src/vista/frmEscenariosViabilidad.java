package vista;

import controlador.ControladorEscenarioViabilidad;
import controlador.ControladorUsuario;
import controlador.controladorConsulta;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmEscenariosViabilidad extends javax.swing.JInternalFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    private String accion;
    private String idViabilidad;
    ArrayList<String> codigoRol = new ArrayList<>();
    String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;
// </editor-fold > 

    public frmEscenariosViabilidad() {
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpRegistroUsuario = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblInformeViabilidad = new javax.swing.JLabel();
        lblEquipamiento = new javax.swing.JLabel();
        lblActividades = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblNumeroEstudiantes = new javax.swing.JLabel();
        txtViabilidad = new javax.swing.JTextField();
        btnViabilidad = new javax.swing.JButton();
        lblObservaciones = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaActividades1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaEquipamiento1 = new javax.swing.JTextArea();
        txtTipo1 = new javax.swing.JTextField();
        lblPersona6 = new javax.swing.JLabel();
        lblPersona7 = new javax.swing.JLabel();
        lblPersona8 = new javax.swing.JLabel();
        lblPersona9 = new javax.swing.JLabel();
        lblPersona10 = new javax.swing.JLabel();
        jpBusquedaUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEscenariosPedagogicos = new javax.swing.JTable();
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

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("ESCENARIOS PEDAGÓGICOS");
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

        txtNumero.setPreferredSize(new java.awt.Dimension(225, 25));
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        lblInformeViabilidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblInformeViabilidad.setText("Viabilidad:");
        lblInformeViabilidad.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblInformeViabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

        lblEquipamiento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEquipamiento.setText("Equipamiento:");
        lblEquipamiento.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblEquipamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, -1));

        lblActividades.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblActividades.setText("Actividades:");
        lblActividades.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 110, -1));

        lblTipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTipo.setText("Tipo:");
        lblTipo.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));

        lblNumeroEstudiantes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumeroEstudiantes.setText("No. de Estudiantes:");
        lblNumeroEstudiantes.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblNumeroEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, -1));

        txtViabilidad.setEditable(false);
        txtViabilidad.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroUsuario.add(txtViabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        btnViabilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnViabilidad.setToolTipText("Buscar");
        btnViabilidad.setBorder(null);
        btnViabilidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViabilidadActionPerformed(evt);
            }
        });
        jpRegistroUsuario.add(btnViabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        lblObservaciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblObservaciones.setText("Observaciones:");
        lblObservaciones.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 110, -1));

        txaObservaciones.setColumns(1);
        txaObservaciones.setLineWrap(true);
        txaObservaciones.setRows(3);
        jScrollPane2.setViewportView(txaObservaciones);

        jpRegistroUsuario.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 220, -1));

        txaActividades1.setColumns(1);
        txaActividades1.setLineWrap(true);
        txaActividades1.setRows(3);
        jScrollPane3.setViewportView(txaActividades1);

        jpRegistroUsuario.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 220, -1));

        txaEquipamiento1.setColumns(1);
        txaEquipamiento1.setLineWrap(true);
        txaEquipamiento1.setRows(3);
        jScrollPane4.setViewportView(txaEquipamiento1);

        jpRegistroUsuario.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 220, -1));

        txtTipo1.setPreferredSize(new java.awt.Dimension(225, 25));
        txtTipo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTipo1KeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtTipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        lblPersona6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona6.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona6.setText("*");
        lblPersona6.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 10, -1));

        lblPersona7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona7.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona7.setText("*");
        lblPersona7.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 10, -1));

        lblPersona8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona8.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona8.setText("*");
        lblPersona8.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 10, -1));

        lblPersona9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona9.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona9.setText("*");
        lblPersona9.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 10, -1));

        lblPersona10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona10.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona10.setText("*");
        lblPersona10.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 10, -1));

        jPanel1.add(jpRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 55, -1, -1));

        jpBusquedaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaUsuario.setPreferredSize(new java.awt.Dimension(450, 510));
        jpBusquedaUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(430, 420));

        jtEscenariosPedagogicos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtEscenariosPedagogicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtEscenariosPedagogicos.setGridColor(new java.awt.Color(0, 102, 153));
        jtEscenariosPedagogicos.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtEscenariosPedagogicos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtEscenariosPedagogicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEscenariosPedagogicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEscenariosPedagogicos);

        jpBusquedaUsuario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        jpBusquedaUsuario.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 90, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaUsuario.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 280, -1));

        lblRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros.setText("Registros:");
        lblRegistros.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaUsuario.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaUsuario.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

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
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_nuevo_40.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos"> 
    private void jtEscenariosPedagogicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEscenariosPedagogicosMouseClicked
        int fila = jtEscenariosPedagogicos.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarEscenarioViabilidad(consultarRegistroIndividual(jtEscenariosPedagogicos.getValueAt(fila, 0).toString(), "usuario"));
        }
    }//GEN-LAST:event_jtEscenariosPedagogicosMouseClicked

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

    private void btnViabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViabilidadActionPerformed
        buscar("persona");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarViabilidad(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona"));
    }//GEN-LAST:event_btnViabilidadActionPerformed

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        convertirAminusculas(txtNumero);
    }//GEN-LAST:event_txtNumeroKeyReleased

    private void txtTipo1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipo1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipo1KeyReleased
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtEscenariosPedagogicos.getRowCount();
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
        map.put("tipo", txtNumero.getText());
        map.put("numeroEstudiantes", txtNumero.getText());
        map.put("observaciones", txaObservaciones.getText());
        map.put("actividades", txaActividades1.getText());
        map.put("equipamiento", txaEquipamiento1.getText());

        //instacia el controlador
        ControladorEscenarioViabilidad escViabilidad = new ControladorEscenarioViabilidad();
        //llama al metodo para crear o actualizar segun sea la accion
        return escViabilidad.crearActualizar(map);

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
        jtEscenariosPedagogicos.getColumnModel().getColumn(0).setMaxWidth(0);
        jtEscenariosPedagogicos.getColumnModel().getColumn(0).setMinWidth(0);
        jtEscenariosPedagogicos.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    protected void limpiarCajasTexto(Component component) {
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

    private void llenarEscenarioViabilidad(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        idViabilidad = (String.valueOf(datos.get(1)));
        txtViabilidad.setText((String) datos.get(2));
        txtTipo1.setText((String) datos.get(2));
        txtNumero.setText((String) datos.get(2));
        txaEquipamiento1.setText((String) datos.get(2));
        txaObservaciones.setText((String) datos.get(2));
        txaActividades1.setText((String) datos.get(2));
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid() {
        jtEscenariosPedagogicos.setModel(controladorGrid.getInstance().llenarGrid("escenario_viabilidad", "grid", null, true));
        sorter = new TableRowSorter<>(jtEscenariosPedagogicos.getModel());
        jtEscenariosPedagogicos.setRowSorter(sorter);
        jtEscenariosPedagogicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarViabilidad(ArrayList<Object> datos) {
        idViabilidad = (String.valueOf(datos.get(0)));
        txtViabilidad.setText((String) datos.get(5) + " " + (String) datos.get(4));

    }

// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify                     "> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnViabilidad;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpBusquedaUsuario;
    private javax.swing.JPanel jpRegistroUsuario;
    private javax.swing.JTable jtEscenariosPedagogicos;
    private javax.swing.JLabel lblActividades;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblEquipamiento;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblInformeViabilidad;
    private javax.swing.JLabel lblNumeroEstudiantes;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPersona10;
    private javax.swing.JLabel lblPersona6;
    private javax.swing.JLabel lblPersona7;
    private javax.swing.JLabel lblPersona8;
    private javax.swing.JLabel lblPersona9;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaActividades1;
    private javax.swing.JTextArea txaEquipamiento1;
    private javax.swing.JTextArea txaObservaciones;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTipo1;
    private javax.swing.JTextField txtViabilidad;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
