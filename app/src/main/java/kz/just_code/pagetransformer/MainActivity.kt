package kz.just_code.pagetransformer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kz.just_code.pagetransformer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList:MutableList<Fragment> = mutableListOf()

        Item.values().forEach {
            fragmentList.add(ItemFragment(it))
        }
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, fragmentList)
        with(binding){
            viewPager.adapter = adapter
            viewPager.offscreenPageLimit = 1
            viewPager.setPageTransformer(Transformer())
        }
        TabLayoutMediator(binding.bottomTab, binding.viewPager){tab, _ ->
            tab.view.isClickable = false
        }.attach()

    }
}