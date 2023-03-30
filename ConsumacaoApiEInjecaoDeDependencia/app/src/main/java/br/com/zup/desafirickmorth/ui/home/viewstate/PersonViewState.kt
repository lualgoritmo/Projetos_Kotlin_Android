package br.com.zup.desafirickmorth.ui.home.viewstate

import br.com.zup.desafirickmorth.data.model.PersonResult

sealed class PersonViewState {
    object Loading : PersonViewState()
    data class Success(val persons: List<PersonResult>) : PersonViewState()
    data class Error(val message: String) : PersonViewState()
}
