package br.study.hexagonal.adapters.out.client

import br.study.hexagonal.adapters.out.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name= "FindAddressByZipCodeClient",
    url = "\${study.client.address.url}"
)
interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
    fun find(@PathVariable("zipCode") zipCode: String): AddressResponse
}
