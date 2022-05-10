import React, { useEffect } from 'react';

import Menu from '../../components/Menu';
import Subscribe from '../../components/Subscribe';

const Home = () => {
  useEffect(() => {
    document.title = 'Nudemo | Tudo que você precisa para receber, movimentar e guardar seu dinheiro.'
  }, []);
  
  return (
    <>
      <Menu />
      <Subscribe />
    </>
  );
}

export default Home;
