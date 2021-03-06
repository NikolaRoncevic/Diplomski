package rs.ac.uns.ftn.product.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.product.productservice.DTO.request.CreateProductRequestDTO;
import rs.ac.uns.ftn.product.productservice.DTO.request.UpdateProductRequestDTO;
import rs.ac.uns.ftn.product.productservice.DTO.response.ProductResponseDTO;
import rs.ac.uns.ftn.product.productservice.service.ProductService;


@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseDTO> createNewProduct(@RequestBody CreateProductRequestDTO requestDTO){
        return new ResponseEntity<>(productService.createNewProduct(requestDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@RequestBody UpdateProductRequestDTO requestDTO) {
        return new ResponseEntity<>(productService.updateProduct(requestDTO),HttpStatus.ACCEPTED);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getByProductId(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getOneById(id),HttpStatus.ACCEPTED);
    }
}
