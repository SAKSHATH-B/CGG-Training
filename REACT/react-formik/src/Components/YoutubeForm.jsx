import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";

const initialValues = {
  name: "Sakshath",
  email: "",
  channel: "",
  comments: "",
};

const onSubmit = (values) => {
  console.log("Form Data", values);
};

const validationSchema = Yup.object({
  name: Yup.string().required("Required!!"),
  email: Yup.string().email("Invalid Format!!").required("Required!!"),
  channel: Yup.string().required("Required!!"),
});

function YoutubeForm() {
  return (
    <Formik
      initialValues={initialValues}
      validationSchema={validationSchema}
      onSubmit={onSubmit}
    >
      <Form>
        <div className="form-control">
          <label htmlFor="name">Name</label>
          <Field type="text" name="name" id="name" />
          <ErrorMessage name="name" />
        </div>

        <div className="form-control">
          <label htmlFor="email">E-mail</label>
          <Field type="email" name="email" id="email" />
          <ErrorMessage name="email" />
        </div>

        <div className="form-control">
          <label htmlFor="channel">Channel</label>
          <Field type="text" name="channel" id="channel" />
          <ErrorMessage name="channel" />
        </div>

        <div className="form-control">
          <label htmlFor="comments">Comments</label>
          <Field as="textarea" id="comments" name="comments" />
        </div>

        <button type="submit">Submit</button>
      </Form>
    </Formik>
  );
}

export default YoutubeForm;

//reduce the repeated code in YoutubeForm.jsx and make it simpler

//on each input field there are three values repeated same onChange,onBlur,value{fieldName} - remove this and add an object formik.getFieldProps('fieldName') and spread to make a copy

//we will use four components that makes code simpler

//1.import and use Formik Component instead of useFormik hook
//Formik component makes code simpler by removing the useFormik hook and pass the functions(initialstate,onsubmit,validationSchema) as props to the Formik component.

//2.Form Component
//import and use Form Component instead of form tag
//remove onSubmit prop
//Form component automatically links onSubmit method passed as props to Formik component

//3.Field Component
//import and use Field Component instead of input tags
//remove the getFieldProps
//Field component hooks directly into Formik component using the name attribute and accesses the value,onBlur,onChange events

//4.error message component
//import and use ErrorMessage component by passing the name instead of conditionally rendering error messages

// ---------------------------------
//(Vid18)
//More about Field Component
//if we want to have a textarea then use field with as or component equals textarea -> Field as/component="textarea"
