import React, { Component } from 'react';

class ListEmployeeComponents extends Component {

    constructor(props){
        super(props) 

        this.state = {
            employee: []
        }
    }



    render() {
        return (
            <div>
        
                <h2 className="text-center"> Employee List</h2>

                <div className = "row" >
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th>First Name: </th>
                                <th>Last Name: </th>
                                <th>Email ID: </th>
                                <th> Actions</th>
                            </tr>
                        </thead>

                    <tbody>
                        {
                            this.state.employee.map(
                                employee =>
                                <tr key = {employee.id}>
                                    <td>    {employee.firstName}             </td>
                                    <td>    {employee.lastName}             </td>
                                    <td>    {employee.emailId}             </td>
                                </tr>
                            )
                        }
                    </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ListEmployeeComponents;