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
import ligaajedrez.modelo.Usuario;

/**
 *
 * @author jbeltran
 */
public class UsuarioDao {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    private static final String USERNAME = "liga";
    private static final String PASSWORD = "ISIILiga2020";
    
    private static final String SELECTONE = 
            "SELECT * FROM usuario " +
            " WHERE id = ?";
    private static final String SELECT = 
            "SELECT * FROM usuario";
    private static final String INSERT =
            "INSERT INTO usuario VALUES " + 
            "(?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE usuario " +
            " SET isAdmin = ?, username = ?, userpass = ?, playerid = ?" +
            " WHERE id = ?";
    private static final String DELETE =
            "DELETE FROM usuario " +
            " WHERE id = ?";
    private static final String CREATE = 
            "CREATE TABLE 'USUARIO' " +
            "('ID' NUMBER(10,0) NOT NULL ENABLE, " +
            "'ISADMIN' NUMBER(10,0) NOT NULL ENABLE, " +
            "'USERNAME' VARCHAR2(255), " +
            "'USERPASS' VARCHAR2(255), " +
            "'PLAYERID' NUMBER(10,0), " +
            "PRIMARY KEY ('ID'), " +
            "CONSTRAINT 'FK_USUARIO_JUGADOR' FOREIGN KEY ('PLAYERID') " +
            "REFERENCES 'JUGADORMODEL' ('ID') ENABLE)";
    
    public UsuarioDao() {}
    
    public List<Usuario> selectAll() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECT);
        ResultSet rs = read.executeQuery();
        
        while (rs.next()) {
            Usuario usuario = new Usuario(
                    rs.getString("username"),
                    rs.getString("userpass"),
                    new JugadorModelDao().selectOne(rs.getInt("playerId")),
                    rs.getInt("isAdmin") == 1
            );
            usuario.setId(rs.getInt("id"));
            usuarios.add(usuario);
        }
        
        oracleConn.close();
        return usuarios;
    }
    
    public Usuario selectOne(int id) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException {
        Usuario usuario = null;
        
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        
        PreparedStatement read = oracleConn.prepareStatement(SELECTONE);
        read.setInt(1, id);
        ResultSet rs = read.executeQuery();
        
        if (rs.next()) {
            usuario = new Usuario(
                    rs.getString("username"),
                    rs.getString("userpass"),
                    new JugadorModelDao().selectOne(rs.getInt("playerId")),
                    rs.getInt("isAdmin") == 1
            );
            usuario.setId(rs.getInt("id"));
        }
        
        oracleConn.close();
        return usuario;
    }
    
    public void insert(Usuario usuario) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        PreparedStatement insert = oracleConn.prepareStatement(INSERT);
        insert.setInt(1, usuario.getId());
        insert.setInt(2, usuario.isAdmin() ? 1 : 0);
        insert.setString(3, usuario.getUserName());
        insert.setString(4, usuario.getUserPass());
        insert.setInt(5, usuario.getPlayer().getId());
        insert.executeUpdate();
        
        oracleConn.commit();
        oracleConn.setAutoCommit(true);
        oracleConn.close();
    }
    
    public void update(Usuario usuario) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        Connection oracleConn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
           
        oracleConn.setAutoCommit(false);
        PreparedStatement update = oracleConn.prepareStatement(UPDATE);
        update.setInt(1, usuario.isAdmin() ? 1 : 0);
        update.setString(2, usuario.getUserName());
        update.setString(3, usuario.getUserPass());
        update.setInt(4, usuario.getPlayer().getId());
        update.setInt(5, usuario.getId());
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
