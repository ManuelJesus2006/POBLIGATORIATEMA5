package models;

import utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    //Atributos
    private int id;
    private LocalDate fechaPedido;
    private LocalDate fechaEntregaEstimada;
    private int estado;
    private String comentario;
    private ArrayList<Producto> productos;

    //Constructor
    public Pedido(LocalDate fechaPedido, LocalDate fechaEntregaEstimada, int estado, String comentario, ArrayList<Producto> productos) {
        this.fechaPedido = fechaPedido;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.estado = estado;
        this.comentario = comentario;
        this.productos = productos;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // Otros metodos
  /*  public boolean cambiaEstado(int nuevoEstado) {

    }

    public boolean cambiaFechaEntrega(LocalDate nuevaFecha) {

    }*/

    //Deveuelve el precio sin IVA de un pedido concreto
    public float calculaTotalPedidoSinIVA() {
        float sumatorio = 0;
        for (Producto p : productos){
            sumatorio += p.getPrecio();
        }
        return sumatorio;
    }

    //Devuelve el IVA del pedido concreto
    public float calculaIVAPedido(int IVA) {
        return calculaTotalPedidoSinIVA() * (float)IVA/100;
    }

    //Devuelve el precio con el IVA añadido
    public float calculaTotalPedidoConIVA(int IVA) {
        return calculaTotalPedidoSinIVA()+calculaIVAPedido(Utils.IVA);
    }

    /*public int numArticulos() {

    }

    public Producto buscaProducto(int idProducto) {

    }

    public boolean addProducto(Producto producto) {

    }*/

    //Metodo que pinta los datos del pedido
   public String pintaPedidoCorreo() {
        String salida = "";
       /*  salida += "\n\n";
        salida += "==========\tPedido " + id + "\t===========<br>";
        salida += "Estado: " + estado + "<br>";
        salida += "Fecha del pedido: " + fechaPedido + "<br>";
        salida += "Fecha de entrega estimada: " + fechaEstimada + "<br>";
        salida += "Comentario del pedido: " + (comentario == null ? "No hay comentarios asignados" : comentario) + "<br>";
        salida += "Detalles del pedido:<br>";
        salida += (producto1 == null ? "" : "\t" + pintarProducto(producto1) + "<br>");
        salida += (producto2 == null ? "" : "\t" + pintarProducto(producto2) + "<br>");
        salida += (producto3 == null ? "" : "\t" + pintarProducto(producto3) + "<br>");
        salida += "<hr>";
        salida += "Total pedido: " + sumarPrecioProductos() + "€<br>";
        salida += "<br>";*/

        return salida;
    }

    @Override
    public String toString() {
       String resultado = "";
        resultado += "====== PEDIDO " + id + "======\n";
        resultado += "Fecha de pedido: " + fechaPedido + "\n";
        resultado += "Fecha de entrega: " + fechaEntregaEstimada + "\n";
        resultado += "Estado " + devuelveEstado(estado) + "\n";
        resultado += "Productos " + productos + "\n";
        return resultado;
    }

    private String devuelveEstado(int estado) {
       switch (estado){
           case 1: return "En preparación";
           case 2: return "Enviado";
           case 3: return "Entregado";
           case 4: return "Cancelado";
           default: return "Creado";
       }
    }
}
