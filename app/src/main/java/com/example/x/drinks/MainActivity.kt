package com.example.x.drinks

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.x.drinks.R.id.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var dBase: SQLiteDatabase
    lateinit var mAdView:AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713")
        mAdView = adview
         var adRequest:AdRequest  = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        dBase = openOrCreateDatabase("snak_db",
                Context.MODE_PRIVATE,null)
        dBase.execSQL("create table if not exists snak(title primary key,size float,description varchar(1000))")
// insert into table_name values(value1,'value2','value3')

        ll1.setOnClickListener({
            var i= Intent(this@MainActivity,Main2Activity::class.java )
            startActivity(i)
        })
        ll2.setOnClickListener({
            var i= Intent(this@MainActivity,Main3Activity::class.java )
            startActivity(i)
        })
        ll3.setOnClickListener({
            var i= Intent(this@MainActivity,Main4Activity::class.java )
            startActivity(i)
        })
        ll4.setOnClickListener({
            var i= Intent(this@MainActivity,Main5Activity::class.java )
            startActivity(i)
        })
        ll5.setOnClickListener({
            var i= Intent(this@MainActivity,Main6Activity::class.java )
            startActivity(i)
        })
        ll6.setOnClickListener({
            var i= Intent(this@MainActivity,Main7Activity::class.java )
            startActivity(i)
        })
        ll7.setOnClickListener({
            var i= Intent(this@MainActivity,Main8Activity::class.java )
            startActivity(i)
        })
        ll8.setOnClickListener({
            var i= Intent(this@MainActivity,Main9Activity::class.java )
            startActivity(i)
        })
        ll9.setOnClickListener({
            var i= Intent(this@MainActivity,Main10Activity::class.java )
            startActivity(i)
        })
        ll10.setOnClickListener({
            var i= Intent(this@MainActivity,Main11Activity::class.java )
            startActivity(i)
        })


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun displayScreen(id : Int){
        val fragment = when(id){
            R.id.nav_camera -> {

            }
            R.id.nav_gallery -> {

            }
            else -> {
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.main, fragment as Fragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        displayScreen(item.itemId)


        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
