import React, { useEffect } from 'react';
import { Link } from 'react-router-dom';

import Menu from '../../components/Menu';

const NotFound = () => {
  useEffect(() => {
    document.title = 'Nudemo | Página não encontrada'
  }, []);

  return (
    <>
      <Menu />
      <main>
        <h1>Página não encontrada</h1>
        <Link to='/'>Voltar para o início</Link>
      </main>
    </>
  );
}

export default NotFound;
