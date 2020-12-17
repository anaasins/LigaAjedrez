/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.dao;

import java.util.*;
import java.sql.*;
import es.uv.gii.ligaajedrez.modelo.FederacionModel;

/**
 *
 * @author asins
 */
public class FederacionDao {
    public static final String DRIVER = "oracle.jdbc.OracleDriver";
    public static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    public static final String USERNAME = "liga";
    public static final String PASSWORD = "ISIILiga2020";
    
    private static final String SELECT = "Select id, city from federacionModel";
    private static final String SELECTONE = "Select id, city from federacionModel where id = ?";
    private static final String INSERT = "Insert into federacionModel(id, city) values(?, ?)";
    private static final String UPDATE = "Update federacionModel set city=? where id = ?";
    private static final String DELETE = "Delete from federacionModel where id= ?";
    private static final String CREATE = 
            "create table federacionModel("
            + "id NUMBER NOT NULL,"
            + "city VARCHAR(255),"
            + "PRIMARY KEY('id')"
            + ");";
    
    public List<FederacionModel> selectAll(){
               
        List<FederacionModel> federaciones = new ArrayList<FederacionModel>();
        Connection oracleConn = null;
        PreparedStatement read = null;
        ResultSet rs = null;
        try {
        Class.forName(DRIVER).newInstance();
        oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        read = oracleConn.prepareStatement(SELECT);
        rs = read.executeQuery();
    
        while(rs.next()){
            FederacionModel fede = new FederacionModel();
            fede.setId(rs.getInt("id"));
            fede.setCity(rs.getString("city"));
            federaciones.add(fede);
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
        return federaciones;
    }
    
    public FederacionModel selectOne(int id)             
    {
       FederacionModel fede = null;
       Connection oracleConn = null;
       PreparedStatement read = null;
       ResultSet rs = null;
       try {
       Class.forName(DRIVER).newInstance();
       oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
       
       read = oracleConn.prepareStatement(SELECTONE);
       read.setInt(1, id);
       rs = read.executeQuery();
       
       if(rs.next()){
           fede = new FederacionModel();
           fede.setId(rs.getInt("id"));
           fede.setCity(rs.getString("city"));
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
       return fede;
    }
    
    public void createTable() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException 
    {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        oracleConn.setAutoCommit(false);
        PreparedStatement create = oracleConn.prepareStatement(CREATE);
        create.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void insert(int id, String city)
    {
      
       Connection oracleConn = null;
       PreparedStatement create = null;
       try {
        Class.forName(DRIVER).newInstance();
        oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        oracleConn.setAutoCommit(false);
        create = oracleConn.prepareStatement(INSERT);
        create.setInt(1, id);
        create.setString(2, city);
        create.executeUpdate();
        
         oracleConn.commit();
        oracleConn.setAutoCommit(true);
        }catch(Exception e){} 
         finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
                if (create!= null)
                create.close();
            } catch(Exception e){}    
        }
    }
    
    public void update(int id, String city)
    {
       Connection oracleConn = null;
       PreparedStatement create = null;
       try {
        Class.forName(DRIVER).newInstance();
        oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        oracleConn.setAutoCommit(false);
        create = oracleConn.prepareStatement(UPDATE);
        create.setString(1, city);
        create.setInt(2, id);
        create.executeUpdate();
        
         oracleConn.commit();
        oracleConn.setAutoCommit(true);
       }catch(Exception e){} 
         finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
                if (create!= null)
                create.close();
            } catch(Exception e){}            
        }
    }
    
    public void delete(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement delete = oracleConn.prepareStatement(DELETE);
        delete.setInt(1, id);
        delete.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
}
