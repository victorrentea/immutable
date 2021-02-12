package victor.training.immutable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class A {
   private final int x;
   private final List<Integer> list;
   private final B b; // line 1

   public A(int x, List<Integer> list, B b) {
      this.x = x;
      this.list = Objects.requireNonNull(list);
      this.b = Objects.requireNonNull(b);
   }

   public List<Integer> getList() {
      return Collections.unmodifiableList(list); // line 3
   }

   public int getX() {
      return x;
   }

   public A withX(int newX) { // line 4
      return new A(newX, list, b);
   }

   public B getB() {
      return b;
   }

   @Override
   public String toString() {
      return String.format("Immutable{x=%d, numbers=%s, other=%s}", x, list, b);
   }
}
