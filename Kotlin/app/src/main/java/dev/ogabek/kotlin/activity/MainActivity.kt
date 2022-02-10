package dev.ogabek.kotlin.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.*
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.adapter.InfoPageAdapter
import dev.ogabek.kotlin.model.InfoPage
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var skip: TextView
    private lateinit var getStarted: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.rv_main)

        skip = findViewById(R.id.tv_skip)
        getStarted = findViewById(R.id.btn_get_started)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = InfoPageAdapter(this, prepareInfoList())

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        recyclerView.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val offset = recyclerView.computeHorizontalScrollOffset()
                if (offset % recyclerView.width == 0) {
                    val position = offset / recyclerView.width
                    if (position == 2) {
                        skip.visibility = View.GONE
                        getStarted.visibility = View.VISIBLE
                    } else {
                        skip.visibility = View.VISIBLE
                        getStarted.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun prepareInfoList(): List<InfoPage> {
        val infoList: MutableList<InfoPage> = ArrayList<InfoPage>()
        infoList.add(InfoPage("topup.json", "Say Hello to Global Top-Up", "Send mobile top-up to more than 500 networks in over 140 countries."))
        infoList.add(InfoPage("safe.json", "Safe Trusted & Fully Secure", "Encrypted transactions mean your payment & Privacy and Protected."))
        infoList.add(InfoPage("easy.json", "Easy to Use", "Pick a number, choose an amount, send your Top-up, Simple"))
        return infoList
    }

}