package jp.chau2chaun2.honkot.samplejetpackproject2020.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import jp.chau2chaun2.honkot.samplejetpackproject2020.R
import jp.chau2chaun2.honkot.samplejetpackproject2020.databinding.Fragment3rdBinding
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.EachViewModel
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.MainViewModel
import javax.inject.Inject

class ThirdFragment : DaggerFragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val commonViewModel by viewModels<MainViewModel> { vmFactory }

    private val eachViewModel by viewModels<EachViewModel> { vmFactory }

    private lateinit var binding: Fragment3rdBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = Fragment3rdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.commonVM = commonViewModel
        binding.eachVM = eachViewModel

        view.findViewById<Button>(R.id.nextButton).apply {
            setOnClickListener {
                val action = ThirdFragmentDirections.actionThirdFragmentToForthFragment()
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
