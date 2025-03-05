package Services.AppStore;

import Model.AppStore;
import Requests.AddProductRequest;

import java.util.List;

public interface iAppStoreInterface {

    AppStore addProduct(AddProductRequest request);
    AppStore getProductById(Integer id);
    void deleteProductById(Integer id);
    List<AppStore> getAllProducts();
    AppStore updateProduct(Integer id , AppStore product);
}
