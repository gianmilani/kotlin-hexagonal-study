package br.study.hexagonal.config

import br.study.hexagonal.application.core.usecases.DeleteCustomerByIdUseCase
import br.study.hexagonal.application.core.usecases.FindCostumerByIdUseCase
import br.study.hexagonal.application.core.usecases.InsertCustomerUseCase
import br.study.hexagonal.application.core.usecases.UpdateCustomerUseCase
import br.study.hexagonal.application.ports.out.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CostumerConfig {

    @Bean
    fun deleteCustomerByIdUseCase(
        findCustomerByIdOutPutPort: FindCustomerByIdOutPutPort,
        deleteCustomerByIdOutPutPort: DeleteCustomerByIdOutPutPort,
    ) = DeleteCustomerByIdUseCase(findCustomerByIdOutPutPort, deleteCustomerByIdOutPutPort)

    @Bean
    fun insertCustomerUseCase(
        findAddressByZipCodeOutPutPort: FindAddressByZipCodeOutPutPort,
        insertCustomerOutPutPort: InsertCustomerOutPutPort,
        sendCpfValidationOutPutPort: SendCpfValidationOutPutPort,
    ) = InsertCustomerUseCase(
        findAddressByZipCodeOutPutPort,
        insertCustomerOutPutPort,
        sendCpfValidationOutPutPort,
    )

    @Bean
    fun findCostumerByIdUseCase(findCustomerByIdOutPutPort: FindCustomerByIdOutPutPort) =
        FindCostumerByIdUseCase(findCustomerByIdOutPutPort)

    @Bean
    fun updateCustomerUseCase(
        findCustomerByIdOutPutPort: FindCustomerByIdOutPutPort,
        findAddressByZipCodeOutPutPort: FindAddressByZipCodeOutPutPort,
        updateCustomerOutPutPort: UpdateCustomerOutPutPort,
    ) = UpdateCustomerUseCase(findCustomerByIdOutPutPort, findAddressByZipCodeOutPutPort, updateCustomerOutPutPort)


}