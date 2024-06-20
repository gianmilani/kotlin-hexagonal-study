package br.study.hexagonal.application.ports.out

import br.study.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutPutPort {

    fun find(zipCode: String): Address
}