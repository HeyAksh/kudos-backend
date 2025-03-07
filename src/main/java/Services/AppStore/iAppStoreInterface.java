package Services.AppStore;

import Model.AppStore;
import Requests.AddProductRequest;
import Requests.UpdateProductRequest;
import Response.AppStoreResponse;

import java.util.List;

public interface iAppStoreInterface {

    AppStore addProduct(AddProductRequest request);
    AppStore getProductById(Integer id);
    void deleteProductById(Integer id);
    List<AppStoreResponse> getAllProducts();
    AppStore updateProduct(Integer id , UpdateProductRequest product);
}
