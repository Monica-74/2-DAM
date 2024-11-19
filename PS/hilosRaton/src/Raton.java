//1.Ejecución secuencial
//Tenemos una única clase (Ratón) que tiene 2 atributos (nombre y tiempo en segundos que tarda en comer)
//En el método main se crean varios objetos de Ratón y se invoca al método comer de cada uno de ellos.
//El método comer de Ratón sólo muestra un texto por pantalla cuando comienza, realiza una pausa
//de duración segundos (con el método sleep de Thread) y finalmente, muestra otro texto por
//pantalla cuando termina de comer
public class Raton {
    private String nombre;
    private int tiempoComer;

    public Raton(String nombre, int tiempoComer) {
        this.nombre = nombre;
        this.tiempoComer = tiempoComer;
    }



    public void comer() {
        System.out.println(nombre + " ha comenzado a comer.");
        try {
            Thread.sleep(tiempoComer * 1000); //convertir seg a miliseg
        } catch (InterruptedException e) {
            System.out.println(nombre + "fue interrumpido mientras comía.");
        }
        System.out.println(nombre + " ha terminado de comer");
    }


    public static void main(String[] args) {
        Raton raton1 = new Raton("Raton 1", 3);
        Raton raton2 = new Raton("Raton 2", 1);
        Raton raton3 = new Raton("Raton 3",6);

        raton1.comer();
        raton2.comer();
        raton3.comer();


    }
}
