import React, { useEffect, useState } from "react";
import {
  Col,
  Container,
  Pagination,
  PaginationItem,
  PaginationLink,
  Row,
} from "reactstrap";
import InfiniteScroll from "react-infinite-scroll-component";
import Post from "./Post";
import { toast } from "react-toastify";
import { loadAllPosts } from "../services/post-services";

const NewsFeed = () => {
  const [postContent, setPostContent] = useState({
    content: [],
    totalPages: "",
    totalElements: "",
    pageSize: "",
    lastPage: false,
    pageNumber: "",
  });

  useEffect(() => {
    changePage(0);
  }, []);

  const changePage = (pageNumber = 0, pageSize = 5) => {
    if (pageNumber > postContent.pageNumber && postContent.lastPage) {
      return;
    }
    if (pageNumber < postContent.pageNumber && postContent.pageNumber === 0) {
      return;
    }
    loadAllPosts(pageNumber, pageSize)
      .then((data) => {
        console.log(data);
        setPostContent(data);
        window.scroll(0, 0);
      })
      .catch((error) => toast.error("Error in loading posts"));
  };

  return (
    <div className="container-fluid">
      <Row>
        <Col md={{ size: 10, offset: 1 }}>
          <h1>Blogs Count ({postContent?.totalElements})</h1>
          <InfiniteScroll dataLength={postContent.content.length}>
            {postContent.content.map((post) => {
              <Post post={post} key={post.postId} />;
            })}
          </InfiniteScroll>

          <Container className="mt-3">
            <Pagination size="lg">
              <PaginationItem
                onClick={() => changePage(postContent.pageNumber - 1)}
                disabled={postContent.pageNumber == 0}
              >
                <PaginationLink previous>Previous</PaginationLink>
              </PaginationItem>

              {[...Array(postContent.totalElements)].map((item, index) => {
                <PaginationItem
                  onClick={() => changePage(index)}
                  active={index === postContent.pageNumber}
                  key={index}
                >
                  <PaginationLink>{index + 1}</PaginationLink>
                </PaginationItem>;
              })}

              <PaginationItem
                onClick={() => changePage(postContent.pageNumber + 1)}
                disabled={postContent.lastPage}
              >
                <PaginationLink next>Next</PaginationLink>
              </PaginationItem>
            </Pagination>
          </Container>
        </Col>
      </Row>
    </div>
  );
};

export default NewsFeed;
