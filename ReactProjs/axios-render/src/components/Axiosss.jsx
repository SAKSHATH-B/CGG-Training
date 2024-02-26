import React, { useEffect, useState } from "react";
import axios from "axios";

const Axiosss = () => {
  const [data, setData] = useState(null);
  const [imageId, setImageId] = useState(0);
  const fetchData = async () => {
    try {
      const response = await axios.get(
        "https://dog.ceo/api/breeds/image/random"
      );
      console.log(response);
      setData(response.data.message);
      if (response.data.message != null) {
        setImageId((prev) => prev + 1);
      }
    } catch (error) {
      console.log("error fetching data : ", error);
    }
  };

  useEffect(() => {
    const interval = setInterval(fetchData, 2000);

    return () => clearInterval(interval);
  }, []);

  return (
    <div>
      {data ? (
        <>
          <h1>My Api Images</h1>
          <img className="image" src={data} alt="not found" />
          <h2>{imageId} images fetched...</h2>
        </>
      ) : (
        <h1>Loading...</h1>
      )}
    </div>
  );
};

export default Axiosss;
