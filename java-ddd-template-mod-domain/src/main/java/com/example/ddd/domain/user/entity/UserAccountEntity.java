package com.example.ddd.domain.user.entity;

import com.example.ddd.acl.port.repository.user.po.userAccountPO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountEntity {
    Long Id;
    String password;
    String username;


    public static userAccountPO toPO(UserAccountEntity user) {
        if (user == null) {
            return null;
        }
        userAccountPO userAccountPO = new userAccountPO();
        userAccountPO.setId(user.getId());
        userAccountPO.setPassword(user.getPassword());
        userAccountPO.setUsername(user.getUsername());
        return userAccountPO;
    }

    public static UserAccountEntity fromPO(userAccountPO user) {
        if (user == null) {
            return null;
        }
        UserAccountEntity userAccountEntity = new UserAccountEntity();
        userAccountEntity.setId(user.getId());
        userAccountEntity.setPassword(user.getPassword());
        userAccountEntity.setUsername(user.getUsername());
        return userAccountEntity;
    }

}
