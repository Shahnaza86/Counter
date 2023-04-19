package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.CounterView
import com.example.Injector
import com.example.Presenter
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),CounterView {
    lateinit var binding: ActivityMainBinding
     private val presenter=Injector.getPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        with(binding){
            incrementBtn.setOnClickListener{
                presenter.increment()
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()
            }
        }
    }
    override fun showCount(count:String) {
        binding.countTv.text=count
    }
    override fun showToast() {
        Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT).show()
    }

    override fun changerColor(color: Int) {
        binding.countTv.setTextColor(color)
    }

}