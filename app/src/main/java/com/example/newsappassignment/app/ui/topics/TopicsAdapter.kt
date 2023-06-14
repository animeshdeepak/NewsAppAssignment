package com.example.newsappassignment.app.ui.topics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappassignment.app.ui.topics.model.TopicDataModel
import com.example.newsappassignment.databinding.TopicItemRvBinding

class TopicsAdapter : ListAdapter<TopicDataModel, TopicsAdapter.TopicsViewHolder>(DiffCallback()) {
    var onItemClick: ((model: TopicDataModel) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsViewHolder {
        val binding =
            TopicItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopicsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopicsViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class TopicsViewHolder(private val binding: TopicItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: TopicDataModel) {
            binding.apply {
                topicTv.text = model.name
                topicCv.setOnClickListener {
                    onItemClick?.invoke(model)
                    topicCv.isChecked = !topicCv.isChecked // add checkbox to cards
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<TopicDataModel>() {
        override fun areItemsTheSame(oldItem: TopicDataModel, newItem: TopicDataModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TopicDataModel, newItem: TopicDataModel): Boolean {
            return oldItem == newItem
        }
    }
}