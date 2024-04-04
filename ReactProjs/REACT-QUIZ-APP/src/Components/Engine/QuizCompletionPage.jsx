import React from "react";
import CustomNavbar from "../CustomNavbar";
import { Button } from "reactstrap";

const QuizCompletionPage = ({ marks, question_count }) => {
  function convertFractionToScaleOf5(marks, questionCount) {
    // Ensure marks and questionCount are numbers
    marks = parseFloat(marks);
    questionCount = parseFloat(questionCount);

    // Calculate the ratio of marks to questionCount
    const ratio = marks / questionCount;

    // Map the ratio to the scale of 5
    const scaleValue = Math.ceil(ratio * 5);

    // Ensure scaleValue is within the range of 1 to 5
    return Math.min(Math.max(scaleValue, 1), 5);
  }
  return (
    <div className=" border  border-2 border-start-0 border-top-0  border-black vh-100 align-items-center  d-flex  justify-content-center  ">
      {/* <Confetti width={width} height={height} numberOfPieces={300} /> */}
      <div className="text-center ">
        {/* <Rating
          name="read-only"
          value={convertFractionToScaleOf5(marks, question_count)}
          readOnly
        /> */}
        <h2>QUIZ SUBMITTED SUCCESFULLY </h2>
        <h3>you have attempted :</h3>
        <h3>
          {marks}/{question_count}
        </h3>

        <p>
          Click here to get back to <a href="/user/userDashboard">Home</a>Page
        </p>
      </div>
    </div>
  );
};

export default QuizCompletionPage;
