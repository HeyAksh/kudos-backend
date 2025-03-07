package Services.AppStore;

import Exceptions.ProductNotFoundException;
import Model.AppStore;
import Repository.AppStoreRepository;
import Requests.AddProductRequest;
import Requests.UpdateProductRequest;
import Response.AppStoreResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppStoreService implements iAppStoreInterface{

    @Autowired
    private AppStoreRepository appStoreRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AppStore addProduct(AddProductRequest request) {
        return appStoreRepository.save(modelMapper.map(request, AppStore.class));
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
    public List<AppStoreResponse> getAllProducts() {
        List<AppStore> products = appStoreRepository.findAll();

        List<AppStoreResponse> res = new ArrayList<>();

        for(AppStore product : products) {
            res.add(modelMapper.map(product, AppStoreResponse.class));
        }

        return res;
    }

    @Override
    public AppStore updateProduct(Integer id, UpdateProductRequest request) {
        AppStore product;
        try {
            product = getProductById(id);
        }
        catch (ProductNotFoundException e) {
            throw new ProductNotFoundException("Product to be updated does not exist");
        }
        product = modelMapper.map(request, AppStore.class);
        product.setId(id);
        return appStoreRepository.save(product);
    }
}
