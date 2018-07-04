package antonioleiva.com.appkotlin.main

class MainPresenter(var mainView: MainView?, val findItemsInteractor: FindItemsInteractor) {

    fun onResume() {
        mainView?.showProgress()
        findItemsInteractor.findItems(::onItemsLoaded)
    }

    private fun onItemsLoaded(items: List<String>) {
        mainView?.apply {
            setItems(items)
            hideProgress()
        }
    }

    fun onItemClicked(item: String) {
        mainView?.showMessage(item)
    }

    fun onDestroy() {
        mainView = null
    }
}