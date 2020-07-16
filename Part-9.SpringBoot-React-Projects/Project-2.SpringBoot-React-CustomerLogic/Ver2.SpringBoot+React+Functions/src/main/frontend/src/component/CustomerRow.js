import React from "react";
import {Link} from "react-router-dom";

function CustomerRow(props){


    return props.stateCustomer.map(d =>(
        <tr key={d.id}> 

            <td>
                <input type="checkbox" checked={d.select}
                onChange={e => {
                    let value = e.target.checked;
                    props.setCustomerState(
                        props.stateCustomer.map(sd=>{
                            if(sd.id==d.id){
                                sd.select = value;
                            }
                            return sd;
                        })
                    );
                }}/>
            </td>
            
            <th scope="row"> {d.id} </th>
            <td> {d.name} </td>
            <td> {d.dob}</td>
            <td>{d.criditlimit}</td>

            <td>
                <Link to={'edit/${d.id}'}>
               
                <button className="btn btn-primary btn-sm" > 
                    Edit
                </button>
                </Link>
            </td>

        </tr>
    ));
}

export default CustomerRow;