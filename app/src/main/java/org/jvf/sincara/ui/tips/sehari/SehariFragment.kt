package org.jvf.sincara.ui.tips.sehari

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.jvf.sincara.databinding.FragmentSehariBinding


class SehariFragment : Fragment() {
    private lateinit var binding: FragmentSehariBinding
    private lateinit var viewModel: SehariViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSehariBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SehariViewModel::class.java)

    }
}