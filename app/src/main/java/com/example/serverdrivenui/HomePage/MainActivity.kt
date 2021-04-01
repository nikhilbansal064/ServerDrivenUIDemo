package com.example.serverdrivenui.HomePage

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.serverdrivenui.R
import com.example.serverdrivenui.ui_components.Components
import com.example.serverdrivenui.utils.Utils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val components = Gson().fromJson(Utils.getUIJson(applicationContext), Components::class.java)

        val componentClickListener = ComponentClickListener {component ->
            Toast.makeText(this, "Clicked on ${component.viewType} with text - ${component.text}", Toast.LENGTH_SHORT).show()
        }

        val listItemClickListener = ListItemClickListener { data ->
            Toast.makeText(this, "Clicked on list item of ${data.viewType} with text - ${data.text}", Toast.LENGTH_SHORT).show()
        }
        val homePageListAdapter = HomePageListAdapter(components.components,
            componentClickListener,
            listItemClickListener
        )
        home_page_list.adapter = homePageListAdapter

    }
}