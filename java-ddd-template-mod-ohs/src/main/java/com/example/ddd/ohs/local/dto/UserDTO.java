package com.example.ddd.ohs.local.dto;

import com.example.ddd.domain.user.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTO {

    @NotEmpty
    @JsonProperty("user_id")
    Long userId;

    @NotEmpty
    @JsonProperty("name")
    String name;

    @NotEmpty
    @JsonProperty("age")
    Integer age;

    @NotEmpty
    @JsonProperty("telephone")
    String telephone;

    @NotEmpty
    @JsonProperty("email")
    String email;

    @NotEmpty
    @JsonProperty("status")
    Integer status;

    @NotEmpty
    @NotNull
    @JsonProperty("address")
    UserAddressDTO address;

    @NotEmpty
    @NotNull
    @JsonProperty("accounts")
    List<UserAccountDTO> accounts;

    public static UserEntity toDO(UserDTO user) {
        if (user == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(user.getUserId());
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        userEntity.setTelephone(user.getTelephone());
        userEntity.setEmail(user.getEmail());
        userEntity.setStatus(user.getStatus());
        userEntity.setAddress(UserAddressDTO.toDO(user.getAddress()));
        userEntity.setAccounts(user.getAccounts().stream().map(UserAccountDTO::toDO).collect(Collectors.toList()));
        return userEntity;
    }

    public static UserDTO fromDO(UserEntity user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());
        userDTO.setTelephone(user.getTelephone());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(UserAddressDTO.fromDO(user.getAddress()));
        userDTO.setAccounts(user.getAccounts().stream().map(UserAccountDTO::fromDO).collect(Collectors.toList()));
        userDTO.setStatus(user.getStatus());
        return userDTO;
    }


}

