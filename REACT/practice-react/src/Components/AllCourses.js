import React, { useState } from "react";
import { Course } from "./Course";

export const AllCourses = () => {
  const [cours, setCours] = useState([
    {
      title: "JavaScript",
      desc: "Hands on Practice on JavaScript",
    },
    { title: "ReactJS", desc: "Hands on Practice on ReactJS" },
    { title: "HTML & CSS", desc: "Hands on Development on HTML & CSS" },
  ]);
  return (
    <div>
      <h3>All Courses Listed Below</h3>
      <p>This is a reference for all the courses to be learned</p>
      {cours.length > 0
        ? cours.map((item) => <Course courses={item} />)
        : "No Courses"}
    </div>
  );
};
