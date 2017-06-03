import React from "react";
import ReactDOM from "react-dom";
import {Provider} from "react-redux";
import {applyMiddleware, createStore} from "redux";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import promise from "redux-promise";

import reducers from "./reducers/index";
import EmployeeIndex from "./components/employees_index";
import EmployeesNew from "./components/employees_new";
import EmployeesShow from './components/employees_show';

const createStoreWithMiddleware = applyMiddleware(promise)(createStore);


ReactDOM.render(
    <Provider store={createStoreWithMiddleware(reducers)}>
        <BrowserRouter>
            <div>
                HEADER!
                <Switch>
                    <Route path="/employees/new" component={EmployeesNew}/>
                    <Route path="/employees/:id" component={EmployeesShow}/>
                    <Route path="/" component={EmployeeIndex}/>
                </Switch>
            </div>
        </BrowserRouter>
    </Provider>
    , document.querySelector('.container'));
