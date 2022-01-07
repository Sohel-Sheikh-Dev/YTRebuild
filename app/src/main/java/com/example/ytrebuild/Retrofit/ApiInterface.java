package com.example.ytrebuild.Retrofit;

import com.example.ytrebuild.Parent.ParentSearchResponse;
import com.example.ytrebuild.Parent.ParentVideoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //videos?part=snippet&chart=mostPopular&order=date&maxResults=1000&regionCode=IN&key=AIzaSyB4Gt0F2v2Zt9wLBFIU9nxvRIzR7L9OZAs
    //videos?part=snippet&chart=mostPopular&regionCode=IN&videoCategoryId=20&key=AIzaSyB4Gt0F2v2Zt9wLBFIU9nxvRIzR7L9OZAs
    @GET("videos?part=snippet%2CcontentDetails%2Cstatistics&chart=mostPopular&order=date&maxResults=1000&regionCode=IN&key=AIzaSyB4Gt0F2v2Zt9wLBFIU9nxvRIzR7L9OZAs")
    Call<ParentVideoResponse> getVideoDetails();

    @GET("search?key=AIzaSyB4Gt0F2v2Zt9wLBFIU9nxvRIzR7L9OZAs&part=snippet,id&order=date&maxResults=1000&regionCode=IN")
    Call<ParentSearchResponse> getSearchResponse();

    @GET("search?part=snippet&regionCode=IN&maxResults=50&&pageToken=CDIQAA&q=shorts&key=AIzaSyB4Gt0F2v2Zt9wLBFIU9nxvRIzR7L9OZAs")
    Call<ParentSearchResponse> getShortsSearchResponse();

    @GET("videos?part=snippet&chart=mostPopular&order=views&maxResults=10&regionCode=IN&key=AIzaSyB4Gt0F2v2Zt9wLBFIU9nxvRIzR7L9OZAs")
    Call<ParentVideoResponse> getPopVids(@Query("videoCategoryId") int id);

}
