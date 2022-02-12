package com.example.duos.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.duos.data.entities.chat.ChatRoom

@Dao
interface ChatRoomDao {
    @Insert
    fun insert(chatRoom: ChatRoom)

    @Update
    fun update(chatRoom: ChatRoom)

    @Delete
    fun delete(chatRoom: ChatRoom)

    @Query("SELECT * FROM ChatRoomTable")
    fun getChatRoomList(): List<ChatRoom>

    @Query("SELECT chatRoomIdx FROM ChatRoomTable WHERE chatRoomIdx =:chatRoomIdx")
    fun getChatRoomIdx(chatRoomIdx: String): String

    @Query("SELECT * FROM ChatRoomTable WHERE chatRoomIdx =:chatRoomIdx")
    fun getChatRoom(chatRoomIdx: String): ChatRoom

    @Query("UPDATE ChatRoomTable SET isAppointmentExist = :isAppointmentExist WHERE chatRoomIdx = :chatRoomIdx")
    fun updateAppointmentExist(chatRoomIdx: String, isAppointmentExist : Boolean)

    @Query("UPDATE ChatRoomTable SET appointmentIdx = :appointmentIdx WHERE chatRoomIdx = :chatRoomIdx")
    fun updateAppointmentIdx(chatRoomIdx: String, appointmentIdx : Int?)

    @Query("SELECT isAppointmentExist FROM ChatRoomTable WHERE chatRoomIdx = :chatRoomIdx")
    fun getAppointmentExist(chatRoomIdx: String): Boolean

    @Query("SELECT chatRoomImg FROM ChatRoomTable WHERE chatRoomIdx =:chatRoomIdx")
    fun getPartnerProfileImgUrl(chatRoomIdx: String): String

    @Query("SELECT chatRoomName FROM ChatRoomTable WHERE chatRoomIdx =:chatRoomIdx")
    fun getPartnerId(chatRoomIdx: String): String
}