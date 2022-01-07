package com.example.ytrebuild.Parent;

import com.example.ytrebuild.Response.PageInfo;
import com.example.ytrebuild.Response.YTSearchResponse;
import com.example.ytrebuild.Response.YTVideoResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParentSearchResponse {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("items")
    @Expose
    private List<YTSearchResponse> items = null;
    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;

    /**
     * No args constructor for use in serialization
     *
     */
    public ParentSearchResponse() {
    }

    /**
     *
     * @param kind
     * @param nextPageToken
     * @param pageInfo
     * @param etag
     * @param items
     */
    public ParentSearchResponse(String kind, String etag, List<YTSearchResponse> items, String nextPageToken, PageInfo pageInfo) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.items = items;
        this.nextPageToken = nextPageToken;
        this.pageInfo = pageInfo;
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

    public List<YTSearchResponse> getItems() {
        return items;
    }

    public void setItems(List<YTSearchResponse> items) {
        this.items = items;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }


}
