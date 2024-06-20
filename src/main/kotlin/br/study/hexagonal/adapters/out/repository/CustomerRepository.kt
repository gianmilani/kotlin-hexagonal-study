package br.study.hexagonal.adapters.out.repository

import br.study.hexagonal.adapters.out.repository.entity.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<CustomerEntity, String>{
}