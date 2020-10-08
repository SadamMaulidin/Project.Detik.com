package tapperware.man.projectdetikcom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tapperware.man.projectdetikcom.R
import tapperware.man.projectdetikcom.adapter.NewsAdapter
import tapperware.man.projectdetikcom.model.Article
import tapperware.man.projectdetikcom.presenter.MainContract
import tapperware.man.projectdetikcom.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var mPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = MainPresenter(this)
        mPresenter.getData()

    }

    override fun showLoading() {
        progress_Bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_Bar.visibility = View.GONE
    }

    override fun showData(itemData: List<Article>) {
        rv_news.setHasFixedSize(true)
        rv_news.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_news.adapter = NewsAdapter(this, itemData)
    }
}