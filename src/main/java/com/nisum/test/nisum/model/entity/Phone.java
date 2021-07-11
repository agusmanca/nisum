package com.nisum.test.nisum.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "PHONES")
@Getter
@Setter
public class Phone {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "CITY_CODE")
    private String citycode;

    @Column(name = "COUNTRY_CODE")
    private String contrycode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USER")
    private User user;
}
