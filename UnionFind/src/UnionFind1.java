/**
 * 底层数组模拟实现并查集
 */

public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {

        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

    }

    //查找元素p所对应的集合编号
    private int find(int p) {
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out pf bound !");
        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //查询元素P和元素q是否处于同一个集合中
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p和元素q的集合
    @Override
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID;
        }

    }
}
