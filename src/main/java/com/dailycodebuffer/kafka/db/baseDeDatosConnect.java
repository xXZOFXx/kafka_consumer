/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dailycodebuffer.kafka.db;

/**
 *
 * @author e-zof
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class baseDeDatosConnect {
    
    //coonectar a la base 
    //entrada de metodo publico y que tenga un constructor 
    
    
    
    
   public static Connection conexion() {

      Connection conn = null;
        // auto close connection
        try {
            
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testlocal", "ricardo", "l1nuxru13s");

                
            if (conn != null) {
                System.out.println("Se conecto a la base!");
            } else {
                System.out.println("Fallo la  conexion!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
        
    }
   
   
   
   
   
    public void cerrarConexion( Connection conexion) throws SQLException{
         
        conexion.close();
        
        System.out.println("Se cerro la conexion");
 
     
    }
    
    
   public String insertarMensaje(Connection conexion, String Mesagge) throws SQLException{
    
        
            
        Statement st = conexion.createStatement();
        String SQL = "INSERT INTO `records`( `mensaje`, `id_stand`) VALUES ('"+ Mesagge + "',2);";
        int result = st.executeUpdate(SQL);
       return null;
    
    
    }
     
}
 
     
    

