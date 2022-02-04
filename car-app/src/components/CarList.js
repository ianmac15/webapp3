import { Component } from "react";
import { Button, ButtonGroup, Container, Table } from 'reactstrap'
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class CarList extends Component {

    constructor(props) {
        super(props);
        this.state = { cars: [] }
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('api/car')
            .then(response => response.json())
            .then(data => this.setState({ clients: data }));
    }

    async remove(id) {
        await fetch(`api/car/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCars = [...this.state.cars].filter(i => i.id !== id);
            this.setState({ clients: updatedCars });
        });
    }

}

export default CarList;