import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link, BrowserRouter
} from "react-router-dom";
import Home from "./Home"

class States extends Component {
    constructor() {
        super();
        this.state = {
            count: 0
        };
    }

    increment = () => {
        this.setState({count: this.state.count + 1});
    }

    decrease = () => {
        this.setState({count: this.state.count - 1});
    }

    render() {
        return (
            <div>
                <h2>Golden Acorn application with states</h2>
                <button onClick={this.increment}>Buy one</button>
                <br/>
                {this.state.count}
                <br/>
                <button onClick={this.decrease}>Eat one</button>
            </div>
        )
    }
}

ReactDOM.render(
    <BrowserRouter>
        <States>
            <Route exact path='/' component={Home}/>
            <Route path='/simple/states' component={States}/>
        </States>
    </BrowserRouter>,
    document.getElementById('root')
);

export default States;
