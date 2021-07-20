package com.arpit.stackexchangeapi

import com.google.gson.annotations.SerializedName

data class ResponseStack(

	@field:SerializedName("quota_max")
	val quotaMax: Int? = null,

	@field:SerializedName("quota_remaining")
	val quotaRemaining: Int? = null,

	@field:SerializedName("has_more")
	val hasMore: Boolean? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)

data class Owner(

	@field:SerializedName("profile_image")
	val profileImage: String? = null,

	@field:SerializedName("account_id")
	val accountId: Int? = null,

	@field:SerializedName("user_type")
	val userType: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("reputation")
	val reputation: Int? = null,

	@field:SerializedName("display_name")
	val displayName: String? = null,

	@field:SerializedName("accept_rate")
	val acceptRate: Int? = null
)

