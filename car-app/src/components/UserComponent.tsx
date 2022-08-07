import React from "react";
import UserService from "../service/UserService";

class UserComponent extends React.Component{
    
    constructor(props) {
        super(props)
        this.state = {
            users:[]
        }
    }

    componentDidMount() {
        UserService.getUsers.then((response) => {
            this.setState({users:response.data})
        });
    }

    render() {
        return(
            <div>
                <h1 className="text-center">Cars List</h1>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td> Car Id</td>
                            <td> Car Brand</td>
                            <td> Car Model</td>
                            <td> Car Colour</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.users.map(
                                user =>
                                <tr key = {user.id}>
                                    <td> {user.id}</td>
                                    <td> {user.brand}</td>
                                    <td> {user.model}</td>
                                    <td> {user.colour}</td> 
                                </tr>
                            )
                        }
                    </tbody>

                </table>
            </div>
        )
    }
}

export default UserComponent