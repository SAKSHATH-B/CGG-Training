import { useChall } from "./useChall";

const link = "https://api.github.com/users/QuincyLarson";

export const Chall = () => {
  const person = useChall(link);
  //   console.log(data);
  const { data: user, isLoading, isError } = person;
  const { avatar_url, name, company, bio } = user;
  return (
    <div>
      {isLoading ? (
        <h2>Loading...</h2>
      ) : (
        <>
          <h1>Fetch Data</h1>
          <img src={avatar_url} alt="Image" />
          <h1>{name}</h1>
          <h2>Works At {company}</h2>
          <h3>{bio}</h3>
        </>
      )}
      {isError ? <h2>There is some error</h2> : ""}
    </div>
  );
};
