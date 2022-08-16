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
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val pizzaType = view.findViewById<RadioGroup>(R.id.pizza_group);
            val pizzaId = pizzaType.checkedRadioButtonId
            if (pizzaId == -1) {
                Toast.makeText(activity, "You need to choose a pizza type", Toast.LENGTH_LONG).show()
            }
            else {
                var orderText = (when (pizzaType.id) {
                    R.id.diavolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                })
                val parmesan = view.findViewById<Chip>(R.id.parmesan)
                if (parmesan.isChecked) orderText += ", extra parmesan"
                val chili = view.findViewById<Chip>(R.id.chili_oil)
                if (chili.isChecked) orderText += ", extra chili oil"
                Snackbar.make(fab, orderText,Snackbar.LENGTH_SHORT).show()
            }
        }
        return view
    }
}