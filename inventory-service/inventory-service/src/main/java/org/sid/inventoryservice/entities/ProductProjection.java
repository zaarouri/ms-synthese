package org.sid.inventoryservice.repos;

import org.sid.inventoryservice.entities.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullProduct",types = Product.class)
public interface ProductProjection {
    public Long getId() ;
    public String getname() ;
    public Double getprice() ;
    public int getQuantity ();
}

