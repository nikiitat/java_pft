package stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nikitatertytskyi on 31.01.2018.
 */
public class Collections {

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<String>();
        List<String> numbers2 = Arrays.asList("1", "2", "3", "4");

        numbers.add("5");
        numbers.add("6");
        numbers.add("7");
        numbers.add("8");

        for (String l : numbers2) {
            System.out.println("Numbers2 " + l);
        }

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("Numbers = " + numbers.get(i));
        }
    }
}
