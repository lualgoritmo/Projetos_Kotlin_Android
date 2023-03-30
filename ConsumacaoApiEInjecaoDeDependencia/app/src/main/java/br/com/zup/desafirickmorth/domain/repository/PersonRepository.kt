package br.com.zup.desafirickmorth.domain.repository

import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.data.model.RickAndMortyResponse

interface PersonRepository {
    suspend fun insertPersonDao(personList: List<PersonResult>)
    suspend fun getAllPerson(): RickAndMortyResponse
    suspend fun getAllPersonDao(): List<PersonResult>
}
