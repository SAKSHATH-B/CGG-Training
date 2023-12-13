package map;

import java.util.List;

public class DetailEx {

  private int detailId;
  private List<String> details;

  public DetailEx(int detailId, List<String> details) {
    this.detailId = detailId;
    this.details = details;
  }

  public void setDetailId(int detailId) {
    this.detailId = detailId;
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }

  public int getDetailId() {
    return detailId;
  }

  public List<String> getDetails() {
    return details;
  }
}
