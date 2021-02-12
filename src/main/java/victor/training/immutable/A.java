package victor.training.immutable;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Embeddable
public class A {
   private int x;
   @ElementCollection
   private List<Integer> list;
   @Embedded
   private B b; // line 1

   protected A() {
   } // For Hibernate only

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
