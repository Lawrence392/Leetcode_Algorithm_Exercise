package Other;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;


class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }
    
    public void appendTail(int value) {
        stack1.add(value);



    }
    
    public int deleteHead() {
        if(stack1.isEmpty()){
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop()); 
        }
        int temp = stack2.pop();



    while(!stack2.isEmpty()){
            stack1.push(stack2.pop()); 
        }
        
        return temp;
    }
}


class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}

class Solution {
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }
    
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;// k >= 0
        if(k == 0){
            return;
        }
        reorder(nums, 0, len - 1);
        reorder(nums, 0, k-1);
        reorder(nums, k, len - 1);
    }
    public static void reorder(int[] nums, int begin, int end){
        int temp = 0;
        while(begin < end){
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }

    }
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        // int[] n = Solution.sortedSquares(nums);
        // for (int i : n) {
        //     System.out.println(i);
        // }
        Solution.rotate(nums,2);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class App {
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp = ' ';
        while(left < right){
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
    
    
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null)
        {
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode zero = new ListNode(-1,head);

        ListNode slow = zero;
        ListNode fast = head;

        while(n != 0){
            fast = fast.next;
            n--;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        
        }

        slow.next = slow.next.next;
        return zero.next;
    }
    
    public static int lengthOfLongestSubstring(String s) {// Set
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0;
        int right = 0;
        int count = 0;
        int temp = 0;
        while(right != len){
            if(!map.containsKey(chars[right])){
                map.putIfAbsent(chars[right], right);
            }else{
                temp = map.get(chars[right]) + 1;
                left = temp > left ? temp : left;
                map.put(chars[right], right);
            }
            count = count < right - left + 1 ? right - left + 1 : count;
            right++;
            
        }
        return count;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    public static int findRepeatNumber(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i) {
                //发现重复元素
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //置换，将指针下的元素换到属于他的索引处
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static int minStartValue(int[] nums) {
        int sum = 0;
        int min = 1;
        for(int i : nums){
            sum += i;
            min = Math.min(sum,min);
        }

        return min;
    }

    public static void main(String[] args) throws Exception {
        // CQueue cQueue = new CQueue();
        // cQueue.appendTail(1);
        // cQueue.appendTail(2);
        // cQueue.appendTail(3);
        // cQueue.appendTail(4);
        // for (int i = 0; i < 4; i++) {
        //     System.out.println(cQueue.deleteHead());
        // }

        // char[] s = {'h','e','l','l','o'};
        // App.reverseString(s);
        // for (char c : s) {
        //     System.out.println(c);
        // }
        // ListNode listNode5 = new ListNode(5);
        // ListNode listNode4 = new ListNode(4,listNode5);
        // ListNode listNode3 = new ListNode(3,listNode4);
        // ListNode listNode2 = new ListNode(2,listNode3);
        // ListNode listNode1 = new ListNode(1,listNode2);
        
        // middleNode;
        // ListNode listNode = middleNode(listNode1);
        // System.out.println(listNode.val);
        
        // lengthOfLongestSubstring
        // String s = "weewb";
        // int count = lengthOfLongestSubstring(s);
        // System.out.println(count);
        
        
        // findRepeatNumber
        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(nums));




    }
    
    
} 