import React from "react";
import { useFormik } from "formik";
import * as Yup from "yup";

const initialValues = {
  name: "Sakshath",
  email: "",
  channel: "",
};

const onSubmit = (values) => {
  console.log("Form Data", values);
};

const validate = (values) => {
  //validate function returns an object
  //create an empty object and return the same
  //errors.name errors.email errors.channel
  //errors.name = 'This field is required'

  let errors = {};

  if (!values.name) {
    errors.name = "Required";
  }
  if (!values.email) {
    errors.email = "Required";
  } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
    errors.email = "Invalid email format";
  }
  if (!values.channel) {
    errors.channel = "Required";
  }

  return errors;
};

const validationSchema = Yup.object({
  name: Yup.string().required("Required!!"),
  email: Yup.string().email("Invalid Format!!").required("Required!!"),
  channel: Yup.string().required("Required!!"),
});

function OldYoutubeForm() {
  const formik = useFormik({
    initialValues,
    onSubmit,
    // validate,
    validationSchema,
  });

  // console.log("Form Data",formik.values);
  // console.log("Form errors",formik.errors);
  // console.log("visited fields", formik.touched); //checks whether the field is visited or not

  return (
    <div>
      <form onSubmit={formik.handleSubmit}>
        <div className="form-control">
          <label htmlFor="name">Name</label>
          <input
            type="text"
            name="name"
            id="name"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            value={formik.values.name}
          />
          {formik.touched.name && formik.errors.name ? (
            <div className="error">{formik.errors.name}</div>
          ) : null}
        </div>

        <div className="form-control">
          <label htmlFor="email">E-mail</label>
          <input
            type="email"
            name="email"
            id="email"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            value={formik.values.email}
          />
          {formik.touched.email && formik.errors.email ? (
            <div className="error">{formik.errors.email}</div>
          ) : null}
        </div>

        <div className="form-control">
          <label htmlFor="channel">Channel</label>
          <input
            type="text"
            name="channel"
            id="channel"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            value={formik.values.channel}
          />
          {formik.touched.channel && formik.errors.channel ? (
            <div className="error">{formik.errors.channel}</div>
          ) : null}
        </div>

        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default OldYoutubeForm;

//Simple form with three fields
//useFormik hook
//Managing form state, handling form submission and form validation
//initial values + formik.handleChange
//onSubmit method + formik.handleSubmit
//validate Function
//validationSchema using Yup library
//formik.errors and formik.touched
//Formik Components - Formik, Form, Field, ErrorMessage

//the error message is applied to a form field as required field by using validate function in the useFormik hook and it returns an object with keys as name property on input fields
//ex:errors{object}.name

//and display the error msg using conditional rendering

//this makes the user to view error messages if the values does not match the input field type

//but if there are more input fields and if user tries to access the first field the error messages are displayed to all the fields without visiting

//to improve user experience we use the property called onBlur={formik.handleBlur} on input fields to track the changes in the fields

//this onBlur returns a object "formik.touched" states whether the field is visited or not

//we can enhance the validate function to more simple way by using yup - install by using yarn add yup and import into file
//we will write a validationSchema to validate the fields using Yup.object({}) and pass it to the use Formik hook which is similar to the validate function

//reduce the repeated code in newYoutubeForm.jsx and make it simpler
