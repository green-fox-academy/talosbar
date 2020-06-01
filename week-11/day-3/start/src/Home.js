import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link, BrowserRouter
} from "react-router-dom";
import States from "./States"
import HomePage from "./HomePage";

class Home extends Component {

    render() {
        return (
            <Router>
                <main>
                    <nav>
                        <Link to="/">Home Page</Link>
                        <Link to="/simple/states/">With states</Link>
                    </nav>
                    <Switch>
                        <Route exact path="/">
                            <HomePage/>
                        </Route>
                        <Route path="/simple/states/">
                            <States/>
                        </Route>
                    </Switch>
                </main>
            </Router>
        );
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

export default Home;
