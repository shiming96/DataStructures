public interface UF {

    int getSize();

    //判断两个元素是否连接(不关心哪两个元素,依据索引)
    boolean isConnected(int p, int q);

    //将两个元素合并在一起
    void unionElements(int p, int q);
}
