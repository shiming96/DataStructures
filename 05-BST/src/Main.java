import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty()) {
//            nums.add(bst.removeMin());
            nums.add(bst.removeMax());
        }
        System.out.println(nums);

/*        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num: nums) {
            bst.add(num);
        }
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        bst.inOrder();
        System.out.println("-------");
        bst.preOrderNR();
        bst.levelOrder();   //广度优先遍历
        bst.postOrder();
        System.out.println();
        System.out.println(bst);*/

    }
}
