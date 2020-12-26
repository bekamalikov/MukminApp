package com.kg.malikov.mukminapp.models.namaztime

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class Date(
    var readable: String? = null,
    var timestamp: String? = null,
    var gregorian: Gregorian? = null,
)

data class Datum(
    var timings: Timings? = null,
    var date: Date? = null,
    var meta: Meta? = null
)

data class Designation(
    var abbreviated: String? = null,
    var expanded: String? = null
)


data class Gregorian(
    var date: String? = null,
    var format: String? = null,
    var day: String? = null,
    var weekday: Weekday? = null,
    var month: Month? = null,
    var year: String? = null,
    var designation: Designation? = null
)

data class Hijri(
    var date: String? = null,
    var format: String? = null,
    var day: String? = null,
    var weekday: String? = null,
    var month: String? = null,
    var year: String? = null,
    var designation: Designation? = null,
    var holidays: MutableList<Objects>? = null,
)


data class Meta(
    var latitude: Double? = null,
    var longitude: Double? = null,
    var timezone: String? = null,
    var method: Method? = null,
    var latitudeAdjustmentMethod: String? = null,
    var midnightMode: String? = null,
    var school: String? = null,
    var offset: Offset? = null
)

data class Month(
    var number: Int? = null,
    var en: String? = null
)

data class Method(
    var id: Int? = null,
    var name: String? = null,
    var params: Params? = null
)


data class Month_(
    var number: Int? = null,
    var en: String? = null,
    var ar: String? = null
)

data class NamazTimeModel(
    var code: Int? = null,
    var status: String? = null,
    var data: MutableList<Datum>? = null
)

data class NamazTimeModelToday(
    var code: Int? = null,
    var status: String? = null,
    var data: Datum? = null
)


data class Offset(
    @SerializedName("Imsak")
    @Expose
    var imsak: Int? = null,

    @SerializedName("Fajr")
    @Expose
    var fajr: Int? = null,

    @SerializedName("Sunrise")
    @Expose
    var sunrise: Int? = null,

    @SerializedName("Dhuhr")
    @Expose
    var dhuhr: Int? = null,

    @SerializedName("Asr")
    @Expose
    var asr: Int? = null,

    @SerializedName("Maghrib")
    @Expose
    var maghrib: Int? = null,

    @SerializedName("Sunset")
    @Expose
    var sunset: Int? = null,

    @SerializedName("Isha")
    @Expose
    var isha: Int? = null,

    @SerializedName("Midnight")
    @Expose
    var midnight: Int? = null
)

data class Params(
    @SerializedName("Fajr")
    @Expose
    var fajr: Int? = null,

    @SerializedName("Isha")
    @Expose
    var isha: Int? = null
)

data class Timings(
    @SerializedName("Fajr")
    @Expose
    var fajr: String? = null,

    @SerializedName("Sunrise")
    @Expose
    var sunrise: String? = null,

    @SerializedName("Dhuhr")
    @Expose
    var dhuhr: String? = null,

    @SerializedName("Asr")
    @Expose
    var asr: String? = null,

    @SerializedName("Sunset")
    @Expose
    var sunset: String? = null,

    @SerializedName("Maghrib")
    @Expose
    var maghrib: String? = null,

    @SerializedName("Isha")
    @Expose
    var isha: String? = null,

    @SerializedName("Imsak")
    @Expose
    var imsak: String? = null,

    @SerializedName("Midnight")
    @Expose
    var midnight: String? = null
)

data class Weekday(var en: String? = null)

data class Weekday_(
    var en: String? = null,
    var ar: String? = null
)
