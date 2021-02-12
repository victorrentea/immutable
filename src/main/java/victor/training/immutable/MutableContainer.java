package victor.training.immutable;

import victor.training.immutable.A;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class MutableContainer {
   @Id
   @GeneratedValue
   private Long id;
   @Embedded
   private A a;

   protected MutableContainer() {
   }

   public MutableContainer(A a) {
      this.a = Objects.requireNonNull(a);
   }

   public Long getId() {
      return id;
   }

   public A getA() {
      return a;
   }

   public void setA(A a) {
      this.a = Objects.requireNonNull(a); // otherwise exception at persist of null
   }
}
