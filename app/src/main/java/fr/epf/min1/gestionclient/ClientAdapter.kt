package fr.epf.min1.gestionclient

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epf.min1.gestionclient.model.Client
import fr.epf.min1.gestionclient.model.Gender

class ClientAdapter(val clients : List<Client>) : RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {

    // équivalent à faire un constructeur avec super(view) et this.view = view
    class ClientViewHolder(val view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val clientView = inflater.inflate(R.layout.adapter_client, parent, false)
        return ClientViewHolder(clientView)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = clients[position]

        holder.view.setOnClickListener {
            val context = it.context
            val intent = Intent(context, DetailsClientActivity::class.java)
            intent.putExtra("client_id", position)
            context.startActivity(intent)
        }

        val clientTextView = holder.view.findViewById<TextView>(R.id.adapter_client_textview)

        clientTextView.text = client.name

        val clientImageView = holder.view.findViewById<ImageView>(R.id.adapter_client_imageview)

        clientImageView.setClient(client)

    }

    override fun getItemCount() = clients.size

}

fun Client.nomComplet(): String {
    return "${this.firstName} ${this.lastName}"
}

val Client.name
    get() = "${this.firstName} ${this.lastName}"