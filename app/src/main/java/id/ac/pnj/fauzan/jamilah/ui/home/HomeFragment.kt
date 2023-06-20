package id.ac.pnj.fauzan.jamilah.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.ac.pnj.fauzan.jamilah.authentication.LoginActivity
import id.ac.pnj.fauzan.jamilah.services.FacialActivity
import id.ac.pnj.fauzan.jamilah.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("session")
    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewModel: HomeViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = ViewModelProvider(
            this, HomeViewModelFactory.getInstance(requireContext().dataStore))[HomeViewModel::class.java]

        viewModel.getSession().observe(requireActivity()) {
            Log.d(this::class.java.simpleName, "Session id: ${it.id}")
            if (it.id == -1) {
                startActivity(Intent(requireActivity(), LoginActivity::class.java))
                requireActivity().finish()
            }
        }
        /*
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

         */
        _binding?.fabHomeFacial?.setOnClickListener {
            val intent = Intent(it.context, FacialActivity::class.java)
            it.context.startActivity(intent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}