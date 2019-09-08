package questions;

import java.util.Scanner;

/**
 * @ClassName Fibonacci
 * @Description Program for Fibonacci numbers
 * @Author NebulaPort
 * @Date 2019/7/29 16:56
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=0;
        n=in.nextInt();
        System.out.println(fibRecursion(n));
        System.out.println(fibMethod2(n));
        System.out.println(fibMethod3(n));
        System.out.println(fibMethod5(n));
        System.out.println(fibMethod7(n));
    }

/**
 * Method 1 ( Use recursion )
 * */
static int fibRecursion(int n)
    {
        if (n <= 1) {
            return n;
        }
        return fibRecursion(n-1) + fibRecursion(n-2);
    }


    /**
 * Method 2 ( Use Dynamic Programming )
 * */
    private static int fibMethod2(int n) {
        int f[]=new int[n+2];
        f[0]=0;
        f[1]=1;
        for(int i=2;i<=n;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];
    }
/**
 * Method 3 ( Space Optimized Method 2 )
 * */
private static int fibMethod3(int n){
    int a = 0, b = 1, c;
    if (n == 0) {
        return a;
    }
    for (int i = 2; i <= n; i++)
    {
        c = a + b;
        a = b;
        b = c;
    }
    return b;
}
/**
 * Method 4 ( Using power of the matrix {{1,1},{1,0}} )
 * */
/*
private static int fibMethod4(int n){
    int F[][] = new int[][]{{1,1},{1,0}};
    if (n == 0) {
        return 0;
    }
    power(F, n-1);

    return F[0][0];
}

    */
/** Helper function that multiplies 2 matrices F and M of size 2*2, and
    puts the multiplication result back to F[][] *//*

    static void multiply(int F[][], int M[][])
    {
        int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
        int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
        int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
        int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    */
/** Helper function that calculates F[][] raise to the power n and puts the
    result in F[][]
    Note that this function is designed only for fib() and won't work as general
    power function *//*

    static void power(int F[][], int n)
    {
        int i;
        int M[][] = new int[][]{{1,1},{1,0}};

        // n - 1 times multiply the matrix to {{1,0},{0,1}}
        for (i = 2; i <= n; i++) {
            multiply(F, M);
        }
    }
*/

/**
 * Method 5 ( Optimized Method 4 )
 *
 * */
private static int fibMethod5(int n){
    int F[][] = new int[][]{{1,1},{1,0}};
    if (n == 0) {
        return 0;
    }
    power(F, n-1);

    return F[0][0];
}

    static void multiply(int F[][], int M[][])
    {
        int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
        int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
        int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
        int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    /** Optimized version of power() in method 4 */
    static void power(int F[][], int n)
    {
        if( n == 0 || n == 1) {
            return;
        }
        int M[][] = new int[][]{{1,1},{1,0}};

        power(F, n/2);
        multiply(F, F);

        if (n%2 != 0) {
            multiply(F, M);
        }
    }

/**
 * Method 6 (O(Log n) Time)
 * */
   /* static int MAX = 1000;
    static int f[];
private static int fibMethod6(int n){
// Base cases
    if (n == 0)
        return 0;

    if (n == 1 || n == 2)
        return (f[n] = 1);

    // If fib(n) is already computed
    if (f[n] != 0)
        return f[n];

    int k = (n & 1) == 1? (n + 1) / 2
            : n / 2;

    // Applyting above formula [Note value
    // n&1 is 1 if n is odd, else 0.
    f[n] = (n & 1) == 1? (fibMethod6(k) * fibMethod6(k) +
            fibMethod6(k - 1) * fibMethod6(k - 1))
            : (2 * fibMethod6(k - 1) + fibMethod6(k))
            * fibMethod6(k);

    return f[n];
}*/

/**
 *Method 7
 * Another approach:(Using formula)
 * Fn = {[(√5 + 1)/2] ^ n} / √5
 * */
private static int fibMethod7(int n){
    double phi = (1 + Math.sqrt(5)) / 2;
    return (int) Math.round(Math.pow(phi, n)
            / Math.sqrt(5));
}

}


