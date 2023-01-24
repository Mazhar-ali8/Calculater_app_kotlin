package com.calculaterapp.simplecalculaterappfragments.top_fragment

import android.content.Context
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.calculaterapp.simplecalculaterappfragments.SharedViewModel
import com.calculaterapp.simplecalculaterappfragments.databinding.FragmentDisplaybarBinding
import java.nio.file.Files.delete
class DisplaybarFragment : Fragment() {
    private lateinit var viewBinding: FragmentDisplaybarBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var mContext: Context
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDisplaybarBinding.inflate(inflater, container, false)
        viewBinding.viewModel = viewModel
        mContext = requireActivity()
        viewBinding.scrollView.postDelayed({
            kotlin.run {
                viewBinding.scrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
            }

        },100L)

        viewBinding.scrollView2.postDelayed({
            kotlin.run {
                viewBinding.scrollView2.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
            }
        },100L)
        return viewBinding.root
    }



}