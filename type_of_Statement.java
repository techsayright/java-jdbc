package sunitaDB;
import java.sql.*;
public class type_of_Statement {
    public static void main(String[] args) {
        try{
            
            //for load drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //for connect the DB
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/frds","root","");
            System.out.println("Connected to DB");
            
            // for run query createStatement, its required for statement type 
            Statement st=con.createStatement(); 
            
            
//            create table.
            String query="create table student1(rollno int,name varchar(20))";
            st.execute(query);//run queries
            System.out.println("Table created");
            
            
            //Insert single data with Statement
            String query0="insert into student1 values(1,'darshan')";//insert the query 
            int result = st.executeUpdate(query0);//run queries 
       
            
            
            //Insert multiple data with PreparedStatement
            String query1="insert into student1 values(?,?)";
            PreparedStatement ps=con.prepareStatement(query1);
            int result2 = 0;
            
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
            
          
            
            
            //for update single record
            String query3="update student1 set name='khushbu' where rollno=2";
            int result3 = st.executeUpdate(query3);
            if(result3!=0){
                System.out.println("Update the value in table is success!");
            }
            
            //for delete single record
            String query4="delete from student1 where rollno=6";
            int result4=st.executeUpdate(query4);
           
           //for delete multiple record
            String query5="delete from student1 where rollno=?";
            PreparedStatement ps2=con.prepareStatement(query5);
            ps2.setInt(1,5);
            int result5=ps2.executeUpdate();
            
            ps2.setInt(1,7);
            result5=ps2.executeUpdate();
            
            
            
   
            //for print table along with ResultSet rs....
            String sql="select * from student1";
            ResultSet rs=st.executeQuery(sql);//3rd type of execute
            System.out.println("\nDisplaying the record of table...");
            while(rs.next()){
                int roll= rs.getInt("rollno");
                String name=rs.getString("name");
                //dispaly values..
                System.out.println(+roll+ "\t" +name);
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
}