/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.project04;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mwllf
 */
// Mengatur class sebagai controller
@RestController

// Class ProductServiceController
public class ProductServiceController {
    
    // Mendeklarasikan variable productRepo dengan tipe data Map
    private static Map<String, Product> productRepo = new HashMap<>();
    
    // Menginialisasi variable productRepo
    static {
        //
        Product honey = new Product();
        // Mengatur Id dari variable Honey
        honey.setId("1");
        // Mengatur Name dari variable Honey
        honey.setName("Honey");
        
        honey.setPrice(3000);
        
        honey.setNumber(5);
        
        // Mengatur productRepo dengan mengisi Id dan Name dari variable Honey
        productRepo.put(honey.getId(), honey);
        
        //
        Product almond = new Product();
        // Mengatur Id dari variable Almond
        almond.setId("2");
        // Mengatur Name dari variable Almond
        almond.setName("Almond");
        // Mengatur productRepo dengan mengisi Id dan Name dari variable Almond
        productRepo.put(almond.getId(), almond);
        
    }
    
    // Melakukan RequestMapping dengan mengatur value
    @RequestMapping(value = "/products")
    // Melakukan deklarasi variable
    public ResponseEntity<Object> getProduct() {
        // Mengatur jika productRepo kosong
        if (productRepo.isEmpty()) {
            // Mengembalikan nilai dari ResponseEntity
            return new ResponseEntity<>("Product Doesn't Exist", HttpStatus.NOT_FOUND);
        } 
        // Mengembalikan nilai dari ResponseEntity
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    
    // Melakukan RequestMapping dengan mengatur value dan method
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    // Melakukan deklarasi variable dan menangkap nilai dari product
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        // Mengatur jika productRepo sudah memiliki Id
        if (productRepo.containsKey(product.getId()))
            // Mengembalikan nilai dari ResponseEntity
            return new ResponseEntity<>("Prodcuct is already Exist", HttpStatus.NOT_FOUND);
        // Mengatur productRepo dengan memasukkan Name dan Id dari product
        productRepo.put(product.getId(), product);
        // Mengembalikan nilai dari ResponseEntity
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
    
    // Melakukan RequestMapping dengan mengatur value dan method
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    // Melakukan deklarasi variable, meminta request path dan juga menangkap nilai dari product
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        // Mengatur jika productRepo tidak memiliki ID
        if (productRepo.containsKey(id))
            // Mengembalikan nilai dari ResponseEntity
            return new ResponseEntity<>("Product Not Found" + id,HttpStatus.NOT_FOUND);
        // Menghapus Id dari productRepo
        productRepo.remove(id);
        // Set (mengatur) Id dari product
        product.setId(id);
        // Mengatur productRepo dengan memasukkan Name dan Id dari product
        productRepo.put(id, product);
        // Mengembalikan nilai dari ResponseEntity
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }
    
    // Melakukan RequestMapping dengan mengatur value dan method
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    // Melakukan deklarasi variable dan meminta request path
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        // Mengatur jika productRepo tidak memiliki ID
        if(!productRepo.containsKey(id))
            // Mengembalikan nilai dari ResponseEntity
            return new ResponseEntity<>("Product Not Found" + id,HttpStatus.NOT_FOUND);
        // Menghapus Id dari productRepo
        productRepo.remove(id);
        // Mengembalikan nilai dari ResponseEntity
        return new ResponseEntity<>("Product is deleted successfullya", HttpStatus.OK);
    }
}
