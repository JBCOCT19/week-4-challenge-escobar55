import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static ArrayList<Admin> adminList = new ArrayList<>();
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static ArrayList<Faculty> facultyList = new ArrayList<>();
    private static ArrayList<Class> classList = new ArrayList<>();

    public static void main(String[] args) {
       Admin adminUser = new Admin(200L, "Marcus", "admin1@email.com", "password");
       adminList.add(adminUser);

       //add some students
        Student student1 = new Student(100L, "Ivan", "ivan@email.com", "password");
        Student student2 = new Student(101L, "Elise", "elise@email.com", "password");
        Student student3 = new Student(102L, "Daphne", "daphne@email.com", "password");
        Collections.addAll(studentList, student1,student2,student3);

        //add some faculty
        Faculty faculty1 = new Faculty(001L, "Victor", "victor@email.com", "password");
        Faculty faculty2 = new Faculty(002L, "Sue", "sue@email.com", "password");
        Faculty faculty3 = new Faculty(003L, "Bethy", "bethy@emial.com", "password");
        Collections.addAll(facultyList, faculty1, faculty2, faculty3);

        //add some classes
        Class class1 = new Class(300L, "Java", "Learn core java concepts and how to develop java applications");
        Class class2 = new Class(301L, "HTML/CSS", "Learn how to develop Web applications using HTML and CSS ");
        Class class3 = new Class(302L, "Oracle SQL", "Learn SQL queries, tables and relational databases");
        Collections.addAll(classList, class1, class2, class3);

        Scanner key = new Scanner(System.in);
        System.out.println("Welcome to Montgomery's School System  ");
        System.out.println(); //Just a space
        System.out.println("Would you like to login in? (Y/N) ");
        String answer = key.nextLine();
        if(answer.equalsIgnoreCase("y")){
            System.out.println("Would you like to login as an (A)Admin, (F)Faculty, or (S)Student? ");
            answer = key.nextLine();
            if(answer.equalsIgnoreCase("a")){
                logIn();
            }
            else{
                System.out.println("Ok, Goodbye!");
            }
        }

        //offer options to the user
        System.out.println("Options: ");
        System.out.println(" 1 - Add Student \n 2 - Add Faculty \n 3 - Edit Student \n 4 - Edit Faculty \n 5 - Add Class");
        System.out.println(" 6 - Edit Class \n 7 - Enroll Student \n 8 - Hire a Faculty \n 9 - Viw All Information");
        System.out.println("Enter \"q\" to quit ");
        key.nextLine();
        int input = key.nextInt();
        if(input == 1){
            addStudent();
        }

        //Allow user to add a new Student
        //System.out.println("Would you like to add a new student? (Y/N)");


    }//end main method

     public static void logIn(){
            Scanner key = new Scanner(System.in);
            System.out.println("Please enter your email: ");
            String adminEmail = key.nextLine();
            System.out.println("Please enter your password: ");
            String adminPass = key.nextLine();
            for(Admin a : adminList){
                if(adminEmail.equalsIgnoreCase(a.getEmail()) && adminPass.equalsIgnoreCase(a.getPassword())){
                    System.out.println("You logged in! ");
                }
                else{
                    System.out.println("Invalid, please try again");
                    logIn();
                }

            }
        }//End logIn method

     public static void addStudent(){
        Scanner key = new Scanner(System.in);


     }


}//end main class
