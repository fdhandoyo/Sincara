package org.jvf.sincara.ui.sejarah

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.jvf.sincara.databinding.FragmentSejarahBinding

class SejarahFragment : Fragment() {
    private lateinit var binding: FragmentSejarahBinding
    private lateinit var viewModel: SejarahViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSejarahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SejarahViewModel::class.java)

    }
}