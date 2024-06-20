package br.study.hexagonal.adapters.`in`.controller

import br.study.hexagonal.adapters.`in`.controller.mapper.toCustomer
import br.study.hexagonal.adapters.`in`.controller.mapper.toCustomerResponse
import br.study.hexagonal.adapters.`in`.controller.request.CustomerRequest
import br.study.hexagonal.adapters.`in`.controller.response.CustomerResponse
import br.study.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import br.study.hexagonal.application.ports.`in`.FindCostumerByIdUseInputPort
import br.study.hexagonal.application.ports.`in`.InsertCustomerInputPort
import br.study.hexagonal.application.ports.`in`.UpdateCostumerInputPort
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customer")
class CustomerController(
    val insertCustomerInputPort: InsertCustomerInputPort,
    val findCostumerByIdUseInputPort: FindCostumerByIdUseInputPort,
    val updateCostumerInputPort: UpdateCostumerInputPort,
    val deleteCustomerByIdInputPort: DeleteCustomerByIdInputPort,
) {

    @PostMapping
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        val customer = customerRequest.toCustomer()
        val zipCode = customerRequest.zipCode
        insertCustomerInputPort.insert(customer, zipCode)
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable("id") id: String): ResponseEntity<CustomerResponse> {
        val customer = findCostumerByIdUseInputPort.find(id)
        return ResponseEntity.ok(customer.toCustomerResponse())
    }

    @PutMapping("/{id}")
    fun updateCustomer(
        @PathVariable("id") id: String,
        @Valid @RequestBody customerRequest: CustomerRequest
    ): ResponseEntity<Void> {
        val customer = customerRequest.toCustomer()
        customer.id = id
        updateCostumerInputPort.update(customer, customerRequest.zipCode)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCustomerById(@PathVariable("id") id: String): ResponseEntity<Void> {
        deleteCustomerByIdInputPort.delete(id)
        return  ResponseEntity.noContent().build()
    }
}