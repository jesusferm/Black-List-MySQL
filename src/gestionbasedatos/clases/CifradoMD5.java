/*
 * Clase para cifrar las contraseñas.
 */
package gestionbasedatos.clases;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author m2
 */
public class CifradoMD5 {
    private static MessageDigest md;
    public static String Cifrado(String pass){
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Error al encriptar MD5: "+ex.getMessage());
        }
        return null;
    }
}
