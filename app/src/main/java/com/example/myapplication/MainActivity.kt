package com.example.myapplication

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences.Editor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    lateinit var mAdView : AdView
    private lateinit var webView: WebView
    private lateinit var editor : Editor
    private lateinit var btn : SwitchCompat
    private var recyclerView: RecyclerView? = null
    private var myAdapter: MyAdapter? = null
    private var bookList = arrayListOf<MyModel>()

    private lateinit var header : View
    private lateinit var navigationView : NavigationView
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var menu : ImageView


    private final var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}



        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val adView = AdView(this)
           AdSize.BANNER
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"



        supportActionBar?.hide()

        val sharedPreferences = getSharedPreferences("Mode", Context.MODE_PRIVATE)
        val nightMode = sharedPreferences.getBoolean("night", false)
        editor = sharedPreferences.edit()

        webView = findViewById(R.id.webView)
       webView.visibility = View.GONE

        btn = findViewById(R.id.switchBtn)

        if(nightMode) {
            bannerAd()
            btn.isChecked = true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        }


       btn.setOnCheckedChangeListener { buttonView, isChecked ->
           if(!isChecked) {
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
               editor.putBoolean("night", false)
               editor.apply()
           } else {
               bannerAd()
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
               editor.putBoolean("night", true)
               editor.apply()
           }
       }


        menu = findViewById(R.id.menu)
        navigationView  = findViewById(R.id.navView)
        navigationView.setNavigationItemSelectedListener(this)
        drawerLayout = findViewById(R.id.drawerLayout)



        recyclerView = findViewById(R.id.recyclerView)
        myAdapter = MyAdapter(this, bookList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = myAdapter



        bookList.add(MyModel(0, "Content"))
        bookList.add (MyModel(1, "Verb (Basic)"))
        bookList.add (MyModel(2, "Tense"))
        bookList.add (MyModel(3, "Passive Voice"))
        bookList.add (MyModel(4, "Narration"))
        bookList.add (MyModel(5, "Question Tag"))
        bookList.add (MyModel(6, "Subject Verb Agreement"))
        bookList.add (MyModel(7, "Conditional Sentence"))
        bookList.add (MyModel(8, "Verb (Advance)"))
        bookList.add (MyModel(9, "Noun"))
        bookList.add (MyModel(10, "Pronoun"))
        bookList.add (MyModel(11, "Adjective"))
        bookList.add(MyModel(12, "Conjunction"))
        bookList.add(MyModel(13, "Article"))
        bookList.add(MyModel(14, "Preposition"))
        bookList.add(MyModel(15, "Adverb"))
        bookList.add(MyModel(16, "words Often Confused and misused"))
        bookList.add(MyModel(17, "Vocabularies"))
        bookList.add(MyModel(18, "Synonyms"))
        bookList.add(MyModel(19, "Antonyms"))
        bookList.add(MyModel(20, "One Word Substitution"))
        bookList.add(MyModel(21, "One Word Substitution - Practice Set"))
        bookList.add(MyModel(22, "Idioms and phrases - 1"))
        bookList.add(MyModel(23, "idioms and phrases - 2"))
        bookList.add(MyModel(24, "idioms and phrases (Practice Set) "))

        recyclerView!!.adapter = myAdapter
        myAdapter = MyAdapter(this, bookList)


        header = navigationView.getHeaderView(0)

        menu.setOnClickListener {
            if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.share -> {

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Get Neetu Singh English Book . \n\n  https://play.google.com/store/apps/details?id= " + packageName
                )
                startActivity(Intent.createChooser(intent, "Get Neetu Singh English Book"))


                Toast.makeText(this, "Share Now", Toast.LENGTH_SHORT).show()
            }

            R.id.feedback -> {

                Toast.makeText(this, "Will be available soon", Toast.LENGTH_SHORT).show()
            }


            R.id.rate -> {
                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
                } catch(e : ActivityNotFoundException) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
                }


                Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show()
            }
            R.id.policy -> {

                webView.visibility = View.VISIBLE
                webView.webViewClient = WebViewClient()
               webView.apply {
                  loadUrl("https://healthiency.blogspot.com/2023/05/neetu-singh-english-book-privacy-policy.html")
                   settings.javaScriptEnabled = true
                   settings.allowFileAccess = true
                   settings.allowContentAccess = true
                   settings.allowFileAccessFromFileURLs = true
               }


            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
private fun bannerAd() {
    val mAdView1 = findViewById<AdView>(R.id.adView)
    val adRequest = AdRequest.Builder().build()
    mAdView1.loadAd(adRequest)
    val adView = AdView(this)
    AdSize.BANNER
    adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"

}

}


