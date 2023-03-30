package br.com.zup.desafirickmorth.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.desafirickmorth.domain.useCase.PersonUseCase
import br.com.zup.desafirickmorth.ui.home.viewstate.PersonViewState
import kotlinx.coroutines.launch

class PersonViewModel(
    private val personUseCase: PersonUseCase
) : ViewModel() {
    private val _personResponse = MutableLiveData<PersonViewState>()
    val personResponse: LiveData<PersonViewState> = _personResponse

    fun getAllPerson() {
        viewModelScope.launch {
            _personResponse.value = PersonViewState.Loading
            try {
                val response = personUseCase.getAllPerson()
                _personResponse.value = PersonViewState.Success(response)
            } catch (ex: Exception) {
                _personResponse.value = PersonViewState.Error(ex.message ?: "Erro aqui")
            }
        }
    }
}
