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
        clientes.add(new Cliente(generaIdCliente(), "hola@hola", "3421", "Manolo", "Martos", "Jaén", "avda moris n32", 653423428));
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

    // Metodo que añade un producto al carrito
    public boolean addProductoCarrito(Cliente cliente, int idProducto) {
        Producto temp = buscaProductoById(idProducto);
        if (temp == null) return false;
        return cliente.getCarro().add(temp);
    }

    // Metodo que busca un producto por ID
    public Producto buscaProductoById(int id) {
        for (Producto producto : catalogo) {
            if (producto.getId() == id) return producto;
        }
        return null;
    }

    // Metodo para confirmar cualquier pedido de cliente
    public boolean confirmaPedidoCliente(int id) {
        Cliente temp = buscaClienteById(id);
        if (temp == null) return false;
        temp.getPedidos().add(new Pedido(generaIdPedido(), LocalDate.now(), null, 0, null, temp.getCarro()));
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
        for (Producto producto : catalogo) {
            if (producto.getPrecio() >= precioMin && producto.getPrecio() <= precioMax)
                productosEncontrados.add(producto);
        }
        return productosEncontrados;
    }

    /*public boolean editarProducto(Producto p) {

    }*/

    // Metodo que devuelve todos los pedidos que haya
    public ArrayList<Pedido> getTodosPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        for (Cliente c : clientes) {
            if (!c.getPedidos().isEmpty()) pedidos.addAll(c.getPedidos());
        }

        return pedidos;
    }

    // Metodo que cuenta los pedidos totales
    public int numPedidosTotales() {
        int cont = 0;

        for (Cliente c : clientes) {
            if (c.getPedidos() != null) cont++;
        }
        return cont;
    }

    // Metodo que busca un pedido por su ID
    public Pedido buscaPedidoById(int idPedido) {
        for (Pedido p : getTodosPedidos()) {
            if (p.getId() == idPedido) return p;
        }
        return null;
    }

    // Metodo que cambia el estado de un pedido
    public boolean cambiaEstadoPedido(int idPedido, int nuevoEstado) {
        for (Pedido p : getTodosPedidos()) {
            if (p.getId() == idPedido) return p.cambiaEstado(nuevoEstado);
        }
        return false;
    }

    // Metodo que añade un trabajador a trabajadores
    public boolean nuevoTrabajador(String email, String clave, String nombre, int movil) {
        return trabajadores.add(new Trabajador(generaIdTrabajador(), nombre, clave, email, movil));
    }

    // Metodo que añade un cliente a clientes
    public boolean nuevoCliente(String email, String clave, String nombre, String localidad, String provincia, String direccion, int movil) {
        return clientes.add(new Cliente(generaIdCliente(), email, clave, nombre, localidad, provincia, direccion, movil));
    }

    /*public Trabajador buscaTrabajadorAsignadoAPedido(int idPedido) {

    }*/

    // Metodo que devuelve los pedidos que no tienen el trabajador
    public ArrayList<Pedido> pedidosSinTrabajador() {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        // Bucle que mira todos los pedidos
        for (Pedido pA : getTodosPedidos()) {
            // Bucle que mira todos los trabajadores
            for (Trabajador t : trabajadores) {
                // Bucle que mira todos los pedidos asignados trabajadores
                for (Pedido pT : t.getPedidosAsignados()) {
                    if (t.getPedidosAsignados().contains(pA)) pedidos.add(pA);
                }
            }
        }
        return pedidos;
    }


    // Metodo que muestra el numero de pedidos sin el trabajador
    public int numPedidosSinTrabajador(){
        return pedidosSinTrabajador().size();
    }

    /*public boolean asignaPedido(int idPedido, int idTrabajador) {

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

    // Metodo que busca un pedido asignado en el trabajador
    public Pedido buscaPedidoAsignadoTrabajador(int idTrabajador, int idPedido) {
        // Miramos en los trabajadores a ver si coincide la id que nos pasan del trabajador con algun trabajador
        for (Trabajador t : trabajadores) {
            if (t.getId() == idTrabajador) {
                // Si coincide hacemos un bucle para comprobar sus pedidos
                for (Pedido p : t.getPedidosAsignados()) {
                    // Si la id de un pedido coincide lo devolvemos
                    if (p.getId() == idPedido) return p;
                }
            }
        }
        return null;
    }

    // Metodo que devuelve un array de pedidos completados
    public ArrayList<PedidoClienteDataClass> getPedidosCompletadosTrabajador(int idTrabajador) {
        ArrayList<PedidoClienteDataClass> pedidosCompletadosT = new ArrayList<>();

        Trabajador temp = buscaTrabajadorById(idTrabajador);

        //Bucle que mira los pedidos completados de los trabajadores
        for (Pedido pT : temp.getPedidosCompletados()) {
            // Bucle del cliente
            for (Cliente c : clientes) {
                // Bucle que mira los pedidos de los clientes
                for (Pedido pC : c.getPedidos()) {
                    if (pC.getId() == pT.getId()) {
                        pedidosCompletadosT.add(new PedidoClienteDataClass(c.getId(), c.getEmail(), c.getNombre(), c.getLocalidad(),
                                c.getProvincia(), c.getDireccion(), c.getMovil(), pC.getId(), pC.getFechaPedido(), pC.getFechaEntregaEstimada(),
                                pC.getEstado(), pC.getComentario(), pC.getProductos()));
                    }
                }
            }
        }

        return pedidosCompletadosT;
    }

    // Metodo que pasa los pedidos asignados y completados al trabajador
    public ArrayList<PedidoClienteDataClass> getPedidosAsignadosYCompletados(int idTrabajador) {
        ArrayList<PedidoClienteDataClass> pedidos = new ArrayList<>();

        Trabajador temp = buscaTrabajadorById(idTrabajador);

        // Mira los pedidos del trabajador, los pedidos completados
        for (Pedido p : temp.getPedidosCompletados()) {
            // Mira los clientes y sus pedidos
            for (Cliente c : clientes) {
                for (Pedido pC : c.getPedidos()) {
                    if (p.getId() == pC.getId()) pedidos.add(new PedidoClienteDataClass(c.getId(), c.getEmail(), c.getNombre(), c.getLocalidad(),
                            c.getProvincia(), c.getDireccion(), c.getMovil(), pC.getId(), pC.getFechaPedido(), pC.getFechaEntregaEstimada(),
                            pC.getEstado(), pC.getComentario(), pC.getProductos()));
                }
            }
        }

        // Mira los pedidos del trabajador, los pedidos asignados
        for (Pedido p : temp.getPedidosAsignados()) {
            // Mira los clientes y sus pedidos
            for (Cliente c : clientes) {
                for (Pedido pC : c.getPedidos()) {
                    if (p.getId() == pC.getId()) pedidos.add(new PedidoClienteDataClass(c.getId(), c.getEmail(), c.getNombre(), c.getLocalidad(),
                            c.getProvincia(), c.getDireccion(), c.getMovil(), pC.getId(), pC.getFechaPedido(), pC.getFechaEntregaEstimada(),
                            pC.getEstado(), pC.getComentario(), pC.getProductos()));
                }
            }
        }
        return pedidos;
    }


    // Metodo que genera una id aleatoria para el cliente entre el 0 y 99999
    private int generaIdCliente() {
        boolean repetido = false;
        int id;
        do {
            // Generamos la id
            id = (int) (Math.random() * 2);
            // Hacemos un bucle de clientes para comprobar sus id
            for (Cliente c : clientes) {
                if (c.getId() == id) {
                    // Si la id se repite salimos del bucle for
                    repetido = true;
                    break;
                }
            }
        } while (repetido);

        return id;
    }

    // Metodo que genera una id aleatoria para el producto entre el 500000 y 599999
    private int generaIdProducto() {
        return (int) (Math.random() * 100000) + 500000;
    }

    // Metodo que genera una id aleatoria para el pedido entre el 600000 y 699999
    private int generaIdPedido() {
        boolean repetido = false;
        int id;
        do {
            // Generamos la id
            id = (int) (Math.random() * 100000) + 600000;
            // Hacemos un bucle de clientes para comprobar sus pedidos
            for (Cliente c : clientes) {
                // Bucle que comprueba los pedidos de cada cliente y si la id coincide
                for (int i = 0; i < c.getPedidos().size(); i++) {
                    if (c.getPedidos().get(i).getId() == id) {
                        repetido = true;
                        break;
                    }
                }
            }
        } while (repetido);
        return id;
    }

    // Metodo que genera una id aleatoria para el admin entre el 200000 y 299999
    private int generaIdAdmin() {
        boolean repetido = false;
        int id;
        do {
            // Generamos la id
            id = (int) (Math.random() * 100000) + 200000;
            for (Admin a : admins) {
                if (a.getId() == id) {
                    repetido = true;
                    break;
                }
            }
        } while (repetido);
        return id;
    }

    // Metodo que genera una id aleatoria para el admin entre el 100000 y 199999
    private int generaIdTrabajador() {
        boolean repetido = false;
        int id;
        do {
            // Generamos la id
            id = (int) (Math.random() * 100000) + 100000;
            // Hacemos un bucle de clientes para comprobar sus id
            for (Trabajador t : trabajadores) {
                if (t.getId() == id) {
                    // Si la id se repite salimos del bucle for
                    repetido = true;
                    break;
                }
            }
        } while (repetido);
        return id;
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

    // Metodo que genera un Token aleatorio
    public String generaToken(Object user) {
        String token = "JM-" + (int) (Math.random() * 99999999);

        for (Trabajador t : trabajadores) {
            if (user == t) {
                t.setToken(token);
                t.setValid(false);
            }
        }

        for (Cliente c : clientes) {
            if (user == c) {
                c.setToken(token);
                c.setValid(false);
            }
        }
        return token;
    }

    // Metodo que comprueba el token de un Trabajador y de los clientes
    public boolean compruebaToken(Object user, String tokenTeclado) {
        // Miramos si el usuario pasado coincide con algun trabajador
        for (Trabajador t : trabajadores) {
            if (user == t) {
                if (t.getToken().equals(tokenTeclado)) {
                    t.setValid(true);
                    return true;
                } else t.setValid(false);
            }
        }
        // Miramos si el usuario pasado coincide con algun cliente
        for (Cliente c : clientes) {
            if (user == c) {
                if (c.getToken().equals(tokenTeclado)) {
                    c.setValid(true);
                    return true;
                } else c.setValid(false);
            }
        }

        return false;
    }
}
