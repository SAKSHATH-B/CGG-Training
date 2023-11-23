type greet = {
  name: string;
  minutes?: number;
  isLoggedIn: boolean;
};
export const Greet = (props: greet) => {
  const { minutes = 0 } = props;
  return (
    <div>
      {props.isLoggedIn
        ? `Hello ${props.name} you are here to learn React with Typescript you have
      spent ${minutes} minutes of time in this page`
        : "Welcome Guest"}
    </div>
  );
};
