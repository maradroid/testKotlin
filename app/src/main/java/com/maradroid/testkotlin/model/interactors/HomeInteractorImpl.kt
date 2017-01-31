package com.maradroid.testkotlin.model.interactors

import com.maradroid.testkotlin.base.RestInterface
import com.maradroid.testkotlin.model.data_model.Data
import com.maradroid.testkotlin.model.data_model.Response
import com.maradroid.testkotlin.model.interactors.listener.HomeListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

/**
 * Created by mara on 1/24/17.
 */
class HomeInteractorImpl @Inject constructor() : HomeInteractor{

    @Inject
    lateinit var restInterface: RestInterface

    var compositeDisposable = CompositeDisposable()

    override fun unsubscribe() {
        compositeDisposable.dispose()
    }

    override fun getData(limit: String, listener: HomeListener) {
        compositeDisposable.add(restInterface.getData(limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object:DisposableObserver<Response>(){
                    override fun onComplete() {

                    }

                    override fun onNext(t: Response?) {
                        listener.onDataSuccess(t ?: Response(ArrayList<Data>()))
                    }

                    override fun onError(e: Throwable?) {
                        listener.onDataError(e?.message ?: "undefined error!")
                    }
                }))
    }
}