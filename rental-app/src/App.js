import React, { Component } from 'react';
import './App.css';
import Dashboard from './dashboard/Dashboard.js';
import {HashRouter} from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <HashRouter>
        <Dashboard></Dashboard>
      </HashRouter>
    );
  }
}

export default App;
