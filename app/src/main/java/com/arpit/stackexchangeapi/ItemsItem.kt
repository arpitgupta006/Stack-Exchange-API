package com.arpit.stackexchangeapi

import com.google.gson.annotations.SerializedName

data class ItemsItem(

    @field:SerializedName("owner")
    val owner: Owner? = null,

    @field:SerializedName("content_license")
    val contentLicense: String? = null,

    @field:SerializedName("link")
    val link: String? = null,

    @field:SerializedName("last_activity_date")
    val lastActivityDate: Int? = null,

    @field:SerializedName("creation_date")
    val creationDate: Int? = null,

    @field:SerializedName("answer_count")
    val answerCount: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("question_id")
    val questionId: Int? = null,

    @field:SerializedName("tags")
    val tags: List<String?>? = null,

    @field:SerializedName("score")
    val score: Int? = null,

    @field:SerializedName("bounty_amount")
    val bountyAmount: Int? = null,

    @field:SerializedName("bounty_closes_date")
    val bountyClosesDate: Int? = null,

    @field:SerializedName("is_answered")
    val isAnswered: Boolean? = null,

    @field:SerializedName("view_count")
    val viewCount: Int? = null,

    @field:SerializedName("last_edit_date")
    val lastEditDate: Int? = null,

    @field:SerializedName("accepted_answer_id")
    val acceptedAnswerId: Int? = null
)
