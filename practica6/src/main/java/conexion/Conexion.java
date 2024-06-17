package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static final String USER="root";
    static final String  PASSWORD="";

    static  Connection con=null;
    public static Connection conectar(){
        try {

            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/dietetica", USER,PASSWORD);
            System.out.println("conexion");


        }
        catch(SQLException e){
            System.out.println(""+e.getMessage());

            }
        return con;
    }
}
