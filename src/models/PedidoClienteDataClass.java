package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class PedidoClienteDataClass {
    private int idPedido;
    private int estado;
    private String nombreCliente;
    private String direccion;
    private String localidad;
    private String provincia;
    private int movil;
    private LocalDate fechaPedido;
    private LocalDate fechaEntregaEstimada;
    private String comentario;
    private ArrayList<Producto> productos;

    //Constructor
    public PedidoClienteDataClass(int idPedido, int estado, String nombreCliente, String direccion, String localidad, String provincia, int movil, LocalDate fechaPedido, LocalDate fechaEntregaEstimada, String comentario, ArrayList<Producto> productos) {
        this.idPedido = idPedido;
        this.estado = estado;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.movil = movil;
        this.fechaPedido = fechaPedido;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.comentario = comentario;
        this.productos = productos;
    }


    //Getters y setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEntregaEstimada() {
        return fechaEntregaEstimada;
    }

    public void setFechaEntregaEstimada(LocalDate fechaEntregaEstimada) {
        this.fechaEntregaEstimada = fechaEntregaEstimada;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}