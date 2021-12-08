package aoc.six;

import org.eclipse.collections.api.factory.Lists;

import java.util.Arrays;

public class Lanternfish {

    public int populate(int days, String input) {
        var fish = Lists.mutable.with(input.split(",")).collectInt(Integer::parseInt).toArray();

        for (int i=1; i<= days; i++) {
            int newFish = 0;
            for(int j = 0 ; j < fish.length ; j++) {
                if (fish[j] == 0) {
                    fish[j] = 6;
                    newFish++;
                } else {
                    fish[j]--;
                }
            }
            fish = Arrays.copyOf(fish, fish.length + newFish);
            for (int h = fish.length - 1; h > (fish.length - 1 - newFish); h--) {
                fish[h] = 8;
            }
        }

        return fish.length;
    }

}
