package aoc.four;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.api.tuple.Pair;

public class Bingo {

    public class Score {
        ImmutableList<ImmutableIntList> row;
        int round;
    }

    public class Board {
        ImmutableList<ImmutableList<Pair<Integer, Boolean>>> board;


        Board(String input) {
            ImmutableList<String> lines = Lists.immutable.of(input.split("\n"));
            //this.board = lines.collect(each -> Lists.immutable.ofAll(Lists.immutable.of(each.split("\\s+")).collect(Integer::parseInt)
                                                                                    //.collect(i -> new Pair<Integer, Boolean>(i,  Boolean.FALSE))));
        }

    }


    public int bingo(String input) {
        ImmutableList<String> lineSeparated = Lists.immutable.with(input.split("^\\s+$"));
        IntList numbers = Lists.immutable.with(lineSeparated.get(0).split(",")).collectInt(Integer::parseInt);
        ImmutableList<Board> collect = lineSeparated.subList(1, lineSeparated.size()).collect(each -> new Board(each));

        return 0;
    }

    /*public int checkboard(IntList numbers, Board board) {
        final int[] index = {0};

        numbers.collect(each -> {

        });
        return 0;
    }
    public ImmutableList<ImmutableIntList> diagonal(Board board) {

    }*/
}
