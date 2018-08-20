/*
 * Nombre de la clase: Principal
 * Descripción: esta clases es la principal, desde aquí se invocan a las demás
 *  interfaces para que inicie el programa completo.
 */
package gestionbasedatos;

import gestionbasedatos.interfaces.LoginBD;
import gestionbasedatos.interfaces.SplashScreen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author m2 linuxitos@gmail.com
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
            System.err.println("Error Look GUI: "+e.getMessage());
        }
        SplashScreen s=new SplashScreen();
        s.setVisible(true);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.dispose();
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                /*Aquí crean el objeto hacía su aplicación, para hacer visible*/
                LoginBD nuevaSesion = new LoginBD();
                nuevaSesion.setVisible(true);
            }
        });        
    }
    
}