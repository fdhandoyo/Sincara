package org.jvf.sincara.ui.tips.kosakata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.jvf.sincara.databinding.FragmentKosakataBinding

class KosakataFragment : Fragment() {
    private lateinit var binding: FragmentKosakataBinding
    private lateinit var viewModel: KosakataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKosakataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(KosakataViewModel::class.java)
    }
}