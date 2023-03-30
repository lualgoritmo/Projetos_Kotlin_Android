package br.com.zup.desafirickmorth.inject.di

import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.domain.repository.PersonRepository
import br.com.zup.desafirickmorth.domain.repository.PersonRepositoryImpl
import br.com.zup.desafirickmorth.ui.home.view.HomeAdapter
import org.koin.dsl.module

val repositoryImpl = module {
    single<PersonRepository> {
        PersonRepositoryImpl(personDao = get(), remoteGetPerson = get())
    }
}

val adapterPersonModule = module {
    factory { (listPerson: MutableList<PersonResult>,
                  clickDetallPerson: (person: PersonResult)
                  -> Unit) ->
        HomeAdapter(listPerson, clickDetallPerson)
    }
}
