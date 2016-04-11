/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controladorConsulta;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmAgenda extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    private String[] criterioBusqueda;
    private TableRowSorter<TableModel> sorter;
// </editor-fold> 

    public frmAgenda() {
        initComponents();
        this.setLocationRelativeTo(null);
        init();
    }

    private void init() {
        criterioBusqueda = new String[2];
        llenarGrid();
        llenarFiltro();
        cargarTotalRegistros();
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recursos/ico_agenda_32.jpg"));

        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpBusquedaAsignatura = new javax.swing.JPanel();
        lblFiltro = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox();
        txtCriterioBusqueda = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtContactos = new javax.swing.JTable();
        lblTotalRegistros = new javax.swing.JLabel();
        lblRegistros3 = new javax.swing.JLabel();
        jpRegistroUsuario = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtNombrePersona = new javax.swing.JTextField();
        lblRol = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        lblClave3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
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
        lblBusqueda = new javax.swing.JLabel();
        lblBusqueda1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AGENDA");
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpBusquedaAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaAsignatura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaAsignatura.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaAsignatura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaAsignatura.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));

        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpBusquedaAsignatura.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 23));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioBusquedaActionPerformed(evt);
            }
        });
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaAsignatura.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 250, -1));

        jtContactos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtContactos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtContactos.setGridColor(new java.awt.Color(0, 102, 153));
        jtContactos.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtContactos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtContactosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtContactos);

        jpBusquedaAsignatura.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 440, 450));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaAsignatura.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        lblRegistros3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros3.setText("Registros:");
        lblRegistros3.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaAsignatura.add(lblRegistros3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        jPanel1.add(jpBusquedaAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

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

        txtNombrePersona.setEditable(false);
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
        jpRegistroUsuario.add(txtNombrePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 250, -1));

        lblRol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol.setText("Identificación:");
        lblRol.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, -1));

        lblClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave.setText("Nombres:");
        lblClave.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 20));

        lblClave3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave3.setText("Apellidos:");
        lblClave3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 130, 20));

        txtApellido.setEditable(false);
        txtApellido.setPreferredSize(new java.awt.Dimension(225, 25));
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 250, -1));

        txtFormacionAcademica.setEditable(false);
        txtFormacionAcademica.setPreferredSize(new java.awt.Dimension(225, 25));
        txtFormacionAcademica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFormacionAcademicaKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtFormacionAcademica, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 250, -1));

        lblClave5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave5.setText("Teléfono Fijo:");
        lblClave5.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 80, 20));

        txtTelefonoFijo.setEditable(false);
        txtTelefonoFijo.setPreferredSize(new java.awt.Dimension(225, 25));
        txtTelefonoFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoFijoKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtTelefonoFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 250, -1));

        lblClave6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave6.setText("Teléfono Móvil:");
        lblClave6.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 90, 20));

        txtTelefonoMovil.setEditable(false);
        txtTelefonoMovil.setPreferredSize(new java.awt.Dimension(225, 25));
        txtTelefonoMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoMovilActionPerformed(evt);
            }
        });
        txtTelefonoMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoMovilKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtTelefonoMovil, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 250, -1));

        lblClave7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave7.setText("Correo Electrónico:");
        lblClave7.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 130, 20));

        txtEmail.setEditable(false);
        txtEmail.setPreferredSize(new java.awt.Dimension(225, 25));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 250, -1));

        lblClave8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave8.setText("Fecha Nacimiento:");
        lblClave8.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 20));

        lblRol1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol1.setText("Dirección:");
        lblRol1.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 130, -1));

        lblRol2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol2.setText("Formación Académica:");
        lblRol2.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 130, -1));

        jScrollPane2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jScrollPane2KeyReleased(evt);
            }
        });

        txaInformacionAdicional.setEditable(false);
        txaInformacionAdicional.setColumns(20);
        txaInformacionAdicional.setLineWrap(true);
        txaInformacionAdicional.setRows(2);
        txaInformacionAdicional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaInformacionAdicionalKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaInformacionAdicional);

        jpRegistroUsuario.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 250, -1));

        lblRol3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol3.setText("Información Adicional:");
        lblRol3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRol3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 130, -1));

        txtNumeroIdentificacion.setEditable(false);
        txtNumeroIdentificacion.setPreferredSize(new java.awt.Dimension(100, 25));
        txtNumeroIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroIdentificacionActionPerformed(evt);
            }
        });
        txtNumeroIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroIdentificacionKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtNumeroIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 250, -1));

        txaDireccion.setEditable(false);
        txaDireccion.setColumns(1);
        txaDireccion.setLineWrap(true);
        txaDireccion.setRows(2);
        txaDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDireccionKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txaDireccion);

        jpRegistroUsuario.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 250, -1));

        dtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        dtFechaNacimiento.setPreferredSize(new java.awt.Dimension(110, 25));
        jpRegistroUsuario.add(dtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 110, -1));
        dtFechaNacimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Date date3 = new Date();
        dtFechaNacimiento.setDate(date3);

        jPanel1.add(jpRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        lblBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_agenda_32.jpg"))); // NOI18N
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, -1));

        lblBusqueda1.setBackground(new java.awt.Color(255, 255, 255));
        lblBusqueda1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda1.setText("AGENDA");
        jPanel1.add(lblBusqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCriterioBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaActionPerformed

    private void txtCriterioBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaKeyPressed

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased
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

    private void filtrar() {
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(txtCriterioBusqueda.getText(), cmbFiltro.getSelectedIndex() + 1);
            sorter.setRowFilter(rf);

        } catch (java.util.regex.PatternSyntaxException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Error Filtrar", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void jtContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtContactosMouseClicked
        int fila = jtContactos.getSelectedRow();//guarda la fila seleccionada
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarTutorEmpresarial(consultarRegistroIndividual(jtContactos.getValueAt(fila, 0).toString(), "persona_agenda"));
        }
    }//GEN-LAST:event_jtContactosMouseClicked

    private void txtNombrePersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePersonaActionPerformed

    private void txtNombrePersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePersonaKeyReleased

        convertirAmayusculas(txtNombrePersona);
        txtNombrePersona.setText(controladorVariablesSesion.validarLetrasConEspacios(txtNombrePersona.getText()));
    }//GEN-LAST:event_txtNombrePersonaKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        convertirAmayusculas(txtApellido);
        txtApellido.setText(controladorVariablesSesion.validarLetrasConEspacios(txtApellido.getText()));
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtFormacionAcademicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormacionAcademicaKeyReleased
        convertirAmayusculas(txtFormacionAcademica);
    }//GEN-LAST:event_txtFormacionAcademicaKeyReleased

    private void txtTelefonoFijoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoFijoKeyReleased
        txtTelefonoFijo.setText(controladorVariablesSesion.validarNumerosSinEspacios(txtTelefonoFijo.getText()));
    }//GEN-LAST:event_txtTelefonoFijoKeyReleased

    private void txtTelefonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoMovilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoMovilActionPerformed

    private void txtTelefonoMovilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoMovilKeyReleased
        txtTelefonoMovil.setText(controladorVariablesSesion.validarNumerosSinEspacios(txtTelefonoMovil.getText()));
    }//GEN-LAST:event_txtTelefonoMovilKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased

    }//GEN-LAST:event_txtEmailKeyReleased

    private void txaInformacionAdicionalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaInformacionAdicionalKeyReleased
        convertirAmayusculas(txaInformacionAdicional);
    }//GEN-LAST:event_txaInformacionAdicionalKeyReleased

    private void jScrollPane2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane2KeyReleased

    }//GEN-LAST:event_jScrollPane2KeyReleased

    private void txaDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDireccionKeyReleased
        convertirAmayusculas(txaDireccion);
    }//GEN-LAST:event_txaDireccionKeyReleased

    private void txtNumeroIdentificacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroIdentificacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroIdentificacionKeyReleased

    private void txtNumeroIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroIdentificacionActionPerformed

    }//GEN-LAST:event_txtNumeroIdentificacionActionPerformed
    private ArrayList<Object> consultarRegistroIndividual(String id, String tabla) {
        criterioBusqueda[0] = id;
        controladorConsulta consulta = new controladorConsulta();
        return consulta.obtenerConsulta(tabla, controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);
    }

    private void llenarTutorEmpresarial(ArrayList<Object> datos) {
        txtNombrePersona.setText((String) datos.get(1));
        txtApellido.setText((String) datos.get(2));
        txtNumeroIdentificacion.setText((String) datos.get(3));
        txtTelefonoFijo.setText((String) datos.get(4));
        txtTelefonoMovil.setText((String) datos.get(5));
        txtEmail.setText((String) datos.get(6));
        dtFechaNacimiento.setDate(stringToJDateChooser((String) datos.get(7)));
        txaDireccion.setText((String) datos.get(8));
        txtFormacionAcademica.setText((String) datos.get(9));
        txaInformacionAdicional.setText((String) datos.get(10));
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

    private void llenarGrid() {
        jtContactos.setModel(controladorGrid.getInstance().llenarGrid("persona", "grid", null, true));
        sorter = new TableRowSorter<>(jtContactos.getModel());
        jtContactos.setRowSorter(sorter);
        jtContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void formatearColumnas() {
        //Oculta la primera columna que corresponde al ID de la tabla
        jtContactos.getColumnModel().getColumn(0).setMaxWidth(0);
        jtContactos.getColumnModel().getColumn(0).setMinWidth(0);
        jtContactos.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    private void cargarTotalRegistros() {
        int total = jtContactos.getRowCount();
        lblTotalRegistros.setText(String.valueOf(total));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbFiltro;
    private com.toedter.calendar.JDateChooser dtFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpBusquedaAsignatura;
    private javax.swing.JPanel jpRegistroUsuario;
    private javax.swing.JTable jtContactos;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblBusqueda1;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblClave3;
    private javax.swing.JLabel lblClave5;
    private javax.swing.JLabel lblClave6;
    private javax.swing.JLabel lblClave7;
    private javax.swing.JLabel lblClave8;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblRegistros3;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblRol1;
    private javax.swing.JLabel lblRol2;
    private javax.swing.JLabel lblRol3;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaDireccion;
    private javax.swing.JTextArea txaInformacionAdicional;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFormacionAcademica;
    private javax.swing.JTextField txtNombrePersona;
    private javax.swing.JTextField txtNumeroIdentificacion;
    private javax.swing.JTextField txtTelefonoFijo;
    private javax.swing.JTextField txtTelefonoMovil;
    // End of variables declaration//GEN-END:variables
}
