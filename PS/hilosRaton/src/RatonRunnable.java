public class RatonRunnable implements Runnable {

    private String nombre;
    private int tiempoComer;

    public RatonRunnable(String nombre, int tiempoComer){
        this.nombre = nombre;
        this.tiempoComer = tiempoComer;

    }
    public void comer() throws InterruptedException {
        System.out.println(nombre + " comienza a comer.");
        try {
            java.lang.Thread.sleep(tiempoComer * 1000L);
        }catch (InterruptedException e){
            System.out.println(nombre + " se interrumpe mientras come.");
        }
        System.out.println(nombre + " ha terminado de comer.");
    }

    @Override
    public void run() {
        try {
            comer();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Thread raton1 = new Thread(new RatonRunnable("raton1", 2));
        Thread raton2 = new Thread(new RatonRunnable("raton2",3));
        Thread raton3 = new Thread(new RatonRunnable("raton3", 1));
        Thread raton4 = new Thread(new RatonRunnable("raton4", 4));

        raton1.start();
        raton2.start();
        raton3.start();
        raton4.start();
    }


}
