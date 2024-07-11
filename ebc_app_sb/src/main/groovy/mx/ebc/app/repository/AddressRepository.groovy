package mx.ebc.app.repository

import mx.ebc.app.model.Address
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository extends CrudRepository<Address, Integer> {

}