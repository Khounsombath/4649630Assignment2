package com.example.s4649630assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class S4649630LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout for this fragment
        return inflater.inflate(R.layout.fragment_s4649630_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bind UI components
        val edtUsername = view.findViewById<EditText>(R.id.edtUsername)
        val edtPassword = view.findViewById<EditText>(R.id.edtPassword)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter both fields", Toast.LENGTH_SHORT).show()
            } else if (username == "khounsombath" && password == "4649630") {
                // Navigate to Dashboard when correct
                findNavController().navigate(R.id.action_login_to_dashboard)
            } else {
                Toast.makeText(requireContext(), "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
