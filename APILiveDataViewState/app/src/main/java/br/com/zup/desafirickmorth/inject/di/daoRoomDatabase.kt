package br.com.zup.desafirickmorth.inject.di

import br.com.zup.desafirickmorth.data.datasource.local.database.PersonDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val daoModule = module {
    single {
        PersonDataBase.getDatabase(androidContext())
            .personDao()
    }
}
