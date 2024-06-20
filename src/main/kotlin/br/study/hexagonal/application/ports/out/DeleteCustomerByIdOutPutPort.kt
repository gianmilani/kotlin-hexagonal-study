package br.study.hexagonal.application.ports.out

interface DeleteCustomerByIdOutPutPort {

    fun delete(id: String)
}