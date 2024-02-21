import React, { useEffect, useState } from "react";
import Base from "../../components/base";
import { Container } from "reactstrap";
import AddPost from "../../components/AddPost";
import NewFeed from "../../components/NewFeed";
import { getCurrentUserDetail } from "../../auth";
import { loadPostUserWise } from "../../services/post-services";
import Post from "../../components/Post";
import { deletePostService } from "../../services/post-services";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const Userdashboard = () => {
  const [user, setUser] = useState({});
  const [posts, setPosts] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [postsPerPage] = useState(2);
  useEffect(() => {
    console.log(getCurrentUserDetail());
    setUser(getCurrentUserDetail());
    loadPostData();
  }, []);

  function loadPostData() {
    loadPostUserWise(getCurrentUserDetail().userId)
      .then((data) => {
        console.log(data);
        setPosts([...data]);
      })
      .catch((error) => {
        console.log(error);
        toast.error("error in loading user posts");
      });
  }
  //function to delete post
  const deletePost = (post) => {
    //going to delete post
    deletePostService(post.postId)
      .then((res) => {
        console.log(res);
        toast.success("Post is deleted...");
        //loadPostData()
        let newPosts = posts.filter((p) => p.postId != post.postId);
        setPosts([...newPosts]);
      })
      .catch((error) => {
        console.log(error);
        toast.error("error in deleting post");
      });
  };

  // Get current posts
  const indexOfLastPost = currentPage * postsPerPage;
  const indexOfFirstPost = indexOfLastPost - postsPerPage;
  const currentPosts = posts.slice(indexOfFirstPost, indexOfLastPost);

  // Change page
  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  return (
    <Base>
      <Container>
        <AddPost />
        <h1 className="my-3">Posts Count : ({posts.length})</h1>
        {currentPosts.map((post, index) => {
          return <Post post={post} key={index} deletePost={deletePost} />;
        })}
        {/* Pagination */}
        <ul className="pagination justify-content-center mt-4">
          {Array.from({ length: Math.ceil(posts.length / postsPerPage) }).map(
            (_, index) => (
              <li key={index} className="page-item">
                <button
                  onClick={() => paginate(index + 1)}
                  className="page-link"
                >
                  {index + 1}
                </button>
              </li>
            )
          )}
        </ul>
      </Container>
    </Base>
  );
};
export default Userdashboard;
