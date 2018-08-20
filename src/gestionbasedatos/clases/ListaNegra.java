/*
 * Nombre de la clase: ListaNegra
 * Descripción: Contiene los atributos de la tabla listanegra que se encuentra en
    la base de datos.
 */
package gestionbasedatos.clases;

/**
 *
 * @author m2 <linuxitos@gmail.com>
 */
public class ListaNegra {
    int id;
    String nombre="";
    String razon="";
    int edad;
    int iduser;

    public ListaNegra(String nom, String raz,int eda){
        setNombre(nom);
        setRazon(raz);
        setEdad(eda);
    }
    public ListaNegra(){
        setNombre("");
        setRazon("");
        setEdad(1);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
}
