/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbasedatos.interfaces;

import gestionbasedatos.clases.AdminBDListaNegra;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author m2 <linuxitos@gmail.com>
 */
public class NuevoUsuario extends javax.swing.JDialog {
    
    AdminBDListaNegra adminUsuario = new AdminBDListaNegra();
    
    /**
     * Creates new form NuevoUsuario
     */
    public NuevoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jtxtNick = new javax.swing.JTextField();
        jtxtname = new javax.swing.JTextField();
        jtxtlastname = new javax.swing.JTextField();
        jpasswd = new javax.swing.JPasswordField();
        jpasswdRepetir = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JToggleButton();
        jbCrear = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Creando nuevo usuario");
        setResizable(false);

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel1.setText("Creando nuevo usuario:");

        jtxtNick.setText("NickName");
        jtxtNick.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtNickFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtNickFocusLost(evt);
            }
        });
        jtxtNick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNickKeyPressed(evt);
            }
        });

        jtxtname.setText("Nombre");
        jtxtname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtnameFocusLost(evt);
            }
        });
        jtxtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtnameKeyPressed(evt);
            }
        });

        jtxtlastname.setText("Apellidos");
        jtxtlastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtlastnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtlastnameFocusLost(evt);
            }
        });
        jtxtlastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtlastnameKeyPressed(evt);
            }
        });

        jpasswd.setText("password");
        jpasswd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpasswdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpasswdFocusLost(evt);
            }
        });
        jpasswd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpasswdKeyPressed(evt);
            }
        });

        jpasswdRepetir.setText("password");
        jpasswdRepetir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpasswdRepetirFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpasswdRepetirFocusLost(evt);
            }
        });
        jpasswdRepetir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpasswdRepetirKeyPressed(evt);
            }
        });

        jLabel2.setText("Contraseña");

        jLabel3.setText("Repetir contraseña");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxtname, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtlastname, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                    .addComponent(jtxtNick)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpasswd)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jpasswdRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jtxtNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpasswdRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestionbasedatos/png/32x32/delete.png"))); // NOI18N
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestionbasedatos/png/32x32/accept.png"))); // NOI18N
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCancelar)
                .addGap(18, 18, 18)
                .addComponent(jbCrear)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbCancelar)
                    .addComponent(jbCrear))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtNickKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNickKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            jbCrear.doClick();
        }
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_jtxtNickKeyPressed

    private void jpasswdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpasswdKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            jbCrear.doClick();
        }
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_jpasswdKeyPressed

    private void jtxtnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnameKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            jbCrear.doClick();
        }
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_jtxtnameKeyPressed

    private void jtxtlastnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtlastnameKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            jbCrear.doClick();
        }
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_jtxtlastnameKeyPressed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed
        if(jtxtNick.getText().length()>0 && jtxtlastname.getText().length()>0 &&
                jtxtname.getText().length()>0 && jpasswd.getPassword().length>0){
            if(!jtxtNick.getText().equals("NickName")){
                String pass1 = new String (jpasswd.getPassword());
                String pass2 = new String (jpasswdRepetir.getPassword());
                if(pass1.equals(pass2)){
                    if(adminUsuario.addNewUser(jtxtNick.getText().toLowerCase(), new String(jpasswd.getPassword()), jtxtname.getText().toUpperCase(), jtxtlastname.getText().toUpperCase())){
                        this.dispose();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.","Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "El NickName no es correcto.","Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Rellene todos los campos.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbCrearActionPerformed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jtxtNickFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNickFocusGained
        if(jtxtNick.getText().equals("NickName")){
            jtxtNick.setText("");
        }
    }//GEN-LAST:event_jtxtNickFocusGained

    private void jpasswdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpasswdFocusGained
        if((new String(jpasswd.getPassword())).equals("password")){
            jpasswd.setText("");
        }
    }//GEN-LAST:event_jpasswdFocusGained

    private void jtxtnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtnameFocusGained
        if(jtxtname.getText().equals("Nombre")){
            jtxtname.setText("");
        }
    }//GEN-LAST:event_jtxtnameFocusGained

    private void jtxtlastnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtlastnameFocusGained
        if(jtxtlastname.getText().equals("Apellidos")){
            jtxtlastname.setText("");
        }
    }//GEN-LAST:event_jtxtlastnameFocusGained

    private void jtxtNickFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNickFocusLost
        if(jtxtNick.getText().equals("")){
            jtxtNick.setText("NickName");
        }
    }//GEN-LAST:event_jtxtNickFocusLost

    private void jpasswdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpasswdFocusLost
        if((new String(jpasswd.getPassword())).equals("")){
            jpasswd.setText("password");
        }
    }//GEN-LAST:event_jpasswdFocusLost

    private void jtxtnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtnameFocusLost
        if(jtxtname.getText().equals("")){
            jtxtname.setText("Nombre");
        }
    }//GEN-LAST:event_jtxtnameFocusLost

    private void jtxtlastnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtlastnameFocusLost
        if(jtxtlastname.getText().equals("")){
            jtxtlastname.setText("Apellidos");
        }
    }//GEN-LAST:event_jtxtlastnameFocusLost

    private void jpasswdRepetirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpasswdRepetirKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            jbCrear.doClick();
        }
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_jpasswdRepetirKeyPressed

    private void jpasswdRepetirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpasswdRepetirFocusGained
        if((new String(jpasswdRepetir.getPassword())).equals("password")){
            jpasswdRepetir.setText("");
        }
    }//GEN-LAST:event_jpasswdRepetirFocusGained

    private void jpasswdRepetirFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpasswdRepetirFocusLost
        if((new String(jpasswdRepetir.getPassword())).equals("")){
            jpasswdRepetir.setText("password");
        }
    }//GEN-LAST:event_jpasswdRepetirFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jbCancelar;
    private javax.swing.JToggleButton jbCrear;
    private javax.swing.JPasswordField jpasswd;
    private javax.swing.JPasswordField jpasswdRepetir;
    private javax.swing.JTextField jtxtNick;
    private javax.swing.JTextField jtxtlastname;
    private javax.swing.JTextField jtxtname;
    // End of variables declaration//GEN-END:variables
}
