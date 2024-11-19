//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.public class dataBaseLibreria {
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.io.FileOutputStream;

public class dataBaseLibreria {  //con esta clase nos conectaremos a mi BBDD. Ejecutaremos consultas y
    // registraremos información.

    static String c_ruta_padre = "C:\\Users\\blanco.mamoi\\Documents\\AD\\Practica3.1";
    static String c_log_file = "\\logs";
    static String c_tipo_info = "I";
    static String c_tipo_error = "E";
    static String c_tipo_aviso = "W";


    // escribo en mi fichero
    private static void escribirFile(BufferedWriter v_log_buf, String v_tipo, String v_traza) {

        try {
            v_log_buf.write(v_tipo + "-" + v_traza + "\n"); //escribe la entrada de log con tipo String y mensaje
            v_log_buf.flush(); //fuerza a que la entrada de log sea inmediata.
        } catch (IOException e) { // controlamos las excepciones
            System.out.println("error de IO en el fichero de log: " + e.toString());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("error escribiendo en el fichero de log : " + e.toString());
            System.exit(1); //termina el programa.
        }

    }

    // conecto la base de datos y manejo excepciones
    public static Connection conecta_dbl(BufferedWriter v_log_buf) {
        Connection v_conexion = null;
        String v_traza = "";
        escribirFile(v_log_buf, c_tipo_info, v_traza); //intenta el registro para conectar.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //carga el controlador JDBC de MySQL.
        } catch (Exception e) { //controlamos las posibles excepciones.
            System.out.println("SQLException: " + e.getMessage());
        }
        try {
            String usr;
            v_conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Libreria", "desarrollador","1234");

            escribirFile(v_log_buf, c_tipo_info, "Conexión exitosa"); //registra la conexión exitosa
        } catch (SQLException e) { //Control de excepciones
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQEstate: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            System.out.println("SQLException: " + e.getMessage());
            escribirFile(v_log_buf, c_tipo_info, "Error en la conexión" + e.getMessage());
        }
        return v_conexion; //Devuelve un objeto Connection.
    }

    //voy a imprimir los resultados de las consultas a la BBDD.
    private static void imprimeInforme(ResultSet i_datos, BufferedWriter v_log_buf) throws SQLException {
        ResultSetMetaData v_rs_metadatos = i_datos.getMetaData(); //Obtiene metadatos sobre el conjunto de resultados.
        int v_num_cols = v_rs_metadatos.getColumnCount();
        String v_traza = "";
        escribirFile(v_log_buf, c_tipo_info, "Imprimiendo informe");//Registra el inicio de la impresión del informe.
        while ((i_datos.next())) { //Iteramos sobre los resultados, usamos el for para recorrerlos todos y después imprimimos cada fila.
            for (int i = 1; i <= v_num_cols; i++) {
                if (i > 1) System.out.print("|");
                System.out.println(i_datos.getString((i)));
            }
            System.out.println("|");
        }
        escribirFile(v_log_buf, c_tipo_info, v_traza); //Finalizamos la impresión del informe.
    }

    // lanzo la consulta
    private static void lanzarConsulta(Connection i_conexion, String i_consulta, BufferedWriter v_log_buf) throws SQLException {
        Statement v_sentencia = null;
        ResultSet v_resultado = null;

        escribirFile(v_log_buf, c_tipo_info, "lanzando la consulta" + i_consulta);
        imprimeInforme(v_resultado, v_log_buf);
        try {
            v_sentencia = i_conexion.createStatement();
            v_resultado = v_sentencia.executeQuery(i_consulta);
            imprimeInforme(v_resultado, v_log_buf);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState " + e.getSQLState());
            System.out.println("Error de Código: " + e.getErrorCode());
        } finally {
            if (v_resultado != null) {
                try {
                    v_resultado.close();
                } catch (SQLException sqlEx) {
                }
            }
            if (v_sentencia != null) {
                try {
                    v_sentencia.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        String v_ruta_log = c_ruta_padre + c_log_file;
        FileWriter v_log = new FileWriter(v_ruta_log );
        BufferedWriter v_log_Writer = new BufferedWriter(v_log);

        try {
            System.out.println("Comienza ejecución");
            escribirFile(v_log_Writer, c_tipo_info, "Iniciando ejecución");

            Connection v_con_dbl = conecta_dbl(v_log_Writer);
            //listar libros por autor
            String i_consulta = "SELECT L.titulo, L.genero, L.fecha_publicacion " +
                    "from Libros L " +
                    "join Autores A on L.autor_id = A.autor_id " +
                    "where A.nombre = autorNombre ";

            lanzarConsulta(v_con_dbl, "SELECT * from libreria.autores;", v_log_Writer);
            System.out.println("Fin de la ejecución");

        } catch (Exception e) {
            System.out.println("Error en la ejecución");

        } finally {
            if (v_log_Writer != null) v_log_Writer.close();
        }

    }


}