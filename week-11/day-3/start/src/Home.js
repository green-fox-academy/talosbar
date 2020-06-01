import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link, BrowserRouter
} from "react-router-dom";
import States from "./States"

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

function HomePage() {
    return <div>
        <h1>Golden Accorn is life!</h1>
        <img src="golden-acorn-illustration.png" alt="golden accorn"/>
    </div>
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
