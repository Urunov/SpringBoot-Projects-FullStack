import logo from './logo.svg';
import './App.css';

import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import ListEmployeeComponents from './components/ListEmployeeComponents';
import HeaderComponents from './components/HeaderComponents';
import FooterComponents from './components/FooterComponents';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';
import ViewEmployeeComponent from './components/ViewEmployeeComponent';
// import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';
// import ViewEmployeeComponent from './components/ViewEmployeeComponent';


function App() {
  return (
    <div>
        <Router>
            <div className = "container">

              <HeaderComponents />
                <div className="container">   
                    <Switch> localhost:3000/update-employee/1
        
                       <Route path="/" exact component={ListEmployeeComponents}/> 
                       <Route path="/employees" component={ListEmployeeComponents}/> 
                       <Route path="/add-employee" component={CreateEmployeeComponent}/>
                       <Route path="/update-employee/:id" component={UpdateEmployeeComponent}/>
                       <Route path="/view-employee/:id" component={ViewEmployeeComponent}/>
                    </Switch>   
                </div>
              <FooterComponents />
            </div>
      </Router>
    </div>

   
  );
}

export default App;
