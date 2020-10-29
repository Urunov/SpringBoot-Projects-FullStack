import logo from './logo.svg';
import './App.css';


import React from 'react';


import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';


import ListEmployeeComponents from './components/ListEmployeeComponents';
import HeaderComponents from './components/HeaderComponents';
import FooterComponents from './components/FooterComponents';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';


function App() {
  return (
    <div>
        <Router>
            <div className = "container">

              <HeaderComponents />
                <div className="container">
                {/* http://localhost:3000/employee */}
                 
                    <Switch>   http://localhost:3000/update-employee/
                     
                      <Route path="/" exact component={ListEmployeeComponents}/> 
                      <Route path="/employee" component={ListEmployeeComponents} /> 
                      <Route path="/add-employee" component={CreateEmployeeComponent}/>
                      <Route path="/update-employee/:id" component={UpdateEmployeeComponent}/>

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
