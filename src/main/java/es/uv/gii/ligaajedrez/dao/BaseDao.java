/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author jbeltran
 */
public class BaseDao {

    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    private static final String USERNAME = "liga";
    private static final String PASSWORD = "ISIILiga2020";

    private static final String DELETE
            = "DELETE FROM usuario "
            + " WHERE id = ?";
    private static final String CREATE
            = "CREATE TABLE 'USUARIO' "
            + "('ID' NUMBER(10,0) NOT NULL ENABLE, "
            + "'ISADMIN' NUMBER(10,0) NOT NULL ENABLE, "
            + "'USERNAME' VARCHAR2(255), "
            + "'USERPASS' VARCHAR2(255), "
            + "'PLAYERID' NUMBER(10,0), "
            + "PRIMARY KEY ('ID'), "
            + "CONSTRAINT 'FK_USUARIO_JUGADOR' FOREIGN KEY ('PLAYERID') "
            + "REFERENCES 'JUGADORMODEL' ('ID') ENABLE)";

    public void delete(int id) {
        Connection oracleConn = null;
        try {
            Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

            oracleConn.setAutoCommit(false);
            PreparedStatement delete = oracleConn.prepareStatement(DELETE);
            delete.setInt(1, id);
            delete.executeUpdate();

            oracleConn.commit();
            oracleConn.setAutoCommit(true);
        } catch (Exception e) {
        } finally {
            if (oracleConn != null) {
                try {
                    oracleConn.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public void create() {
        Connection oracleConn = null;
        try {
            Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

            oracleConn.setAutoCommit(false);
            // Sentencia de insert
            PreparedStatement create = oracleConn.prepareStatement(CREATE);
            create.executeUpdate();

            oracleConn.commit();
            oracleConn.setAutoCommit(true);
        } catch (Exception e) {
        } finally {
            if (oracleConn != null) {
                try {
                    oracleConn.close();
                } catch (Exception ex) {
                }
            }
        }
    }
}
