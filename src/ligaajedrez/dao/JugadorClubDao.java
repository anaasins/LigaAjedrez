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
import ligaajedrez.modelo.Club;
import ligaajedrez.modelo.JugadorModel;

/**
 *
 * @author Olaf
 */
class JugadorClubDao {
     /*
        Parametres conexio base de dades
    */
    public static final String DRIVER = "oracle.jdbc.OracleDriver";
    public static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    public static final String USERNAME = "liga";
    public static final String PASSWORD = "ISIILiga2020";
    
    /*
        Consultes
    */
     private static final String SELECTONE= 
            "SELECT jugadorId, clubId"+
            " FROM JugadorClub " +
            " WHERE jugadorId= ?";
     private static final String SELECT=  
            "SELECT * FROM JugadorClub";
     
     private static final String UPDATE= 
             "Update JugadorModel "+
             "Set jugadorId=?, clubId=?"+
             "where jugadorId=?";
    private static final String INSERT =
            "INSERT INTO jugadorId, clubId"+
            "VALUES (?,?)";
    private static final String CREATE = 
            "CREATE TABLE 'JugadorClub'( 'jugadorId' NUMBER(10,0) NOT NULL ENABLE,"+
            "clubId NUMBER(10,0),"+            
            "PRIMARY KEY ('jugadorId'),"+
            "FK_clubId FOREIGN KEY ('clubId')  REFERENCES Club('ID') ENABLE";
    
        private static final String DELETE =
            "DELETE FROM JugadorModel  " +
            " WHERE idJugador = ?";;
       
    public void update(JugadorModel jugador, Club club) throws ClassNotFoundException, 
           InstantiationException, IllegalAccessException, SQLException {
        /*
        * Conexion a la base de datos
        */
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement update = oracleConn.prepareStatement(UPDATE);
        
        update.setInt(1, jugador.getId());
        update.setInt(2, club.getId());
        update.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    public void insert(JugadorModel jugador,Club club) throws 
        ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
       
        /*
        * Conexion a la base de datos
        */
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
    public void create( JugadorModel jugador) throws 
        ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
       
        /*
        * Conexion a la base de datos
        */
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
    
     public JugadorModel selectOne(int idJugador) throws 
        ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException{
         
        JugadorModel jugador = new JugadorModel();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        // Sentencia de insert
        PreparedStatement read = oracleConn.prepareStatement(SELECTONE);
        read.setInt(1, idJugador);
        ResultSet rs = read.executeQuery();
        
        if (rs.next()) {
            // Crear llista de tornejos
            ArrayList<Club> clubs = new ArrayList<Club>();
            int [] idClubs={};            
            
            //Buscar els id dels tornejos en els que participa el club
            idClubs = JugadorClubDao.selectOne("idJugador");
            
            //Guardar els tornejos en la llista
            for(int i=0; i<=idClubs.length;i++)
            {
                clubs.add(new ClubDao().leerClub(idClubs[i]));
            }
            
            jugador.setId(rs.getInt("idJugador"));
            jugador.setName(rs.getString("name"));
            jugador.setElo(rs.getInt("elo"));
            jugador.setClub(new ClubDao().leerClub(rs.getInt("clubiId")));
            jugador.setAge(rs.getInt("age"));
            jugador.setResponsableName(rs.getString("responsableName"));
            jugador.setReponsablePhoneNumber(rs.getString("reponsablePhoneNumber"));
            jugador.setMoroso(rs.getBoolean("moroso"));
            jugador.setMulta(rs.getInt("multa"));
            jugador.setClubs(clubs);
            
        }
        return jugador;
    }
    
       public JugadorModel select(int idJugador) throws 
        ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException{
         
        JugadorModel jugador = new JugadorModel();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        // Sentencia de insert
        PreparedStatement read = oracleConn.prepareStatement(SELECTONE);
        read.setInt(1, idJugador);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            // Crear llista de tornejos
            ArrayList<Club> clubs = new ArrayList<Club>();
            int [] idClubs={};            
            
            //Buscar els id dels tornejos en els que participa el club
            idClubs = JugadorClubDao.selectOne("idJugador");
            
            //Guardar els tornejos en la llista
            for(int i=0; i<=idClubs.length;i++)
            {
                clubs.add(new ClubDao().leerClub(idClubs[i]));
            }
            
            jugador.setId(rs.getInt("idJugador"));
            jugador.setName(rs.getString("name"));
            jugador.setElo(rs.getInt("elo"));
            jugador.setClub(new ClubDao().leerClub(rs.getInt("clubiId")));
            jugador.setAge(rs.getInt("age"));
            jugador.setResponsableName(rs.getString("responsableName"));
            jugador.setReponsablePhoneNumber(rs.getString("reponsablePhoneNumber"));
            jugador.setMoroso(rs.getBoolean("moroso"));
            jugador.setMulta(rs.getInt("multa"));
            jugador.setClubs(clubs);
            
        }
        return jugador;
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
}


