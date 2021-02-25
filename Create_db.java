package create_db;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Create_db {
   public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
            System.out.println("connection is created");
            Statement st= con.createStatement();
            st.execute("create database newdb;");
            System.out.println("db is created");
        }
        
        catch (ClassNotFoundException e) {
            System.out.println(e);
            } catch (SQLException ex) {
           Logger.getLogger(Create_db.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
