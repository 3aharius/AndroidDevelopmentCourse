package course.bandsintown.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
public class Event {

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("datetime")
    private Date datetime;

    @SerializedName("formatted_datetime")
    private String formattedDatetime;

    @SerializedName("formatted_location")
    private String formattedLocation;

    @SerializedName("ticket_url")
    private String ticketUrl;

    @SerializedName("ticket_type")
    private String ticketType;

    @SerializedName("ticket_status")
    private String ticketStatus;

    @SerializedName("on_sale_datetime")
    private Date onSaleDatetime;

    @SerializedName("facebook_rsvp_url")
    private String facebookRsvpUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("artists")
    private List<Artist> artists;

    @SerializedName("venue")
    private Venue venue;

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getFormattedDatetime() {
        return formattedDatetime;
    }

    public void setFormattedDatetime(String formattedDatetime) {
        this.formattedDatetime = formattedDatetime;
    }

    public String getFormattedLocation() {
        return formattedLocation;
    }

    public void setFormattedLocation(String formattedLocation) {
        this.formattedLocation = formattedLocation;
    }

    public String getTicketUrl() {
        return ticketUrl;
    }

    public void setTicketUrl(String ticketUrl) {
        this.ticketUrl = ticketUrl;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Date getOnSaleDatetime() {
        return onSaleDatetime;
    }

    public void setOnSaleDatetime(Date onSaleDatetime) {
        this.onSaleDatetime = onSaleDatetime;
    }

    public String getFacebookRsvpUrl() {
        return facebookRsvpUrl;
    }

    public void setFacebookRsvpUrl(String facebookRsvpUrl) {
        this.facebookRsvpUrl = facebookRsvpUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

}
