const heading = {
  fontSize: "72px",
  color: "blue",
};
const Inline = () => {
  return (
    <div>
      <h1 className="error">ERROR</h1>
      <h1 style={heading}>INLINE</h1>
      {/* <h1 className={styles.success}>SUCCESS</h1> */}
    </div>
  );
};

export default Inline;
