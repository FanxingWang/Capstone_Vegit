package sheridan.fanxing.vegit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import sheridan.fanxing.vegit.fragments.GroceryListFragment
import sheridan.fanxing.vegit.fragments.HomeFragment
import sheridan.fanxing.vegit.fragments.MarketingFragment
import sheridan.fanxing.vegit.fragments.ScanIngredientFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val scanIngredientFragment = ScanIngredientFragment()
        val groceryListFragment = GroceryListFragment()
        val marketingFragment = MarketingFragment()

        makeCurrentFragment(homeFragment)
        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener { when (it.itemId){
            R.id.ic_home->makeCurrentFragment(homeFragment)
            R.id.ic_camera->makeCurrentFragment(scanIngredientFragment)
            R.id.ic_list->makeCurrentFragment(groceryListFragment)
            R.id.ic_marketing->makeCurrentFragment(marketingFragment)


        }
            true}


    }

    private fun makeCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {replace(R.id.fl_wrapper,fragment)
        commit()}
}