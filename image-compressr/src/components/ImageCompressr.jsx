import React, { useState } from "react";
import { Card } from "react-bootstrap";
import imageCompression from "browser-image-compression";

const ImageCompressr = () => {
  const [compressedLink, setCompressedLink] = useState("");
  const [originalImage, setOriginalImage] = useState(null);
  const [originalLink, setOriginalLink] = useState("");
  const [clicked, setClicked] = useState(false);
  const [uploadImage, setUploadImage] = useState(false);
  const [outputFileName, setOutputFileName] = useState("");
  const [compressedImage, setCompressedImage] = useState(null);

  const handleUpload = (e) => {
    const imageFile = e.target.files[0];
    setOriginalLink(URL.createObjectURL(imageFile));
    setOriginalImage(imageFile);
    setOutputFileName(imageFile.name);
    setUploadImage(true);
  };

  const handleClick = (e) => {
    e.preventDefault();

    const options = {
      maxSizeMB: 1,
      maxWidthOrHeight: 500,
      useWebWorker: true,
    };

    if (options.maxSizeMB >= originalImage.size / 1024) {
      alert("Image is too small, can't be Compressed!");
      return;
    }

    imageCompression(originalImage, options).then((compressedImage) => {
      const downloadLink = URL.createObjectURL(compressedImage);
      setCompressedLink(downloadLink);
      setClicked(true);
      setCompressedImage(compressedImage);
    });
  };

  return (
    <div className="container">
      <h1 className="text-white py-2">Image-size-compressor</h1>
      <div className="row mt-5 text-white">
        <div className="first col-xl-4 col-lg-4 col-md-12 col-sm-12">
          {uploadImage ? (
            <Card.Img src={originalLink} className="ht" variant="top" />
          ) : (
            "Upload Image"
          )}
          <div className="justify-content-center d-flex">
            <input
              type="file"
              accept="image/*"
              className="mt-2 btn btn-outline-primary btn-dark "
              onChange={(e) => handleUpload(e)}
            />
          </div>
          <h5 className="text-danger">
            {originalImage && (originalImage.size / 1024).toFixed(0) + "KB"}
          </h5>
        </div>

        <div className="second col-xl-4 col-lg-4 col-md-12 mb-5 mt-5 col-sm-12 d-flex justify-content-center align-items-baseline">
          <br />
          {outputFileName && (
            <button
              type="button"
              className="btn btn-dark"
              onClick={(e) => handleClick(e)}
            >
              Compress
            </button>
          )}
        </div>

        <div
          className={`third col-xl-4 col-lg-4 col-md-12 col-sm-12 mt-3 ${
            clicked && "active"
          }`}
        >
          <Card.Img variant="top" src={compressedLink} />
          {clicked && (
            <div className="d-flex justify-content-center">
              <a
                href={compressedLink}
                download={outputFileName}
                className="mt-2 btn btn-dark btn-outline-primary w-75"
              >
                Download
              </a>
            </div>
          )}
          <h5 className="text-success">
            {compressedImage && (compressedImage.size / 1024).toFixed(0) + "KB"}
          </h5>
        </div>
      </div>
    </div>
  );
};

export default ImageCompressr;
