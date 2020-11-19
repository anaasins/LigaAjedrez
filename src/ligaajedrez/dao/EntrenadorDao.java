/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import ligaajedrez.modelo.EntrenadorModel;

/**
 *
 * @author asins
 */
public class EntrenadorDao {
     /*
        Parametres conexio base de dades
    */
    public static final String DRIVER = "oracle.jdbc.OracleDriver";
    public static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    public static final String USERNAME = "liga";
    public static final String PASSWORD = "ISIILiga2020";
    
     private static final String selectOne= "SELECT * FROM entrenador WHERE id = ?";
     private static final String select = "SELECT * FROM entrenador";
     private static final String insert = "INSERT INTO entrenador VALUES(?, ?, ?, ?, ?, ?)";
     private static final String update = "UPDATE entrenador SET id=?, name=?, surname=?, phone=?, birth=?, clubId=? WHERE id=?";
     private static final String delete = "DELETE FROM entrenador WHERE id=?";
     private static final String create = "CREATE TABLE entrenador("
             + "id NUMBER NOT NULL ENABLE,"
             + "name VARCHAR(255) NOT NULL,"
             + "surname VARCHAR(255),"
             + "phone VARCHAR(255),"
             + "birth VARCHAR(255),"
             + "clubId NUMBER,"
             + "PRIMARY KEY(id)"
             + ");";
     
     public EntrenadorDao(){}
     
     public List<EntrenadorModel> selectAll()throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException 
     {
         List<EntrenadorModel> entrenadores = new ArrayList<EntrenadorModel>();
         
         Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(select);
        ResultSet rs = read.executeQuery();
        
        while(rs.next())
        {
            EntrenadorModel entrenador = new EntrenadorModel(
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("birth"),
                    rs.getString("phone")
            );
            entrenador.setId(rs.getInt("id"));
            //ME FALTA SET CLUB PERQUE NO SE COM ES FA.
            entrenadores.add(entrenador);
        }
        return entrenadores;
     }
     
     public EntrenadorModel selectOne(int id)throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException 
     {
        
         EntrenadorModel entrenador = null;
         Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(selectOne);
        read.setInt(1, id);
        ResultSet rs = read.executeQuery();
        
        if(rs.next())
        {
            entrenador = new EntrenadorModel(
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("birth"),
                    rs.getString("phone")
            );
            entrenador.setId(rs.getInt("id"));
            //ME FALTA SET CLUB PERQUE NO SE COM ES FA.
            
        }
        return entrenador;
     }
        
}
