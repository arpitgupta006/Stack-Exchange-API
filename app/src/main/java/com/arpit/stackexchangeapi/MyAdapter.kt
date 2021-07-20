package com.arpit.stackexchangeapi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*


class MyAdapter(val context: Context, val questions: MutableList<ItemsItem?>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        var tvCreationDate = itemView.findViewById<TextView>(R.id.tvCreationDate)
        var tvLink = itemView.findViewById<TextView>(R.id.tvLink)
        var tvScore = itemView.findViewById<TextView>(R.id.tvScore)
        var tvView = itemView.findViewById<TextView>(R.id.tvViews)
        var tvTag = itemView.findViewById<TextView>(R.id.tvTag)
        var tvAnswered = itemView.findViewById<TextView>(R.id.tvAnswered)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvTitle.text = questions[position]!!.title
        holder.tvLink.text = questions[position]!!.link
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val netDate = Date( questions[position]!!.creationDate!!.toLong() * 1000)
        val dateF = sdf.format(netDate)
        holder.tvCreationDate.text = "Created On- " + dateF
        holder.tvScore.text = "Score- " + questions[position]!!.score.toString()
        holder.tvView.text = "Views- " + questions[position]!!.viewCount.toString()
        holder.tvTag.text = "Tags- " + questions[position]!!.tags.toString()
        holder.tvAnswered.text ="Answered- " + questions[position]!!.isAnswered.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(context, QuestionActivity::class.java)
            intent.putExtra("link", questions[position]!!.link)
            context.startActivity(intent)

        }
    }

        override fun getItemCount() = questions.size

        override fun onViewDetachedFromWindow(holder: MyViewHolder) {
            super.onViewDetachedFromWindow(holder)
            holder.itemView.clearAnimation()
        }
    }


