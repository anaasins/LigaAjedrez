package ligaajedrez.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import ligaajedrez.modelo.Club;
import ligaajedrez.modelo.Torneo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Olaf
 */
public class ClubDao {
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
     private static final String selectUn= 
            "SELECT idClub, name, federacionid, sedeId,clubId" +
            "       " +
            "  FROM club " +
            " WHERE idClub = ?";
     private static final String select=  
            "SELECT * FROM JugadorModel";
     
     private static final String update= 
             "Update Club "+
             "Set idClub=?, name=?,federacionid=?, sedeId=?,clubId=?"+
             "where id=?";
    private static final String insert =
            "INSERT INTO club (idClub, name, federacionid, " +
            "                         sedeId,clubId) " +
            "VALUES (?,?,?,?,?)";
    private static final String create = 
            "CREATE TABLE 'CLUB'( 'idClub'  NUMBER(10,0) NOT NULL ENABLE,"+
            " NAME VARCHAR2(255),"+ 
            "FEDERATIONID NUMBER(10,0),"+
            "SEDEID NUMBER(10,0),"+ 
            "CLUBID NUMBER(10,0), "+
            "PRIMARY KEY ('idClub')"+
            "FK_FederacioId FOREIGN KEY ('FEDERATIONID')"+
            "REFERENCES FEDERACION ('ID')"+
            "FK_SedeId FOREIGN KEY ('SEDEID')"+
            "REFERENCES SEDE ('ID')";
        private static final String delete =
            "DELETE FROM club  " +
            " WHERE idClub = ?";;
   
    public ClubDao() {}
    
    public void actualizarClub(Club club) throws ClassNotFoundException, 
           InstantiationException, IllegalAccessException, SQLException {
        /*
        * Conexion a la base de datos
        */
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement update = oracleConn.prepareStatement(this.update);
        
        update.setInt(1, club.getId());
        update.setString(2, club.getName());
        update.setInt(3, club.getFederation().getId());
        update.setInt(4, club.getSede().getId());
        update.setInt(5, club.getId());
        update.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    public void insertarClub(Club club) throws 
        ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
       
        /*
        * Conexion a la base de datos
        */
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement insert = oracleConn.prepareStatement(this.insert);
        insert.setInt(1, club.getId());
        insert.setString(2, club.getName());
        insert.setInt(3, club.getFederation().getId());
        insert.setInt(4, club.getSede().getId());
        insert.setInt(5,club.getId());
        insert.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    public void crearClub(Club club) throws 
        ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
       
        /*
        * Conexion a la base de datos
        */
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement create = oracleConn.prepareStatement(this.create);
        create.executeUpdate();       
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
     public Club leerClub(int idClub) throws 
        ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException {
        
        Club club = new Club();
      
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        // Sentencia de insert
        PreparedStatement read = oracleConn.prepareStatement(selectUn);
        read.setInt(1, idClub);
        ResultSet rs = read.executeQuery();
        
        if (rs.next()) {
            
            ArrayList<Torneo> torneos = new ArrayList<Torneo>();
                                 
            for (Integer idTorneo : new TorneoClubDao().selectByClub(rs.getInt("idClub")))
                torneos.add(new TorneoDao().selectOne(idTorneo));
                     
            club.setId(rs.getInt("idClub"));
            club.setName(rs.getString("name"));
            club.setFederation(new FederacionDao().selectOne(rs.getInt("idFederacion")));
            club.setSede(new SedeDao().selectOne(rs.getInt("idSede")));
            club.setTorneos(torneos);       
        }
        return club;
    }
    
       public ArrayList<Club> leerClubs(int idClub) throws 
        ClassNotFoundException, InstantiationException, IllegalAccessException, 
        SQLException, ParseException {
        
        ArrayList<Club> clubs = new ArrayList<Club>();
      
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        // Sentencia de insert
        PreparedStatement read = oracleConn.prepareStatement(select);
        read.setInt(1, idClub);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            
            // Crear llista de tornejos
            ArrayList<Torneo> torneos = new ArrayList<Torneo>();
                                 
            for (Integer idTorneo : new TorneoClubDao().selectByClub(rs.getInt("idClub")))
                torneos.add(new TorneoDao().selectOne(idTorneo));
                     
            Club  club = new Club();
            club.setId(rs.getInt("idClub"));
            club.setName(rs.getString("name"));
            club.setFederation(new FederacionDao().selectOne(rs.getInt("idFederacion")));
            club.setSede(new SedeDao().selectOne(rs.getInt("idSede")));
            club.setTorneos(torneos);
            clubs.add(club);
        }
        
        return clubs;
    }
       
     public void borrarClub(int idClub) throws 
        ClassNotFoundException, 
        InstantiationException, IllegalAccessException, SQLException {
        /*
        * Conexion a la base de datos
        */
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
            
        oracleConn.setAutoCommit(false);
        
        // Sentencia de borrado
        PreparedStatement delete = oracleConn.prepareStatement(this.delete);
        delete.setInt(1, idClub);
        delete.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
}
