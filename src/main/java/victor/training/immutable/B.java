package victor.training.immutable;

import org.immutables.value.Value;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
@Value.Style(of = "new")
public abstract class B {
   @Parameter
   public abstract int y();
}
