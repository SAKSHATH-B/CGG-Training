import React from "react";
import { Formik, Form } from "formik";
import * as Yup from "yup";
import FormikControl from "./FormikControl";

function FormikContainer() {
  const dropDownOptions = [
    { key: "select an Option", value: "" },
    { key: "Option 1", value: "option1" },
    { key: "Option 2", value: "option2" },
    { key: "Option 3", value: "option3" },
  ];
  const radioOptions = [
    { key: "Option 1", value: "rOption1" },
    { key: "Option 2", value: "rOption2" },
    { key: "Option 3", value: "rOption3" },
  ];
  const checkboxOptions = [
    { key: "Check 1", value: "cOption1" },
    { key: "Check 2", value: "cOption2" },
    { key: "Check 3", value: "cOption3" },
  ];
  const initialValues = {
    email: "",
    textarea: "",
    selectOption: "",
    radioOption: "",
    checkboxOption: [],
    birthDate: null,
  };
  const validationSchema = Yup.object({
    email: Yup.string().email("Invaid Email Format").required("Required!!"),
    textarea: Yup.string().required("Required!!"),
    selectOption: Yup.string().required("Required!!"),
    radioOption: Yup.string().required("Required!!"),
    checkboxOption: Yup.array().required("Required!!"),
    birthDate: Yup.date().required("Required!!").nullable(),
  });
  const onSubmit = (values) => console.log("Form Data", values);
  return (
    <Formik
      initialValues={initialValues}
      validationSchema={validationSchema}
      onSubmit={onSubmit}
    >
      <Form>
        <FormikControl
          control="input"
          type="email"
          label="Email"
          name="email"
        />
        <FormikControl control="textarea" label="Description" name="textarea" />
        <FormikControl
          control="select"
          label="Select a topic"
          name="selectOption"
          options={dropDownOptions}
        />
        <FormikControl
          control="radio"
          label="Radio Topic"
          name="radioOption"
          options={radioOptions}
        />
        <FormikControl
          control="checkbox"
          label="CheckBox Topics"
          name="checkboxOption"
          options={checkboxOptions}
        />
        <FormikControl control="date" label="Pick a Date" name="birthDate" />
        <button type="submit">Submit</button>
      </Form>
    </Formik>
  );
}

export default FormikContainer;
