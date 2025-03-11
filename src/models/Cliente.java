package models;

import controlador.Controlador;

import java.util.ArrayList;

public class Cliente {
    //Atributos
    private int id;
    private String email;
    private String clave;
    private String nombre;
    private String localidad;
    private String provincia;
    private String direccion;
    private int movil;
    private String token;
    private boolean isValid;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Producto> carro;

    //Constructor
    public Cliente(int id, String email, String clave, String nombre, String localidad, String provincia, String direccion, int movil) {
        this.id = id;
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;
        this.localidad = localidad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.movil = movil;
    }


    //Getter y Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    //Otros metodos
    public boolean login(String email, String pass) {
        return email.equals(this.email) && pass.equals(this.clave);
    }

   /* public void addProductoCarro(Producto p) {

    }

    public boolean quitaProducto(int idProducto) {

    }

    public int numProductosCarro() {

    }*/

    public void vaciaCarro() {
        carro.clear();
    }

  /*  public void addPedido() {

    }

    public float precioCarroSinIva(int IVA) {

    }

    public float precioIVACarro(int IVA) {

    }

    public float precioCarroConIVA(int IVA) {

    }

    public boolean existeProductoCarro(int idProducto) {

    }*/
}
