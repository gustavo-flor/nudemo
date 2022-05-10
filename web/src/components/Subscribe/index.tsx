import React, { useState } from 'react';

import Button from '../Button';
import TextField from '../TextField';

import api from '../../services/api';

const Subscribe = () => {
  const [cpf, setCpf] = useState('');
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    
    try {
      const { status } = await api.post('/customers', { cpf, name, email });
      if (status === 202) {
        alert('Informações enviadas');
        return;
      }
    } catch (error) {
      console.error(error);
    }
    alert('Ops... estamos sofrendo uma instabilidade, tente novamente mais tarde!')
  }

  return (
    <section>
      <form onSubmit={handleSubmit}>
        <TextField 
          label='CPF'
          onChange={event => setCpf(event.target.value)} 
        />
        <TextField 
          label='Nome completo'
          onChange={event => setName(event.target.value)} 
        />
        <TextField 
          label='E-mail'
          type='email'
          onChange={event => setEmail(event.target.value)} 
        />
        <Button className='flex items-center justify-between'>
          Enviar 
        </Button>
      </form>
    </section>
  );
}

export default Subscribe;
