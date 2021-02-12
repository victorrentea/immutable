package victor.training.immutable;

import lombok.NonNull;
import lombok.Value;
import lombok.With;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Value
public class A {
   @With
   int x;
   @NonNull
   List<Integer> list;
   @NonNull
   B b;

   public List<Integer> getList() {
      return Collections.unmodifiableList(list);
   }
}
