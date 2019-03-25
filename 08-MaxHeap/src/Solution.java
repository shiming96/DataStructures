import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
class Solution {

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        //重写compareTo方法，自定义优先队列中的优先级
        @Override
        public int compareTo(Freq another) {
            if(this.freq < another.freq) {
                //与java中的规定成反逻辑
                //频率低的优先级高(即为根节点)
                return 1;
            }
            else if(this.freq > another.freq) {
                //频率高的优先级低
                return -1;
            } else {
                return 0;
            }
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {

        //统计频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key : map.keySet()) {
            if(pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            }
            //当前key的频次比优先队列中频次最小的值大时
            else if(map.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()) {
            res.add(pq.dequeue().e);
        }
        return res;
    }
}