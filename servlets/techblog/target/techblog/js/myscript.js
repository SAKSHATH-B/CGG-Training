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
      if (data) {
        let id = "#" + $.escapeSelector(pid);
        let c = $(id).html();
        c++;
        $(id).html(c);
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.log(errorThrown);
    },
  });
}
