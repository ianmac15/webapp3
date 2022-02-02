import React from "react";
import UserService from "../service/UserService";

class UserComponent extends React.Component{
    
    constructor() {
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
                
            </div>
        )
    }
}

export default UserComponent