/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.dao;
import java.util.*;
import java.sql.*;
import java.text.ParseException;
import ligaajedrez.modelo.JugadorModel;
import ligaajedrez.modelo.Partida;
import ligaajedrez.modelo.Sede;
import ligaajedrez.modelo.Torneo;

/**
 *
 * @author asins
 */
public class PartidaDao {
    public static final String DRIVER = "oracle.jdbc.OracleDriver";
    public static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    public static final String USERNAME = "liga";
    public static final String PASSWORD = "ISIILiga2020";
    
    private static final String SELECT = "select * from partida";
    private static final String SELECTONE = "select * from partida where id=?";
    private static final String INSERT = "insert into partida values (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = ""
            + "update partida set "
            + "id=?, "
            + "jugador1Id=?, "
            + "jugador2Id=?, "
            + "sedeId=?, "
            + "fecha=?, "
            + "hora=?, "
            + "torneoId=?, "
            + "ganadorId=?"
            + "where id=?";
    private static final String DELETE = "delete from partida where id=?";
    private static final String CREATE = ""
            + "CREATE TABLE partida("
            + "id NUMBER NOT NULL,"
            + "jugador1Id NUMBER,"
            + "jugador2Id NUMBER,"
            + "sedeId NUMBER,"
            + "fecha VARCHAR(255),"
            + "hora VARCHAR(255),"
            + "torneoId NUMBER,"
            + "ganadorId NUMBER,"
            + "PRIMARY KEY('id')"
            + ");";
    
    public PartidaDao() {}
    
    public List<Partida> selectAll() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException
    {
       List<Partida> partidas = new ArrayList<Partida>(); 
       Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECT);
        ResultSet rs = read.executeQuery();
        Sede s = new Sede();
        JugadorModel j1 = new JugadorModel();
        JugadorModel j2 = new JugadorModel();
        JugadorModel ganador = new JugadorModel();
        Torneo torneo = new Torneo();
        while(rs.next())
        {
            j1 = JugadorDao.selectOne(rs.getInt("jugador1Id"));
            j2 = JugadorDao.selectOne(rs.getInt("jugador2Id"));
            ganador = JugadorDao.selectOne(rs.getInt("ganadorId"));
            s=SedeDao.selectOne(rs.getInt("sedeId"));
            torneo = TorneoDao.selectOne(rs.getInt("torneoId"));
            Partida partida = new Partida();
            partida.setId(rs.getInt("id"));
            partida.setJugador1(j1);
            partida.setJugador2(j2);
            partida.setSede(s);
            
            partida.setFechaPartida(new java.util.Date(rs.getString("fecha")));
            partida.setHora(new java.util.Date(rs.getString("hora")));
            partida.setGanador(ganador);
            partida.setTorneo(torneo);
            
            partidas.add(partida);
        }
        return partidas;
    }
    
    public Partida selectOne() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException
    {
        Partida partida = null;
       Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECTONE);
        ResultSet rs = read.executeQuery();
        Sede s = new Sede();
        JugadorModel j1 = new JugadorModel();
        JugadorModel j2 = new JugadorModel();
        JugadorModel ganador = new JugadorModel();
        Torneo torneo = new Torneo();
        if(rs.next())
        {
            j1 = JugadorDao.selectOne(rs.getInt("jugador1Id"));
            j2 = JugadorDao.selectOne(rs.getInt("jugador2Id"));
            ganador = JugadorDao.selectOne(rs.getInt("ganadorId"));
            s=SedeDao.selectOne(rs.getInt("sedeId"));
            torneo = TorneoDao.selectOne(rs.getInt("torneoId"));
            partida = new Partida();
            partida.setId(rs.getInt("id"));
            partida.setJugador1(j1);
            partida.setJugador2(j2);
            partida.setSede(s);
            
            partida.setFechaPartida(new java.util.Date(rs.getString("fecha")));
            partida.setHora(new java.util.Date(rs.getString("hora")));
            partida.setGanador(ganador);
            partida.setTorneo(torneo);
            
        }
        return partida;
    }
    
    public void insert(Partida partida)throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
                
        oracleConn.setAutoCommit(false);
        PreparedStatement insert = oracleConn.prepareStatement(INSERT);
        insert.setInt(1, partida.getId());
        insert.setInt(2, partida.getJugador1().getId());
        insert.setInt(3, partida.getJugador2().getId());
        insert.setInt(4, partida.getSede().getId());
        insert.setString(5, partida.getFechaPartida().toString());
        insert.setString(6, partida.getHora().toString());
        insert.setInt(7, partida.getTorneo().getId());
        insert.setInt(8, partida.getGanador().getId());
        insert.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
        
    }
    
    public void update(Partida partida)throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
                
        oracleConn.setAutoCommit(false);
        PreparedStatement insert = oracleConn.prepareStatement(UPDATE);
        insert.setInt(1, partida.getId());
        insert.setInt(2, partida.getJugador1().getId());
        insert.setInt(3, partida.getJugador2().getId());
        insert.setInt(4, partida.getSede().getId());
        insert.setString(5, partida.getFechaPartida().toString());
        insert.setString(6, partida.getHora().toString());
        insert.setInt(7, partida.getTorneo().getId());
        insert.setInt(8, partida.getGanador().getId());
        insert.setInt(9, partida.getId());
        insert.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
        
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
