package com.example.ytrebuild.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statistics {

    @SerializedName("viewCount")
    @Expose
    private String viewCount;
    @SerializedName("likeCount")
    @Expose
    private String likeCount;
    @SerializedName("favoriteCount")
    @Expose
    private String favoriteCount;
    @SerializedName("commentCount")
    @Expose
    private String commentCount;

    /**
     * No args constructor for use in serialization
     *
     */
    public Statistics() {
    }

    /**
     *
     * @param likeCount
     * @param viewCount
     * @param favoriteCount
     * @param commentCount
     */
    public Statistics(String viewCount, String likeCount, String favoriteCount, String commentCount) {
        super();
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.favoriteCount = favoriteCount;
        this.commentCount = commentCount;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(String favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

}
