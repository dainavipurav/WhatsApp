package com.example.whatsapp.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapp.interfaces.IOnChatsMessagesClick
import com.example.whatsapp.R
import com.example.whatsapp.models.ChatsMessageModel
import kotlinx.android.synthetic.main.custom_rv_chats_message.view.*

class ChatsMessageAdapter(
    private var mContext: Context,
    private var mItemLayout: Int,
    private var mChatsMessageModelList: ArrayList<ChatsMessageModel>,
    private var mIOnChatsMessagesClick: IOnChatsMessagesClick
) : RecyclerView.Adapter<ChatsMessageAdapter.MyViewHolder>() {

    inner class MyViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView),
        View.OnClickListener {
        init {
            mItemView.setOnClickListener(this@MyViewHolder)
        }

        override fun onClick(v: View?) {
            mIOnChatsMessagesClick.onChatsMessagesClick(
                mChatsMessageModelList[adapterPosition]
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
        return mChatsMessageModelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        if (mChatsMessageModelList[position].messageIn){
            holder.itemView.imageViewCustomRVChatsMessageStatus.visibility = View.GONE
           if (mChatsMessageModelList[position].newMessage){
               holder.itemView.imageViewCustomRVChatsNewMessageCount.visibility = View.VISIBLE
               holder.itemView.textViewViewCustomRVChatsContactTime.setTextColor(Color.GREEN)
               holder.itemView.textNewMessagesCountNumber.text = mChatsMessageModelList[position].newMessageCount.toString()
           }
            else{
               holder.itemView.imageViewCustomRVChatsNewMessageCount.visibility = View.GONE
               holder.itemView.textViewViewCustomRVChatsContactTime.setTextColor(Color.BLACK)
               holder.itemView.textNewMessagesCountNumber.visibility = View.GONE
           }
        }
        else{
            holder.itemView.imageViewCustomRVChatsMessageStatus.visibility = View.VISIBLE
        }

        if (mChatsMessageModelList[position].type == mContext.getString(R.string.text_type_image)){
            Glide.with(mContext).load(R.drawable.ic_photo).into(holder.itemView.imageViewcustomRVChatsMessageTypeImage)
            holder.itemView.textViewViewCustomRVChatsContactMessage.text =
                mContext.getString(R.string.text_type_image)
        }
        else if(mChatsMessageModelList[position].type == mContext.getString(R.string.text_type_audio)){
            Glide.with(mContext).load(R.drawable.ic_voice_message).into(holder.itemView.imageViewcustomRVChatsMessageTypeImage)
            holder.itemView.textViewViewCustomRVChatsContactMessage.text =
                mContext.getString(R.string.text_type_audio)
        }
        else if (mChatsMessageModelList[position].type == mContext.getString(R.string.text_type_video)){
            Glide.with(mContext).load(R.drawable.ic_video).into(holder.itemView.imageViewcustomRVChatsMessageTypeImage)
            holder.itemView.textViewViewCustomRVChatsContactMessage.text =
                mContext.getString(R.string.text_type_video)
        }
        else if (mChatsMessageModelList[position].type == mContext.getString(R.string.text_type_text)){
            holder.itemView.imageViewcustomRVChatsMessageTypeImage.visibility = View.GONE
            holder.itemView.textViewViewCustomRVChatsContactMessage.text =
                mChatsMessageModelList[position].message
        }

        if (mChatsMessageModelList[position].status == mContext.getString(R.string.text_status_sent)){
            Glide.with(mContext).load(R.drawable.ic_message_sent).into(holder.itemView.imageViewCustomRVChatsMessageStatus)
        }
        else if (mChatsMessageModelList[position].status == mContext.getString(R.string.text_status_delivered)){
            Glide.with(mContext).load(R.drawable.ic_message_delivered).into(holder.itemView.imageViewCustomRVChatsMessageStatus)
        }
        else if (mChatsMessageModelList[position].status == mContext.getString(R.string.text_status_read)){
            Glide.with(mContext).load(R.drawable.ic_read).into(holder.itemView.imageViewCustomRVChatsMessageStatus)
        }

        Glide.with(mContext).load(mChatsMessageModelList[position].icon)
            .into(holder.itemView.imageViewCustomRVChatsContact)

        holder.itemView.textViewViewCustomRVChatsContactName.text =
            mChatsMessageModelList[position].name

        holder.itemView.textViewViewCustomRVChatsContactTime.text =
            mChatsMessageModelList[position].time
    }
}