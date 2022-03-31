package org.d3if2090.iniaplikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        if (selectedId == -1) {
            Toast.makeText(this, R.string.country_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val isKorea = selectedId == R.id.koreaRadioButton //default value nya
        val isJepang = selectedId == R.id.jepangRadioButton
        val isTaiwan = selectedId == R.id.taiwanRadioButton
        val kategori = getKategori(isKorea,isJepang,isTaiwan)
//        Log.d("kacau", "$kategori ")

        binding.tvHasil.text = kategori
    }

    private fun getKategori(isKorea: Boolean, isJepang: Boolean, isTaiwan: Boolean): String {
        var stringRes = ""

        when{
            isKorea -> stringRes =  resources.getString(R.string.member_korea)
            isJepang -> stringRes =  resources.getString(R.string.member_jepang)
            isTaiwan -> stringRes =  resources.getString(R.string.member_taiwan)
        }
        return stringRes
    }


    private fun getData(): List<Member> {
        return listOf(
            Member("NAYEON", "163 cm", "22 September 1995", R.drawable.nayeon),
            Member("JEONGYEON", "167 cm", "01 November 1996", R.drawable.jeongyeon),
            Member("MOMO", "163 cm", "09 November 1996", R.drawable.momo),
            Member("SANA", "164 cm", "29 Desember 1996", R.drawable.sana),
            Member("JIHYO", "160 cm", "01 Februari 1997", R.drawable.jihyo),
            Member("MINA", "163 cm", "24 Maret 1997", R.drawable.mina),
            Member("DAHYUN", "159 cm", "28 Mei 1998", R.drawable.dahyun),
            Member("CHAEYOUNG", "159 cm", "24 April 1999", R.drawable.chaeyoung),
            Member("TZUYU", "172 cm", "14 Juni 1999", R.drawable.tzuyu)
        )
    }
}