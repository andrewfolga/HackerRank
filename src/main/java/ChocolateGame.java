import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by andrzejfolga on 15/04/2017.
 */
public class ChocolateGame {

    private static final int Nmax = 100000 + 2;

    static int[] d = new int[Nmax];
    static Map<Integer, Integer> map = new HashMap<>();

    static int N;
    static long ans = 0;

    static void solve(int even) {
        map.clear();
        map.put(0, 1);

        int xorsum = 0;

        for (int i = N - even - 1; i >= 0; i -= 2) {
            int aux = d[i];

            if (i > 0) aux -= d[i - 1];

            map.putIfAbsent(xorsum ^ d[i], 0);
            ans += map.get(xorsum ^ d[i]);

            map.putIfAbsent(xorsum ^ aux, 0);
            if (i > 0) ans += map.get(xorsum ^ aux);

            xorsum ^= aux;
            map.merge(xorsum, 1, (a, b) -> a + b);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        for (int pile_i = 0; pile_i < N; pile_i++) {
            d[pile_i] = in.nextInt();
        }

        solve(0);
        solve(1);

        System.out.println(1L * N * (N - 1) / 2 - ans);

    }

}
