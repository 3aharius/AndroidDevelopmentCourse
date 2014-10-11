package course.bandsintown.entity;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Artist {

    @SerializedName("name")
    private String name;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("thumb_url")
    private String thumbUrl;

    @SerializedName("facebook_tour_dates_url")
    private String facebookTourDatesUrl;

    @SerializedName("mbid")
    private String mbid;

    @SerializedName("upcoming_events_count")
    private int upcomingEventsCount;

    public int getUpcomingEventsCount() {
        return upcomingEventsCount;
    }

    public void setUpcomingEventsCount(int upcomingEventsCount) {
        this.upcomingEventsCount = upcomingEventsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getFacebookTourDatesUrl() {
        return facebookTourDatesUrl;
    }

    public void setFacebookTourDatesUrl(String facebookTourDatesUrl) {
        this.facebookTourDatesUrl = facebookTourDatesUrl;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

}
