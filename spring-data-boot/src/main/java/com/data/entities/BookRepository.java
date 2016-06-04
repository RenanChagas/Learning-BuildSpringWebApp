package com.data.entities;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@ComponentScan
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}