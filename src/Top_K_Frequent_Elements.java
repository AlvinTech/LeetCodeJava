import java.util.*;

/**
 * Created by Alvin on 16/12/13.
 */
/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
* */
public class Top_K_Frequent_Elements {

    public class Node implements Comparable<Node> {
        public int value;
        public int key;

        public Node(Integer key, int value) {
            this.value = value;
            this.key = key;
        }

        @Override public int compareTo(Node o) {
            if (this.key > o.key) {
                return -1;
            }
            else if (this.key < o.key) {
                return 1;
            }
            else {
                return 0;
            }

        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            }
            else {
                map.put(value, 1);
            }
        }

        List<Node> nodes = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            nodes.add(new Node(map.get(i), i));
        }
        Collections.sort(nodes);
        for (int i = 0; i < k; i++) {
            list.add(nodes.get(i).value);
        }

        return list;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = { 1, 1, 2, 2, 2, 3 };
        System.out.println(new Top_K_Frequent_Elements().topKFrequent(nums, k));
    }
}
