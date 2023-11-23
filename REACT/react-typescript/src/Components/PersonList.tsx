type personListProps = {
  names: {
    firstName: string;
    lastName: string;
  }[];
};

export const PersonList = (props: personListProps) => {
  return (
    <div>
      {props.names.map((name) => {
        return (
          <h4>
            {name.firstName} {name.lastName}
          </h4>
        );
      })}
    </div>
  );
};
