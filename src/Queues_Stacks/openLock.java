package Queues_Stacks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class openLock {

    public static void main(String[] args) {
        String target = "0202";
        String[] deadends = {"0201","0101","0102","1212","2002"};
        // System.out.println(target.substring(3));
        System.out.println(Solution(deadends,target));
    }

    public static int Solution(String[] deadends, String target) {
        Set<String> Lock = new HashSet<String>(Arrays.asList(deadends));
        // 创建队列

        String start = "0000";
        if (Lock.contains(start)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);

        Set<String> set = new HashSet<String>();
        set.add(start);

        // 记录步数
        int count = 0;
        int size = 0;
        // 树节点(使用递归代替节点)
        while(!queue.isEmpty()){
            size = queue.size();
            while(size-- > 0) {
                String string = queue.poll();
                // 八个节点
                for (int i = 0; i < 4; i++) {
                    char ch = string.charAt(i);
                    //strAdd表示加1的结果，strSub表示减1的结果
                    String strAdd = string.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1) + string.substring(i + 1);
                    String strSub = string.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + string.substring(i + 1);
                    //如果找到直接返回
                    if (string.equals(target))
                        return count;
                    //不能包含死亡数字也不能包含访问过的字符串
                    if (!set.contains(strAdd) && !Lock.contains(strAdd)) {
                        queue.offer(strAdd);
                        set.add(strAdd);
                    }
                    if (!set.contains(strSub) && !Lock.contains(strSub)) {
                        queue.offer(strSub);
                        set.add(strSub);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
