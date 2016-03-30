package vista;

import controlador.ControladorEnumeracion;
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

public class frmParametrizacion extends javax.swing.JInternalFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    private String accion;
    private int limiteTipo;
    private String[] criterioBusqueda;
    ArrayList<String> descripcion;
    private TableRowSorter<TableModel> sorter;
// </editor-fold > 

    public frmParametrizacion() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        limiteTipo = 2;
        criterioBusqueda = new String[2];
        descripcion = new ArrayList<>();
        llenarGrid();
        llenarComboTipos();
        cargarTotalRegistros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpBusquedaUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEnumeración = new javax.swing.JTable();
        lblRegistros = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescripción = new javax.swing.JTextArea();
        lblClave3 = new javax.swing.JLabel();
        lblPersona = new javax.swing.JLabel();
        txtNombreEnumeracion = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        lblClave2 = new javax.swing.JLabel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblBusqueda = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("PARAMETRIZACIÓN");
        setPreferredSize(new java.awt.Dimension(945, 535));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpBusquedaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaUsuario.setPreferredSize(new java.awt.Dimension(600, 520));
        jpBusquedaUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtEnumeración.setModel(new javax.swing.table.DefaultTableModel(
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
        jtEnumeración.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtEnumeración.setGridColor(new java.awt.Color(0, 102, 153));
        jtEnumeración.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtEnumeración.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtEnumeración.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEnumeraciónMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEnumeración);

        jpBusquedaUsuario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 590, 260));

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
        jpBusquedaUsuario.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        cmbTipo.setBackground(new java.awt.Color(204, 204, 255));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbTipo.setPreferredSize(new java.awt.Dimension(150, 25));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });
        jpBusquedaUsuario.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 160, -1));

        txaDescripción.setColumns(20);
        txaDescripción.setRows(3);
        txaDescripción.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDescripciónKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaDescripción);

        jpBusquedaUsuario.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 500, 70));

        lblClave3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave3.setText("Descripción:");
        lblClave3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpBusquedaUsuario.add(lblClave3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, -1));

        lblPersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona.setText("Nombre:");
        lblPersona.setPreferredSize(new java.awt.Dimension(120, 25));
        jpBusquedaUsuario.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        txtNombreEnumeracion.setPreferredSize(new java.awt.Dimension(225, 25));
        txtNombreEnumeracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreEnumeracionKeyReleased(evt);
            }
        });
        jpBusquedaUsuario.add(txtNombreEnumeracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 500, -1));

        txtCodigo.setPreferredSize(new java.awt.Dimension(225, 25));
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });
        jpBusquedaUsuario.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 160, -1));

        lblClave2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave2.setText("Código:");
        lblClave2.setPreferredSize(new java.awt.Dimension(120, 25));
        jpBusquedaUsuario.add(lblClave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, -1));

        lblTitulo_Id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id.setText("Id:");
        lblTitulo_Id.setPreferredSize(new java.awt.Dimension(15, 20));
        jpBusquedaUsuario.add(lblTitulo_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpBusquedaUsuario.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jPanel1.add(jpBusquedaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 620, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("PARAMETRIZACIÓN");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 5, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos"> 
    private void jtEnumeraciónMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEnumeraciónMouseClicked
        int fila = jtEnumeración.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarEnumeracion(consultarRegistroIndividual(jtEnumeración.getValueAt(fila, 0).toString(), "enumeracion"));
        }
    }//GEN-LAST:event_jtEnumeraciónMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpBusquedaUsuario);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpBusquedaUsuario);
            llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        accion = "crear";
        eliminar();//elimina el registro seleccionado
        llenarGrid();//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
        limpiarCajasTexto(jpBusquedaUsuario);//limpia las cajas de texto
        cargarTotalRegistros();//carga el total de registros
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtNombreEnumeracionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEnumeracionKeyReleased
        convertirAmayusculas(txtNombreEnumeracion);
    }//GEN-LAST:event_txtNombreEnumeracionKeyReleased

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txaDescripciónKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescripciónKeyReleased
        convertirAmayusculas(txaDescripción);
    }//GEN-LAST:event_txaDescripciónKeyReleased

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        txaDescripción.setText(descripcion.get(cmbTipo.getSelectedIndex()));
        if (cmbTipo.getSelectedIndex() == 0) {
            llenarGrid();
        } else {
            filtrar();
        }
        cargarTotalRegistros();
    }//GEN-LAST:event_cmbTipoActionPerformed
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtEnumeración.getRowCount();
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
        map.put("nombre", txtNombreEnumeracion.getText());
        map.put("idRol", cmbTipo.getSelectedIndex());
        map.put("codigo", txtCodigo.getText());
        map.put("tipo", cmbTipo.getSelectedItem());
        map.put("descripcion", txaDescripción.getText());

        //instacia el controlador
        ControladorEnumeracion controladorEnumeracion = new ControladorEnumeracion();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorEnumeracion.crearActualizar(map);

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
            rf = RowFilter.regexFilter(cmbTipo.getSelectedItem().toString(), 2);
            sorter.setRowFilter(rf);

        } catch (java.util.regex.PatternSyntaxException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Error Filtrar", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void formatearColumnas() {
        //Oculta la primera columna que corresponde al ID de la tabla
        jtEnumeración.getColumnModel().getColumn(0).setMaxWidth(0);
        jtEnumeración.getColumnModel().getColumn(0).setMinWidth(0);
        jtEnumeración.getColumnModel().getColumn(0).setPreferredWidth(0);

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

    private void llenarGrid() {
        jtEnumeración.setModel(controladorGrid.getInstance().llenarGrid("enumeracion", "grid", null, true));
        sorter = new TableRowSorter<>(jtEnumeración.getModel());
        jtEnumeración.setRowSorter(sorter);
        jtEnumeración.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarEnumeracion(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        txtNombreEnumeracion.setText((String) datos.get(1));
        cmbTipo.setSelectedItem((String) datos.get(2));
        txtCodigo.setText((String) datos.get(3));
        txaDescripción.setText((String) datos.get(4));
    }

    private void llenarComboTipos() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "enumeracion";
        criterioBusqueda[1] = "tabla";
        cmbTipo.setModel(consulta.consultarCombo(criterioBusqueda));
        descripcion = consulta.getCodigoCombo();
    }
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify                     "> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpBusquedaUsuario;
    private javax.swing.JTable jtEnumeración;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblClave2;
    private javax.swing.JLabel lblClave3;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaDescripción;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombreEnumeracion;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
