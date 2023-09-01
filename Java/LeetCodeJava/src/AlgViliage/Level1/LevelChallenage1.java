package AlgViliage.Level1;

/**
 * @author 欧欧
 * @version 1.0
 */
public class LevelChallenage1 {
    public static void main(String[] args) {
        Student head = new Student("aa", "java");
        head.next = new Student("ab", "java");
        head.next.next = new Student("ba", "cpp");
        head.next.next.next = new Student("bb", "cpp");
        head.next.next.next.next = new Student("ca", "python");
        head.next.next.next.next.next = new Student("cb", "python");
        addStudent(head, "ac", "java");
        addStudent(head, "bc", "cpp");
        addStudent(head, "cc", "python");
        addStudent(head, "bd", "cpp");
        while (head != null) {
            head.displayStudent();
            head = head.next;
        }
    }

    public static Student addStudent(Student head, String name, String language) {
        Student newStudent = new Student(name, language);
        Student temp = head;
        while(temp.next != null) {
            if (temp.language == newStudent.language && temp.next.language != newStudent.language) {
                newStudent.next = temp.next;
                temp.next = newStudent;
                return head;
            } else {
                temp = temp.next;
            }


        }
        return head;
    }
}

class Student {
    public String name;
    public String language;
    public Student next;

    public Student(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public void displayStudent() {
        System.out.println("{" + name  + ", " + language + "} ");
    }
}
