package Other;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/minimum-index-sum-of-two-lists/solution/

// 用String作为键值
public class findRestaurant {
    public static String[] findRestaurant1(String[] list1, String[] list2) {

        Map<String,Integer> map = new HashMap<String,Integer>();
        List<String> res = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])){
                int tmpIndexSum =i+map.get(list2[i]);
                if(tmpIndexSum==minIndexSum){
                    res.add(list2[i]);
                }
                if(tmpIndexSum<minIndexSum) {
                    minIndexSum = tmpIndexSum;
                    res.clear();
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);


    }
    public static void main(String[] args) {
        // String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"},list2 = {"KFC", "Shogun", "Burger King"};
        // class Node{
        //     int value = 0;
        //     Node(int value){
        //         this.value = value;
        //     }
        // }
        // Node node1 = new Node(1);
        // Node node2 = new Node(2);
        // Node node3 = new Node(3);
        // Map<Node,Integer> map = new HashMap<Node,Integer>();
        // map.putIfAbsent(node1, 1);
        // map.putIfAbsent(node2, 2);
        // map.putIfAbsent(node3, 3);
    }
}




