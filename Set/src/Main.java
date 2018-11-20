import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
//        demo1();
        System.out.println(testSet(new LinkedListSet<String>(), "pride-and-prejudice.txt"));

        System.out.println("--------");
        System.out.println(testSet(new BSTSet<String>(), "pride-and-prejudice.txt"));

        System.out.println("--------");
        System.out.println(testSet(new AVLSet<String>(), "pride-and-prejudice.txt"));
    }

    private static void demo1() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",word1);
        System.out.println("Total word1:" + word1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for(String word : word1) {
            set1.add(word);
        }
        System.out.println("Total different words:" + set1.getSize());

        System.out.println("------------");

        System.out.println("a-tale-of-two-cities.txt");

        ArrayList<String> word2 = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt",word2);
        System.out.println("Total word2:" + word2.size());

        BSTSet<String> set2 = new BSTSet<>();
        for(String word : word2) {
            set2.add(word);
        }
        System.out.println("Total different words:" + set2.getSize());
    }
}
