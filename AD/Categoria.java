package org.example;
import javax.annotation.processing.Generated;
import  javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue; //indica que el valor de la clave primaria es generada automáticamente por la BBDD.
import javax.persistence.GenerationType;
import javax.persistence.Id; //para especificar cual será la clave primaria de la entidad.
import javax.persistence.JoinColumn; //sirve para especificar que esta columna se usará para unir dos tablas en la relación.
import javax.persistence.ManyToOne; //define una entidad de muchos a uno o lo que es lo mismo N:1

@Entity

@Table(name ="Categoria")

public class Categoria {
    @Id  //con ello estoy definiendo que tengo una clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //esta anotación me hace falta para que hibernate incremente automáticamente los valores. Sustituye
    //al increment en la BBDD cuando lo generamos. Si mi clave primaria fuera nombre no haría falta poner este código.
    private int idCategoria;

    private String alimentosUltracongelados;
    private  String alimentosCongelados;
    private String alimentosRefrigerados;
    private String alimentosFrescos;
    @ManyToOne //relacion N:1 muchos a uno
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor")
    private Proveedor proveedor; // esta es la clave foránea de proveedor

    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto") //se utiliza esta columna como clave foranea para referenciar la clave primaria
    private Producto producto; // instanciamos la clase Producto con el objeto producto.

    private List<Categoria>Categorias = new ArrayList<>();

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getAlimentosUltracongelados() {
        return alimentosUltracongelados;
    }
    public String getAlimentosCongelados() {
        return alimentosCongelados;
    }

    public String getAlimentosRefrigerados() {
        return alimentosRefrigerados;
    }

    public String getAlimentosFrescos() {
        return alimentosFrescos;
    }

    public List<Categoria> getCategorias() {
        return Categorias;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setAlimentosUltracongelados(String alimentosUltracongelados) {
        this.alimentosUltracongelados = alimentosUltracongelados;
    }

    public void setAlimentosCongelados(String alimentosCongelados) {
        this.alimentosCongelados = alimentosCongelados;
    }

    public void setAlimentosRefrigerados(String alimentosRefrigerados) {
        this.alimentosRefrigerados = alimentosRefrigerados;
    }

    public void setAlimentosFrescos(String alimentosFrescos) {
        this.alimentosFrescos = alimentosFrescos;
    }

    public void setCategorias(List<Categoria> Categorias) {
        this.Categorias = Categorias;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
