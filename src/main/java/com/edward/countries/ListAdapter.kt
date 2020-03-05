package com.edward.countries

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class ListAdapter(private val list: List<MainFragment.Country>)
    : RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CountryViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country: MainFragment.Country = list[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int = list.size

}

class CountryViewHolder(inflater: LayoutInflater, parent: ViewGroup)
    : RecyclerView.ViewHolder(inflater.inflate(R.layout.country_item, parent, false)) {
    private var mCountryView: TextView? = null
    private var mCapitalView: TextView? = null
    private var mRegionView: TextView? = null

    init {
        mCountryView = itemView.findViewById(R.id.country_name)
        mCapitalView = itemView.findViewById(R.id.country_capital)
        mRegionView = itemView.findViewById(R.id.country_region)
    }

    fun bind(country: MainFragment.Country) {
        mCountryView?.text = country.name
        mCapitalView?.text = country.capital
        mRegionView?.text = country.region
    }

}