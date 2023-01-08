package Other;
import java.util.HashMap;
import java.util.Map;

public class firstUniqChar {
    public static int firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (char c : chars) {
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            // minfre
            if(map.get(chars[i]) == 1){
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar1(s));
    }
}
