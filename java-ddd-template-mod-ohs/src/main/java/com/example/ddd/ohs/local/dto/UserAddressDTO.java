package com.example.ddd.ohs.local.dto;

import com.example.ddd.domain.user.valueobject.UserAddressValueObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserAddressDTO {

    @NotEmpty
    @JsonProperty("street")
    String street;

    @NotEmpty
    @JsonProperty("province")
    String province;

    @NotEmpty
    @JsonProperty("city")
    String city;

    @NotEmpty
    @JsonProperty("region")
    String region;


    public static UserAddressValueObject toDO(UserAddressDTO user) {
        if (user == null) {
            return null;
        }
        UserAddressValueObject userAddressValueObject = new UserAddressValueObject();
        userAddressValueObject.setStreet(user.getStreet());
        userAddressValueObject.setProvince(user.getProvince());
        userAddressValueObject.setCity(user.getCity());
        userAddressValueObject.setRegion(user.getRegion());
        return userAddressValueObject;
    }

    public static UserAddressDTO fromDO(UserAddressValueObject user) {
        if (user == null) {
            return null;
        }
        UserAddressDTO userAddressDTO = new UserAddressDTO();
        userAddressDTO.setStreet(user.getStreet());
        userAddressDTO.setProvince(user.getProvince());
        userAddressDTO.setCity(user.getCity());
        userAddressDTO.setRegion(user.getRegion());
        return userAddressDTO;
    }

}
