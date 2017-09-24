package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
