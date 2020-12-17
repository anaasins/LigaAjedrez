/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.dao;
import java.util.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import es.uv.gii.ligaajedrez.modelo.JugadorModel;
import es.uv.gii.ligaajedrez.modelo.Partida;
import es.uv.gii.ligaajedrez.modelo.Sede;
import es.uv.gii.ligaajedrez.modelo.Torneo;

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
    
    public List<Partida> selectAll() {
        Connection oracleConn = null;
        PreparedStatement read = null;
            ResultSet rs = null;
        List<Partida> partidas = new ArrayList<Partida>(); 

         try{
            Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);

            read = oracleConn.prepareStatement(SELECT);
            rs = read.executeQuery();
            Sede s = new Sede();
            JugadorModel j1 = new JugadorModel();
            JugadorModel j2 = new JugadorModel();
            JugadorModel ganador = new JugadorModel();
            Torneo torneo = new Torneo();
            while(rs.next())
            {
                j1 = new JugadorModelDao().selectOne(rs.getInt("jugador1Id"));
                j2 = new JugadorModelDao().selectOne(rs.getInt("jugador2Id"));
                ganador = new JugadorModelDao().selectOne(rs.getInt("ganadorId"));
                s= new SedeDao().selectOne(rs.getInt("sede_id"));
                torneo = new TorneoDao().selectOne(rs.getInt("torneoId"));
                Partida partida = new Partida();
                partida.setId(rs.getInt("id"));
                partida.setJugador1(j1);
                partida.setJugador2(j2);
                partida.setSede(s);

                partida.setFechaPartida(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("fechaPartida")));
                partida.setHora(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("hora")));
                partida.setGanador(ganador);
                partida.setTorneo(torneo);

                partidas.add(partida);
            }
        } catch(Exception e){} 
        finally {
            try {
                if(oracleConn != null)
                    oracleConn.close();
                if(read != null)
                    read.close();
                if(rs!=null)
                    rs.close();
            } catch(Exception e){}
        }
        return partidas;
    }
    
    public Partida selectOne(){
        
        Connection oracleConn = null;
        Partida partida = null;
         PreparedStatement read = null;
             ResultSet rs = null;
        try{
            
            Class.forName(DRIVER).newInstance();
             oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);

             read = oracleConn.prepareStatement(SELECTONE);
             rs = read.executeQuery();
             Sede s = new Sede();
             SedeDao sd = new SedeDao();
             JugadorModel j1 = new JugadorModel();
             JugadorModel j2 = new JugadorModel();
             JugadorModel ganador = new JugadorModel();
             JugadorModelDao jd = new JugadorModelDao();
             Torneo torneo = new Torneo();
             TorneoDao td = new TorneoDao();
             if(rs.next())
             {
                 j1 = jd.selectOne(rs.getInt("jugador1Id"));
                 j2 = jd.selectOne(rs.getInt("jugador2Id"));
                 ganador = jd.selectOne(rs.getInt("ganadorId"));
                 s= sd.selectOne(rs.getInt("sedeId"));
                 torneo = td.selectOne(rs.getInt("torneoId"));
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
        }catch(Exception e){} 
        finally {
            try {
                if(oracleConn != null)
                    oracleConn.close();
                if(read != null)
                    read.close();
                if(rs!=null)
                    rs.close();
            } catch(Exception e){}
        }
        
        return partida;
    }
    
    public void insert(Partida partida){
        
        Connection oracleConn = null;
            PreparedStatement insert =null;

        try{
            Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
            oracleConn.setAutoCommit(false);
            insert = oracleConn.prepareStatement(INSERT);
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
        }catch(Exception e){} 
        finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
                if(insert!=null)
                        insert.close();
            } catch(Exception e){}
        }
        
    }
    
    public void update(Partida partida){
       Connection oracleConn = null;
       PreparedStatement insert =null;

        try{
            Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);


            oracleConn.setAutoCommit(false);
            insert = oracleConn.prepareStatement(UPDATE);
            insert.setInt(1, partida.getJugador1().getId());
            insert.setInt(2, partida.getJugador2().getId());
            insert.setInt(3, partida.getSede().getId());
            insert.setString(4, partida.getFechaPartida().toString());
            insert.setString(5, partida.getHora().toString());
            insert.setInt(6, partida.getTorneo().getId());
            insert.setInt(7, partida.getGanador().getId());
            insert.setInt(8, partida.getId());
            insert.executeUpdate();

            oracleConn.commit();
            oracleConn.setAutoCommit(true);
        }catch(Exception e){} 
        finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
                if(insert!=null)
                        insert.close();
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
        Connection oracleConn = null;
        
        
        try{
            Class.forName(DRIVER).newInstance();

            oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);

            oracleConn.setAutoCommit(false);
            // Sentencia de insert
            PreparedStatement create = oracleConn.prepareStatement(CREATE);
            create.executeUpdate();

            oracleConn.commit();
            oracleConn.setAutoCommit(true);
        } finally{
            try{
                oracleConn.close();
            }catch(Exception e){}
        }
    }
    
        
}
