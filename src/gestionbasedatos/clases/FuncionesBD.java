/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbasedatos.clases;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author m2 <linuxitos@gmail.com>
 */
public class FuncionesBD {
    private static String dbName;
    private static String dbUserName;
    private static String dbPassword;
    private static String archivo;

    public FuncionesBD(String bd, String user, String passwd, String archSql){
        dbName = bd;
        dbUserName = user;
        dbPassword = passwd;
        archivo = archSql;
    }
    
    public static boolean backupDB() {
        File file = new File(archivo);
        String path = file.getPath();
        if (!path.contains(".sql")) {
            file = new File(path + ".sql");
        }
        String executeCmd = "mysqldump -u " + dbUserName + " -p" + dbPassword + " --add-drop-database -B " + dbName + " -r " + file.getPath();
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Respaldo de la Base de Datos exitoso.","Respaldo",JOptionPane.INFORMATION_MESSAGE);
                runtimeProcess.destroy();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error: revise contraseña, base de datos, usuario o la conexión al servidor.","Respaldo",JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException | InterruptedException | HeadlessException ex) {
            System.err.println("Error respaldo: "+ex.getMessage());
        }

        return false;
    }

    public static boolean restoreDB(File file) {
        String path = file.getPath();
        if (!path.contains(".sql")) {
            file = new File(path + ".sql");
        }
        String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source " + file.getPath()};
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Restauración de la Base de Datos exitosa.","Restauración",JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error: revise contraseña, base de datos, usuario o la conexión al servidor.","Restauración",JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException | InterruptedException | HeadlessException ex) {
            System.err.println("Erro restauración: "+ex.getMessage());
        }
        return false;
    }
}