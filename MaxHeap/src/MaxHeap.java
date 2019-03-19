import java.util.List;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    //将传入的数组变成堆结构(heapify--数组建堆)
    public MaxHeap(E[] arr) {

        data = new Array<>(arr);
        //从第一个非叶子节点开始，执行下沉操作
        for(int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    //返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的父节点的索引
    private int parent(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent!");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的左孩子的索引
    private int leftChild(int index) {

        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的左孩子的索引
    private int rightChild(int index) {

        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //元素上浮的过程
    private void  siftUp(int k) {

        while( k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //看堆中的最大元素
    public E findMax() {
        if(data.getSize() == 0) {
            throw new IllegalArgumentException("Cannot find Max,Because Heap is empty");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() {

        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //元素下沉的过程
    private void siftDown(int k) {

        while(leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            //如果有右孩子并且右孩子大于左孩子
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            //data[j]是leftChild 和 rightChild 中的最大值
            if(data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //将最大元素替换成e，返回最大元素
    public E replace(E e) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);

        return ret;
    }
}
