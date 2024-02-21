import { Button, Card, CardBody, Container } from "reactstrap";
import { loadAllCategories } from "../services/category-services";
import { useEffect, useState } from "react";
import JoditEditor from "jodit-react";
import { useRef } from "react";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { getCurrentUserDetail } from "../auth";
import { createPost as doCreatePost } from "../services/post-services";
const AddPost = () => {
  const editor = useRef(null);
  const [content, setContent] = useState("");
  const [user, setUser] = useState(undefined);
  const [categories, setCategories] = useState([]);
  const [post, setPost] = useState({
    title: "",
    content: "",
    category: {
      categoryId: 0,
    },
    user: {
      userId: "",
    },
  });
  const config = {
    placeholder: "Start typing...",
  };
  useEffect(() => {
    setUser(getCurrentUserDetail());
    loadAllCategories()
      .then((data) => {
        console.log(data);
        setCategories(data);
      })
      .catch((error) => {
        console.log(error);
      });

    setPost({ ...post, user: { userId: getCurrentUserDetail().userId } });
  }, []);
  //field changed function
  const fieldChanged = (event) => {
    //console.log(event)
    setPost({ ...post, [event.target.name]: event.target.value });
  };
  const contentFieldChanged = (data) => {
    setPost({ ...post, content: data });
  };
  const categoryChanged = (event) => {
    const categoryId = parseInt(event.target.value);
    setPost({ ...post, category: { categoryId: categoryId } });
  };

  //create post function
  const createPost = (event) => {
    event.preventDefault();

    console.log(post);
    if (post.title.trim() == "") {
      toast.error("post is required !!");
      return;
    }
    if (post.content.trim() == "") {
      toast.error("post content is required !!");
      return;
    }

    if (post.categoryId == "") {
      toast.error("Post Category is required !!");
      return;
    }
    //submit the form on server

    doCreatePost(post, user.userId)
      .then((resp) => {
        console.log(resp);
        toast.success("Post Created");
        setPost({
          title: "",
          content: "",
          category: {
            categoryId: 0,
          },
          user: {
            userId: user.userId,
          },
        });
      })
      .catch((error) => {
        toast.error("An error occurred while creating the post.");
        console.log(error);
      });
  };
  return (
    <div className="wrapper ">
      <Card className="shadow-sm border-0 mt-2">
        <CardBody>
          {JSON.stringify(post)}
          <h3>what is going in your mind?</h3>
          <form onSubmit={createPost}>
            <div className="my-3">
              <label htmlFor="content">Post title</label>
              <input
                type="text"
                id="content"
                placeholder="Enter here"
                className="rounded-0"
                style={{ height: "40px" }}
                name="title"
                onChange={fieldChanged}
              />
            </div>
            <div className="my-3">
              <label htmlFor="category">Post Content</label>
              {/* <input type="textarea" id="content" placeholder="Enter here" className="rounded-0"onChange={fieldChanged} style={{ height: '300px' }}/>*/}
              <JoditEditor
                ref={editor}
                value={post.content}
                config={{
                  enter: "br",
                  cleanHTML: false,
                  removeButtons: ["paragraph"], // Remove the paragraph button from the toolbar
                }}
                onChange={contentFieldChanged}
              />
            </div>
            <div className="my-3">
              <label htmlFor="content">Category </label>
              <select
                type="select"
                id="category"
                placeholder="Enter here"
                className="rounded-0"
                name="categoryId"
                onChange={categoryChanged}
                defaultValue={0}
              >
                <option disabled value={0}>
                  --Select category--
                </option>
                {categories.map((category) => (
                  <option value={category.categoryId} key={category.categoryId}>
                    {category.categoryTitle}
                  </option>
                ))}
              </select>
            </div>
            <Container className="text-center">
              <Button type="submit" className="rounded-0" color="primary">
                Create Post
              </Button>
              <Button className="rounded-0 ms-2" color="danger">
                Reset Content
              </Button>
            </Container>
          </form>
        </CardBody>
      </Card>
    </div>
  );
};
export default AddPost;
