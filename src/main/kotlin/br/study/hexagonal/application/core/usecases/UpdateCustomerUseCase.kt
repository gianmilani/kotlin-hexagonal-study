package br.study.hexagonal.application.core.usecases

import br.study.hexagonal.application.core.domain.Customer
import br.study.hexagonal.application.ports.`in`.UpdateCostumerInputPort
import br.study.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort
import br.study.hexagonal.application.ports.out.FindCustomerByIdOutPutPort
import br.study.hexagonal.application.ports.out.UpdateCustomerOutPutPort

class UpdateCustomerUseCase(
    private val findCustomerByIdOutPutPort: FindCustomerByIdOutPutPort,
    private val findAddressByZipCodeOutPutPort: FindAddressByZipCodeOutPutPort,
    private val updateCustomerOutPutPort: UpdateCustomerOutPutPort,
) : UpdateCostumerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        findCustomerByIdOutPutPort.find(customer.id!!)
        val addressFound = findAddressByZipCodeOutPutPort.find(zipCode)
        customer.apply {
            address = addressFound
        }
        updateCustomerOutPutPort.update(customer)
    }
}