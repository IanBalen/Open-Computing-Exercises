import React from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './IndexPage.css';


const IndexPage = () => {
  // Function to download files would go here, similar to your Database component
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
  return (
    <div className="index-container">
      <h1>Welcome to the NBA Player Database for Open Computing</h1>
      <button onClick={() => downloadFile('csv')}>Download CSV</button>
      <button onClick={() => downloadFile('json')}>Download JSON</button>
      <Link to="/database">Go to Database</Link>
    </div>
  );
};

export default IndexPage;
