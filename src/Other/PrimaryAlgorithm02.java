package Other;
public class PrimaryAlgorithm02 {
    public static void main(String[] args) {
        
        int[] prices = {7,1,5,3,6,4};
        int res = 7;
        
        if(maxProfit(prices) != res){
            System.out.println("Error!");
        }
    }
    
    
    public static int maxProfit(int[] prices) {
        int head = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[head] < prices[i]){
                profit += prices[i] - prices[head];
            }
            head = i;
        }
        return profit;
    }
}
