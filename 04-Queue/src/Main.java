import java.util.Random;

public class Main {

    //测试使用q运行opCount个入队和出队耗费的时间  单位:秒
    private static double testQueue(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();
        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 500000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println(testQueue(arrayQueue,opCount));

        System.out.println("--------------");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println(testQueue(loopQueue,opCount));

        System.out.println("--------------");

        LinkedListQueue<Integer> linkedListQueue= new LinkedListQueue<>();
        System.out.println(testQueue(linkedListQueue,opCount));
    }
}
