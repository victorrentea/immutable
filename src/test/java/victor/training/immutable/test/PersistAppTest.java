package victor.training.immutable.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import victor.training.immutable.A;
import victor.training.immutable.B;
import victor.training.immutable.MutableContainer;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersistAppTest {

   @Autowired
   private SomeService service;

   @Test
   public void provesWritten() {
      Long id = service.create(1);

      service.updateX(id, 99);

      assertEquals(99, service.getX(id));;
   }
}

@Transactional
@Service
class SomeService {
   private final MutableContainerRepo repo;

   SomeService(MutableContainerRepo repo) {
      this.repo = repo;
   }
   public Long create(int x) {
      A a = new A(x, Collections.emptyList(), new B(2));
      MutableContainer container = new MutableContainer(a);
      return repo.save(container).getId();
   }

   public void updateX(Long id, int newX) {
      MutableContainer container = repo.findById(id).get();
      A newA = container.getA().withX(newX);
      container.setA(newA);
   }
   public int getX(Long id) {
      MutableContainer container = repo.findById(id).get();
      return container.getA().x();
   }
}

interface MutableContainerRepo extends JpaRepository<MutableContainer, Long> {
}

