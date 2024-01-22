package cgg.spring.core;

public class Pancard {

  private String panHolderName;
  private String panNo;

  public String getPanHolderName() {
    return panHolderName;
  }

  public void setPanHolderName(String panHolderName) {
    this.panHolderName = panHolderName;
  }

  public String getPanNo() {
    return panNo;
  }

  public void setPanNo(String panNo) {
    this.panNo = panNo;
  }

  @Override
  public String toString() {
    return "Pancard [panHolderName=" + panHolderName + ", panNo=" + panNo + "]";
  }
}
