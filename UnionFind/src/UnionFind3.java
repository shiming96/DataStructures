/**
 * 基于size优化树结构实现的并查集
 */

public class UnionFind3 implements UF {
    private int[] parent;
    private int[] sz;  //sz[i]表示以i为根的集合中元素个数

    public UnionFind3(int size) {

        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查找过程,查找元素p所对应的集合编号
    //O(h)复杂度，h为树的高度
    private int find(int p) {

        if(p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound !");

        //循环到根节点
        while(p != parent[p])
            p = parent[p];
        return p;
    }

    //查看p和q是否所属一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    //合并元素p和元素q所属的集合
    //O(h)复杂度,h为树的高度
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        //节点元素少的指向节点元素多的
        if(sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }
}
