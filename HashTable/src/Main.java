import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("pride-and-prejudice.txt");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {

//            Collections.sort(words);

            //Test BST
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

            //Test AVL
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

            //Test RBTree
            long startTime2 = System.nanoTime();
            RBTree<String, Integer> rbTree = new RBTree<>();
            for (String word : words) {
                if(!rbTree.contains(word))
                    rbTree.add(word, 1);
                else
                    rbTree.add(word, rbTree.get(word) + 1);
            }

            for (String word : words) {
                rbTree.contains(word);
            }

            long endTime2 = System.nanoTime();

            double time2 = (endTime2 - startTime2) / 1000000000.0;
            System.out.println("RBTree :" + time2 + "s");

            //Test HashTable
            long startTime3 = System.nanoTime();
            HashTable<String, Integer> ht = new HashTable<>();
            for (String word : words) {
                if(!ht.contains(word))
                    ht.add(word, 1);
                else
                    ht.add(word, ht.get(word) + 1);
            }

            for (String word : words) {
                ht.contains(word);
            }

            long endTime3 = System.nanoTime();

            double time3 = (endTime3 - startTime3) / 1000000000.0;
            System.out.println("HashTable :" + time3 + "s");
        }
    }
}
