package com.example.ytrebuild.Response;

import com.example.ytrebuild.Model.ContentDetails;
import com.example.ytrebuild.Model.Snippet;
import com.example.ytrebuild.Model.Statistics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YTVideoResponse {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("snippet")
    @Expose
    private Snippet snippet;
    @SerializedName("contentDetails")
    @Expose
    private ContentDetails contentDetails;
    @SerializedName("statistics")
    @Expose
    private Statistics statistics;

    /**
     * No args constructor for use in serialization
     *
     */

    /**
     *
     * @param snippet
     * @param kind
     * @param etag
     * @param id
     * @param contentDetails
     * @param statistics
     */
    public YTVideoResponse(String kind, String etag, String id, Snippet snippet, ContentDetails contentDetails, Statistics statistics) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.id = id;
        this.snippet = snippet;
        this.contentDetails = contentDetails;
        this.statistics = statistics;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }


}
