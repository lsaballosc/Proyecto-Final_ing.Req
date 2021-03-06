/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import funciones.AbrirArchivo;
import funciones.GuardarArchivo;
import funciones.getFecha;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class Ventana extends javax.swing.JFrame {

    TextLineNumber numeroLinea;

    public Ventana() {
        initComponents();
        numeroLinea = new TextLineNumber(notas);
        scroll.setRowHeaderView(numeroLinea);
        ponerInfo();
        try {
            setIconImage(new ImageIcon(getClass().getResource("../imagenes/bloc-de-notas.png")).getImage());
        } catch (Exception e) {
        }
        comprobaciones();
        ponerTitulo();

    }

    private void ponerTitulo() {
        this.setTitle("Nuevo documento");
    }

    private void comprobaciones() {
        if (ajusteLinea.isSelected()) {
            notas.setLineWrap(true);
        } else {
            notas.setLineWrap(false);
        }

    }

    private void ponerInfo() {

        notas.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
                try {
                    if (esp.isSelected()) {
                        int row = notas.getLineOfOffset(pos) + 1;
                        int col = pos - notas.getLineStartOffset(row - 1) + 1;
                        info.setText("L??nea: " + row + " Columna: " + col + " Numero de palabras: " + contarPalabras(notas.getText()));
                    } else {
                        int row = notas.getLineOfOffset(pos) + 1;
                        int col = pos - notas.getLineStartOffset(row - 1) + 1;
                        info.setText("Line: " + row + " Column: " + col + " Number of words: " + contarPalabras(notas.getText()));
                    }
                } catch (BadLocationException exc) {
                    System.out.println(exc);
                }
            }
        });
    }

    private void abrirArchivo() {
        AbrirArchivo abrir = new AbrirArchivo();
        AbrirArchivo.Abrir(modificado, notas, this);
    }

    private File guardarArchivo() {
        GuardarArchivo guardar = new GuardarArchivo();
        return GuardarArchivo.guardar(guardado, notas, this);
    }

    private static int contarPalabras(String notas) {
        notas.trim();
        int cont = 1;
        int posicion;
        if (notas.isEmpty()) {
            cont = 0;
        } else {
            cont = notas.split("\\s+|\n|,").length;
        }

        return cont;
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idioma_btnGroup = new javax.swing.ButtonGroup();
        scroll = new javax.swing.JScrollPane();
        notas = new javax.swing.JTextArea();
        info = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        infoTam = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MenuSuperior = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        Nuevo = new javax.swing.JMenuItem();
        Abrir = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        Editar = new javax.swing.JMenu();
        ColorFondo = new javax.swing.JMenuItem();
        ColorLetras = new javax.swing.JMenuItem();
        Colores = new javax.swing.JMenu();
        Dark = new javax.swing.JMenuItem();
        Light = new javax.swing.JMenuItem();
        nature = new javax.swing.JMenuItem();
        water = new javax.swing.JMenuItem();
        fuentes = new javax.swing.JMenu();
        Arial = new javax.swing.JMenuItem();
        Impact = new javax.swing.JMenuItem();
        tahoma = new javax.swing.JMenuItem();
        georgia = new javax.swing.JMenuItem();
        jokerman = new javax.swing.JMenuItem();
        inkFree = new javax.swing.JMenuItem();
        buscar = new javax.swing.JMenuItem();
        fecha = new javax.swing.JMenuItem();
        Formato = new javax.swing.JMenu();
        ajusteLinea = new javax.swing.JCheckBoxMenuItem();
        mostrarNumLinea = new javax.swing.JCheckBoxMenuItem();
        idioma = new javax.swing.JMenu();
        esp = new javax.swing.JRadioButtonMenuItem();
        ing = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        notas.setColumns(20);
        notas.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        notas.setRows(5);
        notas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        notas.setSelectionColor(new java.awt.Color(255, 102, 102));
        notas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notasMouseClicked(evt);
            }
        });
        notas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                notasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                notasKeyTyped(evt);
            }
        });
        scroll.setViewportView(notas);

        info.setBackground(new java.awt.Color(102, 102, 102));
        info.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        slider.setMajorTickSpacing(10);
        slider.setMaximum(50);
        slider.setMinimum(10);
        slider.setMinorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setValue(18);
        slider.setName("Tama??o"); // NOI18N
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        infoTam.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        infoTam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("jLabel1");

        MenuSuperior.setBackground(new java.awt.Color(153, 255, 153));
        MenuSuperior.setForeground(new java.awt.Color(51, 0, 51));
        MenuSuperior.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        archivo.setText("Archivo");
        archivo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        Nuevo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        archivo.add(Nuevo);

        Abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Abrir.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        archivo.add(Abrir);

        Guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Guardar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        archivo.add(Guardar);

        Salir.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        archivo.add(Salir);

        MenuSuperior.add(archivo);

        Editar.setText("Editar");
        Editar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        ColorFondo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ColorFondo.setText("Color de fondo");
        ColorFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorFondoActionPerformed(evt);
            }
        });
        Editar.add(ColorFondo);

        ColorLetras.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ColorLetras.setText("Color de las letras");
        ColorLetras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorLetrasActionPerformed(evt);
            }
        });
        Editar.add(ColorLetras);

        Colores.setText("Temas de color");
        Colores.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        Dark.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Dark.setText("Dark");
        Dark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarkActionPerformed(evt);
            }
        });
        Colores.add(Dark);

        Light.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Light.setText("Light");
        Light.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LightActionPerformed(evt);
            }
        });
        Colores.add(Light);

        nature.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nature.setText("Nature");
        nature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                natureActionPerformed(evt);
            }
        });
        Colores.add(nature);

        water.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        water.setText("Water");
        water.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waterActionPerformed(evt);
            }
        });
        Colores.add(water);

        Editar.add(Colores);

        fuentes.setText("Fuentes");
        fuentes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        fuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuentesActionPerformed(evt);
            }
        });

        Arial.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Arial.setText("Arial");
        Arial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArialActionPerformed(evt);
            }
        });
        fuentes.add(Arial);

        Impact.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        Impact.setText("Impact");
        Impact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpactActionPerformed(evt);
            }
        });
        fuentes.add(Impact);

        tahoma.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tahoma.setText("Tahoma");
        tahoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahomaActionPerformed(evt);
            }
        });
        fuentes.add(tahoma);

        georgia.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        georgia.setText("Georgia");
        georgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                georgiaActionPerformed(evt);
            }
        });
        fuentes.add(georgia);

        jokerman.setFont(new java.awt.Font("Jokerman", 0, 16)); // NOI18N
        jokerman.setText("Jokerman");
        jokerman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jokermanActionPerformed(evt);
            }
        });
        fuentes.add(jokerman);

        inkFree.setFont(new java.awt.Font("Ink Free", 0, 16)); // NOI18N
        inkFree.setText("Ink Free");
        inkFree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inkFreeActionPerformed(evt);
            }
        });
        fuentes.add(inkFree);

        Editar.add(fuentes);

        buscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buscar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        Editar.add(buscar);

        fecha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        fecha.setText("Fecha y hora");
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });
        Editar.add(fecha);

        MenuSuperior.add(Editar);

        Formato.setText("Formato");
        Formato.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        ajusteLinea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ajusteLinea.setSelected(true);
        ajusteLinea.setText("Ajuste de Linea");
        ajusteLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajusteLineaActionPerformed(evt);
            }
        });
        Formato.add(ajusteLinea);

        mostrarNumLinea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mostrarNumLinea.setSelected(true);
        mostrarNumLinea.setText("Numero de linea");
        mostrarNumLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarNumLineaActionPerformed(evt);
            }
        });
        Formato.add(mostrarNumLinea);

        MenuSuperior.add(Formato);

        idioma.setText("Idioma");
        idioma.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        idioma_btnGroup.add(esp);
        esp.setSelected(true);
        esp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/esp.gif"))); // NOI18N
        esp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espActionPerformed(evt);
            }
        });
        idioma.add(esp);

        idioma_btnGroup.add(ing);
        ing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ing.jpg"))); // NOI18N
        ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingActionPerformed(evt);
            }
        });
        idioma.add(ing);

        MenuSuperior.add(idioma);

        setJMenuBar(MenuSuperior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoTam, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoTam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

        guardarArchivo();


    }//GEN-LAST:event_GuardarActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed

        notas.setText("");
        ponerTitulo();
    }//GEN-LAST:event_NuevoActionPerformed

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed

        abrirArchivo();
    }//GEN-LAST:event_AbrirActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed

        System.exit(0);

    }//GEN-LAST:event_SalirActionPerformed

    private void ajusteLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajusteLineaActionPerformed

        if (ajusteLinea.isSelected()) {

            notas.setLineWrap(true);
        } else {
            notas.setLineWrap(false);
        }
    }//GEN-LAST:event_ajusteLineaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed


    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

        if (modificado == true && guardado == false) {
            int opciones = JOptionPane.showConfirmDialog(null, "??Guardar el archivo?");  //0=si 1=no 2=cancelar
            switch (opciones) {
                case 0:
                    guardarArchivo();
                    break;
                case JOptionPane.CANCEL_OPTION:
                    setDefaultCloseOperation(Ventana.DO_NOTHING_ON_CLOSE);
                    break;
                default:
                    System.exit(0);
            }

        }


    }//GEN-LAST:event_formWindowClosing

    private void notasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notasKeyTyped

        modificado = true;
    }//GEN-LAST:event_notasKeyTyped

    private void notasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notasKeyPressed

        infoTam.setText("Tama??o de las letras: " + slider.getValue());
        ponerInfo();
        try {
            popDerecho.setVisible(false);
        } catch (Exception e) {
            Exception NullException;
        }
        contarPalabras(notas.getText());
    }//GEN-LAST:event_notasKeyPressed


    private void notasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notasMouseClicked

        infoTam.setText("Tama??o de las letras: " + slider.getValue());
        if (evt.getClickCount() == 2) {
            Highlighter h = notas.getHighlighter();
            h.removeAllHighlights();
        }

        if (evt.getButton() == MouseEvent.BUTTON3) {

            if (popDerecho != null) {
                popDerecho.setVisible(false);
            }
            popDerecho = new JPopupMenu();
            copiarpop = new JMenuItem("Copiar");
            pegarpop = new JMenuItem("Pegar");
            cortarpop = new JMenuItem("Cortar");
            popDerecho.add(copiarpop);
            popDerecho.add(pegarpop);
            popDerecho.add(cortarpop);

            popDerecho.setLocation(evt.getLocationOnScreen());
            popDerecho.setVisible(true);

        }

    }//GEN-LAST:event_notasMouseClicked

    private void espActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espActionPerformed
        // TODO add your handling code here:
        archivo.setText("Archivo");
        Nuevo.setText("Nuevo");
        Abrir.setText("Abrir");
        Guardar.setText("Guardar");
        Salir.setText("Salir");

        Editar.setText("Editar");
        ColorFondo.setText("Color de fondo");
        ColorLetras.setText("Color de las letras");
        Colores.setText("Colores");
        fuentes.setText("Fuentes");
        buscar.setText("Buscar");
        fecha.setText("Fecha y hora");

        mostrarNumLinea.setText("Numero de linea");
        Formato.setText("Formato");
        ajusteLinea.setText("Ajuste de linea");
        idioma.setText("Idioma");


    }//GEN-LAST:event_espActionPerformed

    private void ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingActionPerformed

        archivo.setText("File");
        Nuevo.setText("New");
        Abrir.setText("Open");
        Guardar.setText("Save");
        Salir.setText("Exit");

        Editar.setText("Edit");
        ColorFondo.setText("Background Color");
        ColorLetras.setText("Word Color");
        fuentes.setText("Fonts");
        buscar.setText("Find");
        mostrarNumLinea.setText("Line number");
        fecha.setText("Date and hour");
        Colores.setText("Themes");
        Formato.setText("Format");
        ajusteLinea.setText("Word wrap");

        idioma.setText("Language");


    }//GEN-LAST:event_ingActionPerformed

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed

        fechaHora = new java.util.GregorianCalendar();
        getFecha getFecha = new getFecha();
        if (esp.isSelected()) {

            String getFechaESP = getFecha.getFechaHoraESP(fechaHora);
            notas.setText(notas.getText() + getFechaESP);
        }

    }//GEN-LAST:event_fechaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

     

    }//GEN-LAST:event_buscarActionPerformed


    private void inkFreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inkFreeActionPerformed

      
    }//GEN-LAST:event_inkFreeActionPerformed

    private void jokermanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jokermanActionPerformed

       
    }//GEN-LAST:event_jokermanActionPerformed

    private void georgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_georgiaActionPerformed

       
    }//GEN-LAST:event_georgiaActionPerformed

    private void tahomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahomaActionPerformed

       
    }//GEN-LAST:event_tahomaActionPerformed

    private void ImpactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImpactActionPerformed

    
    }//GEN-LAST:event_ImpactActionPerformed

    private void ArialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArialActionPerformed

    

    }//GEN-LAST:event_ArialActionPerformed

    private void ColorLetrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorLetrasActionPerformed

    

    }//GEN-LAST:event_ColorLetrasActionPerformed

    private void ColorFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorFondoActionPerformed

     

    }//GEN-LAST:event_ColorFondoActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated

        try {
            if (popDerecho.isVisible()) {
                popDerecho.setVisible(false);
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_formWindowDeactivated

    private void DarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DarkActionPerformed

        notas.setBackground(Color.black);
        notas.setForeground(Color.white);
    }//GEN-LAST:event_DarkActionPerformed

    private void LightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LightActionPerformed

        notas.setBackground(Color.white);
        notas.setForeground(Color.black);
    }//GEN-LAST:event_LightActionPerformed

    private void natureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_natureActionPerformed

        Color fondo = new Color(192, 235, 221);
        Color letras = new Color(1, 97, 66);
        notas.setBackground(fondo);
        notas.setForeground(letras);
    }//GEN-LAST:event_natureActionPerformed

    private void waterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waterActionPerformed

        Color fondo = new Color(186, 237, 245);
        Color letras = new Color(0, 42, 252);
        notas.setBackground(fondo);
        notas.setForeground(letras);


    }//GEN-LAST:event_waterActionPerformed

    private void mostrarNumLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarNumLineaActionPerformed

        if (mostrarNumLinea.isSelected()) {
            numeroLinea = new TextLineNumber(notas);
            scroll.setRowHeaderView(numeroLinea);
        } else {
            numeroLinea = new TextLineNumber(notas);
            scroll.setRowHeaderView(null);
        }
    }//GEN-LAST:event_mostrarNumLineaActionPerformed

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged

    
    }//GEN-LAST:event_sliderStateChanged

    private void fuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fuentesActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try { //Para cambiar la interfaz grafica de los FileChooser, se cambia por la que tenga el sistema en ese momento
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new Ventana().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JMenuItem Arial;
    private javax.swing.JMenuItem ColorFondo;
    private javax.swing.JMenuItem ColorLetras;
    private javax.swing.JMenu Colores;
    private javax.swing.JMenuItem Dark;
    private javax.swing.JMenu Editar;
    private javax.swing.JMenu Formato;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuItem Impact;
    private javax.swing.JMenuItem Light;
    private javax.swing.JMenuBar MenuSuperior;
    private javax.swing.JMenuItem Nuevo;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JCheckBoxMenuItem ajusteLinea;
    private javax.swing.JMenu archivo;
    private javax.swing.JMenuItem buscar;
    private javax.swing.JRadioButtonMenuItem esp;
    private javax.swing.JMenuItem fecha;
    private javax.swing.JMenu fuentes;
    private javax.swing.JMenuItem georgia;
    private javax.swing.JMenu idioma;
    private javax.swing.ButtonGroup idioma_btnGroup;
    private javax.swing.JLabel info;
    private javax.swing.JLabel infoTam;
    private javax.swing.JRadioButtonMenuItem ing;
    private javax.swing.JMenuItem inkFree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jokerman;
    private javax.swing.JCheckBoxMenuItem mostrarNumLinea;
    private javax.swing.JMenuItem nature;
    private javax.swing.JTextArea notas;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JSlider slider;
    private javax.swing.JMenuItem tahoma;
    private javax.swing.JMenuItem water;
    // End of variables declaration//GEN-END:variables
   private java.util.GregorianCalendar fechaHora;
    boolean modificado = false;
    boolean guardado = false;
    private JComboBox size;
    private JPopupMenu popDerecho;
    private JMenuItem cortarpop, copiarpop, pegarpop;
    private String texto;
    Font fuente;
}
