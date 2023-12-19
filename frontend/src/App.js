// App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Database from './Database';
import IndexPage from './IndexPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/database" element={<Database />} />
        <Route path="/" element={<IndexPage />} />
      </Routes>
    </Router>
  );
}

export default App;
