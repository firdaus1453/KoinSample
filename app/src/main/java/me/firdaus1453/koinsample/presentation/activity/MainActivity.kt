package me.firdaus1453.koinsample.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.firdaus1453.koin.data.responses.Team
import me.firdaus1453.koinsample.R
import me.firdaus1453.koinsample.domain.router.openFragment
import me.firdaus1453.koinsample.external.constant.Constant
import me.firdaus1453.koinsample.presentation.fragment.DetailTeamsFragment
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainContract.View {

    val presenter: MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setupView(this)
        setupUIListener()
    }

    override fun setupUIListener() {
        btnSearch.setOnClickListener {
            val searchText = etSearchTeam.text.toString()
            presenter.searchTeams(searchText)
        }
    }

    override fun showTeamData(teamData: Team?) {
        // Mengirim data ke fragment
        val bundle = Bundle()
        bundle.putParcelable(Constant.BUNDLE_KEY, teamData)

        // TODO menggunakan router agar bisa langsung memanggil fragment
        supportFragmentManager.openFragment(
            R.id.layoutSearchResult,
            DetailTeamsFragment(),
            bundle
        )

//        val fragment = DetailTeamsFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//
//        // Memasukkan data ke bundle
//        bundle.putParcelable(Constant.BUNDLE_KEY, teamData)
//        // Memasukkan bundle ke fragment dengan method arguments
//        fragment.arguments = bundle
//
//        transaction.replace(R.id.layoutSearchResult, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
    }

    override fun showError(message: String) {
        toast(message)
    }
}
