package com.codewithvu.pizzaorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.codewithvu.pizzaorder.databinding.FragmentOrderBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        binding.fab.setOnClickListener {
            val pizzaId = binding.pizzaGroup.checkedRadioButtonId
            if (pizzaId == -1) {
                Toast.makeText(activity, "You need to choose a pizza type", Toast.LENGTH_LONG).show()
            }
            else {
                var orderText = (when (binding.pizzaGroup.id) {
                    R.id.diavolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                })
                if (binding.parmesan.isChecked) orderText += ", extra parmesan"
                if (binding.chiliOil.isChecked) orderText += ", extra chili oil"
                Snackbar.make(binding.fab, orderText,Snackbar.LENGTH_SHORT).show()
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}