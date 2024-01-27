function doLike(pid, uid) {
  console.log(pid + "," + uid);

  const d = {
    pid: pid,
    uid: uid,
    operation: "Like",
  };

  $.ajax({
    url: "LikeServlet",
    data: d,
    success: function (data, textStatus, jqXHR) {
      console.log(data);
      console.log("done");
      if (data) {
        console.log("done");
        let c = $(".like-counter").html();
        c++;
        $(".like-counter").html(c);
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.log(errorThrown);
    },
  });
}
