package com.dnf.jarvis.publicenemy.mvp.bean

data class WantedTopic(
    var title:String,
    var wantedImage:String,
    var author:String,
    var authorAvatar:String,
    var eggs:Int
)

data class UserInfo(
    val name:String,
    val iconurl:String,
    val gender:String,
    val uid:String
)