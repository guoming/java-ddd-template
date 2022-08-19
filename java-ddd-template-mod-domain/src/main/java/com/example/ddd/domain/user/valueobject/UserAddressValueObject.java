package com.example.ddd.domain.user.valueobject;

import com.example.ddd.acl.port.repository.user.po.userAddressPO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressValueObject {
    String street;
    String province;
    String city;
    String region;


    public static userAddressPO toPO(UserAddressValueObject userAddress) {
        if (userAddress == null) {
            return null;
        }
        userAddressPO userAddressPO = new userAddressPO();
        userAddressPO.setStreet(userAddress.getStreet());
        userAddressPO.setProvince(userAddress.getProvince());
        userAddressPO.setCity(userAddress.getCity());
        userAddressPO.setRegion(userAddress.getRegion());
        return userAddressPO;
    }


    public static UserAddressValueObject fromPO(userAddressPO user) {
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
}
