package br.study.hexagonal.adapters.out

import br.study.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import br.study.hexagonal.adapters.out.client.mapper.toAddress
import br.study.hexagonal.application.core.domain.Address
import br.study.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    val findAddressByZipCodeClient: FindAddressByZipCodeClient
) : FindAddressByZipCodeOutPutPort {
    override fun find(zipCode: String): Address {
        val addressResponse = findAddressByZipCodeClient.find(zipCode)
        return addressResponse.toAddress()
    }
}