package com.decagon.OakLandv1be.services;


import com.decagon.OakLandv1be.dto.ProductCustResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    ProductCustResponseDto fetchASingleProduct(Long product_id);

    Page<ProductCustResponseDto> productWithPaginationAndSorting(Integer page, Integer size, String sortingField,boolean isAscending);

    List<ProductCustResponseDto> fetchAllProducts();

    public List<ProductCustResponseDto> fetchAllProducts();
    ApiResponse<Page<Product>> getAllProducts(Integer pageNo, Integer pageSize, String sortBy, boolean isAscending);

    String uploadProductImage(long productId, MultipartFile image) throws IOException;

    ApiResponse<Page<Product>> getAllProductsBySubCategory(Long subCategoryId, Integer pageNo, Integer pageSize, String sortBy, boolean isAscending);
}
