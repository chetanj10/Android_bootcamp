package com.example.retrofitapi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://api.github.com/orgs/fossasia/"
class MainActivity : AppCompatActivity() ,OnRepoItemClickListener{

    lateinit var myAdapter: MyAdapter
    lateinit var responseBody:List<PostModel>
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repoRecyclerView:RecyclerView=findViewById(R.id.RepoRecyclerView)
        repoRecyclerView.setHasFixedSize(true)
        linearLayoutManager= LinearLayoutManager(this)
        repoRecyclerView.layoutManager=linearLayoutManager
        val retrofitBuilder=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

        val retrofitData=retrofitBuilder.getData()

        val responseRepo:MutableList<PostModel>

        retrofitData.enqueue(object : Callback<List<PostModel>?> {
            override fun onResponse(
                call: Call<List<PostModel>?>,
                response: Response<List<PostModel>?>
            ) {
                val responseBody=response.body()!!
                myAdapter= MyAdapter(baseContext,responseBody,this@MainActivity)
                myAdapter.notifyDataSetChanged()
                val repoRecyclerView:RecyclerView=findViewById(R.id.RepoRecyclerView)
                repoRecyclerView.adapter=myAdapter



//                myAdapter.onItemClick={
//                    val intent=Intent(this,DetailedActivity::class.java)
//                    intent.putExtra("repo",it)
//                    startActivity(intent)
//                }

            }

            override fun onFailure(call: Call<List<PostModel>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        //getMyData()




    }

    override fun onItemClick(item: PostModel, position: Int) {
        val intent= Intent(this, DetailedActivity::class.java) //creating intent ... it will open repodetails class // this ... is main activity
      // intent.putExtra(Constants.KEY_INTENT_DATA,PostModel) // pasisng the data in the intent view (mydataitem)
        intent.putExtra("item",item)
        this.startActivity(intent)
    }
}