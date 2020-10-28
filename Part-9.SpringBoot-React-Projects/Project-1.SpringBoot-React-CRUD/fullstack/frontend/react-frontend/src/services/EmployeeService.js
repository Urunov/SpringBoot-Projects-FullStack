import axios from 'axios';

const EMPLOYEE_API_BASE_URL="http://localhost:8080/api/v1/employee";

class EmployeeService{

    getEmployees(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }
    
}

export default new EmployeeService();