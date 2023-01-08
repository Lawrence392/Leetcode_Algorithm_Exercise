package Other;
public class PrimaryAlgorithm11 {

    public static void change(Quote quote){
        quote.a = 2;
    }
    public static void main(String[] args) {
        Quote quote = new Quote();
        change(quote);
        System.out.println(quote.a);
    }

}
class Quote{
    public Quote(){
        
    }
    int a = 1;
}
