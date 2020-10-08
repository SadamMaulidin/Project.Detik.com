package tapperware.man.projectdetikcom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import tapperware.man.projectdetikcom.R

class DetailActivity : AppCompatActivity() {

    var title: String? = ""
    var author: String? = ""
    var date: String? = ""
    var content: String? = ""
    var image: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setTitle("News Detail")

        val mTitle = findViewById<TextView>(R.id.tvNewsTitleDetails)
        val mAuthor = findViewById<TextView>(R.id.tvWriterDetails)
        val mDate = findViewById<TextView>(R.id.tvPublishDateDetails)
        val mContent = findViewById<TextView>(R.id.tvContentDetails)
        val mImage = findViewById<ImageView>(R.id.img_news_detil)

        title = intent.getStringExtra("titles")
        mTitle.setText(title)

        author = intent.getStringExtra("authors")
        mAuthor.setText(author)

        date = intent.getStringExtra("dates")
        mDate.setText(date)

        content = intent.getStringExtra("contents")
        mContent.setText(content)

        image = intent.getStringExtra("images")
        Glide.with(this).load(image).into(mImage)

    }
}