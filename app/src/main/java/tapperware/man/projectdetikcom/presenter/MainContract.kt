package tapperware.man.projectdetikcom.presenter

import tapperware.man.projectdetikcom.model.Article

interface MainContract {
    interface View{
        fun showLoading()
        fun hideLoading()
        fun showData(itemData : List<Article>)
    }

    interface Presenter{
        fun getData()
    }
}