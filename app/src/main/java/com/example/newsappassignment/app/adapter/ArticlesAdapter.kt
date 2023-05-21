package com.example.newsappassignment.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappassignment.app.utils.changeDateFormat
import com.example.newsappassignment.app.utils.loadImage
import com.example.newsappassignment.databinding.ItemNewsBinding
import com.example.newsappassignment.domain.model.Articles

class ArticlesAdapter : ListAdapter<Articles, ArticlesAdapter.ArticleViewHolder>(DiffCallback()) {
    var onItemClick: ((urlToOpen: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class ArticleViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Articles) {
            binding.apply {
                root.context.loadImage(newsImage, article.urlToImage)
                newsTitle.text = article.title
                newsDesc.text = article.description
                newsSource.text = article.source?.name
                newsPublishedAt.text = article.publishedAt.changeDateFormat()
                newsUrl.text = article.url

                newsUrl.setOnClickListener {
                    article.url?.let {
                        onItemClick?.invoke(it)
                    }
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Articles>() {
        override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
        }
    }
}