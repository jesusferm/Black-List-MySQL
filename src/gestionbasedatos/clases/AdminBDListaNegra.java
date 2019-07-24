/*
 * Nombre de la clase: AdminBDListaNegra
 * Descripción: Define métodos que se usan para mostrar y extraer registros
    de la base de datos.
 */
package gestionbasedatos.clases;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author m2 <linuxitos@gmail.com>
 */
public class AdminBDListaNegra {
    
    private String servidor;
    private String usuario;
    private String contrasena;
    private String bd;
    
    ConexionBD conectarBD= new ConexionBD("com.mysql.jdbc.Driver", "jdbc:mysql", "127.0.0.1:3306", "bdlistanegra", "root", "KJota23/1992");

    public ConexionBD getConectarBD() {
        return conectarBD;
    }

    public void setConectarBD(ConexionBD conectarBD) {
        this.conectarBD = conectarBD;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }
    
    
    
    /**
     * Método que recibe toda la información general de un nuevo registro y lo guarda a la base de datos
     * @param reg
     * @return boolean
     * @throw SQLException.
    */
    public boolean GuardarNuevoRegistro(ListaNegra reg){
        conectarBD.conectar();
        boolean guardado = conectarBD.agregarDatosBD("insert into listanegra (iduser, nombre, razon, edad) "
                + "values("+reg.getIduser()+",'"+reg.getNombre()+"','"+reg.getRazon()+"',"+reg.getEdad()+");");
        conectarBD.desconectar();
        return guardado;
    }
    
    /**
    * Método que muestra todos los registros agregandolos a una tabla
    * @param pac.
     * @param iduser
    */
    public void cargarRegistrosTablas(javax.swing.JTable pac, int iduser){
        ListaNegra lista[];
        lista = obtenerTodosRegistros(iduser);
        for (ListaNegra reg : lista) {
            DefaultTableModel tabla=(DefaultTableModel)pac.getModel();
            String[] r=new String[4];
            r[0] = Integer.toString(reg.getId());
            r[1] = reg.getNombre();
            r[2] = reg.getRazon();
            r[3] = Integer.toString(reg.getEdad());
            tabla.addRow(r);
        }
    }
    
    /**
     * Método que retorna un array de registros almacenados en la tabla listanegra de la BD
     * que coincidan con la búsqueda realizada
     * @param busqueda
     * @return arreglo de objetos de tipo listanegra
     * @throw SQLException.
    */
    public ListaNegra[] obtenerTodosRegistros(String busqueda){
        ListaNegra lista[];
        conectarBD.conectar();
        int numPac = Integer.parseInt(obtenerCampo(conectarBD.RealizarConsulta(
                "select count(*) from listanegra where nombre like '%"+busqueda+"%';"),"count(*)"));
        System.out.println("num pacientes "+numPac);
        lista = new ListaNegra[numPac];
        ResultSet consulta;
        consulta = conectarBD.RealizarConsulta("select * from listanegra where nombre like '%"+busqueda+"%' ;");
        try {
            int i=0;
            while(consulta.next()){
                lista[i]=new ListaNegra();
                lista[i].setId(Integer.parseInt(consulta.getString("id")));
                lista[i].setNombre(consulta.getString("nombre"));
                lista[i].setRazon(consulta.getString("razon"));
                lista[i].setEdad(Integer.parseInt(consulta.getString("edad")));
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error en obtenerTodosRegistros (String busqueda): "+ex.getMessage());
        }
        conectarBD.desconectar();
        return lista;
    }
    
    /**
    * Método que retorna un array de listanegra almacenados en la tabla listanegra de la BD.
     * @param iduser
    * @return arreglo de objetos de tipo listanegra
    */
    public ListaNegra[] obtenerTodosRegistros(int iduser){
        ListaNegra lista[];
        conectarBD.conectar();
        int numPac = Integer.parseInt(obtenerCampo(conectarBD.RealizarConsulta("select count(*) from listanegra where iduser="+iduser+";"),"count(*)"));
        lista = new ListaNegra[numPac];
        ResultSet consulta;
        consulta = conectarBD.RealizarConsulta("select * from listanegra where iduser="+iduser+";");
        try {
            int i=0;
            while(consulta.next()){
                lista[i]=new ListaNegra();
                lista[i].setId(Integer.parseInt(consulta.getString("id")));
                lista[i].setEdad(Integer.parseInt(consulta.getString("edad")));
                lista[i].setNombre(consulta.getString("nombre"));
                lista[i].setRazon(consulta.getString("razon"));
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error en obtenerTodosRegistros(int iduser): "+ex.getMessage());
        }
        conectarBD.desconectar();
        return lista;
    }
    
    /**
     * Método que devuelve el valor de un campo espéficico que se le indique lo retorna como string
     * si la consulta cuenta con muchas filas, se quedará con el último valor
     * @param rel
     * @param campo
     * @return String
     * @throw SQLException.
    */
    public String obtenerCampo(ResultSet rel, String campo){
       String valCampo =new String();
       try{
            while(rel.next()){ 
                valCampo=rel.getString(campo);
            }
        } catch (SQLException ex) {
            System.out.println("Error en obtenerCampo: "+ex.getMessage());
        }
        return valCampo;
    }
    
    /**
     * Método que va filtrando datos de los registros mientras se teclean los datos en un jtxt
     * los resultados de la búsqueda se muestran en una tabla
     * @param pac
     * @param busqueda
     * @param iduser
    */
    public void cargarRegistrosTablasMientrasEscribe(javax.swing.JTable pac, String busqueda, int iduser){
        ListaNegra lista[];
        borrarContenidoTabla(pac);
        lista = obtenerTodosRegistro(busqueda, iduser);
        for (ListaNegra temp : lista) {
            DefaultTableModel tabla = (DefaultTableModel)pac.getModel();
            String[] r=new String[4];
            r[0] = Integer.toString(temp.getId());
            r[1] = temp.getNombre();
            r[2] = temp.getRazon();
            r[3] = Integer.toString(temp.getEdad());
            tabla.addRow(r);
        }
    }
    
    /**
    * Método que recibe una tabla para eliminar su contenido
    * @param  table
    */
    public void borrarContenidoTabla(javax.swing.JTable table){
        DefaultTableModel tab =(DefaultTableModel) table.getModel();
        while(table.getRowCount()>0){
            tab.removeRow(tab.getRowCount()-1);
        }
    }

    /**
     *
     * @param busqueda
     * @param iduser
     * @return
     */
    public ListaNegra[] obtenerTodosRegistro(String busqueda, int iduser){
        ListaNegra lista[];
        conectarBD.conectar();
        int numPac = Integer.parseInt(obtenerCampo(conectarBD.RealizarConsulta(
                "select count(*) from listanegra where nombre like '%"+busqueda+"%' and iduser="+iduser+";"),"count(*)"));
        lista = new ListaNegra[numPac];
        ResultSet consulta;
        consulta = conectarBD.RealizarConsulta("select * from listanegra where nombre like '%"+busqueda+"%' and iduser="+iduser+" ;");
        try {
            int i=0;
            while(consulta.next()){
                lista[i]=new ListaNegra();
                lista[i].setId(Integer.parseInt(consulta.getString("id")));
                lista[i].setNombre(consulta.getString("nombre"));
                lista[i].setRazon(consulta.getString("razon"));
                lista[i].setEdad(Integer.parseInt(consulta.getString("edad")));
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error obtenerTodosRegistros(String busqueda, int iduser): "+ex.getMessage());
        }
        conectarBD.desconectar();
        return lista;
    }
    
    /**
    * Método que actualiza información de un sólo registro en la base de datos
    * @param  pac
    */
    public void actualizarDatosGenerales(ListaNegra pac){
        boolean actualizado;
        conectarBD.conectar();
        actualizado=conectarBD.actualizarDatos("UPDATE listanegra\n" +
                            " SET nombre='"+pac.getNombre()+"',\n" +
                            " razon='"+pac.getRazon()+"', \n" +
                            " edad="+pac.getEdad()+"\n" +
                            " WHERE id="+pac.getId()+";");
        if(actualizado){
            JOptionPane.showMessageDialog(null, "El registro ha sido actualizado correctamente.","Actulizando información",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió un eror al actulizar","Error", JOptionPane.ERROR_MESSAGE);
        }
        conectarBD.desconectar();
    }
    
    /**
     * Método elimina la información de un registro
     * se eliminan
     * @param regEliminar
    */
    public void eliminarRegistros(ListaNegra regEliminar){
        boolean eliminado;
        conectarBD.conectar();
        eliminado = conectarBD.eliminarDatos("delete from listanegra where id="+regEliminar.getId()+";");
        if(eliminado){
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado.","Eliminando información",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió un eror al eliminar.","Error", JOptionPane.ERROR_MESSAGE);
        }
        conectarBD.desconectar();
    }
    
    /**
     * Metodo que agrega la información de un nuevo usuario a la base de datos
     * @param nick
     * @param passwd
     * @param name
     * @param lastname
     * @return
     */
    public boolean addNewUser(String nick, String passwd, String name, String lastname){
        boolean ingresado=false;
        conectarBD.conectar();
        int usrExis = Integer.parseInt(obtenerCampo(conectarBD.RealizarConsulta(
                "select count(*) from usuarios where nick like '%"+nick+"%';"),"count(*)"));
        if(usrExis==0){
            ingresado = conectarBD.agregarDatosBD("insert into usuarios (nick, passwd,nombre, apellidos) "
                    + "values('"+nick+"', '"+CifradoMD5.Cifrado(passwd)+"','"+name+"','"+lastname+"');");
            if(ingresado){
                JOptionPane.showMessageDialog(null, "Usuario añadido.","Ingresando usuario",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "El usuario ya existe.","Error", JOptionPane.ERROR_MESSAGE);
        }
        conectarBD.desconectar();
        return ingresado;
    }
    
    /**
     * Método que valida si un usuario existe o no al momento de iniciar sesión.
     * @param nick
     * @param passwd
     * @return
     */
    public Usuario validateUser(String nick, String passwd){
        Usuario userLog = new Usuario();
        conectarBD.conectar();
        int usrExis = Integer.parseInt(obtenerCampo(conectarBD.RealizarConsulta(
                "select count(*) from usuarios where nick='"+nick+"' and passwd='"+passwd+"';"),"count(*)"));
        if(usrExis==1){
            ResultSet consulta;
            consulta = conectarBD.RealizarConsulta("select * from usuarios where nick='"+nick+"';");
            try {
                while(consulta.next()){
                    userLog.setIduser(Integer.parseInt(consulta.getString("id")));
                    userLog.setApellidos(consulta.getString("apellidos"));
                    userLog.setNick(consulta.getString("nick"));
                    userLog.setPasswd(consulta.getString("passwd"));
                    userLog.setNombre(consulta.getString("nombre"));
                }
            } catch (SQLException ex) {
                System.out.println("Error en validateUser: "+ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "El usuario o contraseña incorrecto","Error", JOptionPane.ERROR_MESSAGE);
        }
        conectarBD.desconectar();
        return userLog;
    }
    
    /**
     * Método que actualiza la información de un usuario.
     * @param user
     */
    public void actualizarNombre(Usuario user){
        conectarBD.conectar();
        conectarBD.actualizarDatos("UPDATE usuarios SET nombre='"+user.getNombre()+"', apellidos='"+
                user.getApellidos()+"' WHERE id="+user.getIduser()+";");
        conectarBD.desconectar();
    }
    
    /**
     * Método que actuala la contraseña de un usuario.
     * @param user
     */
    public void cambiarPasswd(Usuario user){
        conectarBD.conectar();
        conectarBD.actualizarDatos("UPDATE usuarios SET passwd='"+user.getPasswd()+"' WHERE id="+user.getIduser()+";");
        conectarBD.desconectar();
    }
    
    /**
     * Método que guarda la fecha y datos de un evento.
     * @param even
     * @return
     */
    public boolean guardarUnEvento(Eventos even){
        conectarBD.conectar();
        boolean guardado = conectarBD.agregarDatosBD("insert into fechas_importantes "
                + "(id_user, tipo_fecha, descripcion, fecha) values("+even.getId_user()+",'"+even.getTipo_evento()+"',"
                + "'"+even.getDesc_evento()+"','"+even.getFecha_evento()+"');");
        conectarBD.desconectar();
        return guardado;
    }
    
    /**
     * Método que muestra en la tabla eventos, todos los eventos que estén en la
     * tabla eventos de la bd de un usuario específico.
     * @param fechas
     * @param iduser
     */
    public void cargarTodosEventosEnTabla(javax.swing.JTable fechas, int iduser){
        Eventos lista[];
        borrarContenidoTabla(fechas);
        lista = obtenerTodosEventosDeUnUsuario(iduser);
        Date fechaEvento = new Date();
        Calendar c;
        String fecha;
        for (Eventos temp : lista) {
            DefaultTableModel tabla=(DefaultTableModel)fechas.getModel();
            String[] r=new String[4];
            //r[0] = temp.getId_fecha();
            r[0] = temp.getTipo_evento();
            r[1] = temp.getDesc_evento();
            fechaEvento.setTime(Long.parseLong(temp.getFecha_evento()));
            c = Calendar.getInstance();
            c.setTime(fechaEvento);
            fecha = Integer.toString(c.get(Calendar.DATE))+"/"+Integer.toString(c.get(Calendar.MONTH)+1)+"/"+Integer.toString(c.get(Calendar.YEAR));
            r[2] = fecha;
            tabla.addRow(r);
        }
    }
    
    /**
     * Devuelve un arreglo de todos los eventos de un usuario específico.
     * @param iduser
     * @return
     */
    public Eventos[] obtenerTodosEventosDeUnUsuario(int iduser){
        Eventos lista[];
        conectarBD.conectar();
        int numPac = Integer.parseInt(obtenerCampo(conectarBD.RealizarConsulta(
                "select count(*) from fechas_importantes where id_user="+iduser+";"),"count(*)"));
        lista = new Eventos[numPac];
        ResultSet consulta;
        consulta = conectarBD.RealizarConsulta("select * from fechas_importantes where id_user="+iduser+" order by fecha;");
        try {
            int i=0;
            while(consulta.next()){
                lista[i]=new Eventos();
                lista[i].setId_fecha(consulta.getString("id_fecha"));
                lista[i].setId_user(consulta.getString("id_user"));
                lista[i].setTipo_evento(consulta.getString("tipo_fecha"));
                lista[i].setDesc_evento(consulta.getString("descripcion"));
                lista[i].setFecha_evento(consulta.getString("fecha"));
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error otenerTodosEventosDeUnUsuario: "+ex.getMessage());
        }
        conectarBD.desconectar();
        return lista;
    }

    /**
     * Método que actualiza la información de un evento
     * @param evento
     */
    public void actualizarUnEvento(Eventos evento){
        conectarBD.conectar();
        conectarBD.actualizarDatos("update fechas_importantes set tipo_fecha='"+evento.getTipo_evento()
                +"', descripcion='"+evento.getDesc_evento()+"', fecha='"+evento.getFecha_evento()+"' where id_fecha="+evento.getId_fecha()+";");
        conectarBD.desconectar();
    }
    
    /**
     * Método que elimina un evento específico.
     * @param evento
     */
    public void eliminarUnEvento(Eventos evento){
        boolean eliminado;
        conectarBD.conectar();
        eliminado = conectarBD.eliminarDatos("delete from fechas_importantes where id_fecha="+evento.getId_fecha()+";");
        if(eliminado){
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado.","Eliminando información",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió un eror al eliminar.","Error", JOptionPane.ERROR_MESSAGE);
        }
        conectarBD.desconectar();
    }
    
    /**
     * Método que actualiza la imagen de un usuario, debido a que la consulta es irregular
     * requiere de un método y parámetros adicionales.
     * @param infoUser
     * @param rutaImage
     */
    public void actualizarImagenUsuario(Usuario infoUser, String rutaImage){
        ByteArrayOutputStream baos = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        FileOutputStream fileOuputStream = null;
        try {
            BufferedImage originalImage = ImageIO.read(new File(rutaImage));
            baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            conectarBD.conectar();
            connection = conectarBD.getConexion();

            String insertImageSql = "UPDATE usuarios SET image=? where id=?;";
            preparedStatement = connection.prepareStatement(insertImageSql);
            preparedStatement.setBytes(1, imageInByte);
            preparedStatement.setString(2, Integer.toString(infoUser.getIduser()));

            preparedStatement.executeUpdate();
            System.out.println("Imagen guardada correctamente...");
        }catch (IOException | SQLException e) {
            System.out.println("No se pudo conectar a la base de datos" + e.getMessage());
        }finally{
            conectarBD.desconectar();
            try {
                if (baos != null) {
                        baos.close();
                }
                if (preparedStatement != null) {
                        preparedStatement.close();
                }
                if (connection != null) {
                        connection.close();
                }
                if (statement != null) {
                        statement.close();
                }
                if (resultSet != null) {
                        resultSet.close();
                }
                if (fileOuputStream != null) {
                        fileOuputStream.close();
                }
            } catch (IOException | SQLException e2) {
                System.err.println("Error en actualizarImagenUsuario: "+e2.getMessage());
            }
        }
    }
    
    /**
     * Método que obtiene la imagen alamacenada de un usuario, si hay alguna previamente
     * guardada, la devuelve como ImageIcon. Si en la base de datos no hay imagen
     * almacenada previamente, entonces se toma una de la carpeta sources, para evitar
     * guardarla en el BD.
     * @param infoUser
     * @return
     */
    public ImageIcon obtenerImagenUsuario(Usuario infoUser){
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("../images/user-not-image.png"));
        conectarBD.conectar();
        try {
            ResultSet consulta;
            consulta = conectarBD.RealizarConsulta("SELECT image FROM usuarios where id="+infoUser.getIduser()+";");
            while (consulta.next()) {
                System.out.println("Usuario con imagen...");
                Blob filenameBlob = consulta.getBlob("image");
                if(filenameBlob!=null){
                    byte[] content = filenameBlob.getBytes(1L,(int)filenameBlob.length());
                    imageIcon = new ImageIcon(content);
                }else{
                    imageIcon = new ImageIcon(getClass().getResource("../images/user-not-image.png"));
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error SQL & ClassNotFound: "+ex.getMessage());
        } finally{
            conectarBD.desconectar();
        }
        return imageIcon;
    }
    
    /**
     * Método que establece la imagen del usuario en el jlabel que recibe, 
     * ajusta la imagen al tamaño del jlabel trata de escalar.
     * @param jlbl
     * @param infoUser
     */
    public void obtenerImagenUsuario(JLabel jlbl, Usuario infoUser){
        ImageIcon imageUser = obtenerImagenUsuario(infoUser);
        Image img = imageUser.getImage();
        Image newimg = img.getScaledInstance(jlbl.getWidth(), jlbl.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING);
        imageUser = new ImageIcon(newimg);
        jlbl.setIcon(imageUser);
    }
    
    /**
     * Elimina la foto del usuario, y establece a null en la base de datos del campo
     * image, de tabla usuarios.
     * @param infoUser
     */
    public void eliminarImagenUsuario(Usuario infoUser){
        conectarBD.conectar();
        conectarBD.actualizarDatos("UPDATE usuarios SET image=null where id="+infoUser.getIduser()+";");
        conectarBD.desconectar();
    }
    
    public void leerCadConexion(String rutaArchivo){
        File f = new File(rutaArchivo);
        if(f.exists() && !f.isDirectory()) { 
            Scanner scanner;
            try {
                scanner = new Scanner(f);
                while(scanner.hasNext()){
                    String cad = scanner.nextLine();
                    String[] param = cad.split("\\|");
                    servidor = param[0];
                    usuario = param[1];
                    contrasena = param[2];
                    bd = param[3];
                }
            } catch (FileNotFoundException ex) {
                System.err.println("Error en: leerCadConexion.: "+ex.getMessage());
            }
        }else{
            System.out.println("El archivo de configuración no existe.\nGuarde una configuración previamente.");
        }
    }
}
