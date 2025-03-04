package Repository;

import Model.AppStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppStoreRepository extends JpaRepository<AppStore,Integer> {
}
