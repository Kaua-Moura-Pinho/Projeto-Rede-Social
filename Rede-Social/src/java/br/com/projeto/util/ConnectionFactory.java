package br.com.projeto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    
    public static Connection getConnection() throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5433/dbredesocial", "postgres", "postdba");
        } catch (Exception ex){
            throw new Exception (ex.getMessage());
        }
    }
    
    public static void closeConnection(Connection conn)throws Exception{
        close(conn, null, null);
    }
    public static void closeConnection(Connection conn, Statement stmt)throws Exception{
        close(conn, stmt, null);
    }
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs)throws Exception{
        close(conn, stmt, rs);
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception{
       try{
           if (rs != null){
               rs.close();
           }
           if (stmt != null){
               stmt.close();
           }
           if (conn != null){
               conn.close();
           }
       } catch (SQLException ex){
           throw new Exception (ex.getMessage());
       }
    }
}
