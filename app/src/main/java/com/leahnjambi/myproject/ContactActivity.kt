package com.leahnjambi.myproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var peopleList: ArrayList<People>
    private lateinit var peopleAdapter: PeopleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        recyclerView = findViewById(R.id.rycleP)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        peopleList = ArrayList()

        peopleList.add(People(R.drawable.chef1, " Chef Nelly"))
        peopleList.add(People(R.drawable.chef2, "Chef Mary",))
        peopleList.add(People(R.drawable.chef3, "Chef Cate",))
        peopleList.add(People(R.drawable.chef4, "Chef william",))
        peopleList.add(People(R.drawable.chef5, "Chef Lilly",))
        peopleList.add(People(R.drawable.chef6, "Chef Alvin",))
        peopleList.add(People(R.drawable.chef7, "Chef Kelvin",))
        peopleList.add(People(R.drawable.chef8, "Chef Peter",))
        peopleList.add(People(R.drawable.chef9, "Chef Maureen",))
        peopleList.add(People(R.drawable.chef10, "Chef Sam",))
        peopleList.add(People(R.drawable.chef11, "Chef Antony",))
        peopleList.add(People(R.drawable.chef12, "Chef Benson",))
        peopleList.add(People(R.drawable.chef13, "Chef Grace",))
        peopleList.add(People(R.drawable.chef14, "Chef Naicy",))
        peopleList.add(People(R.drawable.chef15, "Chef Kion",))


        peopleAdapter = PeopleAdapter(peopleList)
        recyclerView.adapter = peopleAdapter
        peopleAdapter.onItemClick = {
            val intent = Intent(this,PeopleActivity::class.java)
            intent.putExtra("people", it)
            startActivity(intent)
        }

    }
}