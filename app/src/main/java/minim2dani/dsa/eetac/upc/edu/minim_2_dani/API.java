package minim2dani.dsa.eetac.upc.edu.minim_2_dani;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Dani on 30/5/18.
 */

public class API {

    private static API instance;

    private static final String baseUrl = "http://api.dsamola.tk/";
    public static APII api;

    private API(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(APII.class);
    };

    public static API getInstance(){
        if(instance==null)
            return new API();
        return instance;
    }

}
