import logo from './logo.svg';
import './App.css';


import React from 'react';


import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';


import ListEmployeeComponents from './components/ListEmployeeComponents';
import HeaderComponents from './components/HeaderComponents';
import FooterComponents from './components/FooterComponents';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';


function App() {
  return (
    <div>
        <Router>
            <div className = "container">

              <HeaderComponents />
                <div className="container">
                {/* http://localhost:3000/employee */}
                 
                    <Switch>   http://localhost:3000/employee/add-employee
                     
                      <Route path="/" exact component={ListEmployeeComponents}/> 
                      <Route path="/employee" component={ListEmployeeComponents} /> 
                      <Route path="/add-employee" component={CreateEmployeeComponent}/>
                           {/* <ListEmployeeComponents />  */}
                    </Switch>   
                </div>
              <FooterComponents />
            </div>
      </Router>
    </div>

   
  );
}

export default App;
