import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.jvf.sincara.R
import org.jvf.sincara.databinding.ListKomunikasiBinding
import org.jvf.sincara.model.HasilKomunikasi

class KomunikasiAdapter : RecyclerView.Adapter<KomunikasiAdapter.ViewHolder>() {

    private val data = mutableListOf<HasilKomunikasi>()

    fun updateData(newData: List<HasilKomunikasi>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListKomunikasiBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(info: HasilKomunikasi) = with(binding) {
            textKalimat.text = info.deskripsi
            imageView.load(info.imageId) {
                error(R.drawable.baseline_broken_image_24)
            }

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, info.deskripsi)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListKomunikasiBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = data[position]
        holder.bind(info)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}