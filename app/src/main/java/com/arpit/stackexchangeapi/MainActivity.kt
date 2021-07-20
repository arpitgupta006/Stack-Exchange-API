package com.arpit.stackexchangeapi

import android.content.DialogInterface
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val timeStamp = System.currentTimeMillis()/1000
    lateinit var questionsadapter : MyAdapter
    private var questionRecentList = mutableListOf<ItemsItem?>()
    var pagenum = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext , "Activity Loaded " , Toast.LENGTH_LONG).show()

        questionsadapter = MyAdapter(this, questionRecentList)
        rvQuestions.adapter = questionsadapter
        val layoutMAnager = LinearLayoutManager(this)
        rvQuestions.layoutManager = layoutMAnager

        rvQuestions.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutMAnager.childCount
                val pastVisibleItem = layoutMAnager.findFirstVisibleItemPosition()
                val total  = questionsadapter.itemCount
                if (visibleItemCount + pastVisibleItem>= total){
                    progressBar.visibility = View.VISIBLE
                    getQuestionList()
                    pagenum++

                }

                super.onScrolled(recyclerView, dx, dy)
            }

        })

        checkConnection()

    }

    private fun checkConnection() {
        var connectivityManager = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        var networkInfo = connectivityManager.getActiveNetworkInfo()

        if (networkInfo != null && networkInfo.isConnected){
            getQuestionList()
        }
        else if(networkInfo == null){
            AlertDialog.Builder(this)
                .setTitle("RETRY")
                .setMessage("NO INTERNET CONNECTION")
                .setPositiveButton("Retry",{ dialogInterface: DialogInterface, i: Int -> checkConnection() })
                .show()
        }
    }

    private fun getQuestionList(){

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = questionsService.apiService.getQuestions(pagenum,20 , timeStamp.toInt() )
                if (response.isSuccessful) {
                    val moviesList= response.body()
                    withContext(Dispatchers.Main) {
                        if (moviesList!= null) {
                            questionRecentList.addAll(moviesList.items!!)
                            questionsadapter.notifyDataSetChanged()
                            progressBar.visibility = View.GONE
                        }
                    }
                }
            }
            catch (e: Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(applicationContext, "Cannot Load Data" , Toast.LENGTH_LONG).show()
                }
            }

        }

    }
}