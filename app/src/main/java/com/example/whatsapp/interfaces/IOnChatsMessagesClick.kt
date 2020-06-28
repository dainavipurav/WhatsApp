package com.example.whatsapp.interfaces

import com.example.whatsapp.models.ChatsMessageModel

interface IOnChatsMessagesClick {
    fun onChatsMessagesClick(mPosition : ChatsMessageModel)
}