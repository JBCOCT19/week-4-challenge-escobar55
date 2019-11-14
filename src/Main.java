import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static ArrayList<Admin> adminList = new ArrayList<>();
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static ArrayList<Faculty> facultyList = new ArrayList<>();
    private static ArrayList<Class> classList = new ArrayList<>();
    private static ArrayList<Enrollments> enrollmentList = new ArrayList<>();

    public static void main(String[] args) {
       Admin adminUser = new Admin(100L, "Marcus", "admin1@email.com", "password");
       adminList.add(adminUser);

       //add some students
        Student student1 = new Student(200L, "Ivan", "ivan@email.com", "password");
        Student student2 = new Student(201L, "Elise", "elise@email.com", "password");
        Student student3 = new Student(202L, "Daphne", "daphne@email.com", "password");
        Collections.addAll(studentList, student1,student2,student3);

        //add some faculty
        Faculty faculty1 = new Faculty(300L, "Victor", "victor@email.com", "password");
        Faculty faculty2 = new Faculty(301L, "Sue", "sue@email.com", "password");
        Faculty faculty3 = new Faculty(302L, "Betty", "betty@emial.com", "password");
        Collections.addAll(facultyList, faculty1, faculty2, faculty3);

        //add some classes
        Class class1 = new Class(400L, "Java", "Learn core java concepts and how to develop java applications");
        Class class2 = new Class(401L, "HTML/CSS", "Learn how to develop Web applications using HTML and CSS ");
        Class class3 = new Class(402L, "Oracle SQL", "Learn SQL queries, tables and relational databases");
        Collections.addAll(classList, class1, class2, class3);

        //add some enrollments (Student-Class)
        Enrollments studentEnrollment1 = new Enrollments();
        studentEnrollment1.setId(500L);
        studentEnrollment1.setClassId(400L);
        studentEnrollment1.setStudentId(200L);

        Enrollments studentEnrollment2 = new Enrollments();
        studentEnrollment2.setId(501L);
        studentEnrollment2.setClassId(401L);
        studentEnrollment2.setStudentId(201L);
        Collections.addAll(enrollmentList, studentEnrollment1, studentEnrollment2);

        //*******************TEST!!!***8***8
        System.out.println("BEFORE ADDING ");
        //print();
        //printF();
        //printC();
        printEnrollment();
        //****************************************
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






    }//end main method
    //***test*****
    public static void print(){
        for(Student s : studentList){
            System.out.println("Student ID: " + s.getId());
            System.out.println("Student Name: " + s.getName());
            System.out.println("Student Email: " + s.getEmail());
            System.out.println("Student Password: " + s.getPassword());
        }

    }

    public static void printF(){
        for(Faculty f: facultyList){
            System.out.println("f ID: " + f.getId());
            System.out.println("f Name: " + f.getName());
            System.out.println("f Email: " + f.getEmail());
            System.out.println("f Password: " + f.getPassword());
        }

    }

    public static void printC(){
        for(Class c: classList){
            System.out.println("C ID: " + c.getId());
            System.out.println("C Name: " + c.getName());
            System.out.println("C DES: " + c.getDescription());

        }

    }

    public static void printEnrollment(){
        for(Enrollments en: enrollmentList){
            for(Class c: classList){
                if(en.getClassId() == c.getId()){
                    System.out.println(c.getName());
                    break;
                }
            }
            for(Student s: studentList){
                if(en.getStudentId() == s.getId()){
                    System.out.println(s.getName());
                    break;
                }
            }
        }

    }

    //***************
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

         //******TEST
         System.out.println("STUDENTS AFTER ADDING ");
         print();
         //***********
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
        System.out.println("Faculty after adding ");
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
        System.out.println("STUDENTS after editing ");
        print();
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
        System.out.println("Faculty after editing ");
        printF();
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
            System.out.println("New class added!");
            classList.add(classes);
            count++;

        }

        System.out.println();
        System.out.println("classes after adding ");
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
        System.out.println("Classes after editing ");
        printC();
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
            enrollmentList.add(enrollments);
            System.out.println("Student enrolled!");
            count++;
        }
        System.out.println("enrollments after adding: ");
        printEnrollment();
    }




}//end main class

/*
for(Student s : studentList){
                s.getId();
                s.getName();
                s.getEmail();
                s.getPassword();
            }
 */