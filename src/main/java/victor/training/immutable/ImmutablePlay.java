package victor.training.immutable;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ImmutablePlay {
   public static void main(String[] args) {
      List<Integer> numbers = Stream.of(1, 2, 3).collect(toList());

      A a = new A(1, numbers, new B(15));

      System.out.println(a);

   }
}

class A {
   private final int x;
   private final List<Integer> numbers;
   private final B other;

   public A(int x, List<Integer> numbers, B other) {
      this.x = x;
      this.numbers = numbers;
      this.other = other;
   }
   public int getX() {
      return x;
   }
   public List<Integer> getNumbers() {
      return numbers;
   }
   public B getOther() {
      return other;
   }

   @Override
   public String toString() {
      return String.format("Immutable{x=%d, numbers=%s, other=%s}", x, numbers, other);
   }
}

class B {
   private int y;

   public B(int y) {
      this.y = y;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }
}
