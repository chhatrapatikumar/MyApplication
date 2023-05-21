package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class BookActivity : AppCompatActivity() {


    private final var TAG = "MainActivity"

    private lateinit var pdfView : PDFView
    private lateinit var editor : Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        MobileAds.initialize(this) {}




        pdfView = findViewById(R.id.pdfView)


        val btn = findViewById<SwitchCompat>(R.id.switchBtn)

        val sharedPreferences = getSharedPreferences("Dark", Context.MODE_PRIVATE)
        val nightMode = sharedPreferences.getBoolean("black", false)
        editor = sharedPreferences.edit()
                val pos = intent.getIntExtra("position", 0)

                if(pos == 0) {
                   bannerAd()
                    pdfView.fromAsset("book.pdf")
                        .scrollHandle(DefaultScrollHandle(this))
                        .enableSwipe(true).pages(5.6.toInt()).load()
                    pdfView.zoom
                    pdfView.pageCount
                    pdfView.currentPage


                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        bannerAd()

                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this))
                            .enableSwipe(true).pages(5.6.toInt()).nightMode(true).load()
                    }

                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true).pages(5.6.toInt()).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true).pages(5.6.toInt()).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if (pos == 1) {
                    bannerAd()

                    pdfView.fromAsset("book.pdf")
                        .scrollHandle(DefaultScrollHandle(this))
                        .autoSpacing(true)
                        .enableSwipe(true).pages(
                            6, 7, 8, 9 , 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29.5.toInt()
                        ).load()

                    if(nightMode) {
                        bannerAd()
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                6, 7, 8, 9 , 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29.5.toInt()
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true).pages(
                                    6, 7, 8, 9 , 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29.5.toInt()
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true).pages(
                                    6, 7, 8, 9 , 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29.5.toInt()
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                else if (pos == 2) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45.toInt(),
                    ).load()
                    pdfView.zoom
                    pdfView.pageCount
                    pdfView.currentPage


                    if(nightMode) {
                         bannerAd()
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .enableSwipe(true) .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .pages(
                                30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46.5.toInt()
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true) .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .pages(
                                    30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46.5.toInt()
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true).pages(
                                    30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46.5.toInt()
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }


                } else if (pos == 3) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 63, 64, 65, 66, 67, 68, 69, 70,
                        71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                        80.5.toInt()
                    ).load()


                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .enableSwipe(true)
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10).pages(
                                46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 63, 64, 65, 66, 67, 68, 69, 70,
                                71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                                80.5.toInt()
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10) .enableSwipe(true)
                                .pages(
                                    46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 63, 64, 65, 66, 67, 68, 69, 70,
                                    71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                                    80.5.toInt()
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true) .scrollHandle(DefaultScrollHandle(this)).spacing(10).pages(
                                    46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 63, 64, 65, 66, 67, 68, 69, 70,
                                    71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                                    80.5.toInt()
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                }  else if (pos == 4) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104,
                        105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 114.5.toInt()
                    ).load()
                    pdfView.zoom
                    pdfView.pageCount
                    pdfView.currentPage

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104,
                                105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 114.5.toInt()
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true).pages(
                                    81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104,
                                    105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 114.5.toInt()
                                ).nightMode(false) .scrollHandle(DefaultScrollHandle(this)).spacing(10).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true).pages(
                                    81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104,
                                    105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 114.5.toInt()
                                ).nightMode(true) .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }


                } else if (pos == 5) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        115, 116, 117.5.toInt()
                    ).load()


                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .enableSwipe(true).pages(
                                115, 116, 117.5.toInt()

                            ).nightMode(true) .scrollHandle(DefaultScrollHandle(this)).spacing(10).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    115, 116, 117.5.toInt()
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true).pages(
                                    115, 116, 117.5.toInt()
                                ) .scrollHandle(DefaultScrollHandle(this)).spacing(10).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }



                } else if(pos == 6) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf").enableSwipe(true)
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10) .pages(
                        118,119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130 , 131.5.toInt()
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                118,119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130 , 131.5.toInt()
                            ).nightMode(true).load()
                        Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    118,119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130 , 131.5.toInt()
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .enableSwipe(true).pages(
                                    118,119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130 , 131.5.toInt()
                                ).nightMode(true) .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 7) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        132, 133, 134, 135, 136, 137, 138.5.toInt()
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                132, 133, 134, 135, 136, 137, 138.5.toInt()
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    132, 133, 134, 135, 136, 137, 138.5.toInt()
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    132, 133, 134, 135, 136, 137, 138.5.toInt()
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 8) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153.5.toInt()
                    ).load()
                    Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153.5.toInt()
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153.5.toInt()
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153.5.toInt()
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }


                } else if(pos == 9) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf").enableSwipe(true)
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10).pages(
                        154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170.5.toInt(),
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 10) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf")
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        171, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187,188, 189, 190.5.toInt(),
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                171, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187,188, 189, 190.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    171, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187,188, 189, 190.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    171, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187,188, 189, 190.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 11) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf").enableSwipe(true)
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .pages(
                        191, 192, 193, 194, 195, 196, 197,  198, 199, 200, 201, 202, 203, 204, 205, 206.6.toInt()
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .enableSwipe(true) .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .pages(
                                191, 192, 193, 194, 195, 196, 197,  198, 199, 200, 201, 202, 203, 204, 205, 206.6.toInt()
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    191, 192, 193, 194, 195, 196, 197,  198, 199, 200, 201, 202, 203, 204, 205, 206.6.toInt()
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    191, 192, 193, 194, 195, 196, 197,  198, 199, 200, 201, 202, 203, 204, 205, 206.6.toInt()
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 12) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf")
                        .scrollHandle(DefaultScrollHandle(this))
                        .spacing(10).enableSwipe(true).pages(
                        208, 209, 210, 211, 212, 213, 214, 215, 217, 218, 219, 220, 221.5.toInt(),
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                208, 209, 210, 211, 212, 213, 214, 215, 217, 218, 219, 220, 221.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    208, 209, 210, 211, 212, 213, 214, 215, 217, 218, 219, 220, 221.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    208, 209, 210, 211, 212, 213, 214, 215, 217, 218, 219, 220, 221.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 13) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf").enableSwipe(true)
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .pages(
                        222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236.5.toInt(),
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 14) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf")
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254,
                        255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272,
                        273, 274, 275.5.toInt(),
                    ).load()
                    // 237..276

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254,
                                255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272,
                                273, 274, 275.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254,
                                    255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272,
                                    273, 274, 275.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254,
                                    255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272,
                                    273, 274, 275.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 15) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf")
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 287, 288, 289.5.toInt(),
                    ).load()
                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf") .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 287, 288, 289.5.toInt(),
                            ).nightMode(true).load()
                        Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 287, 288, 289.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 287, 288, 289.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }
                    // 276..290//
                } else if(pos == 16) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf")
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300.5.toInt()
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300.5.toInt()
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300.5.toInt()
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300.5.toInt()
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 17) {
                    pdfView.fromAsset("book.pdf")
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319,
                        320, 321, 322, 323, 324.5.toInt(),
                        // 01..325//
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319,
                                320, 321, 322, 323, 324.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319,
                                    320, 321, 322, 323, 324.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319,
                                    320, 321, 322, 323, 324.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 18) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf").enableSwipe(true)
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .pages(
                        325, 326, 327, 328, 329, 330, 331, 332, 333, 334.5.toInt(),
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                325, 326, 327, 328, 329, 330, 331, 332, 333, 334.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    325, 326, 327, 328, 329, 330, 331, 332, 333, 334.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    325, 326, 327, 328, 329, 330, 331, 332, 333, 334.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else if(pos == 19) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf").enableSwipe(true)
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .pages(
                        335, 336, 337, 338, 339, 340, 341, 342, 343, 344.5.toInt(),
                    ).load()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .enableSwipe(true)
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .pages(
                                335, 336, 337, 338, 339, 340, 341, 342, 343, 344.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    335, 336, 337, 338, 339, 340, 341, 342, 343, 344.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    335, 336, 337, 338, 339, 340, 341, 342, 343, 344.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }



                } else if(pos == 20) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf").enableSwipe(true)
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .pages(
                        345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 360, 361, 362.5.toInt(),
                    ).load()


                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 360, 361, 362.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 360, 361, 362.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 360, 361, 362.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }




                } else if(pos == 21) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf").enableSwipe(true)
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .pages(
                        363, 364, 365, 366, 367, 368, 369, 370, 371, 372.5.toInt(),
                    ).load()



                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                363, 364, 365, 366, 367, 368, 369, 370, 371, 372.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    363, 364, 365, 366, 367, 368, 369, 370, 371, 372.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    363, 364, 365, 366, 367, 368, 369, 370, 371, 372.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }




                } else if(pos == 22) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf").enableSwipe(true)
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .pages(
                        373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386.5.toInt(),
                    ).load()




                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {

                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }


                } else if(pos == 23) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf")
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        387, 388, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402.5.toInt(),
                    ).load()




                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                387, 388, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    387, 388, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    387, 388, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                        }
                    }




                } else if(pos == 24) {
                    bannerAd()
                    pdfView.fromAsset("book.pdf")
                        .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                        .enableSwipe(true).pages(
                        403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420,
                        421, 422.5.toInt(),

                        ).load()
                    Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()

                    if(nightMode) {
                        btn.isChecked = true
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        pdfView.fromAsset("book.pdf")
                            .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                            .enableSwipe(true).pages(
                                403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420,
                                421, 422.5.toInt(),
                            ).nightMode(true).load()
                    }


                    btn.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(!isChecked) {
                            Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            editor.putBoolean("black", false)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420,
                                    421, 422.5.toInt(),
                                ).nightMode(false).load()
                        } else {
                            bannerAd()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            editor.putBoolean("black", true)
                            editor.apply()
                            pdfView.fromAsset("book.pdf")
                                .scrollHandle(DefaultScrollHandle(this)).spacing(10)
                                .enableSwipe(true).pages(
                                    403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420,
                                    421, 422.5.toInt(),
                                ).nightMode(true).load()
                            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()

                        }
                    }
                }



        }

    private fun bannerAd() {

       val mAdView = findViewById<AdView>(R.id.adView)

            val adRequest = AdRequest.Builder().build()
            mAdView.loadAd(adRequest)
            val adView = AdView(this)
            AdSize.BANNER
            adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"

    }

}