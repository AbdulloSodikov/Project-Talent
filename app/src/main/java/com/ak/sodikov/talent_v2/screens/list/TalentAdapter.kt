package com.ak.sodikov.talent_v2.screens.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ak.sodikov.talent_v2.R
import com.ak.sodikov.talent_v2.model.entites.Talent

class TalentAdapter : RecyclerView.Adapter<TalentAdapter.TalentHolder>() {
private var mListTalent = emptyList<Talent>()

    class TalentHolder (view: View) : RecyclerView.ViewHolder (view) {
        val fullName:TextView = view.findViewById(R.id.tv_person_full_name)
        val profession:TextView = view.findViewById(R.id.tv_person_of_profession)
        val education:TextView = view.findViewById(R.id.tv_education)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TalentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.talent_item, parent, false)
        return TalentHolder(view)
    }

    override fun onBindViewHolder(holder: TalentHolder, position: Int) {
        val talent = mListTalent[position]

        holder.fullName.text =  "${talent.talentSurname.toString()} ${talent.talentName.toString()}"
        holder.profession.text = talent.professionName.toString()
        holder.education.text = "Образование: ${mListTalent[position].info.toString()}"
    }

    override fun getItemCount(): Int = mListTalent.size

fun setList (list: List <Talent>) {
    mListTalent = list
    notifyDataSetChanged()
}
}