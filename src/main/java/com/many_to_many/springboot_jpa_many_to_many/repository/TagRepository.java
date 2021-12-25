package com.many_to_many.springboot_jpa_many_to_many.repository;

import com.many_to_many.springboot_jpa_many_to_many.entity.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface TagRepository extends JpaRepository<Tag, Long>{
    
}
