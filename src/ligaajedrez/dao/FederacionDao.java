/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.dao;

import java.util.*;
import java.sql.*;
import ligaajedrez.modelo.FederacionModel;

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
    private static final String UPDATE = "Update federacionModel set id = ?, city=? where id = ?";
    private static final String DELETE = "Delete from federacionModel where id= ?";
    private static final String CREATE = 
            "create table federacionModel("
            + "id NUMBER NOT NULL,"
            + "city VARCHAR(255),"
            + "PRIMARY KEY('id')"
            + ");";
    
    public List<FederacionModel> selectAll() 
                throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        List<FederacionModel> federaciones = new ArrayList<FederacionModel>();
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECT);
        ResultSet rs = read.executeQuery();
    
        while(rs.next()){
            FederacionModel fede = new FederacionModel();
            fede.setId(rs.getInt("id"));
            fede.setCity(rs.getString("city"));
            federaciones.add(fede);
        }
        return federaciones;
    }
    
    public FederacionModel selectOne(int id)throws
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException 
    {
       FederacionModel fede = null;
       
       Class.forName(DRIVER).newInstance();
       Connection oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
       
       PreparedStatement read = oracleConn.prepareStatement(SELECTONE);
       read.setInt(1, id);
       ResultSet rs = read.executeQuery();
       
       if(rs.next()){
           fede = new FederacionModel();
           fede.setId(rs.getInt("id"));
           fede.setCity(rs.getString("city"));
       }
       return fede;
    }
    
    public void createTable()throws
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
    
    public void insert(int id, String city)throws
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        oracleConn.setAutoCommit(false);
        PreparedStatement create = oracleConn.prepareStatement(INSERT);
        create.setInt(1, id);
        create.setString(2, city);
        create.executeUpdate();
        
         oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void update(int id, String city)throws
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        
        oracleConn.setAutoCommit(false);
        PreparedStatement create = oracleConn.prepareStatement(UPDATE);
        create.setInt(1, id);
        create.setString(2, city);
        create.setInt(3, id);
        create.executeUpdate();
        
         oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
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
