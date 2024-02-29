package com.example.apirest.Pagers;

import com.example.apirest.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DriverPager extends JpaRepository<Driver, Long> {
    Page<Driver> findAllProjectedBy(Pageable pageabe);

}
