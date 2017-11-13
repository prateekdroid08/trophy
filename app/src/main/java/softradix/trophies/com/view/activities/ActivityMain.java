package softradix.trophies.com.view.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import softradix.trophies.com.R;
import softradix.trophies.com.view.fragments.FragmentTrophies;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        FragmentTrophies fragmentMain = FragmentTrophies.newInstance();
        FragmentTransaction fts = this.getSupportFragmentManager().beginTransaction();
        fts.add(R.id.fragmentHolder, fragmentMain);
        fts.addToBackStack(fragmentMain.getClass().getSimpleName());
        fts.commit();

    }

    @Override
    public void onBackPressed() {
        FragmentTransaction fts = this.getSupportFragmentManager().beginTransaction();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStackImmediate();
            fts.commit();
        } else {
            finish();
        }

    }
}