package com.example.zhack.share_ie

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatDialogFragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.example.zhack.share_ie.R.array.user_foto
import com.example.zhack.share_ie.R.array.user_nama
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.berita.*

class MainActivity : AppCompatActivity() {
    private var items:MutableList<ItemAdapter> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment(control_berita())
        berita.setColorFilter(R.color.colorPrimaryDark)
        berita.setOnClickListener{
            initFragment(control_berita())
            berita.setColorFilter(R.color.colorPrimaryDark)
            seminar.clearColorFilter()
            jadwal.clearColorFilter()
            laporan.clearColorFilter()
        }
    }

    private fun initFragment(classFragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, classFragment)
        transaction.commit()
    }

}
