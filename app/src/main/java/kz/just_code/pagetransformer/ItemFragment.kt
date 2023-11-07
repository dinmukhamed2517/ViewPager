package kz.just_code.pagetransformer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kz.just_code.pagetransformer.databinding.FragmentItemBinding

class ItemFragment(private val item:Item?):Fragment() {
    private lateinit var binding:FragmentItemBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        item?.let {
            binding.root.setImageResource(it.image)
        }
    }
}