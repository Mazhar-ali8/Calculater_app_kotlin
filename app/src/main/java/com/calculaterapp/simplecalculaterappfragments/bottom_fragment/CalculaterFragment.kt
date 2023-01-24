package com.calculaterapp.simplecalculaterappfragments.bottom_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.calculaterapp.simplecalculaterappfragments.SharedViewModel
import com.calculaterapp.simplecalculaterappfragments.databinding.FragmentCalculaterBinding
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class CalculaterFragment : Fragment() {
    private lateinit var viewBinding: FragmentCalculaterBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var mContext: Context
    lateinit var button0: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var buttonPlus: Button
    lateinit var buttonMinus: Button
    lateinit var buttonDivide: Button
    lateinit var buttonPercentage: Button
    lateinit var buttonOff: Button
    lateinit var buttonEqualTo: Button
    lateinit var buttonDot: Button
    lateinit var buttonPlusMinus: Button
    lateinit var buttonMultply: Button
    lateinit var buttonSqaureRoot: Button
    lateinit var buttonClear: Button
    var check = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCalculaterBinding.inflate(inflater, container, false)
//        viewBinding.viewModel = viewModel
        mContext = requireActivity()
        initViews()
        var text: String

        button0.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "0"
            viewModel.InputNumberTextView.set(text)
            result(text)
        }

        button1.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "1"
            viewModel.InputNumberTextView.set(text)
            result(text)
        }
        button2.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "2"
            viewModel.InputNumberTextView.set(text)
            result(text)
        }
        button3.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "3"
            viewModel.InputNumberTextView.set(text)
            result(text)
        }
        button4.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "4"
            viewModel.InputNumberTextView.set(text)
            result(text)
        }
        button5.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "5"
            viewModel.InputNumberTextView.set(text)
            result(text)
        }
        button6.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "6"
            viewModel.InputNumberTextView.set(text)
            result(text)
        }
        button7.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "7"
            viewModel.InputNumberTextView.set(text)
            result(text)
        }

        button8.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "8"
            viewModel.InputNumberTextView.set(text)
            result(text)
        }

        button9.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "9"
            viewModel.InputNumberTextView.set(text)
            result(text)
        }
        buttonDot.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "."
            viewModel.InputNumberTextView.set(text)
            result(text)
        }

        buttonPlus.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "+"
            viewModel.InputNumberTextView.set(text)
            check = check + 1
        }



        buttonMinus.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "-"
            viewModel.InputNumberTextView.set(text)
            check = check + 1
        }

        buttonMultply.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "*"
            viewModel.InputNumberTextView.set(text)
            check = check + 1
        }

        buttonDivide.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "/"
            viewModel.InputNumberTextView.set(text)
            check = check + 1
        }

        buttonPercentage.setOnClickListener {
            text = viewModel.InputNumberTextView.get().toString() + "%"
            viewModel.InputNumberTextView.set(text)
            check = check + 1
        }
        buttonSqaureRoot.setOnClickListener {

            var expression=viewModel.InputNumberTextView.get()
            viewModel.InputNumberTextView.set(expression)
            var sqaureRoot=Math.pow(expression!!.toDouble(),0.5)
            viewModel.resultTextView.set(sqaureRoot.toString())

        }

        buttonPlusMinus.setOnClickListener {
            text = "-" + viewModel.InputNumberTextView.get().toString()
            viewModel.InputNumberTextView.set(text)
            check = check + 1
        }
        buttonEqualTo.setOnClickListener {
            text = viewModel.resultTextView.get().toString()
            viewModel.InputNumberTextView.set(text)
            viewModel.resultTextView.set("")

        }



        buttonClear.setOnClickListener {
            viewModel.InputNumberTextView.set("")
            viewModel.resultTextView.set("")
        }
        buttonOff.setOnClickListener {
            requireActivity().finish()
        }

//        buttonClear.setOnClickListener {
//            var backSpace: String? = null
//
//            var stringBuilder: StringBuilder =
//                StringBuilder(viewModel.InputNumberTextView.get().toString())
//            val find = viewModel.InputNumberTextView.get().toString()
//            val find2 = find.last()
//
//            if (find2.equals('+') || find2.equals('-') || find2.equals('/') || find2.equals('*') || find2.equals(
//                    '%'
//                )
//            ) {
//                check = check + 1
//            }
//
//            stringBuilder.deleteCharAt(viewModel.InputNumberTextView.get().toString().length - 1)
//            backSpace = stringBuilder.toString()
//            viewModel.InputNumberTextView.set(backSpace)
//            viewModel.resultTextView.set(backSpace)
//        }


        return viewBinding.root

    }

    private fun result(text: String) {
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any = engine.eval(text)
            var main = result.toString()

            if (check == 0) {
                viewModel.resultTextView.set("")

            } else {
                viewModel.resultTextView.set(main)

            }
        } catch (e: ScriptException) {
            Log.e("TAG", "result: ${e.localizedMessage}")
        }
    }

    private fun initViews() {
        button0 = viewBinding.button0
        button1 = viewBinding.button1
        button2 = viewBinding.buttun2
        button3 = viewBinding.buttunThree
        button4 = viewBinding.buttonFour
        button5 = viewBinding.buttunFive
        button6 = viewBinding.buttunSix
        button7 = viewBinding.buttonSeven
        button8 = viewBinding.buttunEight
        button9 = viewBinding.buttunNine
        buttonPlus = viewBinding.buttunPlus
        buttonMinus = viewBinding.buttunMinus
        buttonDivide = viewBinding.buttunDivide
        buttonPercentage = viewBinding.buttunPercentage
//        buttonBackSpace=viewBinding.button
        buttonEqualTo = viewBinding.buttunEqaul
        buttonDot = viewBinding.buttunPoint
        buttonPlusMinus = viewBinding.buttunPlusminus
        buttonMultply = viewBinding.buttunMultiply
        buttonSqaureRoot = viewBinding.buttunSquareRoot
        buttonClear = viewBinding.buttunClear
        buttonOff = viewBinding.buttunOn
    }

}