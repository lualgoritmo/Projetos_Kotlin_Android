package br.com.zup.desafirickmorth.ui.home.viewstate

import br.com.zup.desafirickmorth.data.model.PersonResult

sealed class PersonStateFlow {
    object Loading : PersonStateFlow()
    data class Success(val persons: List<PersonResult>) : PersonStateFlow()
    data class Error(val message: String) : PersonStateFlow()
}
