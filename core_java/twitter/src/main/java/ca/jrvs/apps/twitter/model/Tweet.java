package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "created_at",
    "id",
    "id_str",
    "text",
    "entities",
    "coordinates",
    "retweet_count",
    "favorite_count",
    "favorited",
    "retweeted"
})

public class Tweet {

  @JsonProperty("created_at")
  private String createdAt;
  @JsonProperty("id")
  private long id;
  @JsonProperty("id_str")
  private String idStr;
  @JsonProperty("text")
  private String text;
  @JsonProperty("entities")
  private Entities entities;
  @JsonProperty("coordinates")
  private Coordinates coordinates;
  @JsonProperty("retweet_count")
  private long retweetCount;
  @JsonProperty("favorite_count")
  private long favoriteCount;
  @JsonProperty("favorited")
  private boolean favorited;
  @JsonProperty("retweeted")
  private boolean retweeted;

  @JsonProperty("created_at")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("created_at")
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  @JsonProperty("id")
  public long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(long id) {
    this.id = id;
  }

  public String getIdStr() {
    return idStr;
  }

  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }

  @JsonProperty("text")
  public String getText() {
    return text;
  }

  @JsonProperty("text")
  public void setText(String text) {
    this.text = text;
  }

  @JsonProperty("entities")
  public Entities getEntities() {
    return entities;
  }

  @JsonProperty("entities")
  public void setEntities(Entities entities) {
    this.entities = entities;
  }

  @JsonProperty("coordinates")
  public Coordinates getCoordinates() {
    return coordinates;
  }

  @JsonProperty("coordinates")
  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  @JsonProperty("retweet_count")
  public long getRetweetCount() {
    return retweetCount;
  }

  @JsonProperty("retweet_count")
  public void setRetweetCount(int retweetCount) {
    this.retweetCount = retweetCount;
  }

  @JsonProperty("favorite_count")
  public long getFavoriteCount() {
    return favoriteCount;
  }

  @JsonProperty("favorite_count")
  public void setFavoriteCount(int favoriteCount) {
    this.favoriteCount = favoriteCount;
  }

  @JsonProperty("favorited")
  public boolean isFavorited() {
    return favorited;
  }

  @JsonProperty("favorited")
  public void setFavorited(boolean favorited) {
    this.favorited = favorited;
  }

  @JsonProperty("retweeted")
  public boolean isRetweeted() {
    return retweeted;
  }

  @JsonProperty("retweeted")
  public void setRetweeted(boolean retweeted) {
    this.retweeted = retweeted;
  }

  @Override
  public String toString() {
    return "Tweet{" +
        "createdAt='" + createdAt + '\'' +
        ", id=" + id +
        ", intStr='" + idStr + '\'' +
        ", text='" + text + '\'' +
        ", entities=" + entities +
        ", coordinates=" + coordinates +
        ", retweetCount=" + retweetCount +
        ", favoriteCount=" + favoriteCount +
        ", favorited=" + favorited +
        ", retweeted=" + retweeted +
        '}';
  }
}
