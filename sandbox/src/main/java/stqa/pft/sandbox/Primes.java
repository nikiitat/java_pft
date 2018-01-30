package stqa.pft.sandbox;

/**
 * Created by nikitatertytskyi on 30.01.2018.
 */
public class Primes {
    public static boolean isPrime(int n) {
        int m = (int) Math.sqrt(n);
        for (int i = 2; i < m; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWhile(int n) {
        int i = 0;
        while (i < n && n % i != 0) {
            i++;
        }
        return i == n;
    }
}
