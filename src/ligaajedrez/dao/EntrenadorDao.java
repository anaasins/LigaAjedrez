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
    
     private static final String selectOne= "SELECT * FROM entrenadorModel WHERE id = ?";
     private static final String select = "SELECT * FROM entrenadorModel";
     private static final String insertEn = "INSERT INTO entrenadorModel VALUES(?, ?, ?, ?, ?)";
     private static final String updateEn = "UPDATE entrenadorModel SET id=?, name=?, surname=?, phone=?, birth=? WHERE id=?";
     private static final String deleteEn = "DELETE FROM entrenadorModel WHERE id=?";
     private static final String createEn = "CREATE TABLE entrenadorModel("
             + "id NUMBER NOT NULL ENABLE,"
             + "name VARCHAR(255) NOT NULL,"
             + "surname VARCHAR(255),"
             + "phone VARCHAR(255),"
             + "birth VARCHAR(255),"
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
            
        }
        return entrenador;
     }
     
    public void insert(EntrenadorModel entrenador) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        PreparedStatement insert = oracleConn.prepareStatement(insertEn);
        insert.setInt(1, entrenador.getId());
        insert.setString(2, entrenador.getName());
        insert.setString(3, entrenador.getSurname());
        insert.setString(4, entrenador.getPhone());
        insert.setString(8, entrenador.getBirth());
        insert.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void update(EntrenadorModel entrenador) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        PreparedStatement update = oracleConn.prepareStatement(updateEn);
        update.setInt(1, entrenador.getId());
        update.setString(2, entrenador.getName());
        update.setString(3, entrenador.getSurname());
        update.setString(4, entrenador.getPhone());
        update.setString(8, entrenador.getBirth());
        update.setInt(9, entrenador.getId());
        update.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
       
    public void delete(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        PreparedStatement delete = oracleConn.prepareStatement(deleteEn);
        delete.setInt(1, id);
        delete.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void create() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement create = oracleConn.prepareStatement(createEn);
        create.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
}
