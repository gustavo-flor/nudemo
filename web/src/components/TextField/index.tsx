import React, { useRef } from 'react';

interface Props extends React.DetailedHTMLProps<React.InputHTMLAttributes<HTMLInputElement>, HTMLInputElement> {
  label: string;
  type?: 'text' | 'email'
}

const TextField = ({ label, type = 'text', ...rest }: Props) => {
  const inputRef = useRef<HTMLInputElement>(null!);

  return (
    <fieldset>
      <label onClick={() => inputRef.current.focus()}>
        {label}
      </label>
      <input 
        {...rest} 
        ref={inputRef} 
        type={type}
      />
    </fieldset>
  );
}

export default TextField;
