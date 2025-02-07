package InterfazGrafica2;

public class Alumno {
  private String nombre;
  private String direccion;
  private String estadoMAtricula;

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEstadoMAtricula() {
        return estadoMAtricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstadoMAtricula(String estadoMAtricula) {
        this.estadoMAtricula = estadoMAtricula;
    }

    public Alumno(String nombre, String direccion, String estadoMAtricula){

      this.direccion = direccion;
      this.nombre = nombre;
      this.estadoMAtricula= estadoMAtricula;
  }
}
