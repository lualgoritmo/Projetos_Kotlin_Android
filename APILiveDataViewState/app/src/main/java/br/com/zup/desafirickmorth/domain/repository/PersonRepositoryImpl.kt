package br.com.zup.desafirickmorth.domain.repository

import br.com.zup.desafirickmorth.data.datasource.local.dao.PersonDao
import br.com.zup.desafirickmorth.data.datasource.remote.PersonRetrofitService
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.data.model.RickAndMortyResponse

class PersonRepositoryImpl(
    private val personDao: PersonDao,
    private val remoteGetPerson: PersonRetrofitService
) : PersonRepository {

    override suspend fun insertPersonDao(personList: List<PersonResult>) {
        personDao.insertPersonDao(personList)
    }

    override suspend fun getAllPerson(): RickAndMortyResponse {
        return remoteGetPerson.getAllPerson()
    }

    override suspend fun getAllPersonDao(): List<PersonResult> =
        personDao.getAllPersonDao()
}
