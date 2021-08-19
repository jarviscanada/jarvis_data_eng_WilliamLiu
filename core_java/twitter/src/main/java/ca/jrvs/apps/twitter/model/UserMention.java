package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserMention {

  private String name;
  private List<Integer> indices;
  private String screenName;
  private int id;
  private String idStr;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Integer> getIndices() {
    return indices;
  }

  public void setIndices(List<Integer> indices) {
    this.indices = indices;
  }

  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getIdStr() {
    return idStr;
  }

  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }

  @Override
  public String toString() {
    return "UserMention{" +
        "name='" + name + '\'' +
        ", indices=" + indices +
        ", screenName='" + screenName + '\'' +
        ", id=" + id +
        ", idStr='" + idStr + '\'' +
        '}';
  }
}
