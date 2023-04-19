package com.example

import android.graphics.Color
import com.example.counter.MainActivity

class Presenter {
    var model=Injector.getModel()
    lateinit var view:CounterView

    fun increment(){
        model.increment()
        view.showCount(model.count.toString())
        if (model.count == 10) {
            view.showToast()
        }
        if (model.count == 15) {
            view.changerColor(Color.GREEN)
        } else {
            view.changerColor(Color.BLACK)
        }
    }
    fun decrement() {
        model.decrement()
        view.showCount(model.count.toString())
        if (model.count == 10) {
            view.showToast()
        }
        if (model.count == 15) {
            view.changerColor(Color.GREEN)
        } else {
            view.changerColor(Color.BLACK)
        }
    }
    fun attachView(viewFromActivity: CounterView){
        view=viewFromActivity
    }


}