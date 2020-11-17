package jp.chau2chaun2.honkot.samplejetpackproject2020.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.viewbinding.BindableItem
import dagger.hilt.android.AndroidEntryPoint
import jp.chau2chaun2.honkot.samplejetpackproject2020.CustomApplication
import jp.chau2chaun2.honkot.samplejetpackproject2020.R
import jp.chau2chaun2.honkot.samplejetpackproject2020.databinding.FragmentGroupieListBinding
import jp.chau2chaun2.honkot.samplejetpackproject2020.databinding.ItemGroupieListBinding
import jp.chau2chaun2.honkot.samplejetpackproject2020.model.SampleBindingData
import jp.chau2chaun2.honkot.samplejetpackproject2020.util.autoCleared
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.GroupieListViewModel
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.RowGroupieViewModel

@AndroidEntryPoint
class GroupieListFragment : Fragment() {

    private val viewModel by activityViewModels<GroupieListViewModel>()
    private var binding by autoCleared<FragmentGroupieListBinding>()
    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGroupieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.list.adapter = adapter
        viewModel.listItems.observe(viewLifecycleOwner) {
            adapter.update(it.map { ListItem(it) })
        }
        viewModel.initialize()
    }

    private inner class ListItem(
        private val data: SampleBindingData
    ) : BindableItem<ItemGroupieListBinding>(data.displayData.hashCode().toLong()) {

        override fun getLayout() = R.layout.item_groupie_list

        override fun initializeViewBinding(view: View): ItemGroupieListBinding {
            return ItemGroupieListBinding.bind(view).also {
                val component = (view.context.applicationContext as CustomApplication).rowViewModelComponent
                val rowViewModel = RowGroupieViewModel(component)
                it.lifecycleOwner = viewLifecycleOwner
                it.viewModel = rowViewModel
                it.root.tag = rowViewModel
            }
        }

        @SuppressLint("SetTextI18n")
        override fun bind(viewBinding: ItemGroupieListBinding, position: Int) {
            val rowViewModel = viewBinding.root.tag as RowGroupieViewModel
            rowViewModel.setData(data)
        }
    }
}
