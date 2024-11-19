public class RatonConcurrente extends Thread {
   private  String nombre;
   private int tiempocomer;
   public RatonConcurrente(String nombre, int tiempocomer){
       this.nombre = nombre;
       this.tiempocomer = tiempocomer;
   }

    @Override
    public void run() {
        System.out.println(nombre + " el raton comienza a comer");
        try {
            Thread.sleep(tiempocomer * 1000);
        } catch (InterruptedException e) {
            System.out.println(nombre + " se ha interrumpido la comida");
        }
        System.out.println(nombre + " el ratón ha comido. ");
    }

    public static void main(String[] args) {
       RatonConcurrente raton1 = new RatonConcurrente("raton 1",2);
       RatonConcurrente raton2 = new RatonConcurrente("raton2", 3);
       RatonConcurrente raton3 = new RatonConcurrente("raton3",8);
       RatonConcurrente raton4 = new RatonConcurrente("raton4",7);

       raton1.start();
       raton2.start();
       raton3.start();
       raton4.start();
    }
}
