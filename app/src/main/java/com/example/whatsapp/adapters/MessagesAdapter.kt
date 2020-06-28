package com.example.whatsapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapp.R
import com.example.whatsapp.models.MyMessageModel
import kotlinx.android.synthetic.main.custom_rv_my_messages.view.*

class MessagesAdapter(
    private var mContext: Context,
    private var mMyMessagesModelList: ArrayList<MyMessageModel>
) : RecyclerView.Adapter<MessagesAdapter.MyViewHolder>() {

    inner class MyViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.custom_rv_my_messages,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mMyMessagesModelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (mMyMessagesModelList[position].messageIn) {
            holder.itemView.cardViewCustomRVMessageOut.visibility = View.GONE
            holder.itemView.textViewCustomRVMessageInMessage.text =
                mMyMessagesModelList[position].message
            holder.itemView.textViewCustomRVMessageInTime.text = mMyMessagesModelList[position].time
        } else {
            holder.itemView.cardViewCustomRVMessageIn.visibility = View.GONE
            holder.itemView.textViewCustomRVMessageOutMessage.text =
                mMyMessagesModelList[position].message
            holder.itemView.textViewCustomRVMessageOutTime.text =
                mMyMessagesModelList[position].time
            if (mMyMessagesModelList[position].sent && mMyMessagesModelList[position].delivered) {
                Glide.with(mContext).load(R.drawable.ic_message_delivered)
                    .into(holder.itemView.imageViewMessageStatus)
            } else {
                Glide.with(mContext).load(R.drawable.ic_message_sent)
                    .into(holder.itemView.imageViewMessageStatus)
            }
        }
    }

}