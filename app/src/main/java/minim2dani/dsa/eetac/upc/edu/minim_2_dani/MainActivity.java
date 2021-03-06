package minim2dani.dsa.eetac.upc.edu.minim_2_dani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        API.getInstance().api.getBooks().enqueue(new Callback<List<Book>>() {

            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()){
                    final List<Book> bookList = response.body();
                    ListView lv = (ListView) findViewById(R.id.book_list);
                    lv.setClickable(true);
                    BookArrayAdapter bk = new BookArrayAdapter(getApplicationContext(), bookList);
                    lv.setAdapter(bk);

                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position,long id)
                        {
                            //Object o = listView.getItemAtPosition(position);
                            Book b = bookList.get(position);

                            Intent i = new Intent(getApplicationContext(), Details_Activity.class);
                            i.putExtra("id", b.get_id());
                            startActivity(i);


                        }
                    });

                }
                else {
                    Toast.makeText(getApplicationContext(), "No trobat", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No connection", Toast.LENGTH_LONG).show();
            }
        });


    }
}
