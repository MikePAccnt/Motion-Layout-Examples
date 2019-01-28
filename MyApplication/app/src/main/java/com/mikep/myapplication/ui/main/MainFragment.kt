package com.mikep.myapplication.ui.main

import android.content.Context
import android.hardware.input.InputManager
import android.inputmethodservice.InputMethodService
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.FragmentFactory
import com.mikep.myapplication.R
import com.mikep.myapplication.Util
import kotlinx.android.synthetic.main.view_input.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class MainFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var motionLayout: MotionLayout
    private lateinit var positionOne: View
    private lateinit var positionTwo: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.view_selector, container, false)
        motionLayout = view.findViewById(R.id.motion_layout)
        positionOne = view.findViewById(R.id.position_one)
        positionTwo = view.findViewById(R.id.position_two)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MainActivity", motionLayout.constraintSetIds.toString())

        motionLayout.constraintSetIds.forEach {
            Log.d("Constraint set", "Constraint id: $it")
        }

        positionOne.setOnClickListener {
            motionLayout.transitionToState(R.id.mid)
        }

        positionTwo.setOnClickListener {
            motionLayout.transitionToState(R.id.mid_2)
        }

        //view.postDelayed( {  motionLayout.transitionToEnd() } , 200)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

    }

}
