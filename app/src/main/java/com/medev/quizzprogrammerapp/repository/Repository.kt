package com.medev.quizzprogrammerapp.repository

import android.content.Context
import com.google.gson.Gson
import com.medev.quizzprogrammerapp.model.Content
import com.medev.quizzprogrammerapp.model.Contents
import java.io.IOException

object Repository {
    fun getDataContents(context: Context?): List<Content>? {
        val json:String?
        try {
            val inputStream = context?.assets?.open("json/contents.json")
            json = inputStream?.bufferedReader().use { it?.readText() }
        }catch (e:IOException){
            return null
        }
        val contents = Gson().fromJson(json, Contents::class.java)
        return contents.contents
    }
}