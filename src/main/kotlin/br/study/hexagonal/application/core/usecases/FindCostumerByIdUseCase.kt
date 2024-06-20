package br.study.hexagonal.application.core.usecases

import br.study.hexagonal.application.core.domain.Customer
import br.study.hexagonal.application.ports.`in`.FindCostumerByIdUseInputPort
import br.study.hexagonal.application.ports.out.FindCustomerByIdOutPutPort

class FindCostumerByIdUseCase(
    private val findCustomerByIdOutPutPort: FindCustomerByIdOutPutPort,
) : FindCostumerByIdUseInputPort {

    override fun find(id: String): Customer =
        findCustomerByIdOutPutPort
            .find(id) ?: throw RuntimeException("User not found !")
}