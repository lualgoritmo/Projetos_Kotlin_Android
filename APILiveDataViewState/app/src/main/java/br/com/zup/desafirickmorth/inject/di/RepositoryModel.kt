package br.com.zup.desafirickmorth.inject.di

import br.com.zup.desafirickmorth.domain.repository.PersonRepository
import br.com.zup.desafirickmorth.domain.repository.PersonRepositoryImpl
import org.koin.dsl.module

val repositoryImpl = module {
    single<PersonRepository> {
        PersonRepositoryImpl(personDao = get(), remoteGetPerson = get())
    }
}
