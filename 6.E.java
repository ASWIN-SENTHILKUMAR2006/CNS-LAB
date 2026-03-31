import java.util.Scanner;

public class ElGamalSignature {

    // Function for modular exponentiation
    static long modExp(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;

        while (exp > 0) {
            if (exp % 2 == 1)
                result = (result * base) % mod;

            exp = exp / 2;
            base = (base * base) % mod;
        }
        return result;
    }

    // Function to find GCD
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    // Function to find modular inverse
    static long modInverse(long a, long m) {
        long m0 = m, t, q;
        long x0 = 0, x1 = 1;

        if (m == 1)
            return 0;

        while (a > 1) {
            q = a / m;
            t = m;

            m = a % m;
            a = t;
            t = x0;

            x0 = x1 - q * x0;
            x1 = t;
        }

        if (x1 < 0)
            x1 += m0;

        return x1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long p, g, x, k, m;
        long y, r, s, kInv, v1, v2;

        // Inputs
        System.out.print("Enter prime number p: ");
        p = sc.nextLong();

        System.out.print("Enter primitive root g: ");
        g = sc.nextLong();

        System.out.print("Enter private key x: ");
        x = sc.nextLong();

        System.out.print("Enter random number k (gcd(k, p-1)=1): ");
        k = sc.nextLong();

        System.out.print("Enter message (integer): ");
        m = sc.nextLong();

        // Public key
        y = modExp(g, x, p);

        // Signature generation
        r = modExp(g, k, p);
        kInv = modInverse(k, p - 1);

        s = (kInv * (m - x * r)) % (p - 1);
        if (s < 0)
            s += (p - 1);

        System.out.println("\n--- Signature ---");
        System.out.println("r = " + r);
        System.out.println("s = " + s);

        // Verification
        v1 = (modExp(y, r, p) * modExp(r, s, p)) % p;
        v2 = modExp(g, m, p);

        System.out.println("\n--- Verification ---");
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);

        if (v1 == v2)
            System.out.println("Signature is VALID");
        else
            System.out.println("Signature is INVALID");

        sc.close();
    }
}