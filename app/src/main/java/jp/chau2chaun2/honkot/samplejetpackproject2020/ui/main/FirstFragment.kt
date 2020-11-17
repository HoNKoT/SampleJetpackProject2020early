package jp.chau2chaun2.honkot.samplejetpackproject2020.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.chau2chaun2.honkot.samplejetpackproject2020.R
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.MainViewModel

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel>()

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
        view.findViewById<Button>(R.id.listButton).apply {
            setOnClickListener {
                val action = FirstFragmentDirections.actionFirstFragmentToGroupieListFragment()
                findNavController().navigate(action)
            }
        }
    }
}
