import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static ArrayList<Admin> adminList = new ArrayList<>();
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static ArrayList<Faculty> facultyList = new ArrayList<>();
    private static ArrayList<Class> classList = new ArrayList<>();
    private static ArrayList<Enrollments> enrollmentList = new ArrayList<>();
    private static ArrayList<Enrollments> facultyHireList = new ArrayList<>();

    public static void main(String[] args) {
       Admin adminUser = new Admin(100L, "Marcus", "admin1@email.com", "password");
       adminList.add(adminUser);

       //add some students to the application
        Student student1 = new Student(200L, "Ivan", "ivan@email.com", "password");
        Student student2 = new Student(201L, "Elise", "elise@email.com", "password");
        Student student3 = new Student(202L, "Daphne", "daphne@email.com", "password");
        Collections.addAll(studentList, student1,student2,student3);

        //add some faculty members to the application
        Faculty faculty1 = new Faculty(300L, "Victor", "victor@email.com", "password");
        Faculty faculty2 = new Faculty(301L, "Sue", "sue@email.com", "password");
        Faculty faculty3 = new Faculty(302L, "Betty", "betty@email.com", "password");
        Collections.addAll(facultyList, faculty1, faculty2, faculty3);

        //add some classes to the application
        Class class1 = new Class(400L, "Java", "Learn core java concepts and how to develop java applications");
        Class class2 = new Class(401L, "HTML/CSS", "Learn how to develop Web applications using HTML and CSS ");
        Class class3 = new Class(402L, "Oracle SQL", "Learn SQL queries, tables and relational databases");
        Collections.addAll(classList, class1, class2, class3);

        //add some enrollments (Student-Class)
        Enrollments studentEnrollment1 = new Enrollments();
        studentEnrollment1.setId(500L);
        studentEnrollment1.setClassId(400L);
        studentEnrollment1.setStudentId(200L);
        studentEnrollment1.setDate("Nov/12/2018");

        Enrollments studentEnrollment2 = new Enrollments();
        studentEnrollment2.setId(501L);
        studentEnrollment2.setClassId(401L);
        studentEnrollment2.setStudentId(201L);
        studentEnrollment2.setDate("Nov/10/2019");
        Collections.addAll(enrollmentList, studentEnrollment1, studentEnrollment2);

        //Add some enrollments-hiring (Faculty-Class)
        Enrollments facultyHire1 = new Enrollments();
        facultyHire1.setId(600L);
        facultyHire1.setClassId(400L);
        facultyHire1.setFacultyId(300L);

        Enrollments facultyHire2 = new Enrollments();
        facultyHire2.setId(601L);
        facultyHire2.setClassId(401L);
        facultyHire2.setFacultyId(301L);
        Collections.addAll(facultyHireList, facultyHire1, facultyHire2);

        Scanner key = new Scanner(System.in);
        System.out.println("Welcome to Montgomery's School System  ");
        System.out.println(); //Just a space
        System.out.println("Would you like to login in? (Y/N) ");
        String answer = key.nextLine();
        if(answer.equalsIgnoreCase("y")){
            System.out.println("Would you like to login as an (A)Admin, (F)Faculty, or (S)Student? ");
            answer = key.nextLine();
            if(answer.equalsIgnoreCase("a")){
                System.out.println(adminUser.welcomeMessage());
                logIn();
            }
            else{
                System.out.println("Ok, Goodbye!");
            }
        }

        //offer options to the user
        System.out.println();
        System.out.println("Please choose between the following options: ");
        System.out.println(" 1 - Add Student \n 2 - Add Faculty \n 3 - Edit Student \n 4 - Edit Faculty \n 5 - Add Class");
        System.out.println(" 6 - Edit Class \n 7 - Enroll Student \n 8 - Hire a Faculty \n 9 - Viw All Information");
        System.out.println(" 10 - to quit ");
        int input = key.nextInt();
        if(input == 1){
            addStudent();
        }
        if(input == 2){
            addFaculty();
        }
        if(input == 3){
            editStudent();
        }
        if(input == 4){
            editFaculty();
        }
        if(input == 5){
            addClass();
        }
        if(input == 6){
            editClass();
        }
        if(input == 7){
            enrollStudent();
        }
        if(input == 8){
            hireFaculty();
        }
        if(input == 9){
            System.out.println(); //Just a space
            System.out.println("All Students: ");
            System.out.println(); //Just a space
            printS();
            System.out.println("All Faculty: ");
            System.out.println(); //Just a space
            printF();
            System.out.println("All Classes: ");
            System.out.println(); //Just a space
            printC();
            System.out.println("All Current Student Enrollments: ");
            System.out.println(); //Just a space
            printEnrollment();
            System.out.println("All Current Faculty Hires: ");
            System.out.println(); //Just a space
            printHiring();
        }
        if(input == 10){
            System.out.println("Ok, BYE BYE!" );
        }


    }//end main method

    public static void printS(){
        for(Student s : studentList){
            System.out.println("Student ID: " + s.getId());
            System.out.println("Student Name: " + s.getName());
            System.out.println("Student Email: " + s.getEmail());
            System.out.println(); //Just a space
        }
    }

    public static void printF(){
        for(Faculty f: facultyList){
            System.out.println("Faculty ID: " + f.getId());
            System.out.println("Faculty Name: " + f.getName());
            System.out.println("Faculty Email: " + f.getEmail());
            System.out.println(); //Just a space
        }

    }

    public static void printC(){
        for(Class c: classList){
            System.out.println("Class ID: " + c.getId());
            System.out.println("Class Name: " + c.getName());
            System.out.println("Class Description: " + c.getDescription());
            System.out.println(); //Just a space
        }
    }

    public static void printEnrollment(){  //Student enrollments
        for(Enrollments en: enrollmentList){
            for(Class c: classList){
                if(en.getClassId() == c.getId()){
                    System.out.println("Class Name: " + c.getName());
                    System.out.println("Enrollment date: " + en.getDate());
                    break;
                }
            }
            for(Student s: studentList){
                if(en.getStudentId() == s.getId()){
                    System.out.println("Student Name: " + s.getName());
                    break;
                }
            }
            System.out.println(); //Just a space
        }

    }

    public static void printHiring(){
        for(Enrollments en: facultyHireList){
            for(Class c: classList){
                if(en.getClassId() == c.getId()){
                    System.out.println("Class Name: " + c.getName());
                    break;
                }
            }
            for(Faculty f: facultyList){
                if(en.getFacultyId() == f.getId()){
                    System.out.println("Faculty Name: " + f.getName());
                    break;
                }
            }
            System.out.println(); //Just a space
        }
    }

     public static void logIn(){
            Scanner key = new Scanner(System.in);
            System.out.println("Please enter your email: ");
            String adminEmail = key.nextLine();
            System.out.println("Please enter your password: ");
            String adminPass = key.nextLine();
            for(Admin a : adminList){
                if(adminEmail.equalsIgnoreCase(a.getEmail()) && adminPass.equalsIgnoreCase(a.getPassword())){
                    System.out.println(); //Just a space
                    System.out.println("Welcome " + a.getName() + "!");
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
         System.out.println("How many students would you like to add? ");
         int num = key.nextInt();
         int count = 0;
         while(count < num){
             Student student = new Student();
             System.out.println("Please enter an ID for the new student: ");
             student.setId(key.nextLong());
             key.nextLine();
             System.out.println("Please enter the name of the new student: ");
             student.setName(key.nextLine());
             System.out.println("Please enter the email of the new student: ");
             student.setEmail(key.nextLine());
             System.out.println("Please enter a password for the new student: ");
             student.setPassword(key.nextLine());
             System.out.println("Student added!");
             studentList.add(student);
             count++;
         }
         System.out.println(); //Just a space
         System.out.println("All Students after new additions: ");
         System.out.println(); //Just a space
         printS();
     }

    public static void addFaculty(){
        Scanner key = new Scanner(System.in);
        System.out.println("How many faculty members would you like to add? ");
        int num = key.nextInt();
        int count = 0;
        while(count < num){
            Faculty faculty = new Faculty();
            System.out.println("Please enter an ID for the new faculty member: ");
            faculty.setId(key.nextLong());
            key.nextLine();
            System.out.println("Please enter the name of the new faculty member: ");
            faculty.setName(key.nextLine());
            System.out.println("Please enter the email of the new faculty member: ");
            faculty.setEmail(key.nextLine());
            System.out.println("Please enter a password for the new faculty member: ");
            faculty.setPassword(key.nextLine());
            System.out.println("Faculty member added!");
            facultyList.add(faculty);
            count++;

        }

        System.out.println();
        System.out.println("All Faculty after new additions: ");
        System.out.println(); //Just a space
        printF();
    }

    public static void editStudent(){
        Scanner key = new Scanner(System.in);
        System.out.println("Enter the ID of the student that you wish to edit: ");
        long userInput = key.nextLong();
        key.nextLine();
        for(Student s: studentList){
            if(userInput == s.getId()){
                System.out.println("Would you like to edit the name? (Y/N) ");
                String answer = key.nextLine();
                if(answer.equalsIgnoreCase("y")){
                    System.out.println("Please enter the new name: ");
                    s.setName(key.nextLine());
                }
                System.out.println("Would you like to edit the email? (Y/N) ");
                answer = key.nextLine();
                if(answer.equalsIgnoreCase("y")){
                    System.out.println("Please enter the new email: ");
                    s.setEmail(key.nextLine());
                }
                System.out.println("Would you like to edit the password? (Y/N) ");
                answer = key.nextLine();
                if(answer.equalsIgnoreCase("y")){
                    System.out.println("Please enter the new password: ");
                    s.setPassword(key.nextLine());
                }

            }
        }
        System.out.println("Student edited! ");
        System.out.println();
    }

    public static void editFaculty(){
        Scanner key = new Scanner(System.in);
        System.out.println("Enter the ID of the faculty member that you wish to edit: ");
        long userInput = key.nextLong();
        key.nextLine();
        for(Faculty f: facultyList){
            if(userInput == f.getId()){
                System.out.println("Would you like to edit the name? (Y/N) ");
                String answer = key.nextLine();
                if(answer.equalsIgnoreCase("y")){
                    System.out.println("Please enter the new name: ");
                    f.setName(key.nextLine());
                }
                System.out.println("Would you like to edit the email? (Y/N) ");
                answer = key.nextLine();
                if(answer.equalsIgnoreCase("y")){
                    System.out.println("Please enter the new email: ");
                    f.setEmail(key.nextLine());
                }
                System.out.println("Would you like to edit the password? (Y/N) ");
                answer = key.nextLine();
                if(answer.equalsIgnoreCase("y")){
                    System.out.println("Please enter the new password: ");
                    f.setPassword(key.nextLine());
                }

            }
        }
        System.out.println("Faculty edited! ");
        System.out.println();
    }

    //Add a class
    public static void addClass(){
        Scanner key = new Scanner(System.in);
        System.out.println("How many classes would you like to add? ");
        int num = key.nextInt();
        int count = 0;
        while(count < num){
            Class classes = new Class();
            System.out.println("Please enter an ID for the new class: ");
            classes.setId(key.nextLong());
            key.nextLine();
            System.out.println("Please enter the name of the new class: ");
            classes.setName(key.nextLine());
            System.out.println("Please enter a short description of the class: ");
            classes.setDescription(key.nextLine());
            classList.add(classes);
            count++;

        }
        System.out.println("New class added!");
        System.out.println();
        System.out.println("All Classes after new additions: ");
        System.out.println(); //Just a space
        printC();
    }

    public static void editClass(){
        Scanner key = new Scanner(System.in);
        System.out.println("Enter the ID of the class that you wish to edit: ");
        long userInput = key.nextLong();
        key.nextLine();
        for(Class c: classList){
            if(userInput == c.getId()){
                System.out.println("Would you like to edit the name of the class? (Y/N) ");
                String answer = key.nextLine();
                if(answer.equalsIgnoreCase("y")){
                    System.out.println("Please enter the new name: ");
                    c.setName(key.nextLine());
                }
                System.out.println("Would you like to edit the description of the class? (Y/N) ");
                answer = key.nextLine();
                if(answer.equalsIgnoreCase("y")){
                    System.out.println("Please enter the new description for the class: ");
                    c.setDescription(key.nextLine());
                }
            }
        }
        System.out.println("Class edited! ");
        System.out.println();
    }

    public static void enrollStudent(){
        Scanner key = new Scanner(System.in);
        System.out.println("How many Students would you like to enroll? ");
        int num = key.nextInt();
        int count = 0;
        while(count < num){
            Enrollments enrollments = new Enrollments();
            System.out.println("Please enter a new ID for the enrollment: ");
            enrollments.setId(key.nextLong());
            System.out.println("Please enter the ID of the student that you wish to enroll: ");
            enrollments.setStudentId(key.nextLong());
            System.out.println("Please enter the ID of the class where you wish to enroll the student: ");
            enrollments.setClassId(key.nextLong());
            key.nextLine();
            System.out.println("Please enter today's date (e.g., Nov/15/2019): ");
            enrollments.setDate(key.nextLine());
            enrollmentList.add(enrollments);
            System.out.println("Student enrolled!");
            count++;
        }
        System.out.println(); //space
        System.out.println("All Current Student Enrollments after new additions: ");
        System.out.println(); //Just a space
        printEnrollment();
    }

    public static void hireFaculty(){
        Scanner key = new Scanner(System.in);
        System.out.println("How many Faculty members would you like to hire? ");
        int num = key.nextInt();
        int count = 0;
        while(count < num){
            Enrollments facultyHires = new Enrollments();
            System.out.println("Please enter a new ID for the hiring record: ");
            facultyHires.setId(key.nextLong());
            System.out.println("Please enter the ID of the faculty that you wish to hire: ");
            facultyHires.setFacultyId(key.nextLong());
            System.out.println("Please enter the ID of the class where you wish to hire the faculty member: ");
            facultyHires.setClassId(key.nextLong());
            facultyHireList.add(facultyHires);
            System.out.println("Faculty hired!");
            count++;
        }
        System.out.println(); //Just a space
        System.out.println("All Current Faculty Hires after additions: ");
        System.out.println(); //Just a space
        printHiring();
    }


}//end main class

