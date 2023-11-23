import React, { useEffect, useState } from "react";

export const MultipleReturnsBasics = () => {
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    setTimeout(() => {
      //   console.log("first");
      setIsLoading(false);
    }, 3000);
  }, []);

  if (isLoading) {
    return <div>Loading...</div>;
  }
  return <div>MultipleReturnsBasics</div>;
};
