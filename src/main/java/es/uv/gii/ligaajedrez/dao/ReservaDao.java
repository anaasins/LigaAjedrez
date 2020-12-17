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
import es.uv.gii.ligaajedrez.modelo.Reserva;

/**
 *
 * @author jbeltran
 */
public class ReservaDao {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    private static final String USERNAME = "liga";
    private static final String PASSWORD = "ISIILiga2020";
    
    private static final String SELECTONE = 
            "SELECT * FROM reserva " +
            "WHERE id = ?";
    private static final String SELECT = 
            "SELECT * FROM reserva";
    private static final String INSERT =
            "INSERT INTO reserva VALUES " + 
            "(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE reserva " +
            "SET contador = ?, hora = ?, inicio = ?, sedeid = ?, usuarioid = ? " +
            "WHERE id = ?";
    private static final String DELETE =
            "DELETE FROM reserva " +
            "WHERE id = ?";
    private static final String CREATE = 
            "CREATE TABLE 'RESERVA' " +
            "('ID' NUMBER(10,0) NOT NULL ENABLE, " +
            "'CONTADOR' NUMBER(10,0) NOT NULL ENABLE, " +
            "'HORA' NUMBER(10,0) NOT NULL ENABLE, " +
            "'INICIO' DATE, " +
            "'SEDEID' NUMBER(10,0), " +
            "'USUARIOID' NUMBER(10,0), " +
            "PRIMARY KEY ('ID'), " +
            "CONSTRAINT 'FK_N85B1IA69HTM2F3NAY8G2BXJX' FOREIGN KEY ('SEDEID') " +
            "REFERENCES 'SEDE' ('ID') ENABLE, " +
            "CONSTRAINT 'FK_NGDYKKVY6RR1Q0WMONKBLDK5T' FOREIGN KEY ('USUARIOID') " +
            "REFERENCES 'USUARIO' ('ID') ENABLE)";
    
    public ReservaDao() {}
    
    public List<Reserva> selectAll(){
        List<Reserva> reservas = new ArrayList<Reserva>();
       Connection oracleConn = null;

       try {
           Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);

            PreparedStatement read = oracleConn.prepareStatement(SELECT);
            ResultSet rs = read.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva(
                        new UsuarioDao().selectOne(rs.getInt("usuarioid")),
                        rs.getDate("inicio"),
                        rs.getInt("hora"),
                        new SedeDao().selectOne(rs.getInt("sedeId"))
                );
                reserva.setContador(rs.getInt("contador"));
                reserva.setId(rs.getInt("id"));
                reservas.add(reserva);
            }
       }catch(Exception e){} 
        finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
            } catch(Exception e){}
        }
        
        return reservas;
    }
    
    public Reserva selectOne(int id){
        Reserva reserva = null;
        Connection oracleConn = null;
 
        try {
            Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);

            PreparedStatement read = oracleConn.prepareStatement(SELECT);
            read.setInt(1, id);
            ResultSet rs = read.executeQuery();

            if (rs.next()) {
                reserva = new Reserva(
                        new UsuarioDao().selectOne(rs.getInt("usuarioid")),
                        rs.getDate("inicio"),
                        rs.getInt("hora"),
                        new SedeDao().selectOne(rs.getInt("sedeId"))
                );
                reserva.setContador(rs.getInt("contador"));
                reserva.setId(rs.getInt("id"));
            }
       }catch(Exception e){} 
        finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
            } catch(Exception e){}
        }
        return reserva;
    }
    
    public void insert(Reserva reserva) {
        Connection oracleConn = null;
 
        try {
            Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
            oracleConn.setAutoCommit(false);
            PreparedStatement insert = oracleConn.prepareStatement(INSERT);
            insert.setInt(1, reserva.getId());
            insert.setInt(2, reserva.getContador());
            insert.setDate(3, (Date) reserva.getInicio());
            insert.setInt(4, reserva.getSede().getId());
            insert.setInt(5, reserva.getUser().getId());
            insert.executeUpdate();

            oracleConn.commit();
            oracleConn.setAutoCommit(true);
       }catch(Exception e){} 
        finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
            } catch(Exception e){}
        }
    }
    
    public void update(Reserva reserva) {
        Connection oracleConn = null;

        try {
            Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
            oracleConn.setAutoCommit(false);
            PreparedStatement update = oracleConn.prepareStatement(UPDATE);
            update.setInt(1, reserva.getContador());
            update.setInt(2, reserva.getHora());
            update.setDate(3, (Date) reserva.getInicio());
            update.setInt(4, reserva.getSede().getId());
            update.setInt(5, reserva.getUser().getId());
            update.setInt(6, reserva.getId());
            update.executeUpdate();

            oracleConn.commit();
            oracleConn.setAutoCommit(true);
       }catch(Exception e){} 
        finally {
            try {
                if(oracleConn != null)
                oracleConn.close();
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
