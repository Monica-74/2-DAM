//Imagina que tienes tres tareas diferentes que deben ejecutarse en un orden específico.
// Cada tarea tiene un nombre y un tiempo de ejecución en segundos. Tu objetivo es implementar estas tareas utilizando hilos,
// pero asegurarte de que se ejecuten de manera secuencial.Requisitos:Crea una clase Tarea que implemente la interfaz Runnable .
// La clase Tarea debe tener dos atributos: nombre (String) y tiempoEnSegundos (int).Implementa el método run para que imprima
// un mensaje indicando que la tarea ha comenzado, duerma el hilo por el tiempo especificado, y luego imprima un mensaje indicando
// que la tarea ha terminado.En el método main, crea tres instancias de Tarea con diferentes nombres y tiempos de ejecución.
// Ejecuta las tareas de manera secuencial utilizando hilos y el método join()  para asegurarte de que cada tarea termine
// antes de que comience la siguiente.

public class Tareas implements Runnable{
    private String nombre;
    private int tiempoEnSegundos;

    public Tareas(String nombre, int tiempoEnSegundos){
        this.nombre = nombre;
        this.tiempoEnSegundos = tiempoEnSegundos;

    }

    public void hacerTareas(){
        System.out.println(nombre + " he empezado a hacer las tareas");
        try {
            Thread.sleep(tiempoEnSegundos * 1000L);
        } catch (InterruptedException e) {
            System.out.println(nombre + "interumpida la tarea");
        }
        System.out.println(nombre + " la tarea ha acabado.");

    }

    @Override
    public void run() {
        hacerTareas();

    }

    public static void main(String[] args) {

        Thread tareaMates = new Thread(new Tareas("tareaMates", 10));
        Thread tareaLengua = new Thread(new Tareas("tareaLengua",4));
        Thread tareafisica = new Thread(new Tareas("tareafisica", 5));

        tareaMates.start();
        tareafisica.start();
        tareaLengua.start();
    }
}
