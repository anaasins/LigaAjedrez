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
import java.util.ArrayList;
import java.util.List;
import ligaajedrez.modelo.GerenteModel;

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
            " SET id = ?, name = ?, surname = ?, phone = ?, nomina = ?," +
            " irpf = ?, clubId = ?, birth = ?" +
            " WHERE idmascota = ?";
    private static final String DELETE =
            "DELETE FROM gerentemodel " +
            " WHERE id = ?";
    private static final String CREATE = 
            "CREATE TABLE 'USUARIO'" +
            "('ID' NUMBER(10,0) NOT NULL ENABLE, " +
            "'ISADMIN' NUMBER(10,0) NOT NULL ENABLE, " +
            "'USERNAME' VARCHAR2(255), " +
            "'USERPASS' VARCHAR2(255), " + 
            "'PLAYERID' NUMBER(10,0), " +
            "PRIMARY KEY ('ID')";
    
    public GerenteModelDao() {}
    
    public List<GerenteModel> selectAll() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        List<GerenteModel> gerentes = new ArrayList<GerenteModel>();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECT);
        ResultSet rs = read.executeQuery();
        
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
            gerentes.add(gerente);
        }
        
        return gerentes;
    }
    
    public GerenteModel selectOne(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        GerenteModel gerente = null;
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECT);
        read.setInt(1, id);
        ResultSet rs = read.executeQuery();
        
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
        }
        
        return gerente;
    }
    
    public void insert(GerenteModel gerente) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement insert = oracleConn.prepareStatement(INSERT);
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
        oracleConn.close();
    }
    
    public void update(GerenteModel gerente) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement update = oracleConn.prepareStatement(UPDATE);
        update.setInt(1, gerente.getId());
        update.setString(2, gerente.getName());
        update.setString(3, gerente.getSurname());
        update.setString(4, gerente.getPhone());
        update.setString(5, gerente.getNomina());
        update.setString(6, gerente.getIrpf());
        update.setInt(7, gerente.getClub().getId());
        update.setString(8, gerente.getBirth());
        update.setInt(9, gerente.getId());
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
        // Sentencia de insert
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
