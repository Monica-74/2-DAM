
import java.io.*;

public class contador {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java contador <nombreFicheroEntrada> <vocal>");
            return;
        }
        String fichero = args[0];
        char vocal = args[1].charAt(0);
        int contador = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea ;
            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    char actual = linea.charAt(i);
                    if (Character.toLowerCase(actual) == Character.toLowerCase(vocal)) {
                        contador++;

                    }
                }

            }
            //br.close();
            System.out.println(contador);

        } catch (IOException e) {
            System.out.println("No se pudo procesar el fichero " + fichero + ":" + e.getMessage());
        }
    }
}

