package Queues_Stacks;

import java.util.Queue;

import java.util.ArrayList;
import java.util.LinkedList;

public class numSquares {
    public static void main(String[] args) {
        System.out.println(Solution(13));
    }
    public static int Solution(int n) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int max = 1;
        // 记录节点个数
        for (int i = 1; max < n; i++) {
            arrayList.add(max);
            max = (i + 1)*(i + 1);
        }
        if(n == max){
            return 1;
        }
        Integer[] array = new Integer[arrayList.size()];
        arrayList.toArray(array);
        // 记录次数
        int count = 1;
        int size = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        while(!queue.isEmpty()){
            size = queue.size();
            while(size-- > 0) {
                int num = queue.poll();
                for (int i = array.length - 1; i >= 0; i--) {
                    int subnum = num - array[i];
                    if(subnum == 0){
                        return count;
                    }else if(subnum > 0){
                        queue.add(subnum);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static int Solution2(int n) {
        // 记录节点个数
        int max_factor = (int)Math.sqrt(n);
        if(n == max_factor*max_factor){
            return 1;
        }
        int[] array = new int[max_factor];
        for (int i = 0; i < max_factor; i++) {
            array[i] = (i+1)*(i+1);
        }
        // 记录次数
        int count = 0;
        int size = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        while(!queue.isEmpty()){
            size = queue.size();
            count++;
            while(size-- > 0) {
                int num = queue.poll();
                for (int i = array.length - 1; i >= 0; i--) {
                    int subnum = num - array[i];
                    if(subnum == 0){
                        return count;
                    }else if(subnum > 0){
                        queue.add(subnum);
                    }
                }
            }
        }
        return -1;
    }
}
