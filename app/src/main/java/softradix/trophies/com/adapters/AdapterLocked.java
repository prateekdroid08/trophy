package softradix.trophies.com.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import softradix.trophies.com.R;
import softradix.trophies.com.interfaces.InterfaceTrophy;

/**
 * Created by softradix on 13/11/17.
 */

public class AdapterLocked extends RecyclerView.Adapter<AdapterLocked.RecyclerViewHolder> {

    Context context;
    LayoutInflater inflater;

    public AdapterLocked(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public AdapterLocked.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.adapter_locked, parent, false);
        AdapterLocked.RecyclerViewHolder viewHolder = new AdapterLocked.RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterLocked.RecyclerViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}