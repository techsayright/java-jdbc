package crude;
import java.sql.*;
import java.util.Scanner;
public class CRUDE {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root",""); 
            System.out.println("1-> Conncetion is Created!");
            
            // for run query createStatement, its required for statement type 
            Statement st=con.createStatement(); 
            
            //for create DB
            st.execute("create database ajp_pract4");
            System.out.println("\n2-> DataBase is Created as name ajp_pract4 !");
            
            //for use database
            st.execute("use ajp_pract4");
            System.out.println("Access the created DB for use to modification.");
            
            //for create table
            String queryy="create table student(rollno int,name varchar(20))";
            st.execute(queryy);
            System.out.println("\n3-> Table created.");
            
            //Insert single data 
            //using Statement
//            Scanner sc=new Scanner(System.in);
//            System.out.println("enter name:");
//            String n= sc.nextLine();
            String query="insert into student values(1,'Patel Neet')";//insert the query 
            int result = st.executeUpdate(query);//run queries 
            if(result!=0){
                System.out.println("\n4-> \nSingle Value is Inserted in the table by statement.");
            }
            
            //Insert multiple data 
            //using PreparedStatement
            String query1="insert into student values(?,?)";
            PreparedStatement ps=con.prepareStatement(query1);
            int result2 = 0; //just for defined variable
            
            ps.setInt(1,2);
            ps.setString(2,"kp");
            result2 =ps.executeUpdate();
            
            ps.setInt(1,3);
            ps.setString(2,"drasti");
            result2 =ps.executeUpdate();
            
            ps.setInt(1,4);
            ps.setString(2,"darshan");
            result2 =ps.executeUpdate();
            
            ps.setInt(1,5);
            ps.setString(2,"shyam");
            result2 =ps.executeUpdate();
            
            ps.setInt(1,6);
            ps.setString(2,"hp");
            result2 =ps.executeUpdate();
            
            ps.setInt(1,7);
            ps.setString(2,"parth");
            result2 =ps.executeUpdate();
            
            if(result2!=0){
                System.out.println("Multiple Values are Inserted in the table by preparedstatement.");
            }
            
            //for print table along with ResultSet rs....
            String sql="select * from student";
            ResultSet rs=st.executeQuery(sql);//3rd type of execute
            System.out.println("Displaying inserted record of table...");
            while(rs.next()){
                int roll= rs.getInt("rollno");
                String name=rs.getString("name");
                //dispaly values..
                System.out.println(+roll+ "\t" +name);
            }
            
            //for update single record
            //using statement
            String query3="update student set name='khushbu' where rollno=2";
            int result3 = st.executeUpdate(query3);
            if(result3!=0){
                System.out.println("\n5-> \nSingle Value is upadated in table by statement.");
            }
            
            //for update multiple record
            //using preparedstatement
            String query6="update student set name=? where rollno=?";
            PreparedStatement ps2=con.prepareStatement(query6);
            int result6=0;
            
            ps2.setInt(2,4);
            ps2.setString(1,"shyam Patel");
            result6 = ps2.executeUpdate();
            
            ps2.setInt(2,3);
            ps2.setString(1,"drasti thakker");
            result6 = ps2.executeUpdate();
            
            if(result6!=0){
                System.out.println("Multiple Value are upadated in table by preparedstatement.");
            }
            
            //for print table along with ResultSet rs....
            String sql1="select * from student";
            ResultSet rs1=st.executeQuery(sql1);//3rd type of execute
            System.out.println("Displaying Updated record of table...");
            while(rs1.next()){
                int roll= rs1.getInt("rollno");
                String name=rs1.getString("name");
                //dispaly values..
                System.out.println(+roll+ "\t" +name);
            }
            
            
            //for delete single record
            String query4="delete from student where rollno=6";
            int result4=st.executeUpdate(query4);
            if(result4!=0){
                System.out.println("\n6-> \nSingle Value is deleted in table by statement.");
            }
            
            //for delete multiple record
            String query5="delete from student where rollno = ? ";
            PreparedStatement ps3=con.prepareStatement(query5);
            int result5=0;
            
            ps3.setInt(1,5);
            result5=ps3.executeUpdate();
            
            ps3.setInt(1,7);
            result5=ps3.executeUpdate();
            
            if(result5!=0){
                System.out.println("Multiple Value are deleted in table by preparedstatement.");
            }
            
            
            
            //for print table along with ResultSet rs....
            String sqll="select * from student";
            ResultSet rss=st.executeQuery(sqll);//3rd type of execute
            System.out.println("Displaying table's record after deleting...");
            while(rss.next()){
                int roll= rss.getInt("rollno");
                String name=rss.getString("name");
                //dispaly values..
                System.out.println(+roll+ "\t" +name);
            }
            
            //for delete the table
            String del_table_sql = "drop table student";
            st.execute(del_table_sql);
            System.out.println("\n7-> \nThe table is Deleted Successfully !!!");
            
            //for delete the DB
            String del_db_sql = "drop database ajp_pract4";
            st.execute(del_db_sql);
            System.out.println("The Database is Deleted Successfully !!!");

        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
 
}