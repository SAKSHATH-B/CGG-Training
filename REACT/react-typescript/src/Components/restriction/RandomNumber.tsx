type RandomNumberType = {
  value: number;
};

type PositiveNumber = RandomNumberType & {
  isPositive: boolean;
  isNegative?: never;
  isZero?: never;
};
type NegativeNumber = RandomNumberType & {
  isPositive?: never;
  isNegative: boolean;
  isZero?: never;
};
type isZero = RandomNumberType & {
  isPositive?: never;
  isNegative?: never;
  isZero: boolean;
};

export const RandomNumber = ({
  value,
  isPositive,
  isNegative,
  isZero,
}: PositiveNumber | NegativeNumber | isZero) => {
  return (
    <div>
      {value} {isPositive && "Positive"} {isNegative && "Negative"}{" "}
      {isZero && "Zero"}
    </div>
  );
};
