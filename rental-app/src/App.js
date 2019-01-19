import React, { Component } from 'react';
import './App.css';
import Dashboard from './dashboard/Dashboard.js';
import {BrowserRouter} from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <Dashboard></Dashboard>
      </BrowserRouter>
    );
  }
}

export default App;
