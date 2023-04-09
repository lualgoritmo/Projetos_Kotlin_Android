package br.com.zup.desafirickmorth.appapplication

import android.app.Application
import br.com.zup.desafirickmorth.inject.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(
               listOf(
                   daoModule,
                   netWorkModule,
                   repositoryImpl,
                   useCaseModule,
                   personViewModelModule,
                   personModule)
            )
        }
    }
}
