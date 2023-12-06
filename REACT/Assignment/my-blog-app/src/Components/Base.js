const Base = ({ title = "Welcome to this Blog App", children }) => {
  return (
    <div className="container-fluid p-0 m-0">
      <h1>{title}</h1>
      {children}
      <h3>--- Footer ---</h3>
    </div>
  );
};

export default Base;
