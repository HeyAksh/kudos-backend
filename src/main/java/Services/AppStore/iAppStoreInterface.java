package Services.AppStore;

import Model.AppStore;
import java.util.List;

public interface iAppStoreInterface {

    AppStore addProduct(AppStore product);
    AppStore getProductById(Integer id);
    boolean deleteProductById(Integer id);
    List<AppStore> getAllProducts();
}
