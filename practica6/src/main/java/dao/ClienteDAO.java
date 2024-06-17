package dao;

import conexion.Conexion;
import modelos.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO implements GenericosDAO<Cliente>{
    @Override
    public void crear(Cliente cliente) {

        Connection con=null;
        try {

            con= Conexion.conectar();
            con.setAutoCommit(false);

            String st="INSERT INTO cliente(nombreCliente, dni, email, telefono) VALUES(?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(st);
            ps.setString(1,cliente.getNombreCliente());
            ps.setInt(2,cliente.getDni());
            ps.setString(3,cliente.getEmail());
            ps.setInt(4,cliente.getTelefono());

            ps.execute();
           // System.out.println("datos preparados para insertar ");
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
    public ArrayList<Cliente> listar() {
        Connection con=null;
        ArrayList<Cliente> result=null;
        try {

            con= Conexion.conectar();
            con.setAutoCommit(false);

            String st="SELECT * FROM cliente";
            PreparedStatement ps= con.prepareStatement(st);


            ResultSet resultado=ps.executeQuery();
            result=new ArrayList<>();

            while(resultado.next()) {
                Cliente cliente=new Cliente(resultado.getString("nombreCliente"),resultado.getInt("dni"),
                        resultado.getString("email"),resultado.getInt("telefono"));
                result.add(cliente);
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
