package com.example.newsappassignment.domain.model

import com.example.newsappassignment.app.ui.topics.model.TopicDataModel

fun getFakeTopicsList(): ArrayList<TopicDataModel> {
    return arrayListOf<TopicDataModel>().apply {
        add(TopicDataModel(1, "Business"))
        add(TopicDataModel(2, "Crypto"))
        add(TopicDataModel(3, "Gaming"))
        add(TopicDataModel(4, "Technology"))
        add(TopicDataModel(5, "Science"))
        add(TopicDataModel(6, "Medical"))
        add(TopicDataModel(7, "India"))
        add(TopicDataModel(8, "USA"))
    }
}