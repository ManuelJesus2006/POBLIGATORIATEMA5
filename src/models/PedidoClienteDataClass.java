package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class PedidoClienteDataClass {
    private int idCliente;
    private String email;
    private String clave;
    private String nombre;
    private String localidad;
    private String provincia;
    private String direccion;
    private int movil;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Producto> carro;
    private int idPedido;
    private LocalDate fechaPedido;
    private LocalDate fechaEntregaEstimada;
    private LocalDate deliveryDAte;
    private int estado;
    private String comentario;
    private ArrayList<Producto> productos;

    //Constructor
    public PedidoClienteDataClass(int idCliente, String email, String clave, String nombre, String localidad, String provincia, String direccion, int movil, ArrayList<Pedido> pedidos, ArrayList<Producto> carro, int idPedido, LocalDate fechaPedido, LocalDate fechaEntregaEstimada, LocalDate deliveryDAte, int estado, String comentario, ArrayList<Producto> productos) {
        this.idCliente = idCliente;
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;
        this.localidad = localidad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.movil = movil;
        this.pedidos = pedidos;
        this.carro = carro;
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.deliveryDAte = deliveryDAte;
        this.estado = estado;
        this.comentario = comentario;
        this.productos = productos;
    }

    //Getters y setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Producto> getCarro() {
        return carro;
    }

    public void setCarro(ArrayList<Producto> carro) {
        this.carro = carro;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public LocalDate getDeliveryDAte() {
        return deliveryDAte;
    }

    public void setDeliveryDAte(LocalDate deliveryDAte) {
        this.deliveryDAte = deliveryDAte;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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
