package models;

import java.util.ArrayList;

public class Trabajador {
    // Atributos
    private int id;
    private String nombre;
    private String pass;
    private String email;
    private int movil;
    private String token;
    private boolean isValid;
    private ArrayList<Pedido> pedidosAsignados;

    //Constructor
    public Trabajador(String nombre, String pass, String email, int movil) {
        this.nombre = nombre;
        this.pass = pass;
        this.email = email;
        this.movil = movil;
    }

    // Getters y Setters
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public ArrayList<Pedido> getPedidosAsignados() {
        return pedidosAsignados;
    }

    public void setPedidosAsignados(ArrayList<Pedido> pedidosAsignados) {
        this.pedidosAsignados = pedidosAsignados;
    }


    // Otros metodos
    public boolean login(String email, String pass) {
        return nombre.equals(email) && pass.equals(this.pass);
    }

  /*  public Pedido buscaPedidoAsignadoPendiente(int idPedido) {

    }

    public Pedido buscaPedidoAsignadoCompletado(int idPedido) {

    }

    public boolean asignaPedido(Pedido p) {

    }

    public ArrayList<Pedido> getPendidosPendientes() {

    }

    public ArrayList<Pedido> getPedidosCompletados() {

    }

    public int numPedidosPendientes() {

    }*/
}
