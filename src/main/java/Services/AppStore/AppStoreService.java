package Services.AppStore;

import Exceptions.EmployeeNotFoundException;
import Exceptions.ProductNotFoundException;
import Model.AppStore;
import Model.Employee;
import Repository.AppStoreRepository;
import Requests.AddProductRequest;
import Requests.UpdateProductRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<AppStore> getAllProducts() {
        return appStoreRepository.findAll();
    }

    @Override
    public AppStore updateProduct(Integer id, UpdateProductRequest request) {
        Optional<AppStore> appStore = appStoreRepository.findById(id);

        if (appStore.isEmpty()) {
            throw new ProductNotFoundException("Product Not Found!");
        }

        AppStore updatedAppStore = appStore.get();
        updatedAppStore.setId(id);
        return appStoreRepository.save(updatedAppStore);
    }
}
