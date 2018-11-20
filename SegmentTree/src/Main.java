public class Main {

    public static void main(String[] args) {

        Integer[] nums = {-2, 0, 3, -5};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });

        System.out.println(segTree.query(0, 1));

        System.out.println(segTree);

    }
}


