package org.d3if2090.iniaplikasi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.d3if2090.iniaplikasi.databinding.ListItemBinding

class MainAdapter(private val data: List<Member>) :
        RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(member: Member) = with(binding){
            tvNama.text = member.nama
            tvTinggi.text = member.tinggi
            tvTanggal.text = member.tanggalLahir
            imageView.setImageResource(member.imageResId)

            root.setOnClickListener{
                val message = root.context.getString(R.string.message, member.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater,parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}