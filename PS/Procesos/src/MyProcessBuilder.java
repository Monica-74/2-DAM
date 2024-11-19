
//PROCESOS
// Instanciar el lanzador de procesos
//construir el comando a ejecutar
//Lanzar el proceso/comando
//Obtener el id del proceso
//Destruir el proceso


import java.io.IOException;

public class MyProcessBuilder {
    public static void main(String[] args)throws IOException, InterruptedException {
        // Instanciar el lanzador de procesos
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Construir el comando a ejecutar
        processBuilder.command("notepad.exe"); // Aquí puedes poner cualquier comando que desees ejecutar

        Process process = null;
        try {
            // Lanzar el proceso/comando
            process = processBuilder.start();
            System.out.println("Proceso iniciado.");

            // Obtener el ID del proceso
            long processId = process.pid();
            System.out.println("ID del proceso: " + processId);
            // Esperar un poco antes de destruir el proceso (por ejemplo, 5 segundos)
            Thread.sleep(5000);

            // Destruir el proceso
            process.destroy();
            System.out.println("Proceso destruido.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



