package mx.com.seting.shopiing.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name ="product")
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
	
	
    private  String name;
    private  Double price;

    public Product() {
 
    }

    public Product(@JsonProperty("id") int id,
                  @JsonProperty("name") String name,
                  @JsonProperty("price") Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public Double getPrice() {
        return price;
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    
}
