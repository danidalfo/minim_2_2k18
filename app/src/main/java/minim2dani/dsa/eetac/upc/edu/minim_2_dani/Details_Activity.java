package minim2dani.dsa.eetac.upc.edu.minim_2_dani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Details_Activity extends AppCompatActivity {

    public static String book_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);

        Intent i = this.getIntent();
        book_id = i.getStringExtra("id");

        API.getInstance().api.getDetails(book_id).enqueue(new Callback<Book_detail>() {
            @Override
            public void onResponse(Call<Book_detail> call, Response<Book_detail> response) {
                if (response.isSuccessful()){
                    Book_detail book_detail = response.body();


                    //Picasso.with(this).load(book_detail.getImage()).into((ImageView) findViewById(R.id.image));

                    TextView author_tv = (TextView) findViewById(R.id.author);
                    author_tv.setText((book_detail.getAuthor()));
                    TextView title_tv = (TextView) findViewById(R.id.title);
                    title_tv.setText((book_detail.getTitle()));
                    TextView description_tv = (TextView) findViewById(R.id.description);
                    description_tv.setText((book_detail.getDescription()));
                    TextView publisher_tv = (TextView) findViewById(R.id.publisher);
                    publisher_tv.setText((book_detail.getPublisher()));
                    TextView date_tv = (TextView) findViewById(R.id.date);
                    date_tv.setText((book_detail.getDate()));
                    TextView rating_tv = (TextView) findViewById(R.id.rating);
                    rating_tv.setText((book_detail.getRating()));
                    TextView comments_tv = (TextView) findViewById(R.id.comments);
                    comments_tv.setText((book_detail.getComments()));


                }
            }

            @Override
            public void onFailure(Call<Book_detail> call, Throwable t) {

            }
        });
    }
}
