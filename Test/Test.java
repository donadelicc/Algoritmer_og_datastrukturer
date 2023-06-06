package Test;

public class Test {

    public static void main(String[] args) {
        System.out.println(f(4, 2));
    }

    public static int f(int n, int k) {
        if (k == 1) {
        return n;
        } else if(n == k) {
        return 1;
        } else {
        return f(n - 1, k) + f(n - 1, k - 1);
        }
    }
        
    
}
