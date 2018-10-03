package com.example.zhack.share_ie

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.berita.*
import kotlinx.android.synthetic.main.tampilan_berita.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [control_berita.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [control_berita.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class control_berita : Fragment() {
    private var items:MutableList<ItemAdapter> = mutableListOf()
     override fun onCreateView(inflater: LayoutInflater,
                                       container: ViewGroup?,
                                       savedInstanState: Bundle?) = inflater.inflate(R.layout.berita,container,false)
         override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
             super.onViewCreated(view, savedInstanceState)
             initData()
             rv.layoutManager = LinearLayoutManager(activity)
             rv.adapter = RvAdapter(requireContext(),items){
                 val toast = Toast.makeText(activity,it.nama,Toast.LENGTH_SHORT)
                 toast.show()
             }
         }


    private fun initData(){
        val nama = resources.getStringArray(R.array.user_nama)
        val foto = resources.obtainTypedArray(R.array.user_foto)
        items.clear()
        for(i in nama.indices){
            items.add(ItemAdapter(nama[i],
                    foto.getResourceId(i,0)))
        }
        foto.recycle()
    }
}
