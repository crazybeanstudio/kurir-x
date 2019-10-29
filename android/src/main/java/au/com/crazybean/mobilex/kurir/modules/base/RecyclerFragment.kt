package au.com.crazybean.mobilex.kurir.modules.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import au.com.crazybean.foundation.widgets.RecyclerUtils
import au.com.crazybean.mobilex.foundation.saw.Worker
import au.com.crazybean.mobilex.foundation.saw.Adviser
import au.com.crazybean.mobilex.kurir.R

abstract class RecyclerFragment<out WRAPPER: Adviser<Scene, Worker>, TYPE: Any> : BaseFragment<WRAPPER>(), RecyclerUtils.Delegate<TYPE> {
    abstract override val adviser: WRAPPER?

    override val layoutRes: Int
        get() = R.layout.sketch_recycler

    private var refreshLayout: SwipeRefreshLayout? = null

    protected abstract val adapter: RecyclerUtils.Adapter<TYPE>?

    override fun onViewLoad(layout: ViewGroup) {
        super.onViewLoad(layout)
        refreshLayout = layout.findViewById<SwipeRefreshLayout?>(R.id.refresh_layout)
        refreshLayout?.setOnRefreshListener {
            onRefresh()
        }

        layout.findViewById<RecyclerView>(R.id.recycler_view)?.let {
            it.adapter = adapter
        }
    }

    protected open fun onRefresh() {
    }

    fun showSpinner() {
        refreshLayout?.isRefreshing = true
    }

    fun hideSpinner() {
        refreshLayout?.isRefreshing = false
    }
}