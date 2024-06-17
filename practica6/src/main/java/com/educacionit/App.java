package com.educacionit;

import conexion.Conexion;
import dao.ClienteDAO;
import dao.FacturaDAO;
import dao.ProductoDAO;
import modelos.Cliente;
import modelos.Factura;
import modelos.Producto;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.conectar();
        System.out.println("*********** MENU DIETETICA ***********");
        Scanner leer = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int opcion;
        do {
            System.out.println("ELIJA OPCION");
            System.out.println("1. Producto");
            System.out.println("2. Cliente");
            System.out.println("3. Factura");
            System.out.println("4. Salir");
            opcion = leer.nextInt();
            //leer.nextInt();

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("***************INFORMACION DEL PRODUCTO****************");
                        System.out.println("Nombre del producto ");
                        leer.nextLine();
                        String nombreProducto = leer.nextLine();

                        System.out.println("Stock:");
                        int stock = leer.nextInt();

                        System.out.println("precio:");
                        float precio = leer.nextFloat();

                        ProductoDAO productoDAO = new ProductoDAO();
                        Producto producto = new Producto(nombreProducto, stock, precio);
                        productoDAO.crear(producto);
                        System.out.println(productoDAO.listar());
                    } catch (InputMismatchException e) {
                        System.out.println("error tipo de dato incorrecto " + e.getMessage() + e.getClass());
                        leer.nextInt();

                    }
                    break;
                case 2:
                    try {
                        System.out.println("***************INFORMACION DEL CLIENTE****************");

                        System.out.println("Ingrese nombre del cliente");
                        leer.nextLine();
                        String nombreCliente = leer.nextLine();
                        System.out.println("Ingrese DNI");
                        int dni = leer.nextInt();
                        System.out.println("Ingrese correo");
                        leer.nextLine();
                        String email = leer.nextLine();
                        System.out.println("Ingrese telefono");
                        int telefono = leer.nextInt();
                        ClienteDAO clienteDAO = new ClienteDAO();
                        clienteDAO.crear(new Cliente(nombreCliente, dni, email, telefono));
                        System.out.println(clienteDAO.listar());
                    } catch (InputMismatchException e) {
                        System.out.println("error tipo de dato incorrecto " + e.getMessage() + e.getClass());
                        leer.nextInt();
                    }
                    break;

                case 3:
                    System.out.println("***************INFORMACION DE LA FACTURA****************");
                    try {
                        System.out.println("Ingrese numero de cliente");
                        int idCliente = leer.nextInt();
                        System.out.println("Ingrese numero de producto");
                        int idProducto = leer.nextInt();
                        System.out.println("Ingrese la fecha");
                        leer.nextLine();
                        String fecha = leer.nextLine();
                        LocalDate fec = LocalDate.parse(fecha, formato);
                        System.out.println("Ingrese cantidad");
                        int cantidad = leer.nextInt();
                        System.out.println("total");
                        int total = leer.nextInt();
                        Factura factura = new Factura();

                        leer.nextLine();
                        FacturaDAO facturaDAO = new FacturaDAO();

                        facturaDAO.crear(new Factura(idCliente, idProducto, fec, cantidad, total));
                        System.out.println(facturaDAO.listar());
                    } catch (InputMismatchException e) {
                        System.out.println("error: tipo de dato incorrecto " + e.getMessage() + e.getClass());
                        leer.nextInt();
                    }
                    break;
                case 4:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion incorrecta ");
                    System.out.println("Vuelva a elejir opcion");
            }
        } while (opcion != 4);

    }}





