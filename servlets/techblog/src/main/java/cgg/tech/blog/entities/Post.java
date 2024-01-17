package cgg.tech.blog.entities;

import java.util.Date;

public class Post {

  public Post() {}

  private int pId;
  private String pTitle;
  private String pContent;
  private String pCode;
  private String pPic;
  private int catId;
  private int userId;
  private Date pDate;

  public Post(
    int pId,
    String pTitle,
    String pContent,
    String pCode,
    String pPic,
    int catId,
    int userId,
    Date pDate
  ) {
    this.pId = pId;
    this.pTitle = pTitle;
    this.pContent = pContent;
    this.pCode = pCode;
    this.pPic = pPic;
    this.catId = catId;
    this.userId = userId;
    this.pDate = pDate;
  }

  public Post(
    String pTitle,
    String pContent,
    String pCode,
    String pPic,
    int catId,
    int userId
  ) {
    this.pTitle = pTitle;
    this.pContent = pContent;
    this.pCode = pCode;
    this.pPic = pPic;
    this.catId = catId;
    this.userId = userId;
  }

  public int getpId() {
    return pId;
  }

  public void setpId(int pId) {
    this.pId = pId;
  }

  public String getpTitle() {
    return pTitle;
  }

  public void setpTitle(String pTitle) {
    this.pTitle = pTitle;
  }

  public String getpContent() {
    return pContent;
  }

  public void setpContent(String pContent) {
    this.pContent = pContent;
  }

  public String getpCode() {
    return pCode;
  }

  public void setpCode(String pCode) {
    this.pCode = pCode;
  }

  public String getpPic() {
    return pPic;
  }

  public void setpPic(String pPic) {
    this.pPic = pPic;
  }

  public int getCatId() {
    return catId;
  }

  public void setCatId(int catId) {
    this.catId = catId;
  }

  public Date getpDate() {
    return pDate;
  }

  public void setpDate(Date pDate) {
    this.pDate = pDate;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
