package jp.chau2chaun2.honkot.samplejetpackproject2020.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import jp.chau2chaun2.honkot.samplejetpackproject2020.R
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.MainViewModel

class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private var count: Int = 0

    private val viewModel: MainViewModel by lazy { ViewModelProvider(activity!!).get(MainViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_3rd, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.nextButton).apply {
            setOnClickListener {
                val action = ThirdFragmentDirections.actionThirdFragmentToForthFragment()
                findNavController().navigate(action)
            }
        }

        view.findViewById<Button>(R.id.countUpButton).apply {
            setOnClickListener {
                // count up both
                count++
                viewModel.countUp()

                // update the views
                updateView()
            }
        }

        // set count observer to update message automatically
        val viewModelValueView = view.findViewById<AppCompatTextView>(R.id.countUpTextOnViewModel)
        viewModel.count.observe(viewLifecycleOwner, Observer { count ->
            viewModelValueView.text = count.toString()
        })
        // set message observer to update message automatically
        val countMessageView = view.findViewById<AppCompatTextView>(R.id.countUpTextOnViewModel2)
        viewModel.countMessage.observe(viewLifecycleOwner, Observer { countMessage ->
            countMessageView.text = countMessage
        })
    }

    override fun onResume() {
        super.onResume()
        updateView()
    }

    private fun updateView() {
        activity?.findViewById<TextView>(R.id.countUpTextOnFragment)?.text = count.toString()
    }
}
