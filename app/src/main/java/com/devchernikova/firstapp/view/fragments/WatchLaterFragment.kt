package com.devchernikova.firstapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.devchernikova.firstapp.R
import com.devchernikova.firstapp.databinding.FragmentWatchLaterBinding
import com.devchernikova.firstapp.utils.AnimationHelper


class WatchLaterFragment : Fragment(R.layout.fragment_watch_later) {

    private var fragmentWatchLaterBinding: FragmentWatchLaterBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentWatchLaterBinding.bind(view)
        fragmentWatchLaterBinding = binding

        AnimationHelper.performFragmentCircularRevealAnimation(binding.watchLaterFragmentRoot, requireActivity(), 4)
    }
    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        fragmentWatchLaterBinding = null
        super.onDestroyView()
    }
}
