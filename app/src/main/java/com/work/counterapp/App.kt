package com.work.counterapp

import android.app.Application
import android.content.Context
import com.work.counterapp.views.IntCache
import com.work.counterapp.views.PermanentStorage

class App : Application() {

    lateinit var viewModel: CounterViewModel


    override fun onCreate() {
        super.onCreate()
        val permanentStorage = PermanentStorage.Base(
            getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        )
        viewModel = CounterViewModel(Repository.Base(IntCache.Base(permanentStorage, "key", 0)))
    }
}