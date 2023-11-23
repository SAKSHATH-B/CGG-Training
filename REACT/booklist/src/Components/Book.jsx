// import { Author } from "./Author";
// import { Image } from "./Image";
// import { Title } from "./Title";

export const Book = ({
  img,
  title,
  author /*,children */ /*, display*/,
  getBook,
  id,
  number,
}) => {
  // const displayTitle = () => {
  //   console.log(title);
  // };
  // const getSingleBook = () => {
  //   getBook(id);
  // };
  // console.log(number);
  return (
    <article className="book">
      <img src={img} alt={title} />
      <h2>{title}</h2>
      <h4>{author}</h4>
      <span className="number">#{number + 1}</span>
    </article>
  );
  // <button onClick={/*displayTitle*/ /*display*/ getSingleBook}>
  //   Display Title
  // </button>
};
