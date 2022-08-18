package com.example.retrofitapi

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MyAdapter(val context :Context,val repoList:List<PostModel>, private val listener :OnRepoItemClickListener):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    lateinit var repoArrayList:ArrayList<PostModel>
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var name:TextView
     //var name2:TextView
//        var id:TextView
//        var full_name:TextView
//        var visibility:TextView
//        var html_url:TextView
        init{
            //name2=itemView.findViewById(R.id.NameView)
            name=itemView.findViewById(R.id.name)
//            id=itemView.findViewById(R.id.IdView)
//            full_name=itemView.findViewById(R.id.FullNameView)
//            visibility=itemView.findViewById(R.id.VisibilityView)
//            html_url=itemView.findViewById(R.id.UrlView)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Repo=repoList[position]
        holder.name.text=Repo.name

        holder.itemView.setOnClickListener {
            listener.onItemClick(Repo,holder.adapterPosition)

        }

    }

    override fun getItemCount(): Int {
        return repoList.size
    }
}

interface OnRepoItemClickListener{
    fun onItemClick(item:PostModel,position: Int)
}