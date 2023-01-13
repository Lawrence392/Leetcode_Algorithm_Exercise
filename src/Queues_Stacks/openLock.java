package Queues_Stacks;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class openLock {

    public static void main(String[] args) {
        String s3 ="000";
        System.out.println(s3 == "000");

        String target = "0202";
        // String[] deadends = {"0201","0101","0102","1212","2002"};
        // System.out.println(Solution.openLock(deadends,target));
    }
}
/**
 * InneropenLock
 */
class Solution {
    public static int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<String>();
        // 创建队列

        String start = "0000";
        if (start == target) {
            return -1;
        }
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(target);
        
        
        // 使用循环将deadends中的锁全部导入Set
        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }
        // start也计入set
        set.add(start);
        
        // 记录步数
        int count = 0;
        int size = 0;
        // 树节点(使用递归代替节点)
        tree(target, queue);
        while(!queue.isEmpty()){
            count++;

            size = queue.size();
            for (int i = 0; i < size; i++) {
                
                // 八个节点
                queue.add((start+1));

                if(set.contains(start)){
                    continue;
                }
                
            }

            if (target == "0000") {
                break;
            }
        }

        return count;
    }
    public static void tree(String target, Queue<String> queue) {

        
    }
}
