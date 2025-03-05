package Services.AppStore;

import Model.AppStore;
import Repository.AppStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppStoreService implements iAppStoreInterface{

    @Autowired
    private AppStoreRepository appStoreRepository;

    @Override
    public AppStore addProduct(AppStore product) {
        return appStoreRepository.save(product);
    }

    @Override
    public AppStore getProductById(Integer id) {
        Optional<AppStore> product = appStoreRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public boolean deleteProductById(Integer id) {
        if (appStoreRepository.existsById(id)) {
            appStoreRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<AppStore> getAllProducts() {
        return appStoreRepository.findAll();
    }
}
