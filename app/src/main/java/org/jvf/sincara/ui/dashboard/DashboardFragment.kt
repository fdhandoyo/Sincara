package org.jvf.sincara.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import org.jvf.sincara.R
import org.jvf.sincara.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding

    private val viewModel: DashboardViewModel by lazy {
        ViewModelProvider(this).get(DashboardViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.tombolAngka.setOnClickListener { navAngka() }
        binding.tombolAlfabet.setOnClickListener { navHuruf() }
        binding.tombolKomnunikasi.setOnClickListener { navKomunikasi() }
        binding.profileButton.setOnClickListener { navProfile() }
        viewModel.authState.observe(viewLifecycleOwner) {}
    }

    private fun navAngka() {
        val action = DashboardFragmentDirections.actionDashboardFragmentToAngkaFragment()
        findNavController().navigate(action)
    }
    private fun navHuruf() {
        val action = DashboardFragmentDirections.actionDashboardFragmentToAlphabetFragment()
        findNavController().navigate(action)
    }
    private fun navKomunikasi() {
        val action = DashboardFragmentDirections.actionDashboardFragmentToKomunikasiFragment()
        findNavController().navigate(action)
    }
    private fun navProfile() {
        val action = DashboardFragmentDirections.actionDashboardFragmentToProfileFragment()
        findNavController().navigate(action)
    }
}



