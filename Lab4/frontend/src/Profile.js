import React from 'react';
import { useAuth0 } from "@auth0/auth0-react";

const Profile = () => {
  const { user } = useAuth0();
  console.log(user);

  return (
    <div>
      <h2>Profile</h2>
      <p>Name: {user.name}</p>
      <p>Email: {user.email}</p>
      <p>Picture: {user.picture}</p>
      <p>Updated At: {user.updated_at}</p>
    </div>
  );
};

export default Profile;
