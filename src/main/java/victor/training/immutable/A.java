package victor.training.immutable;

import com.google.common.collect.ImmutableList;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import java.util.List;

@Immutable
public abstract class A {
   @Parameter
   public abstract int x();
   @Parameter
   public abstract ImmutableList list();
   @Parameter
   public abstract ImmutableB b();

   public int logic() {
      return list().size() + x();
   }
}
