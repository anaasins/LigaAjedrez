package ligaajedrez.dao;
import java.sql.*;
import java.util.*;

import ligaajedrez.modelo.Sede;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Olaf
 */
public class SedeDao {
    public static final String DRIVER = "oracle.jdbc.OracleDriver";
    public static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    public static final String USERNAME = "liga";
    public static final String PASSWORD = "ISIILiga2020";
    
    private static final String LSEDE = "Select id from sede";
    private static final String LONESEDE = "Select id from sede where id = ?";
    private static final String ISEDE = "Insert into sede(id) values(?)";
    private static final String ASEDE = "Update sede set id = ? where id = ?";
    private static final String BSEDE = "Delete from sede where id= ?";
    private static final String CTABLE = 
            "create table sede("
            + "id NUMBER NOT NULL,"
            + "PRIMARY KEY('id')"
            + ");";
    
    public List<Sede> selectAll() 
                throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        List<Sede> sedes = new ArrayList<Sede>();
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(LSEDE);
        ResultSet rs = read.executeQuery();
    
        while(rs.next()){
            Sede sede = new Sede();
            sede.setId(rs.getInt("id"));
            sedes.add(sede);
        }
        return sedes;
    }
    
    public Sede selectOne(int id)throws
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException 
    {
       Sede sede = null;
       
       Class.forName(DRIVER).newInstance();
       Connection oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
       
       PreparedStatement read = oracleConn.prepareStatement(LONESEDE);
       read.setInt(1, id);
       ResultSet rs = read.executeQuery();
       
       if(rs.next()){
           sede = new Sede();
           sede.setId(id);
       }
       return sede;
    }
    
    public void createTable()throws
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        oracleConn.setAutoCommit(false);
        PreparedStatement create = oracleConn.prepareStatement(CTABLE);
        create.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void insertSede(int id)throws
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        oracleConn.setAutoCommit(false);
        PreparedStatement create = oracleConn.prepareStatement(ISEDE);
        create.setInt(1, id);
        create.executeUpdate();
        
         oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void updateSede(int id)throws
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        oracleConn.setAutoCommit(false);
        PreparedStatement create = oracleConn.prepareStatement(ASEDE);
        create.setInt(1, id);
        create.setInt(2, id);
        create.executeUpdate();
        
         oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void deleteSede(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement delete = oracleConn.prepareStatement(BSEDE);
        delete.setInt(1, id);
        delete.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
}


    
    

