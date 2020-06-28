package com.example.whatsapp.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapp.R
import com.example.whatsapp.activities.MainActivity
import com.example.whatsapp.adapters.ChatsMessageAdapter
import com.example.whatsapp.adapters.ChatsStatusAdapter
import com.example.whatsapp.adapters.ChatsTypeAdapter
import com.example.whatsapp.helpers.InfoHelper
import com.example.whatsapp.interfaces.IOnChatsMessagesClick
import com.example.whatsapp.interfaces.IOnChatsTypeClick
import com.example.whatsapp.interfaces.IOnStatusClick
import com.example.whatsapp.models.ChatsMessageModel
import com.example.whatsapp.models.ChatsTypeModel
import com.example.whatsapp.models.StatusModel

class ChatsFragment : Fragment(R.layout.fragment_chats), IOnChatsMessagesClick, IOnStatusClick,
    IOnChatsTypeClick {

    private lateinit var mConstraintLayoutChats : ConstraintLayout
    private lateinit var mRecyclerViewChatsStatus :RecyclerView
    private lateinit var mRecyclerViewChatsType : RecyclerView
    private lateinit var mRecyclerViewChatsMessages : RecyclerView

    private lateinit var mChatsMessageAdapter: ChatsMessageAdapter
    private var mChatsMessageModelList : ArrayList<ChatsMessageModel> = ArrayList()

    private lateinit var mStatusAdapter: ChatsStatusAdapter
    private var mStatusModelList : ArrayList<StatusModel> = ArrayList()

    private lateinit var mChatsTypeAdapter: ChatsTypeAdapter
    private var mChatsTypeModelList : ArrayList<ChatsTypeModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mConstraintLayoutChats = view.findViewById(R.id.constraintLayoutChats)
        mRecyclerViewChatsStatus = view.findViewById(R.id.recyclerViewChatsStatus)
        mRecyclerViewChatsType = view.findViewById(R.id.recyclerViewChatsType)
        mRecyclerViewChatsMessages = view.findViewById(R.id.recyclerViewChatsMessages)

        //(requireActivity() as MainActivity).mToolbar.title = getString(R.string.text_menu_chats)
        (requireActivity() as MainActivity).mTextViewToolbarName.text = getString(R.string.text_menu_chats)

        /*(requireActivity() as MainActivity).mTextViewToolbarName.text = getString(R.string.text_menu_chats)
        (requireActivity() as MainActivity).mTextViewToolbarLastSeen.visibility = View.GONE
        (requireActivity() as MainActivity).mImageViewToolBarProfile.visibility = View.GONE
        (requireActivity() as MainActivity).mImageViewToolBarVideo.visibility = View.GONE
        (requireActivity() as MainActivity).mImageViewToolBarCall.visibility = View.GONE
        (requireActivity() as MainActivity).mImageViewToolBarMore.visibility = View.GONE*/


        context?.let {
            InfoHelper(it).loadChatsMessages(mChatsMessageModelList)
            InfoHelper(it).loadStatus(mStatusModelList)
            InfoHelper(it).loadChatsType(mChatsTypeModelList)

            mChatsMessageAdapter = ChatsMessageAdapter(
                it,
                R.layout.custom_rv_chats_message,
                mChatsMessageModelList,
                this@ChatsFragment
            )

            mRecyclerViewChatsMessages.adapter = mChatsMessageAdapter
            mChatsMessageAdapter.notifyDataSetChanged()

            mStatusAdapter = ChatsStatusAdapter(
                it,
                R.layout.custom_rv_status,
                mStatusModelList,
                this@ChatsFragment
            )

            mRecyclerViewChatsStatus.adapter = mStatusAdapter
            mStatusAdapter.notifyDataSetChanged()

            mChatsTypeAdapter = ChatsTypeAdapter(
                it,
                R.layout.custom_rv_chat_type,
                mChatsTypeModelList,
                this@ChatsFragment
            )

            mRecyclerViewChatsType.adapter = mChatsTypeAdapter
            mChatsTypeAdapter.notifyDataSetChanged()
        }
    }

    override fun onChatsMessagesClick(mPosition: ChatsMessageModel) {
        val action = ChatsFragmentDirections.actionChatsFragmentToViewMyMessagesFragment(
            mPosition.icon,
            mPosition.name
        )

        view?.let { Navigation.findNavController(it).navigate(action) }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_bar_menu,menu)
    }

    override fun onStatusClick(mPosition: StatusModel) {

    }

    override fun onChatsTypeClick(mPosition: ChatsTypeModel) {

    }
}