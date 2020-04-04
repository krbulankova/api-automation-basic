package domain;

import java.util.Map;

public class ProductInfo {
  // Variables
  private Integer id;
  private String name;
  private String description;
  private Double price;
  private Double deluxePrice;
  private String image;
  private String createdAt;
  private String updatedAt;
  private String deletedAt;
  // Constructor
  public ProductInfo(Map<String, String> map) {
    this.id = Integer.parseInt(map.get("id"));
    this.name = map.get("name");
    this.description = map.get("description");
    this.price = Double.parseDouble(map.get("price"));
    this.deluxePrice = Double.parseDouble(map.get("deluxePrice"));
    this.image = map.get("image");
    this.createdAt = map.get("createdAt");
    this.updatedAt = map.get("updatedAt");
    this.deletedAt = map.get("deletedAt");
  }
  // Getters & Setters
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
  public Double getDeluxePrice() {
    return deluxePrice;
  }
  public void setDeluxePrice(Double deluxePrice) {
    this.deluxePrice = deluxePrice;
  }
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }
  public String getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
  public String getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
  public String getDeletedAt() {
    return deletedAt;
  }
  public void setDeletedAt(String deletedAt) {
    this.deletedAt = deletedAt;
  }
}