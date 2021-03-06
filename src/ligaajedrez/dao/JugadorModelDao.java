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
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author Olaf
 */
public class JugadorModelDao {
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
            "SELECT id, name, elo, clubid,age,category,responsableName,"+
            "reponsablePhoneNumber,moroso,multa " +
            " FROM JugadorModel " +
            " WHERE id  = ?";
    
      private static final String SELECTMOROSOS= 
            "SELECT id, name, elo, clubid,age,category,responsableName,"+
            "reponsablePhoneNumber,moroso,multa " +
            " FROM JugadorModel " +
            " WHERE moroso  = ?";
      
     private static final String SELECT=  
            "SELECT * FROM JugadorModel";
     
     private static final String UPDATE= 
             "Update JugadorModel "+
             "Set name=?,elo=?, clubid=?, age=?"+
             "category=?,responsableName=?,reponsablePhoneNumber=?"+
             "moroso=?,multa=? "+
             "where id=?";
    private static final String INSERT =
            "INSERT INTO id, name, elo, clubID,age,category,responsableName,"+
            " reponsablePhoneNumber,moroso,multa " +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String CREATE = 
            "CREATE TABLE 'JugadorModel'( 'ID' NUMBER(10,0) NOT NULL ENABLE,"+
            "NAME VARCHAR2(255),"+ 
            "ELO NUMBER(10,0),"+
            "CLUBID NUMBER(10,0),"+ 
            "AGE NUMBER(10,0), "+
            "CATEGORY ENUM(10,0),"+
            "RESPOSABLENAME VARCHAR2(255),"+
            "RESPONSABLEPHONENUMBER VARCHAR2(255)"+
            "MOROSO BIT,"+
            "MULTA NUMBER(10,0),"+          
            "PRIMARY KEY ('id'),"+
            "FK_clubId FOREIGN KEY ('CLUBID')  REFERENCES Club('ID') ENABLE";
        private static final String DELETE =
            "DELETE FROM JugadorModel  " +
            " WHERE id = ?";;
   
    public JugadorModelDao() {}
    
    public void update(JugadorModel jugador) throws ClassNotFoundException, 
           InstantiationException, IllegalAccessException, SQLException {
        /*
        * Conexion a la base de datos
        */
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        // Sentencia de insert
        PreparedStatement update = oracleConn.prepareStatement(UPDATE);
        
        update.setString(1, jugador.getName());
        update.setInt(2, jugador.getElo());
        update.setInt(3, jugador.getClub().getId());
        update.setInt(4, jugador.getAge());
        update.setInt(5,jugador.getCategory().getValue()); 
        update.setString(6,jugador.getResponsableName());
        update.setString(7,jugador.getReponsablePhoneNumber());
        update.setBoolean(8,jugador.getMoroso());
        update.setInt(9,jugador.getMulta());
        update.setInt(10,jugador.getId());
        update.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    public void insert(JugadorModel jugador) throws 
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
        insert.setString(2, jugador.getName());
        insert.setInt(3, jugador.getElo());
        insert.setInt(4, jugador.getClub().getId());
        insert.setInt(5, jugador.getAge());
        insert.setInt(6,jugador.getCategory().getValue()); 
        insert.setString(7,jugador.getResponsableName());
        insert.setString(8,jugador.getReponsablePhoneNumber());
        insert.setBoolean(9,jugador.getMoroso());
        insert.setInt(10,jugador.getMulta());
        
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
            ArrayList<Club> clubs = new ArrayList<Club>();           
            for (Integer idClub : new JugadorClubDao().selectByJugador(rs.getInt("clubId")))
                clubs.add(new ClubDao().leerClub(idClub));
            
            jugador.setId(rs.getInt("id"));
            jugador.setName(rs.getString("name"));
            jugador.setElo(rs.getInt("elo"));
            jugador.setClub(new ClubDao().leerClub(rs.getInt("clubId")));
            jugador.setAge(rs.getInt("age"));
            jugador.setResponsableName(rs.getString("responsableName"));
            jugador.setReponsablePhoneNumber(rs.getString("reponsablePhoneNumber"));
            jugador.setMoroso(rs.getBoolean("moroso"));
            jugador.setMulta(rs.getInt("multa"));
            jugador.setClubs(clubs);
            
        }
        
        oracleConn.close();
        return jugador;
    }
     public ArrayList<JugadorModel> selectMoroso(boolean moroso) throws 
        ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException{
         
        ArrayList<JugadorModel> jugadors = new ArrayList<JugadorModel>();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        // Sentencia de insert
        PreparedStatement read = oracleConn.prepareStatement(SELECTMOROSOS);
        read.setBoolean(1, moroso);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
         
            JugadorModel jugador = new JugadorModel();jugador.setId(rs.getInt("id"));
            jugador.setName(rs.getString("name"));
            jugador.setElo(rs.getInt("elo"));
            jugador.setClub(new ClubDao().leerClub(rs.getInt("clubId")));
            jugador.setAge(rs.getInt("age"));
            jugador.setResponsableName(rs.getString("responsableName"));
            jugador.setReponsablePhoneNumber(rs.getString("reponsablePhoneNumber"));
            jugador.setMoroso(rs.getBoolean("moroso"));
            jugador.setMulta(rs.getInt("multa"));
            jugadors.add(jugador);
        }
        
        oracleConn.close();
        return jugadors;
     }
       public ArrayList<JugadorModel> select( ) throws 
        ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException{
         
        ArrayList<JugadorModel> jugadors = new  ArrayList<JugadorModel> ();
        
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        // Sentencia de insert
        PreparedStatement read = oracleConn.prepareStatement(SELECTONE);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            
            ArrayList<Club> clubs = new ArrayList<Club>();
            JugadorModel jugador = new JugadorModel();

                     
            for (Integer idClub : new JugadorClubDao().selectByJugador(rs.getInt("idJugador")))
                clubs.add(new ClubDao().leerClub(idClub));
            
            jugador.setId(rs.getInt("id"));
            jugador.setName(rs.getString("name"));
            jugador.setElo(rs.getInt("elo"));
            jugador.setClub(new ClubDao().leerClub(rs.getInt("clubId")));
            jugador.setAge(rs.getInt("age"));
            jugador.setResponsableName(rs.getString("responsableName"));
            jugador.setReponsablePhoneNumber(rs.getString("reponsablePhoneNumber"));
            jugador.setMoroso(rs.getBoolean("moroso"));
            jugador.setMulta(rs.getInt("multa"));
            jugador.setClubs(clubs);
            jugadors.add(jugador);
        }
        
        oracleConn.close();
        return jugadors;
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
