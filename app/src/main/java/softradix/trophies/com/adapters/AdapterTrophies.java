package softradix.trophies.com.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import softradix.trophies.com.R;
import softradix.trophies.com.interfaces.InterfaceTrophy;

/**
 * Created by softradix on 13/11/17.
 */

public class AdapterTrophies extends RecyclerView.Adapter<AdapterTrophies.RecyclerViewHolder> {

    Context context;
    LayoutInflater inflater;
    String screen;
    InterfaceTrophy interfaceTrophy;

    public AdapterTrophies(Context context, String screen, InterfaceTrophy interfaceTrophy) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.screen = screen;
        this.interfaceTrophy = interfaceTrophy;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.adapter_trophies, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {

        if (screen.equalsIgnoreCase(context.getString(R.string.trophy))) {
            holder.tvCommon.setText(R.string.text_common);
            holder.roundCornerProgressBar.setVisibility(View.GONE);
            holder.tvDate.setVisibility(View.VISIBLE);
        } else if (screen.equalsIgnoreCase(context.getString(R.string.in_progress))) {
            holder.tvCommon.setText(R.string.rare);
            holder.roundCornerProgressBar.setVisibility(View.VISIBLE);
            holder.tvDate.setVisibility(View.GONE);
        } else {

        }

        holder.mainLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (screen.equalsIgnoreCase(context.getString(R.string.trophy)))
                    interfaceTrophy.onTrophyClick();
                else if (screen.equalsIgnoreCase(context.getString(R.string.in_progress)))
                    interfaceTrophy.onTrophyClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_common)
        TextView tvCommon;
        @Bind(R.id.tv_date)
        TextView tvDate;
        @Bind(R.id.progress)
        RoundCornerProgressBar roundCornerProgressBar;
        @Bind(R.id.main_lay)
        LinearLayout mainLay;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}