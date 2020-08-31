package com.example.synrgy_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.synrgy_retrofit.pojo.GetPersonsResponse
import kotlinx.android.synthetic.main.person_item.view.*

class PersonAdapter (val listPerson: List<GetPersonsResponse.Result>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false))
    }

    override fun onBindViewHolder(holder: PersonAdapter.ViewHolder, position: Int) {
        holder.itemView.tvId.text = listPerson[position].iD.toString()
        holder.itemView.tvFirstName.text = listPerson[position].firstName
        holder.itemView.tvLastName.text = listPerson[position].lastName
        holder.itemView.tvUpdatedAt.text = listPerson[position].updatedAt
        holder.itemView.tvCreatedAt.text = listPerson[position].createdAt
        holder.itemView.tvDeletedAt.text = "${listPerson[position].deletedAt}"
    }

    override fun getItemCount(): Int {
        return listPerson.size
    }

}