package org.jvf.sincara.ui.tips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.jvf.sincara.R
import org.jvf.sincara.databinding.FragmentTipsBinding
import org.jvf.sincara.ui.dashboard.DashboardFragmentDirections


class TipsFragment : Fragment() {
    private lateinit var binding: FragmentTipsBinding
    private lateinit var viewModel: TipsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTipsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(TipsViewModel::class.java)

        binding.button2.setOnClickListener { navSehari() }
        binding.button3.setOnClickListener { navPd() }
        binding.button4.setOnClickListener { navKultur() }
        binding.button5.setOnClickListener { navKendala() }
        binding.button6.setOnClickListener { navKosakata() }

    }

    private fun navSehari() {
        val action = TipsFragmentDirections.actionTipsFragmentToSehariFragment()
        findNavController().navigate(action)
    }

    private fun navPd() {
        val action = TipsFragmentDirections.actionTipsFragmentToPdFragment()
        findNavController().navigate(action)
    }

    private fun navKendala() {
        val action = TipsFragmentDirections.actionTipsFragmentToKendalaFragment()
        findNavController().navigate(action)
    }

    private fun navKultur() {
        val action = TipsFragmentDirections.actionTipsFragmentToKulturFragment()
        findNavController().navigate(action)
    }

    private fun navKosakata() {
        val action = TipsFragmentDirections.actionTipsFragmentToKosakataFragment()
        findNavController().navigate(action)
    }

}