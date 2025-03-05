package Services.AppStore;

import Exceptions.ProductNotFoundException;
import Model.AppStore;
import Repository.AppStoreRepository;
import Requests.AddProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppStoreService implements iAppStoreInterface{

    @Autowired
    private AppStoreRepository appStoreRepository;

    @Override
    public AppStore addProduct(AddProductRequest request) {
        return appStoreRepository.save(helperForAddingProduct(request));
    }

    private AppStore helperForAddingProduct(AddProductRequest request){
        return new AppStore(
                request.getName(),
                request.getPrice(),
                request.getDescription(),
                request.getProductImageUrl()
        );
    }

    @Override
    public AppStore getProductById(Integer id) {
        return appStoreRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product Not Found!"));
    }

    @Override
    public void deleteProductById(Integer id) {
        appStoreRepository.findById(id).ifPresentOrElse(appStoreRepository::delete,
                ()->{throw new ProductNotFoundException("Product Not Found!");});
    }

    @Override
    public List<AppStore> getAllProducts() {
        return appStoreRepository.findAll();
    }

    @Override
    public AppStore updateProduct(Integer id, AppStore request) {
        AppStore existingProduct = getProductById(id);
        helperForUpdatingProduct(existingProduct,request);
        return appStoreRepository.save(existingProduct);
    }

    private void helperForUpdatingProduct(AppStore existingProduct , AppStore request){
        existingProduct.setName(request.getName());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setProductImageUrl(request.getProductImageUrl());
    }
}
