package com.example.ddd.domain.user.entity;

import com.example.ddd.acl.port.repository.user.po.userPO;
import com.example.ddd.domain.user.valueobject.UserAddressValueObject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserEntity {
     Long userId;
     String name;
     Integer age;
     String telephone;
     String email;
     UserAddressValueObject address;
     List<UserAccountEntity> accounts;

     Integer status;

     public void create(String name,
                        Integer age,
                        String telephone,
                        String email,
                        UserAddressValueObject address)
     {
          this.email=email;
          this.age=age;
          this.name=name;
          this.address=address;
          this.telephone=telephone;
          this.address=new UserAddressValueObject();
          this.accounts=new ArrayList<>();
     }

     public void createAccount(String username,String password)
     {
          UserAccountEntity userAccount = new UserAccountEntity();
          userAccount.setUsername(username);
          userAccount.setPassword(password);
          this.accounts.add(userAccount);
     }

     public  void updateAccountPassword(String username,String password)
     {
          Optional<UserAccountEntity> first = this.accounts.stream().filter(a -> username.equals(a.getUsername())).findFirst();
          first.ifPresent(userAccountEntity -> userAccountEntity.setPassword(password));
     }

     public void updateBaseInformation(String name,Integer age,String email,String telephone)
     {
          this.name=name;
          this.age=age;
          this.email=email;
          this.telephone=telephone;
     }

     public void updateAddress(UserAddressValueObject address) {
          this.address = address;
     }

     public void Enable()
     {
          this.status =0;
     }

     public void Disabled()
     {
          this.status =1;
     }




     public static userPO toPO(UserEntity user) {
          if (user == null) {
               return null;
          }

          userPO userPO = new userPO();
          userPO.setUserId(user.getUserId());
          userPO.setName(user.getName());
          userPO.setAge(user.getAge());
          userPO.setTelephone(user.getTelephone());
          userPO.setEmail(user.getEmail());
          userPO.setAddress(UserAddressValueObject.toPO( user.getAddress()));
          userPO.setAccounts(user.getAccounts().stream().map(UserAccountEntity::toPO).collect(Collectors.toList()));
          userPO.setStatus(user.getStatus());
          return userPO;
     }


     public static UserEntity fromPO(userPO user) {
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
          userEntity.setAddress(UserAddressValueObject.fromPO(user.getAddress()));
          userEntity.setAccounts(user.getAccounts().stream().map(UserAccountEntity::fromPO).collect(Collectors.toList()));
          return userEntity;
     }

}
