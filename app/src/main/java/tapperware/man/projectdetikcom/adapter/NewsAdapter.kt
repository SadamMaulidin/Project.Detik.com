package tapperware.man.projectdetikcom.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tapperware.man.projectdetikcom.R
import tapperware.man.projectdetikcom.model.Article
import tapperware.man.projectdetikcom.view.DetailActivity

class NewsAdapter(context: Context, itemData: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var data: List<Article> = itemData
    var c: Context = context

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.tvNewsTitle)
        var writer = itemView.findViewById<TextView>(R.id.tvWriter)
        var date = itemView.findViewById<TextView>(R.id.tvPublishDate)
        var image = itemView.findViewById<ImageView>(R.id.img_news)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        val inflater = LayoutInflater.from(c).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        holder.title.text = data.get(position).title
        holder.writer.text = data.get(position).author
        holder.date.text = data.get(position).publishedAt
        Glide.with(c).load(data.get(position).urlToImage).into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(c, DetailActivity::class.java)
            intent.putExtra("images", data.get(position).urlToImage)
            intent.putExtra("titles", data.get(position).title)
            intent.putExtra("authors", data.get(position).author)
            intent.putExtra("dates", data.get(position).publishedAt)
            intent.putExtra("contents", data.get(position).content)
            c.startActivity(intent)
        }

    }
}