package br.study.hexagonal.application.core.usecases

import br.study.hexagonal.application.core.domain.Customer
import br.study.hexagonal.application.ports.`in`.InsertCustomerInputPort
import br.study.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort
import br.study.hexagonal.application.ports.out.InsertCustomerOutPutPort
import br.study.hexagonal.application.ports.out.SendCpfValidationOutPutPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutPutPort: FindAddressByZipCodeOutPutPort,
    private val insertCustomerOutPutPort: InsertCustomerOutPutPort,
    private val sendCpfValidationOutPutPort: SendCpfValidationOutPutPort,
) : InsertCustomerInputPort {
    override fun insert(customer: Customer, zipCode: String){
        val address = findAddressByZipCodeOutPutPort.find(zipCode)
        customer.apply {
            this.address = address
        }
        insertCustomerOutPutPort.insert(customer)
        sendCpfValidationOutPutPort.send(customer.cpf)
    }
}