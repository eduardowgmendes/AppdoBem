package br.com.goodfeel.app.appdobem.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Author;
import de.hdodenhof.circleimageview.CircleImageView;

public class AuthorListAdapter extends BaseAdapter {

    private Context context;
    private List<Author> authors;

    public AuthorListAdapter(Context context, List<Author> authors) {
        this.context = context;
        this.authors = authors;
    }

    @Override
    public int getCount() {
        return authors.size();
    }

    @Override
    public Object getItem(int position) {
        return authors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = LayoutInflater.from(context).inflate(R.layout.author_item, parent, false);

        TextView authorName = item.findViewById(R.id.author_item_name);
        authorName.setText(authors.get(position).toString());

        CircleImageView authorProfilePicture = item.findViewById(R.id.author_item_profile_image);
        Picasso.get().load(authors.get(position).getPicture()).fit().centerCrop().into(authorProfilePicture);

        return item;
    }
}
