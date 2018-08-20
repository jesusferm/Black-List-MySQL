/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbasedatos.clases;

/**
 *
 * @author m2 <linuxitos@gmail.com>
 */
public class Usuario {
    int iduser;
    String nick="";
    String passwd="";
    String nombre="";
    String apellidos="";
    
    public Usuario(int iduser, String nick, String passwd, String nombre, String apellidos){
        setApellidos(apellidos);
        setIduser(iduser);
        setNick(nick);
        setNombre(nombre);
        setPasswd(passwd);
    }
    
    public Usuario(){
        setApellidos("");
        setIduser(0);
        setNick("");
        setNombre("");
        setPasswd("");
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
}
