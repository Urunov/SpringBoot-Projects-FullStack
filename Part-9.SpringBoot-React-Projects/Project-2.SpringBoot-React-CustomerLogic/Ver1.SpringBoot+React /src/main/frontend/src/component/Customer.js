import React, {useState, useEffect} from "react";
import axios from "axios";
import CustomerRow from "./CustomerRow";



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

    return (
        <div>
          <table className="table">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">LastName</th>
                <th scope="col">CreditLimitation</th>
                </tr>
            </thead>
                <tbody>
                    {stateCustomer.map(d => (
                        <tr key={d.id}>
                        <th scope="col">{d.id}</th>
                        <td>{d.name}</td>
                        <td>{d.dob}</td> 
                        <td>{d.criditlimit}</td>
                        </tr>
                    ))}
                   
                </tbody>
            </table> 
    </div> 
    
    );
}




export default Customer;