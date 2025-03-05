package Repository;

import Model.AppStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppStoreRepository extends JpaRepository<AppStore,Integer> {
}
