package com.example.whatsapp.helpers

import android.content.Context
import com.example.whatsapp.R
import com.example.whatsapp.models.ChatsMessageModel
import com.example.whatsapp.models.ChatsTypeModel
import com.example.whatsapp.models.MyMessageModel
import com.example.whatsapp.models.StatusModel

class InfoHelper(private var mContext: Context) {
    fun loadChatsMessages(mMessageModelList: ArrayList<ChatsMessageModel>) {
        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_one,
                "Eddie Sparks",
                "11:45 AM",
                "Yeah, I think I knew",
                true,
                2,
                mContext.getString(R.string.text_type_text),
                true,
                mContext.getString(R.string.text_status_read)
            )
        )
        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_two,
                "Aditi",
                "11:19 AM",
                "Please don't say that",
                true,
                1,
                mContext.getString(R.string.text_type_text),
                true,
                mContext.getString(R.string.text_status_read)
            )
        )

        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_three,
                "Alice Whitman",
                "Yesterday",
                "Hii This Is Dainavi",
                false,
                3,
                mContext.getString(R.string.text_type_image),
                true,
                mContext.getString(R.string.text_status_read)
            )
        )

        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_four,
                "June Carter",
                "Friday",
                "",
                false,
                3,
                mContext.getString(R.string.text_type_audio),
                false,
                mContext.getString(R.string.text_status_read)
            )
        )

        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_five,
                "Mandy Wright",
                "Yesterday",
                "Hii",
                false,
                3,
                mContext.getString(R.string.text_type_image),
                true,
                mContext.getString(R.string.text_status_read)
            )
        )

        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_six,
                "George Farewell",
                "Yesterday",
                "Hii",
                false,
                3,
                mContext.getString(R.string.text_type_audio),
                false,
                mContext.getString(R.string.text_status_delivered)
            )
        )

        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_seven,
                "Mukund",
                "Friday",
                "Hii",
                false,
                3,
                mContext.getString(R.string.text_type_text),
                true,
                mContext.getString(R.string.text_status_sent)
            )
        )

        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_eight,
                "Eddie",
                "Friday",
                "Hii",
                false,
                3,
                mContext.getString(R.string.text_type_image),
                false,
                mContext.getString(R.string.text_status_read)
            )
        )

        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_nine,
                "Akshay Sawant",
                "Thursday",
                "Hii",
                false,
                3,
                mContext.getString(R.string.text_type_audio),
                false,
                mContext.getString(R.string.text_status_read)
            )
        )
        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_ten,
                "Surabhi Kulpe",
                "Friday",
                "Hii",
                false,
                3,
                mContext.getString(R.string.text_type_video),
                true,
                mContext.getString(R.string.text_status_read)
            )
        )

        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_eleven,
                "Alice Whitman",
                "Wednesday",
                "Hii",
                false,
                3,
                mContext.getString(R.string.text_type_text),
                false,
                mContext.getString(R.string.text_status_read)
            )
        )
        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_twelve,
                "Aarti",
                "Friday",
                "Hii",
                false,
                3,
                mContext.getString(R.string.text_type_audio),
                true,
                mContext.getString(R.string.text_status_read)
            )
        )
        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_thirteen,
                "Malcolm Jennings",
                "Friday",
                "Hii",
                false,
                3,
                mContext.getString(R.string.text_type_video),
                true,
                mContext.getString(R.string.text_status_read)
            )
        )
        mMessageModelList.add(
            ChatsMessageModel(
                R.drawable.profile_fourteen,
                "Dainu",
                "Friday",
                "Hii",
                false,
                3,
                mContext.getString(R.string.text_type_image),
                true,
                mContext.getString(R.string.text_status_read)
            )
        )


    }

    fun loadStatus(mStatusModelList : ArrayList<StatusModel>){
        mStatusModelList.add(
            StatusModel(
                "Your Story",
                R.drawable.status_twelve
            )
        )
        mStatusModelList.add(
            StatusModel(
                "Aarti",
                R.drawable.status_two
            )
        )
        mStatusModelList.add(
            StatusModel(
                "Aditi",
                R.drawable.status_three
            )
        )
        mStatusModelList.add(
            StatusModel(
                "Dainu",
                R.drawable.status_four
            )
        )
        mStatusModelList.add(
            StatusModel(
                "Mukund",
                R.drawable.status_five
            )
        )
        mStatusModelList.add(
            StatusModel(
                "Akshay",
                R.drawable.status_six
            )
        )
        mStatusModelList.add(
            StatusModel(
                "Spark",
                R.drawable.status_eight
            )
        )
        mStatusModelList.add(
            StatusModel(
                "June",
                R.drawable.status_nine
            )
        )
        mStatusModelList.add(
            StatusModel(
                "Malcolm",
                R.drawable.status_ten
            )
        )
        mStatusModelList.add(
            StatusModel(
                "Alice Whitman",
                R.drawable.status_eleven
            )
        )
        mStatusModelList.add(
            StatusModel(
                "Mandy",
                R.drawable.status_twelve
            )
        )
    }

    fun loadChatsType(mChatsTypeModelList : ArrayList<ChatsTypeModel>){
        mChatsTypeModelList.add(
            ChatsTypeModel(
                "Friends"
            )
        )

        mChatsTypeModelList.add(
            ChatsTypeModel(
                "Employees"
            )
        )

        mChatsTypeModelList.add(
            ChatsTypeModel(
                "Family"
            )
        )

        mChatsTypeModelList.add(
            ChatsTypeModel(
                "Doctor"
            )
        )

        mChatsTypeModelList.add(
            ChatsTypeModel(
                "Tourism"
            )
        )

        mChatsTypeModelList.add(
            ChatsTypeModel(
                "No One"
            )
        )
    }

    fun messageLoader(mMessageModelList: ArrayList<MyMessageModel>){
        mMessageModelList.add(
            MyMessageModel(
                "Hii George. The design file you sent over isn't opening! Do you think it needs a newer paint version?",
                true,
                "10:47 AM",
                false,
                false

            )
        )

        mMessageModelList.add(
            MyMessageModel(
                "Malcolm this is a psd file, you need photoshop to open it.",
                false,
                "10:49 AM",
                true,
                true

            )
        )

        mMessageModelList.add(
            MyMessageModel(
                "Can't you save it in a way to open on paint? I mean it's also a design software so I'm thinking it should work.",
                true,
                "10:49 AM",
                true,
                true

            )
        )

        mMessageModelList.add(
            MyMessageModel(
                "Please don't say that...",
                false,
                "10:51 AM",
                true,
                true

            )
        )
    }
}