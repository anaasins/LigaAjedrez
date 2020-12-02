/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import ligaajedrez.modelo.Club;
import ligaajedrez.modelo.JugadorModel;
import ligaajedrez.modelo.Torneo;

/**
 *
 * @author jbeltran
 */
public class TorneoParticipanteDao {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    private static final String USERNAME = "liga";
    private static final String PASSWORD = "ISIILiga2020";
    
    private static final String SELECTONEBYTORNEO = 
            "SELECT jugadorId FROM torneopaticipantes " +
            " WHERE torneoId = ?";
    private static final String SELECTONEBYJUGADOR = 
            "SELECT torneoId FROM torneopaticipantes " +
            " WHERE jugadorId = ?";
    private static final String SELECT = 
            "SELECT * FROM torneopaticipantes";
    private static final String INSERT =
            "INSERT INTO torneopaticipantes VALUES " + 
            "(?, ?)";
    private static final String DELETE =
            "DELETE FROM torneopaticipantes " +
            " WHERE torneoId = ? AND jugadorId = ?";
    private static final String CREATE = 
            "CREATE TABLE 'TORNEOPATICIPANTES' " +
            "('TORNEOID' NUMBER(10,0) NOT NULL ENABLE, " +
            "'JUGADORID' NUMBER(10,0) NOT NULL ENABLE, " +
            "CONSTRAINT 'FK_TORNEOPATICIPANTES_JUGADOR' FOREIGN KEY ('JUGADORID') " +
            "REFERENCES 'JUGADORMODEL' ('ID') ENABLE, " +
            "CONSTRAINT 'FK_TORNEOPATICIPANTES_TORNEO' FOREIGN KEY ('TORNEOID') " +
            "REFERENCES 'TORNEO' ('ID') ENABLE)";
    
    public TorneoParticipanteDao() {}
    
    public List<int[]> selectAll() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        List<int[]> torneoClubs = new ArrayList<int[]>();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECT);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            int[] torneoClub = new int[]
            {
                rs.getInt("torneoId"),
                rs.getInt("jugadorId")
            };
        }
        
        oracleConn.close();
        return torneoClubs;
    }
    
    public List<Integer> selectByTorneo(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        List<Integer> clubs = new ArrayList<>();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECTONEBYTORNEO);
        read.setInt(1, id);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            clubs.add(rs.getInt("jugadorId"));
        }
        
        oracleConn.close();
        return clubs;
    }
    
    public List<Integer> selectByJugador(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        List<Integer> torneos = new ArrayList<>();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECTONEBYJUGADOR);
        read.setInt(0, id);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            torneos.add(rs.getInt("torneoId"));
        }
        
        oracleConn.close();
        return torneos;
    }
    
    public void insert(JugadorModel jugador, Torneo torno) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement insert = oracleConn.prepareStatement(INSERT);
        insert.setInt(1, torno.getId());
        insert.setInt(2, jugador.getId());
        insert.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void delete(JugadorModel jugador, Torneo torno) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement delete = oracleConn.prepareStatement(DELETE);
        delete.setInt(1, torno.getId());
        delete.setInt(2, jugador.getId());
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
