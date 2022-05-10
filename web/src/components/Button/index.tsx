import React from 'react';

interface Props extends React.DetailedHTMLProps<React.ButtonHTMLAttributes<HTMLButtonElement>, HTMLButtonElement> {
}

const Button = ({ children, ...rest }: Props) => {
  return (
    <button {...rest}>{children}</button>
  );
}

export default Button;
