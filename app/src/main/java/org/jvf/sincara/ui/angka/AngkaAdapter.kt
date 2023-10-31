package org.jvf.sincara.ui.angka

import AngkaApi
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.jvf.sincara.R
import org.jvf.sincara.databinding.ListAngkaBinding
import org.jvf.sincara.model.HasilAngka

class AngkaAdapter : RecyclerView.Adapter<AngkaAdapter.ViewHolder>() {

    private val data = mutableListOf<HasilAngka>()

    fun updateData(newData: List<HasilAngka>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListAngkaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(info: HasilAngka) = with(binding) {
            textAngka.text = info.deskripsi
            Glide.with(imageView.context)
                .load(AngkaApi.getInfoUrl(info.imageId))
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
        val binding = ListAngkaBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}