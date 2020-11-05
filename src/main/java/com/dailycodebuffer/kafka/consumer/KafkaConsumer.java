package com.dailycodebuffer.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.dailycodebuffer.kafka.db.baseDeDatosConnect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@Component
public class KafkaConsumer {
    
    baseDeDatosConnect bd = new baseDeDatosConnect();

    @KafkaListener(topics = "channel", groupId = "group_id")
    public void consume(String message) throws SQLException
    {
        System.out.println("message = " + message);
      Connection cn = baseDeDatosConnect.conexion();
        Statement st = cn.createStatement();
        bd.insertarMensaje(cn, message);
        bd.cerrarConexion(cn);
    }
}
