package events254.wakenyawawili.com.kedditbysteps.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import events254.wakenyawawili.com.kedditbysteps.R
import events254.wakenyawawili.com.kedditbysteps.commons.inflate

// Adnroid extensions import so we can ccess news_list directly without using findViewByID
import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment: Fragment() {

    // Prevent initialization of newsList as null as we will set it up in onActivityCreated
    private val newsList by lazy { news_list }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

        // Replace with Extension func
        // val view = inflater.inflate(R.layout.news_fragment, container, false)
        return container?.inflate(R.layout.news_fragment)

        // REPLACE WITH ANDROID EXTENSIONS BELOW onActivityCreated()
        // newsList = view.findViewById(R.id.news_list) as RecyclerView
        // newsList?.setHasFixedSize(true)
        // newsList?.layoutManager = LinearLayoutManager(context) // from getContext()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // (news_list) is now a nun nullable object, Here view is already inflated so news list wont be null
        // could use news_list.setHasFixedSize(true) but fails as we may need to access n set our
        // adapters to this
        newsList.setHasFixedSize(true)  // Lazy is executed
        newsList.layoutManager = LinearLayoutManager(context)
    }
}
