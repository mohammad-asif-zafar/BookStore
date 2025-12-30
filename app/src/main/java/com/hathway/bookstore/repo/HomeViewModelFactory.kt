package com.hathway.bookstore.repo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hathway.bookstore.viewmodel.HomeViewModel

class HomeViewModelFactory(
    private val repository: CourseRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}
