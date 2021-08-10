package com.backendtest.UserRegistration.User.entity;

import com.backendtest.UserRegistration.User.enumerate.MemberTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 7, unique = true, name = "id")
    private Long id;

    @Column(name = "username", length = 30)
    @JsonProperty(value = "username")
    private String username;

    @Column(name = "registration_code", length = 12)
    @JsonProperty(value = "registrationCode")
    private String registrationCode;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "telephone", length = 25)
    @JsonProperty(value = "telephone")
    private String telephone;

    @Column(name = "address", length = 300)
    @JsonProperty(value = "address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_type")
    @JsonProperty(value = "memberType")
    private MemberTypeEnum memberType = MemberTypeEnum.SILVER;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
