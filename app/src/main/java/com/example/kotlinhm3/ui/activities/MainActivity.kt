package com.example.kotlinhm3.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlinhm3.databinding.ActivityMainBinding
import com.example.kotlinhm3.models.Pictures

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private val list = arrayListOf(
        Pictures("https://cdn.mos.cms.futurecdn.net/X2YtDeMUgWBEzWHTF3YdwC.jpg", false),
        Pictures("https://images.newscientist.com/wp-content/uploads/2019/07/09172512/205582.jpg?crop=1:1,smart&width=1200&height=1200&upscale=true", false),
        Pictures("https://www.aces.edu/wp-content/uploads/2018/11/iStock-182344013.jpg", false),
        Pictures("https://c8.alamy.com/comp/2B9MTXT/texel-ewe-a-female-sheep-with-her-young-lamb-facing-forward-in-green-meadow-lamb-is-nuzzling-up-to-her-mother-concept-a-mothers-love-landscape-2B9MTXT.jpg", false),
        Pictures("https://images.theconversation.com/files/193769/original/file-20171108-27001-1dsvlrx.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=1200&h=675.0&fit=crop", false)
    )
    private lateinit var adapter: MainAdapter
    private var newList: ArrayList<Pictures> = ArrayList()
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        setLauncherResult()
    }

    private fun setLauncherResult() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initView() {
        adapter = MainAdapter(list)
        binding.recyclerView.adapter = adapter
        adapter.onItemClick = { picture ->

            if (picture.isSelected) {
                newList.add(picture)
            } else {
                newList.remove(picture)
            }
            adapter.notifyDataSetChanged()
        }

        binding.btnSend.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("key", newList)
            launcher.launch(intent)
        }
    }
}