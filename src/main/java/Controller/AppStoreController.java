package Controller;

import Exceptions.ProductNotFoundException;
import Model.AppStore;
import Requests.AddProductRequest;
import Requests.UpdateProductRequest;
import Response.ApiResponse;
import Response.AppStoreResponse;
import Services.AppStore.AppStoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appstore")
public class AppStoreController {

    private final AppStoreService appstoreservice;

    @GetMapping("/get-product-by-id/{productId}")
    public ResponseEntity<ApiResponse> getProductById(
            @PathVariable("productId") Integer id
            ){
        try {
            AppStore response = appstoreservice.getProductById(id);
            return ResponseEntity.ok(new ApiResponse("Information Retrieval Successful",response));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("Product Not Found",e.getMessage()));
        }
    }

    @DeleteMapping("/delete-product-by-id/{productId}")
    public ResponseEntity<ApiResponse> deleteProductById(
            @PathVariable("productId") Integer id
    ){
        try {
            appstoreservice.deleteProductById(id);
            return ResponseEntity.ok(new ApiResponse("Product Deleted Successfully",null));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse("Product Not Found", e.getMessage()));}
    }


    @GetMapping("get-all-products")
    public ResponseEntity<ApiResponse> getAllProducts(){
        try {
            List<AppStoreResponse> response = appstoreservice.getAllProducts();
            return ResponseEntity.ok(new ApiResponse("Information Retrieval Successful",response));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ApiResponse("No Content Found",e.getMessage()));
        }
    }

    @PostMapping("add-product")
    public ResponseEntity<ApiResponse> addProduct(
            @Valid @RequestBody AddProductRequest request
            ){
        try {
            AppStore response = appstoreservice.addProduct(request);
            return ResponseEntity.ok(new ApiResponse("Product Added Successfully",response));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Failed to Add Product",e.getMessage()));
        }
    }

    @PutMapping("update-product/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(
            @PathVariable("productId")Integer id,
            @Valid @RequestBody UpdateProductRequest request
            ){
        try {
            AppStore response = appstoreservice.updateProduct(id,request);
            return ResponseEntity.ok(new ApiResponse("Product Updated Successfully",response));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Failed to Update Product",e.getMessage()));
        }
    }

}
