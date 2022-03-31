package org.d3if2090.iniaplikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if2090.iniaplikasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = MainAdapter(getData())
            setHasFixedSize(true)
        }
        binding.button.setOnClickListener { cariAsal() }
    }


    private fun cariAsal() {
        val selectedId = binding.radioGroup.checkedRadioButtonId
        if (selectedId == -1){
            Toast.makeText(this, R.string.country_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val isKorea = selectedId == R.id.koreaRadioButton //default value nya
        val isJepang = selectedId == R.id.jepangRadioButton //default value nya
        val isTaiwan = selectedId == R.id.taiwanRadioButton //default value nya

    }

    private fun getData(): List<Member> {
        return listOf(
            Member("Nayeon", "163 Cm", "22 September 1995", R.drawable.nayeon),
            Member("Jeongyeon", "167 Cm", "01 November 1996", R.drawable.jeongyeon),
            Member("Momo", "163 Cm", "09 November 1996", R.drawable.momo),
            Member("Sana", "164 Cm", "29 Desember 1996", R.drawable.sana),
            Member("Jihyo", "160 Cm", "01 Februari 1997", R.drawable.jihyo),
            Member("Mina", "163 Cm", "24 Maret 1997", R.drawable.mina),
            Member("Dahyun", "159 Cm", "28 Mei 1998", R.drawable.dahyun),
            Member("Chaeyoung", "159 Cm", "24 April 1999", R.drawable.chaeyoung),
            Member("Tzuyu", "172 Cm", "14 Juni 1999", R.drawable.tzuyu)
        )
    }
}