package me.firdaus1453.koinsample.presentation.activity

import me.firdaus1453.koin.data.responses.Team

/**
 * Created by firdaus1453 on 2/17/2019.
 */
open class MainContract {

    interface View{
        fun setupUIListener()
        fun showTeamData(teamData: Team?)
        fun showError(message: String)
    }

    interface UserActionListener{
        fun setupView(view: View)
        fun searchTeams(searchText: String?)
        fun fetchTeamsData(teamData: Team?)
    }
}