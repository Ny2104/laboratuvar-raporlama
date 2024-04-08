import { useState } from 'react';
import Rapor from './components/Rapor';
import './App.css';

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <div>
        <Rapor />
      </div>
    </>
  );
}

export default App;


