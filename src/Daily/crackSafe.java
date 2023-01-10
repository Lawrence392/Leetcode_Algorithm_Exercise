package Daily;

import java.util.HashMap;
import java.util.Map;


public class crackSafe {
    public static String Solution(int n, int k) {
        Map<String,Integer> map = new HashMap<>();
        int kn = (int) Math.pow(k,n);//路径数量
        StringBuffer ans = new StringBuffer();
        //初始结点为000...
        for(int i = 1;i < n;i++){
            ans.append('0');
        }
        if(ans.length() == 0){
            for(int i = 0;i < k; i++){
                ans.append(i);
            }
            return ans.toString();
        }
        //遍历所有的路
        while (kn != 0){
            String substring = ans.substring(ans.length() - n + 1, ans.length());
            if(!map.containsKey(substring))
                map.put(substring,k-1);
            ans.append(map.get(substring));
            map.put(substring,map.get(substring) - 1);
            kn--;
        }
        return ans.toString();
    }
    public static void main(String[] args) {
            
        System.out.println(Solution(2,2));
    }
}
