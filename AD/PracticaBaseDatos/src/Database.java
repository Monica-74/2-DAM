import java.io.Writer;
import java.io.Serializable;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection; // Se utiliza para establecer una conexión con una base de datos específica y gestionar transacciones.
import java.sql.DriverManager;// Se utiliza para establecer una conexión con una base de datos mediante el método `getConnection()`, que devuelve un objeto `Connection`.
import java.sql.SQLException;//Se utiliza para capturar y manejar errores relacionados con la base de datos, como problemas de conexión o errores en las consultas SQL.
import java.sql.Statement;//Se utiliza para ejecutar consultas SQL estáticas y obtener los resultados de estas consultas.
import java.sql.ResultSet;//Representa el conjunto de resultados de una consulta SQL.
import java.sql.ResultSetMetaData;//proporciona información sobre el conjunto de resultados, como el número de columnas, los nombres de las columnas, los tipos de datos de las columnas, etc.


public class Database {

    static String c_ruta_padre = "C:\\Users\\blanco.mamoi\\IdeaProjects\\AD\\PracticaBaseDatos\\src";
    static String c_log_file = "//log_data-base";
    static String c_tipo_info = "I";
    static String c_tipo_error = "E";
    static String c_tipo_aviso = "W";

    private static void escribe_log(BufferedWriter v_log_buf, String v_tipo, String v_traza) {
        Date v_fecha_actual = new Date();
        DateFormat v_fecha_hora_actual = new SimpleDateFormat("yyyyMMdd_HHmmss");

        try {
            v_log_buf.write(v_fecha_hora_actual.format(v_fecha_actual) + "-" + v_tipo + "-" + v_traza + "\n");
            v_log_buf.flush();
        } catch (IOException e) {
            System.out.println("error de IO en el fichero de log: " + e.toString());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("error escribiendo en el fichero de log : " + e.toString());
            System.exit(1);
        }
    }

    private static Connection conecta_db(BufferedWriter v_log_buf) {
        Connection v_conexion = null;
        String v_traza = "";
        escribe_log(v_log_buf, c_tipo_info, v_traza);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
            escribe_log(v_log_buf, c_tipo_error, "Error estableciendo conexion");
        }
        try {
            String usr;
            v_conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "1234"); //esto es un socket  la contraseña tiene que ir encriptada en los proyectos habrá que crear un metodo para ello");
            escribe_log(v_log_buf, c_tipo_info, v_traza);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLstate: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println("SQLException: " + ex.getMessage());
            escribe_log(v_log_buf, c_tipo_info, "error estableciedo conexion " + ex.getMessage());
        }
        return v_conexion;
    }
    private static void imprimeInforme(ResultSet i_datos, BufferedWriter v_log_buf) throws SQLException {
        ResultSetMetaData v_rs_metadatos = i_datos.getMetaData();
        int v_num_cols = v_rs_metadatos.getColumnCount();
        String v_traza = "";
        escribe_log(v_log_buf, c_tipo_info, "Imprimiendo informe");
        while ((i_datos.next())) {
            for (int i = 1; i <= v_num_cols; i++) {
                if (i > 1) System.out.print("|");
                System.out.println(i_datos.getString((i)));
            }
            System.out.println("");
        }
        escribe_log(v_log_buf, c_tipo_info, v_traza);

    }
    private static void lanzaConsulta(Connection i_conexion, String i_consulta, BufferedWriter v_log_buf) throws SQLException {
        Statement v_sentencia = null;
        ResultSet v_resultado = null;

        escribe_log(v_log_buf, c_tipo_info, "lanzando consulta" + i_consulta);
        imprimeInforme(v_resultado,v_log_buf);
        try {
            v_sentencia = i_conexion.createStatement();
            v_resultado = v_sentencia.executeQuery(i_consulta);
           // String v_traza = "";
            //escribe_log(v_log_buf, c_tipo_info, v_traza);
            imprimeInforme(v_resultado, v_log_buf);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
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

    public static void main(String[] args) throws Exception {

        String v_ruta_log = c_ruta_padre + "\\Logs";
        Date v_fecha_actual = new Date();
        DateFormat v_fecha_hora_actual = new SimpleDateFormat("yyyyMMdd_HHmmss");
        FileWriter v_log = new FileWriter(v_ruta_log + c_log_file);
        BufferedWriter v_log_Writer = new BufferedWriter(v_log);


        try {
            System.out.println("Comienza ejecución");
            String v_traza = "Iniciando ejecución";
            escribe_log(v_log_Writer, c_tipo_info, v_traza);

            Connection v_con_db = conecta_db(v_log_Writer);
            String i_consulta = "SELECT c.Nombre AS País, COUNT(ci.CodigoPais) AS NumeroDeCiudadanos" +
            "FROM pais c" +
            "JOIN ciudadano ci ON c.Codigo = ci.CodigoPais"  +
            "GROUP BY c.Nombre" +
            "ORDER BY NumeroDeCiudadanos DESC" +
            "LIMIT 1";

            lanzaConsulta(v_con_db, "SELECT Code, Name, Continent FROM world.country LIMIT 5;", v_log_Writer);
            System.out.println("Fin de la ejecucion");

        } catch (Exception e) {
            System.out.println("error en la ejecución");

        } finally {
            if (v_log_Writer != null) v_log_Writer.close();
        }
    }
}















