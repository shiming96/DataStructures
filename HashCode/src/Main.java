import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        int a = 42;
        System.out.println(((Integer) a).hashCode());

        int b = -42;
        System.out.println(((Integer) b).hashCode());

        Student student = new Student(3, 2, "明", "师");
        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<Student>();
        set.add(student);

        HashMap<Student, Integer> scores = new HashMap<Student, Integer>();
        scores.put(student, 100);


    }
}
