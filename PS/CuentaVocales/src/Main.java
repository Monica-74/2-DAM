import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Uso: java Main <classpath>");
            return;
        }
        String classpath = args[0];
        System.out.println("el cp es: " +classpath);
        int contador = 0;
        String fichero = "C:\\Users\\Dell\\IdeaProjects\\CuentaVocales\\src\\long.txt";
        char[] vocales = {'a', 'A', 'e', 'E', 'I', 'i', 'o', 'O', 'u', 'U'};

        for (char vocal : vocales) {
            ProcessBuilder pb = new ProcessBuilder("java","-cp",classpath,"contador", "C:\\Users\\Dell\\IdeaProjects\\CuentaVocales\\src\\long.txt",String.valueOf(vocal),fichero,fichero);
            try {
                Process proceso = pb.start();
                BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String linea;
                while ((linea = br.readLine()) != null){
                    contador += Integer.parseInt(linea.trim());
                }
                proceso.waitFor();

            } catch (IOException  | InterruptedException e) {
                System.out.println("Error al iniciar el proceso" + vocal + ":" + e.getMessage());
            }
        }

        System.out.println("Vocales totales : " + contador);


    }

}


