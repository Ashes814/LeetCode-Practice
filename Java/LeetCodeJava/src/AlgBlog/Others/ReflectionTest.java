package AlgBlog.Others;

public class ReflectionTest {

    public static void main(String[] args) {
//        Class.forName("AlgBlog.Others");
    }
}

class User {
    private String name;
    private int id;
    private int age;


    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
