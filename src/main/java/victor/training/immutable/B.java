package victor.training.immutable;

import javax.persistence.Embeddable;

@Embeddable
public class B {
   private int y;

   protected B() {
   }

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
