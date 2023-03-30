package br.com.zup.desafirickmorth.domain.useCase

import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.domain.repository.PersonRepository

class PersonUseCase(private val repository: PersonRepository) {
    private suspend fun getAllPersonDao(): List<PersonResult> {
        return repository.getAllPersonDao()
    }

    suspend fun getAllPerson(): List<PersonResult> {
        return try {
            val person = repository.getAllPerson()
            repository.insertPersonDao(person.results)
            getAllPersonDao()
        } catch (ex: Exception) {
            return getAllPersonDao()
        }
    }
}
