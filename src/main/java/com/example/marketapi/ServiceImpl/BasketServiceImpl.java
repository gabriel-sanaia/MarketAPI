package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.ProductBundleDTO;
import com.example.marketapi.DTO.ResponseBodyDTO;
import com.example.marketapi.Exception.IllegalParameterException;
import com.example.marketapi.Mapper.BasketMapper;
import com.example.marketapi.Mapper.ProductBundleMapper;
import com.example.marketapi.Model.Basket;
import com.example.marketapi.Model.Product;
import com.example.marketapi.Model.ProductBundle;
import com.example.marketapi.Repository.BasketRepository;
import com.example.marketapi.Repository.ProductBundleRepository;
import com.example.marketapi.Repository.ProductRepository;
import com.example.marketapi.Service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.management.openmbean.OpenDataException;
import java.util.List;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductBundleRepository productBundleRepository;

    @Autowired
    ProductRepository productRepository;

    private BasketMapper basketMapper = new BasketMapper();

    private ProductBundleMapper productBundleMapper = new ProductBundleMapper();

    @Override
    public List<ProductBundleDTO> getBasket() {
        Basket basket = basketRepository.getLastBasket();
        List<ProductBundleDTO> dtoList= productBundleMapper.mapToDTOList(basket.getProductBundles());

        return dtoList;
    }

    @Override
    public ResponseBodyDTO addProductToBasket(Long productId, Integer quantity) {
        try {
            validation(quantity, productId);

            Basket currentBasket = basketRepository.getLastBasket();

            ProductBundle productBundle = new ProductBundle();

            if (currentBasket.containsProduct(productId)) {
                productBundle = currentBasket.getProductBundle(productId);
                productBundle.setQuantity(productBundle.getQuantity() + quantity);
            } else {
                Product product = new Product();
                product.setId(productId);
                productBundle.setProduct(product);
                productBundle.setQuantity(quantity);
            }

            productBundle.setBasket(currentBasket);
            productBundleRepository.save(productBundle);

        }catch (IllegalParameterException ex){
            return new ResponseBodyDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()), ex.getMessage());
        }
        catch (Exception ex) {

            return new ResponseBodyDTO("500", ex.getMessage());
        }
        return new ResponseBodyDTO(String.valueOf(HttpStatus.OK), "null");
    }

    @Override
    public ResponseBodyDTO deleteProductFromBasket(Long productId) {

        try {
            checkProductExistence(productId);

            Basket currentBasket = basketRepository.getLastBasket();
            ProductBundle bundle = currentBasket.getProductBundle(productId);
            if(bundle == null)
                throw new IllegalParameterException("You do not have this product in basket");

            productBundleRepository.deleteById(bundle.getId());

        }catch (IllegalParameterException ex){
            return new ResponseBodyDTO(String.valueOf(HttpStatus.BAD_REQUEST), ex.getMessage());

        } catch (Exception ex) {
            return new ResponseBodyDTO("500", ex.getMessage());
        }
        return new ResponseBodyDTO(String.valueOf(HttpStatus.OK), "null");
    }

    @Override
    public ResponseBodyDTO updateProductsQuantity(Integer quantity, Long productId) {

        try {
           validation(quantity, productId);

            Basket currentBasket = basketRepository.getLastBasket();
            ProductBundle productBundle = currentBasket.getProductBundle(productId);

            if(productBundle == null)
                throw new IllegalParameterException("Product should be in basket before updating");

            productBundle.setQuantity(quantity);
            productBundleRepository.save(productBundle);

        } catch (IllegalParameterException ex){
            return new ResponseBodyDTO(String.valueOf(HttpStatus.BAD_REQUEST), ex.getMessage());

        } catch (Exception ex) {
            return new ResponseBodyDTO("500", ex.getMessage());
        }
        return new ResponseBodyDTO(String.valueOf(HttpStatus.OK), "null");
    }

    private void checkProductExistence(Long productId) throws IllegalParameterException {
        if(!productRepository.existsById(productId))
            throw new IllegalParameterException("Provided Illegal product ID");
    }

    private void validation(Integer quantity, Long productId) throws IllegalParameterException {
       checkProductExistence(productId);

       if (quantity < 0)
           throw new IllegalParameterException("Quantity can not be negative");
    }

}
