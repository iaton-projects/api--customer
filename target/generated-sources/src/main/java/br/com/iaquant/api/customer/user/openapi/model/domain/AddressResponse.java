package br.com.iaquant.api.customer.user.openapi.model.domain;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * 
 */

@Schema(name = "AddressResponse", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-06T23:59:29.610610300-03:00[America/Sao_Paulo]")
public class AddressResponse {

  private Integer id;

  private String zipcode;

  private String address;

  private String neighborhood;

  private String city;

  private String state;

  private String number;

  private String complement;

  public AddressResponse id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AddressResponse zipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }

  /**
   * Get zipcode
   * @return zipcode
  */
  
  @Schema(name = "zipcode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("zipcode")
  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public AddressResponse address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  
  @Schema(name = "address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public AddressResponse neighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
    return this;
  }

  /**
   * Get neighborhood
   * @return neighborhood
  */
  
  @Schema(name = "neighborhood", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("neighborhood")
  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public AddressResponse city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  */
  
  @Schema(name = "city", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public AddressResponse state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  */
  
  @Schema(name = "state", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("state")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public AddressResponse number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  */
  
  @Schema(name = "number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public AddressResponse complement(String complement) {
    this.complement = complement;
    return this;
  }

  /**
   * Get complement
   * @return complement
  */
  
  @Schema(name = "complement", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("complement")
  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressResponse addressResponse = (AddressResponse) o;
    return Objects.equals(this.id, addressResponse.id) &&
        Objects.equals(this.zipcode, addressResponse.zipcode) &&
        Objects.equals(this.address, addressResponse.address) &&
        Objects.equals(this.neighborhood, addressResponse.neighborhood) &&
        Objects.equals(this.city, addressResponse.city) &&
        Objects.equals(this.state, addressResponse.state) &&
        Objects.equals(this.number, addressResponse.number) &&
        Objects.equals(this.complement, addressResponse.complement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, zipcode, address, neighborhood, city, state, number, complement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    zipcode: ").append(toIndentedString(zipcode)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    neighborhood: ").append(toIndentedString(neighborhood)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    complement: ").append(toIndentedString(complement)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

