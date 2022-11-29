
package objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void createStudentDB()
    {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        Connection con = null;
        Statement stmt = null;
        String query;
        ResultSet result = null;
        try
        {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            System.out.println("Database Creation is in progress");
            System.out.println("********");
            query = "DROP DATABASE IF EXISTS student_management;";
            stmt.executeUpdate(query);
            query = "CREATE DATABASE student_management;";
            stmt.executeUpdate(query);
            query = "USE student_management;";
            stmt.executeUpdate(query);
            query = """
                    CREATE TABLE student_score(
                    Student_ID INTEGER NOT NULL AUTO_INCREMENT,
                    Subject1 VARCHAR(32),
                    Subject2 VARCHAR(32),
                    Score1 FLOAT,
                    Score2 FLOAT,
                    PRIMARY KEY(Student_ID)
                    );
                    """;
            stmt.executeUpdate(query);
            query = """
                    insert into student_score
                    (Subject1,Score1,Subject2,Score2) 
                    values
                    ('English',94,'Maths',90),
                    ('English',94,'Maths',90),
                    ('Java', 85,'C Sharp',84);
                    """;
            stmt.executeUpdate(query);
            query = "SELECT * FROM student_score";
            result = stmt.executeQuery(query);
        }
        catch(SQLException ex)
        {
            System.out.println("SQLException on database creation:" +ex.getMessage());
        }
        finally
        {
            try
            {
                if(result != null)
                {
                    result.close();
                }
            
            if(stmt != null)
            {
                stmt.close();
            }
            if(con != null)
            {
                con.close();
            }
            }
            catch(SQLException ex)
            {
                System.out.println("SQLException caught: " +ex.getMessage());
            }
        }
    }
    
    
}
