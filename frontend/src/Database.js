import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './Database.css'; // Make sure you have your styles defined in Database.css

const Database = () => {
  // Existing state definitions
  const [inputValue, setInputValue] = useState('');
  const [dropdownValue, setDropdownValue] = useState('');
  const [data, setData] = useState([]);
  const [showDateFormat, setShowDateFormat] = useState(false);
  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage, setItemsPerPage] = useState(10);

  // Existing event handlers
  const handleInputChange = (e) => {
    setInputValue(e.target.value);
  };

  // Update the dropdown handler to check for the "Datum Rođenja" selection
  const handleDropdownChange = (e) => {
    const value = e.target.value;
    setDropdownValue(value);
    // Set the flag to true if "Datum Rođenja" is selected, otherwise false
    setShowDateFormat(value === "datumrodjenja");
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
  // New logic for pagination
  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentItems = data.slice(indexOfFirstItem, indexOfLastItem);

  // New useEffect hook to reset page to 1 when data changes
  useEffect(() => {
    fetchData(inputValue, dropdownValue);
  }, [inputValue, dropdownValue]);
  // Existing useEffect for fetching data on mount here...

  // Existing return statement with added pagination logic
  return (
    <div className="container">
      <Link to="/">Back to Home</Link>
      <input
        type="text"
        value={inputValue}
        onChange={handleInputChange}
        placeholder={showDateFormat ? "dd.MM.yyyy" : ""}
      />
      <select value={dropdownValue} onChange={handleDropdownChange}>
        <option value="">Odaberite polja za pretragu</option>
        <option value="">Sva pola(wildcard)</option>
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
      {showDateFormat && (
        <p className="date-format-message">
          Please enter the date in the format: dd.MM.yyyy
        </p>
      )}
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
          {currentItems.map((item, index) => (
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
      <div className="pagination">
        {Array.from({ length: Math.ceil(data.length / itemsPerPage) }, (_, index) => (
          <button
            key={index}
            onClick={() => setCurrentPage(index + 1)}
            className={currentPage === index + 1 ? 'active' : ''}
          >
            {index + 1}
          </button>
        ))}
      </div>
    </div>
  );
};

export default Database;
