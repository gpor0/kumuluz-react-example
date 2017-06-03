import React, {Component} from 'react';
import {connect} from 'react-redux';
import {fetchEmployee} from '../actions';

class EmployeesShow extends Component {

    componentDidMount() {
        const { id } = this.props.match.params;
        this.props.fetchEmployee(id);
    }

    render() {
        const {employee} = this.props;

        if(!employee) {
            return <div>Loading...</div>;
        }

        return (
            <div>
                {employee.firstName}
            </div>
        );
    }
}

function mapStateToProps({ employees }, ownProps) {
    return { employee: employees[ownProps.match.params.id] }
}

export default connect(mapStateToProps, { fetchEmployee })(EmployeesShow);