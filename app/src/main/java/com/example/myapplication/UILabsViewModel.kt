package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class UILabsViewModel : ViewModel() {
    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title.asStateFlow()

    private val _status = MutableStateFlow("Done")
    val status: StateFlow<String> = _status.asStateFlow()

    private val _priority = MutableStateFlow("Medium")
    val priority: StateFlow<String> = _priority.asStateFlow()

    private val _selectedDate = MutableStateFlow(LocalDate.now())
    val selectedDate: StateFlow<LocalDate> = _selectedDate.asStateFlow()

    private val _selectedTime = MutableStateFlow(LocalTime.now())
    val selectedTime: StateFlow<LocalTime> = _selectedTime.asStateFlow()

    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    val formattedDate: String
        get() = _selectedDate.value.format(dateFormatter)

    val formattedTime: String
        get() = _selectedTime.value.format(timeFormatter)

    fun updateTitle(newTitle: String) {
        _title.value = newTitle
    }

    fun updateStatus(newStatus: String) {
        _status.value = newStatus
    }

    fun updatePriority(newPriority: String) {
        _priority.value = newPriority
    }

    fun updateDate(millis: Long?) {
        millis?.let {
            _selectedDate.value = java.time.Instant.ofEpochMilli(it)
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate()
        }
    }

    fun updateTime(hour: Int, minute: Int) {
        _selectedTime.value = LocalTime.of(hour, minute)
    }

    fun resetForm() {
        _title.value = ""
        _status.value = "Done"
        _priority.value = "Medium"
        _selectedDate.value = LocalDate.now()
        _selectedTime.value = LocalTime.now()
    }

    fun submitForm() {
        // Aqui você pode processar os dados do formulário
        println("Título: ${_title.value}")
        println("Status: ${_status.value}")
        println("Prioridade: ${_priority.value}")
        println("Data: ${formattedDate}")
        println("Hora: ${formattedTime}")
    }
}
