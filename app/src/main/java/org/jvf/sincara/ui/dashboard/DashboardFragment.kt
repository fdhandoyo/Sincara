package org.jvf.sincara.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import org.jvf.sincara.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding

    private val viewModel: DashboardViewModel by lazy {
        ViewModelProvider(this).get(DashboardViewModel::class.java)
    }

//    private fun updateUi(user: FirebaseUser?) = with(binding){
//        if (user == null) {
//            button2.text = getString(R.string.logout)
//        }
//        button2.text = getString(R.string.logout)
//    }

    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        val action = DashboardFragmentDirections.actionDashboardFragmentToAlphabetFragment()
        findNavController().navigate(action)
    }
    private fun navAngka() {
        val action = DashboardFragmentDirections.actionDashboardFragmentToAngkaFragment()
        findNavController().navigate(action)
    }
    private fun navHuruf() {
        val action = DashboardFragmentDirections.actionDashboardFragmentToAlphabetFragment()
        findNavController().navigate(action)
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
        binding.button2.setOnClickListener { logout() }
        binding.tombolAngka.setOnClickListener{ navAngka() }
        binding.tombolAlfabet.setOnClickListener { navHuruf() }
        viewModel.authState.observe(viewLifecycleOwner) {}
    }
}



