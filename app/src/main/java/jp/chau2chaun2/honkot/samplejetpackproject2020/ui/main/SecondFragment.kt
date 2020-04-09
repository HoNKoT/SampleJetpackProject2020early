package jp.chau2chaun2.honkot.samplejetpackproject2020.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment
import jp.chau2chaun2.honkot.samplejetpackproject2020.R
import jp.chau2chaun2.honkot.samplejetpackproject2020.databinding.Fragment2ndBinding
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.EachViewModel
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.MainViewModel
import javax.inject.Inject

class SecondFragment : DaggerFragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val commonViewModel by viewModels<MainViewModel> { vmFactory }

    private val eachViewModel by viewModels<EachViewModel> { vmFactory }

    private lateinit var binding: Fragment2ndBinding

    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = Fragment2ndBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.eachVM = eachViewModel
        binding.commonVM = commonViewModel

        view.findViewById<TextView>(R.id.message).text = args.typeString

        view.findViewById<Button>(R.id.nextButton).apply {
            setOnClickListener {
                val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
                findNavController().navigate(action)
            }
        }

        view.findViewById<Button>(R.id.countUpButton).apply {
            setOnClickListener {
                // count up both
                commonViewModel.countUp()
                eachViewModel.countUp()
            }
        }
    }
}
