import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * Created by andrzejfolga on 13/04/2017.
 */
public class BirthdayCakeCandles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int height[] = new int[n];
        for (int height_i = 0; height_i < n; height_i++) {
            height[height_i] = in.nextInt();
        }

        System.out.println(Arrays.stream(height).
                boxed().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().
                stream().
                sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).
                map(Map.Entry::getValue).
                findFirst().
                get());
    }
}
