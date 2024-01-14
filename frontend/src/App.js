import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { Auth0Provider } from "@auth0/auth0-react";
import Database from './Database';
import IndexPage from './IndexPage';
import Profile from './Profile'; 

function App() {
  return (
    <Auth0Provider
    domain="dev-a2gpessya2fdrqqk.us.auth0.com"
    clientId="UZ0fFS7n0RGJ8cs5xu4UlY2HI8hg6HoF"
    authorizationParams={{ redirect_uri: window.location.origin }}
    >
      <Router>
        <Routes>
          <Route path="/database" element={<Database />} />
          <Route path="/" element={<IndexPage />} />
          <Route path="/profile" element={<Profile />} />

        </Routes>
      </Router>
    </Auth0Provider>
  );
}

export default App;
