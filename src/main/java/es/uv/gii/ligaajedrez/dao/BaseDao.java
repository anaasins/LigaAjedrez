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

    protected static final String DRIVER = "oracle.jdbc.OracleDriver";
    protected static final String DBURL = "jdbc:oracle:thin:@176.31.107.124:1521:XE";
    protected static final String USERNAME = "liga";
    protected static final String PASSWORD = "ISIILiga2020";

    protected String DELETE = "DELETE FROM T WHERE id = ?";
    protected String CREATE = "CREATE TABLE 'T'()";

    public void delete(int id) {
        Connection oracleConn = null;
        PreparedStatement delete = null;

        try {
            Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

            oracleConn.setAutoCommit(false);
            delete = oracleConn.prepareStatement(DELETE);
            delete.setInt(1, id);
            delete.executeUpdate();

            oracleConn.commit();
            oracleConn.setAutoCommit(true);
        } catch (Exception e) {
        } finally {
            try {
                if (oracleConn != null) {
                    oracleConn.close();
                }
                if (delete != null) {
                    delete.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public void create() {
        Connection oracleConn = null;
        PreparedStatement create = null;
        try {
            Class.forName(DRIVER).newInstance();
            oracleConn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

            oracleConn.setAutoCommit(false);
            // Sentencia de insert
            create = oracleConn.prepareStatement(CREATE);
            create.executeUpdate();

            oracleConn.commit();
            oracleConn.setAutoCommit(true);
        } catch (Exception e) {
        } finally {
            if (oracleConn != null) {
                try {
                    if (oracleConn != null) {
                        oracleConn.close();
                    }
                    if (create != null) {
                        create.close();
                    }
                } catch (Exception ex) {
                }
            }
        }
    }
}
