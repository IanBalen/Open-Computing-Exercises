// In a file named `MyComponent.js`
import React, { useState } from 'react';
import axios from 'axios';

const MyComponent = () => {
  // State to store input value
  const [inputValue, setInputValue] = useState('');
  // State to store dropdown value
  const [dropdownValue, setDropdownValue] = useState('');
  // State to store data from backend
  const [data, setData] = useState([]);

  // Event handler for the input field
  const handleInputChange = (e) => {
    setInputValue(e.target.value);
  };

  // Event handler for the dropdown
  const handleDropdownChange = (e) => {
    setDropdownValue(e.target.value);
  };



  // Function to fetch data from the backend
  const fetchData = async (searchText, attribute) => {
    try {
      const response = await axios.get('http://localhost:8080/player', {
        params: { searchText, attribute }
      });
      setData(response.data);
    } catch (error) {
      console.error('Error fetching data: ', error);
      // Handle error appropriately
    }
  };

  // Function to call the backend to download files
  const downloadFile = async (fileType, searchText, attribute) => {
    try {
      const response = await axios.get(`http://localhost:8080/download/${fileType}`, {
        responseType: 'blob', // Important for files like PDF, images, etc.
        params: {searchText, attribute}
      });
      // Create a new Blob object
      const blob = new Blob([response.data], { type: response.headers['content-type'] });
      // Create a link to download the blob
      const link = document.createElement('a');
      link.href = window.URL.createObjectURL(blob);
      link.download = `igraci.${fileType}`;
      link.click();
      window.URL.revokeObjectURL(link.href); // Clean up the URL object
    } catch (error) {
      console.error('Error downloading file: ', error);
      // Handle error appropriately
    }
  };

  // Effect to fetch data on component mount
  React.useEffect(() => {
    fetchData();
  }, []);

  return (
    <div>
      <input type="text" value={inputValue} onChange={handleInputChange} />
      <select value={dropdownValue} onChange={handleDropdownChange}>
        <option value="">Select...</option>
        <option value="ime">Ime</option>
        <option value="prezime">Prezime</option>
        <option value="pozicija">Pozicija</option>
        <option value="datumrodjenja">Datum Rođenja</option>
        <option value="visina">Visina</option>
        <option value="tezina">Težina</option>
        <option value="brojdresa">Broj Dresa</option>
        <option value="poenipoutakmici">Poeni po Utakmici</option>
        <option value="nazivtima">Naziv Tima</option>
        <option value="grad">Grad</option>
        <option value="pobjede">Pobjede</option>
        <option value="porazi">Porazi</option>
      </select>
      <button type="button" onClick={() => fetchData(inputValue, dropdownValue)}>Filter</button>
      <button onClick={() => downloadFile('json', inputValue, dropdownValue)}>Download JSON</button>
      <button onClick={() => downloadFile('csv', inputValue, dropdownValue)}>Download CSV</button>
      <table>
        <thead>
          <tr>
            <th>Ime</th>
            <th>Prezime</th>
            <th>Pozicija</th>
            <th>Datum Rođenja</th>
            <th>Visina</th>
            <th>Težina</th>
            <th>Broj Dresa</th>
            <th>Poeni po Utakmici</th>
            <th>Naziv Tima</th>
            <th>Grad</th>
            <th>Pobjede</th>
            <th>Porazi</th>
        </tr>
        </thead>
        <tbody>
          {data.map((item, index) => (
            <tr key={index}>
              <td>{item.ime}</td>
              <td>{item.prezime}</td>
              <td>{item.pozicija}</td>
              <td>{item.datumrodjenja}</td>
              <td>{item.visina} cm</td>
              <td>{item.tezina} kg</td>
              <td>{item.brojdresa}</td>
              <td>{item.poenipoutakmici}</td>
              <td>{item.nazivtima}</td>
              <td>{item.grad}</td>
              <td>{item.pobjede}</td>
              <td>{item.porazi}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default MyComponent;
