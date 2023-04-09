package br.com.zup.desafirickmorth.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.desafirickmorth.domain.useCase.PersonUseCase
import br.com.zup.desafirickmorth.ui.home.viewstate.PersonStateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class PersonViewModel(private val useCase: PersonUseCase) : ViewModel() {

    private val _personResponse = MutableStateFlow<PersonStateFlow>(PersonStateFlow.Loading)
    val personResponse: StateFlow<PersonStateFlow> = _personResponse

    fun getAllPeson() {
        viewModelScope.launch {
            _personResponse.value = PersonStateFlow.Loading
            val response = useCase.getAllPerson()
            if (response.isNotEmpty()) {
                _personResponse.value = PersonStateFlow.Success(response)
            } else {
                _personResponse.value = PersonStateFlow.Error("Erro aqui")
            }

//            try {
//                 val response = useCase.getAllPerson()
//                _personResponse.value = PersonStateFlow.Success(response)
//            } catch (ex: Exception) {
//                _personResponse.value = PersonStateFlow.Error(ex.message ?: "Erro aqui")
//            }
        }
    }
}
