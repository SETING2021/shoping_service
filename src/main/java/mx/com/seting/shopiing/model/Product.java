package mx.com.seting.shopiing.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="Product Model")
@Entity
@Table(name ="product")
public class Product {
	
	@ApiModelProperty(notes = "ID of the Product", name = "id", required = true, value = "234567")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
	
	@ApiModelProperty(notes = "NAME of the Product", name = "name", required = true, value = "Sergio")
    private  String name;
	
	@ApiModelProperty(notes = "PRICE of the Product", name = "price", required = true, value = "100.00")
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
