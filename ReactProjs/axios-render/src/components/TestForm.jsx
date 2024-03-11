import React, { useEffect, useState } from "react";

const initBeforeUnload = (showExitPrompt) => {
  window.onbeforeunload = (event) => {
    if (showExitPrompt) {
      const e = event || window.event;
      e.preventDefault();
      if (e) {
        e.returnValue = "";
      }
      return "";
    }
  };
};

const TestForm = () => {
  //   useEffect(() => {
  //     const handleBeforeUnload = (e) => {
  //       e.preventDefault();
  //       window.alert("hello");
  //       window.confirm("Are you sure that you want to leave the page ?");
  //       //   window.location.href = "/red";
  //     };

  //     window.addEventListener("beforeunload", handleBeforeUnload);

  //     return () => {
  //       window.removeEventListener("beforeunload", handleBeforeUnload);
  //     };
  //   }, []);

  const [showExitPrompt, setShowExitPrompt] = useState(false);

  useEffect(() => {
    initBeforeUnload(showExitPrompt);

    const handleUnload = () => {
      if (showExitPrompt) {
        console.log("not running");
        window.history.pushState({}, "", "/red");
      }
    };

    window.addEventListener("unload", handleUnload);

    return () => {
      window.removeEventListener("unload", handleUnload);
      window.onbeforeunload = null;
    };
  }, [showExitPrompt]);

  return (
    <div
      onMouseDown={() => false}
      onPaste={(e) => {
        e.preventDefault();
        return false;
      }}
      onCopy={(e) => {
        e.preventDefault();
        return false;
      }}
      onCut={(e) => {
        e.preventDefault();
        return false;
      }}
      onDrag={(e) => {
        e.preventDefault();
        return false;
      }}
      onDrop={(e) => {
        e.preventDefault();
        return false;
      }}
      style={{ userSelect: "none" }}
      autoComplete="off"
    >
      <h1>Page with Unsaved Changes Prompt</h1>
      <p>Perform any action to trigger the beforeunload event.</p>
      <button onClick={() => setShowExitPrompt(true)}>
        Enable Exit Prompt
      </button>
      <button onClick={() => setShowExitPrompt(false)}>
        Disable Exit Prompt
      </button>
    </div>
  );
};

export default TestForm;
