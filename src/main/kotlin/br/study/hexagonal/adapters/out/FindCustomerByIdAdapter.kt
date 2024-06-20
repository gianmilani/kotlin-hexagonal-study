package br.study.hexagonal.adapters.out

import br.study.hexagonal.adapters.out.repository.CustomerRepository
import br.study.hexagonal.adapters.out.repository.mapper.toCustomer
import br.study.hexagonal.application.core.domain.Customer
import br.study.hexagonal.application.ports.out.FindCustomerByIdOutPutPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
) : FindCustomerByIdOutPutPort {
    override fun find(id: String): Customer? {
        val customerEntity = customerRepository.findById(id)
        return customerEntity.map { it.toCustomer() }.getOrNull()
    }
}