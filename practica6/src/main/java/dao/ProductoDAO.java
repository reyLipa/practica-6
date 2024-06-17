package dao;

import conexion.Conexion;
import modelos.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO implements GenericosDAO<Producto>{
    @Override
    public void crear(Producto producto) {
        Connection con=null;
        try {

            con= Conexion.conectar();
            con.setAutoCommit(false);

            String st="INSERT INTO producto(nombreProducto, stock, precio) VALUES(?,?,?)";
            PreparedStatement ps= con.prepareStatement(st);
            ps.setString(1,producto.getNombreProducto());
            ps.setInt(2,producto.getStock());
            ps.setFloat(3,producto.getPrecio());

            ps.execute();
            System.out.println("datos preparados para insertar ");
            con.commit();
            ps.close();
            con.close();

        }catch (Exception e){

            System.out.println("Error "+e.getMessage());
            try {
                con.rollback();
            }catch (SQLException e2){
                System.out.println("error rollback");
            }
        }


    }

    @Override
    public ArrayList<Producto> listar() {
        Connection con=null;
        ArrayList<Producto> result=null;
        try {

            con= Conexion.conectar();
            con.setAutoCommit(false);

            String st="SELECT * FROM producto";
            PreparedStatement ps= con.prepareStatement(st);


            ResultSet resultado=ps.executeQuery();
             result=new ArrayList<>();

            while(resultado.next()) {
                Producto prod1=new Producto(resultado.getString("nombreProducto"),resultado.getInt("stock"),
                        resultado.getFloat("precio"));
            result.add(prod1);
            }


            con.commit();
            ps.close();
            con.close();

        }catch (Exception e){

            System.out.println("Error "+e.getMessage());
            try {
                con.rollback();
            }catch (SQLException e2){
                System.out.println("error rollback");
            }
        }

        return result;
    }
}
