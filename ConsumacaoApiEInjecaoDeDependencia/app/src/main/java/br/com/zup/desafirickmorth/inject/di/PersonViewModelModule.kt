package br.com.zup.desafirickmorth.inject.di

import br.com.zup.desafirickmorth.ui.home.viewmodel.PersonViewModel
import org.koin.dsl.module

val personViewModelModule = module {
    factory { PersonViewModel(personUseCase = get()) }
}
