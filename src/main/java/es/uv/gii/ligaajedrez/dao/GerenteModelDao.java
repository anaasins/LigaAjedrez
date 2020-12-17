/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import es.uv.gii.ligaajedrez.modelo.GerenteModel;

/**
 *
 * @author jbeltran
 */
public class GerenteModelDao {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    private static final String USERNAME = "liga";
    private static final String PASSWORD = "ISIILiga2020";
    
    private static final String SELECTONE = 
            "SELECT * FROM gerentemodel " +
            " WHERE id = ?";
    private static final String SELECT = 
            "SELECT * FROM gerentemodel";
    private static final String INSERT =
            "INSERT INTO gerentemodel VALUES " + 
            "(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE gerentemodel " +
            " SET name = ?, surname = ?, phone = ?, nomina = ?," +
            " irpf = ?, clubId = ?, birth = ?" +
            " WHERE id = ?";
    private static final String DELETE =
            "DELETE FROM gerentemodel " +
            " WHERE id = ?";
    private static final String CREATE = 
            "CREATE TABLE 'GERENTEMODEL' " + 
            "('ID' NUMBER(10,0) NOT NULL ENABLE, " + 
            "'BIRTH' VARCHAR2(255), " + 
            "'IRPF' VARCHAR2(255), " + 
            "'NAME' VARCHAR2(255), " + 
            "'NOMINA' VARCHAR2(255), " + 
            "'PHONE' VARCHAR2(255), " + 
            "'SURNAME' VARCHAR2(255), " + 
            "'CLUBID' NUMBER(10,0), " + 
            "PRIMARY KEY ('ID')";
    
    public GerenteModelDao() {}
    
    public List<GerenteModel> selectAll() {
        List<GerenteModel> gerentes = new ArrayList<GerenteModel>();
        Connection oracleConn = null;
        PreparedStatement read = null;
        ResultSet rs = null;
        try {
        Class.forName(DRIVER).newInstance();
        oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        read = oracleConn.prepareStatement(SELECT);
        rs = read.executeQuery();
        
        while (rs.next()) {
            GerenteModel gerente = new GerenteModel(
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("birth"),
                    rs.getString("phone"),
                    rs.getString("nomina"),
                    rs.getString("irpf")
            );
            gerente.setId(rs.getInt("id"));
            gerente.setClub(new ClubDao().leerClub(rs.getInt("clubId")));
            gerentes.add(gerente);
        }
        
        }catch(Exception e){} 
         finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
                if (read!= null)
                read.close();
                if(rs!=null)
                rs.close();
            } catch(Exception e){}            
        }
        return gerentes;
    }
    
    public GerenteModel selectOne(int id) {
        GerenteModel gerente = null;
        
        Connection oracleConn = null;
        PreparedStatement read = null;
        ResultSet rs = null;
        try {
        Class.forName(DRIVER).newInstance();
        oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        read = oracleConn.prepareStatement(SELECT);
        read.setInt(1, id);
        rs = read.executeQuery();
        
        if (rs.next()) {
            gerente = new GerenteModel(
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("birth"),
                    rs.getString("phone"),
                    rs.getString("nomina"),
                    rs.getString("irpf")
            );
            gerente.setId(rs.getInt("id"));
            gerente.setClub(new ClubDao().leerClub(rs.getInt("clubId")));
        }
        
        }catch(Exception e){} 
         finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
                if (read!= null)
                read.close();
                if(rs!=null)
                rs.close();
            } catch(Exception e){}            
        }
        return gerente;
    }
    
    public void insert(GerenteModel gerente){
        
       Connection oracleConn = null;
       PreparedStatement insert = null;
       try {
        Class.forName(DRIVER).newInstance();
        oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        insert = oracleConn.prepareStatement(INSERT);
        insert.setInt(1, gerente.getId());
        insert.setString(2, gerente.getName());
        insert.setString(3, gerente.getSurname());
        insert.setString(4, gerente.getPhone());
        insert.setString(5, gerente.getNomina());
        insert.setString(6, gerente.getIrpf());
        insert.setInt(7, gerente.getClub().getId());
        insert.setString(8, gerente.getBirth());
        insert.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
         }catch(Exception e){} 
         finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
                if (insert!= null)
                insert.close();
            } catch(Exception e){}    
        }
    }
    
    public void update(GerenteModel gerente) {
       Connection oracleConn = null;
       PreparedStatement update = null;
       try {
        Class.forName(DRIVER).newInstance();
        oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        update = oracleConn.prepareStatement(UPDATE);
        update.setString(1, gerente.getName());
        update.setString(2, gerente.getSurname());
        update.setString(3, gerente.getPhone());
        update.setString(4, gerente.getNomina());
        update.setString(5, gerente.getIrpf());
        update.setInt(6, gerente.getClub().getId());
        update.setString(7, gerente.getBirth());
        update.setInt(8, gerente.getId());
        update.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
         }catch(Exception e){} 
         finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
                if (update!= null)
                update.close();
            } catch(Exception e){}            
        }
    }
    
    public void delete(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        PreparedStatement delete = oracleConn.prepareStatement(DELETE);
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
        PreparedStatement create = oracleConn.prepareStatement(CREATE);
        create.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
}
