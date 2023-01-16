package Daily;


public class areSentencesSimilar {
    public static void main(String[] args) {
        // String sentence1 = "My name is Haley", sentence2 = "My Haley";
        // String sentence1 = "of", sentence2 = "A lot of words";
        String sentence1 = "words", sentence2 = "A lot of words";
        // String sentence1 = "A of words", sentence2 = "A lot of words";


        System.out.println(Solution(sentence1, sentence2));
    }
    public static boolean Solution(String sentence1, String sentence2) {
        String[] strings1 = sentence1.split(" ");
        String[] strings2 = sentence2.split(" ");
        String[] strings3;
        // Swap
        if(strings1.length > strings2.length) {
        }else{
            strings3 = strings1;
            strings1 = strings2;
            strings2 = strings3;
        }

        int i = 0;
        int len1 = strings1.length -1;
        int len2 = strings2.length -1;
        if(len2 == 0){

            return strings1[0].equals(strings2[0]) || strings1[len1].equals(strings2[0]);
        }

        while(strings1[i].equals(strings2[i])){
            i++;
            if(i > len2){
                return true;
            }
        }


        while(i <= len2){
            if (!strings1[len1].equals(strings2[len2])) {
                return false;
            }
            len1--;
            len2--;
        }
        return true;
    }
    public static boolean Solution2(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0, j = 0;
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        while (j < words1.length - i && j < words2.length - i && words1[words1.length - j - 1].equals(words2[words2.length - j - 1])) {
            j++;
        }
        return i + j == Math.min(words1.length, words2.length);
    }
}
