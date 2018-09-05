package methods.first;

public class Factorial {
    public static int factorial(int n){
        int a = 1;
        for (int b = 1; b <= n; b++){
            a = a*b;
        }
        return a;
    }

    public static void main(String[] args){
        System.out.println(factorial(12));
    }

}
