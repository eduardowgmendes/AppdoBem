package br.com.goodfeel.app.appdobem.ui.adapter.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Author;
import br.com.goodfeel.app.appdobem.ui.adapter.interfaces.OnItemClickListener;
import br.com.goodfeel.app.appdobem.ui.adapter.interfaces.OnItemLongClickListener;

public class TopAuthorAdapter extends RecyclerView.Adapter<TopAuthorAdapter.AuthorViewHolder> {

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    private Context context;
    private List<Author> authors;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public TopAuthorAdapter(Context context, List<Author> authors) {
        this.context = context;
        this.authors = authors;
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.author_snap_item, viewGroup, false);
        return new AuthorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder authorViewHolder, int i) {
        authorViewHolder.bind(authors.get(i));
    }

    @Override
    public int getItemCount() {
        return authors.size();
    }

    public class AuthorViewHolder extends RecyclerView.ViewHolder {

        private ImageView authorPicture;
        private TextView authorName;

        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
            authorName = itemView.findViewById(R.id.author_name);
            authorPicture = itemView.findViewById(R.id.author_picture_profile);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(getAdapterPosition());
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onItemLongClickListener != null) {
                        onItemLongClickListener.onItemLongClick(getAdapterPosition());
                    }

                    return true;
                }
            });
        }

        public void bind(Author author) {
            authorName.setText(author.toString());
            Picasso.get().load(author.getPicture()).placeholder(R.drawable.ic_account_circle_96dp).fit().centerCrop().into(authorPicture);
        }
    }
}
