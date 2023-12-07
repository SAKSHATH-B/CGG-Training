import React from "react";
import {
  Formik,
  Form,
  Field,
  ErrorMessage,
  FieldArray,
  FastField,
} from "formik";
import * as Yup from "yup";
import TextError from "./TextError";
import { useState } from "react";

const initialValues = {
  name: "Sakshath",
  email: "",
  channel: "",
  comments: "",
  address: "",
  social: {
    facebook: "",
    twitter: "",
  },
  phoneNumbers: ["", ""],
  phNumbers: [""],
};

const savedValues = {
  name: "Sakshath",
  email: "sakshathkumar64@gmail.com",
  channel: "YoutubeForms",
  comments: "learn Youtube Forms",
  address: "Gachibowli, Hyderabad",
  social: {
    facebook: "",
    twitter: "",
  },
  phoneNumbers: ["", ""],
  phNumbers: [""],
};

const onSubmit = (values, onSubmitProps) => {
  console.log("Form Data", values);
  //   console.log("Submit Props", onSubmitProps);
  onSubmitProps.setSubmitting(false);
  onSubmitProps.resetForm();
};

const validationSchema = Yup.object({
  name: Yup.string().required("Required!!"),
  email: Yup.string().email("Invalid Format!!").required("Required!!"),
  channel: Yup.string().required("Required!!"),
  //   comments: Yup.string().required("Required!!"),
});

//field level validation function
const validateComments = (value) => {
  let error;
  if (!value) {
    error = "REQUIRED!!";
  }
  return error;
};

function YoutubeForm() {
  const [formData, setFormData] = useState(null);
  return (
    <Formik
      initialValues={formData || initialValues}
      validationSchema={validationSchema}
      onSubmit={onSubmit}
      enableReinitialize
      //   validateOnMount
      //   validateOnChange={false}
      //   validateOnBlur={false}
    >
      {(formik) => {
        console.log("Formik Props", formik);
        return (
          <Form>
            <div className="form-control">
              <label htmlFor="name">Name</label>
              <Field type="text" name="name" id="name" />
              <ErrorMessage name="name" component={TextError} />
            </div>

            <div className="form-control">
              <label htmlFor="email">E-mail</label>
              <Field type="email" name="email" id="email" />
              <ErrorMessage name="email">
                {(errorMsg) => <div className="error">{errorMsg}</div>}
              </ErrorMessage>
            </div>

            <div className="form-control">
              <label htmlFor="channel">Channel</label>
              <Field
                type="text"
                name="channel"
                id="channel"
                placeholder="Youtube Channel Name"
              />
              <ErrorMessage name="channel" component={TextError} />
            </div>

            <div className="form-control">
              <label htmlFor="comments">Comments</label>
              <Field
                as="textarea"
                id="comments"
                name="comments"
                validate={validateComments}
              />
              <ErrorMessage name="comments" component={TextError} />
            </div>

            {/* rendering custom input fields using render props method */}
            <div className="form-control">
              <label htmlFor="address">Address</label>
              <FastField name="address">
                {(props) => {
                  const { field, form, meta } = props;
                  // console.log(props);
                  //   console.log("Field render");
                  return (
                    <div>
                      <input type="text" id="address" {...field} />
                      {meta.touched && meta.error ? (
                        <div>{meta.error}</div>
                      ) : null}
                    </div>
                  );
                }}
              </FastField>
            </div>

            <div className="form-control">
              <label htmlFor="facebook">Facebook</label>
              <Field type="text" id="facebook" name="social.facebook" />
            </div>

            <div className="form-control">
              <label htmlFor="twitter">Twitter</label>
              <Field type="text" id="twitter" name="social.twitter" />
            </div>

            <div className="form-control">
              <label htmlFor="primaryPh">Primary PhoneNumber</label>
              <Field type="text" id="primaryPh" name="phoneNumbers[0]" />
            </div>

            <div className="form-control">
              <label htmlFor="secondaryPh">Secondary PhoneNumber</label>
              <Field type="text" id="secondaryPh" name="phoneNumbers[1]" />
            </div>

            <div className="form-control">
              <label htmlFor="">List of Phone Numbers</label>
              <FieldArray name="phNumbers">
                {(fieldArrayProps) => {
                  //   console.log("FieldArrayProps", fieldArrayProps);
                  const { form, push, remove } = fieldArrayProps;
                  const { values } = form;
                  const { phNumbers } = values;
                  //   console.log("Form Errors", form.errors);
                  return (
                    <div>
                      {phNumbers.map((phNumber, index) => (
                        <div key={index}>
                          <Field name={`phNumbers[${index}]`} />
                          {index > 0 && (
                            <button type="button" onClick={() => remove(index)}>
                              -
                            </button>
                          )}
                          <button type="button" onClick={() => push("")}>
                            +
                          </button>
                        </div>
                      ))}
                    </div>
                  );
                }}
              </FieldArray>
            </div>

            {/* <button
              type="button"
              onClick={() => formik.validateField("comments")}
            >
              Validate Comments
            </button>
            <button type="button" onClick={() => formik.validateForm()}>
              Validate all
            </button>
            <button
              type="button"
              onClick={() => formik.setFieldTouched("comments")}
            >
              Visit Comments
            </button>
            <button
              type="button"
              onClick={() =>
                formik.setTouched({
                  name: true,
                  email: true,
                  channel: true,
                  comments: true,
                })
              }
            >
              Visit all
            </button> */}
            <button type="button" onClick={() => setFormData(savedValues)}>
              Load Saved Data
            </button>
            <button type="reset">Reset</button>
            <button
              type="submit"
              disabled={!formik.isValid || formik.isSubmitting}
            >
              Submit
            </button>
            {/* <button type="submit" disabled={!(formik.dirty && formik.isValid)}>
              Submit
            </button> */}
          </Form>
        );
      }}
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

//custom inputs by using render props method

//(vid19)
//in ErrorMessage Component we can pass another components as props to render the jsx of the passed component
//and can also use render props method to display any jsx

//(vid20) Formik supports nested objects and arrays to store the data
//-- nested objects

//(vid21) -- arrays to store data

//(vid22) -- FieldArray Component - dynamic array fields component

//(vid23) -- FastField component -- used for performance optimization in case of multiple renderings
//fastfield component renders the field only once when there is an update

//(vid25) -- Specifying validation rule at field level

//(vid27) -- disabling form submit button
//by using formik.isValid and formik.dirty props
//formik.isValid -- checks for the error object in props to be a boolean value and change submit button accordingly
//formik.dirty -- checks the field is updated or not and returns a boolean value.
//better to use only formik.isValid to disable the submit button based on validity of error object in formik props

//(vid28) -- disabling submit button while submitting form

//(vid29) -- load saved data by creating savedValues object and creating a state to set the state value to null and at last create a button to load saved data and write a onClick button setFormData to savedValues
//at formik props render the initial values to saved values or initial values
//enableReinitialize in formik component props

//(vid30) -- Reset form data
//by creating a button with type reset
//by using onSubmitProps.resetForm() on onSubmit method while submitting the data
