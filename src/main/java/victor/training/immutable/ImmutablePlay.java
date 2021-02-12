package victor.training.immutable;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ImmutablePlay {
   public static void main(String[] args) {
      List<Integer> numbers = Stream.of(1, 2, 3).collect(toList());

      ImmutableA a = ImmutableA.of(1, ImmutableList.copyOf(numbers), new ImmutableB(15));

      ImmutableA a2 = a.withX(99);

      System.out.println(a2);

   }
}

