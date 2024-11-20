package org.example;
import  javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="Producto")

public class Producto {
    private String nombreProducto;
    private float precio;
    private int cantidad;
    private int IdProveedor;
    private int IdCategoria;
    private int idProducto;
    private List<Producto>Productos = new ArrayList<>();

    public String getNombreProducto() {
        return nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setIdProveedor(int idProveedor) {
        this.IdProveedor = idProveedor;
    }

    public void setIdCategoria(int idCategoria) {
        this.IdCategoria = idCategoria;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
