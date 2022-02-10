package dev.ogabek.kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.model.InfoPage

class InfoPageAdapter(private val context: Context, private val infoList: List<InfoPage>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val animation: LottieAnimationView = view.findViewById(R.id.item_lottie_animation)
        val title: TextView = view.findViewById(R.id.item_title)
        val text: TextView = view.findViewById(R.id.item_text)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val infoPage = infoList[position]

        if (holder is ItemViewHolder) {
            holder.apply {
                animation.setAnimation(infoPage.animation)
                title.text = infoPage.title
                text.text = infoPage.text
            }
        }

    }

    override fun getItemCount() = infoList.size
}