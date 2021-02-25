package jdbc1;

import java.sql.*;
import java.sql.DriverManager;

public class Jdbc1 {

    public static void main(String[] args) {
        try {
//            for load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shortform", "root", "");
            
            System.out.println("connection created");
            String query="create table student(rollno int, name varchar(20))";
            Statement st=con.createStatement();
            System.out.println("statement created");
            st.execute(query);
            System.out.println("table created");
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
