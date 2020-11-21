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
import java.util.ArrayList;
import java.util.List;
import ligaajedrez.modelo.Club;
import ligaajedrez.modelo.JugadorModel;

/**
 *
 * @author Olaf
 */
class JugadorClubDao {
     private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    private static final String USERNAME = "liga";
    private static final String PASSWORD = "ISIILiga2020";
    
    private static final String SELECTONEBYTJUGADOR = 
            "SELECT CLUBS_ID FROM jugadorModel_club " +
            " WHERE JUGADORMODEL_ID = ?";
    private static final String SELECTONEBYCLUB = 
            "SELECT JUGADORMODEL_ID FROM jugadorModel_club " +
            " WHERE CLUBS_ID = ?";
    private static final String SELECT = 
            "SELECT * FROM jugadorModel_club";
    private static final String INSERT =
            "INSERT INTO jugadorModel_club VALUES " + 
            "(?, ?)";
    private static final String DELETE =
            "DELETE FROM jugadorModel_club " +
            " WHERE jugadorId = ? AND CLUBS_ID = ?";
    private static final String CREATE = 
            "CREATE TABLE 'JUGADORCLUB' " +
            "('JUGADORMODEL_ID' NUMBER(10,0) NOT NULL ENABLE, " + 
            "'CLUBS_ID' NUMBER(10,0) NOT NULL ENABLE, " + 
            "CONSTRAINT 'FK_JUGADORCLUB_CLUB' FOREIGN KEY ('CLUBS_ID') " +
            "REFERENCES 'CLUB' ('ID') ENABLE, " + 
            "CONSTRAINT 'FK_JUGADORCLUB_JUGADOR' FOREIGN KEY ('JUGADORMODEL_ID') " +
            "REFERENCES 'JUGADORMODEL' ('ID') ENABLE)";
    
    public JugadorClubDao() {}
    
    public List<int[]> selectAll() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        List<int[]> jugadorCubs = new ArrayList<int[]>();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECT);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            int[] jugadorClub = new int[]
            {
                rs.getInt("torneoId"),
                rs.getInt("CLUBS_ID")
            };
        }
        
        return jugadorCubs;
    }
    
    public List<Integer> selectByJugador(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        List<Integer> clubs = new ArrayList<>();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECTONEBYTJUGADOR);
        read.setInt(1, id);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            clubs.add(rs.getInt("CLUBS_ID"));
        }
        
        return clubs;
    }
    
    public List<Integer> selectByClub(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        List<Integer> jugadores = new ArrayList<>();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECTONEBYCLUB);
        read.setInt(1, id);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            jugadores.add(rs.getInt("jugadorId"));
        }
        
        return jugadores;
    }
    
    public void insert(Club club, JugadorModel jugador) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement insert = oracleConn.prepareStatement(INSERT);
        insert.setInt(1, jugador.getId());
        insert.setInt(2, club.getId());
        insert.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void delete(Club club, JugadorModel jugador) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement delete = oracleConn.prepareStatement(DELETE);
        delete.setInt(1, jugador.getId());
        delete.setInt(2, club.getId());
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



