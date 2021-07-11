package com.nisum.test.nisum.model.dao;

import com.nisum.test.nisum.model.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PhoneDao extends JpaRepository<Phone, UUID> {
    Phone findByNumber(String number);
}
