package Services.AppStore;

import Model.AppStore;

import java.util.List;

public class AppStoreService implements iAppStoreInterface{

    @Override
    public AppStore addProduct(AppStore product) {
        return null;
    }

    @Override
    public AppStore getProductById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteProductById(Integer id) {
        return false;
    }

    @Override
    public List<AppStore> getAllProducts() {
        return List.of();
    }
}
