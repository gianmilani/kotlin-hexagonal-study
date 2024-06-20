package br.study.hexagonal.adapters.out

import br.study.hexagonal.adapters.out.repository.CustomerRepository
import br.study.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
) : DeleteCustomerByIdOutPutPort {
    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }
}