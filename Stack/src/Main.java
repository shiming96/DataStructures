import java.util.Random;

public class Main {


    public static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10000000;
        System.out.println(testStack(new ArrayStack<Integer>(), opCount));
        System.out.println("---------");

        System.out.println(testStack(new LinkedListStack<Integer>(), opCount));

        //理论上复杂度相同
        //但LinkedListStack包含更多的new操作，数据量大的时候比较费时。

    }
}
