package com.example.whatsapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapp.interfaces.IOnChatsMessagesClick
import com.example.whatsapp.R
import com.example.whatsapp.interfaces.IOnStatusClick
import com.example.whatsapp.models.ChatsMessageModel
import com.example.whatsapp.models.StatusModel
import kotlinx.android.synthetic.main.custom_rv_chats_message.view.*
import kotlinx.android.synthetic.main.custom_rv_status.view.*

class ChatsStatusAdapter(
    private var mContext: Context,
    private var mItemLayout: Int,
    private var mStatusModelList: ArrayList<StatusModel>,
    private var mIOnStatusClick: IOnStatusClick
) : RecyclerView.Adapter<ChatsStatusAdapter.MyViewHolder>() {

    inner class MyViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView),
        View.OnClickListener {
        init {
            mItemView.setOnClickListener(this@MyViewHolder)
        }

        override fun onClick(v: View?) {
            mIOnStatusClick.onStatusClick(
                mStatusModelList[adapterPosition]
            )
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(mContext).inflate(
                mItemLayout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mStatusModelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(mContext).load(mStatusModelList[position].icon)
            .into(holder.itemView.imageViewCustomRVChatsStatusImage)

        holder.itemView.textViewCustomRVChatsStatusName.text =
            mStatusModelList[position].name

    }
}