package dev.ogabek.java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.activity.MainActivity;
import dev.ogabek.java.model.InfoPage;

public class InfoPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<InfoPage> infoPages;

    public InfoPageAdapter(Context context, List<InfoPage> infoPages) {
        this.context = context;
        this.infoPages = infoPages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new InfoPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        InfoPage infoPage = infoPages.get(position);

        if (holder instanceof InfoPageViewHolder) {
            ((InfoPageViewHolder) holder).animationView.setAnimation(infoPage.getAnimation());
            ((InfoPageViewHolder) holder).title.setText(infoPage.getTitle());
            ((InfoPageViewHolder) holder).text.setText(infoPage.getText());
        }
    }

    @Override
    public int getItemCount() {
        return infoPages.size();
    }

    private static class InfoPageViewHolder extends RecyclerView.ViewHolder {

        LottieAnimationView animationView;
        TextView title, text;

        public InfoPageViewHolder(View view) {
            super(view);
            animationView = view.findViewById(R.id.item_lottie_animation);
            title = view.findViewById(R.id.item_title);
            text = view.findViewById(R.id.item_text);
        }
    }
}
