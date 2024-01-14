import React, { useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './IndexPage.css';
import { useAuth0 } from "@auth0/auth0-react";

const AuthButton = () => {
  const { isAuthenticated, loginWithRedirect, logout } = useAuth0();

  return isAuthenticated ? (
    <button onClick={() => logout({ returnTo: window.location.origin })}>
      Odjava
    </button>
  ) : (
    <button onClick={loginWithRedirect}>Prijava</button>
  );
};

const IndexPage = () => {

  const { isAuthenticated, loginWithRedirect, error } = useAuth0();
  console.log('Authentication Error:', error);

    useEffect(() => {
    // Set the metadata in the document head
    const setMetaTag = (name, content) => {
      let element = document.head.querySelector(`meta[name="${name}"]`);
      if (!element) {
        element = document.createElement('meta');
        element.setAttribute('name', name);
        document.head.appendChild(element);
      }
      element.setAttribute('content', content);
    };

    setMetaTag('description', 'Informacije o NBA igračima i njihovim timovima.');
    setMetaTag('author', 'Ian Balen');
    document.title = "NBA Baza Podataka";
  }, []);

  const downloadFile = async (fileType) => {
    try {
      const response = await axios.get(`http://localhost:8080/download/${fileType}`, {
        responseType: 'blob',
        params: {}
      });
      const blob = new Blob([response.data], { type: response.headers['content-type'] });
      const link = document.createElement('a');
      link.href = window.URL.createObjectURL(blob);
      link.download = `igraci.${fileType}`;
      link.click();
      window.URL.revokeObjectURL(link.href);
    } catch (error) {
      console.error('Error downloading file: ', error);
    }
  };

  return (
    <div className="index-container" style={styles.container}>
      {isAuthenticated ? (
        <>
          <AuthButton />
          <Link to="/profile" style={styles.linkStyle}>Profile</Link>
          <h1 style={styles.header}>Welcome to the NBA Player Database</h1>
          <div style={styles.buttonContainer}>
            <button onClick={() => downloadFile('csv')} style={styles.button}>Download CSV</button>
            <button onClick={() => downloadFile('json')} style={styles.button}>Download JSON</button>
          </div>
          <Link to="/database" style={styles.databaseLink}>Go to Database</Link>
          <div style={styles.readmeContainer}>
            <h2 style={styles.readmeHeader}>NBA Baza Podataka README</h2>
            <p style={styles.paragraph}><strong>Licenca:</strong> Creative Commons Zero v1.0 Universal (CC0 1.0)</p>
            <p style={styles.paragraph}><strong>Autor:</strong> Ian Balen</p>
            <p style={styles.paragraph}><strong>Verzija skupa podataka:</strong> 1.0</p>
            <p style={styles.paragraph}><strong>Jezik podataka:</strong> Hrvatski</p>
            <p style={styles.paragraph}><strong>Opis atributa:</strong></p>
            <dl style={styles.definitionList}>
                <dt style={styles.term}>ime</dt><dd style={styles.description}>Ime igrača</dd>
                <dt style={styles.term}>prezime</dt><dd style={styles.description}>Prezime igrača</dd>
                <dt style={styles.term}>pozicija</dt><dd style={styles.description}>Pozicija igrača</dd>
                <dt style={styles.term}>datumrodjenja</dt><dd style={styles.description}>Datum rođenja igrača</dd>
                <dt style={styles.term}>visina</dt><dd style={styles.description}>Visina igrača u centimetrima</dd>
                <dt style={styles.term}>tezina</dt><dd style={styles.description}>Težina igrača u kilogramima</dd>
                <dt style={styles.term}>brojdresa</dt><dd style={styles.description}>Broj dresa igrača</dd>
                <dt style={styles.term}>poenipoutakmici</dt><dd style={styles.description}>Prosečan broj poena po utakmici</dd>
                <dt style={styles.term}>nazivtima</dt><dd style={styles.description}>Ime tima kojem igrač pripada</dd>
                <dt style={styles.term}>grad</dt><dd style={styles.description}>Grad tima</dd>
                <dt style={styles.term}>pobjede</dt><dd style={styles.description}>Broj pobjeda tima</dd>
                <dt style={styles.term}>porazi</dt><dd style={styles.description}>Broj poraza tima</dd>
                </dl>
            <p style={styles.paragraph}><strong>Datum objavljivanja:</strong> 08.11.2023</p>
            <p style={styles.paragraph}><strong>Kontakt:</strong> ian.balen@fer.hr</p>
            <p style={styles.paragraph}><strong>Prostorna pokrivenost:</strong> Sjedinjene Američke Države</p>
            <p style={styles.paragraph}><strong>Učestalost ažuriranja:</strong> Godišnje</p>
            <p style={styles.paragraph}><strong>Tema:</strong> Sport, Košarka</p>
            <p style={styles.paragraph}><strong>Format datuma i vremena:</strong> ISO 8601</p>
            <div style={styles.distributionContainer}>
              <p style={styles.paragraph}><strong>Distribucija Skupa Podataka:</strong></p>
              <ul style={styles.list}>
                <li style={styles.listItem}>JSON Distribucija - JSON distribucija skupa podataka o NBA igračima i timovima, Medijska vrsta - application/json</li>
                <li style={styles.listItem}>CSV Distribucija - CSV distribucija NBA skupa podataka, Medijski tip - text/csv</li>
              </ul>
            </div>
            <div style={styles.versionHistoryContainer}>
              <p style={styles.paragraph}><strong>Povijest verzija skupa podataka:</strong></p>
              <table style={styles.table}>
                <thead>
                  <tr>
                    <th style={styles.tableHeader}>Verzija</th>
                    <th style={styles.tableHeader}>Datum izdavanja</th>
                    <th style={styles.tableHeader}>Promjene</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td style={styles.tableCell}>1.0</td>
                    <td style={styles.tableCell}>08.11.2023</td>
                    <td style={styles.tableCell}>Druga verzija skupa podataka</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          </>
    ) : (
      <div>
        <h1>Please log in to view the data</h1>
        <button onClick={loginWithRedirect}>Prijava</button>
      </div>
    ) }
  </div>
  );
    };
    
    const styles = {
        term: {
                fontWeight: 'bold',
                float: 'left',
                clear: 'left',
                width: '150px',
                textAlign: 'right',
                marginRight: '10px',
                paddingTop: '5px',
                paddingBottom: '5px',
              },
              description: {
                marginLeft: '160px', // this should be equal to the width of the term plus any margin
                paddingTop: '5px',
                paddingBottom: '5px',
              },
      container: {
        fontFamily: 'Arial, sans-serif',
        textAlign: 'center',
        maxWidth: '800px',
        margin: '0 auto',
        padding: '20px',
        color: '#333',
      },
      header: {
        marginBottom: '20px',
      },
      buttonContainer: {
        marginBottom: '20px',
      },
      button: {
        backgroundColor: '#4E73DF',
        color: 'white',
        border: 'none',
        borderRadius: '5px',
        padding: '10px 20px',
        margin: '0 10px',
        cursor: 'pointer',
      },
      databaseLink: {
        display: 'inline-block',
        backgroundColor: '#1CC88A',
        color: 'white',
        textDecoration: 'none',
        padding: '10px 20px',
        borderRadius: '5px',
        margin: '20px 0',
      },
      readmeContainer: {
        textAlign: 'left',
        borderTop: '2px solid #333',
        paddingTop: '20px',
        marginTop: '20px',
      },
      readmeHeader: {
        marginBottom: '10px',
      },
      paragraph: {
        lineHeight: '1.6',
        marginBottom: '10px',
      },
      distributionContainer: {
        marginBottom: '20px',
      },
      list: {
        listStyleType: 'none',
        paddingLeft: '0',
      },
      listItem: {
        marginBottom: '5px',
      },
      versionHistoryContainer: {
        marginTop: '20px',
      },
      table: {
        width: '100%',
        borderCollapse: 'collapse',
        marginTop: '10px',
      },
      tableHeader: {
        background: '#4E73DF',
        color: 'white',
        padding: '10px',
        borderBottom: '1px solid #ddd',
      },
      tableCell: {
        padding: '10px',
        borderBottom: '1px solid #ddd',
      },
    };
    
    export default IndexPage;
