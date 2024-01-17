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
        if(posts.size()==0){
            out.println("<h3 class='display-3 text-center'>No Posts in this Category</h3>");
        }
    }

for(Post p : posts){
    %>

    <div class="col-md-6">
        <div class="card">
            <img src="blogpics/<%= p.getpPic() %>" class="card-img-top" alt="img_not_found">
            <div class="card-body">
                <b class="card-title"><%= p.getpTitle() %></b>
                <p class="card-text"><%= p.getpContent() %></p>
                <pre><%= p.getpCode() %></pre>
            </div>
        </div>
    </div>
<%
}

%>
</div>