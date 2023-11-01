package org.jvf.sincara.ui.login

import androidx.navigation.fragment.findNavController
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import org.jvf.sincara.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private val contract = FirebaseAuthUIActivityResultContract()
    private val signInLauncher = registerForActivityResult(contract) { }
    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginGoogle.setOnClickListener { googleLogin() }
    }

        private fun googleLogin() {
            val providers = arrayListOf(AuthUI.IdpConfig.GoogleBuilder().build())
            val intent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build()
            signInLauncher.launch(intent)
            viewModel.authState.observe(viewLifecycleOwner, { user ->
                if (user == null) {
                    // Pengguna belum login, tampilkan tampilan login
                    binding.root.visibility = View.VISIBLE
                } else {
                    // Pengguna telah login, navigasikan ke DashboardFragment
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToDashboardFragment()
                    )
                }
            })
        }
    }






