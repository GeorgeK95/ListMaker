package com.georgek.sgfs.listmaker


import android.os.Parcel
import android.os.Parcelable

class TaskList constructor(val name: String, val tasks: ArrayList<String> = ArrayList()) : Parcelable {

  constructor(source: Parcel) : this(
      source.readString(),
      source.createStringArrayList()
  )

  override fun describeContents() = 0

  override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
    writeString(name)
    writeStringList(tasks)
  }

  companion object {
    @JvmField
    val CREATOR: Parcelable.Creator<TaskList> = object : Parcelable.Creator<TaskList> {
      override fun createFromParcel(source: Parcel): TaskList = TaskList(source)
      override fun newArray(size: Int): Array<TaskList?> = arrayOfNulls(size)
    }
  }
}
