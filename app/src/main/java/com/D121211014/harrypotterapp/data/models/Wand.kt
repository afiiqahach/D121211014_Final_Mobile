package com.D121211014.harrypotterapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Parcelize
@Serializable
data class Wand(
    val core: String?,
    val length: Double?,
    val wood: String?
): Parcelable