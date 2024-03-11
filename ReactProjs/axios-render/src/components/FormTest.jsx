import React, { useEffect, useState } from "react";

const FormTest = () => {
  const [unsavedChanges, setUnsavedChanges] = useState(false);

  useEffect(() => {
    const handleBeforeUnload = (e) => {
      if (unsavedChanges) {
        const message =
          "Are you sure you want to leave? All unsaved changes will be lost.";
        e.returnValue = message;
        return message;
      }
    };

    window.addEventListener("beforeunload", handleBeforeUnload);

    return () => {
      window.removeEventListener("beforeunload", handleBeforeUnload);
    };
  }, [unsavedChanges]);

  const handleInputChange = () => {
    setUnsavedChanges(true);
  };

  const handleFormSubmit = () => {
    setUnsavedChanges(false);
    // Add logic to submit the form or save changes
  };

  return (
    <div>
      <h1>Page with Unsaved Changes Prompt</h1>
      <form onSubmit={handleFormSubmit}>
        <input type="text" onChange={handleInputChange} />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default FormTest;
