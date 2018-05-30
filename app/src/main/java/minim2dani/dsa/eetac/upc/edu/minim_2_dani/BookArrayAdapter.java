package minim2dani.dsa.eetac.upc.edu.minim_2_dani;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Dani on 30/5/18.
 */

public class BookArrayAdapter extends ArrayAdapter<Book> {

    public BookArrayAdapter(@NonNull Context context, List<Book> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book b = getItem(position);
        if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.books_layout, parent, false);
            }
            Picasso.with(super.getContext()).load(b.getImage()).into((ImageView) convertView.findViewById(R.id.avatar_image));
            TextView bookname = (TextView) convertView.findViewById(R.id.bookname_txt);
            TextView autorname = (TextView) convertView.findViewById(R.id.autorname_txt);
            bookname.setText(b.getTitle());
            autorname.setText(b.getAuthor());
            return convertView;
        }


    }