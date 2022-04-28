package com.example.bottommenucoordinator

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.bottommenucoordinator.behaviors.HideToolbarBehaviorActivity
import com.example.bottommenucoordinator.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.snackbarShowBtn.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        behaviorSetup()
    }

    private fun behaviorSetup() {
        // Задаем поведение для того что бы скрывать Toolbar при прокрутке
        (binding.appBar.layoutParams as CoordinatorLayout.LayoutParams).behavior = HideToolbarBehaviorActivity()

        // Задаем поведение для нижнего меню
        val standardBottomSheetBehavior = BottomSheetBehavior.from(binding.bottomMenu)

        // Параметр задающий возможность свайпить боттом меню и скрывать его
        // без него даже задав STATE_HIDDEN боттом щит будет показываться
        // можно задать через xml
        standardBottomSheetBehavior.isHideable = true

        // Задаем меню изначально скрытым
        standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        binding.menuButton.setOnClickListener {
            if(standardBottomSheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN)
                standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            else
                standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}