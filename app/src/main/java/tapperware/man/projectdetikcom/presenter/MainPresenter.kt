package tapperware.man.projectdetikcom.presenter

import org.jetbrains.annotations.Contract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tapperware.man.projectdetikcom.model.Article
import tapperware.man.projectdetikcom.model.News
import tapperware.man.projectdetikcom.service.ApiClient

class MainPresenter(model: MainContract.View) : MainContract.Presenter {

    var view: MainContract.View? = null

    init {
        view = model
    }

    override fun getData() {
        view?.showLoading()

        ApiClient.getClient().getNews().enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (response.isSuccessful) {
                    view?.hideLoading()
                    view?.showData(response.body()?.articles as List<Article>)
                } else {
                    view?.hideLoading()
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                view?.hideLoading()
            }

        })

    }

}