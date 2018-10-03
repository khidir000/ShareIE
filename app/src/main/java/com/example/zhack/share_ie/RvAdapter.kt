package com.example.zhack.share_ie

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.zhack.share_ie.R.id.rv
import com.example.zhack.share_ie.R.layout.tampilan_berita
import kotlinx.android.synthetic.main.tampilan_berita.view.*
import java.util.*

class RvAdapter(private val context: Context, private val items: List<ItemAdapter>,
                          private val listener: (ItemAdapter)->Unit):RecyclerView.Adapter<RvAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    override fun getItemCount(): Int = items.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(tampilan_berita,parent,false))

    class ViewHolder(val containerView: View):RecyclerView.ViewHolder(containerView){
        fun bindItem(items: ItemAdapter,listener: (ItemAdapter) -> Unit ){
            itemView.nama_user.text = items.nama
            Glide.with(containerView).load(items.image).into(itemView.imagecircle)
            containerView.setOnClickListener{listener(items)}
        }
    }
}