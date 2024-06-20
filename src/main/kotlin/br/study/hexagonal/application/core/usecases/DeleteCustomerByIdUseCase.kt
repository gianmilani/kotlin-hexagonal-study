package br.study.hexagonal.application.core.usecases

import br.study.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import br.study.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort
import br.study.hexagonal.application.ports.out.FindCustomerByIdOutPutPort

class DeleteCustomerByIdUseCase(
    private val findCustomerByIdOutPutPort: FindCustomerByIdOutPutPort,
    private val deleteCustomerByIdOutPutPort: DeleteCustomerByIdOutPutPort,
): DeleteCustomerByIdInputPort {

    override fun delete(id: String) {
        findCustomerByIdOutPutPort.find(id)
        deleteCustomerByIdOutPutPort.delete(id)
    }
}