package com.ak.sodikov.talent_v2.ui.talent_list_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ak.sodikov.talent_v2.R
import com.ak.sodikov.talent_v2.model.entites.Talent
import com.bumptech.glide.Glide

class TalentAdapter : RecyclerView.Adapter<TalentAdapter.TalentHolder>() {

    private var mListTalent = emptyList<Talent>()
    var onItemClick : ((talent: Talent ) -> Unit)? = null

   inner class TalentHolder (view: View) : RecyclerView.ViewHolder (view) {
        val fullName:TextView = view.findViewById(R.id.tv_person_full_name)
        val profession:TextView = view.findViewById(R.id.tv_person_of_profession)
        val workState:TextView = view.findViewById(R.id.tv_workState)
        val city:TextView = view.findViewById(R.id.tv_city)
        val avatar:ImageView = view.findViewById(R.id.talentAvatar)

        init {
            view.setOnClickListener {
                onItemClick?.invoke(mListTalent[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TalentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.talent_item, parent, false)
        return TalentHolder(view)
    }

    override fun onBindViewHolder(holder: TalentHolder, position: Int) {
        val talent = mListTalent[position]
        holder.fullName.text =  "${talent.talentSurname} ${talent.talentName}"
        holder.profession.text = talent.professionNameInTalent
        holder.workState.text = talent.workState
        holder.city.text = talent.cityNameInTalent

        if (talent.urlAvatar != null) {
            Glide.with(holder.avatar.context)
                .load(talent.urlAvatar)
                .into(holder.avatar)
        }


}


override fun getItemCount(): Int = mListTalent.size
fun setList (list: List <Talent>) {
    mListTalent = list
    notifyDataSetChanged()
  }
}
