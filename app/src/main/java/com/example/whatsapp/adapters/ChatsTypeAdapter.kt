package com.example.whatsapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapp.interfaces.IOnChatsMessagesClick
import com.example.whatsapp.R
import com.example.whatsapp.interfaces.IOnChatsTypeClick
import com.example.whatsapp.models.ChatsMessageModel
import com.example.whatsapp.models.ChatsTypeModel
import kotlinx.android.synthetic.main.custom_rv_chat_type.view.*
import kotlinx.android.synthetic.main.custom_rv_chats_message.view.*

class ChatsTypeAdapter(
    private var mContext: Context,
    private var mItemLayout: Int,
    private var mChatsTypeModelList: ArrayList<ChatsTypeModel>,
    private var mIOnChatsTypeClick: IOnChatsTypeClick
) : RecyclerView.Adapter<ChatsTypeAdapter.MyViewHolder>() {

    inner class MyViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView),
        View.OnClickListener {
        init {
            mItemView.setOnClickListener(this@MyViewHolder)
        }

        override fun onClick(v: View?) {
            mIOnChatsTypeClick.onChatsTypeClick(
                mChatsTypeModelList[adapterPosition]
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
        return mChatsTypeModelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.chipChatsMessageType.text = mChatsTypeModelList[position].typeName
    }
}