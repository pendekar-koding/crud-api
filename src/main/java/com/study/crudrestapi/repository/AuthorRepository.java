package com.study.crudrestapi.repository;

import com.study.crudrestapi.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

    List<Author> findAllByDeletedIsFalse();

}
