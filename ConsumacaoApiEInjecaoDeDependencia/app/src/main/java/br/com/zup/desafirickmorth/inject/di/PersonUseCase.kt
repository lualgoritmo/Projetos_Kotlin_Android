package br.com.zup.desafirickmorth.inject.di

import br.com.zup.desafirickmorth.domain.useCase.PersonUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<PersonUseCase>{ PersonUseCase(get()) }
}