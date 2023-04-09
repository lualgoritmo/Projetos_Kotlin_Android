package br.com.zup.desafirickmorth.inject.di

import br.com.zup.desafirickmorth.data.datasource.remote.PersonRetrofitService
import br.com.zup.desafirickmorth.domain.repository.PersonRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://rickandmortyapi.com/api/"

val netWorkModule = module {
    single { createPersonService() }
}

private inline fun createPersonService(): PersonRetrofitService {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PersonRetrofitService::class.java)
}

val personModule = module {
    single {
        PersonRepositoryImpl(
            personDao = get(),
            remoteGetPerson = get()
        )
    }
}

