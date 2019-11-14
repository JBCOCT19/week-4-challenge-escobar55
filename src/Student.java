public class Student extends Admin {

    public Student() {
    }

    public Student(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override //applied polymorphism
    public String welcomeMessage(){
        return "Welcome Student";
    }

}
