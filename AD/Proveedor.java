
package org.example;
import  javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table ( name ="Proveedor")

public class Proveedor {

    private  int idProveedor;
    private int idProducto;
    private int idCategoria;
    private String nombreComercial;
    private  String emailContacto;
    private String cif;
    private List<Proveedor> Proveedores = new ArrayList<>();

    public int getIdProducto() {
        return idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }


    public int getIdProveedor() {
        return idProveedor;
    }


    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public String getCif() {
        return cif;
    }

    public List<Proveedor> getProveedores() {
        return Proveedores;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setProveedores(List<Proveedor> Proveedores) {
        this.Proveedores = Proveedores;
    }


}
