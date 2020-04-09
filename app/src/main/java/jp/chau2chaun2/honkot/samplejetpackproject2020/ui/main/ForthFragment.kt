package jp.chau2chaun2.honkot.samplejetpackproject2020.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import jp.chau2chaun2.honkot.samplejetpackproject2020.R
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.MainViewModel
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.factory.MainViewModelFactory

class ForthFragment : Fragment() {

    companion object {
        fun newInstance() = ForthFragment()
    }

    private val viewModel: MainViewModel by lazy { ViewModelProvider(this, MainViewModelFactory(0)).get(MainViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_4th, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.nextButton).apply {
            setOnClickListener {
                val action = ForthFragmentDirections.actionForthFragmentToFifthFragment()
                findNavController().navigate(action)
            }
        }
    }
}
