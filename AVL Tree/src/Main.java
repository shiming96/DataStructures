import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        System.out.println("pride-and-prejudice.txt");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {

            Collections.sort(words);
            long startTime = System.nanoTime();
            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if(!bst.contains(word))
                    bst.add(word, 1);
                else
                    bst.add(word, bst.get(word) + 1);
            }

            for (String word : words) {
                bst.contains(word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST :" + time + "s");

            long startTime1 = System.nanoTime();
            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if(!avl.contains(word))
                    avl.add(word, 1);
                else
                    avl.add(word, avl.get(word) + 1);
            }

            for (String word : words) {
                avl.contains(word);
            }

            long endTime1 = System.nanoTime();

            double time1 = (endTime1 - startTime1) / 1000000000.0;
            System.out.println("AVL :" + time1 + "s");
        }
    }
}
