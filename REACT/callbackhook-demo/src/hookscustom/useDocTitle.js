import { useEffect } from "react";

export const useDocTitle = (count) => {
  useEffect(() => {
    document.title = `${count} - Count`;
  }, [count]);
};
