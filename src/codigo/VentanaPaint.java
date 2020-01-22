/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import codigo.formas.Circulo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author jahaziel
 */
public class VentanaPaint extends javax.swing.JFrame {

    BufferedImage buffer = null;

    Graphics2D bufferGraphics, jPanelGraphics = null; //libreria de java que permite figuras geometricas y lineas

    int herramientaSeleccionada = 0;//Creado para poder elegir que estoy haciendo, arrastrar, pintar....

    Circulo miCirculo = null;

    public VentanaPaint() { //constructor
        initComponents();
        inicializaBuffers(); //llamo al metodo para ejecutar, pero aun no he enlazado memoria en blanco con el componente (jPanel)
    }

    private void inicializaBuffers() {
        //Creo una imagen del mismo alto y ancho que el jPanel1
        buffer = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight()); // (BufferedImage) es un casteo
        //creo una imagen modificable
        bufferGraphics = buffer.createGraphics();
        //inicializar buffer para que se pinte de blanco entero
        bufferGraphics.setColor(Color.white);
        bufferGraphics.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight()); // los ceros señalan la esq.super.izq (0,0)
        //Con esto esta creado el rectangulo
        jPanelGraphics = (Graphics2D) jPanel1.getGraphics(); //enlazo jpanel1 con jpanelgraphics 
    }

    @Override
    public void paint(Graphics g) { //g de graficos, paint es un metodo dentro de  JFrame, paint se encarga de dibujar 
        super.paint(g); // llamo a la clasa a la que extiendo, al metodo que se llama paint de jframe

        //pinto el buffer sobre el jpanel
        jPanelGraphics.drawImage(buffer, 0, 0, null);// buffer es una imagen sobre (0,0), y se coloca null

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelColores1 = new codigo.PanelColores();
        herramientas1 = new codigo.Herramientas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(herramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelColores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(herramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelColores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        switch (herramientaSeleccionada) {
            case 0:
                bufferGraphics.setColor(panelColores1.colorSeleccionado); //Estoy dibujando sobre la memoria, y después tengo que volcarlo sobre la pantalla
                bufferGraphics.fillOval(evt.getX(), evt.getY(), 4, 4);

                break;
            case 1: miCirculo.dibujate(bufferGraphics, evt.getX());
            break;

        }
        repaint(0, 0, 1, 1); //refresca pantalla 
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        switch (herramientas1.formaElegida) {
            case 0:
                break;
            case 1:
                miCirculo = new Circulo(evt.getX(), evt.getY(), 1, panelColores1.colorSeleccionado, true);
                miCirculo.dibujate(bufferGraphics, evt.getX());
                break;

        }
    }//GEN-LAST:event_jPanel1MousePressed

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
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPaint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private codigo.Herramientas herramientas1;
    private javax.swing.JPanel jPanel1;
    private codigo.PanelColores panelColores1;
    // End of variables declaration//GEN-END:variables
}
