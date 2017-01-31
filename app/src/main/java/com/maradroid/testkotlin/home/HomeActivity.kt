package com.maradroid.testkotlin.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.maradroid.testkotlin.R
import com.maradroid.testkotlin.base.KotlinApplication
import com.maradroid.testkotlin.home.presenter.HomePresenter
import com.maradroid.testkotlin.model.data_model.Data
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeView {

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KotlinApplication.component.plus(HomeModule(this)).inject(this)
    }

    override fun onStart() {
        super.onStart()
        homePresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        homePresenter.onStop()
    }

    override fun setupRecyclerData(data: List<Data>?) {

    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show()
    }
}
