package com.kg.malikov.mukminapp.utils

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.kg.malikov.mukminapp.models.name.NameModel

lateinit var REF_DATABASE_ROOT: DatabaseReference
lateinit var mRefUserListener: AppValueEventListener


const val NODE_NAMES = "names"
const val NODE_HADIS = "hadis"
const val NODE_DUA = "dua"


fun initFirebase() {
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
}

fun fetchListNameFromFirebase(list: MutableList<NameModel>) {

}

