package controlador;

import data.DataProductos;
import models.*;

import java.time.LocalDate;
import java.util.ArrayList;

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
        //clientes.add(new Cliente(generaIdCliente(), "hola@hola", "3421", "Manolo", "Martos", "Jaén", "avda moris n32", 653423428));
        //clientes.add(new Cliente(generaIdCliente(), "jl@jl", "1234", "Jl", "Madrid", "Madrid", "avda gran vía", 456234244));
        //trabajadores.add(new Trabajador(generaIdTrabajador(), "Carlos", "1111", "adios@adios", 555443322));
        admins.add(new Admin(generaIdAdmin(), "root", "root", "root@root"));
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

    // Metodo que sirve para registrarnos, devolveremos un cliente con su correo y clave, en caso de trabajadores y administradores
    // nos logueamos con su nombre y clave, en caso de que coincida alguno devolveremos el rol de lo que ha coincidido
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
        Producto temp = buscaProductoById(idProducto);
        if (temp == null) return false;
        cliente.getCarro().add(temp);
        return true;
    }

    // Metodo que busca un producto por ID
    public Producto buscaProductoById(int id) {
        for (Producto producto : catalogo){
            if (producto.getId() == id) return producto;
        }
        return null;
    }

    // Metodo para confirmar cualquier pedido de cliente
    public boolean confirmaPedidoCliente(int id) {
        Cliente temp = buscaClienteById(id);
        if (temp == null) return false;
        temp.getPedidos().add(new Pedido(LocalDate.now(), null, 0, null, temp.getCarro()));
        return true;
    }

    /*public Trabajador buscaTrabajadorCandidatoParaAsignar() {

    }

    public boolean hayEmpateTrabajadoresCandidatos(Trabajador candidato) {

    }*/

    // Metodo que busca un cliente por su id, y lo devuelve
    public Cliente buscaClienteById(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idCliente) return cliente;
        }
        return null;
    }

    // Metodo que busca un admin por su id, y lo devuelve
    public Admin buscaAdminById(int idAdmin) {
        for (Admin admin : admins) {
            if (admin.getId() == idAdmin) return admin;
        }
        return null;
    }

    // Metodo que busca productos por su marca, devolvemos un Array
    public ArrayList<Producto> buscaProductosByMarca(String marca) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : catalogo) {
            if (producto.getMarca().toLowerCase().contains(marca.toLowerCase())) productosEncontrados.add(producto);
        }
        return productosEncontrados;
    }

    // Metodo que busca productos por su modelo, devolvemos un Array
    public ArrayList<Producto> buscaProductosByModelo(String modelo) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : catalogo) {
            if (producto.getModelo().toLowerCase().contains(modelo.toLowerCase())) productosEncontrados.add(producto);
        }
        return productosEncontrados;
    }

    // Metodo que busca productos por su descripcion, devolvemos un Array
    public ArrayList<Producto> buscaProductosByDescripcion(String descripcion) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : catalogo) {
            if (producto.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                productosEncontrados.add(producto);
        }
        return productosEncontrados;
    }

    /*public ArrayList<Producto> buscaProductosByTermino(String termino) {

    }*/

    // Metodo que busca productos por su precio, devolvemos un Array
    public ArrayList<Producto> buscaProductosByPrecio(float precioMin, float precioMax) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : catalogo){
            if (producto.getPrecio() >= precioMin && producto.getPrecio() <= precioMax) productosEncontrados.add(producto);
        }
        return productosEncontrados;
    }


    /*

    public boolean editarProducto(Producto p) {

    }

    public  ArrayList<Pedido> getTodosPedidos() {

    }

    public int numPedidosTotales() {

    }

    public Pedido buscaPedidoById(int idPedido) {

    }

    public boolean cambiaEstadoPedido(int idPedido, int nuevoEstado) {

    }*/

    // Metodo que añade un trabajador a trabajadores
    public boolean nuevoTrabajador(String email, String clave, String nombre, int movil) {
        return trabajadores.add(new Trabajador(generaIdTrabajador(), nombre, clave, email, movil));
    }

    // Metodo que añade un cliente a clientes
    public boolean nuevoCliente(String email, String clave, String nombre, String localidad, String provincia, String direccion, int movil) {
        return clientes.add(new Cliente(generaIdCliente(), email, clave, nombre, localidad, provincia, direccion, movil));
    }

/*

    public Trabajador buscaTrabajadorAsignadoAPedido(int idPedido) {

    }

    public ArrayList<Pedido> pedidosSinTrabajador(int id) {

    }

    public int numPedidosSinTrabajador(){

    }

    public boolean asignaPedido(int idPedido, int idTrabajador) {

    }

    public ArrayList<PedidoClienteDataClass> getPedidosAsignadosTrabajador(int idTrabajador) {

    }*/

    // Metodo que busca un trabajador por su id, y lo devuelve
    public Trabajador buscaTrabajadorById(int idTrabajador) {
        for (Trabajador t : trabajadores) {
            if (t.getId() == idTrabajador) return t;
        }

        return null;
    }
/*

    public Pedido buscaPedidoAsignadoTrabajador(int idTrabajador, int idPedido) {

    }

    public ArrayList<PedidoClienteDataClass> getPedidosCompletadosTrabajador(int idTrabajador) {

    }

    public ArrayList<PedidoClienteDataClass> getPedidosAsignadosYCompletados(int idTrabajador) {

    }*/

    // Metodo que genera una id aleatoria para el cliente entre el 0 y 99999
    private int generaIdCliente() {
        return (int) (Math.random() * 100000);
    }

    // Metodo que genera una id aleatoria para el producto entre el 500000 y 599999
    private int generaIdProducto() {
        return (int) (Math.random() * 100000) + 500000;
    }

    // Metodo que genera una id aleatoria para el pedido entre el 600000 y 699999
    private int generaIdPedido() {
        return (int) (Math.random() * 100000) + 600000;
    }

    // Metodo que genera una id aleatoria para el admin entre el 200000 y 299999
    private int generaIdAdmin() {
        return (int) (Math.random() * 100000) + 200000;
    }

    // Metodo que genera una id aleatoria para el admin entre el 100000 y 199999
    private int generaIdTrabajador() {
        return (int) (Math.random() * 100000) + 100000;
    }

    // Metodo que le pasan un correo, y comprueba si coincide con el correo de un admin, trabajador o cliente
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

    // Metodo que comprueba el token de un Trabajador
    public boolean compruebaTokenTrabajador(Trabajador trabajador, String tokenTeclado) {
        for (Trabajador t : trabajadores) {
            if (t.getToken().equals(tokenTeclado)) {
                trabajador.setValid(true);
                return true;
            }
        }
        return false;
    }

    // Metodo que genera un Token aleatorio
    public String generaTokenCliente(Cliente cliente) {
        if (cliente == null) return "";
        String token = "";
        token = "JM-" + (int) (Math.random() * 99999999);
        cliente.setToken(token);
        cliente.setValid(false);
        return token;
    }

    // Metodo que genera un Token aleatorio
    public String generaTokenTrabajador(Trabajador trabajador) {
        if (trabajador == null) return "";
        String token = "";
        token = "JM-" + (int) (Math.random() * 99999999);
        trabajador.setToken(token);
        trabajador.setValid(false);
        return token;
    }

    // Metodo que comprueba el Token de un cliente
    // TODO comprobar
    public boolean compruebaTokenCliente(Cliente cliente, String tokenTeclado) {
        if (cliente.getToken().equals(tokenTeclado)) {
            cliente.setValid(true);
            return true;
        } else cliente.setValid(false);
        return false;
    }
}
