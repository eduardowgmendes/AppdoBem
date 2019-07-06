package br.com.goodfeel.app.appdobem.ui.adapter.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Author;
import br.com.goodfeel.app.appdobem.ui.adapter.interfaces.OnItemClickListener;
import de.hdodenhof.circleimageview.CircleImageView;

public class AuthorRecyclerAdapter extends RecyclerView.Adapter<AuthorRecyclerAdapter.AuthorListViewHolder> {

    private Context context;
    private List<Author> authors;
    private OnItemClickListener onItemClickListener;

    public AuthorRecyclerAdapter(Context context, List<Author> authors) {
        this.context = context;
        this.authors = authors;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public AuthorListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.author_item, viewGroup, false);
        return new AuthorListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorListViewHolder authorListViewHolder, int i) {
        authorListViewHolder.bind(authors.get(i));
    }

    @Override
    public int getItemCount() {
        return authors.size();
    }

    public class AuthorListViewHolder extends RecyclerView.ViewHolder {

        private TextView authorName;
        private CircleImageView authorPicture;

        public AuthorListViewHolder(@NonNull View itemView) {
            super(itemView);

            authorName = itemView.findViewById(R.id.author_item_name);
            authorPicture = itemView.findViewById(R.id.author_item_profile_image);
            if (onItemClickListener != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(getAdapterPosition());
                    }
                });
            }
        }

        public void bind(Author author) {
            authorName.setText(author.getCompleteName());
            Picasso.get().load(author.getPicture()).placeholder(R.drawable.ic_account_circle_96dp).fit().centerCrop().into(authorPicture);
        }
    }
}
