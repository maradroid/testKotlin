package com.maradroid.testkotlin.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.maradroid.testkotlin.R
import com.maradroid.testkotlin.base.KotlinApplication
import com.maradroid.testkotlin.home.presenter.HomePresenter
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeView {

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KotlinApplication.component.plus(HomeModule(this)).inject(this)
    }
}
