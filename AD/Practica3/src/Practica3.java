import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.io.*;
import java.nio.file.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.io.BufferedOutputStream;


public class Practica3 {
            final static String c_ruta_padre = "C:\\Users\\Dell\\Downloads\\PROGRAM\\SGP\\AD";
            final static String c_log_file = "//log_mueve_fichero";
            final static String c_tipo_info = "I";
            final static String c_tipo_error = "E";
            final static String c_tipo_aviso = "W";

            public static void main(String[] args) throws Exception {


                //Ruta origen
                String v_tipo = null;
                String v_traza = null;
                String v_ruta_origen = c_ruta_padre + "//Origen";
                //Ruta destino
                String v_ruta_destino = c_ruta_padre + "//Destino";
                //Ruta Logs
                String v_ruta_log = c_ruta_padre + "//Log";


                Date v_fecha = new Date();
                DateFormat v_fecha_hora = new SimpleDateFormat("yyyyMMdd_HHmmss");
                FileWriter v_file_log = new FileWriter(v_ruta_log + c_log_file + v_fecha_hora.format(v_fecha) + ".log");
                BufferedWriter v_log_Writer = new BufferedWriter(v_file_log);
                System.out.println("Comienza la ejecución");
                File v_file_origFile = new File(v_ruta_origen);
                File v_file_list[] = v_file_origFile.listFiles();
                for (int i = 0; i < v_file_list.length; i++) {

                    File v_file = v_file_list[i];
                    System.out.println("Procesando archivo: " + v_file.toString());
                }

                escribe_log(v_log_Writer, c_tipo_info, v_traza);

                if (v_file_list == null || v_file_list.length == 0) {
                    System.out.println("La ruta origen está vacía");
                    for (int i = 0; i < v_file_list.length; i++) {

                        File v_file = v_file_list[i];
                        System.out.println("Procesando archivo: " + v_file.toString());
                        try {

                            Files.copy(v_file_origFile.toPath(), (new File(v_ruta_destino + v_file.getName())).toPath(), StandardCopyOption.REPLACE_EXISTING);
                            Thread.sleep((Duration.ofMillis(2000)));
                            System.out.println("Fichero copiado a " + v_ruta_destino);

                            //int i = 0;
                            if (i == 1) throw new Exception("Se ha producido un error forzado");
                            //BufferedWriter v_log_Writer;
                        } catch (UnsupportedOperationException e) {
                            escribe_log(v_log_Writer, c_tipo_error, "Error copiando-Operación no soportada: " + e.getMessage());
                        } catch (FileAlreadyExistsException e) {
                            escribe_log(v_log_Writer, c_tipo_error, "Error copiando-Fichero ya existe: " + e.getMessage());
                        } catch (DirectoryNotEmptyException e) {
                            escribe_log(v_log_Writer, c_tipo_error, "Error copiando-Directorio no vacío: " + e.getMessage());
                        } catch (IOException e) {
                            escribe_log(v_log_Writer, c_tipo_error, "Error copiando-Error IO: " + e.getMessage());
                        } catch (Exception e) {
                            escribe_log(v_log_Writer, c_tipo_error, "Error copiando: " + e.getMessage());
                        }


                    }

                } else {
                    System.out.println("La ruta contiene : " + v_file_list.length + " archivos");

                    if (v_file_origFile.isFile()) {
                        System.out.println("El archivo es un directorio ");

                    } else {
                        System.out.println("Es un fichero");
                        System.out.println("Copiando fichero");
                    }


                    Date v_fecha_actual = new Date();
                    DateFormat v_fecha_hora_actual = new SimpleDateFormat("yyyyMMdd_HHmmss");

                    try {
                        v_log_Writer.write(v_fecha_hora_actual.format(v_fecha_actual) + "-" + v_tipo + "-" + v_traza + "\n");
                        BufferedOutputStream v_log_buf = null;
                        v_log_buf.flush();
                    } catch (Exception e) {
                        System.out.println("Error escribiendo en el fichero de log: " + e.toString());
                    }
                    return;

                }

                //private static void escribe_log (BufferedWriter vLogWriter, String cTipoInfo, String vTraza){
                //}
            }

            public static void escribe_log(BufferedWriter v_log_Writer, String c_tipo_info, String v_traza) {
                try {
                    String mensaje = "información adicional";
                    v_log_Writer.write(c_tipo_info + ": " + mensaje + " - Tipo de excepción: " + e.getClass().getName() + "\n");
                    v_log_Writer.flush();
                } catch (IOException ioException) {
                    System.out.println("Error escribiendo en el log: " + ioException.getMessage());
                }
            }
        }


