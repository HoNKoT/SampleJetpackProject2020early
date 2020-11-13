package jp.chau2chaun2.honkot.samplejetpackproject2020.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.chau2chaun2.honkot.samplejetpackproject2020.R
import jp.chau2chaun2.honkot.samplejetpackproject2020.databinding.Fragment3rdBinding
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.EachViewModel
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.MainViewModel

@AndroidEntryPoint
class ThirdFragment : Fragment() {

    private val commonViewModel by activityViewModels<MainViewModel>()

    private val eachViewModel by viewModels<EachViewModel>()

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
