package com.example.ytrebuild.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ytrebuild.Adapter.SearchListAdapter;
import com.example.ytrebuild.Adapter.ShortsAdapter;
import com.example.ytrebuild.Adapter.VideoListAdapter;
import com.example.ytrebuild.Parent.ParentSearchResponse;
import com.example.ytrebuild.Parent.ParentVideoResponse;
import com.example.ytrebuild.R;
import com.example.ytrebuild.Response.YTSearchResponse;
import com.example.ytrebuild.Response.YTVideoResponse;
import com.example.ytrebuild.Retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<YTVideoResponse> ytRes = new ArrayList<>();
    List<YTVideoResponse> ytResFirst = new ArrayList<>();
    List<YTSearchResponse> ytSearchResponses = new ArrayList<>();
    List<YTSearchResponse> yTShortSearchResponse = new ArrayList<>();

    RecyclerView videoIdList;
    VideoListAdapter videoListAdapter;

    RecyclerView searchList;
    SearchListAdapter searchListAdapter;

    RecyclerView shortsList;
    ShortsAdapter shortsListAdapter;

    RecyclerView singleVideoIdList;
    VideoListAdapter singleListAdapter;

    LinearLayoutManager linearLayoutManagerVid;
    LinearLayoutManager linearLayoutManagerShorts;
    LinearLayoutManager singleLinearLayoutManager;
    LinearLayoutManager linearLayoutManagerSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        int[] categories = {1, 2, 10, 15, 17, 19, 20, 22, 23, 24, 25, 26, 27, 28, 29};

        getVideoIdYT();
        getShortsSearchResp();
//        getSearchResp();
//        for (int i : categories) {
//            getPopVidYT(10);
//        }
        getFirstVidYT(10);
        init();

    }



    private void init(){

        //Video List Result
        videoIdList = findViewById(R.id.videoIdList);
        videoListAdapter = new VideoListAdapter(getApplicationContext(), ytRes);
        linearLayoutManagerVid = new LinearLayoutManager(getApplicationContext());
        linearLayoutManagerVid.setOrientation(RecyclerView.VERTICAL);
        videoIdList.setLayoutManager(linearLayoutManagerVid);
        videoIdList.setAdapter(videoListAdapter);


        //Single Vid Result
        singleVideoIdList = findViewById(R.id.firstSingleVid);
        singleListAdapter = new VideoListAdapter(getApplicationContext(), ytResFirst);
        singleLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        singleLinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        singleVideoIdList.setLayoutManager(singleLinearLayoutManager);
        singleVideoIdList.setAdapter(singleListAdapter);


        //Shorts Result
        shortsList = findViewById(R.id.shortsList);
        shortsListAdapter = new ShortsAdapter(getApplicationContext(),yTShortSearchResponse);
        linearLayoutManagerShorts = new LinearLayoutManager(getApplicationContext());
        linearLayoutManagerShorts.setOrientation(RecyclerView.HORIZONTAL);
        shortsList.setLayoutManager(linearLayoutManagerShorts);
        shortsList.setAdapter(shortsListAdapter);
/*
        //Search Result
        searchList = findViewById(R.id.videoIdList);
        searchListAdapter = new SearchListAdapter(getApplicationContext(),ytSearchResponses);
        linearLayoutManagerSearch = new LinearLayoutManager(getApplicationContext());
        linearLayoutManagerSearch.setOrientation(RecyclerView.VERTICAL);
        searchList.setLayoutManager(linearLayoutManagerSearch);
        searchList.setAdapter(searchListAdapter);
*/
    }


    private void getVideoIdYT() {
        Call<ParentVideoResponse> data = RetrofitInstance.getRetrofitInstance().getVideoDetails();

        data.enqueue(new Callback<ParentVideoResponse>() {
            @Override
            public void onResponse(Call<ParentVideoResponse> call, Response<ParentVideoResponse> response) {
                if (response.isSuccessful()) {

//                    ytRes.addAll(response.body().getItems());
                    ytRes.addAll(response.body().getItems());
//                    Collections.shuffle(ytRes);
                    videoListAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ParentVideoResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No Response", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void getPopVidYT(int id) {
        Call<ParentVideoResponse> data = RetrofitInstance.getRetrofitInstance().getPopVids(id);

        data.enqueue(new Callback<ParentVideoResponse>() {
            @Override
            public void onResponse(Call<ParentVideoResponse> call, Response<ParentVideoResponse> response) {
                if (response.isSuccessful() && response != null) {

                    ytRes.addAll(response.body().getItems());
                    Collections.shuffle(ytRes);
                    videoListAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ParentVideoResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No Response", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void getFirstVidYT(int id) {
        Call<ParentVideoResponse> data = RetrofitInstance.getRetrofitInstance().getPopVids(id);

        data.enqueue(new Callback<ParentVideoResponse>() {
            @Override
            public void onResponse(Call<ParentVideoResponse> call, Response<ParentVideoResponse> response) {
                if (response.isSuccessful() && response != null) {

                    ytResFirst.add(response.body().getItems().get(0));
                    singleListAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ParentVideoResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No Response", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getSearchResp() {
        Call<ParentSearchResponse> data = RetrofitInstance.getRetrofitInstance().getSearchResponse();

        data.enqueue(new Callback<ParentSearchResponse>() {
            @Override
            public void onResponse(Call<ParentSearchResponse> call, Response<ParentSearchResponse> response) {
                if (response.isSuccessful()) {

                    ytSearchResponses.addAll(response.body().getItems());
//                    Collections.shuffle(ytRes);
                    Log.d("TAGT", "onResponse: "+response.body().getPageInfo().getTotalResults());
//                    Toast.makeText(getApplicationContext(), ""+response.body().getItems().get(0).getId().getVideoId(), Toast.LENGTH_SHORT).show();
                    searchListAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ParentSearchResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No Response", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void getShortsSearchResp() {
        Call<ParentSearchResponse> data = RetrofitInstance.getRetrofitInstance().getShortsSearchResponse();

        data.enqueue(new Callback<ParentSearchResponse>() {
            @Override
            public void onResponse(Call<ParentSearchResponse> call, Response<ParentSearchResponse> response) {
                if (response.isSuccessful()) {

                    yTShortSearchResponse.addAll(response.body().getItems());
//                    Collections.shuffle(ytRes);
                    Log.d("TAG", "Shorts "+response.body().getItems().get(0).getId().getVideoId());
//                    Toast.makeText(getApplicationContext(), ""+response.body().getItems().get(0).getId().getVideoId(), Toast.LENGTH_SHORT).show();
                    shortsListAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ParentSearchResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No Response", Toast.LENGTH_SHORT).show();
            }
        });

    }



}