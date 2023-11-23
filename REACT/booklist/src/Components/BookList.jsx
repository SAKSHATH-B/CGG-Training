import { Book } from "./Book";
import books from "./Books";
export const BookList = () => {
  // const val = "This is a sample text for props drilling";
  // const display = () => {
  //   console.log(val);
  // };
  // const getBook = (id) => {
  //   const book = books.find((book) => book.id === id);
  //   console.log(book);
  // };
  return (
    <>
      <h1>Amazon Best Seller Books</h1>
      <section className="booklist">
        {/* <Book
        author={firstBook.author}
        title={firstBook.title}
        img={firstBook.img}
      /> */}
        {/* <p>
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Repellat
          animi asperiores dolor eveniet neque minima corporis at ipsa sed quae.
        </p>
        <button>click me</button>
      </Book> */}
        {/* <Book
        author={secondBook.author}
        title={secondBook.title}
        img={secondBook.img}
      />
      <Book
        author={firstBook.author}
        title={firstBook.title}
        img={firstBook.img}
      /> */}
        {/* <EventExamples /> */}

        {books.map((book, index) => {
          // console.log(book);
          return (
            <Book
              {...book}
              key={book.id}
              /*getBook={getBook} */ number={index}
            />
          );
        })}
      </section>
    </>
  );
};

// const EventExamples = () => {
//   // const handleFormInput = (e) => {
//   //   console.log(e);
//   //   console.log(e.target.name);
//   //   console.log(e.target.value);
//   //   console.log("Handle Form Input");
//   // };
//   // const handleButtonClick = () => {
//   //   alert("Handle Button Click");
//   // };

//   const handleFormSubmission = (e) => {
//     e.preventDefault();
//     console.log("Form Submitted");
//   };
//   return (
//     <section>
//       <form onSubmit={handleFormSubmission}>
//         <h2>Typical form</h2>
//         <input
//           type="text"
//           name="example"
//           onChange={(e) => console.log(e.target.value)}
//           style={{ margin: "1rem 0" }}
//         />
//         <button type="submit">Submit</button>
//         <button onClick={() => console.log("Click me")} type="button">
//           Click me
//         </button>
//       </form>
//     </section>
//   );
// };
