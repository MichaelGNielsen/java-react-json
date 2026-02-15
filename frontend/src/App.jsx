import { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
  const [users, setUsers] = useState([]);
  const [name, setName] = useState('');

  useEffect(() => {
    axios.get('/api/users').then(res => setUsers(res.data));
  }, []);

  const addUser = () => {
    if (!name.trim()) return;
    axios.post('/api/users', { name, email: `${name}@test.dk` })
         .then(res => {
           setUsers([...users, res.data]);
           setName('');
         });
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h1>Java + React – gemt i <code>users.json</code></h1>
      <p><strong>Backend:</strong> http://localhost:8080</p>
      <p><strong>Frontend:</strong> {window.location.origin}</p>
      <hr />
      <input
        value={name}
        onChange={e => setName(e.target.value)}
        onKeyPress={e => e.key === 'Enter' && addUser()}
        placeholder="Indtast navn"
        style={{ padding: '8px', fontSize: '16px' }}
      />
      <button onClick={addUser} style={{ padding: '8px 16px', marginLeft: '8px' }}>
        Tilføj bruger
      </button>
      <h2>Brugere:</h2>
      <ul>
        {users.map(u => (
          <li key={u.id}><strong>{u.name}</strong> – {u.email}</li>
        ))}
      </ul>
      <p><em>Data gemmes i <code>users.json</code> – overlever genstart!</em></p>
    </div>
  );
}

export default App;
