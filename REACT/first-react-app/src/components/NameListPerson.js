export const NameListPerson = ({ person }) => {
  return (
    <h2>
      I am Working in {person.company} of type {person.type} with ID.{person.id}
    </h2>
  );
};
