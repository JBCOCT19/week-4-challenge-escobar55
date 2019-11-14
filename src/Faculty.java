public class Faculty extends Admin { //Applied inheritance

    public Faculty(){
    }

    public Faculty(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override //applied polymorphism
    public String welcomeMessage(){
        return "Welcome Faculty Member!";
    }
}
