package com.example.shopease2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var drawerLayout: DrawerLayout  // Reference to DrawerLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Get DrawerLayout from the Activity
        drawerLayout = requireActivity().findViewById(R.id.drawerLayout)



        // Find btnMenu and set click listener
        val btnMenu = view.findViewById<Button>(R.id.btnMenu)
        btnMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvCategories = view.findViewById<RecyclerView>(R.id.rvCategories)

        val categoryList = listOf(
            category("Fruits and vegetables", R.drawable.ic_fruitsandvegetables),
            category("Soda and detergents", R.drawable.ic_shampoo),
            category("Bakery", R.drawable.ic_bakery),
            category("Dairy", R.drawable.ic_dairy)
        )

        rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = CategoryAdapter(categoryList)
    }

}