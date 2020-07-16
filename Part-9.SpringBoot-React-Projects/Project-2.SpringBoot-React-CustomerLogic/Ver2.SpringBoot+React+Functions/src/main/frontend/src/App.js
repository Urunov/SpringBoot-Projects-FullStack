
import React from 'react';
import Header from "./layout/header/Header";
import Customer from "./component/Customer";
import CustomerRow from './component/CustomerRow';
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import AddCustomer from "./component/customer/AddCustomer/AddCustomer";
import EditCustomer from "./component/EditCustomer/EditCustomer";
function App(){
  return (
    <div>
  
    <Router>
        <Header />

        <Switch>
          <Router exact path="/">
             <Customer />
          </Router>
         
          <Router exact path="/save">
             <AddCustomer />
          </Router>

          <Router exact path="/edit/:id">
             <EditCustomer />
          </Router>
        </Switch>
       
     </Router>  

    </div>
  );

}

export default App;
