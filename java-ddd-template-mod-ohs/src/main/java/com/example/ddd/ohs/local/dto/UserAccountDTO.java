package com.example.ddd.ohs.local.dto;

import com.example.ddd.domain.user.entity.UserAccountEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserAccountDTO {

    @NotEmpty
    @JsonProperty("password")
    String password;

    @NotEmpty
    @JsonProperty("username")
    String username;

    public static UserAccountDTO fromDO(UserAccountEntity user) {
        if (user == null) {
            return null;
        }
        UserAccountDTO userAccountDTO = new UserAccountDTO();
        userAccountDTO.setPassword(user.getPassword());
        userAccountDTO.setUsername(user.getUsername());
        return userAccountDTO;
    }

    public static UserAccountEntity toDO(UserAccountDTO user) {
        if (user == null) {
            return null;
        }
        UserAccountEntity userAccountEntity = new UserAccountEntity();
        userAccountEntity.setPassword(user.getPassword());
        userAccountEntity.setUsername(user.getUsername());
        return userAccountEntity;
    }

}
