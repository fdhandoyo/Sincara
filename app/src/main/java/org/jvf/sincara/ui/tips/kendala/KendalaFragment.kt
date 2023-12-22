package org.jvf.sincara.ui.tips.kendala

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.jvf.sincara.databinding.FragmentKendalaBinding

class KendalaFragment : Fragment() {
    private lateinit var binding: FragmentKendalaBinding
    private lateinit var viewModel: KendalaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKendalaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(KendalaViewModel::class.java)
    }
}