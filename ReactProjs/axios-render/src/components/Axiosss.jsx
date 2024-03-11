import React, { useEffect, useState } from "react";
import axios from "axios";

const Axiosss = () => {
  const [data, setData] = useState(null);
  const [imageId, setImageId] = useState(0);
  // const fetchData = async () => {
  //   try {
  //     const response = await axios.get("www.google.com");
  //     console.log(response);
  //     setData(response.data.message);
  //     if (response.data.message != null) {
  //       setImageId((prev) => prev + 1);
  //     }
  //   } catch (error) {
  //     console.log("error fetching data : ", error);
  //   }
  // };

  // useEffect(() => {
  //   const interval = setInterval(fetchData, 2000);

  //   return () => clearInterval(interval);
  // }, []);

  useEffect(() => {
    console.log("running");

    const handleBeforeUnload = (e) => {
      // e.preventDefault();
      const message = "Are you sure you want to leave?";
      e.returnValue = message;
      return message;
    };

    window.addEventListener("beforeunload", handleBeforeUnload);
    return () => {
      window.removeEventListener("beforeunload", handleBeforeUnload);
    };
  }, []);

  return (
    <div>
      {/* {data ? (
        <>
          <h1>My Api Images</h1>
          <img className="image" src={data} alt="not found" />
          <h2>{imageId} images fetched...</h2>
        </>
      ) : (
        <h1>Loading...</h1>
      )} */}

      <iframe
        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3806.478368956399!2d78.3619046!3d17.4368035!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bcb939349c938ad%3A0x434cf5a44aeadf7b!2sCentre%20for%20Good%20Governance!5e0!3m2!1sen!2sin!4v1709034538926!5m2!1sen!2sin"
        width="600"
        height="450"
        style={{ border: 0 }}
        allowFullScreen=""
        loading="lazy"
        referrerPolicy="no-referrer-when-downgrade"
      ></iframe>
    </div>
  );
};

export default Axiosss;

// https://dog.ceo/api/breeds/image/random
