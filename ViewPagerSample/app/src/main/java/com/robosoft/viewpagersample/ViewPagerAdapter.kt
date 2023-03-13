package com.robosoft.viewpagersample

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.robosoft.viewpagersample.fragment.BlueFragment
import com.robosoft.viewpagersample.fragment.BrownFragment
import com.robosoft.viewpagersample.fragment.GreenFragment
import com.robosoft.viewpagersample.fragment.RedFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 4
    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> RedFragment()
            1 -> GreenFragment()
            2 -> BlueFragment()
            3 -> BrownFragment()
            else -> throw Resources.NotFoundException("Position Not Found")
        }
    }
}
