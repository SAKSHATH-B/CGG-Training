import React, { useState, useEffect } from "react";

export const useChall = (url) => {
  const [isLoading, setIsLoading] = useState(true);
  const [isError, setIsError] = useState(false);
  const [data, setData] = useState("");

  useEffect(() => {
    fetch(url)
      .then((res) => res.json(), setIsLoading(false))
      .then((res) => setData(res))
      .catch(() => setIsError(true));
  }, []);
  return { isLoading, isError, data };
};
