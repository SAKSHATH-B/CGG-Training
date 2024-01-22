<%@ page errorPage="error_page.jsp" %> <%@ page
import="cgg.tech.blog.entities.Post,cgg.tech.blog.dao.PostDao,cgg.tech.blog.helper.ConnectionProvider,java.util.List"
%> 
<div class="row">
<% 

int catId = Integer.parseInt(request.getParameter("catId"));

PostDao postdao = new PostDao(ConnectionProvider.getConnection());
List<Post> posts = null;
    if(catId==0){
        posts = postdao.getAllPosts();
    }else{
        posts = postdao.getPostbyCategory(catId);
    }
if(posts.size()==0){
    out.println("<h3 class='display-3 text-center'>No Posts in this Category</h3>");
    return;
}

for(Post p : posts){
    %>

    <div class="col-md-6">
        <div class="card">
            <img src="blogpics/<%= p.getpPic() %>" class="card-img-top" alt="img_not_found">
            <div class="card-body">
                <b class="card-title"><%= p.getpTitle() %></b>
                <p class="card-text"><%= p.getpContent() %></p>
            </div>
            <div class="card-footer text-center primary-background">
                <a href="#!" class="btn btn-outline-light btn-sm"><i class="fa fa-thumbs-o-up"></i><span>10</span></a>
                <a href="showblogpost.jsp?post_id=<%= p.getpId() %>" class="btn btn-outline-light btn-sm">Read More...</a>
                <a href="#!" class="btn btn-outline-light btn-sm"><i class="fa fa-commenting-o"></i><span>10</span></a>
            </div>
        </div>
    </div>
<%
}

%>
</div>