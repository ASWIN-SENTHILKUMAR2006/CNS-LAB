import java.util.Scanner;

public class SchnorrSignature {

    // Modular exponentiation
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

    // Simple hash function (for demo purpose only)
    static long hash(long value, long mod) {
        return value % mod;  // Not secure, just for lab
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long p, q, g, x, y;
        long k, r, e, s, m;
        long v1, v2;

        // Inputs
        System.out.print("Enter prime p: ");
        p = sc.nextLong();

        System.out.print("Enter prime q (q divides p-1): ");
        q = sc.nextLong();

        System.out.print("Enter generator g: ");
        g = sc.nextLong();

        System.out.print("Enter private key x: ");
        x = sc.nextLong();

        System.out.print("Enter message (integer): ");
        m = sc.nextLong();

        // Public key
        y = modExp(g, x, p);

        // Signature generation
        System.out.print("Enter random k: ");
        k = sc.nextLong();

        r = modExp(g, k, p);
        e = hash(r + m, q);   // Challenge
        s = (k + x * e) % q;

        System.out.println("\n--- Signature ---");
        System.out.println("e = " + e);
        System.out.println("s = " + s);

        // Verification
        v1 = modExp(g, s, p);
        v2 = (modExp(y, e, p) * r) % p;

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