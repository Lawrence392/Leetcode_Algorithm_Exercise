package Other;
// https://leetcode.cn/leetbook/read/array-and-string/ceda1/
// 最长公共前缀
// 输入：strs = ["flower","flow","flight"]
// 输出："fl"

// 输入：strs = ["dog","racecar","car"]
// 输出：""
// 解释：输入不存在公共前缀



public class longestCommonPrefix {
    public static String name(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if(strs[i].startsWith(prefix)){
                continue;
            }else{
                while (true) {
                    prefix = prefix.substring(0,prefix.length()-1);
                    if(strs[i].startsWith(prefix)){
                        break;
                    }
                }
            }


        }



        return prefix;
    }
    public static void main(String[] args) {
        String[] strs = {"flower","dlow","flight"};
        String string =  name(strs);
        System.out.println(string);



    }
}
