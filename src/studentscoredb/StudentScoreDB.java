package studentscoredb;

import objects.*;
import java.util.*;

public class StudentScoreDB {
        public static void main(String[] args) {
        int operationCounter;// COunter for Switch Statement
        boolean quit = false;
        System.out.println("********");
        System.out.println("Create student_score Database");
        System.out.println("********");
        CreateDatabase.createStudentDB();
        System.out.println("Database has been created ");
        try {
            Scanner sc = new Scanner(System.in);
            do
            {
        System.out.println("Press 1 to Add Records ");
        System.out.println("Press 2 to Delete Records ");
        System.out.println("Press 3 to Search Records ");
        System.out.println("Press 4 to Update Exiting Records ");
        System.out.println("Press 5 to Display Records ");
        System.out.println("Press 6 to exit");
                operationCounter = sc.nextInt();
            if (operationCounter <= 6 && operationCounter > 0) // only work if given options selected
            {
                switch (operationCounter) {
                case 1 -> {
                    System.out.println("Adding record has been Selected ");
                    StudentManagementOperation.insertStudentRecord();// for insert new record
                    displayRecords();
                    break;
                }

                case 2 -> {
                    System.out.println("Deleting Record has been Selected ");
                    displayRecords();
                    StudentManagementOperation.deleteStudentRecord();// for deleteing record
                    displayRecords();
                    break;
                }

                case 3 -> {
                    System.out.println("Search has been Selected");
                    try {
                        Student s1 = StudentManagementOperation.searchRecord();// for search record using id
                        System.out.printf("%8s    %-20s%8s  %-20s%8s\n", "student_ID", "Subject1", "Score1", "Subject2", "Score2");
                        System.out.printf("%8d      %-20s   %5.2f   %-20s %5.2f\n", s1.getStudent_ID(), s1.getSubject1(), s1.getScore1(), s1.getSubject2(), s1.getScore2());
                    } catch (Exception ex) {
                        System.out.println("Something Went Wrong " + ex.getMessage());
                    }
                    break;
                }
                case 4 ->
                {
                    System.out.println("Update in existing record has been selected");
                    StudentManagementOperation.updateExistingRecord();// updatiion in existing record but both subjects need to be changed
                    displayRecords();
                    break;
                }
                case 5 -> {
                    System.out.println("Display Record has been Selected");
                    displayRecords();// display all the record 
                    break;

                }
                case 6 -> {
                    quit = true;
                    break;
                }

            }
            }
            else
            {
                System.out.println("Not An Option Please Select From the Given Options");
            }
            }
            while(!quit);
                       
            
        } catch (InputMismatchException ex) {
            System.out.println("Invalid Input Please Try Again " + ex.getMessage());
        }

    }

    private static void displayRecords() {// Method to display records
        ArrayList<Student> students = StudentManagementOperation.getAllRecord();
        if (students.isEmpty()) {
            System.out.println(" NO Record Found ");
            return;
        }
        System.out.println("All Student Records : ");
        System.out.printf("%8s  %-20s  %8s   %-20s  %8s\n", "student_ID", "Subject1", "Score1","Subject2","Score2");
        for (Student s1 : students) {
            int id = s1.getStudent_ID();
            String subject1 = s1.getSubject1();
            double score1 = s1.getScore1();
            String subject2 = s1.getSubject2();
            double score2 = s1.getScore2();
            
            System.out.printf("%8s    %-20s  %8s   %-20s%8s\n", id, subject1, score1, subject2, score2);
        }

    }
}
