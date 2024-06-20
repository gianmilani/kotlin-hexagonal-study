package br.study.hexagonal.application.ports.`in`

interface DeleteCustomerByIdInputPort {
    fun delete(id: String)
}