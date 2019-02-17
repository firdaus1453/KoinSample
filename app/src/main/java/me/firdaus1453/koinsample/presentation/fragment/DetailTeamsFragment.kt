package me.firdaus1453.koinsample.presentation.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_teams.*
import kotlinx.android.synthetic.main.fragment_detail_teams.view.*
import me.firdaus1453.koin.data.responses.Team

import me.firdaus1453.koinsample.R
import me.firdaus1453.koinsample.external.constant.Constant
import me.firdaus1453.koinsample.external.loadFromUrl

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DetailTeamsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if (bundle != null){
            val teamData = bundle.getParcelable<Team>(Constant.BUNDLE_KEY)
            // TODO Handle teamData into view
            tvTeamName.text = teamData?.strTeam
            tvTeamDesc.text = teamData?.strDescriptionEN

            // TODO Untuk menampilkan gambar lebih singkat
            imgTeam.loadFromUrl(teamData?.strTeamBadge)
//            Picasso.get()
//                .load(teamData?.strTeamBadge)
//                .fit()
//                .centerCrop()
//                .into(imgTeam)
        }
    }
}
