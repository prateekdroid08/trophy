package softradix.trophies.com.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import softradix.trophies.com.R;
import softradix.trophies.com.adapters.AdapterTrophies;
import softradix.trophies.com.interfaces.InterfaceTrophy;

/**
 * Created by softradix on 13/11/17.
 */

public class FragmentTrophies extends Fragment implements InterfaceTrophy {

    public static FragmentTrophies newInstance() {
        FragmentTrophies fragmentTrophies = new FragmentTrophies();
        return fragmentTrophies;
    }

    @Bind(R.id.trophie_list)
    RecyclerView trophiesList;
    AdapterTrophies adapterTrophies;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trophies, container, false);
        ButterKnife.bind(this, view);

        adapterTrophies = new AdapterTrophies(getActivity(), "Trophy", this);
        trophiesList.setItemAnimator(new DefaultItemAnimator());
        trophiesList.setAdapter(adapterTrophies);
        trophiesList.setHasFixedSize(true);
        //Layout manager for Recycler view
        trophiesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onTrophyClick() {
        FragmentInProgress fragmentInProgress = FragmentInProgress.newInstance();
        FragmentTransaction fts = getActivity().getSupportFragmentManager().beginTransaction();
        fts.add(R.id.fragmentHolder, fragmentInProgress);
        fts.addToBackStack(fragmentInProgress.getClass().getSimpleName());
        fts.commit();
    }
}
