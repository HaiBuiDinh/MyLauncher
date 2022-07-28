package com.ohno.mylauncher

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row_view_list.view.*

class AppsDrawerAdapter: RecyclerView.Adapter<AppsDrawerAdapter.MyViewHolder>() {

    var mListApp: List<AppInfo>

    init {
        mListApp = ArrayList()
    }

    fun setData(listApp: List<AppInfo>) {
        this.mListApp = listApp
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val appInfo = mListApp[adapterPosition]
                val launchIntent = it.context.packageManager.getLaunchIntentForPackage(appInfo.packageName.toString())?.apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                it.context.startActivity(launchIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_view_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val appInfo = mListApp.get(position)
        holder.itemView.app_icon.setImageDrawable(appInfo.icon)
        holder.itemView.tv_app_name.text = appInfo.label
    }

    override fun getItemCount(): Int {
        return mListApp.size
    }

}