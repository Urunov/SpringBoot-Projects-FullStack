import React, {useState, useEffect} from "react";
import axios from "axios";
import CustomerRow from "./CustomerRow";
import {Link} from "react-router-dom";

function Customer(){
    
   const[stateCustomer, setCustomerState] = useState([]);

    useEffect(() => {
       getCustomer();
      // console.log("id");
    }, []);


    const getCustomer = () => {
        axios 
        .get("http://localhost:8080/customers")
        .then(data=> {
            setCustomerState(data.data);
           //console.log(data);
        }).catch(err => alert(err));
    };

    const sendTest=() => {
        console.log("Tess");
    };

    return (

        <div>

            <Link to="/save">        
              <button className="btn btn-primary btn-sm m-2"> Add Customer </button>
            </Link>

          <table className="table">
            <thead>
                <tr>
                <td scope="col"> Select </td>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">LastName</th>
                <th scope="col">CreditLimitation</th>
                <th scope="col">    Edit     </th>

                </tr>
            </thead>
                <tbody>
                
                   <CustomerRow stateCustomer={stateCustomer} sendTest={sendTest}/>
                </tbody>
            </table> 
    </div> 
    
    );
}




export default Customer;