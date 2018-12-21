package com.example.jonathansimonney.igeneration.newsList

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.g123k.myapplication.News

class NewsListViewModel : ViewModel() {
    private var newsList :LiveData<List<News>>? = null

    fun getNews() :LiveData<List<News>>{
        if (newsList == null){
            newsList = NewsListLiveData()
        }

        return newsList as LiveData<List<News>>
    }
}