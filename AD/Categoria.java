package org.example;
import  javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Categoria")


public class Categoria {
    private String alimentosUltracongelados;
    private  String alimentosCongelados;
    private String alimentosRefrigerados;
    private String alimentosFrescos;
    private int idProveedor;
    private int idProducto;
    private int idCategoria;

    private List<Categoria>Categorias = new ArrayList<>();

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getAlimentosUltracongelados() {
        return alimentosUltracongelados;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public int getIdProducto() {
        return idProducto;
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

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


}