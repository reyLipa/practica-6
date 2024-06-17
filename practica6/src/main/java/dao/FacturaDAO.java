package dao;

import conexion.Conexion;
import modelos.Factura;

import java.sql.*;

import java.util.ArrayList;

public class FacturaDAO implements GenericosDAO<Factura>{
    @Override
    public void crear(Factura factura) {

        Connection con=null;

        try {

            con= Conexion.conectar();
            con.setAutoCommit(false);

            String st="INSERT INTO factura(idCliente, idProducto, fecha, cantidad, total) VALUES(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(st);
            ps.setInt(1,factura.getIdCliente());
            ps.setInt(2,factura.getIdProducto());
            ps.setDate(3, Date.valueOf(factura.getFecha()));
            ps.setInt(4,factura.getCantidad());
            ps.setFloat(5,factura.getTotal());

            ps.execute();

            con.commit();
            ps.close();
            con.close();

        }catch (Exception e){
            System.out.println(" error "+e.getMessage());
            try {
                con.rollback();
            }catch (SQLException e2){
                System.out.println("error rollback");
            }
        }

    }

    @Override
    public ArrayList<Factura> listar() {
        Connection con=null;
        ArrayList<Factura> facturas=null;
        try{
            con= Conexion.conectar();
            con.setAutoCommit(false);

           String st="SELECT * FROM factura";
            PreparedStatement ps= con.prepareStatement(st);

            ResultSet rs=ps.executeQuery();
            facturas=new ArrayList<>();
            while (rs.next()){
                Factura factura=new Factura();
                factura.setIdCliente(rs.getInt("idCliente"));
                factura.setIdProducto(rs.getInt("idProducto"));
                factura.setCantidad(rs.getInt("cantidad"));
                factura.setFecha(rs.getDate(("fecha")).toLocalDate());
                factura.setTotal(rs.getFloat("total"));
                facturas.add(factura);
            }
            con.commit();
            ps.close();
            con.close();
            System.out.println("ingreso correcto");
        }catch (Exception e){
            System.out.println("error "+e.getMessage()+getClass());
            try {
                con.rollback();
            }catch (SQLException e2){
                System.out.println("error rollback");
            }
        }

        return facturas;
    }
}
