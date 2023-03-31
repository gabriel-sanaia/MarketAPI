package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.BasketDTO;
import com.example.marketapi.DTO.ProductBundleDTO;
import com.example.marketapi.DTO.ResponseBodyDTO;
import com.example.marketapi.Mapper.BasketMapper;
import com.example.marketapi.Mapper.ProductBundleMapper;
import com.example.marketapi.Mapper.ResponseBodyMapper;
import com.example.marketapi.Model.Basket;
import com.example.marketapi.Model.Product;
import com.example.marketapi.Model.ProductBundle;
import com.example.marketapi.Model.ResponseBody;
import com.example.marketapi.Repository.BasketRepository;
import com.example.marketapi.Repository.ProductBundleRepository;
import com.example.marketapi.Service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductBundleRepository productBundleRepository;

    private ResponseBodyMapper responseBodyMapper = new ResponseBodyMapper();

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
        ResponseBody responseBody = new ResponseBody();

        try {
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
        } catch (Exception ex) {
            responseBody.setStatus("500");
            responseBody.setExceptionText(ex.getMessage());

        }
        return responseBodyMapper.mapToDTO(responseBody);
    }

    @Override
    public ResponseBodyDTO deleteProductFromBasket(Long productId) {
        ResponseBody responseBody = new ResponseBody();

        try {
            Basket currentBasket = basketRepository.getLastBasket();
            ProductBundle bundleId = currentBasket.getProductBundle(productId);
            productBundleRepository.deleteById(bundleId.getId());
        } catch (Exception ex) {
            responseBody.setStatus("500");
            responseBody.setExceptionText(ex.getMessage());

        }
        return responseBodyMapper.mapToDTO(responseBody);

    }

    @Override
    public ResponseBodyDTO updateProductsQuantity(Integer quantity, Long productId) {
        ResponseBody responseBody = new ResponseBody();

        try {
            Basket currentBasket = basketRepository.getLastBasket();
            ProductBundle productBundle = currentBasket.getProductBundle(productId);
            productBundle.setQuantity(quantity);
            productBundleRepository.save(productBundle);
        } catch (Exception ex) {
            responseBody.setStatus("500");
            responseBody.setExceptionText(ex.getMessage());
        }
        return responseBodyMapper.mapToDTO(responseBody);
    }

}
