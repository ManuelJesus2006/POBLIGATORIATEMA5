package controlador;

import data.DataProductos;
import models.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;
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
        clientes = new ArrayList<>();
        trabajadores = new ArrayList<>();
        admins = new ArrayList<>();
        catalogo = new ArrayList<>();
        mock();
    }

    private void mock() {
        //Clientes
        clientes.add(new Cliente(generaIdCliente(), "hola@hola", "3421", "Manolo", "Martos", "Jaén", "avda moris n32", 653423428));
        clientes.add(new Cliente(generaIdCliente(), "jl@jl", "1234", "Jl", "Madrid", "Madrid", "avda gran vía", 456234244));
        trabajadores.add(new Trabajador("Carlos", "1111", "adios@adios", 555443322));
        admins.add(new Admin("root", "root", "root@root"));
        catalogo = DataProductos.getProductosMock();
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
        for (Admin admin : admins) {
            if (admin.login(email, clave)) return admin;
        }

        for (Trabajador trabajador : trabajadores) {
            if (trabajador.login(email, clave)) return trabajador;
        }

        for (Cliente cliente : clientes) {
            if (cliente.login(email, clave)) return cliente;
        }
        return null;
    }

    public boolean addProductoCarrito(Cliente cliente, int idProducto) {

    }

    public Producto buscaProductoById(int id) {

    }

    //Método para confirmar cualquier pedido de cliente
    public boolean confirmaPedidoCliente(int id) {
        Cliente temp = buscaClienteById(id);
        if (temp == null) return false;
        temp.getPedidos().add(new Pedido(LocalDate.now(), null, null, 0,
                null, temp.getCarro()));
        return true;
    }

    public Trabajador buscaTrabajadorCandidatoParaAsignar() {

    }

    public boolean hayEmpateTrabajadoresCandidatos(Trabajador candidato) {

    }

    public Cliente buscaClienteById(int idCliente) {
        for (Cliente cliente : clientes){
            if (cliente.getId() == idCliente) return cliente;
        }
        return null;
    }

    public ArrayList<Producto> buscaProductosByMarca(String marca) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : catalogo){
            if (producto.getMarca().contains(marca)) productosEncontrados.add(producto);
        }
        return productosEncontrados;
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
        return (int) (Math.random() * 100000);
    }

    private int generaIdProducto() {

    }

    private int generaIdPedido() {

    }

    private int generaIdAdmin() {

    }

    private int generaIdTrabajador() {

    }

    public void verCatalogo() {

    }

    public boolean compruebaCorreos(String correoTeclado) {
        for (Admin admin : admins) {
            if (admin.getEmail().equals(correoTeclado)) return true;
        }

        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getEmail().equals(correoTeclado)) return true;
        }

        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(correoTeclado)) return true;
        }

        return false;
    }
}
