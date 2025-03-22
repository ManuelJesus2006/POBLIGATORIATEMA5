package comunicaciones;

import models.Pedido;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;


public class Comunicaciones {
    // Metodo que envia un mensaje al telegram del trabajador diciendole que se le ha asignado un pedido, recibira la ID del pedido
    public static boolean enviaMensajeTelegram(String mensaje) {
        String direccion; // URL de la API de mi bot en mi conversación
        String fijo = "https://api.telegram.org/bot7933251856:AAGX2oHNIFDQKXDq4PmQbst5v1zBQfddpZY/sendMessage?chat_id=1187949150&text=";
        direccion = fijo + mensaje; //Metemos el mensaje al final
        URL url;
        boolean dev;
        dev = false;
        try {
            url = new URL(direccion);  // Creando un objeto URL con la dirección de la API de mi bot
            URLConnection con = url.openConnection();  // Realizando la petición GET
            // Con esto, copiamos en un la respuesta HTTP, por si lo necesitamos
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            dev = true;  // Ha tenido éxito
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dev;  // Devuelvo si ha tenido éxito o no
    }

    // Metodo que envia el token al trabajador o al cliente
    public static void enviaCorreoToken(String destino, String mensaje, String asunto, String token, String nombreUsuario) {
        //Guardamos la dirección que va a remitir el mensaje
        String emisor = "fernanshopjlmanule@gmail.com";
        String usuario = "fernanshopjlmanule@gmail.com";//Usuario para el logueo en el server de correo
        String clave = "ceoeptmyuekuvbge";//Clave del usuario de correo
        //Host del servidor de correo
        String host = "smtp.gmail.com";
        //Creamos nuestra variable de propiedades con los datos de nuestro servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        //Obtenemos la sesión en nuestro servidor de correo
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave);
            }
        });
        try {
            // Definir contenido en HTML con CSS
            String contenidoHTML = String.format("""
                        <!DOCTYPE html>
                        <html>
                        <head>
                            <meta charset='utf-8'>
                            <meta http-equiv='X-UA-Compatible' content='IE=edge'>
                            <title>CORREOFERNANSHOP</title>
                            <meta name='viewport' content='width=device-width, initial-scale=1'>
                            <style>
                                #container{
                                     background-color: black;
                                 }
                    
                                 #comienzo{
                                     height: 70px;
                                     font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
                                     width: 550px;
                                     margin: auto;
                                     background-color: darkcyan;
                                     text-align: center;
                                 }
                    
                                 #info h1{
                                     width: 115px;
                                     background-color: skyblue;
                                 }
                    
                                 #info p{
                                     font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
                                     font-size: 30px;
                                     color: white;
                                     background-color: black;
                                     text-align: center;
                                     margin: auto;
                                     width: 550px;
                                 }
                    
                                 #detalles{
                                     font-weight: bold;
                                     font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
                                     color: black;
                                     background-color: white;
                                     text-align: center;
                                     margin: auto;
                                     width: 550px;
                                 }
                    
                                 footer{
                                     background-color: darkcyan;
                                     font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
                                     border: 2px black dashed;
                                     text-align: center;
                                     width: 550px;
                                     margin: auto;
                                 }
                            </style>
                        </head>
                        <body>
                            <div id="container">
                                    <div id="comienzo">
                                        <h1>¡HOLA, BIENVENIDO %s !</h1>
                                    </div>
                                    <div id="info">
                                        <p>%s</p>
                                        <h2 id="detalles">%s</h2>
                                    </div>
                                    <br>
                                    <br>
                                    <footer>
                                        <h2>GRACIAS POR SU COLABORACIÓN</h2>
                                        <h3>&copy;FERNANSHOP2025</h3>
                                    </footer>
                                </div>
                        </body>
                        </html>
                    """, nombreUsuario, mensaje, token);

            //Creamos un mensaje de correo por defecto
            Message message = new MimeMessage(session);
            //En el mensaje, establecemos el emisor con los datos pasado sa la función
            message.setFrom(new InternetAddress(emisor));
            //En el mensaje, establecemos el receptor
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            //Establecemos el Asunto
            message.setSubject(asunto);
            //Añadimos el contenido del mensaje
            //message.setText(mensaje); Si solo mandamos texto
            message.setContent(contenidoHTML, "text/html; charset=utf-8");
            //Intentamos mandar el mensaje
            Transport.send(message);
        } catch (Exception e) {
            System.out.println("El correo introducido no es válido");
        }
    }

    // Metodo que envia una asignacion de un pedido al trabajador
    public static void enviaCorreoPedido(String receptor, String asunto, Pedido pedido) {
        //Guardamos la dirección que va a remitir el mensaje
        String emisor = "fernanshopjlmanule@gmail.com";
        String usuario = "fernanshopjlmanule@gmail.com";//Usuario para el logueo en el server de correo
        String clave = "ceoeptmyuekuvbge";//Clave del usuario de correo
        //Host del servidor de correo
        String host = "smtp.gmail.com";
        //Creamos nuestra variable de propiedades con los datos de nuestro servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        //Obtenemos la sesión en nuestro servidor de correo
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave);
            }
        });
        try {
            // Definir contenido en HTML con CSS
            String contenidoHTML = String.format("""
                        <!DOCTYPE html>
                        <html>
                        <head>
                            <meta charset='utf-8'>
                            <meta http-equiv='X-UA-Compatible' content='IE=edge'>
                            <title>CORREOFERNANSHOP</title>
                            <meta name='viewport' content='width=device-width, initial-scale=1'>
                            <style>
                                #container{
                                     background-color: black;
                                 }
                    
                                 #comienzo{
                                     height: 70px;
                                     font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
                                     width: 550px;
                                     margin: auto;
                                     background-color: darkcyan;
                                     text-align: center;
                                 }
                    
                                 #info h1{
                                     width: 115px;
                                     background-color: skyblue;
                                 }
                    
                                 #info p{
                                     font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
                                     font-size: 30px;
                                     color: white;
                                     background-color: black;
                                     text-align: center;
                                     margin: auto;
                                     width: 550px;
                                 }
                    
                                 #detalles{
                                     font-weight: bold;
                                     font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
                                     color: black;
                                     background-color: white;
                                     text-align: center;
                                     margin: auto;
                                     width: 550px;
                                 }
                    
                                 footer{
                                     background-color: darkcyan;
                                     font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
                                     border: 2px black dashed;
                                     text-align: center;
                                     width: 550px;
                                     margin: auto;
                                 }
                            </style>
                        </head>
                        <body>
                            <div id="container">
                                    <div id="comienzo">
                                        <h1>¡HOLA!</h1>
                                    </div>
                                    <div id="info">
                                        <p>¡Se te ha asignado un pedido!</p>
                                        <p>Detalles del pedido:</p>
                                        <h2 id="detalles">%s</h2>
                                    </div>
                                    <br>
                                    <br>
                                    <footer>
                                        <h2>GRACIAS POR SU COLABORACIÓN</h2>
                                        <h3>&copy;FERNANSHOP2025</h3>
                                    </footer>
                                </div>
                        </body>
                        </html>
                    """, pedido.pintaPedidoCorreo());

            //Creamos un mensaje de correo por defecto
            Message message = new MimeMessage(session);
            //En el mensaje, establecemos el emisor con los datos pasado sa la función
            message.setFrom(new InternetAddress(emisor));
            //En el mensaje, establecemos el receptor
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));
            //Establecemos el Asunto
            message.setSubject(asunto);
            //Añadimos el contenido del mensaje
            //message.setText(mensaje); Si solo mandamos texto
            message.setContent(contenidoHTML, "text/html; charset=utf-8");
            //Intentamos mandar el mensaje
            Transport.send(message);
        } catch (Exception e) {
            System.out.println("El correo introducido no es válido");
        }

    }

    // Metodo que avisa al cliente que se ha modificado un correo
    public static void enviaCorreoPedidoEstado(String receptor, String asunto, Pedido pedido) {
        //Guardamos la dirección que va a remitir el mensaje
        String emisor = "fernanshopjlmanule@gmail.com";
        String usuario = "fernanshopjlmanule@gmail.com";//Usuario para el logueo en el server de correo
        String clave = "ceoeptmyuekuvbge";//Clave del usuario de correo
        //Host del servidor de correo
        String host = "smtp.gmail.com";
        //Creamos nuestra variable de propiedades con los datos de nuestro servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        //Obtenemos la sesión en nuestro servidor de correo
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave);
            }
        });
        try {
            // Definir contenido en HTML con CSS
            String contenidoHTML = String.format("""
                        <!DOCTYPE html>
                        <html>
                        <head>
                            <meta charset='utf-8'>
                            <meta http-equiv='X-UA-Compatible' content='IE=edge'>
                            <title>CORREOFERNANSHOP</title>
                            <meta name='viewport' content='width=device-width, initial-scale=1'>
                            <style>
                                #container{
                                     background-color: black;
                                 }
                    
                                 #comienzo{
                                     height: 70px;
                                     font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
                                     width: 550px;
                                     margin: auto;
                                     background-color: darkcyan;
                                     text-align: center;
                                 }
                    
                                 #info h1{
                                     width: 115px;
                                     background-color: skyblue;
                                 }
                    
                                 #info p{
                                     font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
                                     font-size: 30px;
                                     color: white;
                                     background-color: black;
                                     text-align: center;
                                     margin: auto;
                                     width: 550px;
                                 }
                    
                                 #detalles{
                                     font-weight: bold;
                                     font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
                                     color: black;
                                     background-color: white;
                                     text-align: center;
                                     margin: auto;
                                     width: 550px;
                                 }
                    
                                 footer{
                                     background-color: darkcyan;
                                     font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
                                     border: 2px black dashed;
                                     text-align: center;
                                     width: 550px;
                                     margin: auto;
                                 }
                            </style>
                        </head>
                        <body>
                            <div id="container">
                                    <div id="comienzo">
                                        <h1>¡HOLA!</h1>
                                    </div>
                                    <div id="info">
                                        <p>¡Su pedido ha sido modificado!</p>
                                        <p>Detalles del pedido:</p>
                                        <h2 id="detalles">%s</h2>
                                    </div>
                                    <br>
                                    <br>
                                    <footer>
                                        <h2>GRACIAS POR SU COLABORACIÓN</h2>
                                        <h3>&copy;FERNANSHOP2025</h3>
                                    </footer>
                                </div>
                        </body>
                        </html>
                    """, pedido.pintaPedidoCorreo());

            //Creamos un mensaje de correo por defecto
            Message message = new MimeMessage(session);
            //En el mensaje, establecemos el emisor con los datos pasado sa la función
            message.setFrom(new InternetAddress(emisor));
            //En el mensaje, establecemos el receptor
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));
            //Establecemos el Asunto
            message.setSubject(asunto);
            //Añadimos el contenido del mensaje
            //message.setText(mensaje); Si solo mandamos texto
            message.setContent(contenidoHTML, "text/html; charset=utf-8");
            //Intentamos mandar el mensaje
            Transport.send(message);
        } catch (Exception e) {
            System.out.println("El correo introducido no es válido");
        }

    }
}
