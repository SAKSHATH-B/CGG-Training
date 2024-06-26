import { myAxios, privateAxios } from "./helper";

//create post function
export const createPost = (postData, userId) => {
  return privateAxios
    .post(
      `/posts/user/${userId}/category/${postData.category.categoryId}/posts`,
      postData
    )
    .then((response) => response.data);
};

//get all posts
export const loadAllPosts = (pageNumber, pageSize) => {
  return myAxios
    .get(
      `/posts?pageNumber=${pageNumber}&pageSize=${pageSize}&sortBy=addedDate&sortDir=desc`
    )
    .then((response) => response.data);
};

//load single post of given id
// export const loadPost=(postId)=>{
//     return myAxios.get(`/posts/${postId}`)
//     .then(response=>response.data)
// }

export const createComment = (comment, postId) => {
  return privateAxios.post(`/posts/${postId}/comments`, comment);
};
//upload post banner image
export const uploadPostImage = (image, postId) => {
  let formData = new FormData();
  formData.append("image", image);
  return privateAxios
    .post(`/post/image/upload/${postId}`, formData, {
      Headers: {
        "Content-Type": "multipart/form-data",
      },
    })
    .then((response) => response.data);
};

//get category wise posts
export const loadPostCategoryWise = (categoryId) => {
  return privateAxios
    .get(`/category/${categoryId}/posts`)
    .then((response) => response.data);
};
//
export const loadPostUserWise = (userId) => {
  return privateAxios
    .get(`/posts/user/${userId}/posts`)
    .then((response) => response.data);
};

//delete post
export const deletePostService = (postId) => {
  return privateAxios
    .delete(`/posts/${postId}`)
    .then((response) => response.data);
};

//update post
export const doUpdatePost = (post, postId) => {
  console.log(post);
  return privateAxios
    .put(`/posts/${postId}`, post)
    .then((response) => response.data);
};
