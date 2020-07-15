import React from "react";

function CustomerRow(props){

    return (props.stateCustomer.map(d =>
                <tr key={d.id}> 
                    <th scope="row"> {d.id} </th>
                    <th> (d.name) </th>
                    <th> (d.dob)</th>
                    <th> (d.criditlimit)</th>

                </tr>
            ));
}

export default CustomerRow;