package ru.mggtk.practice15

import android.os.Parcel
import android.os.Parcelable

class Animal() : Parcelable {
    private var race: String = ""
    private var month: String = ""
    private var year: String = ""

    constructor(parcel: Parcel) : this() {
        race = parcel.readString().toString()
        month = parcel.readString().toString()
        year = parcel.readString().toString()
    }

    constructor(_race: String, _month: String, _year: String): this(){
        race = _race
        month = _month
        year = _year
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(race)
        parcel.writeString(month)
        parcel.writeString(year)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Animal> {
        override fun createFromParcel(parcel: Parcel): Animal {
            return Animal(parcel)
        }

        override fun newArray(size: Int): Array<Animal?> {
            return arrayOfNulls(size)
        }
    }

    //Геттеры и сеттеры
    fun setRace(_race: String){
        race = _race
    }

    fun getRace(): String{
        return race
    }

    fun setMonth(_month: String){
        month = _month
    }

    fun getMonth(): String{
        return month
    }

    fun setYear(_year: String){
        race = _year
    }

    fun getYear(): String{
        return year
    }


}