package com.devchernikova.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.devchernikova.firstapp.databinding.FragmentSelectionsBinding



class SelectionsFragment : Fragment(R.layout.fragment_selections) {

    private var fragmentSelectionsBinding: FragmentSelectionsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSelectionsBinding.bind(view)
        fragmentSelectionsBinding = binding

        AnimationHelper.performFragmentCircularRevealAnimation(binding.selectionsFragmentRoot, requireActivity(), 3)
    }
    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        fragmentSelectionsBinding = null
        super.onDestroyView()
    }
}
