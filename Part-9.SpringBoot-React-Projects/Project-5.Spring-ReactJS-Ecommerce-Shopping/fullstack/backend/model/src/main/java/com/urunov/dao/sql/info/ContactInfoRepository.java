package com.urunov.dao.sql.info;

import com.urunov.entity.elements.info.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Integer> {
}
