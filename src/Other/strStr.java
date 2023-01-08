package Other;
public class strStr{
    public static int strStr1(String haystack, String needle){
        if(needle.length()==0) return 0;
        
        
        int[] next = Buildnums(needle);
        
        int hlen = haystack.length();
        int htemp = 0;

        int nlen = needle.length();
        int ntemp = 0;

        while(htemp < hlen && ntemp < nlen){
            if(ntemp < 0 || haystack.charAt(htemp) ==  needle.charAt(ntemp)){
                htemp++;
                ntemp++;
            }else{
                ntemp = next[ntemp];
            }
        }
        if(ntemp == nlen){
            return htemp - ntemp;
        }else{
            return -1;
        }
    }
    public static int[] Buildnums(String needle){
        char[] needchars = needle.toCharArray();
        int len = needchars.length;
        int[] next = new int[len];
        int temp = 0;
        int head = next[0] = -1;


        // temp指针遍历字符数组
        // head始终保持在数组头部

        while(temp < len - 1){
            if( head < 0 || needchars[temp] == needchars[head]){
                temp++;
                head++;
                next[temp] = head;
            }else{
                head = next[head];
            }
        }
        return next;
    }
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int p = strStr1(haystack,needle);
        System.out.println(p);

        // return haystack.indexOf(needle);
    }

}