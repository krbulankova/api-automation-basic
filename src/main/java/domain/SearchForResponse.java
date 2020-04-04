package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Map;

public class SearchForResponse {
  // Variables
  private String status;
  private ArrayList<ProductInfo> productInfos;
  // Getters and Setters
  public ArrayList<ProductInfo> getProductInfos() {
    return productInfos;
  }
  public void setProductInfos(ArrayList<ProductInfo> productInfos) {
    this.productInfos = productInfos;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  // Methods
  @JsonProperty("data")
  private void unpackData(ArrayList<Map<String, String>> data) {
    productInfos = new ArrayList<ProductInfo>();
    for (Map<String, String> map : data) {
      productInfos.add(new ProductInfo(map));
    }
  }
}