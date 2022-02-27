import logo from './logo.svg';
import './App.css';
import { Component } from 'react';

class App extends Component {
  state = {
    cars: []
  };

  async componentDidMount() {
    const response = await fetch('cars');
    const body = await response.json();
    this.setState({ cars: body });
  }
  
  render() {
    return (
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
              this.state.cars.map(
                car =>
                  <tr key={car.id}>
                    <td> {car.id}</td>
                    <td> {car.brand}</td>
                    <td> {car.model}</td>
                    <td> {car.colour}</td>
                  </tr>
              )
            }
          </tbody>

        </table>
      </div>
    )
  }
}
export default App;
