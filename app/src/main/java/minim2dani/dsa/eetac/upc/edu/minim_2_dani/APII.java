package minim2dani.dsa.eetac.upc.edu.minim_2_dani;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Dani on 30/5/18.
 */

public interface APII {

    @GET("/books")
    Call<List<Book>> getBooks();

}
