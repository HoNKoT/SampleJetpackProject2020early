package jp.chau2chaun2.honkot.samplejetpackproject2020.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import jp.chau2chaun2.honkot.samplejetpackproject2020.R
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.MainViewModel
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.factory.MainViewModelFactory

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private val viewModel: MainViewModel by lazy { ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_1st, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.nextButton).apply {
            setOnClickListener {
                val argsToNext = view.findViewById<EditText>(R.id.editText).text.toString()
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(argsToNext)
                findNavController().navigate(action)
            }
        }
    }
}
