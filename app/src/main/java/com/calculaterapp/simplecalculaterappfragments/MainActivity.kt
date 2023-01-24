package com.calculaterapp.simplecalculaterappfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.calculaterapp.simplecalculaterappfragments.bottom_fragment.CalculaterFragment
import com.calculaterapp.simplecalculaterappfragments.top_fragment.DisplaybarFragment

class MainActivity : AppCompatActivity() {
    var displayFragment: Fragment?=null
    var calculaterFragment: Fragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayFragment= DisplaybarFragment()
        calculaterFragment= CalculaterFragment()

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.container_a, displayFragment as DisplaybarFragment)
        transaction.add(R.id.container_b, calculaterFragment as CalculaterFragment)

        transaction.commit()
    }
}