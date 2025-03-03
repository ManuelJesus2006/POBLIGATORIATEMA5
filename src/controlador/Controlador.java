package controlador;

import models.*;

import java.util.ArrayList;
import java.util.Objects;

public class Controlador {
    // Atributos
    private ArrayList<Cliente> clientes;
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<Admin> admins;
    private ArrayList<Producto> catalogo;

    //Constructor
    public Controlador() {

    }

    // Getters y Setters
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Producto> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Producto> catalogo) {
        this.catalogo = catalogo;
    }


    // Otros metodos
    public Object login(String email, String clave) {

    }

    public boolean addProductoCarrito(Cliente cliente, int idProducto) {

    }

    public Producto buscaProductoById(int id) {

    }

    public boolean confirmaPedidoCliente(int id) {

    }

    public Trabajador buscaTrabajadorCandidatoParaAsignar() {

    }

    public boolean hayEmpateTrabajadoresCandidatos(Trabajador candidato) {

    }

    public Cliente buscaClienteById(int idCliente) {

    }

    public ArrayList<Producto> buscaProductosByMarca(String marca) {

    }

    public ArrayList<Producto> buscaProductosByModelo(String modelo) {

    }

    public ArrayList<Producto> buscaProductosByDescripcion(String descripcion) {

    }

    public ArrayList<Producto> buscaProductosByTermino(String termino) {

    }

    public ArrayList<Producto> buscaProductosByPrecio(float precioMin, float precioMax) {

    }

    public boolean editarProducto(Producto p) {

    }

    public  ArrayList<Pedido> getTodosPedidos() {

    }

    public int numPedidosTotales() {

    }

    public Pedido buscaPedidoById(int idPedido) {

    }

    public boolean cambiaEstadoPedido(int idPedido, int nuevoEstado) {

    }

    public boolean nuevoTrabajador(String email, String clave, String nombre, int movil) {

    }

    public Trabajador buscaTrabajadorAsignadoAPedido(int idPedido) {

    }

    public ArrayList<Pedido> pedidosSinTrabajador(int id) {

    }

    public int numPedidosSinTrabajador(){

    }

    public boolean asignaPedido(int idPedido, int idTrabajador) {

    }

    public ArrayList<PedidoClienteDataClass> getPedidosAsignadosTrabajador(int idTrabajador) {

    }

    public Trabajador buscaTrabajadorByID(int idTrabajador) {

    }

    public Admin buscaAdminById(int idAdmin) {

    }

    public Pedido buscaPedidoAsignadoTrabajador(int idTrabajador, int idPedido) {

    }

    public ArrayList<PedidoClienteDataClass> getPedidosCompletadosTrabajador(int idTrabajador) {

    }

    public ArrayList<PedidoClienteDataClass> getPedidosAsignadosYCompletados(int idTrabajador) {

    }

    private int generaIdCliente() {

    }

    private int generaIdProducto() {

    }

    private int generaIdPedido() {

    }

    private int generaIdAdmin() {

    }

    private int generaIdTrabajador() {

    }
}
