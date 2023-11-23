// const img =
//   "https://images-eu.ssl-images-amazon.com/images/I/814L+vq01mL._AC_UL600_SR600,400_.jpg";
// const title = "Ikigai";
// const author = "Francesc Miralles";

const firstBook = {
  img: "https://images-eu.ssl-images-amazon.com/images/I/814L+vq01mL._AC_UL600_SR600,400_.jpg",
  title: "Ikigai",
  author: "Francesc Miralles",
};

const BookList = () => {
  return (
    <section className="booklist">
      <Book
        img={firstBook.img}
        title={firstBook.title}
        author={firstBook.author}
      />
      {/* <p>
          Lorem, ipsum dolor sit amet consectetur adipisicing elit. Fugit, aut
          neque velit molestias saepe similique voluptas dignissimos nostrum.
          Sed id neque cupiditate a, vitae dicta nisi. Porro ducimus natus
          aspernatur at, modi et dolorum, saepe incidunt esse deserunt nobis
          placeat sint ipsam, hic nulla. Ducimus distinctio harum est vel? Ut.
        </p>
      </Book> */}
      <Book
        img={firstBook.img}
        title={firstBook.title}
        author={firstBook.author}
      />
      <Book
        img={firstBook.img}
        title={firstBook.title}
        author={firstBook.author}
      />
    </section>
  );
};

const Book = ({ img, title, author, children }) => {
  return (
    <article className="book">
      <img src={img} alt={title} />
      <h2>{title}</h2>
      <h4>{author}</h4>
      {children}
    </article>
  );
};

export default BookList;
