package victor.training.immutable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public record A(int x, List<Integer> list, B b) {
   public A {
      Objects.requireNonNull(list);
      Objects.requireNonNull(b);
   }


   public List<Integer> list() {
      return Collections.unmodifiableList(list);
   }

   public A withX(int newX) {
      return new A(newX, list, b);
   }
}
