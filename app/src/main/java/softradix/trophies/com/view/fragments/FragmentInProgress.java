package softradix.trophies.com.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import softradix.trophies.com.R;
import softradix.trophies.com.adapters.AdapterTrophies;
import softradix.trophies.com.interfaces.InterfaceTrophy;

/**
 * Created by softradix on 13/11/17.
 */

public class FragmentInProgress extends Fragment implements InterfaceTrophy {

    public static FragmentInProgress newInstance() {
        FragmentInProgress fragmentInProgress = new FragmentInProgress();
        return fragmentInProgress;
    }

    @Bind(R.id.trophie_list)
    RecyclerView trophiesList;
    AdapterTrophies adapterTrophies;
    @Bind(R.id.iv_back_btn)
    ImageView ivBackBtn;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trophies, container, false);
        ButterKnife.bind(this, view);

        ivBackBtn.setVisibility(View.VISIBLE);
        tvTitle.setText(R.string.in_progress);

        adapterTrophies = new AdapterTrophies(getActivity(), "In Progress", this);
        trophiesList.setItemAnimator(new DefaultItemAnimator());
        trophiesList.setAdapter(adapterTrophies);
        trophiesList.setHasFixedSize(true);
        //Layout manager for Recycler view
        trophiesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @OnClick(R.id.iv_back_btn)
    void onBackPressedClick() {
        FragmentTransaction fts = getActivity().getSupportFragmentManager().beginTransaction();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStackImmediate();
            fts.commit();
        } else {
            getActivity().finish();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onTrophyClick() {
        FragmentLocked fragmentLocked = FragmentLocked.newInstance();
        FragmentTransaction fts = getActivity().getSupportFragmentManager().beginTransaction();
        fts.add(R.id.fragmentHolder, fragmentLocked);
        fts.addToBackStack(fragmentLocked.getClass().getSimpleName());
        fts.commit();
    }
}