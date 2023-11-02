package org.jvf.sincara.ui.profile

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import org.jvf.sincara.R
import org.jvf.sincara.databinding.FragmentDashboardBinding
import org.jvf.sincara.databinding.FragmentProfileBinding
import org.jvf.sincara.ui.dashboard.DashboardFragment
import org.jvf.sincara.ui.dashboard.DashboardFragmentDirections
import org.jvf.sincara.ui.dashboard.DashboardViewModel

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    private val viewModel: ProfileViewModel by lazy {
        ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firebaseAuth = FirebaseAuth.getInstance()
        val currentUser = firebaseAuth.currentUser

        // Ambil data pengguna dari Firebase
        val email = currentUser?.email
        val phoneNumber = currentUser?.phoneNumber
        val name = currentUser?.displayName

        // Tampilkan data pengguna dalam teks di bawah nama lengkap
        binding.textEmailnya.text = email
        binding.textNamanya.text = name
        binding.textNomornya.text = phoneNumber
        binding.profUsername.text = name

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding.butLogout.setOnClickListener { logout() }
    }
//    private fun logout() {
//        FirebaseAuth.getInstance().signOut()
//        val action = ProfileFragmentDirections.actionProfileFragmentToLoginFragment()
//        findNavController().navigate(action)
//    }

    private fun logout() {
        val firebaseAuth = FirebaseAuth.getInstance()
        val currentUser = firebaseAuth.currentUser

        val email = currentUser?.email
        val phoneNumber = currentUser?.phoneNumber

        // Gunakan email dan phoneNumber sesuai kebutuhan Anda
        if (email != null) {
            // Lakukan sesuatu dengan email
        }
        if (phoneNumber != null) {
            // Lakukan sesuatu dengan nomor telepon
        }

        firebaseAuth.signOut()
        val action = ProfileFragmentDirections.actionProfileFragmentToLoginFragment()
        findNavController().navigate(action)
    }
}