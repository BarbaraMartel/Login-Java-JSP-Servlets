/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.isil.eparcial.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.isil.eparcial.user.dao.mysql.MysqlConnection;
import pe.isil.eparcial.user.model.User;

/**
 *
 * @author Barbara
 */
public class UserDao {
    
    public int loginUser(User user) throws Exception{
        MysqlConnection mysqlConn = new MysqlConnection();
        Connection conn = mysqlConn.getConnection();
        //int count = 0;
        
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Usuario WHERE correo = ? AND pass = ?");
        ps.setString(1, user.getCorreo());
        ps.setString(2, user.getPass());

        ResultSet rs = ps.executeQuery();
        
        int count=0;
        while(rs.next()){
            String correo = rs.getString("correo");
            String pass = rs.getString("pass");
            count++;
        }
        return count;
    }
    
    public int registerUser(User user) throws Exception{

    MysqlConnection mysqlConn = new MysqlConnection();
    Connection conn = mysqlConn.getConnection();
    int rowsAffected = 0;

    String queryInsert = "INSERT INTO Usuario (nombre, apePaterno, apeMaterno, direccion, correo, pass)"
            + "VALUES(?,?,?,?,?,?)";

    PreparedStatement ps = conn.prepareStatement(queryInsert);
    ps.setString(1, user.getNombre());
    ps.setString(2, user.getApePaterno());
    ps.setString(3, user.getApeMaterno());
    ps.setString(4, user.getDireccion());
    ps.setString(5, user.getCorreo());
    ps.setString(6, user.getPass());

    rowsAffected = ps.executeUpdate();
    return rowsAffected;
    }
    
    public String showPassword(User user) throws Exception{
        MysqlConnection mysqlConn = new MysqlConnection();
        Connection conn = mysqlConn.getConnection();
    
        //Listar registros - Statement
        //Statement st = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Usuario WHERE correo = ?");
        ps.setString(1, user.getCorreo());

        ResultSet rs = ps.executeQuery();
        String yourpass="";
        String mensaje="";
        int count=0;
        while(rs.next()){
            yourpass = rs.getString("pass");
            count++;
            //System.out.println(yourpass);
        }
        
        if(count > 0){
            mensaje = "Tu contraseña es: " + yourpass;
        }else{
            mensaje = "El correo no existe";
        }
        return mensaje;
        

    }
    
}

/*

        if(count>0){
            
            
        }else{
            yourpass = "El correo no existe";
        }
        return yourpass;

*/



/*

    
        while (st_resultado.next()){
            System.out.println( st_resultado.getString("cod") + "\n"+
                    st_resultado.getString("nombre") + " "+
                    st_resultado.getString("apellido") + "\n"+
                    "Puesto: " + st_resultado.getString("puesto")+"\n"+
                    "Departamento: " + st_resultado.getString("depart"));
        }
        
        CallableStatement cs = conn.prepareCall("{call showpass(?)}");
        cs.setString(1, user.getPass());

        int filasEliminadas = cs.executeUpdate();
        System.out.println("Filas eliminadas: "+filasEliminadas);

*/