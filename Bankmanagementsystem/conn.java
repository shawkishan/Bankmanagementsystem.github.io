import java.sql.*;



public class conn {
    Statement s;
    Connection c;

    public conn(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementSystem","root","112233445566");
            s=c.createStatement();


        }
        catch(Exception e){

        }
    }
    
}
