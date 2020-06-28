package com.example.whatsapp.fragments

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapp.R
import com.example.whatsapp.activities.MainActivity
import com.example.whatsapp.adapters.MessagesAdapter
import com.example.whatsapp.helpers.InfoHelper
import com.example.whatsapp.models.MyMessageModel

class ViewMyMessagesFragment : Fragment(R.layout.fragment_view_my_messages) {

    private lateinit var mName: String
    private var mIcon: Int = 0

    private lateinit var mToolbar: Toolbar

    private lateinit var mRecyclerViewViewMyMessages: RecyclerView
    private var mMyMessageModelList: ArrayList<MyMessageModel> = ArrayList()
    private lateinit var mMessagesAdapter: MessagesAdapter

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val mArgs: ViewMyMessagesFragmentArgs by navArgs()
        mName = mArgs.name
        mIcon = mArgs.icon

        //Toast.makeText(context, mName, Toast.LENGTH_SHORT).show()

        mRecyclerViewViewMyMessages = view.findViewById(R.id.recyclerViewViewMyMessages)

        context?.let {

            (requireActivity() as MainActivity).mTextViewToolbarName.text = mName
            (requireActivity() as MainActivity).mTextViewToolbarLastSeen.text = "Last seen Jan 11, 17:09"
            Glide.with(it).load(mIcon).into((requireActivity() as MainActivity).mImageViewToolBarProfile)
            Glide.with(it).load(R.drawable.ic_video).into((requireActivity() as MainActivity).mImageViewToolBarVideo)
            Glide.with(it).load(R.drawable.ic_call).into((requireActivity() as MainActivity).mImageViewToolBarCall)
            Glide.with(it).load(R.drawable.ic_more).into((requireActivity() as MainActivity).mImageViewToolBarMore)

            InfoHelper(it).messageLoader(mMyMessageModelList)

            mMessagesAdapter = MessagesAdapter(
                it,
                mMyMessageModelList
            )

            mRecyclerViewViewMyMessages.adapter = mMessagesAdapter
            mMessagesAdapter.notifyDataSetChanged()
        }

        /*mToolbar = view.findViewById(R.id.toolbar)

        activity?.actionBar?.setCustomView(mToolbar)*/

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.messages_action_bar_menu,menu)
    }

}