
package objects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class StudentManagementOperation {
    
    // <editor-fold desc="This is my insert Record Method.">
    public static void insertStudentRecord()
    {
        try
        {
        System.out.println("Enter the name of the first Subject to Add");
        Scanner sc = new Scanner(System.in);
        String subject1 = sc.next();
        System.out.println("Enter the score of Subject1 to Add");
        Scanner sc1 = new Scanner(System.in);
        double score1 = sc1.nextDouble();
        System.out.println("Enter the name of the Second Subject to Add");
        Scanner sc2 = new Scanner(System.in);
        String subject2 = sc2.next();
        System.out.println("Enter the score of Subject2 to Add");
        Scanner sc3 = new Scanner(System.in);
        double score2 = sc3.nextDouble();
        if(score1 >= 0 && score1 <=100 && score2 >= 0 && score2 <= 100)
        {
        String insertRecord = String.format("INSERT INTO student_score(Subject1, Score1, Subject2, Score2) VALUES ('%s','%s','%s','%s');", subject1, score1,subject2, score2);
        int count = StudentScoreUtil.executeUpdate(insertRecord);
        if(count == 0)
        {
            System.out.println("Failed to Add new Record ");
        }
        else
        {
            System.out.println("New Record has been Added");
            
        }   
        }
        else
        {
            System.out.println("Score must be less Than equal 100 and Greater than equal 0");
        }
 
        }
        catch(InputMismatchException ex)
        {
            System.out.println("Invalid Input Please Try Again "+ ex.getMessage());
        }
    }
    // </editor-fold>
    
    // <editor-fold desc="This is my Delete Record Method.">
    public static void deleteStudentRecord()
    {
        System.out.println("Students Records are :" );
        System.out.println("Enter the student ID to delete the record");
        Scanner sc = new Scanner(System.in);
        try
        {
        int id = sc.nextInt();
        String deleteRecord = "DELETE FROM student_score WHERE Student_ID='"+id + "';";
        int count = StudentScoreUtil.executeUpdate(deleteRecord);
        if(count == 0)
        {
            System.out.println(" Record is not found ");
        }
        else
        {
            System.out.println("Record has been deleted ");
            
        }  
        }
        catch(InputMismatchException ex)
        {
            System.out.println("Invalid Input Please Try Again "+ ex.getMessage());
        }
        
    }
    // </editor-fold>
    
    // <editor-fold desc="This is my Search Record Method.">
    public static Student searchRecord()
    {
        Student s1 = null;
                 
        System.out.println("Enter the student Id to search record ");
        Scanner sc = new Scanner(System.in);
        try
        {
        int id = sc.nextInt();
        String query = "SELECT * FROM student_score WHERE Student_ID=" +id +";";
        
        try
        {
            ResultSet rs = StudentScoreUtil.executeQuery(query);
            if(rs.next())
            {
                s1 = new Student();
                s1.setStudent_ID(rs.getInt("Student_ID"));
                s1.setSubject1(rs.getString("Subject1"));
                s1.setScore1(rs.getDouble("Score1"));
                s1.setSubject2(rs.getString("Subject2"));
                s1.setScore2(rs.getDouble("Score2"));
            }
        }
        catch(SQLException ex)
        {
            System.out.println("SQLException on executeQuery: " + ex.getMessage());
        }
        
        }
        catch(InputMismatchException ex)
        {
            System.out.println("Invalid Input Please Try Again "+ ex.getMessage());
        } 
        
               
    return s1;
    }
    // </editor-fold>
    
    // <editor-fold desc="This is my Get Record Method.">
    public static ArrayList<Student> getAllRecord()
    {
        String query = "SELECT * FROM student_score";
        ArrayList<Student> students = new ArrayList<>();
        try
        {
            ResultSet rs = StudentScoreUtil.executeQuery(query);
            while(rs.next())
            {
                Student s1 = new Student();
                s1.setStudent_ID(rs.getInt("Student_ID"));
                s1.setSubject1(rs.getString("Subject1"));
                s1.setScore1(rs.getDouble("Score1"));
                s1.setSubject2(rs.getString("Subject2"));
                s1.setScore2(rs.getDouble("Score2"));
                students.add(s1);
            }
        }
        catch(SQLException ex)
        {
            System.out.println("SQLException on executeQuery : " +ex.getMessage());
        }
        return students;
        
    }
    // </editor-fold>
        
    // <editor-fold desc="This is my UPdate Existing Record Method.">
    public static void updateExistingRecord()
    {
       try
        {
        System.out.println("Enter the id number to update that record ");
        Scanner sc4 = new Scanner(System.in);
        int id = sc4.nextInt();
        System.out.println("Enter the name of the first Subject to Add");
        Scanner sc = new Scanner(System.in);
        String subject1 = sc.next();
        System.out.println("Enter the score of Subject1 to Add");
        Scanner sc1 = new Scanner(System.in);
        double score1 = sc1.nextDouble();
        System.out.println("Enter the name of the Second Subject to Add");
        Scanner sc2 = new Scanner(System.in);
        String subject2 = sc2.next();
        System.out.println("Enter the score of Subject2 to Add");
        Scanner sc3 = new Scanner(System.in);
        double score2 = sc3.nextDouble();
        if(score1 >= 0 && score1 <=100 && score2 >= 0 && score2 <= 100)
        {
        String insertRecord =               
               """
                UPDATE student_score
                SET
                Subject1 ='"""+subject1+""" 
                ',Score1 ="""+score1+"""
                 ,Subject2 ='"""+subject2+"""
                ',Score2 = """+score2
                +"""
                 WHERE Student_ID = 
                 """+id+"""
                 ;
                 """;
        int count = StudentScoreUtil.executeUpdate(insertRecord);
        if(count == 0)
        {
            System.out.println("Failed to Update Record ");
        }
        else
        {
            System.out.println("New Record has been Updated");
            
        }   
        }
        else
        {
            System.out.println("Score must be less Than equal 100 and Greater than equal 0");
        }
 
        }
        catch(InputMismatchException ex)
        {
            System.out.println("Invalid Input Please Try Again "+ ex.getMessage());
        }
        
    }
    // </editor-fold>
        
}
