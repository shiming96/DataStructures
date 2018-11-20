public class Array<E> {

    private E[] data;
    private int size;

    //构造函数,传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    //无参构造函数,默认数组的容量capacity为10
    public Array() {
        this(10);//利用this调用有参构造
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向数组开头添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //向数组末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    public void  add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index > 0 Or index < size.");
        }
        if(size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1 ; i >= index ; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index > 0 Or index < size.");
        }
        E ret = data[index];
        for (int i = index + 1 ; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if(size == data.length / 4 && (data.length / 2) != 0) {
            resize(data.length / 2);
        }

        return ret;

    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //删除数组中第一个出现的元素
    public boolean removeElement(E e) {
        int index = find(e);
        if(index != - 1) {
            remove(index);
            return true;
        }
        return false;
    }

    //获取index索引位置的元素
    E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    //修改index索引位置的元素
    void set(int index , E e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找指定元素的索引
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size , data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if( i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
