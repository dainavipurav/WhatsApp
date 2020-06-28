package com.example.whatsapp.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.whatsapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var mBottomNavigationView: BottomNavigationView
    private lateinit var mNavController: NavController

    lateinit var mToolbar: androidx.appcompat.widget.Toolbar
    lateinit var mImageViewToolBarProfile: ImageView
    lateinit var mTextViewToolbarName : TextView
    lateinit var mTextViewToolbarLastSeen : TextView
    lateinit var mImageViewToolBarVideo : ImageView
    lateinit var mImageViewToolBarCall : ImageView
    lateinit var mImageViewToolBarMore : ImageView

    lateinit var mConstraintLayoutMainScreen : ConstraintLayout
    lateinit var mconstraintLayoutChatScreen : ConstraintLayout

    lateinit var mImageViewToolBarLogo : ImageView
    lateinit var mTextViewToolbarTitle : TextView
    lateinit var mImageViewToolBarSearch : ImageView

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBottomNavigationView = findViewById(R.id.bottomNavigationView)

        mNavController = this@MainActivity.findNavController(R.id.nav_host_fragment)

        mToolbar = findViewById(R.id.toolbar)

        mConstraintLayoutMainScreen = findViewById(R.id.constraintLayoutMainScreen)
        mconstraintLayoutChatScreen = findViewById(R.id.constraintLayoutChatScreen)
        mImageViewToolBarProfile = findViewById(R.id.imageViewToolBarProfile)
        mTextViewToolbarName = findViewById(R.id.textViewToolbarName)
        mTextViewToolbarLastSeen = findViewById(R.id.textViewToolbarLastSeen)
        mImageViewToolBarVideo = findViewById(R.id.imageViewToolBarVideo)
        mImageViewToolBarCall = findViewById(R.id.imageViewToolBarCall)
        mImageViewToolBarMore = findViewById(R.id.imageViewToolBarMore)

        mImageViewToolBarSearch = findViewById(R.id.imageViewToolBarSearch)
        mTextViewToolbarTitle = findViewById(R.id.textViewToolbarTitle)
        mImageViewToolBarLogo = findViewById(R.id.imageViewToolBarLogo)

        mTextViewToolbarLastSeen.isSelected = true
        mTextViewToolbarName.isSelected = true

        mBottomNavigationView.setupWithNavController(mNavController)

        //NavigationUI.setupActionBarWithNavController(this@MainActivity, mNavController)
        mNavController.addOnDestinationChangedListener(this@MainActivity)

        setSupportActionBar(mToolbar)

        setupActionBarWithNavController(
            mNavController, AppBarConfiguration(
                topLevelDestinationIds = setOf(
                    R.id.callsFragment,
                    R.id.photoFragment,
                    R.id.chatsFragment,
                    R.id.contactsFragment,
                    R.id.moreFragment
                )
            )
        )
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.photoFragment,
            R.id.callsFragment,
            R.id.chatsFragment,
            R.id.contactsFragment,
            R.id.moreFragment -> {
                mToolbar.visibility = View.VISIBLE

                mconstraintLayoutChatScreen.visibility = View.GONE
                mConstraintLayoutMainScreen.visibility = View.VISIBLE
                Glide.with(this).load(R.drawable.ic_search).into(mImageViewToolBarSearch)


                /*mImageViewToolBarProfile.visibility = View.VISIBLE
                mTextViewToolbarName.visibility = View.VISIBLE
                mTextViewToolbarLastSeen.visibility = View.VISIBLE
                mImageViewToolBarVideo.visibility = View.VISIBLE
                mImageViewToolBarCall.visibility = View.VISIBLE
                mImageViewToolBarMore.visibility = View.VISIBLE*/

                //Glide.with(this).load(R.drawable).
                Glide.with(this).load(R.drawable.logo).into(mImageViewToolBarProfile)
                mTextViewToolbarName.text = getString(R.string.app_name)
                Glide.with(this).load(R.drawable.ic_search).into(mImageViewToolBarMore)
                mImageViewToolBarCall.visibility = View.GONE
                mImageViewToolBarVideo.visibility = View.GONE
                mTextViewToolbarLastSeen.visibility = View.GONE

                mBottomNavigationView.visibility = View.VISIBLE
            }

            R.id.viewMyMessagesFragment -> {
                mToolbar.visibility = View.VISIBLE

                mConstraintLayoutMainScreen.visibility = View.GONE
                mconstraintLayoutChatScreen.visibility = View.VISIBLE

                mImageViewToolBarProfile.visibility = View.VISIBLE
                mTextViewToolbarName.visibility = View.VISIBLE
                mTextViewToolbarLastSeen.visibility = View.VISIBLE
                mImageViewToolBarVideo.visibility = View.VISIBLE
                mImageViewToolBarCall.visibility = View.VISIBLE
                mImageViewToolBarMore.visibility = View.VISIBLE
                mBottomNavigationView.visibility = View.GONE
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp()
    }

}