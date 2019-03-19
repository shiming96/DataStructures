public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addFirst(new Student("张三",23));
        arr.addFirst(new Student("李四",24));
        arr.addFirst(new Student("王五",26));
        arr.addFirst(new Student("王五",26));
        arr.addFirst(new Student("王五",26));
        System.out.println(arr.getCapacity());
        arr.addFirst(new Student("王五",26));
        arr.addFirst(new Student("王五",26));
        arr.addFirst(new Student("王五",26));
        arr.addFirst(new Student("王五",26));
        System.out.println(arr);
        System.out.println(arr.getCapacity());
    }
}
