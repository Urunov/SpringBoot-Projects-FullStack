import React from 'react'
import { Route } from 'react-router-dom';
import axios from "axios";

function EditCustomer() {

   
    return (
        <div className="container my-3">
            <form 
                onSubmit={e => {
                e.preventDefault();
                
                }}
            > 
                <div className="form-group">
                    <label>Name</label>
                    <input type="text" className="form-control" />
                </div>
                <div className="form-group">
                    <label >DOB</label>
                    <input type="text" className="form-control" />
                </div>
                <div className="form-group">
                    <label>CreditLimit</label>
                    <input type="text" className="form-control" />
                </div>

                <button type="submit" className="btn btn-primary btn-sm"> Submit</button>
            </form>
        </div>
    );
}

export default EditCustomer;
