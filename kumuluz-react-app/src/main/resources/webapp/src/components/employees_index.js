import _ from 'lodash';
import React, {Component } from 'react';
import {connect} from 'react-redux';
import {Link} from 'react-router-dom';
import {fetchEmployees} from '../actions';

class EmployeesIndex extends Component {

    componentDidMount() {
        this.props.fetchEmployees();
    }

    renderPosts() {
        return _.map(this.props.employees, employee => {
            return (
                <li className="list-group-item" key={employee.id}>
                    {employee.firstName}
                </li>
            );
        });
    }

    render() {
        return (
            <div>
                <div className="text-xs-right">
                    <Link className="btn btn-primary" to="/employees/new">
                        Add employee
                    </Link>
                </div>
                <h3>Employees</h3>
                <ul className="list-group">
                    {this.renderPosts()}
                </ul>
            </div>
        );
    };
}

function mapStateToProps(state) {
    return {employees: state.employees};
}

export default connect(mapStateToProps, {fetchEmployees})(EmployeesIndex);