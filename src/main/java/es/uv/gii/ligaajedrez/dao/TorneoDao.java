/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import es.uv.gii.ligaajedrez.modelo.Club;
import es.uv.gii.ligaajedrez.modelo.JugadorModel;
import es.uv.gii.ligaajedrez.modelo.Torneo;

/**
 *
 * @author jbeltran
 */
public class TorneoDao {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    private static final String USERNAME = "liga";
    private static final String PASSWORD = "ISIILiga2020";
    
    private static final String SELECTONE = 
            "SELECT * FROM torneo " +
            " WHERE id = ?";
    private static final String SELECT = 
            "SELECT * FROM torneo";
    private static final String INSERT =
            "INSERT INTO torneo VALUES " + 
            "(?, ?, ?)";
    private static final String UPDATE =
            "UPDATE torneo " +
            " SET fecha = ?, federacionid = ?" +
            " WHERE id = ?";
    private static final String DELETE =
            "DELETE FROM torneo " +
            " WHERE id = ?";
    private static final String CREATE = 
            "CREATE TABLE 'TORNEO' " +
            "('ID' NUMBER(10,0) NOT NULL ENABLE, " +
            "'FECHA' DATE, " +
            "'FEDERACIONID' NUMBER(10,0), " +
            "PRIMARY KEY ('ID'), " +
            "CONSTRAINT 'FK_TORNEO_FEDERACION' FOREIGN KEY ('FEDERACIONID') " +
            "REFERENCES 'FEDERACIONMODEL' ('ID') ENABLE)";
    
    public TorneoDao() {}
    
    public List<Torneo> selectAll() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException {
        List<Torneo> torneos = new ArrayList<Torneo>();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECT);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            List<Club> clubs = new ArrayList<Club>();
            List<JugadorModel> jugadores = new ArrayList<JugadorModel>();
            for (Integer idClub : new TorneoClubDao().selectByTorneo(rs.getInt("id")))
                clubs.add(new ClubDao().leerClub(idClub));
            for (Integer idJugador : new TorneoParticipanteDao().selectByTorneo(rs.getInt("id")))
                jugadores.add(new JugadorModelDao().selectOne(idJugador));
            Torneo torneo = new Torneo(
                    new FederacionDao().selectOne(rs.getInt("federacionId")),
                    rs.getDate("fecha"),
                    (ArrayList<Club>) clubs);
            torneo.setId(rs.getInt("id"));
            torneo.setParticipantes(jugadores);
            torneos.add(torneo);
        }
        
        return torneos;
    }
    
    public Torneo selectOne(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException {
        Torneo torneo = null;
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECTONE);
        read.setInt(1, id);
        ResultSet rs = read.executeQuery();
        
        if (rs.next()) {
            List<Club> clubs = new ArrayList<Club>();
            List<JugadorModel> jugadores = new ArrayList<JugadorModel>();
            for (Integer idClub : new TorneoClubDao().selectByTorneo(rs.getInt("id")))
                clubs.add(new ClubDao().leerClub(idClub));
            for (Integer idJugador : new TorneoParticipanteDao().selectByTorneo(rs.getInt("id")))
                jugadores.add(new JugadorModelDao().selectOne(idJugador));
            torneo = new Torneo(
                    new FederacionDao().selectOne(rs.getInt("federacionId")),
                    rs.getDate("fecha"),
                    (ArrayList<Club>) clubs);
            torneo.setId(rs.getInt("id"));
            torneo.setParticipantes(jugadores);
        }
        
        oracleConn.close();
        return torneo;
    }
    
    public void insert(Torneo torneo) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement insert = oracleConn.prepareStatement(INSERT);
        insert.setInt(1, torneo.getId());
        insert.setDate(2, (Date) torneo.getFecha());
        insert.setInt(3, torneo.getFederacion().getId());
        insert.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void update(Torneo torneo) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement update = oracleConn.prepareStatement(UPDATE);
        update.setInt(1, torneo.getId());
        update.setDate(2, (Date) torneo.getFecha());
        update.setInt(3, torneo.getFederacion().getId());
        update.setInt(4, torneo.getId());
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
