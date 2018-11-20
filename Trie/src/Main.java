import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("pride-and-prejudice.txt");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {

            long startTime = System.nanoTime();

            BSTSet<String> bstSet = new BSTSet<>();
            for (String word : words)
                bstSet.add(word);

            for (String word : words) {
                bstSet.contains(word);
            }
            long endTime=  System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + bstSet.getSize());
            System.out.println("BSTSet:" + time);

            System.out.println("-------------------");


            long startTime1 = System.nanoTime();

            Trie trie = new Trie();
            for (String word : words)
                trie.add(word);

            for (String word : words) {
                trie.contains(word);
            }
            long endTime1=  System.nanoTime();
            double time1 = (endTime1 - startTime1) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("trie:" + time1);

            System.out.println("-------------------");



        }
    }
}
