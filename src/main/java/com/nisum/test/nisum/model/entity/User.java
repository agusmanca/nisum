package com.nisum.test.nisum.model.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false)
    @Setter(AccessLevel.PRIVATE)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Phone> phones;

    @Column(name = "CREATE_AT")
    private Date createDate;

    @Column(name = "MODIFIED_AT")
    private Date modifiedDate;

    @Column(name = "LAST_LOGIN")
    private Date lastLogin;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "IS_ACTIVE")
    private boolean isActive = true;
}
