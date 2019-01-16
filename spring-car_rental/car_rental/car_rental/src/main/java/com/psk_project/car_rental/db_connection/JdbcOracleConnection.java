package com.psk_project.car_rental.db_connection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcOracleConnection {
    public static Connection conn = null;

    public static void init() {

        try {
            // registers Oracle JDBC driver - though this is no longer required
            // since JDBC 4.0, but added here for backward compatibility
            Class.forName("oracle.jdbc.OracleDriver");

            String dbURL2 = "jdbc:oracle:thin:@localhost:1521:xe";


            conn = DriverManager.getConnection(dbURL2, ConnectPass.username, ConnectPass.password);
            if (conn != null) {
                System.out.println("Connected successful");
            }


        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}