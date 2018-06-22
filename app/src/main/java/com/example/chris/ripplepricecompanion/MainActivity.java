package com.example.chris.ripplepricecompanion;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBar;
import java.util.List;
import com.google.android.gms.ads.MobileAds;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-5748311190968217~7216604100");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        final TextView ripple = (TextView)findViewById(R.id.ripple);
        final TextView btc = (TextView)findViewById(R.id.btc);
        final TextView rank = (TextView)findViewById(R.id.rank);
        final TextView oneHR = (TextView)findViewById(R.id.oneHR);
        final TextView oneDay = (TextView)findViewById(R.id.oneDay);
        final TextView oneWeek = (TextView)findViewById(R.id.oneWeek);
        final TextView marketCap = (TextView)findViewById(R.id.marketCap);
        final TextView totalSupply = (TextView)findViewById(R.id.totalSupply);
        final TextView availSupply = (TextView)findViewById(R.id.availSupply);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<contents>> call = api.getContents();

        call.enqueue(new Callback<List<contents>>() {
            @Override
            public void onResponse(Call<List<contents>> call, Response<List<contents>> response) {

            List<contents> contents = response.body();

            for(contents h : contents){
                Log.d("id",h.getId());
                Log.d("rank",h.getRank());
                Log.d("price_usd",h.getPrice_usd());
                Log.d("price_btc",h.getPrice_btc());
                Log.d("market_cap_usd",h.getMarket_cap_usd());
                Log.d("total_supply",h.getTotal_supply());
                Log.d("available_supply",h.getAvailable_supply());
                Log.d("max_supply",h.getMax_supply());
                Log.d("percent_change_1h",h.getPercent_change_1h());
                Log.d("percent_change_24h",h.getPercent_change_24h());
                Log.d("percent_change_7d",h.getPercent_change_7d());

                String usd_price = h.getPrice_usd();
                ripple.setText("Price: " + "$" + usd_price.substring(0,4));
                btc.setText("Price BTC: "+ h.getPrice_btc());
                rank.setText("Rank: " + h.getRank());

                char onehour= h.getPercent_change_1h().charAt(0);
                if(onehour == '-'){
                    oneHR.setTextColor(Color.parseColor("#ff0000"));
                }else{
                    oneHR.setTextColor(Color.parseColor("#39FF14"));
                }
                oneHR.setText("%"+h.getPercent_change_1h());

                char oneDAY = h.getPercent_change_24h().charAt(0);
                if(oneDAY == '-'){
                    oneDay.setTextColor(Color.parseColor("#ff0000"));
                }else{
                    oneDay.setTextColor(Color.parseColor("#39FF14"));
                }
                oneDay.setText("%"+h.getPercent_change_24h());

                char oneWeek2 = h.getPercent_change_7d().charAt(0);
                if(oneWeek2 == '-'){
                    oneWeek.setTextColor(Color.parseColor("#ff0000"));
                }else{
                    oneWeek.setTextColor(Color.parseColor("#39FF14"));
                }
                oneWeek.setText("%"+h.getPercent_change_7d());


                StringBuilder mrktCap = new StringBuilder(h.getMarket_cap_usd());
                mrktCap.setLength(mrktCap.length()-2);
                int x = 0;
                for(int i = mrktCap.length(); i >= 0; i--){
                    if(x%3 ==0 && x!=0) {
                        mrktCap.insert(i,",");
                    }

                    x++;
                }


                StringBuilder totSupply = new StringBuilder(h.getTotal_supply());
                totSupply.setLength(totSupply.length()-2);
                int y = 0;
                for(int i = totSupply.length(); i >= 0; i--){
                    if(y%3 ==0 && y!=0) {
                        totSupply.insert(i,",");
                    }

                    y++;
                }

                StringBuilder avaSupply = new StringBuilder(h.getAvailable_supply());
                avaSupply.setLength(avaSupply.length()-2);
                int w = 0;
                for(int i = avaSupply.length(); i >= 0; i--){
                    if(w%3 ==0 && w!=0) {
                        avaSupply.insert(i,",");
                    }

                    w++;
                }



                marketCap.setText("Market Cap: $" + mrktCap);

                totalSupply.setText("Total Supply: " + totSupply);

                availSupply.setText("Available Supply: " + avaSupply);



            }

            }

            @Override
            public void onFailure(Call<List<contents>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
