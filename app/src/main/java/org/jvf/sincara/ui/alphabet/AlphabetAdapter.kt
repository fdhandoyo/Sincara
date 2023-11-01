package org.jvf.sincara.ui.alphabet

import AlphabetApi
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.jvf.sincara.R
import org.jvf.sincara.databinding.ListAlphabetBinding
import org.jvf.sincara.model.HasilAlphabet

class AlphabetAdapter : RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {

    private val data = mutableListOf<HasilAlphabet>()

    fun updateData(newData: List<HasilAlphabet>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListAlphabetBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(info: HasilAlphabet) = with(binding) {
            textAlphabet.text = info.deskripsi
            Glide.with(imageView.context)
                .load(AlphabetApi.getInfoUrl(info.imageId))
                .error(R.drawable.baseline_broken_image_24)
                .into(imageView)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, info.deskripsi)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListAlphabetBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}