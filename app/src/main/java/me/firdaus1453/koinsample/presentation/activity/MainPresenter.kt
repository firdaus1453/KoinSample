package me.firdaus1453.koinsample.presentation.activity

import android.content.Context
import com.google.gson.Gson
import me.firdaus1453.koin.data.responses.FootballClubData
import me.firdaus1453.koin.data.responses.Team

/**
 * Created by firdaus1453 on 2/17/2019.
 */

class MainPresenter(val context: Context, val gson: Gson) : MainContract.UserActionListener {

    private var view: MainContract.View? = null

    override fun setupView(view: MainContract.View) {
        this.view = view
    }

    override fun searchTeams(searchText: String?) {
        if (!searchText.isNullOrEmpty()) {
            // Akses file
            try {

                val inputStream = context.assets.open("json/football_club.json")
                val inputString = inputStream.bufferedReader().use { it.readText() }
                val footballJson = gson.fromJson(inputString, FootballClubData::class.java)
                val footballData = footballJson.teams?.filter {
                    it?.strTeam?.toLowerCase()?.contains(searchText.toLowerCase()) == true
                }

                if (!footballData.isNullOrEmpty()){
                    fetchTeamsData(footballData.first())
                }else{
                    view?.showError("Data tidak ditemukan")
                }

            } catch (error: Exception) {
                view?.showError(error.message.toString())
            }
        } else {
            view?.showError("Silahkan isi nama team")
        }
    }

    override fun fetchTeamsData(teamData: Team?) {
        view?.showTeamData(teamData)
    }
}