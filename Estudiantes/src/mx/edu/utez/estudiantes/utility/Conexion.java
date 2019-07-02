package mx.edu.utez.estudiantes.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

        public Connection obtenerConexion(){
            String cadenaDeConexion = "jdbc:mysql://localhost:3306/estudiantes?user=root&password=pupi123$root"
                    + "&serverTimezone=America/Mexico_City&useSSL=false&allowPublicKeyRetrieval=true";
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                return DriverManager.getConnection(cadenaDeConexion);
            }catch (Exception ex){
                System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
            }
            return null;
        }

    public static void main(String[] args) {
        Connection  conexion =  new Conexion().obtenerConexion();
            if (conexion != null){
                System.out.println("Todo bien");
            }else{
                System.out.println("Algo pasó");
            }
        }
}

