import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';

class ListEmployeeComponents extends Component {

    constructor(props){
        super(props) 

        this.state = {
            employee: []
        }

        this.addEmployee = this.addEmployee.bind(this);
        this.editEmployee = this.editEmployee.bind(this);
        this.deleteEmployee = this.deleteEmployee.bind(this);

    }

    deleteEmployee(id) {
        EmployeeService.deleteEmployee(id).then( res => {
            this.setState({employee: this.state.employee.filter(employee => employee.id !== id)})
        });
    }

    viewEmployee(id){
        this.props.history.push(`/view-employee/${id}`);
    }

    componentDidMount(){
        EmployeeService.getEmployees().then((res) => 
        { 
            this.setState({ employee: res.data});
        });
    }

    addEmployee(){
        this.props.history.push('/add-employee/_add');
    }

    editEmployee(id){
        this.props.history.push(`/update-employee/${id}`)
    }


    render() {
        return (
            <div>
        
                <h2 className="text-center"> Employee List</h2>

                <div className= "row">
                    <button className="btn btn-primary" onClick={this.addEmployee}> Add Employee </button>
                </div>

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

                                    <td>
                               
                               
                                    <button onClick = { () => this.editEmployee(employee.id)} className="btn btn-info"> Update</button>
                                    <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEmployee(employee.id)} className="btn btn-danger">Delete </button>
                                    <button style={{marginLeft: "10px"}} onClick={ () => this.viewEmployee(employee.id)} className="btn btn-info">View </button>
                                    </td>
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