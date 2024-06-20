package br.study.hexagonal.application.ports.out

interface SendCpfValidationOutPutPort {

    fun send(cpf: String)
}