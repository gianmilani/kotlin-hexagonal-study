package br.study.hexagonal.adapters.out

import br.study.hexagonal.adapters.out.repository.CustomerRepository
import br.study.hexagonal.adapters.out.repository.mapper.toCustomerEntity
import br.study.hexagonal.application.core.domain.Customer
import br.study.hexagonal.application.ports.out.UpdateCustomerOutPutPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository,
) : UpdateCustomerOutPutPort {
    override fun update(customer: Customer) {
        val customerEntity = customer.toCustomerEntity()
        customerRepository.save(customerEntity)
    }
}